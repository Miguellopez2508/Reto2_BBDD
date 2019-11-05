package Modelo;

import Controlador.EmpleadoControlador;
import Controlador.Main;

public class GestorValidaciones {

	public boolean validarEmpleado(EmpleadoControlador panelEmple) {
		if(panelEmple.tf1.getText().isEmpty()) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Campo 'Nombre' vacío.");
			return false;
		}
		
		return true;
	}
	
	
}
