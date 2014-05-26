package br.com.futeboleria.jogador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.futeboleria.jogador.factory.ConnectionFactory;

public class LoginClubDAO {

	Connection conn = null;
	
	public LoginClubDAO(){
		
		try{
			conn = ConnectionFactory.getConnection();
		}
		catch(SQLException ex){ }
	}
	
	public boolean username(String usernamee, String passworde){

		String sql = "SELECT * FROM tb_club WHERE usernamee = ? and passworde = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, usernamee);
			stmt.setString(2, passworde);
					
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
