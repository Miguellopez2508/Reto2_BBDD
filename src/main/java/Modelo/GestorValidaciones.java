package Modelo;


import java.util.regex.Pattern;
import Controlador.DepartamentoControlador;
import Controlador.EmpleadoControlador;
import Controlador.Main;

public class GestorValidaciones {

	Pattern letras = Pattern.compile("[a-z].*");
	 
	public boolean validarEmpleado(EmpleadoControlador panelEmple) {
		String pattern = "[0-9]+";
		
		
		if(panelEmple.tf1.getText().isEmpty()) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Campo 'Nombre' vacío.");
			return false;
		}
		if(panelEmple.tf1.getText().length() < 6 || panelEmple.tf1.getText().length() > 20) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Campo 'Nombre' debe medir entre 6 y 20 c.");
			return false;
		}
		if(panelEmple.tf2.getText().isEmpty()) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Campo 'Apellido' vacío.");
			return false;
		}
		if(panelEmple.tf2.getText().length() < 6 || panelEmple.tf1.getText().length() > 20) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Campo 'Apellido' debe medir entre 6 y 20 c.");
			return false;
		}
		if(panelEmple.tf3.getText().isEmpty()) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Campo 'Responsabilidad' vacío.");
			return false;
		}
		if(panelEmple.tf3.getText().length() < 6 || panelEmple.tf1.getText().length() > 20) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Campo 'Responsabilidad' debe medir entre 6 y 20 c.");
			return false;
		}
		if(panelEmple.tf4.getText().isEmpty()) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Campo 'Salario' vacío.");
			return false;
		}
		if(!panelEmple.tf4.getText().matches(pattern)) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Campo 'Salario' debe ser un número no decimal");
			return false;
		}
		if(panelEmple.combo1.getSelectionModel().getSelectedItem() == null) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Seleccione un gerente");
			return false;
		}
		if(panelEmple.combo2.getSelectionModel().getSelectedItem() == null) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Seleccione un departamaneto");
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
