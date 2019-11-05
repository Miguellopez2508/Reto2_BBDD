package Modelo;

public class Departamento {

	private String nombre;
	private String ubicacion;
	
	
	public Departamento(String nombre, String ubicacion) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}
	
	public Departamento() {
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("\n");
		builder.append("Nombre: ");
		builder.append(nombre);
		builder.append("\n");
		builder.append("Ubicacion: ");
		builder.append(ubicacion);
		builder.append("\n");
		
		return builder.toString();
	
	}
}
