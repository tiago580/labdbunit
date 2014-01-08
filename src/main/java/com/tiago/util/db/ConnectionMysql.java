package com.tiago.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMysql{
	private static Connection connection;
	public static Connection getConnection() {
		
		if(connection == null)
			setConnection();		
		return connection;
	}
	
	private static void setConnection(){
		try {
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
			String serverName = "192.168.1.24"; 
			String database = "agenda";
			String url =  "jdbc:mysql://" + serverName + "/" + database;
			String username = "root";
			String password = "root";
			
			connection = DriverManager.getConnection(url, username, password);
			
			if(connection != null){
				System.out.println("conectado");
			}else{
				System.out.println("problema ao conectar");
			}
			

		} catch (ClassNotFoundException e) {
			 System.out.println("O driver expecificado nao foi encontrado.");
		}catch (SQLException e) {
			System.out.println("Nao foi possivel conectar ao banco de dados");
		}
	}

	public static boolean closeConnection() {
		try {
			getConnection().close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

}
