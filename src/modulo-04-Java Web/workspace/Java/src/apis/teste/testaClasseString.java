package apis.teste;

import static org.junit.Assert.*;

import org.junit.Test;

public class testaClasseString {

	@Test
	public void testeIndexOf() {
		String texto = "micro";
		int indice = texto.indexOf("m");
		assertEquals(0, indice);
	}

	@Test
	public void testeReplace() {
		String texto = "micro";
		String indice = texto.replace('m', 'M');
		assertEquals("Micro", indice);
	}

	@Test
	public void splitTest() {
		String texto = "Rodrigo Molina";
		String[] esperado = { "Rodrigo", "Molina" };
		assertEquals(esperado, texto.split(" "));

	}

}
