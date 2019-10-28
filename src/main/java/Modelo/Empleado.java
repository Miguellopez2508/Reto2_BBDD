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
	
	public Empleado() {
		
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		builder.append("Salario :");
		builder.append(salario);
		builder.append("\n");
		builder.append("Nombre :");
		builder.append(nombre);
		builder.append("\n");
		builder.append("Apellido :");
		builder.append(apellido);
		builder.append("\n");
		builder.append("Responsabilidad :");
		builder.append(responsabilidad);
		builder.append("\n");
		builder.append("Gerente :");
		builder.append(gerente);
		builder.append("\n");
		builder.append("Deptco :");
		builder.append(deptco);
		builder.append("\n");
		builder.append("Esjefe :");
		builder.append(esjefe);
		builder.append("\n");

		return builder.toString();
	}
	
	
	
}
