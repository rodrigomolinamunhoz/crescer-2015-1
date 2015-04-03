

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OrcsTest.
 *
 * @author Rodrigo Molina 
 * @version 02/04/2015
 */
public class OrcsTest
{
    /**
     * @param método que testa se o Orc nasce com 110 de vida.
     * 
     */
    @Test
    public void orcNasceCom110DeVida()
    {
        //Arrange - montagem dos dados de teste.
        //Act - execução da ação de teste.
        //Assert verificação se o resultado é o esperado.
        Orcs umOrc;
        umOrc = new Orcs();
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        assertEquals(resultadoObtido, esperado);
    } 

    
}