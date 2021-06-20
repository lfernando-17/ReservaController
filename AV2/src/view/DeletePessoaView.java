package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bo.Pessoa;

public class DeletePessoaView implements ActionListener {
	 private JFrame janela;
	    private JPanel painel;
	    private JLabel pessoa;
	    private JLabel senha;
	    private JTextField txtnum1;
	    private JTextField txtnum2;
	    private JLabel txtnum3;
	    private JButton btnLg;

	@Override
	public void actionPerformed(ActionEvent e) {
		janela = new JFrame();
        painel = new JPanel();
        pessoa = new JLabel("Digite seu CPF: ");
        painel.add(pessoa);
        txtnum1 = new JTextField(" ");
        painel.add(txtnum1);
        painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10,30));
        painel.setLayout(new GridLayout(0,1));
        senha = new JLabel("Confirme sua Senha: ");
        painel.add(senha);
        txtnum2 = new JTextField(" ");
        painel.add(txtnum2);
        
        btnLg = new JButton("Deletar");
        btnLg.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
            	Pessoa pessoa = new Pessoa ();
            	PessoaView view = new PessoaView();
            	pessoa.setCpf(txtnum1.getText().trim());
            	pessoa.setSenha(txtnum2.getText().trim());
            	view.delete(pessoa,txtnum3);
              }
            });
        txtnum3 = new JLabel(" ");
        painel.add(txtnum3);
        painel.add(btnLg);
        janela.add(painel, BorderLayout.CENTER);
        janela.setTitle("Apagar Conta");
        janela.setSize(300,350);
        janela.setLocation(940, 620);
        janela.setVisible(true);
		
	}

	
}
