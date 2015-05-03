use [Crescer15-1]
/* 1 Identifique e liste quantos valores diferentes estão definidos
para a coluna Situacao da tabela Produto (somente os distintos valores). */

SELECT COUNT(DISTINCT Situacao) AS NumeroDeSituacoes FROM Produto;

/*2 Liste todos os clientes que tenham o LTDA no nome ou razao social.*/
select Nome, RazaoSocial from Cliente
where RazaoSocial like '%Ltda%' or Nome like '%Ltda%';

/*2  - Professor */
select Nome, RazaoSocial from Cliente
where upper(Nome) like '%LTDA%' or upper(RazaoSocial) like '%LTDA%';

/* 3 Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:
Nome: Galocha Maragato
Preço de custo: 35.67
Preço de venda: 77.95
Situação: A */

begin transaction
insert into Produto(Nome,DataCadastro,PrecoCusto,PrecoVenda,Situacao)
VALUES
('Galocha Maragato',GETDATE(),35.67,77.95,'A');
--teste
select * from Produto where Nome = 'Galocha Maragato'; 
commit
roolback

/*4) Identifique e liste os produtos que não tiveram nenhum pedido,
considere os relacionamentos no modelo de dados, pois não há relacionamento direto entre Produto e 
Pedido (será preciso relacionar PedidoItem). Obs.: o produto criado anteriormente deverá ser listado.*/

-- criando índice
CREATE INDEX IX_PEDIDOTEM_PRODUTO ON PedidoItem (IDProduto);
-- apagando índice
drop index PedidoItem.IX_PEDIDOTEM_PRODUTO;

Select p.IDProduto, p.Nome
from Produto p where not exists(select 1
								from PedidoItem
								where p.IDProduto = PedidoItem.IDProduto);



/*5) Identifique qual o estado (coluna UF da tabela Cidade) possuí o maior número de clientes (tabela Cliente),
liste também qual o Estado possuí o menor número de clientes.
Dica: pode (não é obrigatório) ser utilizado subquery, e também UNION.*/

select maior.numero_clientes, maior.UF from
(SELECT top 1 count(c.UF) as [numero_clientes], c.UF FROM Cidade c 
INNER JOIN Cliente cli ON c.IDCidade = cli.IDCidade
GROUP BY c.UF order by count(c.UF) desc) as maior
union
select subMenor.numero_clientes as MenorNumeroClientes, subMenor.UF from 
(SELECT top 1 count(c.UF) as [numero_clientes], c.UF as [UF] FROM Cidade c 
INNER JOIN Cliente cl ON c.IDCidade = cl.IDCidade
GROUP BY C.UF order by count(c.UF)) as subMenor

/*5 - Professor */
create view vwEstados as
select c.UF, count(1) as TotalCidades
From Cidade c
INNER JOIN Cliente cli on cli.IDCidade = c.IDCidade
Group by c.UF;

select * from vwEstados
where TotalCidades = (select MIN(TotalCidades) from vwEstados)
or TotalCidades = (select MAX(TotalCidades) from vwEstados);


/* 6) Liste o total de cidades (distintas) que possuem clientes que realizaram algum pedido.
Dica: será preciso relacionar Cidade com Cliente, e Cliente com Pedido.*/

Select COUNT(Distinct c.Nome) as CidadesDistintas
From Cidade c
where c.IDCidade in (select ci.IDCidade
					from Cidade ci
					INNER JOIN Cliente cli ON cli.IDCidade = ci.IDCidade
					INNER JOIN Pedido p ON p.IDCliente = cli.IDCliente);

/*7) Dentro da atual estrutura, cada produto é composto por 1 ou vários materiais (tabela ProdutoMaterial).
Identifique se existe algum produto sem material relacionado.
Obs.: o produto criado anteriormente deverá ser listado.*/

select p.nome
from ProdutoMaterial pm
right join Produto p on p.IDProduto = pm.IDProduto
left join Material m on M.IDMaterial = pm.IDMaterial
where m.Descricao is null
order by m.Descricao;

/* Exercício 7 - Professor*/
Select pro.IDProduto, pro.Nome
From   Produto pro
Where  NOT EXISTS (Select 1
                   From   ProdutoMaterial pm
			       where  pm.IDProduto = pro.IDProduto );


/* 8) Liste os produtos, com seu preço de custo, e relacione com seus os materiais (ProdutoMaterial),
e liste também o somatório do PrecoCusto de todos seus materiais.*/

Select p.IDProduto, p.Nome, p.PrecoCusto as PrecoCusto,
SUM(m.PrecoCusto * ISNULL(pm.Quantidade, 1)) as CustoMaterias
from Produto p
INNER JOIN ProdutoMaterial pm on p.IDProduto = pm.IDProduto
INNER JOIN Material m on M.IDMaterial = pm.IDMaterial
group by p.Nome, p.PrecoCusto, p.IDProduto;

/*Exercício 8 - Professor*/
select pro.IDProduto,
       pro.Nome,
	   pro.PrecoCusto,
       SUM (ma.PrecoCusto * ISNULL(pm.Quantidade, 1) ) as Preco_Custo_Material
from Produto pro
	 inner join produtoMaterial pm  on pm.idproduto = pro.idproduto
	 inner join Material ma         on ma.IDMaterial = pm.IDMaterial
group by pro.IDProduto,
         pro.Nome,
	     pro.PrecoCusto;

/* 9) Após identificar o preço de custo dos produtos e seus materiais será preciso acertar os produtos que
estão com o valor de custo inferior ao custo dos materiais. Pra isso faça uma alteração (update)
na tabela de Produtos, definindo o PrecoCusto, para que fique igual ao custo dos seus materiais. */

begin transaction

update Produto set PrecoCusto = (select consulta.PrecoMaterias from 
(Select p.IDProduto, p.PrecoCusto as PrecoCusto,
SUM(m.PrecoCusto) as PrecoMaterias from ProdutoMaterial pm
INNER JOIN Produto p on p.IDProduto = pm.IDProduto
INNER JOIN Material m on M.IDMaterial = pm.IDMaterial
GROUP BY p.Nome, p.PrecoCusto, p.IDProduto, p.PrecoCusto HAVING p.PrecoCusto < sum(m.PrecoCusto)) as consulta)
where IDProduto = (select consulta.IDProduto from
(Select p.IDProduto, p.PrecoCusto as PrecoCusto,
SUM(m.PrecoCusto) as PrecoMaterias from ProdutoMaterial pm
INNER JOIN Produto p on p.IDProduto = pm.IDProduto
INNER JOIN Material m on M.IDMaterial = pm.IDMaterial
GROUP BY p.Nome, p.PrecoCusto,p.IDProduto, p.PrecoCusto HAVING p.PrecoCusto < sum(m.PrecoCusto)) as consulta)

rollback

-- CRIANDO UMA VIEW COM TODOS OS PRODUTOS QUE TENHAM O CUSTO DO PRODUTO E O CUSTO DOS SEUS MATERIAIS
-- E UTILIZANDO UMA FUNÇÃO "ROUND" SOBRE A COLUNA QUE EXIBE O TOTAL DE MATERIAIS, COM ISSO TORNAMOS 
-- OS CAMPOS "TotalMateriais" e "PrecoCusto" DO MESMO FORMATO (2 CASAS DECIMAIS)

/* Exercício 9 - Professor*/
Create view vwCustoProduto as
 Select pr.IDProduto, 
        pr.Nome, 
        pr.PrecoCusto, 
        ROUND( SUM( ISNULL(pm.Quantidade,1) * ma.PrecoCusto ),2) as TotalMateriais
 From   Produto pr
   inner join ProdutoMaterial pm on pm.IDProduto  = pr.IDProduto
   inner join Material        ma on ma.IDMaterial = pm.IDMaterial
 Group by pr.IDProduto, 
          pr.Nome, 
          pr.PrecoCusto 
go

BEGIN TRANSACTION
GO

 Update Produto
 Set    PrecoCusto = vw.TotalMateriais
 From   vwCustoProduto vw
 Where  vw.IDProduto = Produto.IDProduto
 and    vw.PrecoCusto < vw.TotalMateriais
go

--ou
Update Produto
Set    PrecoCusto = (select TotalMAteriais
                     From   vwCustoProduto vw
                     Where  vw.IDProduto = Produto.IDProduto
                     and    vw.PrecoCusto < vw.TotalMateriais)
Where  IDProduto in (select IDProduto 
                     from 	vwCustoProduto vw
					 where  vw.PrecoCusto < vw.TotalMateriais)


/*10) Liste os clientes que tenham o mesmo nome (Tabela Cliente, registros com o nome (apenas) duplicado). */

select Nome, COUNT(1)
from Cliente
group by Nome
HAVING COUNT(1) > 1;

/* 11) Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome. */

select top 1 SUBSTRING(Nome, 0, CHARINDEX(' ', Nome)) AS Nome, COUNT(1) as QuantidadeRepetida
from Cliente
group by SUBSTRING(Nome, 0, CHARINDEX(' ', Nome))
ORDER BY QuantidadeRepetida DESC;

/* 12) Liste qual o produto é mais vendido (considere a informação da quantidade).*/

select top 1 with ties
			 pi.IDProduto,
			 p.Nome,
			 SUM(pi.Quantidade) AS QuantidadeVendida
from PedidoItem pi
	INNER JOIN Produto p ON pi.IDProduto = p.IDProduto
GROUP BY p.Nome, pi.IDProduto
ORDER BY QuantidadeVendida DESC;

/*Exercício 12 - Professor*/
Select top 1 with ties
       item.IDProduto, 
       pro.Nome,
       sum(item.Quantidade) TotalItens
From   PedidoItem item
  inner join Produto pro on item.IDProduto = pro.IDProduto
Group  by item.IDProduto,
          pro.Nome
Order  by TotalItens desc