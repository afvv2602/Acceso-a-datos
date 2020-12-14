package Al;

import java.util.HashMap;
/**
 * Clase BDAlumnoJSON
 *
 * contiene los metodos para poder controlar el fichero JSON
 *
 * @author Adrian Fernandez-Vaillo
 * @version 1.0
 */

public class BDAlumnoJSON {
	
	/**
	 * Ruta que tendra el fichero donde guardaremos los datos de los alumnos
	 **/
	String rutaFichero;
	
	/*
	 * fichero donde vamos a almacenar a los alumnos
	 */
	BDAlumno bdaAlumno;
	
	/**
	 * cotenidoJSON contenido que se encuentra dentro del JSON
	 * */
	HashMap<String, Alumno> contenidoJSON = new HashMap<String, Alumno>();
	
	/**
	 * JSONUtil para poder usar las herramientas JSON
	 */
	JSONUtil JSONUtil;

	
	/**
	 * Constructor BDAlumnoJSON
	 * */
	public BDAlumnoJSON() {
		this.bdaAlumno = new BDAlumno();
		this.rutaFichero = "C:\\Users\\afvv2\\Desktop\\Workspaces\\Acceso a datos\\WorkSpace AD\\19-20_PracticaAD_1EvalFernandez_Adrian\\assets\\BDAlumnos.json";
		this.JSONUtil = new JSONUtil(rutaFichero);
	}

	/**
	 * Metodo inserta
	 * 
	 * inserta un HashMap dentro del fichero JSON
	 * 
	 * @throws Excepciones
	 * */
	public void inserta() throws Excepciones {
		this.contenidoJSON = bdaAlumno.crearHM();
		try {
			JSONUtil.toJSONFile(contenidoJSON);
		} catch (Excepciones e) {
			e.getMensaje();
		}
	}

	
}
