package Controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class PruebaControlador implements Initializable{
	
	private Button boton;
	private Main main;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
    @FXML
    void handleButtonAction(ActionEvent event) {
    	
    	Main.controlador.CambiarScene("prueba2.fxml");

    }

}



