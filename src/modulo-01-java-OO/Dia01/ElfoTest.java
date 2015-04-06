

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste ElfoTest.
 *
 * @author  Rodrigo Molina
 * @version 02/04/2015
 */
public class ElfoTest
{
    
    
      /**
     * @param método que testa o número padrão de flechas que seria 42.
     * 
     */
    @Test
    public void numFlechasPadrao(){
        Elfo numFlechasPadrao;
        numFlechasPadrao = new Elfo();
        int esperado = 42;
        int resultadoObtido = numFlechasPadrao.getFlechas();
        assertEquals(resultadoObtido, esperado);
    }
     /**
     * @param método que testa se o Elfo recebe nome de acordo com o que foi escrito.
     * 
     */
    @Test
    public void nomeElfo() {
        Elfo nomeEscrito = new Elfo("Rodrigo");        
        assertEquals("Rodrigo", nomeEscrito.getNome());
    }
    
      /**
     * @param método que testa o método de atirar flechas conferindo se o numero de flechas é diminuido.
     * 
     */
    @Test
    public void diminuiFlecha(){
        Elfo testaMetodo = new Elfo();
        Orc umOrc = new Orc();
        int flecha = testaMetodo.getFlechas();
        testaMetodo.atirarFlecha(umOrc);
        int flechaNova = testaMetodo.getFlechas();
        assertTrue(flechaNova < flecha);
    }
      /**
     * @param método que testa o método de atirar flechas o numero de experiencia aumenta.
     * 
     */
    @Test
    public void recebeExperiencia(){
        Elfo testaMetodo = new Elfo();
        Orc umOrc = new Orc();
        int experiencia = testaMetodo.getExperiencia();
        testaMetodo.atirarFlecha(umOrc);
        int experienciaNova = testaMetodo.getExperiencia();
        assertTrue(experienciaNova > experiencia);
    }
      /**
     * @param método que testa se o nome é inserido na String nome.
     * 
     */
    @Test
    public void recebeNomeNulo(){
        Elfo nomeEscrito = new Elfo("Rodrigo");
        assertNotNull(nomeEscrito.getNome());
    }
     /**
     * @param método que testa se a flecha não está nula.
     * 
     */    
     @Test
    public void recebeFlechaNula(){
        Elfo flecha = new Elfo();
        assertNotNull(flecha.getFlechas());
    }
}
