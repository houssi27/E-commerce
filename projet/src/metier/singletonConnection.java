package metier;

import java.sql.Connection;
import java.sql.DriverManager;

public class singletonConnection {
	private static Connection connection;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/GL1", "root", "root" );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return connection;
	}
}
