package br.com.fiap.fintech.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testeDeConexao {
	
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM95249",
					"060491");
			
			System.out.println("Conected!");
			
			Statement stmt = conexao.createStatement();
			stmt.executeUpdate(
					"INSERT INTO T_FIN_PESSOA (ID_PESSOA, NM_PESSOA, NR_RG, NR_CPF, DT_NASCIMENTO ) "
					+ " VALUES (SEQ_F_PESSOA.NEXTVAL, 'PAULA', '200', '300', to_date('20/03/2022', 'dd/mm/yyyy'))");
			
			String sqlUpdate = "UPDATE T_FIN_PESSOA SET NM_PESSOA = 'MIGUEL' WHERE ID_PESSOA = 1";
			stmt.executeUpdate(sqlUpdate);
			
			ResultSet result = stmt.executeQuery("SELECT * FROM T_FIN_PESSOA");
			
			while (result.next()) {
				System.out.println( result.getInt("ID_PESSOA") + " " +
									result.getString("NM_PESSOA") + " " + 
									result.getString("NR_RG") + " " + 
									result.getString("NR_CPF") + " " + 
									result.getDate("DT_NASCIMENTO")   );
			}
			
			String sqlDelete = "DELETE FROM T_FIN_PESSOA WHERE ID_PESSOA = 6";
			stmt.executeUpdate(sqlDelete);
			
			
			conexao.close();
		
		
		} catch (SQLException e) {
			System.err.println("NAO conecta essa merda mesmo erro do outro");
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			System.err.println("O DRIVER NAO FOI ENCONTRADO!!!");
		}
	}


}
