import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ACMESports {

	private Medalheiro medalheiro;

	private Plantel plantel;
	private Scanner entrada;
	private PrintStream saidaPadrao = System.out;

	public ACMESports() {
		try {
			BufferedReader streamEntrada = new BufferedReader(new FileReader("dadosin.txt"));
			entrada = new Scanner(streamEntrada);   // Usa como entrada um arquivo
			PrintStream streamSaida = new PrintStream(new File("dadosout.txt"), Charset.forName("UTF-8"));
			System.setOut(streamSaida);             // Usa como saida um arquivo
		} catch (Exception e) {
			System.out.println(e);
		}
		Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
		entrada.useLocale(Locale.ENGLISH);
		medalheiro = new Medalheiro();
		plantel = new Plantel();
	}

	public void executar() {
		cadastraAtleta(); //1
		cadastraMedalhas(); //2
		cadastraMedalhasEAtletas(); //3
		mostraAtletaPorNumero(); //4
		mostraAtletaPorNome(); //5
		mostraMedalha(); //6
		mostraAtletaPorPais(); //7
		mostraAtletaPorMedalha(); //8
		mostraAtletaPorModalidade(); //9
//		mostraAtletaComMaisMedalhas(); //10
	}

	// Método 1 para cadastrar um atleta.
	private void cadastraAtleta() {
		int numero;
		String nome;
		String pais;
		Atleta atleta;
		numero = entrada.nextInt(); //Lê a entrada e atribui a variavel numero.
		entrada.nextLine(); //Limpeza de Buffer
		while (numero != -1) { //Se o valor da variavel numero for Diferente de -1 entra no loop while.
			nome = entrada.nextLine();
			pais = entrada.nextLine();
			atleta = new Atleta(numero, nome, pais);
			if (plantel.cadastraAtleta(atleta)) {
				System.out.println("1:" + numero + "," + nome + "," + pais);
			}
			numero = entrada.nextInt();
		}
	}

	// Método 2 para cadastrar uma medalha.
	private void cadastraMedalhas() {
		int codigo;
		int tipo;
		boolean individual;
		String modalidade;
		Medalha medalha;
		codigo = entrada.nextInt();
		while (codigo != -1) {
			tipo = entrada.nextInt();
			entrada.nextLine(); // Limpar o Buffer.
			individual = entrada.nextBoolean();
			entrada.nextLine(); // Limpar o Buffer.
			modalidade = entrada.nextLine();
			medalha = new Medalha(codigo, tipo, individual, modalidade);
			if (medalheiro.cadastraMedalha(medalha)) {
				System.out.println("2:" + codigo + "," + tipo + "," + individual + "," + modalidade);
			}
			codigo = entrada.nextInt();
			entrada.nextLine();
		}
	}

	// Método 3 para atribuir uma medalha a um atleta e vice-versa.
	private void cadastraMedalhasEAtletas() {
		int codigo;
		int numero;
		Medalha medalha;
		Atleta atleta;
		codigo = entrada.nextInt();
		while(codigo != -1){
			numero = entrada.nextInt();
			medalha = medalheiro.consultaMedalha(codigo);
			atleta = plantel.consultaAtleta(numero);
			medalha.adicionaAtleta(atleta);
			atleta.adicionaMedalha(medalha);
			System.out.println("3:" + medalha.getCodigo() + "," + atleta.getNumero());
			codigo = entrada.nextInt();
			entrada.nextLine();
		}
	}

	// Método 4 para mostrar um atleta pesquisando por número.
	private void mostraAtletaPorNumero() {
		int numero;
		Atleta atleta; //variavel local
		// Ler, significa que estamos recebendo um dado, seja por terminal ou por leitura de arquivos
		// Ou seja, leitura está relacionada com o Scanner.
		numero = entrada.nextInt();
		entrada.nextLine();
		atleta = plantel.consultaAtleta(numero);
		if (atleta != null) {
			System.out.println("4:" + numero + "," + atleta.getNome() + "," + atleta.getPais());
		} else {
			System.out.println("4:Nenhum atleta encontrado.");
		}
	}

	// Método 5 mostra um atleta pesquisando por nome.
	private void mostraAtletaPorNome() {
		String nome;
		Atleta atleta;
		nome = entrada.nextLine();
		atleta = plantel.consultaAtleta(nome);
		if (atleta != null) {
			System.out.println("5:" + atleta.getNumero() + "," + atleta.getNome() + "," + atleta.getPais());
		} else {
			System.out.println("5:Nenhum atleta encontrado.");
		}
	}

	// Método 6 mostra uma medalha pesquisando por código.
	private void mostraMedalha() {
		int codigo;
		Medalha medalha;
		codigo = entrada.nextInt();
		entrada.nextLine();
		medalha = medalheiro.consultaMedalha(codigo);
		if (medalha != null) {
			System.out.println("6:" + codigo + "," + medalha.getTipo() + "," + medalha.isIndividual() + "," + medalha.getModalidade());
		} else {
			System.out.println("6:Nenhum medalha encontrado.");
		}
	}

	// Método 7 mostra um atleta pesquisando por país.
	private void mostraAtletaPorPais(){
		String pais;
		Atleta atleta;
		ArrayList<Atleta> auxAtletas;
		pais = entrada.nextLine();
		auxAtletas = plantel.consultaAtletas(pais);
		if (auxAtletas.isEmpty()){
			System.out.println("7:Pais nao encontrado.");
		}else{
			for (Atleta aux:auxAtletas) {
				System.out.println("7:" + aux.getNumero() + "," + aux.getNome() + "," + aux.getPais());
			}
		}
	}

	//	 Método 8 mostra um atleta pesquisando por medalha.
	private void mostraAtletaPorMedalha() {
		int tipo;
		ArrayList<Atleta> auxAtletas;
		tipo = entrada.nextInt();
		auxAtletas = plantel.consultaAtletasPorTipo(tipo);
		if (auxAtletas.isEmpty()){
			System.out.println("8:Nenhum atleta encontrado.");
		}else{
			for (Atleta aux:auxAtletas) {
				System.out.println("8:" + aux.getNumero() + "," + aux.getNome() + "," + aux.getPais());
			}
		}


	}

	//Método 9 mostra atleta pesquisando por modalidade.
	private void mostraAtletaPorModalidade() {
		String modalidade;

	}
}



//	private void mostraAtletaPorPais() {
//		String pais;
//		ArrayList<Atleta> atletasAux;
//		pais = entrada.nextLine();
//		atletasAux = plantel.consultaAtletas(pais);
//		if (atletasAux.size() != 0) {
//			for (int i = 0; i < atletasAux.size(); i++) {
//				System.out.println("7:" + atletasAux.get(i).getNumero() + "," + atletasAux.get(i).getNome() + "," + atletasAux.get(i).getPais());
//			}
//		} else {
//			System.out.println("7:Pais não encontrado.");
//		}
//	}


// Método 8 mostra um atleta pesquisando por medalha.
//	private void mostraAtletaPorMedalha() {
//		String tipo;
//		tipo = entrada.nextLine();
//		ArrayList<Atleta> atletasAux;
//		atletasAux = plantel.consultaAtletasPorTipo(tipo);
//		if(atletasAux.size()!=0) {
//			for (Atleta aux : atletasAux) {
//				System.out.println("8:" + aux.getNumero() + "," + aux.getNome() + "," + aux.getPais());
//			}
//		}else{
//			System.out.println("8:Nenhum atleta encontrado.");
//		}
//	}
