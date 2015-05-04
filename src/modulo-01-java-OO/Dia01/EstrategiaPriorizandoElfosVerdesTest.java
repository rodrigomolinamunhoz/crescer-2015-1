import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaPriorizandoElfosVerdesTest
{
    @Test
    public void exercitoEmbaralhadoPriorizaAtaqueComElfosVerdes() throws NaoPodeAlistarException {
        // Arrange
        ExercitosDeElfos exercito = new ExercitosDeElfos();
        exercito.mudaDeEstrategia(new EstrategiaPriorizandoElfosVerdes());
        Elfo night1 = new ElfoNoturno("Night 1");
        Elfo night2 = new ElfoNoturno("Night 2");
        Elfo green1 = new ElfosVerdes("Green 1");
        Elfo night3 = new ElfoNoturno("Night 3");
        Elfo green2 = new ElfosVerdes("Green 2");
        exercito.alistarElfo(night1);
        exercito.alistarElfo(night2);
        exercito.alistarElfo(green1);
        exercito.alistarElfo(night3);
        exercito.alistarElfo(green2);
        ArrayList<Elfo> esperado = new ArrayList<>(
            Arrays.asList(green2, green1, night1, night2, night3)
        );
        // Act
        exercito.atacarHorda(new ArrayList<>(
            Arrays.asList(new Orc(), new Orc(), new Orc())
        ));
        // Assert
        assertEquals(esperado, exercito.getOrdemDoUltimoAtaque());
    }
    
    @Test
    public void exercitoSóDeVerdes() throws NaoPodeAlistarException {
        // Arrange
        ExercitosDeElfos exercito = new ExercitosDeElfos();
        exercito.mudaDeEstrategia(new EstrategiaPriorizandoElfosVerdes());
        Elfo green1 = new ElfosVerdes("Green 1");
        Elfo green2 = new ElfosVerdes("Green 2");
        exercito.alistarElfo(green1);
        exercito.alistarElfo(green2);
        ArrayList<Elfo> esperado = new ArrayList<>(
            Arrays.asList(green2, green1)
        );
        // Act
        exercito.atacarHorda(new ArrayList<>(
            Arrays.asList(new Orc(), new Orc(), new Orc())
        ));
        // Assert
        assertEquals(esperado, exercito.getOrdemDoUltimoAtaque());
    }
}
