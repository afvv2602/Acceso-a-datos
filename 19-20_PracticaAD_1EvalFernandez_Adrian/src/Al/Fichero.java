package Al;

/**
 * Clase Fichero
 *
 * Contiene todas las utilidades para poder utilizar ficheros
 *
 * @author Adrian Fernandez-Vaillo
 * @version 1.0
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

class Fichero {

	/**
	 * Ruta que tendra el fichero donde guardaremos los datos de los alumnos
	 **/
	private String ruta;

	/**
	 * ArrayList Strings
	 */
	ArrayList<String> objecto = new ArrayList<String>();

	/**
	 * Constructor de fichero
	 */
	public Fichero(String ruta) {
		this.ruta = ruta;
	}

	/**
	 * Metodo insertaLinea
	 * 
	 * Se encarga de insertar una linea en el fichero
	 * 
	 * @param Alumno objeto alumno creado previamente
	 * 
	 */
	public void insertaLinea(String pCadena) throws IOException {
		File fichero = new File(this.ruta);
		BufferedWriter buffWriter = null;
		buffWriter = new BufferedWriter(new FileWriter(fichero, true)); // true para que no machaque el fichero
		buffWriter.write(pCadena); // insertamos la linea
		buffWriter.newLine(); // creamos una linea debajo para que haga el salto de linea
		buffWriter.close(); // cerramos el fichero
		if (buffWriter != null)
			buffWriter.close(); // cerramos el fichero
	}

	/**
	 * Metodo BorrarLinea
	 * 
	 * Se encarga de borrar una linea dentro del fichero y eliminarla
	 * 
	 * @param busqueda Esta es la linea a buscar dentro del fichero la cual va a ser
	 *                 eliminada @param posicion Posicion en la cual se encuentra
	 *                 dentro de la cadena busqueda el parametro identificador del
	 *                 objeto @param separador Caracter mediante el cual separamos
	 *                 la cadena busqueda @throws
	 *
	 */
	public void BorrarLinea(String busqueda, int posicion, String separador) throws IOException {
		File outputFile = null; // Generamos un fichero de salida
		File inputFile = null; // Generamos el fichero de entrada
		inputFile = new File(this.ruta); // Le decimos que el fichero donde estan los datos es el fichero que
											// estamos manejando
		outputFile = new File(
				"C:\\Users\\afvv2\\Desktop\\Workspaces\\Acceso a datos\\WorkSpace AD\\19-20_PracticaAD_1EvalFernandez_Adrian\\assets\\BDAlumnos_Temporal"); // Creamos
																																							// un
																																							// fichero
																																							// de
																																							// salida
																																							// el
																																							// cual
																																							// sera
																																							// temporal
		outputFile.createNewFile(); // Nos aseguramos de crear el fichero de salida
		BufferedReader reader = null;
		BufferedWriter writer = null;
		reader = new BufferedReader(new FileReader(inputFile));
		writer = new BufferedWriter(new FileWriter(outputFile));
		String linea = null;
		while ((linea = reader.readLine()) != null) {
			String[] datosAlumnos = linea.split(separador);
			String DNIactual = datosAlumnos[posicion];
			if (DNIactual.trim().equals(busqueda)) {
				// Si el DNI que esta en ese momento siendo comparada se salta la ejecucion de
				// la siguiente linea
				// Entonces no la escribe en el fichero de salida, sino la ejecucion es normal y
				// se escriben todas la lineas en el fichero de salida
				continue;
			}
			writer.write(linea + System.getProperty("line.separator"));
		}
		if (reader != null && writer != null) {
			reader.close(); // Cerramos el reader creado arriba
			writer.close(); // Cerramos el writer creado arriba
			moveFile(outputFile.getAbsolutePath(), inputFile.getAbsolutePath());
		}

	}

	/**
	 * Metodo moveFile
	 * 
	 * El metodo consiste en pasar el contenido del fichero temporal creado en
	 * borrarLinea y al final del metodo borramos el fichero temporal creado
	 * 
	 * @param fromFile cogemos la ruta del fichero temporal
	 * @param toFile   cogemos la ruta del fichero final
	 * @throws Excepciones
	 * 
	 */
	public void moveFile(String fromFile, String toFile) throws IOException {

		File origin = new File(fromFile); // Fichero temporal
		File destination = new File(toFile); // Fichero final
		if (origin.exists()) {
			BufferedReader reader = null;
			BufferedWriter writer = null;
			reader = new BufferedReader(new FileReader(origin));// Lee BDAlumnos_Temporal
			writer = new BufferedWriter(new FileWriter(destination)); // Escribe en BDAlumnos
			String linea = null;
			while ((linea = reader.readLine()) != null) {
				writer.write(linea); // insertamos la linea
				writer.newLine(); // creamos una linea debajo para que haga el salto de linea
			}
			reader.close();
			writer.close();
			origin.delete(); // Borramos el fichero temporal

		}

	}

	/**
	 * 
	 * Metodo dameContenido
	 * 
	 * Este metodo consiste en guardar el fichero en un arraylist de strings
	 * 
	 * @return ArrayList<String> devuelve el ArrayList del contenido del fichero
	 * @throws Excepciones
	 * 
	 */
	public ArrayList<String> dameContenido() throws IOException {
		File fichero = new File(this.ruta);
		BufferedReader buffReader = null;

		buffReader = new BufferedReader(new FileReader(fichero)); // creamos fichero de lectura
		String linea;
		while ((linea = buffReader.readLine()) != null) {
			objecto.add(linea); // Añadimos el alumno al fichero
		}
		if (buffReader != null)
			buffReader.close();
		return objecto; // devolvemos el arraylist
	}
}
