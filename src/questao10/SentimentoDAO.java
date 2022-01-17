package questao10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SentimentoDAO {

	private Connection connection;
	
	public SentimentoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvarSentimento(Sentimento sentimento) throws SQLException {
		String sql = "INSERT INTO SENTIMENTO (MENSAGEM) VALUES (?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, sentimento.getMensagem());

			pstm.execute();

		}
	}
	
	public List<Sentimento> listar() throws SQLException{
		List<Sentimento> sentimentos = new ArrayList<Sentimento>();
		
		String sql = "SELECT ID, MENSAGEM FROM SENTIMENTO";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					Sentimento sentimento = new Sentimento(rst.getInt(1), rst.getString(2));
					
					sentimentos.add(sentimento);
				}
			}
		}
		return sentimentos;
		
	}
}