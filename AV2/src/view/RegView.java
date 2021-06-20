package view;

import javax.swing.*;

import bo.Pessoa;

import java.awt.*;
import java.awt.event.*;

public class RegView implements ActionListener {
    private JFrame janela;
    
    private JPanel painel;
    private JLabel pessoa;
    private JLabel nome;
    private JLabel tel;
    private JLabel email;
    private JLabel cidade;
    private JLabel senha;
    private JTextField txtnum1;
    private JTextField txtnum2;
    private JTextField txtnum3;
    private JTextField txtnum4;
    private JTextField txtnum5;
    private JTextField txtnum6;
    private JLabel resultado;
    private JButton btnCd;
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	janela = new JFrame();
        painel = new JPanel();
        pessoa = new JLabel("Insira o CPF: ");
        painel.add(pessoa);
        txtnum1 = new JTextField(" ");
        painel.add(txtnum1);
        painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10,30));
        painel.setLayout(new GridLayout(0,1));
        nome = new JLabel("Insira o nome: ");
        painel.add(nome);
        txtnum2 = new JTextField(" ");
        painel.add(txtnum2);
        tel= new JLabel("Insira o telefone: ");
        painel.add(tel);
        txtnum3 = new JTextField(" ");
        painel.add(txtnum3);
        email= new JLabel("Insira o E-mail: ");
        painel.add(email);
        txtnum4 = new JTextField(" ");
        painel.add(txtnum4);
        cidade= new JLabel("Insira a cidade: ");
        painel.add(cidade);
        txtnum5 = new JTextField(" ");
        painel.add(txtnum5);
        senha= new JLabel("Insira a senha: ");
        painel.add(senha);
        txtnum6 = new JTextField(" ");
        painel.add(txtnum6);
        resultado = new JLabel(" ");

        
        btnCd = new JButton("Finalizar");
        btnCd.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
            		Pessoa pessoa = new Pessoa();
            		PessoaView view = new PessoaView();
            		pessoa.setCpf(txtnum1.getText().trim());
            		pessoa.setNome(txtnum2.getText().trim());
            		pessoa.setTelefone(txtnum3.getText().trim());
            		pessoa.setEmail(txtnum4.getText().trim());
            		pessoa.setCidade(txtnum5.getText().trim());
            		pessoa.setSenha(txtnum6.getText().trim());
            		view.create(pessoa,resultado);
              }
            });
        painel.add(btnCd);
        painel.add(resultado);
        janela.add(painel, BorderLayout.CENTER);
        janela.setTitle("Tela de Cadastro");
        janela.setSize(300,400);
        janela.setLocation(940, 620);
        janela.setVisible(true);
    }   
}
