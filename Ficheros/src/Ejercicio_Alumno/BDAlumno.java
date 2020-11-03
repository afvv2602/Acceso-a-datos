package Ejercicio_Alumno;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class BDAlumno {

	Fichero fichero = new Fichero("./BDAlumnos");
	HashMap<String, Alumno> Alumnos = new HashMap<String, Alumno>();
	boolean sw = false;

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

	public boolean buscaPorDNI(String pDNI) {
		Alumnos = fichero.crearHM();
		for (String DNI : Alumnos.keySet()) { // del for sacamos todos los ID del hashmap y los coge en un String DNI
			if (DNI.equals(pDNI)) { // Se comparan los DNI
				return true;
			}
		}
		return false;
	}

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

	public void actualiza(String pDNI, Alumno actualizar) {
		sw = buscaPorDNI(pDNI);
		if (sw) {
			Alumnos = fichero.crearHM();
			Alumnos.replace(pDNI, actualizar);
			fichero.volcarMap(Alumnos);
		}
	}

	public void actualizaPorPosicion(String pDNI,String separador, int posicion,String cambio) {
		sw = buscaPorDNI(pDNI);
		if (sw) {
			Alumno Alumno = fichero.actualizarRegistro(separador, posicion, cambio, pDNI);
			actualiza(pDNI,Alumno);
		}
	}
}
