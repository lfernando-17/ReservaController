package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bo.Pessoa;
import jdbc.ConnectionFactory;

public class PessoaDAO {
	
	public Pessoa login(Pessoa pessoa) {
		
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null ;
		ResultSet rs = null ;
		String sql = "select cpf,senha from pessoa where cpf = (?)";
		Pessoa pessoa1 = new Pessoa();
		try {
			stmt = banco.prepareStatement(sql);
			stmt.setString(1, pessoa.getCpf());
			rs = stmt.executeQuery();
			
			while(rs.next()) {

				pessoa1.setCpf(rs.getString("cpf"));
				pessoa1.setSenha(rs.getString("senha"));
			}
		}
		catch (SQLException e) {
			
			System.out.println("Erro ao tentar ler Pessoa...");
		}
		finally {
			ConnectionFactory.closeConnection(banco,stmt);
		}
		return pessoa1;
	}
	
		public void create(Pessoa pessoa) throws SQLException {
				Connection banco = ConnectionFactory.getConnection();
				PreparedStatement stmt = null;
				String sql = "insert into pessoa(cpf,nome,cidade,email,telefone,senha) values (?,?,?,?,?,?)";
				stmt = banco.prepareStatement(sql);
				
				stmt.setString(1,pessoa.getCpf());
				stmt.setString(2, pessoa.getNome());
				stmt.setString(3, pessoa.getCidade());
				stmt.setString(4, pessoa.getEmail());
				stmt.setString(5, pessoa.getTelefone());
				stmt.setString(6, pessoa.getSenha());
				
				stmt.executeUpdate();
				
				System.out.println("Conta Criada !");

				ConnectionFactory.closeConnection(banco,stmt);
			}
		public void delete(Pessoa pessoa) throws SQLException {
			Connection banco = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			String sql = "delete from pessoa where cpf = (?)";
			stmt = banco.prepareStatement(sql);
			
			stmt.setString(1,pessoa.getCpf());
	
			
			stmt.executeUpdate();
			
			System.out.println("Conta Deletada !");
			ConnectionFactory.closeConnection(banco,stmt);
			System.exit(0);
		}
		
		public void update(Pessoa pessoa) throws SQLException {
				Connection banco = ConnectionFactory.getConnection();
				PreparedStatement stmt = null ; 
				String sql = "update pessoa set nome = (?) , cidade = (?) , email = (?) , telefone = (?) , senha = (?) where cpf = (?)" ; 
				stmt = banco.prepareStatement(sql);
				stmt.setString(1, pessoa.getNome());
				stmt.setString(2, pessoa.getCidade());
				stmt.setString(3, pessoa.getEmail());
				stmt.setString(4, pessoa.getTelefone());
				stmt.setString(5, pessoa.getSenha());
				stmt.setString(6, pessoa.getCpf());
				
				stmt.executeUpdate();
				
				System.out.println("CPF : " + pessoa.getCpf() + " atualizado");
				
				ConnectionFactory.closeConnection(banco, stmt);
		}
		
		}


