import static org.junit.Assert.*;

import org.junit.Test;

import Conexion.ModificarBD;
import Conexion.Textos;

public class test2 {

	Textos text = new Textos();
	ModificarBD modi = new ModificarBD();
	
	@Test
	public void test() {
		String loc = "C:\\\\WORKSPACE\\\\Reto2_BBDD\\\\textos\\\\empleados.xml";
		String datos[][] = text.leerXml(loc);
		
		for (int i = 0; i < datos.length; i = i + 7) {
			System.out.println(modi.insertarEmpleados(datos, i));
		}
	}
}
