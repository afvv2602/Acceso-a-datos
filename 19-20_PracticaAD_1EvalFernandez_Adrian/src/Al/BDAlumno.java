package Al;

import java.io.BufferedWriter;

/**
 * Clase BDAlumno
 *
 * Se encarga de hacer puente entre la clase Fichero la cual le brinda la utilidad para poder
 * Usar los ficheros y la clase main
 *
 * @author Adrian Fernandez-Vaillo
 * @version 1.0
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BDAlumno {
	/*
	 * fichero donde vamos a almacenar a los alumnos
	 */
	Fichero fichero;

	/**
	 * XMLUtil y JSONUtil para cada vez que haga una operacion actualicen los
	 * ficheros
	 */
	XMLUtil xml;
	JSONUtil json;

	/**
	 * HashMap de los alumno que se encuentran en el fichero
	 */
	HashMap<String, Alumno> HMAlumnos = new HashMap<String, Alumno>();

	/**
	 * HashMap donde guardaremos todos los alumnos que se encuentran dentro del
	 * fichero
	 */
	HashMap<String, Alumno> Alumnos = new HashMap<String, Alumno>();

	/**
	 * ArrayList de alumnos que se encuentran dentro del fichero
	 */
	ArrayList<String> ListaAlumnos = new ArrayList<String>();

	/**
	 * Un boolean para controlar algunas operaciones
	 */
	boolean sw = false;

	/**
	 * ArrayList de alumnos para poder enviar los datos al xml
	 */
	ArrayList<Alumno> AlumnosAL = new ArrayList<Alumno>();

	/*
	 * AlumnosInsertados numero de alumnos que se encuentra en el fichero
	 */
	long AlumnosInsertados;

	/**
	 * Constructor de BDAlumno
	 * 
	 * Le pasamos la clase fichero para que sea comun a todos los ficheros
	 */
	public BDAlumno() {
		this.xml = new XMLUtil(
				"C:\\Users\\afvv2\\Desktop\\Workspaces\\Acceso a datos\\WorkSpace AD\\19-20_PracticaAD_1EvalFernandez_Adrian\\assets\\BDAlumnos.xml");
		this.json = new JSONUtil(
				"C:\\Users\\afvv2\\Desktop\\Workspaces\\Acceso a datos\\WorkSpace AD\\19-20_PracticaAD_1EvalFernandez_Adrian\\assets\\BDAlumnos.json");
		this.fichero = new Fichero(
				"C:\\Users\\afvv2\\Desktop\\Workspaces\\Acceso a datos\\WorkSpace AD\\19-20_PracticaAD_1EvalFernandez_Adrian\\assets\\BDAlumnos");
	}

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
	 * @return
	 *         <ul>
	 *         <li>true: El alumno se inserto correctamente</li>
	 *         <li>false: El alumno ya se encontraba en el fichero</li>
	 *         </ul>
	 * @throws Excepciones
	 */
	public boolean inserta(Alumno pAlumno) throws Excepciones {
		try {
			File file = new File(
					"C:\\Users\\afvv2\\Desktop\\Workspaces\\Acceso a datos\\WorkSpace AD\\19-20_PracticaAD_1EvalFernandez_Adrian\\assets\\BDAlumnos");
			file.createNewFile();
		} catch (IOException ioe) {
			throw new Excepciones("Error de creacion base de datos");
		}
		String DNI = pAlumno.getDNI();
		sw = buscaPorDNI(DNI);
		if (sw == false) {
			try {
				fichero.insertaLinea(pAlumno.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new Excepciones("Fallo de acceso a base de datos");
			}
			Alumnos.put(DNI, pAlumno);
			count();
			actualizarFicheros();
			return true;
		} else
			try {
			} catch (Exception e) {
				throw new Excepciones("Error alumno duplicado");
			}
		return false;

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
	 * @throws Excepciones
	 */
	public boolean buscaPorDNI(String pDNI) throws Excepciones {
		Alumnos = crearHM();
		for (String DNI : Alumnos.keySet()) { // del for sacamos todos los ID del hashmap y los coge en un String DNI
			if (DNI.equals(pDNI)) { // Se comparan los DNI
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo findByDNI
	 * 
	 * Vamos a revisar si el alumno se encuentra dentro del HashMap.
	 * 
	 * @param pDNI cadena por la cual vamos a buscar si existe el alumno
	 * 
	 * @return
	 *         <ul>
	 *         <li>Alumnos.get(DNI): Si se encuentra el alumno lo devuelve</li>
	 *         <li>null: No se ha encontrado al alumno</li>
	 *         </ul>
	 * 
	 * @throws Excepciones
	 */
	public Alumno findByDNI(String pDNI) throws Excepciones {
		Alumnos = crearHM();
		for (String DNI : Alumnos.keySet()) { // del for sacamos todos los ID del hashmap y los coge en un String DNI
			if (DNI.equals(pDNI)) { // Se comparan los DNI
				return Alumnos.get(DNI);
			}
		}
		return null;
	}

	/**
	 * Metodo borrar
	 * 
	 * Buscamos al alumno por DNI dentro del hashmap si lo encuentra entonces
	 * llamamos a fichero.borrarlinea y despues borramos al alumno del hashmap
	 * 
	 * @param pDNI Identificador del alumno
	 * @throws Excepciones
	 * 
	 */
	public void borrar(String pDNI) throws Excepciones {
		ListaAlumnos.clear();
		sw = buscaPorDNI(pDNI);
		if (sw) {
			try {
				ListaAlumnos = fichero.dameContenido();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new Excepciones("Error en lectura del fichero");
			}
			Iterator<String> IT = ListaAlumnos.iterator();
			while (IT.hasNext()) {
				String tmp = IT.next();
				String[] datosAlumnos = tmp.split("#");
				String DNI = datosAlumnos[0];
				if (DNI.equals(pDNI)) {
					try {
						fichero.BorrarLinea(pDNI, 0, "#");
					} catch (IOException e) {
						throw new Excepciones("Error acceso a la base de datos");
					}
					Alumnos.remove(pDNI);
					actualizarFicheros();
					break;
				}
			}
		}
		count();
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
	 * @throws Excepciones
	 */
	public void actualiza(Alumno actualizar) throws Excepciones {
		sw = buscaPorDNI(actualizar.getDNI());
		if (sw) {
			try {
				Alumnos.replace(actualizar.getDNI(), actualizar);
				volcarMap(Alumnos);
				actualizarFicheros();
			} catch (Excepciones e) {
				e.getMensaje();
			}
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
	 * @throws Excepciones
	 */
	public void actualizaPorPosicion(String pDNI, String separador, int posicion, String cambio) throws Excepciones {
		sw = buscaPorDNI(pDNI);
		if (sw) {
			try {
				Alumno Alumno = actualizarRegistro(separador, posicion, cambio, pDNI);
				actualiza(Alumno);
				actualizarFicheros();
				count();
			} catch (Excepciones e) {
				e.getMensaje();
			}

		}
	}

	/**
	 * Metodo getAll
	 * 
	 * Nada mas entrar al metodo se actualiza el HashMap para que tenga todos los
	 * valores que se encuentran en el fichero despues introducimos en la lista los
	 * valores que se encuentran en el hashmap
	 * 
	 * @return List<Alumno> devuelve una lista de objetos tipo alumno
	 * @throws Excepciones
	 */
	public List<Alumno> getAll() throws Excepciones {
		Alumnos = crearHM();
		List<Alumno> listadoAlumnos = new ArrayList<Alumno>();
		for (HashMap.Entry<String, Alumno> lista : Alumnos.entrySet()) {
			listadoAlumnos.add(lista.getValue());
		}

		return listadoAlumnos;
	}

	/**
	 * Metodo getMapByNombreIgnoreCase
	 * 
	 * Busca dentro del HashMap si hay algun alumno con el nombre que le pasamos y
	 * hacemos un hashmap paralelo donde guardamos los alumnos que se llaman igual
	 * que el nombre que le hemos pasado por parametro
	 * 
	 * @param pCadena nombre que queremos buscar en el hashmap
	 * 
	 * @return listadoAlumnos hashmap con los nombres encontrados
	 * 
	 * @throws Excepciones
	 */
	public Map<String, Alumno> getMapByIgnoreCase(String pCadena) throws Excepciones {
		String cadena = pCadena.toLowerCase();
		Alumnos = crearHM();
		Map<String, Alumno> listadoAlumnos = new HashMap<String, Alumno>();
		for (HashMap.Entry<String, Alumno> lista : Alumnos.entrySet()) {
			Alumno evaluado = lista.getValue();
			if (evaluado.getNombre().toLowerCase().contains(cadena)) {
				listadoAlumnos.put(evaluado.getDNI(), evaluado);
			}
		}
		return listadoAlumnos;

	}

	/**
	 * Metodo count
	 * 
	 * Devuelve el numero de alumnos que estan insertados en el fichero
	 * 
	 * @return AlumnosInsertados el numero de alumnos que se encuentran en el
	 *         fichero
	 */
	public long count() throws Excepciones {
		Alumnos = crearHM();
		AlumnosInsertados = Alumnos.size();
		return AlumnosInsertados;

	}

	/**
	 * 
	 * Metodo crearAL
	 * 
	 * Crea un hashMap de alumnos con la clave DNI, el cual se actualiza dependiendo
	 * de lo que haya en el fichero
	 * 
	 * @return ArrayList<Alumno> devuelve el HashMap creado.
	 * @throws Excepciones
	 * 
	 */
	public ArrayList<Alumno> crearAL() throws Excepciones {
		AlumnosAL.clear();
		ArrayList<String> alumnos;
		try {
			alumnos = fichero.dameContenido();
		} catch (IOException e) {
			throw new Excepciones("Error acceso a la base de datos");
		}
		for (String cadenaAlumnos : alumnos) {
			String[] datosAlumnos = cadenaAlumnos.split("#");
			String DNI = datosAlumnos[0];
			String Nombre = datosAlumnos[1];
			String Apellidos = datosAlumnos[2];
			String edad = datosAlumnos[3];
			String Modulo = datosAlumnos[4];
			int Edad = Integer.parseInt(edad);
			Alumno Alumno = new Alumno(Nombre, Edad, DNI, Apellidos, Modulo);
			AlumnosAL.add(Alumno);

		}
		alumnos.clear();
		return AlumnosAL;
	}

	/**
	 * 
	 * Metodo crearHM
	 * 
	 * Crea un hashMap de alumnos con la clave DNI, el cual se actualiza dependiendo
	 * de lo que haya en el fichero
	 * 
	 * @return HashMap<String, Alumno> devuelve el HashMap creado.
	 * @throws Excepciones
	 * 
	 */
	public HashMap<String, Alumno> crearHM() throws Excepciones {
		HMAlumnos.clear();
		ArrayList<String> alumnos;
		try {
			alumnos = fichero.dameContenido();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new Excepciones("Error acceso a la base de datos");
		}
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
		alumnos.clear();
		return HMAlumnos;
	}

	/**
	 * Metodo actualizarFicheros
	 * 
	 * Se encarga de tener en sintonia los ficheros xml y json con el fichero
	 * principal
	 * 
	 * @throws Excepciones
	 */
	public void actualizarFicheros() throws Excepciones {
		crearAL();
		crearHM();
		xml.toXMLFile(AlumnosAL);
		json.toJSONFile(HMAlumnos);
	}

	/**
	 * Metodo volcarMap
	 * 
	 * Con este metodo actualizamos todo el fichero dependiendo de lo que se
	 * encuentre dentro del HashMap.
	 * 
	 * @param HashMap<String,Alumno> alumnos
	 * @throws Excepciones
	 * 
	 */
	public void volcarMap(HashMap<String, Alumno> alumnos) throws Excepciones {
		for (HashMap.Entry<String, Alumno> lista : alumnos.entrySet()) {
			try {
				fichero.insertaLinea(lista.getValue().toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new Excepciones("Error acceso a la base de datos");
			} // insertamos la linea

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
	 * @throws Excepciones
	 *
	 */
	public Alumno actualizarRegistro(String separador, int posicion, String cambio, String pDNI) throws Excepciones {
		String Nombre, Apellidos, edad, Modulo;
		Alumno Alumno = null;
		int Edad;
		try {
			ListaAlumnos = fichero.dameContenido();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new Excepciones("Error acceso a la base de datos");
		}
		for (String cadenaAlumnos : ListaAlumnos) {
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
}
