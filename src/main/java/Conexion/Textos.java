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

import Modelo.Empleado;
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
	

	public void leerXml(String archivoEntrada){
		
		
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
						
						Empleado empleado = new Empleado();
						
						int salario = Integer.parseInt(eElement.getElementsByTagName("salario").item(i).getTextContent());
						String nombre = eElement.getElementsByTagName("nombre").item(i).getTextContent();
						String apellido = eElement.getElementsByTagName("apellido").item(i).getTextContent();
						String responsabilidad = eElement.getElementsByTagName("responsabilidad").item(i).getTextContent();
						int gerente = Integer.parseInt(eElement.getElementsByTagName("gerente").item(i).getTextContent());
						int deptco = Integer.parseInt(eElement.getElementsByTagName("deptco").item(i).getTextContent());
						boolean esjefe = Boolean.parseBoolean(eElement.getElementsByTagName("esjefe").item(i).getTextContent());
						
						empleado.setSalario(salario);
						empleado.setNombre(nombre);
						empleado.setApellido(apellido);
						empleado.setResponsabilidad(responsabilidad);
						empleado.setGerente(gerente);
						empleado.setDeptco(deptco);
						empleado.setEsjefe(esjefe);					
						
						
						modelo.getEmpleados().add(empleado);
						
					}
			
					

				} 
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }		
		

			
		  }
	
	
	public void pasarDatosEmpleados() {
		
		
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
	

	/**
	 * 
	 * @param datosBD
	 * @return
	 */

	public String[] cogerDatosCsV(String datosBD) {
		String[] datos = new String[6];
		FileReader fileReader = null;
		BufferedReader buffer = null;	
		
		try {
			fileReader = new FileReader(datosBD);
			buffer = new BufferedReader(fileReader);
			
			String linea = "";
			int i=0;
			
			while ((linea = buffer.readLine()) != null ) {
				String[] parts = linea.split(";");
				
				if (!Arrays.toString(parts).equals("[Nombre, Ubicacion]")) {
					datos[i] = parts[0];
					datos[i+1] = parts[1];
					i = i + 2;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return datos;
	}
	
}
