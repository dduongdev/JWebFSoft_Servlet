package com.dduongdev.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnector {
	private static DbConnector instance;
	private Connection connection;

	private DbConnector() {
		Properties properties = new Properties();

		try {
			properties.load(DbConnector.class.getResourceAsStream("/dbConfig.properties"));
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");

			Class.forName(driver);

			connection = DriverManager.getConnection(url, username, password);
		} catch (IOException | ClassNotFoundException | SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static DbConnector getInstance() throws SQLException {
		if (instance == null || instance.getConnection().isClosed()) {
			instance = new DbConnector();
		}

		return instance;
	}
}
