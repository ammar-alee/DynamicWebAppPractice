package com.apex.advance.java.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static ConnectionManager instance = null;

	private Connection conn = null;

	private ConnectionManager() {
	}

	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}

	private boolean openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    String url = "jdbc:mysql://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public Connection getConnection() {
		if (conn == null) {
			if (openConnection()) {
				System.out.println("Connection Opened");
				return conn;
			} else {
				return null;
			}
		}
		return conn;
	}

	public void close() {
		System.out.println("Closing Connection");
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection Closed");
		conn = null;
	}
}
