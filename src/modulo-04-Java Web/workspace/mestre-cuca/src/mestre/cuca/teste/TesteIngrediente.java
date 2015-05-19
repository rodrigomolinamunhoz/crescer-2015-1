package mestre.cuca.teste;

import static org.junit.Assert.*;

import java.util.*;

import mestre.cuca.Ingrediente;
import mestre.cuca.Receita;
import mestre.cuca.UnidadeMedida;

import org.junit.Test;




public class TesteIngrediente {

	@Test
	public void testeAdicionaIngredientesNaReceita() {
		Ingrediente ingre = new Ingrediente("Tomate", 200.0, UnidadeMedida.GRAMA, 1.50);
		Receita receita = new Receita("Salada");
		
		receita.adicionaIngredientesReceita(ingre);
		
		List<Ingrediente> listaIngredienteEsperado = new ArrayList<Ingrediente>();
		listaIngredienteEsperado.add(ingre);

		assertEquals(listaIngredienteEsperado, receita.getListaIngredientes());
	}

}
