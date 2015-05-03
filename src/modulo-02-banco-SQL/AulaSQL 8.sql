use [Crescer15-1]

-- BLOCOS ANÔNIMOS
BEGIN

	DECLARE @Nome VarChar(30)
	SET @Nome = 'CWI Software'

	Print @Nome
	Print getdate()

END;

BEGIN
	DECLARE @vIDCliente int

	Select @vIDCliente = IDCliente
	From Cliente
	Where Nome = 'Mariana Ventura Che'

	Print 'Mariana possui o código ' +
	Cast(@vIDCliente AS VarChar(10))

END;


BEGIN

	DECLARE @vTamanho int

	--Busca o maior nome (caracteres)
	Select @vTamanho = MAX(Len(Nome))
	From Cliente

	--Lista todos os clientes cfe tamanho do nome
	Select IDCliente, Nome
	From Cliente
	Where Len(Nome) = @vTamanho

END;

BEGIN

	SET NOCOUNT ON

	DECLARE @vTamanho int

	--Busca o maior nome (caracteres)
	Select @vTamanho = MAX(Len(Nome))
	From Cliente
	--Lista todos os clientes cfe tamanho do nome
	Select IDCliente, Nome
	From Cliente
	Where Len(Nome) = @vTamanho

	SET NOCOUNT OFF

END;


BEGIN
	DECLARE @vCount int

	Select @vCount = COUNT(1)
	From Cliente

	IF(@vCount=0) BEGIN
	Print 'Nenhum cliente cadastrado.'
	Print 'Execute o procedimento de carga'
	END ELSE IF (@vCount=1)
	Print 'Um registro encontrado.'
	ELSE
	Print 'Muitos registros encontrados.'
END

BEGIN
	DECLARE @vCount int
	SET @vCount = 0	

	WHILE(@vCount<10) BEGIN
	SET @vCount = @vCount + 1
	Print 'Executou loop: '+ Cast(@vCount as Varchar(10) )
	END
END

BEGIN
	BEGIN TRY
	Begin Transaction

		Insert into Cidade (IDCidade, Nome, UF)
		Values (1, 'Morro da Pedra', 'RS');

	Commit
	END TRY
		BEGIN CATCH
			Rollback
			Print ERROR_MESSAGE()
	END CATCH

END

BEGIN
	BEGIN TRY
	Begin Transaction

	Set Identity_Insert Cidade ON;
	Insert into Cidade (IDCidade, Nome, UF)
	Values (1, 'Morro da Pedra', 'RS');

	Set Identity_Insert Cidade OFF;

	Commit
	END TRY

	BEGIN CATCH
		If @@TRANCOUNT > 0 Rollback; --Se existir alguma transacao
		Print ERROR_MESSAGE()
	END CATCH
END


BEGIN
	BEGIN TRY
		Declare @vRazaoSocial VarChar(50),
		@vNome VarChar(50)
		Set @vRazaoSocial = 'CWI Software Ltda'

		Select @vNome = Nome
		From Cliente
		Where RazaoSocial = @vRazaoSocial

		If @@ROWCOUNT= 0 --Numero de linhas do Select anterior
		RAISERROR('Registro "%s" nao foi encontrado!', 16, 1, @vRazaoSocial)

		Print 'Nome encontrado! ['+ @vNome + ']'

	END TRY
	BEGIN CATCH
		Print 'Error Code: '+ CAST(ERROR_NUMBER() AS VARCHAR(100))
		Print 'Error Text: '+ ERROR_MESSAGE()
	END CATCH
END

--	CURSOR

BEGIN
	DECLARE ListaCidade CURSOR
	Local
	Fast_Forward
	FOR Select Nome, Uf
		From Cidade
		Group by Nome, Uf
		Having COUNT(1) > 1;
	DECLARE @vNome varchar(50),
			@vUF varchar(2)

	OPEN ListaCidade;
	FETCH NEXT FROM ListaCidade INTO @vNome, @vUF

	WHILE (@@FETCH_STATUS=0) BEGIN

		Print @vNome + '/'+@vUF;
		FETCH NEXT FROM ListaCidade INTO @vNome, @vUF

	END

	CLOSE ListaCidade;
	DEALLOCATE ListaCidade;
END

-------------------------------------------------------------------------------------------------
/*Exercícios*/
/* 1)Imprima qual produto é o mais vendido, considere a quantidade(PedidoItem).*/
BEGIN
DECLARE @vIDProduto int,
		@vNomeUM VarChar(50),
		@vQuantidade int

			Select Top 1	    
				   @vIDProduto = PedidoItem.IDProduto,
				   @vNomeUM = Produto.Nome, 
				   @vQuantidade = SUM(Quantidade)
			From PedidoItem 
			INNER JOIN Produto on Produto.IDProduto = PedidoItem.IDProduto
			Group By PedidoItem.IDProduto,
					 Produto.Nome
			Order By SUM(Quantidade) desc;

			Print 'Nome: ' + @vNomeUM +' Quantidade: '+
			Cast(@vQuantidade AS VarChar(10))
END

/* 2)Liste as cidades com nome e UF duplicados que tenham clientes relacionados. */

BEGIN
	DECLARE ListaCidade CURSOR Local Fast_Forward
	FOR Select Nome,
			   Uf
		From Cidade
		Group by Nome, Uf
		Having COUNT(1) > 1

	DECLARE @vNomeDOIS varchar(50),	@vUFUM varchar(2), @total integer

	OPEN ListaCidade;
	FETCH NEXT FROM ListaCidade INTO @vNomeDOIS, @vUFUM

	WHILE (@@FETCH_STATUS=0) BEGIN

	select @total = count(1)
	from Cliente cli
	where IDCidade in (Select 1
				  from Cidade
				  where   Cidade.Nome = @vNomeDOIS
				  and   Cidade.UF = @vUFUM);  

	if (@total > 0)
		Print 'Cidade: '+ @vNomeDOIS + '/'+@vUFUM + ' possui '+ cast(@total as varchar) + ' cliente(s)';

	FETCH NEXT FROM ListaCidade INTO @vNomeDOIS, @vUFUM

	END
	CLOSE ListaCidade;
	DEALLOCATE ListaCidade;
END

/*3)Identifique qual o material é utilizado por mais produtos e em seguida liste a quantidade de pedidos realizados,
 com produtos compostos por este material, liste também o valor total de vendas dos últimos 60 dias.*/

BEGIN
         
 DECLARE @vQtdeProd   int,
         @vIDMaterial int,
         @vDataPedido datetime,
         @vDescricaoMaterial varchar(50),
         @vTotalPedidos int,
         @vTotalVendas  decimal(12,2)
 
 --	IDENTIFICA O MATERIAL MAIS UTILIZADO POR TODOS OS PRODUTOS
 -- IMPORTANTE: não é a quantidade, e sim a frequência em Produtos distintos
 -- BUSCA A DESCRICAO DO MATERIAL
  Select TOP(1) 
		@vDescricaoMaterial = Material.Descricao,
        @vIDMaterial = ProdutoMaterial.IDMaterial, 
        @vQtdeProd   = Count(distinct IDProduto)
 From   ProdutoMaterial
 INNER JOIN Material on Material.IDMaterial = ProdutoMaterial.IDMaterial
 Group  by ProdutoMaterial.IDMaterial,Material.Descricao
 Order  by Count(distinct IDProduto) Desc

 -- BUSCA O TOTAL DE PEDIDOS
 Select @vTotalPedidos = COUNT(distinct IDPedido)
 From   PedidoItem
 Where  IDProduto in (Select IDProduto             -- todos produtos com material selecionado acima
                      From   ProdutoMaterial pm
                      Where  pm.IDMaterial = @vIDMaterial);
 

 -- TOTAL DOS PEDIDOS DOS ÚLTIMOS 60 DIAS 
 Set @vDataPedido = convert(datetime,  convert(varchar, DATEADD(DAY, -60, GETDATE()), 103)  , 103)
 
 -- faz consulta para buscar informação
 Select @vTotalVendas = SUM(ValorPedido) 
 From   Pedido
 Where  DataPedido >= @vDataPedido
 

 -- IMPRIME RESULTADOS

 Print 'Material mais utilizado: ' + cast(@vIDMaterial as varchar) + ' - '+ @vDescricaoMaterial
 Print 'Total de pedidos com produtos que utilizam o material: ' + cast(@vTotalPedidos as varchar)
 Print 'Total de vendas R$ ' + cast(@vTotalVendas as varchar(50)) + ' (últimos 60 dias)'
END

/* 4)Faça um bloco T-SQL que liste todos os Clientes que estão relacionados com as cidades duplicadas (Nome e UF).
 Não considere as cidades duplicadas de menor IDCidade. */
 BEGIN
  SET NOCOUNT ON
  -- LISTA PARA AUXILIAR NA CONSULTA
  Declare @CidadeDuplicada table 
    (
     IDCidadeMenor  int,
     Nome           varchar(50),
     UF             varchar(2)
     )

  -- CARREGA LISTA DE CIDADES DUPLICADAS, E MENOR IDCIDADE
  Insert @CidadeDuplicada 
         (IDCidadeMenor, Nome, UF)
     select MIN(IDCidade) MenorID, 
            Nome, 
            UF
     from   Cidade dup
     group  by Nome, UF
     having COUNT(1) > 1

  -- BUSCA TODOS OS CLIENTES RELACIONANDO COM CIDADE
  -- E FILTRANDO PARA EXIBIR AS CIDADES DUPLICADAS (IGNORANDO IDCIDADE = MIN(IDCIDADE))
  Select Cli.IDCliente, cli.Nome,  cid.IDCidade, cid.Nome as Nome_Cidade
    From  Cliente cli
   inner join Cidade cid on cid.IDCidade = cli.IDCidade
   Where exists (Select 1
                 From   @CidadeDuplicada dup
                 Where  dup.Nome          = cid.Nome
                 and    dup.UF            = cid.UF
                 and    dup.IDCidadeMenor < cid.IDCidade)
  order by Nome_Cidade
  --
  SET NOCOUNT OFF  
END