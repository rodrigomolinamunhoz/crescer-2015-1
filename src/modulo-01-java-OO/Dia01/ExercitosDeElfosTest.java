

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * A classe de teste ExercitosDeElfosTest.
 *
 * @author  Rodrigo Molina Munhoz   
 * @version 14/04/2015
 */
public class ExercitosDeElfosTest
{
    @Test
    public void alistarElfoBaseNãoalistar() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        ExercitosDeElfos exercito = new ExercitosDeElfos();
        // Act
        exercito.alistarElfo(elfo);
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void alistarDoisElfosBaseNãoalistarNenhum() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        Elfo elfo2 = new Elfo("Arwen");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        ExercitosDeElfos exercito = new ExercitosDeElfos();
        // Act
        exercito.alistarElfo(elfo);
        exercito.alistarElfo(elfo2);
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void alistarElfosVerdesalistar() {
        // Arrange
        Elfo elfo = new ElfosVerdes("Green Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(elfo.getNome(), elfo);
        ExercitosDeElfos exercito = new ExercitosDeElfos();
        // Act
        exercito.alistarElfo(elfo);
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void alistarElfoNoturnoalistar() {
        // Arrange
        Elfo elfo = new ElfoNoturno("Night Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(elfo.getNome(), elfo);
        ExercitosDeElfos exercito = new ExercitosDeElfos();
        // Act
        exercito.alistarElfo(elfo);
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void alistarElfosVerdesENoturnosalistarTodos() {
        // Arrange
        Elfo elfo = new ElfoNoturno("Night Legolas");
        Elfo elfo2 = new ElfoNoturno("Night Legolas 2");
        Elfo elfo3 = new ElfosVerdes("Green Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(elfo.getNome(), elfo);
        exercitoEsperado.put(elfo2.getNome(), elfo2);
        exercitoEsperado.put(elfo3.getNome(), elfo3);
        ExercitosDeElfos exercito = new ExercitosDeElfos();
        // Act
        exercito.alistarElfo(elfo);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void alistarElfosVerdesENoturnosalistarTodosMenosBase() {
        // Arrange
        Elfo elfo = new ElfoNoturno("Night Legolas");
        Elfo elfo2 = new ElfoNoturno("Night Legolas 2");
        Elfo elfo3 = new ElfosVerdes("Green Legolas");
        Elfo elfoBase = new Elfo("Normal Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(elfo.getNome(), elfo);
        exercitoEsperado.put(elfo2.getNome(), elfo2);
        exercitoEsperado.put(elfo3.getNome(), elfo3);
        ExercitosDeElfos exercito = new ExercitosDeElfos();
        // Act
        exercito.alistarElfo(elfoBase);
        exercito.alistarElfo(elfo);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }

    @Test
    public void buscarElfoPeloNomeNãoalistardo() {
        // Arrange
        Elfo esperado = null;
        ExercitosDeElfos exercito = new ExercitosDeElfos();
        // Act
        Elfo obtido = exercito.buscar("John"); 
        // Assert
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void buscarElfoalistardo() {
        // Arrange
        String nomeElfo = "Legolas II";
        Elfo esperado = new ElfosVerdes(nomeElfo);
        ExercitosDeElfos exercito = new ExercitosDeElfos();
        exercito.alistarElfo(esperado);
        // Act
        Elfo obtido = exercito.buscar(nomeElfo);
        // Assert
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void buscarElfoalistardoComVarios() {
        // Arrange
        String nomeElfo = "Legolas II";
        Elfo esperado = new ElfosVerdes(nomeElfo);
        ExercitosDeElfos exercito = new ExercitosDeElfos();
        exercito.alistarElfo(esperado);
        exercito.alistarElfo(new ElfosVerdes("green elf"));
        exercito.alistarElfo(new ElfoNoturno("Night Elf"));
        // Act
        Elfo obtido = exercito.buscar(nomeElfo);
        // Assert
        assertEquals(esperado, obtido);
    }
    
    /*
    @Test
    public void agruparVariosElfosPorStatus() {
        // Arrange
        ElfosVerdes elfoVivo1 = new ElfosVerdes("Green 1");
        ElfoNoturno elfoVivo2 = new ElfoNoturno("Aa");
        ElfosVerdes elfoVivo3 = new ElfosVerdes("BB");
        ElfosVerdes elfoAtacando1 = new ElfosVerdes("Green 2");
        ElfosVerdes elfoAtacando2 = new ElfosVerdes("Green 3");
        elfoAtacando1.atirarFlecha(new Orc());
        elfoAtacando2.atirarFlecha(new Orc());
        HashMap<Status, ArrayList<Elfo>> esperado = new HashMap<>();
        esperado.put(Status.ATACANDO, new ArrayList<>(
            Arrays.asList(elfoAtacando1, elfoAtacando2)
        ));
        esperado.put(Status.VIVO, new ArrayList<>(
            Arrays.asList(elfoVivo2, elfoVivo3, elfoVivo1)
        ));
        ExercitosDeElfos exercito = new ExercitosDeElfos();
        exercito.alistarElfo(elfoAtacando1);
        exercito.alistarElfo(elfoAtacando2);
        exercito.alistarElfo(elfoVivo1);
        exercito.alistarElfo(elfoVivo2);
        exercito.alistarElfo(elfoVivo3);
        // Act
        exercito.agruparPorStatus();
        HashMap<Status, ArrayList<Elfo>> resultado = exercito.getExercitoPorStatus();
        // Assert
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void buscarPorStatusAtacandoComVariosElfos() {
        // Arrange
        ElfosVerdes elfoVivo1 = new ElfosVerdes("Green 1");
        ElfoNoturno elfoVivo2 = new ElfoNoturno("Aa");
        ElfosVerdes elfoVivo3 = new ElfosVerdes("BB");
        ElfosVerdes elfoAtacando1 = new ElfosVerdes("Green 2");
        ElfosVerdes elfoAtacando2 = new ElfosVerdes("Green 3");
        elfoAtacando1.atirarFlecha(new Orc());
        elfoAtacando2.atirarFlecha(new Orc());
        ArrayList<Elfo> esperado = new ArrayList<>(
            Arrays.asList(elfoAtacando1, elfoAtacando2)
        );
        ExercitosDeElfos exercito = new ExercitosDeElfos();
        exercito.alistarElfo(elfoVivo2);
        exercito.alistarElfo(elfoVivo3);
        exercito.alistarElfo(elfoAtacando1);
        exercito.alistarElfo(elfoVivo1);
        exercito.alistarElfo(elfoAtacando2);
        // Act
        ArrayList<Elfo> resultado = exercito.buscar(Status.ATACANDO);
        // Assert
        assertEquals(esperado, resultado);
    }
    */
}
