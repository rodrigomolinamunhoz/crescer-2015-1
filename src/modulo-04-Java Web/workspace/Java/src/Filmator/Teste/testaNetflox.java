package Filmator.Teste;

import static org.junit.Assert.*;

import java.util.*;


import org.junit.Test;

import Filmator.Filme;
import Filmator.Genero;
import Filmator.Netflox;

public class testaNetflox {

	@Test
	public void netfloxAdicionaUmFilmeAoAcervo() {
		Filme filme1 = new Filme("Star Wars I",Genero.FICCAO);
		
		Netflox netflox = new Netflox();
		ArrayList<Filme> esperado = new ArrayList<Filme>();
		
		netflox.adicionarAoAcervo(filme1);
		
		esperado.add(filme1);

		assertEquals(esperado, netflox.getListaAcervoFilmes());
	}
	
	@Test
	public void netfloxReproduzUmFilme(){
		Filme filme1 = new Filme("Star Wars I",Genero.FICCAO);
		Netflox netflox = new Netflox();
		HashMap<Genero, ArrayList<Filme>> esperado = new HashMap<Genero, ArrayList<Filme>>();
		
		netflox.adicionarAoAcervo(filme1);
		netflox.reproduzirFilme(filme1);
		esperado.put(filme1.getGenero(), new ArrayList<Filme>(Arrays.asList(filme1)));
		
		assertEquals(esperado, netflox.getListaReproduzidos());
	}
	
	@Test
	public void netfloxGeraUmRelatorioComCincoReproduzidos(){
		Filme filme1 = new Filme("Star Wars I",Genero.FICCAO);
		Filme filme2 = new Filme("Star Wars II",Genero.FICCAO);
		Netflox netflox = new Netflox();
		HashMap<Genero, ArrayList<Filme>> esperado = new HashMap<Genero, ArrayList<Filme>>();
		
		netflox.adicionarAoAcervo(filme1);
		netflox.adicionarAoAcervo(filme2);

		
		netflox.reproduzirFilme(filme1);
		netflox.reproduzirFilme(filme2);

		
		esperado.put(filme1.getGenero(), new ArrayList<Filme>(Arrays.asList(filme1)));
		esperado.get(filme2.getGenero()).add(filme2);

		
		assertEquals("FICCAO - 2",  netflox.gerarRelatorio());
	}

	
}
