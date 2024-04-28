import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
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
//		mostraAtletaPorNome(); //5
//		mostraMedalha(); //6
//		mostraAtletaPorPais(); //7
//		mostraAtletaPorMedalha(); //8
//		mostraAtletaPorModalidade(); //9
//		mostraAtletaComMaisMedalhas(); //10
	}


	private void cadastraAtleta() {
		int numero;
		String nome;
		String pais;
		Atleta atleta;
		numero = entrada.nextInt(); //Lê a entrada e atribui a variavel numero.
		entrada.nextLine(); //Limpeza de Buffer
		while(numero!= -1){ //Se o valor da variavel numero for Diferente de -1 entra no loop while.
			nome = entrada.nextLine();
			pais = entrada.nextLine();
			atleta = new Atleta (numero, nome, pais);
			if(plantel.cadastraAtleta(atleta)){
				System.out.println("1:" + numero +  "," + nome + "," + pais);
			}
			numero = entrada.nextInt();
		}
	}
}
