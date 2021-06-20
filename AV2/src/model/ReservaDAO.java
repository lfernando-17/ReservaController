package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Reserva;
import jdbc.ConnectionFactory;

public class ReservaDAO {

	public void create(Reserva reserva, String lugar) throws SQLException {
		Connection banco = ConnectionFactory.getConnection();
		PreparedStatement stmt = null ;
		
		String sql = "insert into reserva(dt_inicio,dt_fim,hora,pessoa_cpf,espaco_codigo) values(?,?,?,?,?)";
		
		stmt = banco.prepareStatement(sql);
		stmt.setString(1, reserva.getDt_inicio());
		stmt.setString(2, reserva.getDt_fim());
		stmt.setString(3, reserva.getHora());
		stmt.setString(4, reserva.getPessoa_cpf());
		stmt.setString(5, lugar);
		
		stmt.executeUpdate();
		
		ConnectionFactory.closeConnection(banco, stmt);
	}

	public List<Reserva> read() {
		List<Reserva> lista = new ArrayList<Reserva>();
		
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null ;
		ResultSet rs = null ;
		
		String sql = "select reserva.*,pessoa.nome from reserva,pessoa where pessoa.cpf = reserva.pessoa_cpf";
		
		try {
			stmt = banco.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Reserva reserva = new Reserva();
				reserva.setCodigo(rs.getString("codigo"));
				reserva.setDt_inicio(rs.getString("dt_inicio"));
				reserva.setDt_fim(rs.getString("dt_fim"));
				reserva.setHora(rs.getString("hora"));
				reserva.setPessoa_cpf(rs.getString("pessoa_cpf"));
				reserva.setEspaco_codigo(rs.getString("espaco_codigo"));
				reserva.setNome(rs.getString("nome"));
				
				lista.add(reserva);
			}
		}
		catch (SQLException e) {
			System.out.println("Erro ao tentar ler Aluno...");
		}
		finally {
			ConnectionFactory.closeConnection(banco,stmt);
		}
		return lista;
	}

	public void delete(Reserva reserva) throws SQLException {
		Connection banco = ConnectionFactory.getConnection();
		PreparedStatement stmt = null ;
		String sql = "delete from reserva where codigo = (?)";
		stmt = banco.prepareStatement(sql);
		stmt.setString(1, reserva.getCodigo());
		stmt.executeUpdate();
		ConnectionFactory.closeConnection(banco, stmt);
		
	}

	public void update(Reserva reserva) throws SQLException {
		Connection banco = ConnectionFactory.getConnection();
		PreparedStatement stmt = null ;
		
		String sql = "update reserva set dt_inicio = (?),dt_fim = (?) , hora = (?) where codigo = (?)";
		stmt = banco.prepareStatement(sql);
		stmt.setString(1, reserva.getDt_inicio());
		stmt.setString(2, reserva.getDt_fim());
		stmt.setString(3, reserva.getHora());
		stmt.setString(4, reserva.getCodigo());
		
		stmt.executeUpdate();
		ConnectionFactory.closeConnection(banco, stmt);
		
	}
	}
	

