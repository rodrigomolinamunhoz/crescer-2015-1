package mestre.cuca;

public class ReceitaNaoEncontradaException extends RuntimeException {   
	    
	    public ReceitaNaoEncontradaException(String nomeReceita) {
	        super(String.format("deu jabulani", nomeReceita));
	    }
	
}
