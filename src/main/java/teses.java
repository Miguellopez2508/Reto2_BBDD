import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import Conexion.Textos;

public class teses {

	
	Textos text = new Textos();
	
	@Test
	public void test() {
		String loc = "C:\\Users\\in1DM3b_01\\Desktop\\archivoEntrada.csv";
		
		
		System.out.println(Arrays.toString(text.leerCsv(loc)));
	}

}
