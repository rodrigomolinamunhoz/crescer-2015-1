

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * A classe de teste ElfosVerdesTest.
 *
 * @author  Rodrigo Molina Munhoz
 * @version 12/04/2015
 */
public class ElfosVerdesTest
{
    @Test
    public void elfoverdeNasceComNomeInformado() {
        // Arrange
        String esperado = "Celeborn";        
        // Act
        ElfosVerdes elfo = new ElfosVerdes(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoVerdeNasceComNomeVazio() {
        // Arrange
        String esperado = "";        
        // Act
        ElfosVerdes elfo = new ElfosVerdes(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoVerdeNasceComNomeNulo() {
        // Arrange
        String esperado = null;        
        // Act
        ElfosVerdes elfo = new ElfosVerdes(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
      /**
     * @param método que testa um elfo com as 42 flechas por padrão.
     * 
     */
    @Test
    public void elfoVerdeNasceCom42FlechasPorPadrao() {
        // Arrange
        int esperado = 42;
        // Act
        ElfosVerdes elfo = new ElfosVerdes("um nome qualquer");
        // Assert
        assertEquals(esperado, elfo.getFlechas());
    }
    
    @Test
    public void elfoVerdeNasceComNomeEMuitasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 567853;
        // Act
        ElfosVerdes elfo = new ElfosVerdes(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoVerdeNasceComNomeEPoucasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 12;
        // Act
        ElfosVerdes elfo = new ElfosVerdes(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoVerdeNasceComNomeEFlechasNegativasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = -567853;
        // Act
        ElfosVerdes elfo = new ElfosVerdes(nomeEsperado, flechasEsperadas);
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
        ElfosVerdes testaMetodo = new ElfosVerdes("Rodrigo");
        Orc umOrc = new Orc();
        int experiencia = testaMetodo.getExperiencia();
        testaMetodo.atirarFlecha(umOrc);
        int experienciaNova = testaMetodo.getExperiencia();
        assertTrue(experienciaNova > experiencia);
    }

    
    @Test
    public void elfoVerdeAtiraFlechaEmUmOrc() {
        // Arrange
        ElfosVerdes elfo = new ElfosVerdes("Legolas");
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 2;
        int flechasEsperadas = 41;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoVerdeAtiraFlechasDuasVezesNoMesmoOrc() {
        // Arrange
        ElfosVerdes elfo = new ElfosVerdes("Legolas");
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 4;
        int flechasEsperadas = 40;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoVerdeAtiraFlechasCincoVezesNoMesmoOrc() {
        // Arrange
        ElfosVerdes elfo = new ElfosVerdes("Legolas", 4);
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 10;
        int flechasEsperadas = -1;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void quandoAdicionoEspadaDeAçoValirianoAoInventario(){
        //Arrange
        ElfosVerdes elfoverde = new ElfosVerdes("Verde");
        ItemDoInventario EspadaDeAçoValiriano = new ItemDoInventario(1,"Espada de aço valiriano");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<ItemDoInventario>(); 
        inventarioEsperado.add(EspadaDeAçoValiriano);
        //Act
        elfoverde.adicionarItem(EspadaDeAçoValiriano);
        ArrayList<ItemDoInventario> inventarioObtido = elfoverde.getItens(); 
        //Assert 
        assertEquals(inventarioEsperado, inventarioObtido);
        assertEquals(inventarioEsperado.get(0), inventarioObtido.get(0));
    }
    
    @Test
    public void quandoAdicionoEspadaDeAçoValirianoEArcoEFlechaDeVidroAoInventario() {
        // Arrange
        ElfosVerdes elfoverde = new ElfosVerdes("Verde");
        ItemDoInventario EspadaDeAçoValiriano = new ItemDoInventario(34, "Espada de aço valiriano");
        ItemDoInventario ArcoEFlechaDeVidro = new ItemDoInventario(12, "Arco e Flecha de vidro");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(EspadaDeAçoValiriano);
        inventarioEsperado.add(ArcoEFlechaDeVidro);
        // Act
        elfoverde.adicionarItem(EspadaDeAçoValiriano);
        elfoverde.adicionarItem(ArcoEFlechaDeVidro);
        ArrayList<ItemDoInventario> inventarioObtido = elfoverde.getItens();
        // Assert
        assertEquals(inventarioEsperado, inventarioObtido);
    }
    
    @Test
    public void quandoAdicionoEspadaDeAçoValirianoEItemNaoPermitidoAoInventario() {
        // Arrange
        ElfosVerdes elfoverde = new ElfosVerdes("Verde");
        ItemDoInventario EspadaDeAçoValiriano = new ItemDoInventario(34, "Espada de aço valiriano");
        ItemDoInventario adaga = new ItemDoInventario(12, "Adaga");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(EspadaDeAçoValiriano);
        // Act
        elfoverde.adicionarItem(EspadaDeAçoValiriano);
        ArrayList<ItemDoInventario> inventarioObtido = elfoverde.getItens();
        // Assert
        assertEquals(inventarioEsperado, inventarioObtido);
    }
    
    @Test
    public void quandoAdicionoArcoEFlechaDeVidroEItemNaoPermitidoAoInventario() {
        // Arrange
        ElfosVerdes elfoverde = new ElfosVerdes("Verde");
        ItemDoInventario ArcoEFlechaDeVidro = new ItemDoInventario(34, "Arco e Flecha de vidro");
        ItemDoInventario adaga = new ItemDoInventario(12, "Adaga");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(ArcoEFlechaDeVidro);
        // Act
        elfoverde.adicionarItem(ArcoEFlechaDeVidro);
        ArrayList<ItemDoInventario> inventarioObtido = elfoverde.getItens();
        // Assert
        assertEquals(inventarioEsperado, inventarioObtido);
    }
}
