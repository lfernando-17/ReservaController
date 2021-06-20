package view;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;
import bo.Reserva;

import java.awt.*;
import java.awt.event.*;

public class ReadView implements ActionListener {
    private JFrame janela;
    private JPanel painel;
    private JLabel list;
    private JLabel jt;
    private JButton btn1;

    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	janela = new JFrame();
        painel = new JPanel();
        list = new JLabel("Listagem de Reservas");
        painel.setLayout(new GridBagLayout());
        janela.setTitle("Tela de Listagem");
        janela.setSize(750,300);
        janela.setLocation(300, 320);
        janela.setVisible(true);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets (10,10,10,10);
        c.gridx = 0;
        c.gridy = 1;
        painel.add(list,c);
        c.gridx=0;
        c.gridy=2;
        btn1 = new JButton("Revelar");
        btn1.setBounds(20,30,50,30);
        painel.add(btn1,c);
        c.gridx=0;
        c.gridy=3;
        janela.add(painel);
        btn1.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
            	ReservaView leitura = new ReservaView();
        		List<Reserva> lista = new ArrayList<Reserva>();
        		lista = leitura.read();
        		int x=3;
        		for(Reserva reserva:lista) 
        		{
        			c.gridx=0;
        			c.gridy=x;
        			x++;
        			System.out.println(reserva.getDt_fim());
        			painel.remove(btn1);
        			jt = new JLabel(" ");
        			jt.setText("Código da reserva : "+reserva.getCodigo()+"  Código do espaço :"+reserva.getEspaco_codigo()+"  Data de Inicio : "+ reserva.getDt_inicio()+"  Data Fim : "+reserva.getDt_fim()+"  Hora : "+reserva.getHora()+"  Reservado por : "+reserva.getNome());
        			painel.add(jt,c);
        			painel.revalidate();
        			painel.repaint();
        		}
              }
            });
    }   

}
