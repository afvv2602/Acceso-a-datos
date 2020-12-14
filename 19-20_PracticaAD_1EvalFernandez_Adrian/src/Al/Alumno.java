package Al;
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
	 *   nombre del alumno
	 * */
	private String nombre;
	/**
	 *   Edad del alumno
	 * */
	private int edad;
	/**
	 *  DNI del alumno
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
		this.nombre = nombre;
		this.edad = edad;
		this.DNI = DNI;
		this.apellidos = apellidos;
		this.modulo = modulo;
	}
	
	/*
	 * Constuctor Alumno
	 * 
	 * En este constructor les damos a apellidos y modulo los valores de null
	 * 
	 * */
	public Alumno(String nombre,int edad, String DNI) {
		this.nombre= nombre;
		this.edad=edad;
		this.DNI= DNI;
		this.apellidos = null;
		this.modulo = null;
	}

	/**
	 * Getters & setters
	 * */ 
	
	/**
	 * Metodo getNombre
	 * 
	 * @return nombre nombre del alumno
	 */
 	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo setNombre
	 * 
	 * @param  nombre nombre del alumno
	 * */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Metodo getEdad
	 * 
	 * @return edad edad del alumno
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Metodo setEdad
	 * 
	 * @param edad edad del alumno
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	/**
	 * Metodo getDNI
	 * 
	 * @return DNI DNI del alumno
	 */
	public String getDNI() {
		return DNI;
	}

	/**
	 * Metodo setDNI
	 * 
	 * @param dNI DNI del alumno 
	 */
	public void setDNI(String dNI) {
		DNI = dNI;
	}

	/**
	 * Metodo getApellidos
	 * 
	 * @return apellidos apellidos del alumno
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Metodo setApellidos
	 * 
	 * @param apellidos apellidos del alumno
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	/**
	 * Metodo getModulo
	 * 
	 * @return modulo modulo del alumno
	 */
	public String getModulo() {
		return modulo;
	}

	/**
	 * Metodo setModulo
	 * 
	 * @param modulo modulo del alumno
	 */
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
