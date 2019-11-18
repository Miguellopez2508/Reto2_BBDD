package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Logger.Log;
import Modelo.Departamento;
import Modelo.Empleado;

public class ModificarBD {
	
	Connection conn = null;
	ConexionBD pool = null;
	Log log = Log.getInstance();
	
	public ModificarBD() {
		pool = new ConexionBD();
		conectar();
	}
	
	/**
	 * Pide una conexion al pool de conexiones y la almacena en el atributo 'conn'
	 */
	private void conectar() {
		try {
			conn = pool.getConnection();
			log.escribirLogger("Conexión realizada con éxito", this);
		} catch (SQLException e) {
			log.escribirLogger(e.getMessage(), this);
		}
	}
	
	/**
	 * 
	 * @param departamento
	 * @return
	 */
	public ResultSet insertarDepartamentos(Departamento departamento) {
		PreparedStatement stmt = null;
		ResultSet result = null;
		String query = "INSERT INTO Departamento (`Nombre`, `Ubicación`) VALUES (?, ?)";
		try {
			stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, departamento.getNombre());
			stmt.setString(2, departamento.getUbicacion());
			stmt.executeUpdate();
			result = stmt.getGeneratedKeys();
			log.escribirLogger("Se insertó correctamente el departamento con nombre " + departamento.getNombre(), this);
		} catch (SQLException e1) {
			log.escribirLogger(e1.getMessage(), this);
		}
		return result;
	}
	
	/**
	 * 
	 * @param empleados
	 * @return
	 */
	public ResultSet insertarEmpleados(Empleado empleados) {
		PreparedStatement stmt = null;
		ResultSet result = null;
		String query = "INSERT INTO empleados (`Salario`, `Nombre`, `Apellido` ,`Responsabilidad` ,`Gerente`, `DeptCo`, `EsJefe`) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setFloat (1, empleados.getSalario());
			stmt.setString(2, empleados.getNombre());
			stmt.setString(3, empleados.getApellido());
			stmt.setString(4, empleados.getResponsabilidad());
			stmt.setInt(5, empleados.getGerente());
			stmt.setInt(6, empleados.getDeptco());
			stmt.setBoolean(7, empleados.getEsjefe());
			
			stmt.executeUpdate();
			result = stmt.getGeneratedKeys();
			log.escribirLogger("Se insertó correctamente el empleado con nombre " + empleados.getNombre(), this);
			
		} catch (SQLException e1) {
			log.escribirLogger(e1.getMessage(), this);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @return
	 */
	public ResultSet verGerentes() {	
		PreparedStatement stmt = null;
		ResultSet result = null;	
		
		String query = "select Nombre, Apellido, ID from empleados where EsJefe = 1";
		
		try {
			stmt = conn.prepareStatement(query);
			result = stmt.executeQuery();
		}catch (SQLException e1){
			log.escribirLogger(e1.getMessage(), this);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @return
	 */
	public ResultSet verDepartamentos() {	
		PreparedStatement stmt = null;
		ResultSet result = null;	
		
		String query = "select Nombre, DeptCo from departamento";
		
		try {
			stmt = conn.prepareStatement(query);
			result = stmt.executeQuery();
		}catch (SQLException e1){
			log.escribirLogger(e1.getMessage(), this);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param nombre
	 * @param apellido
	 * @return
	 */
	public ResultSet buscarEmpleado(String nombre, String apellido) {
		PreparedStatement stmt = null;
		ResultSet result = null;	
		
		String query = "select * from empleados where Nombre ='" + nombre + "' and Apellido ='" + apellido +"'";
		
		try {
			stmt = conn.prepareStatement(query);
			result = stmt.executeQuery();
		}catch (SQLException e1){
			log.escribirLogger(e1.getMessage(), this);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param nombre
	 * @return
	 */
	public ResultSet buscarDepartamento(String nombre) {
		PreparedStatement stmt = null;
		ResultSet result = null;	
		
		String query = "select * from departamento where Nombre ='" + nombre + "'";
		
		try {
			stmt = conn.prepareStatement(query);
			result = stmt.executeQuery();
		}catch (SQLException e1){
			log.escribirLogger(e1.getMessage(), this);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @return
	 */
	public ResultSet verTodosLosEmpleados() {	
		PreparedStatement stmt = null;
		ResultSet result = null;	
		
		String query = "select * from empleados";
		
		
		try {
			stmt = conn.prepareStatement(query);
			result = stmt.executeQuery();
		}catch (SQLException e1){
			log.escribirLogger(e1.getMessage(), this);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @return
	 */
	public ResultSet verTodosLosDepartamentos() {
		PreparedStatement stmt = null;
		ResultSet result = null;	
		
		String query = "select * from departamento";
		
		
		try {
			stmt = conn.prepareStatement(query);
			result = stmt.executeQuery();
		}catch (SQLException e1){
			log.escribirLogger(e1.getMessage(), this);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param ID
	 * @return
	 */
	public ResultSet buscarEmpleadosPorID(int ID) {	
		PreparedStatement stmt = null;
		ResultSet result = null;	
		
		String query = "select * from empleados where ID =" + ID ;
		
		try {
			stmt = conn.prepareStatement(query);
			result = stmt.executeQuery();
		}catch (SQLException e1){
			log.escribirLogger(e1.getMessage(), this);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @return
	 */
	public ResultSet crearPrimeraVez() {
		PreparedStatement stmt = null;
		ResultSet result = null;	
		
		String query = "insert into primeraVez(`PrimeraVez`) values (CURRENT_TIMESTAMP(6))";
		
		try {
			stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
			result = stmt.getGeneratedKeys();
		}catch (SQLException e1){
			log.escribirLogger(e1.getMessage(), this);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @return
	 */
	public ResultSet comprobarPrimeraVez() {	
		PreparedStatement stmt = null;
		ResultSet result = null;	
		
		String query = "select * from primeraVez";
		
		try {
			stmt = conn.prepareStatement(query);
			result = stmt.executeQuery();
		}catch (SQLException e1){
			log.escribirLogger(e1.getMessage(), this);
		}
		
		return result;
	}
}
