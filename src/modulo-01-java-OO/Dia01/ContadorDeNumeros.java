
/**
 * Escreva a descrição da classe ContadorDeNumeros aqui.
 * 
 * @author Rodrigo Molina
 * @version 08/04/2015
 */
public class ContadorDeNumeros
{
    private static int x;
    private int y;
    
    public static void contarAte5(){
      x = 10;
      for (int i = 0; i < 5; i++){
          System.out.println(i + 1);
      }
    }
    
    public void contarAte3(){
      
      x = 11;
        
      for (int i = 0; i < 3; i++){
          System.out.println(i + 1);
      }
      
      for (int i = 1; i <= 3; i++){
          System.out.println(i);
      }
      
      for (int i = 1; i < 4; i++){
          System.out.println(i);
      }
      
      for (int i = 1; i == 1; i++){
          System.out.println(i);
      }
    }
    
     public void contarAte(int numero){
      for (int i = 0; i < numero; i++){
          System.out.println(i + 1);
      }
    }
    
     public void contarNumeroRegressivamente(){
      for (int i = 0; i > 0; i--){
          System.out.println(i);
      }
    }
}
