
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
     * @param Atira uma flecha e perde uma unidade de flecha, ganha experiencia e a vida do orc diminui no metodo da classe orc.
     */
    public void atirarFlecha(Orcs n) {
        //flechas = flechas - 1;
        flechas--;
        experiencia++;
        n.tiraVida();
        
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
