
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
    
    public void atirarFlecha(Orc umOrc) {
        this.flechas--;
        this.experiencia += 3;
        umOrc.recebeAtaque();
        status = Status.ATACANDO;
        vida = (int)(vida - this.vida * 0.05);
        if (vida <= 0){
            this.status = status.MORTO;
        }
    }
    
    @Override
    public String toString(){
        return "Elfo Noturno: " + super.toString();
    }      
}
