

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste OrcTest.
 *
 * @author  Rodrigo Molina
 * @version 05/04/2015
 */
public class OrcTest
{
    @Test
    public void orcNasceCom110Vida() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        // Assert - Verificação
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
     /**
     * @param método que testa se ao receber o ataque o Orc perde vida.
     * 
     */
    @Test
    public void orcRecebeAtaque() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        // Assert - Verificação
        int esperado = 110;
        umOrc.recebeAtaque();
        int resultadoObtido = umOrc.getVida();
        
        assertTrue(esperado > resultadoObtido);
    }
}