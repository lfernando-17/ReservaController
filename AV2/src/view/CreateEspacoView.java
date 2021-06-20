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

import bo.Espaco;

public class CreateEspacoView implements ActionListener {

	private JFrame janela;
    private JPanel painel;
    private JLabel pessoa;
    private JLabel nome;
    private JTextField txtnum1;
    private JTextField txtnum2;
    private JLabel resultado;
    private JButton btnCd;
    
    public void actionPerformed(ActionEvent e) {
    	janela = new JFrame();
        painel = new JPanel();
        pessoa = new JLabel("Insira o código : ");
        painel.add(pessoa);
        txtnum1 = new JTextField(" ");
        painel.add(txtnum1);
        painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10,30));
        painel.setLayout(new GridLayout(0,1));
        nome = new JLabel("Insira a capacidade total ");
        painel.add(nome);
        txtnum2 = new JTextField(" ");
        painel.add(txtnum2);
 
        btnCd = new JButton("Finalizar");
        resultado = new JLabel(" ");
        btnCd.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
            		Espaco lugar = new Espaco();
            		EspacoView view = new EspacoView();
            		lugar.setCodigo(txtnum1.getText().trim());
            		lugar.setCapacidade(txtnum2.getText().trim());
            		lugar.setSituacao("Disponivel");
            		view.create(lugar,resultado);
              }
            });
        painel.add(btnCd);
        painel.add(resultado);
        janela.add(painel, BorderLayout.CENTER);
        janela.setTitle("Tela de Cadastro de Espaço");
        janela.setSize(300,300);
        janela.setLocation(940, 620);
        janela.setVisible(true);

}
}
