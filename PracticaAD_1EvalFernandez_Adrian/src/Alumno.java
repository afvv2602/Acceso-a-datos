/**
 * Clase Alumno
 *
 * Contiene informacion de cada alumno
 *
 * @author Adrian Fernandez-Vaillo
 * @version 1.0
 */

public class Alumno {
	/**
	 *  // nombre del alumno
	 * */
	private String nombre;
	/**
	 *  // Edad del alumno
	 * */
	private int edad;
	/**
	 * // DNI del alumno
	 * */
	private String DNI; 
	/**
	 * Apellidos del alumno
	 * */
	private String apellidos; 
	/**
	 * Modulo el cual esta cursando el alumno
	 * */
	private String modulo; 

	/**
	 * Constructor del objeto alumno
	 * */ 
	public Alumno(String nombre, int edad, String DNI, String apellidos, String modulo) {
		this.nombre = null;
		this.edad = edad;
		this.DNI = DNI;
		this.apellidos = apellidos;
		this.modulo = modulo;
	}

	/**
	 * Getters & setters
	 * */ 
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

	/**
	 * El metodo toString transforma el objeto Alumno a una cadena con el conector #
	 * Para despues tratar esa cadena en la clase fichero
	 * 
	 */
	@Override
	public String toString() {
		return this.getDNI() + "#" + this.getNombre() + "#" + this.getApellidos() + "#" + this.getEdad() + "#"
				+ this.getModulo();
	}

}
