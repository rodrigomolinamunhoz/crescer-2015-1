-- BANCO CURSO1
--Criação de usuário e           senha.
Create user CURSO1 identified by CURSO1;
-- Concedendo permissões para conectar e criar objetos
grant connect, resource, create view to CURSO1;

------------------------------------------------------
-- BANCO CRESCER15
-- Criando diretorio virtual para importar backup
create directory CURSOSQL as 'C:\ORACLE\DATAPUMP';
--Criação de usuário e           senha.
Create user CRESCER15 identified by CRESCER15;
-- Concedendo permissões para conectar e criar objetos
grant connect, resource, create view to CRESCER15;