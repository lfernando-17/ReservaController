package view;
import bo.Espaco;
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


public class DeleteEspacoView implements ActionListener {

	 private JFrame janela;
	    private JPanel painel;
	    private JLabel espaco;
	    private JTextField txtnum1;
	    private JLabel txtnum2;
	    private JButton btnLg;

	@Override
	public void actionPerformed(ActionEvent e) {
		janela = new JFrame();
     painel = new JPanel();
     espaco = new JLabel("Digite o código do Espaco");
     painel.add(espaco);
     txtnum1 = new JTextField(" ");
     painel.add(txtnum1);
     painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10,30));
     painel.setLayout(new GridLayout(0,1));
     txtnum2 = new JLabel(" ");
     painel.add(txtnum2);
     
     btnLg = new JButton("Deletar");
     btnLg.addActionListener(new ActionListener() {
         @Override public void actionPerformed(ActionEvent e) {
         	Espaco lugar = new Espaco();
         	EspacoView view = new EspacoView();
         	lugar.setCodigo(txtnum1.getText().trim());
         	view.delete(lugar,txtnum2);
           }
         });
     painel.add(btnLg);
     janela.add(painel, BorderLayout.CENTER);
     janela.setTitle("Apagar Espaço");
     janela.setSize(300,350);
     janela.setLocation(940, 620);
     janela.setVisible(true);
		
	}

}
