use Tarefa2

-- Dados Tabela Cidade
insert into Cidade (IDCidade, NomeCidade, UF)
   values (1, 'Sao Leopoldo', 'RS');
insert into Cidade (IDCidade, NomeCidade, UF)
   values (2, 'Porto Alegre', 'RS');
insert into Cidade (IDCidade, NomeCidade, UF)
   values (3, 'Parobé', 'RS');
insert into Cidade (IDCidade, NomeCidade, UF)
   values (4, 'Canoas', 'RS');

-- Dados Tabela NivelCargo
insert into NivelCargo(IDNivelCargo,DescricaoNivelCargo)
	values (1,'Junior');
insert into NivelCargo(IDNivelCargo,DescricaoNivelCargo)
	values (2,'Pleno');
insert into NivelCargo(IDNivelCargo,DescricaoNivelCargo)
	values (3,'Sênior');

-- Dados Tabela Cargo
insert into Cargo(IDCargo,DescricaoCargo)
	values (1,'Presidente');
insert into Cargo(IDCargo,DescricaoCargo)
	values (2,'Gerente');
insert into Cargo(IDCargo,DescricaoCargo)
	values (3,'Atendente');

-- Dados Tabela Classe Salarial
insert into ClasseSalarial(IDClasseSalarial,DescricaoClasseSalarial,Salario)
	values (1,'Presidente Sênior',3500.00);
insert into ClasseSalarial(IDClasseSalarial,DescricaoClasseSalarial,Salario)
	values (2,'Presidente Pleno',2500.00);
insert into ClasseSalarial(IDClasseSalarial,DescricaoClasseSalarial,Salario)
	values (3,'Presidente Junior',1500.00);
insert into ClasseSalarial(IDClasseSalarial,DescricaoClasseSalarial,Salario)
	values (4,'Gerente Sênior',1200.00);
insert into ClasseSalarial(IDClasseSalarial,DescricaoClasseSalarial,Salario)
	values (5,'Gerente Pleno',1000.00);
insert into ClasseSalarial(IDClasseSalarial,DescricaoClasseSalarial,Salario)
	values (6,'Gerente Junior',900.00);
insert into ClasseSalarial(IDClasseSalarial,DescricaoClasseSalarial,Salario)
	values (7,'Atendente Sênior',750.00);
insert into ClasseSalarial(IDClasseSalarial,DescricaoClasseSalarial,Salario)
	values (8,'Atendente Pleno',700.00);
insert into ClasseSalarial(IDClasseSalarial,DescricaoClasseSalarial,Salario)
	values (9,'Atendente Junior',600.00);

-- Dados Tabela Cargo Nivel_Cargo
insert into Cargo_NivelCargo(IDCargoNivelCargo, IDCargo, IDNivelCargo, IDClasseSalarial, IDFuncionario)
	values (1,1,3,1,1);
insert into Cargo_NivelCargo(IDCargoNivelCargo, IDCargo, IDNivelCargo, IDClasseSalarial, IDFuncionario)
	values (2,1,2,2,2);
insert into Cargo_NivelCargo(IDCargoNivelCargo, IDCargo, IDNivelCargo, IDClasseSalarial, IDFuncionario)
	values (3,2,3,4,3);
insert into Cargo_NivelCargo(IDCargoNivelCargo, IDCargo, IDNivelCargo, IDClasseSalarial, IDFuncionario)
	values (4,3,1,9,4);
Select * from Cargo_NivelCargo

-- Dados Tabela Funcionario
insert into Funcionario(IDFuncionario, NomeFuncionario, DataAdmissao, Telefone, Email, Sexo, DataNacimento)
	values(1,'Rodrigo Molina Munhoz',convert(datetime, '25/04/2015', 103),'(51)9910-9610','rodrigomunhoz1995@gmail.com','M',convert(datetime, '01/08/1995', 103));
insert into Funcionario(IDFuncionario, NomeFuncionario, DataAdmissao, Telefone, Email, Sexo, DataNacimento)
	values(2,'Paula Tomasi',convert(datetime, '25/04/2015', 103),'(51)9617-9190','paulatomasi@gmail.com','F',convert(datetime, '29/04/1997', 103));
insert into Funcionario(IDFuncionario, NomeFuncionario, DataAdmissao, Telefone, Email, Sexo, DataNacimento)
	values(3,'Pablo Diehl',convert(datetime, '25/04/2015', 103),'(51)8917-7899','pablodiehl@hotmail.com','M',convert(datetime, '17/01/1994', 103));
insert into Funcionario(IDFuncionario, NomeFuncionario, DataAdmissao, Telefone, Email, Sexo, DataNacimento)
	values(4,'Vitor de Castro',convert(datetime, '26/04/2015', 103),'(54)8910-4578','vitorcastro@hotmail.com','M',convert(datetime, '04/09/1996', 103));


--Dados Tabela Endereco
insert into Endereco(IDEndereco, Endereco, Numero, Complemento, Bairro, CEP, IDFuncionario, IDCidade)
	values(1, 'Rua das Flores', 280, 'Casa', 'Dom Vicente', '95765-000', 1, 1);
insert into Endereco(IDEndereco, Endereco, Numero, Complemento, Bairro, CEP, IDFuncionario, IDCidade)
	values(2, 'Rua Jaguarão', 120, 'Apartamento', 'Canudos', '95345-000', 2, 2);
insert into Endereco(IDEndereco, Endereco, Numero, Complemento, Bairro, CEP, IDFuncionario, IDCidade)
	values(3, 'Rua Inconfidentes', 20, 'Casa', 'Pedro Gomes', '98365-000', 3, 4);
insert into Endereco(IDEndereco, Endereco, Numero, Complemento, Bairro, CEP, IDFuncionario, IDCidade)
	values(4, 'Rua Paraguai', 123, 'Apartamento', 'Ricardo Carvalho', '95300-000', 4, 3);
Select * from Endereco;

-- Teste de casos

--Endereco e sua Cidade
Select e.Endereco, e.Numero, c.NomeCidade
From Endereco e
INNER JOIN Cidade c on c.IDCidade = e.IDCidade;

-- Funcionario com seu Endereco e sua Cidade
Select f.NomeFuncionario, e.Endereco, e.Numero, e.Bairro, c.NomeCidade
From Funcionario f
INNER JOIN Endereco e on e.IDFuncionario = f.IDFuncionario
INNER JOIN Cidade c on c.IDCidade = e.IDCidade;


-- Funcionario com seu cargo, nivel do cargo e salario
Select f.NomeFuncionario, c.DescricaoCargo, nc.DescricaoNivelCargo, cs.Salario
From Funcionario f
INNER JOIN Cargo_NivelCargo cnc on cnc.IDFuncionario = f.IDFuncionario
INNER JOIN Cargo c on c.IDCargo = cnc.IDCargo
INNER JOIN NivelCargo nc on nc.IDNivelCargo = cnc.IDNivelCargo
INNER JOIN ClasseSalarial cs on cs.IDClasseSalarial = cnc.IDClasseSalarial;

--Conte numero funcionario para cargos em geral
Select COUNT(1) AS QuantidadePresidentes, c.DescricaoCargo
From Cargo c
INNER JOIN Cargo_NivelCargo nc on nc.IDCargo = c.IDCargo
group by  c.DescricaoCargo;


