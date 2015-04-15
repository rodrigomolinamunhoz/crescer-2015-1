import java.util.HashMap;
/**
 * Escreva a descrição da classe ExercitosDeElfos aqui.
 * 
 * @author Rodrigo Molina
 * @version 14/04/2015
 */
public class ExercitosDeElfos
{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    
    private HashMap<String, Elfo> exercitoStatusVivo = new HashMap<>();
    private HashMap<String, Elfo> exercitoStatusFerido = new HashMap<>();
    private HashMap<String, Elfo> exercitoStatusMorto = new HashMap<>();
    
    public HashMap<String, Elfo> getExercito(){
        return this.exercito;
    }
    
    public HashMap<String, Elfo> getExercitoVivo(){
        return this.exercitoStatusVivo;
    }
    
    public HashMap<String, Elfo> getExercitoFerido(){
        return this.exercitoStatusFerido;
    }
    
    public HashMap<String, Elfo> getExercitoMorto(){
        return this.exercitoStatusMorto;
    }
    
    /**
    * Alista o elfo no exército para que seja utilizado em batalha.
    * 
    * @param elfo Elfo a ser alistado no exército. Deve ser apenas do tipo ElfoVerde ou ElfoNoturno
    */
    public void alistarElfo(Elfo elfo){
      boolean podeAlistar = elfo instanceof ElfosVerdes || elfo instanceof ElfoNoturno; //|| elfo instanceof Elfo
      if (podeAlistar){
        exercito.put(elfo.getNome(), elfo);
      } 
    }
    
    /**
    * Busca um elfo no meio do exército, a partir do seu nome.
    * 
    * @param nome Nome do elfo para utilizar na busca.
    * @return Elfo Resultado da busca pelo nome. Caso não encontre nada retorna null.
    */
    public Elfo buscarElfo(String nome){
        return exercito.get(nome);
    }
    
    public void agruparElfosPorStatus(Elfo elfo){        
        boolean vivo = elfo.getStatus().equals(Status.VIVO);
        boolean ferido = elfo.getStatus().equals(Status.FERIDO);
        boolean morto = elfo.getStatus().equals(Status.MORTO);
        
        if(vivo){
            exercitoStatusVivo.put(elfo.getNome(), elfo);
        } else if (ferido){
            exercitoStatusFerido.put(elfo.getNome(), elfo);
        } else if (morto){
            exercitoStatusMorto.put(elfo.getNome(), elfo);
        }
        
    }
}
