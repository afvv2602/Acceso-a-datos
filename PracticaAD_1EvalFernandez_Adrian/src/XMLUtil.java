
/**
 * Clase XMLUtil
 *
 * Esta clase se encarga de trabajar con el fichero XML
 *
 * @author Adrian Fernandez-Vaillo
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

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
	 * @param objeto objeto el cual se va a introducir en el archivo XML
	 */
	public void toXMLFile(Object objeto) {
		XStream xstream = new XStream(new DomDriver());
		String xml = xstream.toXML(objeto); // transformas el objeto a un formato XML
		try {
			File fichero = new File(rutaFichero); // Creas un fichero
			fichero.createNewFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(fichero, true));
			writer.write(xml); // Escribimos el XML
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
