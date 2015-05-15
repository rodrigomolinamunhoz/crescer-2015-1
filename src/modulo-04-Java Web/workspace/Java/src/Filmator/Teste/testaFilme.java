package Filmator.Teste;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import Filmator.Ator;
import Filmator.Filme;

public class testaFilme {

	@Test
	public void filmeInsereUmAtor(){
		Ator atorUm = new Ator("Harrion Ford");
		Filme filme = new Filme();
		filme.inserirAtor(atorUm);
		ArrayList<Ator> elencoEsperado = new ArrayList<Ator>();
		elencoEsperado.add(atorUm);
		assertEquals(elencoEsperado,filme.getElenco());
	}
	
	@Test
	public void filmeProcuraListaAtor(){
		Ator atorUm = new Ator("Harrion Ford");
		Filme filme = new Filme();
		filme.inserirAtor(atorUm);
		ArrayList<Ator> esperado = new ArrayList<Ator>();
		esperado.add(atorUm);
		assertEquals(esperado, filme.procuraAtoresElenco("Harrion Ford"));

	}

}
