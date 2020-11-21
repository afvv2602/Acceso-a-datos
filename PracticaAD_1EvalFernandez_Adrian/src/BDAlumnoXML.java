
/**
 * Clase BDAlumnoXML
 *
 * Se encarga de hacer puente entre la clase XMLUtil la cual le brinda la utilidad para poder
 * Usar los ficherosXML y la clase main
 *
 * @author Adrian Fernandez-Vaillo
 * @version 1.0
 */

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class BDAlumnoXML {
	/*
	 * Ruta la cual va a usar el fichero
	 */
	String rutaFichero;
	/**
	 * Objeto xmlUtil para poder usar los metodos de la clase
	 */
	XMLUtil xmlUtil;
	/**
	 * Objeto fichero para poder usar los metodos de la clase
	 */
	Fichero fichero;
	/**
	 * Objeto bdAlumno para poder usar los metodos de la clase
	 */
	BDAlumno bdAlumno = new BDAlumno();
	/**
	 * 
	 */
	ArrayList<Alumno> contenido = new ArrayList<Alumno>();
	/**
	 * 
	 */
	HashMap<String, Alumno> listaAlumnos = new HashMap<String, Alumno>();

	/**
	 * Constructor
	 */
	public BDAlumnoXML() {
		this.rutaFichero = "./BDAlumnos.xml";
		this.xmlUtil = new XMLUtil(rutaFichero);
		this.fichero = new Fichero(rutaFichero);
		this.listaAlumnos = fichero.crearHM();
	}

	public boolean inserta(Alumno pAlumno) {	
		if (!listaAlumnos.containsKey(pAlumno.getDNI())) {
			// Si no está, lo guardo a través de XMLUtil
			xmlUtil.toXMLFile(pAlumno);
			return true;
		}
		return false;
	}

}
