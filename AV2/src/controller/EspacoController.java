package controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Espaco;
import model.EspacoDAO;

public class EspacoController {
	public void create(Espaco espaco) throws SQLException {
		EspacoDAO model = new EspacoDAO();
		model.create(espaco);
	}
	
	public List<Espaco> read() {
		List<Espaco> lista = new ArrayList<Espaco>();
		EspacoDAO model = new EspacoDAO();
		lista = model.read();
		return lista;
	}
	
	
	public void update(String espaco,String situacao) {
		EspacoDAO model = new EspacoDAO();
		model.update(espaco,situacao);
	}
	
	
	public void delete(Espaco espaco) throws SQLException {
		
		EspacoDAO model = new EspacoDAO();
		model.delete(espaco);
	}
}
