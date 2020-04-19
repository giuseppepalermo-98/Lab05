package it.polito.tdp.AnagrammaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDao {

	
	public boolean isCorrect(String anagramma) {
		
		String sql="SELECT * FROM parola WHERE nome= ? ";
		boolean result=false;
		try {
			Connection conn=ConnectDB.getConnection();
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, anagramma);
			
			ResultSet rs= st.executeQuery();
			
			while(rs.next()) {
				result=true;
			}
			
			conn.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
}
