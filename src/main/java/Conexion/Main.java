package Conexion;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
	
	
	
	public static void main(String[]  args) throws SQLException {
	
		Textos misTextos = new Textos();
		prueba();
		System.out.println(misTextos.leerXml("C:\\WORKSPACE\\Reto2_BBDD\\textos\\empleados.xml"));
	
	}
	
	public static void prueba() throws SQLException {
		
		ModificarBD modificador = new ModificarBD();
		
		ResultSet resultado = modificador.selectDePrueba();
		
		
		//----------------------------
		
		ArrayList<Integer> codigos = new ArrayList<Integer>();
		
		try {
			while (resultado.next()) {
				int  codigo = resultado.getInt("DeptCo");
				codigos.add(codigo);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (Integer integer : codigos) {
			System.out.println(integer);
		}
	}
}
