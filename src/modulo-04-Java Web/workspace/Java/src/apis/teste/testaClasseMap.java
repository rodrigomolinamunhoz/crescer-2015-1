package apis.teste;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class testaClasseMap {

	@Test
	public void testaGet() {
		Map<String, Integer> texto = new HashMap<String, Integer>();
		texto.put("Rodrigo", 1);
		texto.put("Molina", 2);
		Integer esperado = 1;
		assertEquals(esperado, texto.get("Rodrigo"));
	}

	@Test
	public void testaPut() {
		Map<String, Integer> texto = new HashMap<String, Integer>();
		texto.put("Rodrigo", 1);
		Map<String, Integer> esperado = new HashMap<String, Integer>();
		esperado.put("Rodrigo", 1);
		assertEquals(esperado, texto);
	}

	@Test
	public void testaContainsKey() {
		Map<String, Integer> texto = new HashMap<String, Integer>();
		texto.put("Rodrigo", 1);
		texto.put("Molina", 2);
		texto.put("Munhoz", 3);
		boolean esperado = false;
		assertEquals(esperado, texto.containsKey("Ricardo"));
	}

	@Test
	public void containsValueTest() {
		Map<String, Integer> texto = new HashMap<String, Integer>();
		texto.put("Rodrigo", 1);
		texto.put("Molina", 2);
		texto.put("Munhoz", 3);
		boolean esperado = false;
		assertEquals(esperado, texto.containsValue(4));
	}

}
