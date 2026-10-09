package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
	private static final String URL="jdbc:mysql://localhost:3306/company_db3";
	private static final String USER="root";
	private static final String PASSWORD= "Himaja@28";
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}