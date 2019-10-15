package Reto2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	
	
	
	public static void main(String[]  args) throws SQLException {
	
		prueba();
	
	}
	
	public static void prueba() throws SQLException {
		
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.ConectarBD();
		
		String query= "SELECT * FROM prueba";
		String nombre= "";
		String apellido= "";
		
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		
		while(rs.next()) {
			nombre = rs.getString("nombre");
			apellido = rs.getString("apellido");
		}
		
		System.out.println("nombre: " + nombre );
		System.out.println("apellido: " + apellido );
		}
}
