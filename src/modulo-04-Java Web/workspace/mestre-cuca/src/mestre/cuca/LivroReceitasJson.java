package mestre.cuca;

import java.util.*;


public class LivroReceitasJson implements LivroReceitas {
	
	private static final String jsonFilePath="C:\\Users\\nikos7\\Desktop\\filesForExamples\\jsonFile.json";

	public static void main(String[] args) {

		LivroReceitas student = new LivroReceitas();

		Gson gson = new Gson();

		String jsonRepresentation = gson.toJson(student);

		try {

			FileWriter Filewriter = new FileWriter(jsonFilePath);
			Filewriter.write(jsonRepresentation);
			Filewriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(jsonRepresentation);

	}
 

	@Override
	public void inserir(Receita receita) {	
	}

	@Override
	public void atualizar(String nomeReceita, Receita receitaAtualizada) {	
	}

	@Override
	public void excluir(String nomeReceita) {		
	}

	@Override
	public List<Receita> getTodasReceitas() {
		return null;
	}

	@Override
	public Receita buscaReceitaPeloNome(String nomeReceita) {
		return null;
	}
	
}
