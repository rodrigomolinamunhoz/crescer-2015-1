package filmator.model;

public enum Genero {

	ACAO("Ação"), AVENTURA("Aventura"), FICCAO("Ficção"), COMEDIA("Comédia"), DESENHO("Desenho"), SUSPENCE("Suspense");

	private String descricao;

	private Genero(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
