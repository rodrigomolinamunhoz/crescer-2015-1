package Filmator.Teste;

import static org.junit.Assert.*;

import org.junit.Test;

import Filmator.Ator;

public class testaAtor {

	@Test
	public void atorRetornNome() {
		Ator atorUm = new Ator("Harrison Ford");
		assertEquals("Harrison Ford", atorUm.getNome());
	}

}
