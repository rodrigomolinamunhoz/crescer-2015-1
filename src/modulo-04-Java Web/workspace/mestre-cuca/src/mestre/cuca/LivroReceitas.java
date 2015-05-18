package mestre.cuca;

import java.util.List;

public interface LivroReceitas {
	void inserir(Receita receita);

	void atualizar(String nomeReceita, Receita receitaAtualizada);

	void excluir(String nomeReceita);

	List<Receita> getTodasReceitas();

	Receita buscaReceitaPeloNome(String nomeReceita);
}
