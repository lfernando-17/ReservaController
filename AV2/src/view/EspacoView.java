package view;

import java.util.List;

import javax.swing.JLabel;

import bo.Espaco;
import controller.EspacoController;

public class EspacoView {
	public void create(Espaco lugar, JLabel resultado) {
		try {
			EspacoController controller = new EspacoController();
			controller.create(lugar);
			resultado.setText("Concluido !");
		}
		catch(Exception e){
			resultado.setText("Tente Novamente");
			System.out.println(e);
		}
	}
	public List<Espaco> read() {

			EspacoController controller = new EspacoController();
			return controller.read();
		
	}
	
	
	public void delete(Espaco espaco , JLabel resultado) {
		try {
			EspacoController controller = new EspacoController();
			controller.delete(espaco);
			resultado.setText("Sucesso em Deletar !");
		}
		catch(Exception e) {
			resultado.setText("Tente novamente Deletar");
			System.out.println(e);
		}
	}
	public void update() {}
}
