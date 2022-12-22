package br.com.fin.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

			private static ConnectionManager instance;
			
			private ConnectionManager() {}
			
			public static ConnectionManager getInstance() {
				if (instance == null) {
					instance = new ConnectionManager();
				}
				return instance;
			}
			
			public Connection getConnection() {
				Connection conexao = null;
				try {
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "FINTECH",
							"K123");
				}catch (Exception e) {
					e.printStackTrace();
				}
				return conexao;
			}
}



