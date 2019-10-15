package Reto2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConsultaBD {
	
		public ResultSet hacerConsultaBD (Connection con, String query) {
			ResultSet rs = null;
			
			try {
				Statement st = con.createStatement();
				rs = st.executeQuery(query);
			} catch (Exception e) {
				System.out.println("Error de conexion" + e);
			}
		
			return rs;
		}
		

		public boolean insertarDatosBD(Connection con, String query) {
			Statement st;
			try {
				st = con.createStatement();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Hubo un error de conexion", "Atencion!", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
				return false;
			}
			
			try {
				st.executeUpdate(query);
			} catch (Exception e){
				System.out.println(e.getMessage());
				return false;
			}

			return true;
		}

}
