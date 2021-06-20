package view;

import javax.swing.*;

import bo.Reserva;

import java.awt.*;
import java.awt.event.*;

public class DeleteView implements ActionListener {
    private JFrame janela;
    private JPanel painel;
     private JLabel sala;
     private JTextField txtnum1;
     private JLabel pessoa;
     private JTextField txtnum2;
     private JButton btnDel;
     private JLabel resultado;
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	janela = new JFrame();
        painel = new JPanel();
        sala = new JLabel("Qual código da reserva ?");
        painel.add(sala);
        txtnum1 = new JTextField(" ");
        painel.add(txtnum1);
        pessoa = new JLabel("Qual código do espaço ? ");
        painel.add(pessoa);
        txtnum2 = new JTextField(" ");
        painel.add(txtnum2);
        painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10,30));
        painel.setLayout(new GridLayout(0,1));
        btnDel = new JButton("Desmarcar");
        resultado = new JLabel(" ");
        btnDel.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
            	Reserva reserva = new Reserva();
            	ReservaView view = new ReservaView();
            	reserva.setEspaco_codigo(txtnum2.getText().trim());
            	reserva.setCodigo(txtnum1.getText().trim());
            	view.delete(reserva,resultado);
              }
            });
        painel.add(btnDel);
        painel.add(resultado);
        janela.add(painel, BorderLayout.CENTER);
        janela.setTitle("Deletar Reserva");
        janela.setSize(300,300);
        janela.setLocation(840, 220);
        janela.pack();
        janela.setVisible(true);
    }   
}