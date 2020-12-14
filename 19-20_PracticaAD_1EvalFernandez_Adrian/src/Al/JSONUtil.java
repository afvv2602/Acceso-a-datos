package Al;

/**
 * Clase JSONUtil
 *
 * Contiene todas las utilidades para poder utilizar ficheros JSON
 *
 * @author Adrian Fernandez-Vaillo
 * @version 1.0
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtil {

	/**
	 * Ruta que tendra el fichero donde guardaremos los datos de los alumnos
	 **/
	String rutaFichero;

	/**
	 * Constructor JSONUtil
	 */
	public JSONUtil(String rutaFichero) {
		this.rutaFichero = rutaFichero;

	}

	/**
	 * Metodo toJSONFile
	 * 
	 * Convierte un HashMap en un objeto tipo JSON y lo introducimos en el fichero
	 * JSON
	 * 
	 * @param HashMap<String,Alumno>pListaAlumnos la lista de alumnos que se
	 *                                            encuentran en el fichero txt
	 * 
	 * @throws Excepciones
	 * 
	 */
	public void toJSONFile(HashMap<String, Alumno> pListaAlumnos) throws Excepciones {
		File fichero = new File(rutaFichero);
		JSONObject objeto = new JSONObject();
		objeto.put("listaAlumnos", pListaAlumnos);
		try (FileWriter file = new FileWriter(fichero)) {
			file.write(objeto.toString());
			file.flush();
		} catch (Exception e) {
			throw new Excepciones("Error de acceso a la base de datos");
		}

	}

}
