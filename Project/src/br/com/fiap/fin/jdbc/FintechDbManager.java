package br.com.fiap.fin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class FintechDbManager {

	public static Connection obterConexao() {
		Connection connection = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "FINTECH",
					"K123");

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}
