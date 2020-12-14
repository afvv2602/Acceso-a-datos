package Al;

/**
 * Clase BDAlumnoXML
 *
 * Contiene todas las utilidades para poder utilizar el fichero XML
 *
 * @author Adrian Fernandez-Vaillo
 * @version 1.0
 */
import java.util.ArrayList;

public class BDAlumnoXML {
	
	/**
	 * rutaFichero ruta en la cual se creara el fichero xml
	 */
	String rutaFichero;

	/**
	 * xmlUtil para poder usar las herramientas xml
	 */
	XMLUtil xmlUtil;

	/**
	 * fichero para poder usar metodos de la clase fichero
	 */
	BDAlumno bdaAlumno;

	/**
	 * contenidoNuevo arrayList para guardar alumnos
	 */
	ArrayList<Alumno> contenidoNuevo = new ArrayList<Alumno>();

	/**
	 * contenidoXML arraylist del contenido dentro del xml
	 */
	ArrayList<Alumno> contenidoXML = new ArrayList<Alumno>();

	/**
	 * sw boolean para tratar algunas operaciones
	 */
	boolean sw;

	/**
	 * Constructor de BDAlumnoXML
	 */
	public BDAlumnoXML() {
		this.rutaFichero = "C:\\Users\\afvv2\\Desktop\\Workspaces\\Acceso a datos\\WorkSpace AD\\19-20_PracticaAD_1EvalFernandez_Adrian\\assets\\BDAlumnos.xml";
		this.xmlUtil = new XMLUtil(rutaFichero);
		this.bdaAlumno = new BDAlumno();
		this.sw = true;
	}

	/**
	 * Metodo inserta
	 * 
	 * inserta un ArrayList dentro del fichero xml
	 * 
	 * @return
	 *         <ul>
	 *         <li>true: El arraylist se inserto correctamente</li>
	 *         <li>false: contenidoNuevo y contenidoXML eran iguales</li>
	 *         </ul>
	 * 
	 * @throws Excepciones
	 */
	public boolean inserta() throws Excepciones {
		int contador = 0;
		contenidoNuevo = bdaAlumno.crearAL();
		if (sw) {
			contenidoXML = contenidoNuevo;
			try {
				xmlUtil.toXMLFile(contenidoNuevo);
			} catch (Excepciones e) {
				e.getMensaje();
			}
			leer();
			contenidoNuevo.clear();
			sw = false;
			return true;
		} else {
			for (Alumno a : contenidoNuevo) {
				for (Alumno b : contenidoXML) {
					if (a.getDNI().equals(b.getDNI())) {
						contador++;
					}
				}
			}
			if (contador == contenidoNuevo.size()) {
				return false;
			} else {
				contenidoXML = contenidoNuevo;
				try {
					xmlUtil.toXMLFile(contenidoNuevo);
				} catch (Excepciones e) {
					e.getMensaje();
				}
				leer();
				contenidoNuevo.clear();
				return true;
			}

		}
	}

	/**
	 * Metodo leer
	 * 
	 * leer el fichero xml y carga el valor en contenidoXML
	 * 
	 * @throws Excepciones
	 * 
	 * */
	public void leer() throws Excepciones{
		try {
			contenidoXML = xmlUtil.fromXMLFile();
		} catch (Excepciones e) {
			e.getMensaje();
		}
	}

}
