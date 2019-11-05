package Modelo;


import java.util.regex.Pattern;
import Controlador.DepartamentoControlador;
import Controlador.EmpleadoControlador;
import Controlador.Main;

public class GestorValidaciones {

	Pattern letras = Pattern.compile("[a-z].*");
	 
	public boolean validarEmpleado(EmpleadoControlador panelEmple) {
		if(panelEmple.tf1.getText().isEmpty()) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Campo 'Nombre' vacío.");
			return false;
		}
		
		return true;
	}
	
	public boolean validarDepartamento(DepartamentoControlador panelDepart) {
		
		
		if(panelDepart.tf1.getText().isEmpty()) {
			Main.controlador.mostrarMensaje(panelDepart.panel, "Campo 'Nombre' vacío.");
			return false;
		}
		
		else if(panelDepart.tf2.getText().isEmpty()) {
			Main.controlador.mostrarMensaje(panelDepart.panel, "Campo 'Localizacion' vacío.");
			return false;
		}
		
		
		return true;
	}
}
