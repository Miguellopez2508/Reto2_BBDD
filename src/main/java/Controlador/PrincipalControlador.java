package Controlador;

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



}
