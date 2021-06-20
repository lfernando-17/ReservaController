package controller;
import java.sql.SQLException;

import bo.Pessoa;
import model.PessoaDAO;
import view.HomeView;

public class PessoaController {
	public void create(Pessoa pessoa) throws SQLException {

			PessoaDAO model = new PessoaDAO();
			model.create(pessoa);

	}
	public void read() {}
	
	public void update(Pessoa pessoa) throws SQLException {

			PessoaDAO model = new PessoaDAO();
			model.update(pessoa);


	}
	public void delete(Pessoa pessoa) throws SQLException {
		Pessoa resposta = new Pessoa();
		PessoaDAO model = new PessoaDAO();
		resposta = model.login(pessoa);
		
		if (resposta.getCpf().equalsIgnoreCase(pessoa.getCpf()) && resposta.getSenha().equalsIgnoreCase(pessoa.getSenha())) {
			System.out.println("Dados Certos !");
			model.delete(pessoa);
			}
		else {
			throw new RuntimeException("Dados errados !");
	}
	}
	
	public void login(Pessoa pessoa) {
		
		Pessoa resposta = new Pessoa();
		PessoaDAO model = new PessoaDAO();
		resposta = model.login(pessoa);
		
		if (resposta.getCpf().equalsIgnoreCase(pessoa.getCpf()) && resposta.getSenha().equalsIgnoreCase(pessoa.getSenha())) {
			System.out.println("Acesso permitido");
			new HomeView(pessoa.getCpf());}
		else {
			throw new RuntimeException("Acesso Negado!");
	}
	}
	
}
