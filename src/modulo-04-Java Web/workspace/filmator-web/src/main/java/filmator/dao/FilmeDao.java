package filmator.dao;

import java.util.Arrays;
import java.util.List;

import filmator.model.Filme;

public class FilmeDao {

	public List<Filme> buscaTodosFilmes(){
		//Imagina que estes dados estao vindo do banco
		return Arrays.asList(new Filme("O poderoso chefão"),
			new Filme("O poderoso chefão II"),
			new Filme("O poderoso chefão III"));
	}
}
 