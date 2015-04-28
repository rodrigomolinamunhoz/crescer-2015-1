/* 1 Identifique e liste quantos valores diferentes estão definidos
para a coluna Situacao da tabela Produto (somente os distintos valores). */

SELECT COUNT(DISTINCT Situacao) AS NumeroDeSituacoes FROM Produto;

/*2 Liste todos os clientes que tenham o LTDA no nome ou razao social.*/
select Nome, RazaoSocial from Cliente
where RazaoSocial like '%Ltda%' or Nome like '%Ltda%';

/* 3 Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:
Nome: Galocha Maragato
Preço de custo: 35.67
Preço de venda: 77.95
Situação: A */

begin transaction
insert into Produto(IDProduto,Nome,DataCadastro,PrecoCusto,PrecoVenda,Situacao)
VALUES
('Galocha Maragato',GETDATE(),35.67,77.95,'A');
--teste
select * from Produto where Nome = 'Galocha Maragato'; 
roolback

/*4) Identifique e liste os produtos que não tiveram nenhum pedido,
considere os relacionamentos no modelo de dados, pois não há relacionamento direto entre Produto e 
Pedido (será preciso relacionar PedidoItem). Obs.: o produto criado anteriormente deverá ser listado.*/

Select p.IDProduto, p.Nome
from Produto p where not exists(select 1
								from PedidoItem
								where p.IDProduto = PedidoItem.IDProduto);



/*5) Identifique qual o estado (coluna UF da tabela Cidade) possuí o maior número de clientes (tabela Cliente),
liste também qual o Estado possuí o menor número de clientes.
Dica: pode (não é obrigatório) ser utilizado subquery, e também UNION.*/

Select cli.IDCliente from Cliente cli where  EXISTS (select count(1), c.UF
										  from Cidade c
										  where cli.IDCidade = c.IDCidade
										  group by c.UF)
