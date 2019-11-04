package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Modelo.Departamento;
import Modelo.Empleado;
import Modelo.Modelo;


public class ModificarBD {
	
	Connection conn = null;
	ConexionBD pool = null;

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
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
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
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return result;
	}
	
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
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return result;
	}
	
	public ResultSet verGerentes() {
		
		PreparedStatement stmt = null;
		ResultSet result = null;	
		
		String query = "select Nombre, Apellido, ID from empleados where EsJefe = 1";
		
		try {
			stmt = conn.prepareStatement(query);
			result = stmt.executeQuery();
		}catch (SQLException e1){
			e1.printStackTrace();
		}
		
		return result;
		
	
	}
	
	
}
