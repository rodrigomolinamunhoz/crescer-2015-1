Select a.Nome as NomeAssociado, c.Nome as NomeCidade
From Associado a
INNER JOIN Cidade c ON c.IDCidade = a.IDCidade

Select Empregado.IDEmpregado, Empregado.NomeEmpregado, Departamento.NomeDepartamento
From Empregado
Inner Join Departamento on Departamento.IDDepartamento = Empregado.IDDepartamento;

Select Empregado.IDEmpregado, Empregado.NomeEmpregado, Departamento.NomeDepartamento
From Empregado
Left Join Departamento on Departamento.IDDepartamento = Empregado.IDDepartamento;

Select Empregado.IDEmpregado, Empregado.NomeEmpregado, Departamento.NomeDepartamento
From Empregado
Right Join Departamento on Departamento.IDDepartamento = Empregado.IDDepartamento;

Select e.NomeEmpregado as NomeEmpregado,
g.NomeEmpregado as NomeGerente
From Empregado e
INNER JOIN Empregado g ON e.IDGerente = g.IDEmpregado;
Select * from Empregado where IDEmpregado in (7369,7982,7566);

Select IDCidade, Nome
From Cidade e
Where EXISTS(Select 1
From Associado a
Where a.IDCidade = e.IDCidade);

Select Nome,(Select Nome From Cidade c Where c.IDCidade = a.IDCidade)as NomeCidade
From Associado a;

Select Nome
From Associado
UNION ALL
Select NomeEmpregado
From Empregado;

Select Nome
From Associado
UNION 
Select NomeEmpregado
From Empregado;

update associado
set idcidade = 1
where idassociado = 1;

update associado
set idcidade = 32
where idassociado = 3;

/*05*/
/*Exercício 1 - Selecione o nome do empregado e nome do departamento que cada um está associado.*/
Select Empregado.NomeEmpregado, Departamento.NomeDepartamento
From Empregado
Inner Join Departamento on Departamento.IDDepartamento = Empregado.IDDepartamento;

/*Exercício 2 - Exibir o nome do associado e sua cidade, exibir também associados sem Cidade relacionada.*/
Select a.Nome, c.Nome
From Associado a 
Left Join Cidade c on a.IDCidade = c.IDCidade;

/* Exercício 3 - Lista os estados (UF) e total de cidades que não possuem associados relacionados
(dica: pode ser utilizado count + group by + exists).*/
Select Count(e.IDCidade) as TotalCidades, e.UF
From Cidade e
Where NOT EXISTS(Select e.IDCidade
From Associado a
Where a.IDCidade = e.IDCidade)
Group by UF;

/*Exercício 3 - Professor*/
Select Count(1) as TotalCidades, e.UF
From Cidade e
Where NOT EXISTS(Select 1
From Associado a
Where a.IDCidade = e.IDCidade)
Group by UF;


/* Exercício 4 - Faça uma consulta que liste o nome do associado, o nome da cidade,
 e uma coluna que indique se a cidade é da região SUL (RS, SC, PR),
se for imprimir *** (3 asteriscos), senão imprimir nulo. */
SELECT a.Nome, c.Nome,
	Case
	when c.UF = 'RS' or c.UF = 'SC' or c.UF = 'PR' then '***' 	 
End UF
FROM Associado a 
INNER JOIN Cidade c on ISNULL (a.IDCidade,0) = ISNULL (c.IDCidade,0);
--teste do UF ***
Begin Transaction
update Cidade set UF = 'SC' where IDCidade = 1; 
update Cidade set UF = 'PR' where IDCidade = 1;  
--teste do Associado NULL
insert into Associado 
      (IDAssociado, 
       Nome, 
       DataNascimento, 
       Sexo,
	   IDCidade)
  values  
      (3, 
       'Rodrigo Molina', 
       convert(datetime, '20/02/1980', 103), 
       'M',
	    106);
 
rollback 

/* Exercício 4 - Professor */
SELECT a.Nome, c.Nome,
	Case
	when c.UF in ('RS', 'SC','PR') then '***'
	else null 	 
End UF
FROM Associado a 
LEFT JOIN Cidade c on a.IDCidade = c.IDCidade;

/* Exercício 5 - Liste o nome do empregado, o nome do gerente, e o departamento de cada um. */
Select e.NomeEmpregado as NomeEmpregado, de.NomeDepartamento as DepEmpregado, g.NomeEmpregado as NomeGerente, dg.NomeDepartamento as DepGerente
From Empregado e
INNER JOIN Empregado g ON e.IDGerente = g.IDEmpregado
INNER JOIN Departamento de ON e.IDDepartamento = de.IDDepartamento
INNER JOIN Departamento dg ON g.IDDepartamento = dg.IDDepartamento;
-- Teste para verificar departamento dos empregados
Select e.NomeEmpregado, d.NomeDepartamento from Empregado e, Departamento d where e.IDDepartamento = d.IDDepartamento; 

/* Exercício - 6 Faça uma cópia da tabela Empregado e altere o salário de todos os empregados que o departamento
fique na localidade de SAO PAULO, faça um reajuste de 14,5% */
Select * into EmpregadoAux From Empregado;

BEGIN TRANSACTION

 UPDATE Empregado SET Salario = Salario + (Salario*0.145)  WHERE IDEmpregado in (SELECT e.IDEmpregado
													FROM Empregado e 
													INNER JOIN Departamento d on e.IDDepartamento = d.IDDepartamento
													WHERE d.Localizacao = 'SAO PAULO');
rollback
--teste
Select NomeEmpregado,Localizacao, Salario from Empregado, Departamento where Departamento.Localizacao = 'SAO PAULO';

/* Exercício- 7 Liste a diferença que representará o reajuste aplicado
no item anterior no somatório dos salários de todos os empregados.*/
SELECT ISNULL(SUM(e.Salario),0) as SalarioNormal, ISNULL(SUM(ea.Salario),0) as SalarioAlterado
FROM Empregado e, EmpregadoAux ea;

/* Exercício 8 - Liste o departamento que possui o empregado de maior salário.*/
SELECT MAX(e.Salario) as MaiorSalario, d.NomeDepartamento
FROM Empregado e 
INNER JOIN Departamento d on e.IDDepartamento = d.IDDepartamento
GROUP BY d.NomeDepartamento;
--Teste
SELECT e.Salario, d.NomeDepartamento
FROM Empregado e 
INNER JOIN Departamento d on e.IDDepartamento = d.IDDepartamento;

/*Exercício - 9 Faça uma consulta para exibir o nome de cada associado e sua cidade e juntamente com os
empregados (nome) e a cidade (localidade) de seu departamento, isto deve ser exibido em uma consulta. */
Select a.Nome, c.Nome 
From Associado a
INNER JOIN Cidade c on a.IDCidade = c.IDCidade
UNION ALL
Select e.NomeEmpregado, d.Localizacao 
From Empregado e
INNER JOIN Departamento d on e.IDDepartamento = d.IDDepartamento;

/* Exercício - 10 Lista as cidades que tenham associado relacionado.*/
Select c.Nome
From Associado a
INNER JOIN Cidade c on a.IDCidade = c.IDCidade;

-- Criando um view
CREATE VIEW vw_cidade_regiao AS
SELECT a.Nome as Nome_Associado, c.Nome as Nome_Cidade,
	Case
	when c.UF in ('RS', 'SC','PR') then '***'
	else null 	 
End UF
FROM Associado a 
LEFT JOIN Cidade c on a.IDCidade = c.IDCidade;

--Exibir uma view
Select * from vw_cidade_regiao;