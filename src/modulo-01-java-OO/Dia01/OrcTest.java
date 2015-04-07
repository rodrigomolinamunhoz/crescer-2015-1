

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste OrcTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
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
    
    @Test
    public void orcNasceVivo() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        // Assert - Verificação
        Status esperado = Status.VIVO;
        Status obtido = umOrc.getStatus();
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void orcRecebeAtaqueUmaVez() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        // Act
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 100;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueDuasVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 90;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueCincoVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 60;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcFicaFeridoAoReceberAtaque() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        // Act
        umOrc.recebeAtaque();
        // Assert - Verificação
        Status esperado = Status.FERIDO;
        Status resultadoObtido = umOrc.getStatus();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueDozeVezes() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        // Assert - Verificação
        int esperado = 0;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringRetornaVidaPadrao() {
        // Arrange
        Orc orc = new Orc();
        // Act
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 110";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberAtaque() {
        // Arrange
        Orc orc = new Orc("Urukhai");
        // Act
        orc.recebeAtaque();
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 100";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcToStringAposReceberDozeAtaques() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        String resultadoObtido = umOrc.toString();
        // Assert
        String esperado = "Vida atual: 0";
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcNasceComNomeInformado() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        String esperado = "Urukhai";	
        // Act - Execução da ação de testes
        umOrc = new Orc(esperado);
        // Assert - Verificação
        String resultadoObtido = umOrc.getNome();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcNasceComNomeVazioInformado() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        String esperado = "";	
        // Act - Execução da ação de testes
        umOrc = new Orc(esperado);
        // Assert - Verificação
        String resultadoObtido = umOrc.getNome();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcNasceComNomeNuloInformado() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        String esperado = null;	
        // Act - Execução da ação de testes
        umOrc = new Orc(esperado);
        // Assert - Verificação
        String resultadoObtido = umOrc.getNome();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcMorreAposDozeFlechadas() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        Status esperado = Status.MORTO;
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        Status resultadoObtido = umOrc.getStatus();
        // Assert
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroGeradoMenorQueZero() {
        Orc orc = new Orc("Tom");
        orc.recebeAtaque();
        
        int vidaEsperada = 110;
        int experienciaEsperada = 2;
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(experienciaEsperada, orc.getExperiencia());
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroGeradoEntre0e100() {
        Orc orc = new Orc("Urukhai"); // para somar 65 ao número gerado
        orc.setExperiencia(1); // ímpar e menor que 2 para poder manter entre 0 e 100
        orc.recebeAtaque();
        
        int vidaEsperada = 110;
        int experienciaEsperada = 1;
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(experienciaEsperada, orc.getExperiencia());
    }
    
    @Test
    public void orcRecebeAtaqueNormal() {
        Orc orc = new Orc("Urukhai"); // para somar 65 ao número gerado e elevar ao cubo e não estar nos casos acima.
        orc.recebeAtaque();
        
        int vidaEsperada = 100;
        Status statusEsperado = Status.FERIDO;
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(statusEsperado, orc.getStatus());
    }
}




