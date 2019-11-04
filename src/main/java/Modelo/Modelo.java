package Modelo;

import java.util.ArrayList;

import Conexion.ModificarBD;

public class Modelo {
	
	private ArrayList<Empleado> empleados ;
	private ArrayList<Departamento> departamentos;
	private ModificarBD modificar;
	private GestorBBDD gestor;
	public boolean primeraVez;
	
	public Modelo() {
		
		this.empleados = new ArrayList<Empleado>();
		this.departamentos =  new ArrayList<Departamento>();
		this.modificar = new ModificarBD();
		this.gestor = new GestorBBDD(this.modificar);
		this.primeraVez = false;
		
	}

	public GestorBBDD getGestor() {
		return gestor;
	}

	public void setGestor(GestorBBDD gestor) {
		this.gestor = gestor;
	}

	public ModificarBD getModificar() {
		return modificar;
	}

	public void setModificar(ModificarBD modificar) {
		this.modificar = modificar;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}

	public ArrayList<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(ArrayList<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

}
