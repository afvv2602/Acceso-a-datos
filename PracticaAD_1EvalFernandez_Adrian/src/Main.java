

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;


public class Main {

	public static void main(String[] args) {

		Fichero fichero = new Fichero("./test.txt");
		Alumno pepe = new Alumno("Pepe", 23, "345678F", "Garcia", "Informatica");
		Alumno a = new Alumno("Andres", 28, "976774J", "Fernandez", "Musica");
//		Alumno b = new Alumno("Ana", 29, "678452N", "Rodriguez", "Produccion");
//		Alumno c = new Alumno("Pedro", 32, "098764L", "Nu�ez", "Animacion");
//		Alumno d = new Alumno("Andrea", 19, "155675Y", "Doral", "Robotica");
		BDAlumno bdalumno = new BDAlumno();
		BDAlumnoXML bdalumnoXML = new BDAlumnoXML();
		bdalumno.inserta(pepe);
		//bdalumnoXML.inserta(pepe);
		bdalumno.inserta(a);
		bdalumnoXML.inserta(a);
		Alumno pep = new Alumno("Jose Mari", 26, "345678F", "Fernandez", "Subnormal");
		bdalumno.actualiza(pep.getDNI(), pep);
		// Posicion 1 Nombre , Posicion 2 Apellidos, Posicion 3 Edad , Posicion 4 Modulo
		bdalumno.actualizaPorPosicion(a.getDNI(), "#", 2, "Garza");

	}
}