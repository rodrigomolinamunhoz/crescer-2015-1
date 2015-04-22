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
