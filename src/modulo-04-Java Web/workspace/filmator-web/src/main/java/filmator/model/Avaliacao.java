package filmator.model;

public class Avaliacao {
	private int idAvaliacao;
	private int idFilme;
	private int codigoUsuario;
	private double nota;
	private double media;
	
	public Avaliacao(){
		
	}
	
	public Avaliacao(int idFilme, double nota, int codigoUsuario){
		this.idFilme = idFilme;
		this.nota = nota;
		this.codigoUsuario = codigoUsuario;
	}

	public int getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(int idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public int getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

}
