package questao10;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TesteSentimento {

	public static void main(String[] args) throws SQLException {

		Scanner entrada = new Scanner(System.in);
		String mensagem = "";
		System.out.println("Digite a mensagem.");
		mensagem = entrada.next();
		
		String chateado = ":-(";
		String divertido = ":-)";
		int countDivertido = 0;
		int countChateado = 0;
		
		for(int i=0; i < mensagem.length(); i++) {
			if(mensagem.contains(":-)")) {
				countDivertido++;
			}
			if(mensagem.contains(":-(")) {
				countChateado++;
			}
		}
		
		switch((countDivertido > countChateado) ? 0 :
					(countDivertido < countChateado ? 1 : 2)) {
		case 0:
			System.out.println("Divertido.");
			break;
		case 1:
			System.out.println("Chateado.");
			break;
		case 2:
			System.out.println("Neutro.");
			break;
		}
		
		Sentimento sentimento = new Sentimento(mensagem);
		
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
		SentimentoDAO sentimentoDao = new SentimentoDAO(connection);
		sentimentoDao.salvarSentimento(sentimento);
		}

	}

}
