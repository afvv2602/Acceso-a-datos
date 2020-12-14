package Al;

/**
 * Clase XMLUtil
 *
 * Contiene los metodos para tratar el fichero XML
 *
 * @author Adrian Fernandez-Vaillo
 * @version 1.0
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class XMLUtil {
	/**
	 * Ruta la cual va a usar el fichero XML
	 */
	String rutaFichero;

	/**
	 * Constructor
	 */
	public XMLUtil(String rutaFichero) {
		this.rutaFichero = rutaFichero;

	}

	/**
	 * Metodo toXMLFile
	 * 
	 * Este metodo se encarga de transforma un objeto java en un string con formato
	 * XML para poder introducirlo en el fichero
	 * 
	 * @param ArrayList<Object> objeto arraylist del objeto que queremos introducir
	 *                          en el xml
	 * @throws Excepciones
	 */
	public void toXMLFile(ArrayList<Alumno> Alumno) throws Excepciones {
		File fichero = new File(rutaFichero);
		XStream xstream = new XStream(new StaxDriver());
		xstream.alias("ListaAlumnos", ArrayList.class);
		// xstream.alias("Alumno", Alumno.class);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, false));
			bw.write(xstream.toXML(Alumno));
			bw.close();
		} catch (IOException e) {
			throw new Excepciones("Error de acceso a la base de datos xml");
		}
	}

	/**
	 * Metodo fromXMLFile
	 * 
	 * Se encarga de coger los alumnos del xml y meterlos en un arraylist
	 * 
	 * @return listadoAlumnos arraylist de los alumnos que se encuentran en el
	 *         fichero xml
	 * @throws Expepciones
	 */
	public ArrayList<Alumno> fromXMLFile() throws Excepciones {
		ArrayList listadoAlumnos = null;
		File f = new File(rutaFichero);
		XStream xstream = new XStream(new StaxDriver());
		try {
			listadoAlumnos = (ArrayList) xstream.fromXML(f);
		} catch (Exception e) {
			throw new Excepciones("Error de acceso a la base de datos");
		}
		return listadoAlumnos;

	}

}
