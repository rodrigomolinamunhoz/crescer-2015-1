
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
       super(nome, 42);
    }
    
    public ElfosVerdes(String umNome, int flechas)
    {
        this(umNome);
        this.flechas = flechas;

    } 
    
    @Override
    public void atirarFlecha(Orc umOrc) {
        //flechas = flechas - 1;
        flechas--;
        experiencia += 2;
        umOrc.recebeAtaque();
    }
    
      /**
   * Adiciona um item ao inventário.
   * 
   * @param item Item a ser adicionado com descrição.
   */
   protected void adicionarItem(ItemDoInventario i){ 
        this.list.add(i);
   } 

    
}
