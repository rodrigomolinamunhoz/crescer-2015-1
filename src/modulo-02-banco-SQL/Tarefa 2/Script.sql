-- Gerado por Oracle SQL Developer Data Modeler 4.0.3.853
--   em:        2015-04-24 22:47:04 BRT
--   site:      SQL Server 2008
--   tipo:      SQL Server 2008




CREATE
  TABLE Cargo
  (
    IDCargo        INTEGER NOT NULL ,
    DescricaoCargo VARCHAR (100) NOT NULL ,
    CONSTRAINT Cargo_PK PRIMARY KEY CLUSTERED (IDCargo)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO
CREATE UNIQUE NONCLUSTERED INDEX
Cargo__IDX ON Cargo
(
  IDCargo
)
ON "default"
GO

CREATE
  TABLE Cargo_NivelCargo
  (
    IDCargoNivelCargo INTEGER NOT NULL ,
    IDCargo           INTEGER NOT NULL ,
    IDNivelCargo      INTEGER NOT NULL ,
    IDClasseSalarial  INTEGER NOT NULL ,
    IDFuncionario     INTEGER NOT NULL ,
    CONSTRAINT Cargo_NivelCargo_PK PRIMARY KEY CLUSTERED (IDCargoNivelCargo)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE Cidade
  (
    IDCidade   INTEGER NOT NULL ,
    NomeCidade VARCHAR (100) NOT NULL ,
    UF         VARCHAR (2) NOT NULL ,
    CONSTRAINT Cidade_PK PRIMARY KEY CLUSTERED (IDCidade)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE ClasseSalarial
  (
    IDClasseSalarial        INTEGER NOT NULL ,
    DescricaoClasseSalarial VARCHAR (100) NOT NULL ,
    Salario                 DECIMAL (7,2) NOT NULL ,
    CONSTRAINT ClasseSalarial_PK PRIMARY KEY CLUSTERED (IDClasseSalarial)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE Endereco
  (
    IDEndereco    INTEGER NOT NULL ,
    Endereco      VARCHAR (100) NOT NULL ,
    Numero        INTEGER NOT NULL ,
    Complemento   VARCHAR (100) ,
    Bairro        VARCHAR (100) NOT NULL ,
    CEP           VARCHAR (20) NOT NULL ,
    IDFuncionario INTEGER NOT NULL ,
    IDCidade      INTEGER NOT NULL ,
    CONSTRAINT Endereco_PK PRIMARY KEY CLUSTERED (IDEndereco)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO
CREATE UNIQUE NONCLUSTERED INDEX
Endereco__IDX ON Endereco
(
  IDFuncionario
)
ON "default"
GO

CREATE
  TABLE Funcionario
  (
    IDFuncionario   INTEGER NOT NULL ,
    NomeFuncionario VARCHAR (100) NOT NULL ,
    DataAdmissao    DATE NOT NULL ,
    DataDemissao    DATE ,
    Telefone        VARCHAR (30) NOT NULL ,
    Email           VARCHAR (100) NOT NULL ,
    Sexo            CHAR (1) NOT NULL ,
    DataNacimento   DATE NOT NULL ,
    CONSTRAINT Funcionario_PK PRIMARY KEY CLUSTERED (IDFuncionario)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

CREATE
  TABLE LogHistorico
  (
    IDHistorico   INTEGER NOT NULL ,
    DataCriacao   DATE NOT NULL ,
    DataAlteracao DATE NOT NULL ,
    IDFuncionario INTEGER NOT NULL ,
    CONSTRAINT LogHistorico_PK PRIMARY KEY CLUSTERED (IDHistorico)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO
CREATE UNIQUE NONCLUSTERED INDEX
LogHistorico__IDX ON LogHistorico
(
  IDFuncionario
)
ON "default"
GO

CREATE
  TABLE NivelCargo
  (
    IDNivelCargo        INTEGER NOT NULL ,
    DescricaoNivelCargo VARCHAR (100) NOT NULL ,
    CONSTRAINT NivelCargo_PK PRIMARY KEY CLUSTERED (IDNivelCargo)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
  )
  ON "default"
GO

ALTER TABLE Cargo_NivelCargo
ADD CONSTRAINT Cargo_NivelCargo_Cargo_FK FOREIGN KEY
(
IDCargo
)
REFERENCES Cargo
(
IDCargo
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE Cargo_NivelCargo
ADD CONSTRAINT Cargo_NivelCargo_ClasseSalarial_FK FOREIGN KEY
(
IDClasseSalarial
)
REFERENCES ClasseSalarial
(
IDClasseSalarial
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE Cargo_NivelCargo
ADD CONSTRAINT Cargo_NivelCargo_Funcionario_FK FOREIGN KEY
(
IDFuncionario
)
REFERENCES Funcionario
(
IDFuncionario
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE Cargo_NivelCargo
ADD CONSTRAINT Cargo_NivelCargo_NivelCargo_FK FOREIGN KEY
(
IDNivelCargo
)
REFERENCES NivelCargo
(
IDNivelCargo
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE Endereco
ADD CONSTRAINT Endereco_Cidade_FK FOREIGN KEY
(
IDCidade
)
REFERENCES Cidade
(
IDCidade
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE Endereco
ADD CONSTRAINT Endereco_Funcionario_FK FOREIGN KEY
(
IDFuncionario
)
REFERENCES Funcionario
(
IDFuncionario
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE LogHistorico
ADD CONSTRAINT LogHistorico_Funcionario_FK FOREIGN KEY
(
IDFuncionario
)
REFERENCES Funcionario
(
IDFuncionario
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO


-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             8
-- CREATE INDEX                             3
-- ALTER TABLE                              7
-- CREATE VIEW                              0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE DATABASE                          0
-- CREATE DEFAULT                           0
-- CREATE INDEX ON VIEW                     0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE ROLE                              0
-- CREATE RULE                              0
-- CREATE PARTITION FUNCTION                0
-- CREATE PARTITION SCHEME                  0
-- 
-- DROP DATABASE                            0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
