
/**
 * Clase BDAlumno
 *
 * Se encarga de hacer puente entre la clase Fichero la cual le brinda la utilidad para poder
 * Usar los ficheros y la clase main
 *
 * @author Adrian Fernandez-Vaillo
 * @version 1.0
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class BDAlumno {
	/*
	 * fichero donde vamos a almacenar a los alumnos
	 */
	Fichero fichero = new Fichero("./BDAlumnos");
	/**
	 * HashMap donde guardaremos todos los alumnos que se encuentran dentro del
	 * fichero
	 */
	HashMap<String, Alumno> Alumnos = new HashMap<String, Alumno>();
	/**
	 * Un boolean para controlar algunas operaciones
	 */
	boolean sw = false;

	/**
	 * Metodo inserta
	 * 
	 * Insertamos en el fichero el alumno que le pasamos como parametro,
	 * asegurandonos antes de que el alumno no se encuentre en el fichero ya sino se
	 * encuentra en el fichero llamamos al metodo insertaLinea de la clase fichero
	 * 
	 * 
	 * @param Alumno pAlumno alumno el cual vamos a inserta en el fichero
	 * 
	 */

	public void inserta(Alumno pAlumno) {
		try {
			File file = new File("./BDAlumnos");
			file.createNewFile();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		String DNI = pAlumno.getDNI();
		sw = buscaPorDNI(DNI);
		if (sw == false) {
			fichero.insertaLinea(pAlumno);
			Alumnos.put(DNI, pAlumno);
		} else
			System.out.println("El Alumno ya esta en la base de datos");

	}

	/**
	 * Metodo buscaPorDNI
	 * 
	 * Vamos a revisar si el alumno se encuentra dentro del HashMap.
	 * 
	 * @param pDNI cadena por la cual vamos a buscar si existe el alumno
	 * 
	 * @return
	 *         <ul>
	 *         <li>true: El alumno se encuentra en el hashmap / fichero</li>
	 *         <li>false: El alumno no se encuentra en el hashmap / fichero</li>
	 *         </ul>
	 */

	public boolean buscaPorDNI(String pDNI) {
		Alumnos = fichero.crearHM();
		for (String DNI : Alumnos.keySet()) { // del for sacamos todos los ID del hashmap y los coge en un String DNI
			if (DNI.equals(pDNI)) { // Se comparan los DNI
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo borrar
	 * 
	 * Buscamos al alumno por DNI dentro del hashmap si lo encuentra entonces
	 * llamamos a fichero.borrarlinea y despues borramos al alumno del hashmap
	 * 
	 * @param pDNI Identificador del alumno
	 * 
	 */

	public void borrar(String pDNI) {
		ArrayList<String> listaAlumnos = new ArrayList<>();
		sw = buscaPorDNI(pDNI);
		if (sw) {
			listaAlumnos = fichero.dameContenido();
			for (String cadenaAlumnos : listaAlumnos) {
				String[] datosAlumnos = cadenaAlumnos.split("#");
				String DNI = datosAlumnos[0];
				if (DNI.equals(pDNI)) {
					fichero.BorrarLinea(pDNI, 0, "#");
					Alumnos.remove(pDNI);
				}
			}
		}
	}

	/**
	 * Metodo actualiza
	 * 
	 * Primero buscamos si existe algun alumno con ese DNI Si existe un alumno con
	 * ese DNI entonces cambia dentro del HashMap el objeto alumno que almacena y
	 * llama al metodo volcarMap de la clase fichero.
	 * 
	 * @param pDNI       Identificador del alumno
	 * @param actualizar Objeto alumno para actulizar por el que ya estaba
	 */

	public void actualiza(String pDNI, Alumno actualizar) {
		sw = buscaPorDNI(pDNI);
		if (sw) {
			Alumnos.replace(pDNI, actualizar);
			fichero.volcarMap(Alumnos);
		}
	}

	/**
	 * Metodo actualizarPorPosicion
	 * 
	 * Primero busca si el alumno se encuentra en el fichero si es asi crea un
	 * objeto alumno que recoge los valores que le devuelve el metodo
	 * actualizarRegistro Despues llama al metodo actualiza para introducir los
	 * cambios en el fichero y en el hashmap
	 * 
	 * @param pDNI      Identificador del alumno
	 * @param separador caracter para separar las cadenas
	 * @param posicion  posicion en la cual se encuentra el parametro a actualizar
	 * @param cambio    la cadena que sustituira el valor anterior del parametro
	 */

	public void actualizaPorPosicion(String pDNI, String separador, int posicion, String cambio) {
		sw = buscaPorDNI(pDNI);
		if (sw) {
			Alumno Alumno = fichero.actualizarRegistro(separador, posicion, cambio, pDNI);
			actualiza(pDNI, Alumno);
		}
	}
}
