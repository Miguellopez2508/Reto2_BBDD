package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
	
	private Connection conexion = null;
	private final String driver = "com.mysql.cj.jdbc.Driver";
	private final String username = "reto2";
	private final String password = "12345";
	private final String urlBBDD = "jdbc:mysql://localhost:3306/reto2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	public Connection ConectarBD()
	{
		
		try
		{
			Class.forName(driver);
			conexion = DriverManager.getConnection(urlBBDD, username, password);
		
		}
			catch (Exception e) {		
				System.out.println("Error de conexion " + e);
			}
		return conexion;
	}

}
