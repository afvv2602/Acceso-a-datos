import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class XMLUtil {

	String rutaFichero;
	
	public  XMLUtil(String rutaFichero) {
		this.rutaFichero = rutaFichero;
	}
	
	public void toXMLFile (Object objeto) {	
		
		XStream xstream = new XStream(new DomDriver());
		
		String xml = xstream.toXML(objeto);
		System.out.println(xml);
		
		try {
			File f = new File(rutaFichero);
			f.createNewFile();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
			bw.write(xml);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}
}
