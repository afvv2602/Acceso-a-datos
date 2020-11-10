package Ejercicio_Alumno;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;

public class BDAlumnoXML {

	String rutaFichero;
	XMLUtil xmlUtil;
	
	
	public BDAlumnoXML(String rutaFichero) { //XMLUtil xmlUtil) {
		this.rutaFichero = rutaFichero;
		//this.xmlUtil = new XMLUtil(this.rutaFichero);
	}
	
	public void inserta(Alumno pAlumno) {
		try {
				FileOutputStream fos = new FileOutputStream(rutaFichero);
				XMLEncoder encoder = new XMLEncoder(fos);
				encoder.writeObject(pAlumno);
				encoder.close();
				fos.close();
				
				
		}catch(IOException e) {
			e.printStackTrace();
		}
		//Compruebo que no este en el hashmap
		//Si no est� lo guardo a traves de XMLUtil:
		//xmlUtil.toXMLFile();
	}
	//Hacer los mismos metodos que en el BDAlumnos normal.
}
