/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 * @author Rodrigo Molina
 */
public class Orc
{
    private int vida = 110;
    private Status status;

    {
        //vida = 110;
        status = Status.VIVO;
    }
    
    /**
     * Construtor para objetos da classe Orc
    public Orc()
    {
        //vida = 110;
    }
    **/
    
    /**
     * Faz o Orc sofrer um ataque.
     * Atualmente 10 de dano será decrementado.
     */
    public void recebeAtaque() {
        this.vida -= 10;
        // this.vida = this.vida - 10;
       
    }
    
    public int getVida() {
        return this.vida;
    }
    
    /**
<<<<<<< HEAD
     * Imprime a vida atual do orc
     * 
     * @return String com vida atual do orc. Ex:
     * "Vida atual: 110."
     */
    public String toString(){
        return "Vida atual: " + this.vida;
    }
    
=======
     * Imprime a vida atual do Orc.
     * 
     * @return String com a vida atual do orc. Ex:
     * 
     * "Vida atual: 110"
     */
    public String toString() {
        return "Vida atual: " + this.vida;
    }
>>>>>>> 688eeedee8cb8fca74b8fbc3cf9b0e810f80b6cf
}
