package Modelo;

import java.util.ArrayList;

public class Modelo {
	
	ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
	
	public Modelo(ArrayList<Empleado> empleados, ArrayList<Departamento> departamentos ) {
		
		this.departamentos = departamentos;
		this.empleados = empleados;
		
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
