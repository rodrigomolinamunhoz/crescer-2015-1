
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
    private int flechas;

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
     * Atira uma flecha e perde uma unidade e a vida do orc diminui.
     */
    public void atirarFlecha(Orcs n) {
        //flechas = flechas - 1;
        flechas--;
        n.vida = n.vida - 10;
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
