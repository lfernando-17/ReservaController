package view;

import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JTextField;

import bo.Pessoa;
import controller.PessoaController;

public class PessoaView {
	
	public void Login(JTextField cpf , JTextField senha)
	{
		String cpf1 = cpf.getText().trim();
		String senha2 = senha.getText().trim();
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf(cpf1);
		pessoa.setSenha(senha2);
		
		try {
			PessoaController controller = new PessoaController();
			controller.login(pessoa);
		}
		catch(Exception e)
		{
			System.out.println("Acesso Negado");
			System.out.println(e);
		}
		
	}
	
	public void create(Pessoa pessoa,JLabel resultado) {
		try {
			PessoaController controller = new PessoaController();
			controller.create(pessoa);
			resultado.setText("Concluido !");
		}
		catch(SQLException e)
		{
			resultado.setText("Tente Novamente");
			System.out.println(e);
		}
	}
	
	public void update(Pessoa pessoa , JLabel resultado) {
		try {
			PessoaController controller = new PessoaController();
			controller.update(pessoa);
			resultado.setText("Atualizado !");
		}
		catch(SQLException e)
		{
			resultado.setText("Tente Novamente");
			System.out.println(e);
		}
	}
	public void delete(Pessoa pessoa, JLabel resultado) {
		//Recebo CPF e Senha
		try {
		PessoaController controller = new PessoaController();
		controller.delete(pessoa);}
		catch(SQLException e)
		{
			resultado.setText("Tente Novamente");
			System.out.println(e);
		}
		
	}
}
