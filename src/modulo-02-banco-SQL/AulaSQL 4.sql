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
Select IDCidade, Nome 
From Cidade e
Where NOT EXISTS(Select IDCidade, Nome
From Associado a
Where a.IDCidade = e.IDCidade);

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

/* Exercício 5 - Liste o nome do empregado, o nome do gerente, e o departamento de cada um. */
Select e.NomeEmpregado as NomeEmpregado, de.NomeDepartamento as DepEmpregado, g.NomeEmpregado as NomeGerente, dg.NomeDepartamento as DepGerente
From Empregado e
INNER JOIN Empregado g ON e.IDGerente = g.IDEmpregado
INNER JOIN Departamento de ON e.IDDepartamento = de.IDDepartamento
INNER JOIN Departamento dg ON g.IDDepartamento = dg.IDDepartamento;
-- Teste para verificar departamento dos empregados
Select e.NomeEmpregado, d.NomeDepartamento from Empregado e, Departamento d where e.IDDepartamento = d.IDDepartamento; 