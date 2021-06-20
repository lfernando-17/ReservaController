package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomeView implements ActionListener {
    private JFrame janela;
    private JPanel painel;
    private JButton btn1;
    private JLabel cr;
    private JButton btn2;
    private JLabel list;
    private JButton btn4;
    private JLabel at;
    private JButton at1;
    private JButton delPe;

     public HomeView(String cpf){
         janela = new JFrame();
         painel = new JPanel();
         painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10,30));
         painel.setLayout(new GridBagLayout());
         GridBagConstraints c = new GridBagConstraints();
         c.insets=new Insets(9,9,9,9);
         c.gridx=0;
         c.gridy = 1;
         JLabel add = new JLabel("Adicionar um local : ");
         painel.add(add,c);
         
         c.gridx=0;
         c.gridy = 2;
         JButton btnadd = new JButton("Adicionar");
         btnadd.addActionListener(new CreateEspacoView());
         painel.add(btnadd,c);
         
         c.gridx=4;
         c.gridy = 1;
         JLabel del = new JLabel("Deletar um local : ");
         painel.add(del,c);
         c.gridx=4;
         c.gridy = 2;
         JButton btndel = new JButton("Deletar");
 		 btndel.addActionListener(new DeleteEspacoView());
         painel.add(btndel,c);
         
         c.gridx=0;
         c.gridy = 7;
         cr = new JLabel("Fazer reserva: ");
         painel.add(cr,c);
         
         c.gridx=0;
         c.gridy = 8;
         btn1 = new JButton("Reservar");
         btn1.addActionListener(new CreateView());
         painel.add(btn1,c);
         
         c.gridx=4;
         c.gridy = 7;
         JLabel ed = new JLabel("Editar uma reserva: ");
         painel.add(ed,c);
         
         c.gridx=4;
         c.gridy = 8;
         JButton btned = new JButton("Editar");
         btned.addActionListener(new UpdateReservaView());
         painel.add(btned,c);
  
         c.gridx=0;
         c.gridy = 11;
         list = new JLabel("Ver Lista de reservas: ");
         painel.add(list,c);
         
         c.gridx=0;
         c.gridy = 12;
         btn2 = new JButton("Ir");
         btn2.addActionListener(new ReadView());
         painel.add(btn2,c);
         
         c.gridx=4;
         c.gridy = 11;
         del = new JLabel("Desmarcar reserva: ");
         painel.add(del,c);
         
         c.gridx=4;
         c.gridy = 12;
         btn4 = new JButton("Deletar");
         btn4.addActionListener(new DeleteView());
         painel.add(btn4,c);
         //
         c.gridx=0;
         c.gridy = 17;
         at = new JLabel("Atualizar dados");
         painel.add(at,c);
         
         c.gridx=0;
         c.gridy = 18;
         at1 = new JButton ("Atualizar");
         at1.addActionListener(new UpdatePessoaView(cpf));
         painel.add(at1,c);
         
         c.gridx=4;
         c.gridy = 18;
         delPe = new JButton ("Deletar Conta");
         delPe.addActionListener(new DeletePessoaView());
         painel.add(delPe,c);
         
         janela.add(painel, BorderLayout.CENTER);
         janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         janela.setTitle("Opções");
         janela.setSize(300,380);
         janela.setLocation(560, 320);
         janela.setVisible(true);
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
              
    }   
}
