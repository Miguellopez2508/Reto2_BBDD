package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class BuscarEmpleadosControlador implements Initializable{
	
	public TextArea textArea;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	@FXML
    void btnVolverBuscarEmpleados(ActionEvent event) {
    	
    	Main.controlador.CambiarScene("Principal.fxml");

    }
    
	
    

}
