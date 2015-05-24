package filmator.dao;

public class FilmeNaoEncontradoException extends RuntimeException {
	public FilmeNaoEncontradoException(String nome) {
		super(String.format("Filme %s não encontado", nome));
	}
}
