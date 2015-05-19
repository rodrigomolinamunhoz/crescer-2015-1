package mestre.cuca.teste;

import mestre.cuca.Principial;

import org.junit.Test;


public class TestePrincipal {

	@Test(expected = NullPointerException.class)
	public void buscaNomeReceitaInexistente() throws NullPointerException {
		Principial livro = new Principial();
		livro.buscaReceitaPeloNome("iuhiuhiu");
	}

}
