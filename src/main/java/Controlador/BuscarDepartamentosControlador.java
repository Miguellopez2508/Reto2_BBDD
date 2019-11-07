package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class BuscarDepartamentosControlador implements Initializable{
	
	public TextArea textArea;
	public JFXTextField nombre;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	@FXML
    void btnVolverBuscarDepartamentos(ActionEvent event) {
    	
    	Main.controlador.CambiarScene("Principal.fxml");

    }
	
	@FXML
    void btnBuscarBuscarDepartamentos(ActionEvent event) {
    	
    	textArea.setText(Main.modelo.getGestor().obtenerDepartamentos(nombre.getText()));

    }
	
}