/* 1 Identifique e liste quantos valores diferentes est�o definidos
para a coluna Situacao da tabela Produto (somente os distintos valores). */

SELECT COUNT(DISTINCT Situacao) AS NumeroDeSituacoes FROM Produto;

/*2 Liste todos os clientes que tenham o LTDA no nome ou razao social.*/
select Nome, RazaoSocial from Cliente
where RazaoSocial like '%Ltda%' or Nome like '%Ltda%';

/* 3 Crie (insira) um novo registro na tabela de Produto, com as seguintes informa��es:
Nome: Galocha Maragato
Pre�o de custo: 35.67
Pre�o de venda: 77.95
Situa��o: A */

begin transaction
insert into Produto(IDProduto,Nome,DataCadastro,PrecoCusto,PrecoVenda,Situacao)
VALUES
('Galocha Maragato',GETDATE(),35.67,77.95,'A');
--teste
select * from Produto where Nome = 'Galocha Maragato'; 
roolback

/*4) Identifique e liste os produtos que n�o tiveram nenhum pedido,
considere os relacionamentos no modelo de dados, pois n�o h� relacionamento direto entre Produto e 
Pedido (ser� preciso relacionar PedidoItem). Obs.: o produto criado anteriormente dever� ser listado.*/

Select p.IDProduto, p.Nome
from Produto p where not exists(select 1
								from PedidoItem
								where p.IDProduto = PedidoItem.IDProduto);



/*5) Identifique qual o estado (coluna UF da tabela Cidade) possu� o maior n�mero de clientes (tabela Cliente),
liste tamb�m qual o Estado possu� o menor n�mero de clientes.
Dica: pode (n�o � obrigat�rio) ser utilizado subquery, e tamb�m UNION.*/

Select cli.IDCliente from Cliente cli where  EXISTS (select count(1), c.UF
										  from Cidade c
										  where cli.IDCidade = c.IDCidade
										  group by c.UF)
