package Controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class PrincipalControlador implements Initializable{
	
	private Main main;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
    @FXML
    void btnAnadirEmpleado(ActionEvent event) {
    	
    	Main.controlador.CambiarScene("Empleados.fxml");

    }

}
