/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 * @author Rodrigo Molina
 */
public class Orc
{
    private int vida = 110;
    private int experiencia,numero;
    private Status status = Status.VIVO;;
    private String nome;
    
    {
        
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
        gerarNumero();
        this.experiencia = experiencia;
    } 
    
    /**
     * Faz o Orc sofrer um ataque.
     * Atualmente 10 de dano será decrementado.
     */
    public void recebeAtaque() {
        double numero = this.gerarNumero();
        this.vida -= 10;
        // this.vida = this.vida - 10;
        this.status = (Status.FERIDO);
        if(this.vida <= 0){
            this.status =(Status.MORTO);
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
    
    public String getNome(){
        return this.nome;
    }
    
    public int setExperiencia(){
        return this.experiencia = experiencia;
    }
    
   public void setStatus(String status) {
       status = status;
   }
   
   public Status getStatus(){
        return this.status;
    }
    
    private double gerarNumero()
    { 
       double numero = 0.0;
       if (this.nome.length() > 5 && this.nome.length() != 0){
           
          numero = this.nome.length() + 65;
       } else {
          numero = this.nome.length() - 60;  
       }
       if(this.status == (Status.FUGINDO)){
           numero = numero / 2;
       } else if (this.status == (Status.FUGINDO) && this.status == (Status.CACANDO)) {
           numero = numero + 1;
       }
       if(this.vida >= 30 && this.vida <= 60){
            numero = this.vida * 2;  
       } else if (getVida() < 20){
            numero = this.vida * 3;
       }
       if(this.experiencia % 2 == 0){
           numero = numero * numero * numero; 
       } else {
           numero = numero * numero;
       }
       return numero;
   }
}
