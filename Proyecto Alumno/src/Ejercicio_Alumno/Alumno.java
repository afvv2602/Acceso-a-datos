package Ejercicio_Alumno;

public class Alumno {

	private String nombre;
	private int edad;
	private String DNI;
	private String apellidos;
	private String modulo;
	
	
	public Alumno(String nombre, int edad, String DNI, String apellidos, String modulo) {
		this.nombre = nombre;
		this.edad = edad;
		this.DNI = DNI;
		this.apellidos = apellidos;
		this.modulo = modulo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getModulo() {
		return modulo;
	}


	public void setModulo(String modulo) {
		this.modulo = modulo;
	}


	@Override
	public String toString() {
		return this.getDNI() + "#" + this.getNombre() + "#" + this.getApellidos() + "#" + this.getEdad()
		+ "#" + this.getModulo();
	}
	
	
	
}
