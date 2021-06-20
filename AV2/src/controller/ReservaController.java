package controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Reserva;
import model.ReservaDAO;

public class ReservaController {
	public void create(Reserva reserva, String string) throws SQLException
	{
		ReservaDAO model = new ReservaDAO();
		model.create(reserva,string);
	}
	
	
	
	public List<Reserva> read() {
		List<Reserva> lista = new ArrayList<Reserva>();
		
		ReservaDAO model = new ReservaDAO();
		lista = model.read();
		return lista;
		
	}
	public void update(Reserva reserva) throws SQLException {
		ReservaDAO model = new ReservaDAO();
		model.update(reserva);
	}
	
	
	public void delete(Reserva reserva) throws SQLException {
		ReservaDAO model = new ReservaDAO();
		model.delete(reserva);
	}
}