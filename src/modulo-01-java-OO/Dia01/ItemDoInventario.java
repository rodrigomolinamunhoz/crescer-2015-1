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
    
    public ItemDoInventario()
    {
        this.quantidade = 12;
        this.descricao = "Faca";
    }
    
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
       
    public int setQuantidade(int quantidade){
        return this.quantidade = quantidade;
    }
    
    public String getDescricao(){
        return this.descricao;
    }

    public String setDescricao(String descricao){
        return this.descricao = descricao;
    }
        
    public void arrayAdicionaItem(){
        System.out.println("As informações inseridas foram:");  
        System.out.println("Quantidade:      " + getQuantidade());  
        System.out.println("Descricao: " + getDescricao());  
       
    }
//}
    
//     public void arrayPerdeItem(){
//     
}

