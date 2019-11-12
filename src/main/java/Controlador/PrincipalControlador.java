package Controlador;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class PrincipalControlador implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
    @FXML
    void btnAnadirEmpleado(ActionEvent event) {
    	
    	Main.controlador.CambiarScene("Empleados.fxml");

    }
    
    @FXML
    void btnAnadirDepartamento(ActionEvent event) {
    	
    	Main.controlador.CambiarScene("Departamentos.fxml");

    }
    
    @FXML
    void btnBuscarEmpleados(ActionEvent event) {
    	
    	Main.controlador.CambiarScene("BuscarEmpleados.fxml");

    }
    
    @FXML
    void btnBuscarDepartamentos(ActionEvent event) {
    	
    	Main.controlador.CambiarScene("BuscarDepartamentos.fxml");

    }
    
    @FXML
    void btnImprimir(ActionEvent event) {
    	String informe = "";
		FileWriter fichero = null;
		
    	informe = "EMPLEADOS\r\n" + "------------" + "\r\n" + Main.modelo.getGestor().obtenerTodosLosEmpleadosEnString();
    	informe += "\r\nDEPARTAMENTOS\r\n" + "------------" + "\r\n" + Main.modelo.getGestor().obtenerTodosLosDepartamentosString();
    	
    	try {
			fichero = new FileWriter(System.getProperty("user.dir") + "\\informe.txt",false);
			fichero.write(informe);
			fichero.close();
		} catch (Exception ex) {
			ex.getStackTrace();
		}
    	
    	
    	try {
    		File archivo = new File(System.getProperty("user.dir") + "\\informe.txt");
    		Desktop.getDesktop().open(archivo);
    	} catch (Exception ex) {
    		ex.getStackTrace();
    	}
    }
}
