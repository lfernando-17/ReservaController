package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import bo.Reserva;
import controller.EspacoController;
import controller.ReservaController;

public class ReservaView {

	public void create(Reserva reserva, String string, JLabel resultado) {
		try {
			ReservaController controller = new ReservaController();
			controller.create(reserva,string);
			resultado.setText("Alugado com Sucesso !");
			EspacoController controller1 = new EspacoController();
			controller1.update(string,"Indisponivel");
			}
		catch(Exception e1) {
			resultado.setText("Tente Novamente!");
			System.out.println(e1);
		}
	}
	
	public List<Reserva> read(){
		List<Reserva> Lista = new ArrayList<Reserva>();
		try {
			ReservaController controller = new ReservaController();
			Lista = controller.read();
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		return Lista;
	}

	public void delete(Reserva reserva, JLabel resultado) {
		try {
			ReservaController controller = new ReservaController();
			controller.delete(reserva);
			resultado.setText("Deletado com Sucesso !");
		}
		catch(Exception e) {
			System.out.println(e);
			resultado.setText("Tente Novamente");
		}
		EspacoController controller1 = new EspacoController();
		controller1.update(reserva.getEspaco_codigo(),"Disponivel");
		
	}
	
	public void update(Reserva reserva , JLabel resultado) {
		try {
			ReservaController controller = new ReservaController();
			controller.update(reserva);
			resultado.setText("Reserva Atualizada !");
		}
		catch(Exception e){
			System.out.println(e);
			resultado.setText("Tente novamente");
		}
	}
	
}
