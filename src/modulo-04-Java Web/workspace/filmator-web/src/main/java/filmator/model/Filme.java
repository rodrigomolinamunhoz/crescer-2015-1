package filmator.model;

public class Filme {

	private String nome;
	private int faixaEtaria;
	private int anoLancamento;
	private String sipnose;
	private String imagem;
	private Genero genero;
	
	public int getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(int faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getSipnose() {
		return sipnose;
	}

	public void setSipnose(String sipnose) {
		this.sipnose = sipnose;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Filme(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
