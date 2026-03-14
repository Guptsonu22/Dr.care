package dba;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	public static Connection getConnection()
	{
		Connection con=null;
		try {
			// Environment variables for Cloud Deployment
			String envUrl = System.getenv("DB_URL");
			String envUser = System.getenv("DB_USER");
			String envPass = System.getenv("DB_PASS");

			// Use Environment variables if they exist, otherwise use Local settings
			String url = (envUrl != null) ? envUrl : "jdbc:mysql://localhost:3306/dcare";
			String user = (envUser != null) ? envUser : "root";
			String pass = (envPass != null) ? envPass : "Root@1234";

			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, pass);
	
		} catch (Exception e) {
			System.out.println("Database Connection Error: " + e.getMessage());
		}
		return con;
	}

	}
