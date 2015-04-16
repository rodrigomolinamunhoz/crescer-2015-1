

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste ElfoNoturnoTest.
 *
 * @author  Rodrigo Molina Munhoz
 * @version 13/04/2015
 */
public class ElfoNoturnoTest
{
    @Test
    public void elfoNoturnoAtiraFlechaEmUmOrc() {
        // Arrange
        ElfoNoturno elfo = new ElfoNoturno("Legolas");
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 3;
        int flechasEsperadas = 41;
        int vidaEsperada = 95;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
        assertEquals(vidaEsperada, elfo.getVida());
    }
    
    @Test
    public void elfoNoturnoAtiraFlechasDuasVezesNoMesmoOrc() {
        // Arrange
        ElfoNoturno elfo = new ElfoNoturno("Legolas");
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 6;
        int flechasEsperadas = 40;
        int vidaEsperada = 90;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
        assertEquals(vidaEsperada, elfo.getVida());
    }
    
    @Test
    public void quandoatirarFlechaStatusAtacando() {
        ElfoNoturno elfoNoturno = new ElfoNoturno("Night Legolas"); 
        Status statusEsperado = Status.ATACANDO;
        elfoNoturno.atirarFlecha(new Orc());
        Status obtido = elfoNoturno.getStatus();

        assertEquals(statusEsperado, obtido); 
    }
    
    /*
     * Meu método
    */
    @Test
    public void elfoNoturnoAtiraFlechasNoOrcAteOElfoNoturnoMorrer() {
        // Arrange
        ElfoNoturno elfo = new ElfoNoturno("Legolas");
        Orc orc = new Orc();
        // Act
        for(int i = 0; i <= 44; i++){
            elfo.atirarFlecha(orc);
        }        
        // Assert
        int experienciaEsperada = 135;
        int flechasEsperadas = -3;
        int vidaEsperada = 0;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
        assertEquals(vidaEsperada, elfo.getVida());
    }
    
    /*
     * Método professor Bernardo
    */
    @Test
    public void quandoAtirarMuitasFlechasStatusMorto() {
        ElfoNoturno elfoSuiçida = new ElfoNoturno("Night Legolas");
        Status statusEsperado = Status.MORTO;

        for (int i = 0; i < 90; i++)
            elfoSuiçida.atirarFlecha(new Orc());

        Status obtido = elfoSuiçida.getStatus();

        assertEquals(statusEsperado, obtido); 
    }  
}
