package mestre.cuca.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import mestre.cuca.Ingrediente;
import mestre.cuca.Receita;
import mestre.cuca.UnidadeMedida;

import org.junit.Test;

public class TesteReceita {

	@Test
	public void testeCalculaValorTotalReceita() {
		Ingrediente ingre = new Ingrediente("Tomate", 200.0,
				UnidadeMedida.GRAMA, 1.5);
		Ingrediente ingre2 = new Ingrediente("Tomate2", 200.0,
				UnidadeMedida.GRAMA, 1.5);
		Receita receita = new Receita("Salada");
		receita.adicionaIngredientesReceita(ingre);
		receita.adicionaIngredientesReceita(ingre2);

		List<Ingrediente> listaIngrediente = new ArrayList<Ingrediente>();
		listaIngrediente.add(ingre);
		listaIngrediente.add(ingre2);

		double esperado = 3.0;

		assertEquals(esperado,
				receita.calculaValorTotalReceita(), 0);
	}
}
