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
			   Uf,
			   COUNT(1) as TotalCidade
		From Cidade
		Group by Nome, Uf
		Having COUNT(1) > 1

	DECLARE @vNomeDOIS varchar(50),	@vUFUM varchar(2), @total integer;

	OPEN ListaCidade;
	FETCH NEXT FROM ListaCidade INTO @vNomeDOIS, @vUFUM

	WHILE (@@FETCH_STATUS=0) BEGIN

	select @total = count(1)
	from Cliente cli
	where EXISTS (Select 1
				  from Cidade
				  Where Cidade.IDCidade = cli.IDCliente
				  and   Cidade.Nome = @vNomeDOIS
				  and   Cidade.UF = @vUFUM);  

	if @total > 0
		Print @vNomeDOIS + '/' + @vUFUM + ' Total Cidades: ' + cast(@total as varchar(10));

	FETCH NEXT FROM ListaCidade INTO @vNomeDOIS, @vUFUM

	END
	CLOSE ListaCidade
	DEALLOCATE ListaCidade;
END


BEGIN
	DECLARE ListaCidade CURSOR local Fast_Forward
		FOR select	nome,
					uf
			from Cidade
			group by nome, uf
			having count(1) > 1
	DECLARE @vNome varchar(50), @vUF varchar(2), @total integer;
	OPEN ListaCidade;
	FETCH NEXT FROM ListaCidade INTO @vNome, @vUF
	
	while(@@FETCH_STATUS = 0) BEGIN
		
		select @total = count(1)
		from cliente cli
		where EXISTS (select 1
					  from Cidade
					  where Cidade.IDCidade = cli.IDCidade
					  and	Cidade.Nome = @vNome
					  and	Cidade.UF = @vUF);		  
		if @total > 0
			print @vNome + '/' + @vUF

		FETCH NEXT FROM ListaCidade INTO @vNome, @vUF
	end
	
	close ListaCidade
	deallocate ListaCidade
END

/*3)Identifique qual o material é utilizado por mais produtos e em seguida liste a quantidade de pedidos realizados,
 com produtos compostos por este material, liste também o valor total de vendas dos últimos 60 dias.*/

select count(distinct ped.IDPedido) total_pedidos
	   count(1) total_itens
from Pedido ped
inner join PedidoItem item on item.IDPedido = ped.IDPedido
where exists (select 1 
			  from ProdutoMaterial pm
			  where pm.IDProduto = item.IDProduto
			  and pm.IDMaterial in (select IDMaterial from vwMateriais_Mais_Utilizados)
			  );
 
 select pro.IDProduto, pro.Nome
 from Produto pro
 where exists (select 1
			   from ProdutoMaterial pm
			   where pm.IDProduto = pro.IDProduto
			   and pm.IDMaterial in (select IDMaterial from vwMateriais_Mais_Utilizados)
			   );

create view vwMateriais_Mais_Utilizados as
 select top 1 with ties ma.IDMaterial, ma.Descricao, count(DISTINCT pm.IDProduto) total_produto_distinto
 from Material ma
 inner join ProdutoMaterial pm on pm.IDMaterial = ma.IDMaterial
 inner join Produto pr on pr.IDProduto = pm.IDProduto
 group by ma.IDMaterial, ma.Descricao
 order by total_produto_distinto desc;


 select ped.IDPedido, PedidoItem.IDPedidoItem, pro.Nome, PedidoItem.Quantidade
 from Pedido ped
 inner join PedidoItem  on PedidoItem.IDPedido = ped.IDPedido
 inner join Produto pro on pro.IDProduto = PedidoItem.IDProduto
 where ped.DataPedido between DATEADD(day, -60, getdate()) and getdate();

 create index IX_Pedido_DataPedido on Pedido(DataPedido);
