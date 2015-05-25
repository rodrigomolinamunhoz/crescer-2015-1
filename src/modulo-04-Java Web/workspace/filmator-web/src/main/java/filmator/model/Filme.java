package filmator.model;

public class Filme {

	private String nome;
	private String faixaEtaria;
	private String anoLancamento;
	private String sinopse;
	private String imagem;
	private Genero genero;

	public Filme() {
	}

	public Filme(String nome) {
		this.nome = nome;
	}
	
	public Filme(String nome, String faixaEtaria, String anoLancamento, String sinopse, String imagem, Genero genero) {
		this.nome = nome;
		this.faixaEtaria = faixaEtaria;
		this.anoLancamento = anoLancamento;
		this.sinopse = sinopse;
		this.imagem = imagem;
		this.genero = genero;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(String faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}
}
