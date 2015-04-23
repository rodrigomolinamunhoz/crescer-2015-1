Select Nome as Nome_Cidade,
UF as Estado
From Cidade;


-- Table "Emp" ... --
create table Empregado (
 IDEmpregado    int not null
,NomeEmpregado  varchar(30) not null
,Cargo          varchar(15) not null
,IDGerente      int null
,DataAdmissao   datetime not null
,Salario        decimal(7,2) not null
,Comissao       decimal(7,2)
,IDDepartamento int
);

insert into Empregado values (7369 ,'SMITH', 'Atendente', '7902', convert(datetime, '1980/12/17', 111), 800, null, 20);
insert into Empregado values (7499 ,'ALLEN', 'Vendedor', '7698', convert(datetime, '1981/02/20', 111), 1600, 300, 30);
insert into Empregado values (7521 ,'WARD', 'Vendedor', '7698', convert(datetime, '1981/02/22', 111), 1250, 500, 30);
insert into Empregado values (7566 ,'JONES', 'Gerente', '7839', convert(datetime, '1981/04/02', 111), 2975, null, 20);
insert into Empregado values (7654 ,'MARTIN', 'Vendedor', '7698', convert(datetime, '1981/09/28', 111), 1250, 1400, 30);
insert into Empregado values (7698 ,'BLAKE', 'Gerente', '7839', convert(datetime, '1981/05/01', 111), 2850, null, 30);
insert into Empregado values (7782 ,'CLARK', 'Gerente', '7839', convert(datetime, '1981/06/09', 111), 2450, null, 10);
insert into Empregado values (7788 ,'SCOTT', 'Analista', '7566', convert(datetime, '1982/12/09', 111), 3000, null, 20);
insert into Empregado values (7839 ,'KING', 'Presidente', null, convert(datetime, '1981/11/17', 111), 5000, null, null);
insert into Empregado values (7844 ,'TURNER', 'Vendedor', '7698', convert(datetime, '1981/09/08', 111), 1500, 0, 30);
insert into Empregado values (7876 ,'ADAMS', 'Atendente', '7788', convert(datetime, '1983/01/12', 111), 1100, null, 20);
insert into Empregado values (7900 ,'JAMES', 'Atendente', '7698', convert(datetime, '1981/12/03', 111), 950, null, 30);
insert into Empregado values (7902 ,'FORD', 'Analista', '7566', convert(datetime, '1981/12/03', 111), 3000, null, 20);
insert into Empregado values (7934 ,'MILLER', 'Atendente', '7782', convert(datetime, '1982/01/23', 111), 1300, null, 10);
insert into Empregado values (7940 ,'ANDREW', 'Atendente', '7782', convert(datetime, '1988/01/20', 111), 1150, null, null);

create table Departamento (
 IDDepartamento   int not null
,NomeDepartamento varchar(30)
,Localizacao      varchar(25)
);

insert into Departamento values (10,'Contabilidade', 'SAO PAULO');
insert into Departamento values (20,'Pesquisa', 'SAO LEOPOLDO');
insert into Departamento values (30,'Vendas', 'SAO PAULO');
insert into Departamento values (40,'Operações', 'RECIFE');
insert into Departamento values (1, 'Presidência', 'RIBEIRAO PRETO');
insert into Departamento values (60, 'Tecnologia', 'PORTO ALEGRE');

---------
ALTER TABLE Departamento ADD  CONSTRAINT PK_departamento 
  PRIMARY KEY  
  (IDDepartamento);

ALTER TABLE Empregado ADD  CONSTRAINT PK_Empregado
  PRIMARY KEY  
  (IDEmpregado);

ALTER TABLE Empregado ADD CONSTRAINT FK_Empregado_Departamento
  FOREIGN KEY (IDDepartamento) REFERENCES Departamento (IDDepartamento);

CREATE INDEX IX_Empregado_Departamento ON Empregado (IDDepartamento);


update associado
set idcidade = 1
where idassociado = 1;

update associado
set idcidade = 32
where idassociado = 3;

Select NomeEmpregado as Nome,
salario as SalarioMensal,
(salario*12) as SalarioAnual
From Empregado;

Select IDCidade, Nome, UF
From Cidade
Order by Nome ASC;

Select IDCidade, Nome, UF
From Cidade
Order by UF DESC, Nome ASC;

Select IDCidade, Nome, UF
From Cidade
Where UF in ('RS', 'SC', 'PR');

Select IDEmpregado, NomeEmpregado
From Empregado
Where salario >= 1000
and salario <= 1500;

Select IDEmpregado, NomeEmpregado
From Empregado
Where salario between 1000 and 1500;

/*Exercício 1 */
Select IDEmpregado, NomeEmpregado from Empregado order by DataAdmissao ASC;

/*Exercício 2 */
Select IDEmpregado, NomeEmpregado
from Empregado
Where Cargo = 'Atendente'
and Salario < 1850000;

/*Exercício 3 */
Select IDCidade from Cidade where Nome = 'Uberlândia';

/*Exercício 4 */
Select IDCidade, Nome from Cidade where UF = 'RS';

Select COUNT(IDEmpregado) From Empregado; 

Select COUNT(*) From Empregado;

Select COUNT(1) From Empregado;

Select COUNT(Comissao) From Empregado;

Select COUNT(Comissao) Comissão, COUNT(IDEmpregado) ID_Empregado, COUNT(1) Conta_PK From Empregado;

Select COUNT(IDDepartamento) From Empregado;

Select MIN(salario) as MenorSalario,
MAX(salario) as MaiorSalario
From Empregado;

Select COUNT(1) as TotalEmpregados,
COUNT(Distinct Cargo) as TotalCargos
From Empregado;

SELECT DISTINCT CARGO FROM EMPREGADO;

SELECT count (DISTINCT CARGO) as total_cargo from Empregado;

SELECT SUM(SALARIO) AS SOMA,
	   MAX(SALARIO) AS MAXIMO,
	   MIN(SALARIO) AS MINIMO
FROM Empregado;

SELECT IDDEPARTAMENTO,
	   SUM(SALARIO) AS SOMA,
	   MAX(SALARIO) AS MAXIMO,
	   MIN(SALARIO) AS MINIMO
FROM Empregado
GROUP BY IDDepartamento;

Select distinct Cargo,
COUNT(1) as Total
From Empregado
Group By Cargo;

Select Cargo,
COUNT(1) as Total
From Empregado
Group By Cargo;

Select Cargo,
COUNT(1) as Total
From Empregado
Group By Cargo
Having COUNT(1) > 1;

Select Cargo,
COUNT(1) as Total
From Empregado
Where Cargo like 'A%'
Group By Cargo
Having COUNT(1) > 1;

Select UPPER(Nome) as NomeCidade_Upper,
LOWER(Nome) as NomeCidade_Lower,
UF
From CIDADE
Order by NomeCidade_Upper;

Select SUBSTRING(Nome, 1, 3) as NomeCidade,
UF
From CIDADE
Order by NomeCidade;

Select NomeEmpregado,
(Salario + Comissao) as Total_sal_a,
(Salario + (ISNULL(Comissao,0)) ) as Total_sal_b,
Comissao
From Empregado;

Select NomeEmpregado,
DataAdmissao,
DateDiff(Month, DataAdmissao, getdate()) MesesTrabalho
From Empregado;

select UPPER('andre nunes');

Select Nome,
REPLACE(REPLACE(Nome, 'ção', 'cion'), 'são', 'san') NomeCidade,
UF
From Cidade;


select IDAssociado, Nome,
Case when sexo = 'F' then 'Feminino'
	 when sexo = 'M' then 'Masculino'
	 else 'sei lá'
  End Genero
from associado;

/* 04 */
/* Exercício 1 */
Select 
substring(Nome, 1, charindex(' ', Nome) )
from Associado;

/* Exercício 2 */
Select Nome, DATEDIFF(Year, DataNascimento, getdate()) from Associado;

/* Exercício 3 - Faça uma consulta que liste os empregados admitidos entre 01/05/1980 e 20/01/1982.
Exibir também o total de meses de trabalho até a data de 31/12/2000. */
Select IDEmpregado, NomeEmpregado, DATEDIFF(MONTH, DataAdmissao, '31/12/2000') as MesesTrabalhados
From Empregado
Where DataAdmissao >= '01/05/1980' and DataAdmissao <= '20/01/1982';

/* Exercício 3 - Professor */
Select IDEmpregado, NomeEmpregado, DataAdmissao, DATEDIFF(MONTH, DataAdmissao, '31/12/2000') as MesesTrabalhados
From Empregado
Where DataAdmissao between Convert(datetime, '01/05/1980', 103) and Convert(datetime, '20/01/1982', 103);


/* Exercício 4 */
Select top 1 Cargo, count(1) as Total
      from Empregado
	  group by Cargo
      order by Total DESC;

/* Exercício 4 - Professor */
Select top 1 with ties
    Cargo, count(1) as Total
    from Empregado
    group by Cargo
    order by Total DESC;


/* Exercício 5 */
Select top 1 Nome, LEN (Nome) as Tamanho
from Associado
order by Tamanho DESC;

/* Exercício 6
Faça uma consulta que retorne o nome do associado e a data de quando cada completará (ou completou) 50 anos,
liste também o dia da semana. */
SET LANGUAGE 'Brazilian'
SELECT Nome, DATENAME(DW,DATEADD(YEAR,50, DataNascimento)),DATEADD(YEAR,50, DataNascimento) AS DiaDaSemana FROM Associado;

/* Exercício 7 - Liste a quantidade de cidades agrupando por UF. */
Select UF, COUNT(1) as QuantidadeCidades
From Cidade
Group By UF;

/* Exercício 8 - Liste as cidades que possuem o mesmo nome e UF. */
Select Nome, UF, COUNT(1) as QuantidadeCidades
From Cidade
Group By Nome, UF
HAVING Count(1) > 1;

/* Exercício 9 - Identifique qual deve ser o próximo ID para a criação de um novo 
registro na tabela Associado (maior + 1). */
SELECT MAX (IDAssociado + 1) FROM Associado;

/* Exercício 9 - Professor */
SELECT ISNULL (MAX(IDAssociado),0) + 1 FROM Associado;

/* Exercício 10 - Limpe a tabela CidadeAux, e insira somente as cidades com nomes e
UF’s distintos, considere somente o menor código ID das cidades duplicadas. */
Truncate Table CidadeAux;
insert into CidadeAux (IDCidade, Nome, UF) select MIN(IDCidade), Nome, UF from Cidade group by Nome,UF;

/* Exercício 11 - Altere todas cidades duplicadas (nome e uf iguais),
acrescente no ínicio do nome um asterisco (*).*/
Select Nome, UF, COUNT(1) as QuantidadeCidades
From Cidade
Group By Nome, UF
HAVING Count(1) > 1;


BEGIN TRANSACTION

 UPDATE Cidade SET Nome = Nome +' *' WHERE Nome in (SELECT Nome
 FROM Cidade
 Group By Nome
 HAVING Count(1) > 1);

rollback
Select * from Cidade;

/*Exercício - 12 Faça uma consulta que liste o nome do Associado
e a descrição da coluna Sexo, informando: Masculino ou Feminino. */
select IDAssociado, Nome,
Case when sexo = 'F' then 'Feminino'
     when sexo = 'M' then 'Masculino'
End Sexo
from associado;

/*Exercício - 13 Faça uma consulta que mostre o nome do empregado, o Salario e percentual a ser descontado do Imposto de Renda,
considerando a tabela abaixo:
Até R$ 1.164,00 = 0%De R$ 1.164,00 a R$ 2.326,00 = 15%
Acima de R$ 2.326,00 = 27,5%. */

select NomeEmpregado, Salario,
Case
	 when Salario between 0 and 1600.00 then '0%' 
	 when Salario between 1164.00 and 2326.00 then '15%'
	 when Salario > 2326.00 then '27,5%'
End Porcentagem
from Empregado;

/* Exercício - 14 Elimine as cidades duplicadas (mantendo 1 registro para cada).*/
BEGIN TRANSACTION

DELETE FROM Cidade WHERE IDCidade in (Select MAX(IDCidade)
				From Cidade
				Group By Nome
				HAVING Count(1) > 1);

rollback

/*Exercício - 15 Adicione uma regra que impeça exista mais de uma cidade com o mesmo nome em um estado.*/
ALTER TABLE Cidade ADD CONSTRAINT UQNomeCidade UNIQUE (Nome);
/* Teste */
Insert into Cidade (IDCidade, Nome, UF)
   values (343, 'Belo Horizonte', 'MG');  





