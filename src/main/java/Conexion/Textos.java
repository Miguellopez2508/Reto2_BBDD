package Conexion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Textos {
	
	/**
	 * Separa los datos dados en un .txt y los mete en un  array de strings
	 * @param datosBD El .txt
	 * @return Devuelve un array con los datos url, database, user, password
	 */
	public String[] cogerDatosDeFichero(String datosBD) {
		String[] datos = new String[4];
		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		try {
			fileReader = new FileReader(datosBD);
			buffer = new BufferedReader(fileReader);
			String linea = "";
			String clave = "";
			String dato = "";
			
			while ((linea = buffer.readLine()) != null) {
				clave = linea.substring(0, linea.indexOf(":"));
				dato = linea.substring(linea.indexOf(":") + 2);
				
				switch (clave) {
					case "url": datos[0] = dato; break;
					case "database": datos[1] = dato; break;
					case "user": datos[2] = dato; break;
					case "password": datos[3] = dato; break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				fileReader.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return datos;
	}
	

	public String[][] leerXml(String archivoEntrada){
		
		String[][] datos = new String[6][1];
		
		try {

			File fXmlFile = new File(archivoEntrada);
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
					
			doc.getDocumentElement().normalize();
					
			NodeList nList = doc.getElementsByTagName("empleado");
					

			for (int temp = 0; temp < nList.getLength(); temp++) {
 
				Node nNode = nList.item(temp);
						
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					
					datos[0][temp] =  eElement.getElementsByTagName("Salario").item(0).getTextContent();
					datos[1][temp] =  eElement.getElementsByTagName("Nombre").item(0).getTextContent();
					datos[2][temp] =  eElement.getElementsByTagName("Apellido").item(0).getTextContent();
					datos[3][temp] =  eElement.getElementsByTagName("Responsabilidad").item(0).getTextContent();
					datos[4][temp] =  eElement.getElementsByTagName("Gerente").item(0).getTextContent();
					datos[5][temp] =  eElement.getElementsByTagName("DeptCo").item(0).getTextContent();
					datos[6][temp] =  eElement.getElementsByTagName("EsJefe").item(0).getTextContent();
					

				} 
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		
		
		
			for (int x=0; x < datos.length; x++) 
			{
				for (int y=0; y < datos[x].length; y++) 
				{

					System.out.print (" " + datos[x][y] + " "); 

				}
				System.out.println();

			}	
		
		
		
		
			return datos;
			
		  }
	
	
	public String leerCsv(String archivoEntraStrg1) {
		
		try {     
			
			BufferedReader br = new BufferedReader(new FileReader(archivoEntraStrg1));
			String line = br.readLine();
			String acumulador = "";
			int i=1;
			
			while (null!=line) {

				String[] parts = line.split(";");
				acumulador = acumulador + "\n" + i + ". " + Arrays.toString(parts) + "\n";
				i++;
				line = br.readLine();
			}
			br.close();
			
			return acumulador;
			
		} catch (Exception e) {
			System.out.println("No se encuentra el archivo");
		}
		
		return "";
	}
	
	public String[] cogerDatosCsV(String datosBD) {
		String[] datos = new String[2];
		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		try {
			fileReader = new FileReader(datosBD);
			buffer = new BufferedReader(fileReader);
			String linea = "";
			String clave = "";
			String dato = "";
			
			while ((linea = buffer.readLine()) != null ) {
				int i = 1;
				String ii = String.valueOf(i);
				clave = linea.substring(0, linea.indexOf(":"));
				dato = linea.substring(linea.indexOf(":") + 2);
				
				switch (clave) {
					case ii + ". [": datos[0] = dato; break;
					case ", ": datos[1] = dato; break;
				}
				i++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				fileReader.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return datos;
	}
	
}
