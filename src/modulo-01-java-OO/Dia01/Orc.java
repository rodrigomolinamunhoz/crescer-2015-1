/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 * @author Rodrigo Molina
 */
public class Orc
{
    private int vida,experiencia;
    private Status status;
    private String nome;
    

    {
        vida = 110;
        status = Status.VIVO;
    }
    
    /**
     * Construtor para objetos da classe Orc
     * 
     */
    public Orc()
    {
        
    }
    public Orc(String nome, int experiencia)
    {
        this.nome = nome;
        this.experiencia = experiencia;
    } 
    
    /**
     * Faz o Orc sofrer um ataque.
     * Atualmente 10 de dano será decrementado.
     */
    public void recebeAtaque() {
        this.vida -= 10;
        // this.vida = this.vida - 10;
        status = Status.FERIDO;
        if(this.vida <= 0){
            status = Status.MORTO;
        }
       
    }
    
    public int getVida() {
        return this.vida;
    }

     /* Imprime a vida atual do Orc.
     * 
     * @return String com a vida atual do orc. Ex:
     * 
     * "Vida atual: 110"
     */
    public String toString() {
        return "Vida atual: " + this.vida;
    }
    
    public Status statusOrc(){
        status = this.status;
        return status;
    }
    
    public String getNome()
    {
        return this.nome;
    }
}
