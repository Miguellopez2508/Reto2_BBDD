package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.ModificarBD;


public class GestorBBDD {
	
	ModificarBD modificar;

	public GestorBBDD(ModificarBD modificar) {
		this.modificar = modificar;
	}
	
	public ArrayList<String> obtenerGerentes()
	{
		ResultSet result = modificar.verGerentes();
		ArrayList<String> gerentes = new ArrayList<String>();
		
		try {
			while(result.next()) {
				
				String nombre = result.getString("Nombre");
				String apellido = result.getString("Apellido");
				int ID = result.getInt("ID");
				
				String acumular = nombre + " " + apellido + "-" + ID ;
				gerentes.add(acumular);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return gerentes;
	
	
	}
	
	public ArrayList<String> obtenerDepartamentos()
	{
		ResultSet result = modificar.verDepartamentos();
		ArrayList<String> gerentes = new ArrayList<String>();
		
		try {
			while(result.next()) {
				String nombre = result.getString("Nombre");
				int ID = result.getInt("DeptCo");
				
				String acumular = nombre + "-" + ID;
				gerentes.add(acumular);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return gerentes;
	
	
	}
	
	public String obtenerEmpleados(String nombre, String apellido)
	{
		ResultSet result = modificar.buscarEmpleado(nombre, apellido);	
		String acumular = "";
		try {
			while(result.next()) {
				String nombre1 = result.getString("Nombre");
				String apellido1 = result.getString("Apellido");
				String responsabilidad = result.getString("Responsabilidad");
				int salario = result.getInt("Salario");
				int ID = result.getInt("ID");
				int gerente = result.getInt("Gerente");
				int deptco = result.getInt("DeptCo");
				int esjefe = result.getInt("EsJefe");
				
				acumular += "ID: " + ID + "\n" +
							"Nombre: " + nombre1 + "\n" +
							"Apellido: " + apellido1 + "\n" +
							"Salario: " + salario + "\n" +
							"Responsabilidad: " + responsabilidad + "\n" + 
							"Gerente: " + gerente + "\n" +
							"DeptCo: " + deptco + "\n" +
							"EsJefe: " + esjefe + "\n" + "\n";			

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (acumular == "") {
			acumular= "Empleado no encontrado";
		}
			
		
		return acumular;
	
	
	}
	
	public String obtenerDepartamentos(String nombre)
	{
		ResultSet result = modificar.buscarDepartamento(nombre);
		String acumular = "";
		try {
			while(result.next()) {
				int id = result.getInt("DeptCo");
				String nombre1 = result.getString("Nombre");
				String ubicacion = result.getString("Ubicaci�n");

				
				acumular += "Codigo: " + id + "\n" +
							"Nombre: " + nombre1 + "\n" +
							"Ubicacion: " + ubicacion + "\n" + "\n";			

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (acumular == "") {
			acumular= "Departamento no encontrado";
		}
			
		
		return acumular;
	
	
	}
	
	public String obtenerEmpleadosPorID(int ID)
	{
		ResultSet result = modificar.buscarEmpleadosPorID(ID);	
		String acumular = "";
		try {
			while(result.next()) {
				String nombre1 = result.getString("Nombre");
				String apellido1 = result.getString("Apellido");
				String responsabilidad = result.getString("Responsabilidad");
				int salario = result.getInt("Salario");
				int ID1 = result.getInt("ID");
				int gerente = result.getInt("Gerente");
				int deptco = result.getInt("DeptCo");
				int esjefe = result.getInt("EsJefe");
				
				acumular += "ID: " + ID1 + "\n" +
							"Nombre: " + nombre1 + "\n" +
							"Apellido: " + apellido1 + "\n" +
							"Salario: " + salario + "\n" +
							"Responsabilidad: " + responsabilidad + "\n" + 
							"Gerente: " + gerente + "\n" +
							"DeptCo: " + deptco + "\n" +
							"EsJefe: " + esjefe + "\n" + "\n";			

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (acumular == "") {
			acumular= "Empleado no encontrado";
		}
			
		
		return acumular;
	
	}

	
	public ArrayList<String> obtenerTodosLosEmpleados()
	{
		ResultSet result = modificar.verTodosLosEmpleados();
		String acumular="";
		ArrayList<String> empleados = new ArrayList<String>();
		
		try {
			while(result.next()) {
				
				int ID = result.getInt("ID");
				int salario = result.getInt("Salario");
				String nombre1 = result.getString("Nombre");
				String apellido1 = result.getString("Apellido");
				String responsabilidad = result.getString("Responsabilidad");			
				int gerente = result.getInt("Gerente");
				int deptco = result.getInt("DeptCo");
				int esjefe = result.getInt("EsJefe");
				
				acumular = 	"ID: " + ID + "\n" +
						"Nombre: " + nombre1 + "\n" +
						"Apellido: " + apellido1 + "\n" +
						"Salario: " + salario + "\n" +
						"Responsabilidad: " + responsabilidad + "\n" + 
						"Gerente: " + gerente + "\n" +
						"DeptCo: " + deptco + "\n" +
						"EsJefe: " + esjefe;	
				
				empleados.add(acumular);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return empleados;
	
	
	}
	
	public ArrayList<String> obtenerTodosLosDepartamentos()
	{
		ResultSet result = modificar.verTodosLosDepartamentos();
		String acumular="";
		ArrayList<String> departamentos = new ArrayList<String>();
		
		try {
			while(result.next()) {
				int id = result.getInt("DeptCo");
				String nombre = result.getString("Nombre");
				String ubicacion = result.getString("Ubicaci�n");
		
				
				acumular = 	"Codigo: " + id + "\n" +
							"Nombre: " + nombre + "\n" +
							"Ubicacion: " + ubicacion;
								
				
				departamentos.add(acumular);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return departamentos;
	}
	
	/**
	 * 
	 * @return
	 */
	public String obtenerTodosLosEmpleadosEnString() {
		ResultSet result = modificar.verTodosLosEmpleados();
		String acumular="";
		
		try {
			while(result.next()) {
				
				int ID = result.getInt("ID");
				int salario = result.getInt("Salario");
				String nombre1 = result.getString("Nombre");
				String apellido1 = result.getString("Apellido");
				String responsabilidad = result.getString("Responsabilidad");			
				int gerente = result.getInt("Gerente");
				int deptco = result.getInt("DeptCo");
				int esjefe = result.getInt("EsJefe");
				
				acumular += 	"ID: " + ID + "\r\n" +
						"Nombre: " + nombre1 + "\r\n" +
						"Apellido: " + apellido1 + "\r\n" +
						"Salario: " + salario + "\r\n" +
						"Responsabilidad: " + responsabilidad + "\r\n" + 
						"Gerente: " + gerente + "\r\n" +
						"DeptCo: " + deptco + "\r\n" +
						"EsJefe: " + esjefe + "\r\n" + "------------" + "\r\n";	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return acumular;
	}
	
	/**
	 * 
	 * @return
	 */
	public String obtenerTodosLosDepartamentosString() {
		ResultSet result = modificar.verTodosLosDepartamentos();
		String acumular="";
		
		try {
			while(result.next()) {
				
				int id = result.getInt("DeptCo");
				String nombre = result.getString("Nombre");
				String ubicacion = result.getString("Ubicaci�n");
		
				acumular += "C�digo: " + id + "\r\n" +
						"Nombre: " + nombre + "\r\n" +
						"Ubicacion: " + ubicacion + "\r\n" + "------------" + "\r\n";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return acumular;
	}
	
	
}
