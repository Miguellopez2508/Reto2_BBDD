package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Modelo.Empleado;



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

	public ResultSet selectDePrueba() {
		PreparedStatement stmt = null;
		ResultSet result = null;
		String query = "SELECT DeptCo from departamento";
		
		try {
			stmt = conn.prepareStatement(query);
			result = stmt.executeQuery();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Inserta un departamento y su ubicacion
	 * @param datos
	 * @param i Es la vuelta que da en los datos originales en formato String[]
	 * @return
	 */
	public ResultSet insertarDepartamentos(String[] datos, int i) {
		PreparedStatement stmt = null;
		ResultSet result = null;
		String query = "INSERT INTO Departamento (`Nombre`, `Ubicación`) VALUES (?, ?)";
		try {
			stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, datos[i]);
			stmt.setString(2, datos[i + 1]);
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
	
}
