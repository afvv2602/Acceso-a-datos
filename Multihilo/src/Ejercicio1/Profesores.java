package Ejercicio1;

public class Profesores  {

	
	String nombre;
	String dia;
	String hora;
	
	public Profesores(String nombre, String dia, String hora) {
		this.nombre = nombre;
		this.dia = dia;
		this.hora = hora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
}
