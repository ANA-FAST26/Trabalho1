import java.util.ArrayList;
import java.util.Collection;

public class Plantel {

	private ArrayList<Atleta> atletas;

	public Plantel() {
		atletas = new ArrayList<Atleta>();
	}

	public boolean cadastraAtleta(Atleta atleta) {
		return false;
	}

	public Atleta consultaAtleta(String nome) {
		//for (Atleta aux : atletas) {//Atleta aux serve para comparar o AUX com o valor do ArrayList -
		for (int i = 0; i < atletas.size(); i++) {
			if (atletas.get(i).getNome().equals(nome)) {//So vai entrar neste if, se o Atleta tiver o mesmo nome recebido por parâmetro
				return atletas.get(i);
			}
		}
		return null;
	}

	public Atleta consultaAtleta(int numero) {

		for (int i = 0; i < atletas.size(); i++) {
			if (atletas.get(i).getNumero() == numero) {
				return atletas.get(i);

			}
		}
		return null;
	}
}

