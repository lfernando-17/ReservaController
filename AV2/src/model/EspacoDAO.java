package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Espaco;
import jdbc.ConnectionFactory;

public class EspacoDAO {

	public void create(Espaco espaco) throws SQLException {
		
		Connection banco = ConnectionFactory.getConnection();
		PreparedStatement stmt = null ;

		String sql = "insert into espaco(codigo,capacidade,situacao) values (?, ? ,?)";
		
		stmt = banco.prepareStatement(sql);
		
		stmt.setString(1, espaco.getCodigo());
		stmt.setString(2, espaco.getCapacidade());
		stmt.setString(3, espaco.getSituacao());
		
		stmt.executeUpdate();
		
		ConnectionFactory.closeConnection(banco, stmt);	
		
	}

	public void delete(Espaco espaco) throws SQLException {
		// TODO Auto-generated method stub
		Connection banco = ConnectionFactory.getConnection();
		PreparedStatement stmt = null ;
		
		String sql = "delete from espaco where codigo = (?)";
		stmt = banco.prepareStatement(sql);
		stmt.setString(1,espaco.getCodigo());
		
		stmt.executeUpdate();
		ConnectionFactory.closeConnection(banco, stmt);
	}

	public List<Espaco> read() {
		List<Espaco> listaEspacos = new ArrayList<Espaco>();
		
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null ;
		ResultSet rs = null ;
		
		String sql = "select * from espaco";
		
		try {
			stmt = banco.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Espaco espaco = new Espaco();
				espaco.setCodigo(rs.getString("codigo"));
				espaco.setCapacidade(rs.getString("capacidade"));
				espaco.setSituacao(rs.getString("situacao"));
				
				listaEspacos.add(espaco);
			}
		}
		catch (SQLException e) {
			System.out.println("Erro ao tentar ler Espaco...");
		}
		finally {
			ConnectionFactory.closeConnection(banco,stmt);
		}
		return listaEspacos;
	}

	public void update(String espaco,String situacao)  {
		try {
		Connection banco = ConnectionFactory.getConnection();
		PreparedStatement stmt = null ;
		String sql = "update espaco set situacao = (?) where codigo = (?)";
		stmt = banco.prepareStatement(sql);
		stmt.setString(1, situacao);
		stmt.setString(2, espaco);
		stmt.executeUpdate();
		ConnectionFactory.closeConnection(banco, stmt);}
		catch (SQLException e) {
			System.out.println("Erro ao atualizar sala");
		}
		
	}


}
