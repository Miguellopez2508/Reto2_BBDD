package Modelo;

import java.util.ArrayList;

public class Modelo {
	
	ArrayList<Empleado> empleados ;
	ArrayList<Departamento> departamentos ;
	
	public Modelo() {
		
		this.empleados = new ArrayList<Empleado>();
		this.departamentos =  new ArrayList<Departamento>();
		
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
