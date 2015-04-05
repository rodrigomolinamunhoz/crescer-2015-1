

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste ElfoTest.
 *
 * @author  Rodrigo Molina
 * @version 05/04/2015
 */
public class ElfoTest
{
    /**
     * Construtor default para a classe de teste ElfoTest
     */
    public ElfoTest()
    {
        
    }
    
      /**
     * @param método que testa o número padrão de flechas que seria 42.
     * 
     */
    @Test
    public void testaNumFlechasPadrao(){
        Elfo numFlechasPadrao;
        numFlechasPadrao = new Elfo();
        int esperado = 42;
        int resultadoObtido = numFlechasPadrao.getFlechas();
        assertEquals(resultadoObtido, esperado);
    }
}
