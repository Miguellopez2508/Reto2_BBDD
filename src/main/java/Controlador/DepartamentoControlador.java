package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXTextField;
import Modelo.Departamento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class DepartamentoControlador implements Initializable{
	
	public JFXTextField tf1,tf2;
	public AnchorPane panel;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	@FXML
    void btnAtrasDepartamento(ActionEvent event) {
    	
    	Main.controlador.CambiarScene("Principal.fxml");

    }
    
    @FXML
    void btnAnadirDepartamento(ActionEvent event) {

    	ingresarDepartamento();
    	
    }
    
    public void ingresarDepartamento() {
    	
    	Departamento departamento = new Departamento();
    	
    	if (Main.modelo.getGestorV().validarDepartamento(this)) {
    		
    		String nombre = tf1.getText();
    		String localizacion = tf2.getText();
    	
    		departamento.setNombre(nombre);
    		departamento.setUbicacion(localizacion);
    	    	
    		Main.modelo.getDepartamentos().add(departamento);  	
    		Main.modelo.getModificar().insertarDepartamentos(Main.modelo.getDepartamentos().get(0));
    		
    		Main.controlador.mostrarMensaje(panel, "Se ha añadido correctamente el departamento.");
        	tf1.clear();
        	tf2.clear();

    	}
    
    }
}
