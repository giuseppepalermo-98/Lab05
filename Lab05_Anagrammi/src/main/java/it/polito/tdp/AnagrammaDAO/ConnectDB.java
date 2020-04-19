package it.polito.tdp.AnagrammaDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root&password=root";

	public static Connection getConnection() {

		try {
				Connection connection = DriverManager.getConnection(jdbcUrl);
				return connection;

		} catch (SQLException e) {
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}
}
