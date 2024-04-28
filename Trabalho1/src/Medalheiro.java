import java.util.Collection;
import java.util.ArrayList;

public class Medalheiro {

	private ArrayList<Medalha> medalhas;
//encapsulamento método	 tipo	nome da variável

	public Medalheiro(){
		medalhas = new ArrayList<>(); // Criei o ArrayList
	}

	public boolean cadastraMedalha(Medalha medalha) {
		int codigo = medalha.getCodigo();
		if(consultaMedalha(codigo)==null){
			return medalhas.add(medalha);
		}
		return false;
	}

	public Medalha consultaMedalha(int codigo){
		for (int i = 0; i < medalhas.size(); i++) { //Primeiro o nome da variavel e depois o .nomeDoMetodo();
			if(medalhas.get(i).getCodigo()==codigo){
				return medalhas.get(i);
			}
		}
		return null;
	}

	public ArrayList<Medalha> consultaMedalha(String modalidade) {
		ArrayList<Medalha> auxMedalhas = new ArrayList<>();
		if(!medalhas.isEmpty()) { //Verificando se o ArrayList de medalhas não esta vazio.
			for (int i =0; i<medalhas.size(); i++){
				if (medalhas.get(i).getModalidade().equals(modalidade)){
					auxMedalhas.add(medalhas.get(i)); //Todas as medalhas que forem iguais a
				}									 //modalidade passada por parametro, serão add a
			}										//este ArrayList auxiliar do tipo Medalhas.
		}
		return null;
	}

}
