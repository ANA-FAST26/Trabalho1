public class Medalha {

	private int codigo;

	private int tipo;

	private boolean individual;

	private String modalidade;

	public Medalha(int codigo, int tipo, boolean individual, String modalidade) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.individual = individual;
		this.modalidade = modalidade;
	}
	public int getCodigo() {
		return codigo;
	}
	public int getTipo(){
		return tipo;
	}
	public boolean isIndividual() {
		return individual;
	}
	public String getModalidade() {
		return modalidade;
	}

	public void adicionaAtleta(Atleta atleta) {

	}

}
