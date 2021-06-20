package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginView implements ActionListener {
    private JFrame janela;
    private JPanel painel;
    private JLabel pessoa;
    private JLabel senha;
    private JLabel cd;
    private JTextField txtnum1;
    private JTextField txtnum2;
    private JButton btnLg;
    private JButton btncd;
    public LoginView()
    {
    	janela = new JFrame();
        painel = new JPanel();
        pessoa = new JLabel("CPF: ");
        painel.add(pessoa);
        txtnum1 = new JTextField(" ");
        painel.add(txtnum1);
        painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10,30));
        painel.setLayout(new GridLayout(0,1));
        senha = new JLabel("Senha: ");
        painel.add(senha);
        txtnum2 = new JTextField(" ");
        painel.add(txtnum2);
        
        btnLg = new JButton("Login");
        btnLg.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                PessoaView view = new PessoaView();
                view.Login(txtnum1,txtnum2);
              }
            });

        painel.add(btnLg);
        cd = new JLabel("Se cadastrar :");
        painel.add(cd);
        btncd = new JButton("Cadastrar");
        painel.add(btncd);
        
        
        btncd.addActionListener(new RegView());
        janela.add(painel, BorderLayout.CENTER);
        janela.setTitle("Login");
        janela.setSize(300,350);
        janela.setLocation(860, 320);
        janela.setVisible(true);
    }
    public static void main(String[] args) {
        new LoginView();
}
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    }   
}
