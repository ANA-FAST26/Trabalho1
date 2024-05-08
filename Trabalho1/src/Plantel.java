import java.util.ArrayList;
import java.util.Collection;

public class Plantel {

	private ArrayList<Atleta> atletas;

	public Plantel() {
		atletas = new ArrayList<Atleta>();
	} //construtor

	public boolean cadastraAtleta(Atleta atleta){// Valida se o atleta existe e se for TRUE cadastra um atleta.
		int numero = atleta.getNumero();
		if(consultaAtleta(numero)==null){
			return atletas.add(atleta); //Essa parte do cod. esta add o atleta ao ArrayList de ATLETAS.
		}
		return false;
	}
	public Atleta consultaAtleta(String nome) {
		for (Atleta aux : atletas) {//Atleta aux serve para comparar o AUX com o valor do ArrayList -
			if (aux.getNome().equals(nome)) {//So vai entrar neste if, se o Atleta tiver o mesmo nome recebido por parâmetro
				return aux;
			}
		}
		return null;
	}
	public Atleta consultaAtleta(int numero) {
		for (Atleta aux: atletas) {
			if (aux.getNumero() == numero){
				return aux;
			}

		}
		return null;
	}

	//Método que retorna todos os atletas de um determinado país
	public ArrayList<Atleta> consultaAtletas(String pais){
		ArrayList<Atleta> auxAtletas = new ArrayList<>();
		if(!atletas.isEmpty()){
			for (Atleta aux: atletas) {
				if(aux.getPais().equals(pais)){
					auxAtletas.add(aux);
				}
			}
			return auxAtletas;
		}
		return null;
	}

	public ArrayList<Atleta> consultaAtletasPorTipo(int tipo) {
		ArrayList<Atleta> auxAtletas = new ArrayList<>();
		if(!atletas.isEmpty()) {
			for (int i = 0; i < atletas.size(); i++) {
				if (atletas.get(i).getMedalhas().get(i).getTipo() == tipo) {
					auxAtletas.add(atletas.get(i));
				}
			}
			return auxAtletas;
		}
		return null;
	}

	public ArrayList<Atleta> consultaAtletasPorModalidade(String modalidade) {
		ArrayList<Atleta> auxAtletas = new ArrayList<>();
		if(!atletas.isEmpty()) { //Verificando se o ArrayList de medalhas não esta vazio.
			for (int i =0; i<atletas.size(); i++){
				if (atletas.get(i).getMedalhas().get(i).getModalidade().equals(modalidade)){
					auxAtletas.add(atletas.get(i)); //Todas as medalhas que forem iguais a
				}									 //modalidade passada por parametro, serão add a
			}										//este ArrayList auxiliar do tipo Medalhas.
			return auxAtletas;
		}
		return null;
	}






}


//	public ArrayList<Atleta> consultaAtletas(String pais) {
//		ArrayList<Atleta> auxAtletas = new ArrayList<>();
//		if(!atletas.isEmpty()) { //Verificando se o ArrayList de medalhas não esta vazio.
//			for (int i =0; i<atletas.size(); i++){
//				if (atletas.get(i).getPais().equals(pais)){
//					auxAtletas.add(atletas.get(i)); //Todas as medalhas que forem iguais a
//				}									 //modalidade passada por parametro, serão add a
//			}										//este ArrayList auxiliar do tipo Medalhas.
//		}
//		return null;
//	}

