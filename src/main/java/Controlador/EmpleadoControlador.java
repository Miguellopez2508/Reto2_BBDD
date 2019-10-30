package Controlador;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import Modelo.Empleado;
import Modelo.Modelo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;

public class EmpleadoControlador implements Initializable{
		
	Modelo modelo;
	
	private Main main;
	public JFXTextField tf1,tf2,tf3,tf4;
	public ComboBox combo1, combo2;
	public CheckBox check1;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
    @FXML
    void btnAtrasEmpleado(ActionEvent event) {
    	
    	Main.controlador.CambiarScene("Principal.fxml");

    }
    
    @FXML
    void btnAnadirEmpleado(ActionEvent event) {

    	ingresarEmpleado();
    
    	System.out.println(modelo.getEmpleados().toString());
    }
    
    
    public void ingresarEmpleado() {
    	
    	Empleado empleado = new Empleado();
    	  	
    	String nombre = tf1.getText();
    	String apellido = tf2.getText();
    	String responsabilidad = tf3.getText(); 	
      	int salario = Integer.parseInt(tf4.getText());
      	
      	empleado.setNombre(nombre);
      	empleado.setApellido(apellido);
      	empleado.setResponsabilidad(responsabilidad);
      	empleado.setSalario(salario);
      	
      //	empleado.setDeptco(1);
      //	empleado.setGerente(1);
      	
      	if ((boolean) check1.isSelected() == true) {
      		empleado.setEsjefe(true);
      	}else {
      		empleado.setEsjefe(false);
      	}
      	
      //	modelo.getEmpleados().add(empleado);
      	

    	
    }


}
