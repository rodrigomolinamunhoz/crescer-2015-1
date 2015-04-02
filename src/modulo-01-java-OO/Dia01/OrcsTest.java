

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OrcsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class OrcsTest
{
    /**
     * Default constructor for test class OrcsTest
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
    
    public void receberAtaque(){}
    
    

    
}
