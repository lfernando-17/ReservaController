package view;

import javax.swing.*;

import bo.Espaco;
import bo.Reserva;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class CreateView implements ActionListener {
    private JFrame janela;
    private JPanel main;
    private JPanel painel1;
    private JPanel painel2;
     private JLabel pessoa;
     private JTextField txtnum2;
     private JLabel resultado;
     private JButton btnCr;

    
    @Override
    public void actionPerformed(ActionEvent e) {
    	janela = new JFrame();
        main = new JPanel();
        painel1 = new JPanel();
        painel2 = new JPanel();
        
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        GridBagConstraints c = new GridBagConstraints();
        c.insets=new Insets(9,9,9,9);
        c.gridx=0;
        c.gridy = 1;
        pessoa = new JLabel("CPF do interessado: ");
        painel1.add(pessoa);
        txtnum2 = new JTextField(" ");
        painel1.add(txtnum2);
        painel1.setBorder(BorderFactory.createEmptyBorder(30, 30, 10,30));
        painel1.setLayout(new GridLayout(0,1));
        JLabel inicio = new JLabel("Inicio do evento: (yyyy-MM-dd)");
        painel1.add(inicio);
        JTextField txtnum4 = new JTextField(" ");
        painel1.add(txtnum4);
        JLabel fim = new JLabel("Fim do Evento : (yyyy-MM-dd)");
        painel1.add(fim);
        JTextField txtnum5 = new JTextField(" ");
        painel1.add(txtnum5);
        Component hora = new JLabel("Hora");
        painel1.add(hora);
        JTextField txtnum6 = new JTextField(" ");
        painel1.add(txtnum6); 
        btnCr = new JButton("Enviar");
        resultado = new JLabel(" ");
        btnCr.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
            	resultado.setText("Escolha uma sala : ");
            	
            	EspacoView leitura = new EspacoView();
            	List<Espaco> lista = new ArrayList<Espaco>();
            	lista = leitura.read();
            	int x=3;
            	for(Espaco lugar:lista) 
            	{	
            		if(lugar.getSituacao().equalsIgnoreCase("Disponivel")) {
            		c.gridx=0;
            		c.gridy=x;
            		x++;
            		JButton jt = new JButton(" ");
            		jt.setText("Codigo : "+lugar.getCodigo()+" Capacidade : "+lugar.getCapacidade()+" Situação : "+lugar.getSituacao());
            		jt.addActionListener(new ActionListener() {
						@Override public void actionPerformed(ActionEvent e) {
                        	Reserva reserva = new Reserva();
                        	ReservaView view = new ReservaView();
                        	reserva.setPessoa_cpf(txtnum2.getText().trim());
                        	reserva.setDt_inicio(txtnum4.getText().trim());
                        	reserva.setDt_fim(txtnum5.getText().trim());
                        	reserva.setHora(txtnum6.getText().trim());
                        	view.create(reserva,lugar.getCodigo(),resultado); 	
                          }
                        });
            		painel2.add(jt,c);
            		painel2.revalidate();
            		painel2.repaint();}
            }
              }
            });
        painel2.add(resultado);
        painel1.add(btnCr);
        main.add(painel1);
        main.add(painel2);
        janela.add(main, BorderLayout.CENTER);
        janela.setTitle("Reserva");
        janela.setSize(350,450);
        janela.setLocation(940, 620);
        janela.setVisible(true);
    }   
}

	