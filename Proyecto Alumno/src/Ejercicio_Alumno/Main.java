package Ejercicio_Alumno;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

import Ejercicio_Alumno.Alumno;
import Ejercicio_Alumno.BDAlumno;
import Ejercicio_Alumno.BDAlumnoXML;
import Ejercicio_Alumno.Fichero;

public class Main {

	public static void main(String[] args) {

		Fichero fichero = new Fichero("./test.txt");
		Alumno pepe = new Alumno("Pepe", 23, "345678F", "Garcia", "Informatica");
		Alumno a = new Alumno("Andres", 28, "976774J", "Fernandez", "Musica");
		Alumno b = new Alumno("Ana", 29, "678452N", "Rodriguez", "Produccion");
		Alumno c = new Alumno("Pedro", 32, "098764L", "Nuñez", "Animacion");
		Alumno d = new Alumno("Andrea", 19, "155675Y", "Doral", "Robotica");
		BDAlumno bdalumno = new BDAlumno();
		bdalumno.inserta(pepe);
		bdalumno.inserta(a);
		bdalumno.inserta(b);
		bdalumno.inserta(c);
		bdalumno.inserta(d);
		Alumno pep = new Alumno("Jose Mari", 26, "345678F", "Fernandez", "Subnormal");
		bdalumno.actualiza(pep.getDNI(), pep);
		BDAlumnoXML bdalumnoXML = new BDAlumnoXML();
		bdalumnoXML.inserta(pepe);
		bdalumnoXML.inserta(a);
		bdalumnoXML.inserta(b);
		bdalumnoXML.inserta(c);
		bdalumnoXML.inserta(d);
		// Posicion 1 Nombre , Posicion 2 Apellidos, Posicion 3 Edad , Posicion 4 Modulo
		bdalumno.actualizaPorPosicion(a.getDNI(), "#", 2, "Garza");
		
//		BDAlumnoXML BDAlumnoXML = new BDAlumnoXML("./BDAlumnos.xml");
//		BDAlumnoXML.inserta(pepe);

	}
}
