package Controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class BuscarDepartamentosControlador implements Initializable{
	
	public TextArea textArea;
	public JFXTextField nombre;
	int contador = 1;
	
	ArrayList<String> departamentos = Main.modelo.getGestor().obtenerTodosLosDepartamentos();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		textArea.setText(departamentos.get(0));	
	}
	
	@FXML
    void btnBuscarBuscarDepartamentos(ActionEvent event) {	
		textArea.setText(Main.modelo.getGestor().obtenerDepartamentos(nombre.getText()));
    }
	
	@FXML
    void btnVolverBuscarDepartamentos(ActionEvent event) {	
    	Main.controlador.CambiarScene("Principal.fxml");
    }
	
	@FXML
    void btnSiguienteBuscarDepartamentos(ActionEvent event) {	
		if (contador < departamentos.size()){
			
			textArea.setText(departamentos.get(contador));
			contador = contador + 1;			
		}
    }
	
	@FXML
    void btnAtrasBuscarDepartamentos(ActionEvent event) { 	
		if (contador == departamentos.size()){
			contador = contador - 1;	
			textArea.setText(departamentos.get(contador));
		} else if (0 < contador) {
			contador = contador - 1;	
			textArea.setText(departamentos.get(contador));
		}
    }
	
	@FXML
    void btnPrimeroBuscarDepartamentos(ActionEvent event) {	
		textArea.setText(departamentos.get(0));
		contador = 0;
    }
	
	@FXML
    void btnUltimoBuscarDepartamentos(ActionEvent event) {	
		textArea.setText(departamentos.get(departamentos.size()-1));
		contador = departamentos.size()-1;
	}
	
	@FXML
    void btnLimpiarBuscarDepartamentos(ActionEvent event) {
		contador = 1;
		nombre.clear();
		textArea.setText(departamentos.get(0));
    }
}