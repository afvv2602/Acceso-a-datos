package Ejercicio_Alumno;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class BDAlumnoXML {
	String rutaFichero;
	XMLUtil xmlUtil;
	Fichero fichero;
	BDAlumno bdAlumno = new BDAlumno();
	ArrayList<Alumno> contenido = new ArrayList<Alumno>();
	HashMap<String, Alumno> listaAlumnos = new HashMap<String, Alumno>();;
	
	
	public BDAlumnoXML() {
		this.rutaFichero = "./BDAlumnos.xml";
		this.xmlUtil = new XMLUtil(this.rutaFichero);
		fichero = new Fichero(rutaFichero);
		
	}
	
	public boolean inserta(Alumno pAlumno) {
		if (!listaAlumnos.containsKey(pAlumno.getDNI())) {
			// Si no está, lo guardo a través de XMLUtil
			xmlUtil.toXMLFile(pAlumno);
			return true;
		}
		
		return false;
	}
}
