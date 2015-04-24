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
();

