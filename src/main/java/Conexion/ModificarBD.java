package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;



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
	
}
