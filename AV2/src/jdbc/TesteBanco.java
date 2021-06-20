package jdbc;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteBanco {

	public static void main(String[] args) {
		
		try {
			
			Connection banco = ConnectionFactory.getConnection();
			System.out.println("Conexão OK!!!!");
			
			createNewTable(banco);
			readTableTest(banco);
		}
		catch(Exception e)
		{
			System.out.println("Erro na Conexão<<>>");
			System.out.println(e);
		}

	}
	
	public static void createNewTable(Connection banco) {
		String sql = "CREATE TABLE IF NOT EXISTS pessoa (\n"
				+ "cpf varchar(10) NOT NULL , \n"
				+ "nome varchar(50) NOT NULL , \n"
				+ "cidade varchar(50) NOT NULL, \n"
				+ "email varchar(50) NOT NULL, \n"
				+ "telefone varchar(50) NOT NULL, \n"
				+ "senha varchar(50) NOT NULL, \n"
				+ "PRIMARY KEY (cpf) \n"
				+ ");";
		
		String sql1 = "CREATE TABLE IF NOT EXISTS espaco (\n"
				+ "codigo varchar(10) PRIMARY KEY , \n"
				+ "capacidade int NOT NULL , \n"
				+ "situacao varchar(50) NOT NULL \n"
				+ ");";
		
		String sql2 = "CREATE TABLE IF NOT EXISTS reserva (\n"
				+ "codigo int NOT NULL AUTO_INCREMENT , \n"
				+ "dt_inicio date NOT NULL , \n"
				+ "dt_fim date NOT NULL , \n"
				+ "hora varchar(5) NOT NULL, \n"
				+ "pessoa_cpf varchar(10) NOT NULL, \n"
				+ "espaco_codigo varchar(10) NOT NULL, \n"
				+ "Primary Key(codigo) , \n"
				+ "Foreign Key(pessoa_cpf) references pessoa (cpf), \n"
				+ "Foreign Key(espaco_codigo) references espaco (codigo) \n"
				+ ");";
			try {
				Statement smt = banco.createStatement();
				smt.execute(sql);
				smt.execute(sql1);
				smt.execute(sql2);
				System.out.println("Tabelas criada !!");
			}
			catch(Exception e) {
				System.out.println("Erro na Conexão");
				System.out.println(e);
			}
		}
	public static void readTableTest(Connection banco) {
		String sql = "select * from pessoa;";
		
		PreparedStatement stmt = null;
		ResultSet rs = null ;
		
		try {
			stmt = banco.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if(rs.next())
				System.out.println("Com registro");
			else
				System.out.println("Sem registro");
		}
		catch (SQLException e) {
			System.out.println("<DAO> Erro lendo banco");
		}
		finally {
			ConnectionFactory.closeConnection(banco,stmt);
		}
	}

}