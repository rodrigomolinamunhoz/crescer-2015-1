package Filmator.Teste;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import Filmator.Empresa;
import Filmator.Filme;
import Filmator.Genero;

public class testaEmpresa {

	@Test
	public void empresaAdicionaUmFilmeAoAcervo() {
		Filme filme1 = new Filme("Star Wars I",Genero.FICCAO);
		
		Empresa empresa = new Empresa();
		ArrayList<Filme> esperado = new ArrayList<Filme>();
		
		empresa.adicionarAoAcervo(filme1);
		
		esperado.add(filme1);

		assertEquals(esperado, empresa.getListaAcervoFilmes());
	}
	
	@Test
	public void empresaReproduzUmFilme(){
		Filme filme1 = new Filme("Star Wars I",Genero.FICCAO);
		Empresa empresa = new Empresa();
		HashMap<Genero, ArrayList<Filme>> esperado = new HashMap<Genero, ArrayList<Filme>>();
		
		empresa.adicionarAoAcervo(filme1);
		empresa.reproduzirFilme(filme1);
		esperado.put(filme1.getGenero(), new ArrayList<Filme>(Arrays.asList(filme1)));
		
		assertEquals(esperado, empresa.getListaReproduzidos());
	}
	
	@Test
	public void empresaGeraUmRelatorioComCincoReproduzidos(){
		Filme filme1 = new Filme("Star Wars I",Genero.FICCAO);
		Filme filme2 = new Filme("Star Wars II",Genero.FICCAO);
		Empresa empresa = new Empresa();
		HashMap<Genero, ArrayList<Filme>> esperado = new HashMap<Genero, ArrayList<Filme>>();
		
		empresa.adicionarAoAcervo(filme1);
		empresa.adicionarAoAcervo(filme2);

		
		empresa.reproduzirFilme(filme1);
		empresa.reproduzirFilme(filme2);

		
		esperado.put(filme1.getGenero(), new ArrayList<Filme>(Arrays.asList(filme1)));
		esperado.get(filme2.getGenero()).add(filme2);

		
		assertEquals("FICCAO - 2",  empresa.gerarRelatorio());
	}

	
}
