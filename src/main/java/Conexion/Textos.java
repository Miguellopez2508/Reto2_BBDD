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

import Modelo.Departamento;
import Modelo.Modelo;


public class Textos {
	
	Modelo modelo;
	
	public Textos (Modelo modelo) {
		this.modelo = modelo;
	}
	
	
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
		
		String[][] datos = new String[7][3];
		
		try {

			File fXmlFile = new File(archivoEntrada);
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
					
			doc.getDocumentElement().normalize();
					
			NodeList nList = doc.getElementsByTagName(doc.getDocumentElement().getNodeName());
			
			 
			for (int temp = 0; temp < nList.getLength(); temp++) {
 
				Node nNode = nList.item(temp);
							 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					
					
					for (int i =0; i < 3; i++){
						datos[0][i] = eElement.getElementsByTagName("salario").item(i).getTextContent();
						datos[1][i] = eElement.getElementsByTagName("nombre").item(i).getTextContent();
						datos[2][i] = eElement.getElementsByTagName("apellido").item(i).getTextContent();
						datos[3][i] = eElement.getElementsByTagName("responsabilidad").item(i).getTextContent();
						datos[4][i] = eElement.getElementsByTagName("gerente").item(i).getTextContent();
						datos[5][i] = eElement.getElementsByTagName("deptco").item(i).getTextContent();
						datos[6][i] = eElement.getElementsByTagName("esjefe").item(i).getTextContent();
						
						modelo.
						
					}
			
					

				} 
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }		
		
			
			return datos;
			
		  }
	
	
	public void pasarDatosEmpleados() {
		
		
	}
	
	

	
	

	/**
	 * 
	 * @param datosBD
	 */
	public void cogerDatosCsV(String datosBD) {
		
		FileReader fileReader = null;
		BufferedReader buffer = null;
		Departamento departamento;
		
		try {
			fileReader = new FileReader(datosBD);
			buffer = new BufferedReader(fileReader);
			
			String linea = "";
			
			
			while ((linea = buffer.readLine()) != null ) {
				String[] parts = linea.split(";");
				
				if (!Arrays.toString(parts).equals("[Nombre, Ubicacion]")) {
					departamento = new Departamento();
					departamento.setNombre(parts[0]); 
					departamento.setUbicacion(parts[1]);
					modelo.getDepartamentos().add(departamento);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
