package com.tiago.agenda.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tiago.util.db.ConnectionMysql;

public class UsuarioDAO {
	public boolean isUserLogin(String login) {
		boolean result = false;
		String sql = "select u.id from usuario u where u.login ='" + login + "'" ;
		try {
			ResultSet rs = ConnectionMysql.getConnection().createStatement().executeQuery(sql);
			if(rs.next()){
				result = rs.getBoolean(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getStackTrace());
		}
		return result;
	}
	
	
}
