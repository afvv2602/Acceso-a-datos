import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class BDAlumnoXML {

//	"Z:\\AccesoDatos\\Proyecto Fichero\\src\\fichero1.txt"
	String rutaFichero ;
	XMLUtil xmlUtil;
	Fichero f;
	BDAlumno bdA = new BDAlumno();
	
	ArrayList<Alumno> contenido = new ArrayList<Alumno>();
	HashMap<String, Alumno> listaAlumnos = new HashMap<String, Alumno>();

	public BDAlumnoXML() {
		this.rutaFichero = "Z:\\AccesoDatos\\ProyectoFichero\\src\\ficheroXML.txt";
		this.xmlUtil = new XMLUtil(this.rutaFichero);
		f = new Fichero(rutaFichero);
		
	}


	public boolean Inserta(Alumno pAlumno) {
		if (!listaAlumnos.containsKey(pAlumno.getId())) {
			// Si no está, lo guardo a través de XMLUtil
			xmlUtil.toXMLFile(pAlumno);
			return true;
		}
		
		return false;
	}

}
