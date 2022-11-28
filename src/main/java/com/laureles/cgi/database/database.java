package com.laureles.cgi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

@Component
public class database {
	
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/cgi_database?useSSl=false&serverTimezone=UTC&useLegacyDatetimecode=false";
	private final String USERNAME = "root";
	private final String PASSWORD = "root";
	
	public Connection connection = null;
	
	public database() {
		try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);			
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery(String query) {
		if(connection != null) {
			Statement statement = null;
			try {
				statement = connection.createStatement();
				return statement.executeQuery(query);
			} catch(SQLException e){
				e.printStackTrace();
			}
			
		}
		return null;
	}

}
