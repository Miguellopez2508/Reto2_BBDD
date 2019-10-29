package Controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class EmpleadoControlador implements Initializable{
	
	private Main main;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
    @FXML
    void btnAtrasEmpleado(ActionEvent event) {
    	
    	Main.controlador.CambiarScene("Principal.fxml");

    }


}
