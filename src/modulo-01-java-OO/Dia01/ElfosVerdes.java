import java.util.*;
/**
 * Escreva a descrição da classe ElfosVerdes aqui.
 * 
 * @author Rodrigo  
 * @version 10/04/2015
 */
public class ElfosVerdes extends Elfo
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    
    /**
     * Construtor para objetos da classe ElfosVerdes
     */
    public ElfosVerdes(String nome)
    {
       super(nome);
    }
    
    public ElfosVerdes(String umNome, int flechas)
    {
        this(umNome);
        this.flechas = flechas;

    } 
    
    public void atirarFlecha(Orc umOrc) {
        this.flechas--;
        this.experiencia += 2;
        umOrc.recebeAtaque();
    }
    
    /*
    public void atirarFlecha(Orc umOrc) {
        super.atirarFlecha(umOrc);
        experiencia ++;
        super.toString();      
    }
    */
    
    /**
    * Adiciona um item ao inventário.
    * 
    * @param item Item a ser adicionado com descrição.
    */
    protected void adicionarItem(ItemDoInventario i){  
        boolean igual = i.getDescricao().equals("Espada de aço valiriano");
        boolean igual2 = i.getDescricao().equals("Arco e Flecha de vidro");
        if (igual || igual2){
            this.list.add(i);
        }       
        /*
        ArrayList<String> itensPermitidos = new ArrayList();
        itensPermitidos.add("Espada de aço valiriano");
        itensPermitidos.add("Arco e Flecha de vidro");
        
        boolean itemPermitido = itensPermitidos.contains("Espada de aço valiriano");
        if (itemPermitido){
            super.adicionarItem(i);
        }  
        */   
    } 

    
}
