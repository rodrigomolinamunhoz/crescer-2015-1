
/**
 * Escreva a descrição da classe ElfoNoturno aqui.
 * 
 * @author Rodrigo Molina
 * @version 13/04/2015
 */
public class ElfoNoturno extends Elfo
{
    /**
     * COnstrutor para objetos da classe ElfoNoturno
     */
    public ElfoNoturno(String nome)
    {
       super(nome);
    }
    
    public ElfoNoturno(String umNome, int flechas)
    {
        this(umNome);
        this.flechas = flechas;

    } 
    
    public void atirarFlecha(Orc umOrc) {
        this.flechas--;
        this.experiencia += 3;
        umOrc.recebeAtaque();
        vida = (int)(vida - this.vida * 0.05);
        if (vida <= 0){
            this.status = status.MORTO;
        }
    }
}
