package mestre.cuca.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mestre.cuca.Ingrediente;
import mestre.cuca.Principial;
import mestre.cuca.Receita;
import mestre.cuca.UnidadeMedida;

import org.junit.Test;

public class TestePrincipal {

	@Test(expected = NullPointerException.class)
	public void buscaNomeReceitaInexistente() throws NullPointerException {
		Principial livro = new Principial();
		livro.buscaReceitaPeloNome("iuhiuhiu");
	}

	@Test
	public void testeSomaTotasReceitas() {
		Principial pri = new Principial();
		Receita receita = new Receita("Salada");
		Ingrediente ingre = new Ingrediente("Tomate", 200.0,
				UnidadeMedida.GRAMA, 1.5);
		Ingrediente ingre2 = new Ingrediente("Tomate2", 200.0,
				UnidadeMedida.GRAMA, 1.5);

		Ingrediente ingre3 = new Ingrediente("Queijo", 200.0,
				UnidadeMedida.GRAMA, 7.0);
		Ingrediente ingre4 = new Ingrediente("Queijo", 200.0,
				UnidadeMedida.GRAMA, 7.0);
		Receita receita2 = new Receita("Pizza");

		receita.adicionaIngredientesReceita(ingre);
		receita.adicionaIngredientesReceita(ingre2);
		receita2.adicionaIngredientesReceita(ingre3);
		receita2.adicionaIngredientesReceita(ingre4);

		List<Receita> listaReceita = new ArrayList<Receita>();
		listaReceita.add(receita);
		listaReceita.add(receita2);

		double esperado = 17.0;

		assertEquals(esperado, pri.somaTotasReceitas(listaReceita), 0);
	}

	@Test
	public void testeProtecaoAlergicos() {
		Principial pri = new Principial();
		Receita receita2 = new Receita("Arroz");
		Receita receita = new Receita("Salada");

		Ingrediente ingre = new Ingrediente("Tomate", 200.0,
				UnidadeMedida.GRAMA, 1.5);
		Ingrediente ingre2 = new Ingrediente("Queijo", 200.0,
				UnidadeMedida.GRAMA, 7.0);
		Ingrediente ingre3 = new Ingrediente("Arroz", 500.0,
				UnidadeMedida.GRAMA, 5.0);
		List<Receita> listaReceitaEsperada = new ArrayList<Receita>();
		List<Ingrediente> listaIngredientesAlergico = new ArrayList<Ingrediente>();

		listaIngredientesAlergico.add(ingre3);
		listaReceitaEsperada.add(receita2);

		pri.inserir(receita);
		pri.inserir(receita2);

		receita2.adicionaIngredientesReceita(ingre);
		receita2.adicionaIngredientesReceita(ingre2);

		receita.adicionaIngredientesReceita(ingre);
		receita.adicionaIngredientesReceita(ingre2);
		receita.adicionaIngredientesReceita(ingre3);

		assertEquals(listaReceitaEsperada,
				pri.protecaoAlergicos(listaIngredientesAlergico));
	}

	@Test
	public void testeGeraListaDeCompras() {
		Principial pri = new Principial();

		Receita receita = new Receita("Salada");
		Ingrediente alface = new Ingrediente("Alface", 200.0,
				UnidadeMedida.GRAMA, 1.5);
		Ingrediente tomate = new Ingrediente("Tomate", 200.0,
				UnidadeMedida.GRAMA, 7.0);
		receita.adicionaIngredientesReceita(alface);
		receita.adicionaIngredientesReceita(tomate);
		pri.inserir(receita);

		Receita receita2 = new Receita("Arroz e Salada");
		Ingrediente arroz = new Ingrediente("Arroz", 200.0,
				UnidadeMedida.GRAMA, 1.5);
		Ingrediente tomate2 = new Ingrediente("Tomate", 200.0,
				UnidadeMedida.GRAMA, 7.0);
		receita2.adicionaIngredientesReceita(arroz);
		receita2.adicionaIngredientesReceita(tomate2);
		pri.inserir(receita2);

		Map<String, Double> listaDeCompras = pri.geraListaDeCompras(Arrays
				.asList(receita, receita2));

		assertEquals(3, listaDeCompras.size());
		assertTrue(listaDeCompras.containsKey(new Ingrediente("Alface", UnidadeMedida.GRAMA)));
		assertTrue(listaDeCompras.containsKey(new Ingrediente("Arroz",	UnidadeMedida.GRAMA)));
		assertTrue(listaDeCompras.containsKey(new Ingrediente("Tomate", UnidadeMedida.GRAMA)));
	}

}
