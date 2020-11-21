package Ejercicio_Alumno;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class XMLUtil {
	
	String rutaFichero;
	
	public XMLUtil(String rutaFichero) {
		this.rutaFichero = rutaFichero;
	}

	public void toXMLFile (Object objeto) {
		XStream xstream = new XStream(new DomDriver());
		String xml = xstream.toXML(objeto); // transformas el objeto a un formato XML
		try {
			File fichero = new File(rutaFichero); // Creas un fichero
			fichero.createNewFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(fichero,true)); 
			writer.write(xml); // Escribimos el XML
			writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
