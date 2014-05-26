package br.com.futeboleria.jogador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.futeboleria.jogador.factory.ConnectionFactory;

public class LoginPlayerDAO {

	Connection conn = null;
	
	public LoginPlayerDAO(){
		
		try{
			conn = ConnectionFactory.getConnection();
		}
		catch(SQLException ex){ }
	}
	
	public boolean username(String username, String password){

		String sql = "SELECT * FROM tb_player WHERE username = ? and password = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
			stmt.setString(2, password);
					
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
				return true;

		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		finally{
			
		}
		
		return false;
	}

}
