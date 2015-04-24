use Tarefa2

-- Dados Tabela Cidade
insert into Cidade (IDCidade, NomeCidade, UF)
   values (1, 'Sao Leopoldo', 'RS');
insert into Cidade (IDCidade, NomeCidade, UF)
   values (2, 'Porto Alegre', 'RS');


-- Dados Tabela NivelCargo
insert into NivelCargo(IDNivelCargo,DescricaoNivelCargo)
	values (1,'Junior');
insert into NivelCargo(IDNivelCargo,DescricaoNivelCargo)
	values (2,'Pleno');
insert into NivelCargo(IDNivelCargo,DescricaoNivelCargo)
	values (3,'Sênior');

-- Dados Tabela Cargo
insert into Cargo(IDCargo,DescricaoCargo,ClasseSalarial_IDClasseSalarial)
	values (1,'Presidente',);
insert into Cargo(IDCargo,DescricaoCargo,ClasseSalarial_IDClasseSalarial)
	values (2,'Gerente',);
insert into Cargo(IDCargo,DescricaoCargo,ClasseSalarial_IDClasseSalarial)
	values (3,'Atendente',);

-- Dados Tabela Classe Salarial
insert into ClasseSalarial(IDClasseSalarial,DescricaoClasseSalarial,Salario)
	values (1,'A1',3500.00);
insert into ClasseSalarial(IDClasseSalarial,DescricaoClasseSalarial,Salario)
	values (2,'A2',2500.00);
insert into ClasseSalarial(IDClasseSalarial,DescricaoClasseSalarial,Salario)
	values (3,'A3',1500.00);
insert into ClasseSalarial(IDClasseSalarial,DescricaoClasseSalarial,Salario)
	values (4,'B1',1200.00);
insert into ClasseSalarial(IDClasseSalarial,DescricaoClasseSalarial,Salario)
	values (5,'B2',1000.00);
insert into ClasseSalarial(IDClasseSalarial,DescricaoClasseSalarial,Salario)
	values (6,'B3',900.00);
insert into ClasseSalarial(IDClasseSalarial,DescricaoClasseSalarial,Salario)
	values (7,'C1',750.00);
insert into ClasseSalarial(IDClasseSalarial,DescricaoClasseSalarial,Salario)
	values (8,'C2',700.00);
insert into ClasseSalarial(IDClasseSalarial,DescricaoClasseSalarial,Salario)
	values (9,'C3',600.00);