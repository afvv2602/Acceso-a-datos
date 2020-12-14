package Al;

/**
 * Clase Excepciones
 *
 * Contiene las excepciones personalizadas para el proyecto
 *
 * @author Adrian Fernandez-Vaillo
 * @version 1.0
 */
public class Excepciones extends Exception {

	/**
	 * mensaje mensaje del error
	 */
	private String mensaje;

	/**
	 * Constructor de excepciones
	 * */
	public Excepciones(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	/**
	 * Metodo getMensaje
	 * 
	 * Recoge el mensaje del error
	 * 
	 * @return mensaje mensaje del error
	 * */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * Metodo setMensaje
	 * 
	 * Establece el mensaje de la excepcion
	 * 
	 * @param mensaje mensaje del error
	 * */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
