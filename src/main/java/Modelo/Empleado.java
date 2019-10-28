package Modelo;

public class Empleado {

	private int salario;
	private String nombre;
	private String apellido;
	private String responsabilidad;
	private int gerente;
	private int deptco;
	private boolean esjefe;
	
	public Empleado(int salario, String nombre, String apellido, String responsabilidad, int gerente, int deptco, boolean esjefe) {
		this.salario = salario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.responsabilidad = responsabilidad;
		this.gerente = gerente;
		this.deptco = deptco;
		this.esjefe = esjefe;
	}
	
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getResponsabilidad() {
		return responsabilidad;
	}
	public void setResponsabilidad(String responsabilidad) {
		this.responsabilidad = responsabilidad;
	}
	
	public int getGerente() {
		return gerente;
	}
	public void setGerente(int gerente) {
		this.gerente = gerente;
	}
	
	public int getDeptco() {
		return deptco;
	}
	public void setDeptco(int deptco) {
		this.deptco = deptco;
	}
	
	public boolean getEsjefe() {
		return esjefe;
	}
	public void setEsjefe(boolean esjefe) {
		this.esjefe = esjefe;
	}
	
	
	
	
}
