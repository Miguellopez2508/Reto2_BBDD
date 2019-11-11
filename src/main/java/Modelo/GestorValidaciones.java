package Modelo;




import Controlador.DepartamentoControlador;
import Controlador.EmpleadoControlador;
import Controlador.Main;


public class GestorValidaciones {
	 
	public boolean validarEmpleado(EmpleadoControlador panelEmple) {
		String pattern = "\\d*";
		
		
		if(panelEmple.tf1.getText().isEmpty()) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Campo 'Nombre' vac�o.");
			return false;
		}
		if(panelEmple.tf1.getText().length() < 3 || panelEmple.tf1.getText().length() > 20) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Campo 'Nombre' debe medir entre 3 y 20 caracteres.");
			return false;
		}
		if(panelEmple.tf2.getText().isEmpty()) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Campo 'Apellido' vac�o.");
			return false;
		}
		if(panelEmple.tf2.getText().length() < 4 || panelEmple.tf1.getText().length() > 20) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Campo 'Apellido' debe medir entre 4 y 20 caracteres.");
			return false;
		}
		if(panelEmple.tf3.getText().isEmpty()) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Campo 'Responsabilidad' vac�o.");
			return false;
		}
		if(panelEmple.tf3.getText().length() < 6 || panelEmple.tf1.getText().length() > 20) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Campo 'Responsabilidad' debe medir entre 6 y 20 caracteres.");
			return false;
		}
		if(panelEmple.tf4.getText().isEmpty()) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Campo 'Salario' vac�o.");
			return false;
		}	
		
		if(!panelEmple.tf4.getText().matches(pattern)) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Campo 'Salario' debe ser un n�mero entero");
			return false;
		}
		if(Integer.parseInt(panelEmple.tf4.getText()) < 0 ) {
			Main.controlador.mostrarMensaje(panelEmple.panel, "Campo 'Salario' es negativo.");
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
			Main.controlador.mostrarMensaje(panelDepart.panel, "Campo 'Nombre' vac�o.");
			return false;
		}
		
		else if(panelDepart.tf2.getText().isEmpty()) {
			Main.controlador.mostrarMensaje(panelDepart.panel, "Campo 'Localizacion' vac�o.");
			return false;
		}
		
		
		return true;
	}
}
