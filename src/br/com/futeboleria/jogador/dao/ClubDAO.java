package br.com.futeboleria.jogador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.futeboleria.jogador.bean.Club;
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

		String sql = "INSERT INTO tb_club (username, password, nome, email, telefone, endereco, bairro, cidade, cpf) VALUES (?,?,?,?,?,?,?,?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, c.getUsername());
			stmt.setString(2, c.getPassword());
			stmt.setString(3, c.getNome());
			stmt.setString(4, c.getEmail());
			stmt.setString(5, c.getTelefone());
			stmt.setString(6, c.getEndereco());
			stmt.setString(7, c.getBairro());
			stmt.setString(8, c.getCidade());
			stmt.setString(9, c.getCpf());
					
			stmt.executeUpdate();

		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		finally{
			
		}
		
	}

	
	public void update(Club c){

		String sql = "UPDATE tb_club SET username = ?, password = ?, nome = ?, email = ?, telefone = ?, endereco = ?, bairro = ?, cidade = ?, cpf = ? WHERE id = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, c.getUsername());
			stmt.setString(2, c.getPassword());
			stmt.setString(3, c.getNome());
			stmt.setString(4, c.getEmail());
			stmt.setString(5, c.getTelefone());
			stmt.setString(6, c.getEndereco());
			stmt.setString(7, c.getBairro());
			stmt.setString(8, c.getCidade());
			stmt.setString(9, c.getCpf());
			stmt.setInt(10, c.getId());
			
			stmt.executeUpdate();

		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		finally{
			
		}
		
	}
	
	public void delete(Integer id){

		String sql = "DELETE FROM tb_club WHERE id = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			stmt.executeUpdate();

		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		finally{
			
		}
		
	}
	
	public List<Club> getAll(){

		String sql = "SELECT id, username, password, nome, email, telefone, endereco, bairro, cidade, cpf FROM tb_club ORDER BY username";
		
		List<Club> clubs = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();

			clubs = new ArrayList<Club>();
			
			while(rs.next()){
				Club c = new Club();
				c.setId(rs.getInt("id"));
				c.setUsername(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				c.setEndereco(rs.getString("endereco"));
				c.setBairro(rs.getString("bairro"));
				c.setCidade(rs.getString("cidade"));
				c.setCpf(rs.getString("cpf"));
				
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
	
	public Club getByPK(Integer id){

		String sql = "SELECT id, username, password, nome, email, telefone, endereco, bairro, cidade, cpf FROM tb_club WHERE id = ?";
		
		Club c = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();

			
			if(rs.next()){
				c = new Club();
				c.setId(rs.getInt("id"));
				c.setUsername(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				c.setEndereco(rs.getString("endereco"));
				c.setBairro(rs.getString("bairro"));
				c.setCidade(rs.getString("cidade"));
				c.setCpf(rs.getString("cpf"));
			}
			
		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		finally{
			
		}
		
		return c;
		
	}
	
	public List<Club> getByNome(String nome){

		String sql = "SELECT id, username, password, nome, email, telefone, endereco, bairro, cidade, cpf FROM tb_club WHERE nome LIKE ? ORDER BY nome";
		
		List<Club> clubs = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, '%' + nome + '%');
			
			ResultSet rs = stmt.executeQuery();

			clubs = new ArrayList<Club>();
			
			while(rs.next()){
				Club c = new Club();
				c.setId(rs.getInt("id"));
				c.setUsername(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				c.setEndereco(rs.getString("endereco"));
				c.setBairro(rs.getString("bairro"));
				c.setCidade(rs.getString("cidade"));
				c.setCpf(rs.getString("cpf"));
				
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
	
	public boolean username(String username, String password){

		String sql = "SELECT * FROM tb_club WHERE username = ? and password = ?";
		
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
	
	public Club getByUsername(String username){

		String sql = "SELECT id, username, password, nome, email, telefone, endereco, bairro, cidade, cpf FROM tb_club WHERE username = ?";
		
		Club c = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();

			
			if(rs.next()){
				c = new Club();
				c.setId(rs.getInt("id"));
				c.setUsername(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				c.setEndereco(rs.getString("endereco"));
				c.setBairro(rs.getString("bairro"));
				c.setCidade(rs.getString("cidade"));
				c.setCpf(rs.getString("cpf"));
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
