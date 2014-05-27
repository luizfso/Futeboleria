package br.com.futeboleria.jogador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.futeboleria.jogador.bean.Club;
import br.com.futeboleria.jogador.bean.Player;
import br.com.futeboleria.jogador.factory.ConnectionFactory;

public class ClubDAO {

	Connection conn = null;
	
	public ClubDAO(){
		
		try{
			conn = ConnectionFactory.getConnection();
		}
		catch(SQLException ex){ }
	}
	
	public void insert(Club c){

		String sql = "INSERT INTO tb_club (usernamee, passworde, nomee, emaile, telefonee, enderecoe, bairroe, cidadee, cpfe) VALUES (?,?,?,?,?,?,?,?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, c.getUsernamee());
			stmt.setString(2, c.getPassworde());
			stmt.setString(3, c.getNomee());
			stmt.setString(4, c.getEmaile());
			stmt.setString(5, c.getTelefonee());
			stmt.setString(6, c.getEnderecoe());
			stmt.setString(7, c.getBairroe());
			stmt.setString(8, c.getCidadee());
			stmt.setString(9, c.getCpfe());
					
			stmt.executeUpdate();

		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		finally{
			
		}
		
	}

	
	public void update(Club c){

		String sql = "UPDATE tb_club SET usernamee = ? passworde = ? nomee = ?, emaile = ?, telefonee = ?, enderecoe = ?, bairroe = ?, cidadee = ?, cpfe = ? WHERE ide = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, c.getPassworde());
			stmt.setString(2, c.getUsernamee());
			stmt.setString(1, c.getNomee());
			stmt.setString(2, c.getEmaile());
			stmt.setString(3, c.getTelefonee());
			stmt.setString(4, c.getEnderecoe());
			stmt.setString(5, c.getBairroe());
			stmt.setString(6, c.getCidadee());
			stmt.setString(7, c.getCpfe());
			stmt.setInt(8, c.getIde());		
			stmt.executeUpdate();

		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		finally{
			
		}
		
	}
	
	public void delete(Integer ide){

		String sql = "DELETE FROM tb_club WHERE ide = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, ide);
			
			stmt.executeUpdate();

		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		finally{
			
		}
		
	}
	
	public List<Club> getAll(){

		String sql = "SELECT ide, usernamee, passworde, nomee, emaile, telefonee, enderecoe, bairroe, cidadee, cpfe FROM tb_club ORDER BY usernamee";
		
		List<Club> clubs = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();

			clubs = new ArrayList<Club>();
			
			while(rs.next()){
				Club c = new Club();
				c.setIde(rs.getInt("ide"));
				c.setUsernamee(rs.getString("usernamee"));
				c.setPassworde(rs.getString("passworde"));
				c.setNomee(rs.getString("nomee"));
				c.setEmaile(rs.getString("emaile"));
				c.setTelefonee(rs.getString("telefonee"));
				c.setEnderecoe(rs.getString("enderecoe"));
				c.setBairroe(rs.getString("bairroe"));
				c.setCidadee(rs.getString("cidadee"));
				c.setCpfe(rs.getString("cpfe"));
				
				clubs.add(c);
			}
			
		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		finally{
			
		}
		
		return clubs;
		
	}
	
	public Club getByPK(Integer ide){

		String sql = "SELECT ide, usernamee, passworde, nomee, emaile, telefonee, enderecoe, bairroe, cidadee, cpfe FROM tb_club WHERE ide = ?";
		
		Club c = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, ide);
			
			ResultSet rs = stmt.executeQuery();

			
			if(rs.next()){
				c = new Club();
				c.setIde(rs.getInt("ide"));
				c.setUsernamee(rs.getString("usernamee"));
				c.setPassworde(rs.getString("passworde"));
				c.setNomee(rs.getString("nomee"));
				c.setEmaile(rs.getString("emaile"));
				c.setTelefonee(rs.getString("telefonee"));
				c.setEnderecoe(rs.getString("enderecoe"));
				c.setBairroe(rs.getString("bairroe"));
				c.setCidadee(rs.getString("cidadee"));
				c.setCpfe(rs.getString("cpfe"));
			}
			
		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		finally{
			
		}
		
		return c;
		
	}
	
	public List<Club> getByNomee(String nomee){

		String sql = "SELECT ide, nomee, emaile, telefonee FROM tb_club WHERE nomee LIKE ? ORDER BY nomee";
		
		List<Club> clubs = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, '%' + nomee + '%');
			
			ResultSet rs = stmt.executeQuery();

			clubs = new ArrayList<Club>();
			
			while(rs.next()){
				Club c = new Club();
				c.setIde(rs.getInt("ide"));
				c.setUsernamee(rs.getString("usernamee"));
				c.setPassworde(rs.getString("passworde"));
				c.setNomee(rs.getString("nomee"));
				c.setEmaile(rs.getString("emaile"));
				c.setTelefonee(rs.getString("telefonee"));
				c.setEnderecoe(rs.getString("enderecoe"));
				c.setBairroe(rs.getString("bairroe"));
				c.setCidadee(rs.getString("cidadee"));
				c.setCpfe(rs.getString("cpfe"));
				
				clubs.add(c);
			}
			
		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		finally{
			
		}
		
		return clubs;
		
	}
	
	public boolean usernamee(String usernamee, String passworde){

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
	
	public Club getByUsernamee(String usernamee){

		String sql = "SELECT ide, usernamee, passworde, nomee, emaile, telefonee, enderecoe, bairroe, cidadee, cpfe FROM tb_club WHERE usernamee = ?";
		
		Club c = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, usernamee);
			
			ResultSet rs = stmt.executeQuery();

			
			if(rs.next()){
				c = new Club();
				c.setIde(rs.getInt("ide"));
				c.setUsernamee(rs.getString("usernamee"));
				c.setPassworde(rs.getString("passworde"));
				c.setNomee(rs.getString("nomee"));
				c.setEmaile(rs.getString("emaile"));
				c.setTelefonee(rs.getString("telefonee"));
				c.setEnderecoe(rs.getString("enderecoe"));
				c.setBairroe(rs.getString("bairroe"));
				c.setCidadee(rs.getString("cidadee"));
				c.setCpfe(rs.getString("cpfe"));
			}
			
		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		finally{
			
		}
		
		return c;
		
	}
	
}
