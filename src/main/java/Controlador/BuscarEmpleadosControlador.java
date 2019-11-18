package Controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BuscarEmpleadosControlador implements Initializable{
	
	public TextArea textArea;
	public JFXTextField nombre;
	public JFXTextField apellido;
	public JFXTextField ID;
	public Button uno, dos, tres, cuatro;
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
		if (contador < empleados.size()){
			textArea.setText(empleados.get(contador));
			contador = contador + 1;			
		}	
    }
	
	@FXML
    void btnAtrasBuscarEmpleados(ActionEvent event) {
		if (contador == empleados.size()){
			contador = contador - 1;	
			textArea.setText(empleados.get(contador));	
		} else if (0 < contador) {		
			contador = contador - 1;	
			textArea.setText(empleados.get(contador));
		}
    }
	
	@FXML
    void btnBuscarNombreBuscarEmpleados(ActionEvent event) {
    	textArea.setText(Main.modelo.getGestor().obtenerEmpleados(nombre.getText(), apellido.getText()));
    	
    	uno.setDisable(true);
    	dos.setDisable(true);
    	tres.setDisable(true);
    	cuatro.setDisable(true);
    }
	
	@FXML
    void btnBuscarIDBuscarEmpleados(ActionEvent event) {
		if (ID.getText().equals("")) {
			textArea.setText("Empleado no encontrado");
		} else {
			textArea.setText(Main.modelo.getGestor().obtenerEmpleadosPorID(Integer.parseInt(ID.getText())));
		}

    	uno.setDisable(true);
    	dos.setDisable(true);
    	tres.setDisable(true);
    	cuatro.setDisable(true);
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
	
	@FXML
	void btnLimpiarBuscarEmpleados(ActionEvent event) {  	
		contador = 1;
		nombre.clear();
		apellido.clear();
		ID.clear();
		textArea.setText(empleados.get(0));
		
		uno.setDisable(false);
    	dos.setDisable(false);
    	tres.setDisable(false);
    	cuatro.setDisable(false);
	}
}
