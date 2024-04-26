public class Atleta {

	private int numero;

	private String nome;

	private String pais;

	public Atleta(int numero, String nome, String pais){ //método construtor
		this.numero = numero;
		this.nome = nome;
		this.pais = pais;
	}
	public int getNumero() {
		return numero;
	}
	public String getNome() {
		return nome;
	}

	public void adicionaMedalha(Medalha medalha) {}

	public int consultaQuantidadeMedalhas() {
		return 0;
	}
}
