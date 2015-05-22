package mestre.cuca;

public class Ingrediente {
	private String nomeIngrediente;
	private double quantidade;
	private UnidadeMedida unidadeMedida;
	private double valor;

	public Ingrediente(String nomeIngrediente, double quantidade,
			UnidadeMedida unidadeMedida, double valor) {
		this.nomeIngrediente = nomeIngrediente;
		this.quantidade = quantidade;
		this.unidadeMedida = unidadeMedida;
		this.valor = valor;
	}

	public Ingrediente(String nomeIngrediente, UnidadeMedida unidadeMedida) {
		this.nomeIngrediente = nomeIngrediente;
		this.unidadeMedida = unidadeMedida;
	}

	public String getNomeIngrediente() {
		return nomeIngrediente;
	}

	public void setNomeIngrediente(String nomeIngrediente) {
		this.nomeIngrediente = nomeIngrediente;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomeIngrediente == null) ? 0 : nomeIngrediente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		if (nomeIngrediente == null) {
			if (other.nomeIngrediente != null)
				return false;
		} else if (!nomeIngrediente.equals(other.nomeIngrediente))
			return false;
		return true;
	}

}
