
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste ElfoTest.
 *
 * @author  Rodrigo Molina
 * @version 07/04/2015
 */
public class ElfoTest
{
      /**
     * @param método que testa se o Elfo recebe nome de acordo com o que foi escrito.
     * 
     */
    @Test
    public void elfoNasceComNomeInformado() {
        // Arrange
        String esperado = "Celeborn";        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeVazio() {
        // Arrange
        String esperado = "";        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeNulo() {
        // Arrange
        String esperado = null;        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }   
    
      /**
     * @param método que testa um elfo com as 42 flechas por padrão.
     * 
     */
    @Test
    public void elfoNasceCom42FlechasPorPadrao() {
        // Arrange
        int esperado = 42;
        // Act
        Elfo elfo = new Elfo("um nome qualquer");
        // Assert
        assertEquals(esperado, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEMuitasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 567853;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEPoucasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 12;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEFlechasNegativasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = -567853;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }

      /**
     * @param método que testa o método de atirar flechas o numero de experiencia aumenta.
     * 
     */
    @Test
    public void recebeExperiencia(){
        Elfo testaMetodo = new Elfo("Rodrigo");
        Orc umOrc = new Orc();
        int experiencia = testaMetodo.getExperiencia();
        testaMetodo.atirarFlecha(umOrc);
        int experienciaNova = testaMetodo.getExperiencia();
        assertTrue(experienciaNova > experiencia);
    }

    
    @Test
    public void elfoAtiraFlechaEmUmOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 1;
        int flechasEsperadas = 41;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasDuasVezesNoMesmoOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 2;
        int flechasEsperadas = 40;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasCincoVezesNoMesmoOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas", 4);
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 5;
        int flechasEsperadas = -1;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoToStringPadrao() {
        // Arrange
        Elfo elfo = new Elfo("Faustão");
        String resultadoEsperado = "Faustão possui 42 flechas e 0 níveis de experiência.";
        // Act
        String resultadoObtido = elfo.toString();
        // Assert
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void elfoNaceUmaVezContadorIgualAUm() {
        // Arrange
        int contadorEsperado = 1; 
        // Act
        Elfo elfo = new Elfo("Legolas");
        // Assert      
        assertEquals(contadorEsperado, Elfo.getContadorNasceElfo());
    }
    
    @Test
    public void elfoNaceTresVezesContadorIgualATres() {
        // Arrange
        int contadorEsperado = 3;   
        // Act
        Elfo elfo1 = new Elfo("Legolas");
        Elfo elfo2 = new Elfo("Arraaaaaaaaaaaaai");
        Elfo elfo3 = new Elfo("AAAAAAAAAAAAAAAAa, calma");
        // Assert     
        assertEquals(contadorEsperado, Elfo.getContadorNasceElfo());
       
    }
    
    @Before 
    public void seuUp(){
        Elfo.resetContadorNasceElfo();
    }
    
    @Test
    public void doisElfosComMesmoNomeSaoIguais() {
        // Arrange
        boolean esperado = true;
        // Act
        Elfo legolas = new Elfo("Legolas");
        Elfo legolas2 = new Elfo("Legolas");
        // Assert
        assertEquals(esperado, legolas.equals(legolas2));
    }
    
    @Test
    public void doisElfosComNomesDiferentesNaoSaoIguais() {
        // Arrange
        boolean esperado = false;
        // Act
        Elfo legolas = new Elfo("Legolas");
        Elfo legolas2 = new Elfo("Legolas II");
        // Assert
        assertEquals(esperado, legolas.equals(legolas2));
    }
}

