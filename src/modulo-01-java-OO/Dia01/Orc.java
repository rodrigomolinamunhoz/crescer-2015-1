/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 */
public class Orc
{
    private int experiencia, vida = 110;
    private String nome;
    private Status status = Status.VIVO;

    {
        //vida = 110;
    }
    
    /**
     * Construtor para objetos da classe Orc
     */ 
    public Orc(String nome)
    {
        //vida = 110;
        this.nome = nome;
    }
    
    public Orc() {
    }
    
    /**
     * Faz o Orc sofrer um ataque.
     * Atualmente 10 de dano será decrementado.
     */
    public void recebeAtaque() {
        
        int danoVida = 10;
        
        if (this.vida >= danoVida) {
            this.vida -= danoVida;
            // this.vida = this.vida - 10;
            this.status = Status.FERIDO;
        } 
        
        if (this.vida == 0) {
            this.status = Status.MORTO;
        }

    }
    
    public String getNome() {
        return this.nome;
    }
    
    public int getExperiencia() {
        return this.experiencia;
    }
    
    public int getVida() {
        return this.vida;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    /**
     * Imprime a vida atual do Orc.
     * 
     * @return String com a vida atual do orc. Ex:
     * 
     * "Vida atual: 110"
     */
    public String toString() {
        return "Vida atual: " + this.vida;
    }
}
