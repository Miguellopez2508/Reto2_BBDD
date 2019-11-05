package Controlador;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import Modelo.Empleado;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;


public class EmpleadoControlador implements Initializable{
	
	public JFXTextField tf1,tf2,tf3,tf4;
	public ComboBox<String> combo1, combo2;
	public CheckBox check1;
	public AnchorPane panel;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		 
		combo1.setItems(FXCollections.observableArrayList(Main.modelo.getGestor().obtenerGerentes()));
		combo2.setItems(FXCollections.observableArrayList(Main.modelo.getGestor().obtenerDepartamentos()));
	}
    @FXML
    void btnAtrasEmpleado(ActionEvent event) {
    	
    	Main.controlador.CambiarScene("Principal.fxml");

    }
    
    @FXML
    void btnAnadirEmpleado(ActionEvent event) {

    	ingresarEmpleado();
    
    	System.out.println(Main.modelo.getEmpleados().toString());
    }
    
    
    public void ingresarEmpleado() {
    	
    	Empleado empleado = new Empleado();
    	  	
    	if (Main.modelo.getGestorV().validarEmpleado(this)) {
    		String nombre = tf1.getText();
        	String apellido = tf2.getText();
        	String responsabilidad = tf3.getText(); 	
          	int salario = Integer.parseInt(tf4.getText());
          	
          	String gerente = combo1.getSelectionModel().getSelectedItem();
          	String deptco = combo2.getSelectionModel().getSelectedItem();
        
          	String[] parts1 = gerente.split("-");
          	String[] parts2 = deptco.split("-");
     
          	empleado.setNombre(nombre);
          	empleado.setApellido(apellido);
          	empleado.setResponsabilidad(responsabilidad);
          	empleado.setSalario(salario);
          	
          	empleado.setDeptco(Integer.parseInt(parts2[1]));     	
          	empleado.setGerente(Integer.parseInt(parts1[1]));
          	
          	if ((boolean) check1.isSelected() == true) {
          		empleado.setEsjefe(true);
          	}else {
          		empleado.setEsjefe(false);
          	}
          	
          	Main.modelo.getEmpleados().add(empleado);
          	
          	Main.modelo.getModificar().insertarEmpleados(Main.modelo.getEmpleados().get(0));
    	}
    	
    	
    	
    }


}
