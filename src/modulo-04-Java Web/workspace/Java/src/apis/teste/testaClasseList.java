package apis.teste;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class testaClasseList {

	@Test
	public void testaGet() {
		List<String> texto = new ArrayList<String>();
		texto.add("Rodrigo");
		assertEquals("Rodrigo", texto.get(0));
	}

	@Test
	public void setTest() {
		List<String> texto = new ArrayList<String>();
		List<String> esperado = new ArrayList<String>();
		esperado.add("Rodrigo1");
		texto.add("Rodrigo");
		texto.set(0, "Rodrigo1");
		assertEquals(esperado, texto);
	}

	@Test
	public void indexOfTest() {
		List<String> texto = new ArrayList<String>();
		texto.add("Rodrigo1");
		texto.add("Rodrigo2");
		assertEquals(1, texto.indexOf("Rodrigo2"));
	}

}
