package Controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class BuscarEmpleadosControlador implements Initializable{
	
	public TextArea textArea;
	public JFXTextField nombre;
	public JFXTextField apellido;
	ArrayList<String> empleados = Main.modelo.getGestor().obtenerTodosLosEmpleados();
	int contador = 1;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

			textArea.setText(empleados.get(0));
		
		
	}
	
	@FXML
    void btnVolverBuscarEmpleados(ActionEvent event) {
    	
    	Main.controlador.CambiarScene("Principal.fxml");

    }
    
	@FXML
    void btnSiguienteBuscarEmpleados(ActionEvent event) {

		
		if (contador != empleados.size()){
			
			textArea.setText(empleados.get(contador));
			contador = contador + 1;			
		}
			
	
    }
	
	@FXML
    void btnAtrasBuscarEmpleados(ActionEvent event) {
		
	

		if (contador == empleados.size()){
	
			contador = contador - 1;	
			System.out.println(contador);
			textArea.setText(empleados.get(contador));
		
		} else if (contador == 0){
			
			textArea.setText(empleados.get(0));
	
		} 
			
		else if (contador != -1){
			
			contador = contador - 1;
			textArea.setText(empleados.get(contador));	
			
		} 
	
    }
	
	@FXML
    void btnBuscarBuscarEmpleados(ActionEvent event) {
    	
    	textArea.setText(Main.modelo.getGestor().obtenerEmpleados(nombre.getText(), apellido.getText()));

    }
	
	@FXML
    void btnUltimoBuscarEmpleados(ActionEvent event) {
    	
		textArea.setText(empleados.get(empleados.size()-1));
		contador = empleados.size()-1;
    }
	
	@FXML
	void btnPrimeroBuscarEmpleados(ActionEvent event) {
	    	
			textArea.setText(empleados.get(0));
			contador = 0;
	}

}
