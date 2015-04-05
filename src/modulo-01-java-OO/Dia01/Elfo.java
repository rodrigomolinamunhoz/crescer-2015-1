
/**
 * Define objetos Elfo
 * 
 * @author CWI Software
 * 
 * somente esta linha
 */
public class Elfo
{
    // Versão correção do tema!!
    
    private String nome;
    private int flechas, experiencia;

    // type initializer
    {
        flechas = 42;
    }
     public Elfo()
    {
       
    }
    
    /**
     * Cria objetos Elfo
     * 
     * @param umNome Nome que o elfo receberá
     * @param flechas Quantidade inicial de flechas
     */
    public Elfo(String umNome, int flechas)
    {
        this(umNome);
        // this.nome = nome;
        this.flechas = flechas;
    } 
       
    public Elfo(String nome) {
        this.nome = nome;
    }
    
    /**
<<<<<<< HEAD
     * @param Atira uma flecha e perde uma unidade de flecha, ganha experiencia e a vida do orc diminui no metodo da classe orc.
     */
    public void atirarFlecha(Orcs n) {
        //flechas = flechas - 1;
        flechas--;
        experiencia++;
        n.tiraVida();
        
=======
     * Atira uma flecha e perde uma unidade.
     * 
     * @param umOrc Orc que receberá uma flechada.
     */
    public void atirarFlecha(Orc umOrc) {
        //flechas = flechas - 1;
        flechas--;
        experiencia++;
        umOrc.recebeAtaque();
>>>>>>> 6fbcffc4d0c351d0d84ab721e1dd116f0988c35a
    }
    
     public int getFlechas(){
        return this.flechas;
    }

    /*
    public void setNome(String novoNome) {
        nome = novoNome;
    }
    */

    /*public void setFlechas(int novaQtdFlechas) {
        if (novaQtdFlechas > flechas) {
            flechas = novaQtdFlechas;
        }
    }*/
    
    // camelCase: public void atirarFlechaDourada
    // PascalCase: public void AtirarFlechaDourada
    
    
    
    
    
    
}
