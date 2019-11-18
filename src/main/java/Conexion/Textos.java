package Conexion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Logger.Log;
import Modelo.Empleado;
import Modelo.Departamento;
import Modelo.Modelo;


public class Textos {
	
	Modelo modelo;
	Log log = Log.getInstance();
	
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
			log.escribirLogger(e.getMessage(), this);

		} finally {
			try {
				fileReader.close();
			} catch (Exception e2) {
				log.escribirLogger(e2.getMessage(), this);
			}
		}
		
		return datos;
	}
	
	/**
	 * 
	 * @param archivoEntrada
	 */
	public void leerXml(String archivoEntrada){
		try {
			File fXmlFile = new File(archivoEntrada);
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
					
			doc.getDocumentElement().normalize();
					
			NodeList nList = doc.getElementsByTagName(doc.getDocumentElement().getNodeName());
			
			NodeList nList2 = doc.getElementsByTagName("empleado");
			 
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
							 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
							
					for (int i =0; i < nList2.getLength() ; i++){
						
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
	    	log.escribirLogger(e.getMessage(), this);
	    }		
	}
		

	/**
	 * Coge los datos de un csv, los formatea y los mete en el modelo
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
			log.escribirLogger(e.getMessage(), this);
		}	
	}	
}
