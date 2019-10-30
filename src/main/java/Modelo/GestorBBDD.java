package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.ModificarBD;

public class GestorBBDD {
	
	ModificarBD modificar = new ModificarBD();
	
	
	public ArrayList<String> obtenerGerentes()
	{
		ResultSet result = modificar.verGerentes();
		ArrayList<String> gerentes = new ArrayList<String>();
		
		try {
			while(result.next()) {
				
				String nombre = result.getString("Nombre");
				String apellido = result.getString("Apellido");
				int ID = result.getInt("ID");
				
				String acumular = nombre + " " + apellido + " " + ID ;
				gerentes.add(acumular);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return gerentes;
	
	
	}

}
