-- BANCO CURSO1
--Cria��o de usu�rio e           senha.
Create user CURSO1 identified by CURSO1;
-- Concedendo permiss�es para conectar e criar objetos
grant connect, resource, create view to CURSO1;

------------------------------------------------------
-- BANCO CRESCER15
-- Criando diretorio virtual para importar backup
create directory CURSOSQL as 'C:\ORACLE\DATAPUMP';
--Cria��o de usu�rio e           senha.
Create user CRESCER15 identified by CRESCER15;
-- Concedendo permiss�es para conectar e criar objetos
grant connect, resource, create view to CRESCER15;