package br.com.futeboleria.jogador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.futeboleria.jogador.bean.Player;
import br.com.futeboleria.jogador.factory.ConnectionFactory;

public class PlayerDAO {

	Connection conn = null;
	
	public PlayerDAO(){
		
		try{
			conn = ConnectionFactory.getConnection();
		}
		catch(SQLException ex){ }
	}
	
	public void insert(Player p){

		String sql = "INSERT INTO tb_player (username, password, nome, email, telefone, endereco, bairro, cidade, cpf) VALUES (?,?,?,?,?,?,?,?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, p.getUsername());
			stmt.setString(2, p.getPassword());
			stmt.setString(3, p.getNome());
			stmt.setString(4, p.getEmail());
			stmt.setString(5, p.getTelefone());
			stmt.setString(6, p.getEndereco());
			stmt.setString(7, p.getBairro());
			stmt.setString(8, p.getCidade());
			stmt.setString(9, p.getCpf());
					
			stmt.executeUpdate();

		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		finally{
			
		}
		
	}

	
	public void update(Player p){
		System.out.println("teste1");
		String sql = "UPDATE tb_player SET username = ?, password = ?, nome = ?, email = ?, telefone = ?, endereco = ?, bairro = ?, cidade = ?, cpf = ? WHERE id = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, p.getUsername());
			stmt.setString(2, p.getPassword());
			stmt.setString(3, p.getNome());
			stmt.setString(4, p.getEmail());
			stmt.setString(5, p.getTelefone());
			stmt.setString(6, p.getEndereco());
			stmt.setString(7, p.getBairro());
			stmt.setString(8, p.getCidade());
			stmt.setString(9, p.getCpf());
			stmt.setInt(10, p.getId());	
			System.out.println("teste2");
			stmt.executeUpdate();

		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		finally{
			
		}
		
	}
	
	public void delete(Integer id){

		String sql = "DELETE FROM tb_player WHERE id = ?";
		
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
	
	public List<Player> getAll(){

		String sql = "SELECT id, username, password, nome, email, telefone, endereco, bairro, cidade, cpf FROM tb_player ORDER BY username";
		
		List<Player> players = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();

			players = new ArrayList<Player>();
			
			while(rs.next()){
				Player p = new Player();
				p.setId(rs.getInt("id"));
				p.setUsername(rs.getString("username"));
				p.setPassword(rs.getString("password"));
				p.setNome(rs.getString("nome"));
				p.setEmail(rs.getString("email"));
				p.setTelefone(rs.getString("telefone"));
				p.setEndereco(rs.getString("endereco"));
				p.setBairro(rs.getString("bairro"));
				p.setCidade(rs.getString("cidade"));
				p.setCpf(rs.getString("cpf"));
				
				players.add(p);
			}
			
		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		finally{
			
		}
		
		return players;
		
	}
	
	public Player getByPK(Integer id){

		String sql = "SELECT id, username, password, nome, email, telefone, endereco, bairro, cidade, cpf FROM tb_player WHERE id = ?";
		
		Player p = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();

			
			if(rs.next()){
				p = new Player();
				p.setId(rs.getInt("id"));
				p.setUsername(rs.getString("username"));
				p.setPassword(rs.getString("password"));
				p.setNome(rs.getString("nome"));
				p.setEmail(rs.getString("email"));
				p.setTelefone(rs.getString("telefone"));
				p.setEndereco(rs.getString("endereco"));
				p.setBairro(rs.getString("bairro"));
				p.setCidade(rs.getString("cidade"));
				p.setCpf(rs.getString("cpf"));
			}
			
		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		finally{
			
		}
		
		return p;
		
	}
	
	public List<Player> getByNome(String nome){

		String sql = "SELECT id, username, password, nome, email, telefone, endereco, bairro, cidade, cpf FROM tb_player WHERE nome LIKE ? ORDER BY nome";
		
		List<Player> players = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, '%' + nome + '%');
			
			ResultSet rs = stmt.executeQuery();

			players = new ArrayList<Player>();
			
			while(rs.next()){
				Player p = new Player();
				p.setId(rs.getInt("id"));
				p.setUsername(rs.getString("username"));
				p.setPassword(rs.getString("password"));
				p.setNome(rs.getString("nome"));
				p.setEmail(rs.getString("email"));
				p.setTelefone(rs.getString("telefone"));
				p.setEndereco(rs.getString("endereco"));
				p.setBairro(rs.getString("bairro"));
				p.setCidade(rs.getString("cidade"));
				p.setCpf(rs.getString("cpf"));
				
				players.add(p);
			}
			
		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		finally{
			
		}
		
		return players;
		
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
	
	public Player getByUsername(String username){

		String sql = "SELECT id, username, password, nome, email, telefone, endereco, bairro, cidade, cpf FROM tb_player WHERE username = ?";
		
		Player p = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();

			
			if(rs.next()){
				p = new Player();
				p.setId(rs.getInt("id"));
				p.setUsername(rs.getString("username"));
				p.setPassword(rs.getString("password"));
				p.setNome(rs.getString("nome"));
				p.setEmail(rs.getString("email"));
				p.setTelefone(rs.getString("telefone"));
				p.setEndereco(rs.getString("endereco"));
				p.setBairro(rs.getString("bairro"));
				p.setCidade(rs.getString("cidade"));
				p.setCpf(rs.getString("cpf"));
			}
			
		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		finally{
			
		}
		
		return p;
		
	}
	
}
