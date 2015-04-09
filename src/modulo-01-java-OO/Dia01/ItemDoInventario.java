import java.util.*;
/**
 * Escreva a descrição da classe ItemDoInventario aqui.
 * 
 * @author Rodrigo Molina
 * @version 07/04/2015
 */
public class ItemDoInventario
{
    private String descricao;
    private int quantidade;
    
       
    /**
    * Cria um item de inventário com a quantidade e descrição informadas
    * 
    * @param quantidade Quantidade de unidades no inventário
    * @param descricao Descrição do item
    */
    public ItemDoInventario(int quantidade, String descricao)
    {
        this.quantidade = quantidade;
        this.descricao = descricao;
    }
    
     public int getQuantidade(){
        return this.quantidade;
    }
       
    public void setQuantidade(int novaQuantidade){
        this.quantidade = novaQuantidade;
    }
    
    public String getDescricao(){
        return this.descricao;
    }

    public String setDescricao(String descricao){
        return this.descricao = descricao;
    }
    
}

