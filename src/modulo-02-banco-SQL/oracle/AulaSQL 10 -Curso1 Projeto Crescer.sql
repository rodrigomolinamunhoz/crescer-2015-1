-- Criando a Tabela Pessoa
CREATE TABLE Pessoa
  (
    IDPessoa        INTEGER NOT NULL,
    Nome            VARCHAR2(50) NOT NULL,
    Data_Nascimento DATE,
    Endereco        VARCHAR2(35),
    Cidade          VARCHAR2(50),
    UF              VARCHAR2(2),
    CONSTRAINT PK_Pessoa PRIMARY KEY (IDPessoa)
  );
CREATE sequence sqPessoa;

-- Inserindo dados na tabela pessoa
INSERT
INTO Pessoa
  (
    IDPessoa,
    Nome,
    Data_Nascimento,
    Endereco,
    Cidade,
    UF
  )
  VALUES
  (
    sqPessoa.nextval,
    'Maria Cavalcante',
    to_date('01/02/1990', 'dd/mm/yyyy'),
    'Rua A, 230',
    'Taquara',
    'RS'
  ) ;
INSERT
INTO Pessoa
  (
    IDPessoa,
    Nome,
    Data_Nascimento,
    Endereco,
    Cidade,
    UF
  )
  VALUES
  (
    sqPessoa.nextval,
    'Pedro de Souza',
    to_date('21/03/1985', 'dd/mm/yyyy'),
    'Av. Ipiranga, 4200',
    'Porto Alegre',
    'RS'
  ) ;
INSERT
INTO Pessoa
  (
    IDPessoa,
    Nome,
    Data_Nascimento,
    Endereco,
    Cidade,
    UF
  )
  VALUES
  (
    sqPessoa.nextval,
    'Gustavo Kuerten',
    to_date('10/09/1976', 'dd/mm/yyyy'),
    'Praia',
    'Florianópolis',
    'SC'
  ) ;
COMMIT;

Select * from Pessoa;
Select * from Pessoa where lower(Cidade) = 'taquara';
Select initcap('rodrigo molina munhoz') from dual;