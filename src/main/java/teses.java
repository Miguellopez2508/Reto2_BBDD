import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import Conexion.ModificarBD;
import Conexion.Textos;

public class teses {

	
	Textos text = new Textos();
	ModificarBD modi = new ModificarBD();
	
	@Test
	public void test() {
		String loc = "C:\\workspace\\Reto2_BBDD\\departamentos.csv";
		String datos[] = text.cogerDatosCsV(loc);
		
		for (int i = 0; i < datos.length; i = i + 2) {
			System.out.println(modi.insertarDepartamentos(datos, i));
		}
	}
	
	

}
