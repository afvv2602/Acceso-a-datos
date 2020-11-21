
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;

class Fichero {
	/**
	 * Ruta que tendra el fichero donde guardaremos los datos de los alumnos
	 **/
	private String ruta;
	/**
	 * HashMap de los alumno que se encuentran en el fichero
	 */
	HashMap<String, Alumno> HMAlumnos = new HashMap<String, Alumno>();
	/**
	 * ArrayList de alumnos usando el metodo toString() de la clase Alumno()
	 */
	ArrayList<String> Alumnos = new ArrayList<String>();

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
	public void insertaLinea(Alumno alumno) {
		File fichero = new File(this.ruta);
		String linea = alumno.toString();
		BufferedWriter buffWriter = null;
		try {
			buffWriter = new BufferedWriter(new FileWriter(fichero, true)); // true para que no machaque el fichero
			buffWriter.write(linea); // insertamos la linea
			buffWriter.newLine(); // creamos una linea debajo para que haga el salto de linea
			buffWriter.close(); // cerramos el fichero
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (buffWriter != null)
					buffWriter.close(); // cerramos el fichero
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	/**
	 * 
	 * Metodo actualizarRegistro
	 * 
	 * Se encarga de actualizar un unico parametro del alumno, depende de la
	 * posicion que se le pase
	 * 
	 * @param separador caracter que uso para cada parametro dentro de la cadena
	 * @param posicion  posicion en la cual se encuentra el parametro a cambiar
	 * @param cambio    cadena la cual va a sustituir la que se encuentra en el
	 *                  fichero
	 * @param pDNI      el DNI del alumno es la variable para identificar al alumno
	 * 
	 * @return Alumno retorna el objeto alumno actualizado
	 *
	 */

	public Alumno actualizarRegistro(String separador, int posicion, String cambio, String pDNI) {
		String Nombre, Apellidos, edad, Modulo;
		Alumno Alumno = null;
		int Edad;
		Alumnos = dameContenido(); // Actualizo el arrayList de alumnos
		for (String cadenaAlumnos : Alumnos) {
			String[] datosAlumnos = cadenaAlumnos.split(separador);
			String DNI = datosAlumnos[0];
			if (pDNI.equals(DNI)) {
				switch (posicion) {
				case 1:
					// Actualiza Nombre
					Apellidos = datosAlumnos[2];
					edad = datosAlumnos[3];
					Modulo = datosAlumnos[4];
					Edad = Integer.parseInt(edad);
					Alumno = new Alumno(cambio, Edad, DNI, Apellidos, Modulo);
					break;
				case 2:
					// Actualiza Apellidos
					Nombre = datosAlumnos[1];
					edad = datosAlumnos[3];
					Modulo = datosAlumnos[4];
					Edad = Integer.parseInt(edad);
					Alumno = new Alumno(Nombre, Edad, DNI, cambio, Modulo);
					break;
				case 3:
					// Actualiza Edad
					Nombre = datosAlumnos[1];
					Apellidos = datosAlumnos[2];
					edad = datosAlumnos[3];
					Modulo = datosAlumnos[4];
					Edad = Integer.parseInt(cambio);
					Alumno = new Alumno(Nombre, Edad, DNI, Apellidos, Modulo);
					break;
				case 4:
					// Actualiza Modulo
					Nombre = datosAlumnos[1];
					Apellidos = datosAlumnos[2];
					edad = datosAlumnos[3];
					Edad = Integer.parseInt(edad);
					Alumno = new Alumno(Nombre, Edad, DNI, Apellidos, cambio);
					break;
				default:
					break;
				}
			}
		}
		return Alumno;

	}

	/**
	 * Metodo BorrarLinea
	 * 
	 * Se encarga de borrar una linea dentro del fichero y eliminarla
	 * 
	 * @param busqueda  Esta es la linea a buscar dentro del fichero la cual va a
	 *                  ser eliminada
	 * @param posicion  Posicion en la cual se encuentra dentro de la cadena
	 *                  busqueda el parametro identificador del objeto
	 * @param separador Caracter mediante el cual separamos la cadena busqueda
	 *
	 */
	public void BorrarLinea(String busqueda, int posicion, String separador) {
		File outputFile = null; // Generamos un fichero de salida
		File inputFile = null; // Generamos el fichero de entrada
		try {
			inputFile = new File(this.ruta); // Le decimos que el fichero donde estan los datos es el fichero que
												// estamos manejando
			outputFile = new File("./BDAlumnos_Temporal"); // Creamos un fichero de salida el cual sera temporal
			outputFile.createNewFile(); // Nos aseguramos de crear el fichero de salida
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
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
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (reader != null && writer != null) {
					reader.close(); // Cerramos el reader creado arriba
					writer.close(); // Cerramos el writer creado arriba
					moveFile(outputFile.getAbsolutePath(), inputFile.getAbsolutePath());
				}

			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}

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
	 * 
	 */
	public void moveFile(String fromFile, String toFile) {

		File origin = new File(fromFile); // Fichero temporal
		File destination = new File(toFile); // Fichero final
		if (origin.exists()) {
			BufferedReader reader = null;
			BufferedWriter writer = null;
			try {
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
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	}

	/**
	 * 
	 * Metodo dameContenido
	 * 
	 * Este metodo consiste en guardar el fichero en un arraylist de strings
	 * 
	 * @return ArrayList<String> devuelve el ArrayList del contenido del fichero
	 * 
	 */
	public ArrayList<String> dameContenido() {
		File fichero = new File(this.ruta);
		BufferedReader buffReader = null;
		try {
			buffReader = new BufferedReader(new FileReader(fichero)); // creamos fichero de lectura
			String linea;
			while ((linea = buffReader.readLine()) != null) {
				Alumnos.add(linea); // Añadimos el alumno al fichero
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (buffReader != null)
					buffReader.close();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}

		}
		return Alumnos; // devolvemos el arraylist
	}

	/**
	 * 
	 * Metodo crearHM
	 * 
	 * Crea un hashMap de alumnos con la clave DNI, el cual se actualiza dependiendo
	 * de lo que haya en el fichero
	 * 
	 * @return HashMap<String, Alumno> devuelve el HashMap creado.
	 * 
	 */
	public HashMap<String, Alumno> crearHM() {

		ArrayList<String> alumnos = dameContenido();
		for (String cadenaAlumnos : alumnos) {
			String[] datosAlumnos = cadenaAlumnos.split("#");
			String DNI = datosAlumnos[0];
			String Nombre = datosAlumnos[1];
			String Apellidos = datosAlumnos[2];
			String edad = datosAlumnos[3];
			String Modulo = datosAlumnos[4];
			int Edad = Integer.parseInt(edad);
			Alumno Alumno = new Alumno(Nombre, Edad, DNI, Apellidos, Modulo);
			HMAlumnos.put(DNI, Alumno);

		}

		return HMAlumnos;
	}

	/**
	 * Metodo volcarMap
	 * 
	 * Con este metodo actualizamos todo el fichero dependiendo de lo que se
	 * encuentre dentro del HashMap.
	 * 
	 * @param HashMap<String,Alumno> alumnos
	 * 
	 */
	public void volcarMap(HashMap<String, Alumno> alumnos) {

		File origin = new File(this.ruta);
		if (origin.exists()) {
			BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter(origin));
				for (HashMap.Entry<String, Alumno> lista : alumnos.entrySet()) {
					writer.write(lista.getValue().toString()); // insertamos la linea
					writer.newLine(); // creamos una linea debajo para que haga el salto de linea
				}
				writer.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();

			}
		}

	}

}