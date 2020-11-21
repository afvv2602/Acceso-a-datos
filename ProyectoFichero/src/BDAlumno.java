import java.util.ArrayList;
import java.util.HashMap;

class BDAlumno {
	Fichero f = new Fichero("Z:\\AccesoDatos\\ProyectoFichero\\src\\fichero1.txt");
	ArrayList <Alumno> contenido = new ArrayList <Alumno> ();
	//HashMap de alumnos
	HashMap <String, Alumno> listaAlumnos = new HashMap <String,Alumno>();

	
	public void updateMap () {
		contenido = f.leerFicheroColeccion();
		
		for(int i = 0; i < contenido.size(); i++) {
			String id = contenido.get(i).getId();
			Alumno a = contenido.get(i);
			if(!listaAlumnos.containsKey(id)) {//Si no existe en la coleccion, lo añade
				listaAlumnos.put(id, a);
			}
			
		}
	}
	
	
	public void Insertar (Alumno pAlumno) {
		if (listaAlumnos.containsKey(pAlumno.getId())) {
			System.out.println("Ya existe el registro!");
			
		}
		else {
			f.escribirFichero(pAlumno.toString());
			listaAlumnos.put(pAlumno.getId(),pAlumno);
			
		}	
	}
	
	public void volcarMap() {
		f.borrarFichero();
		for (HashMap.Entry <String, Alumno> lista: listaAlumnos.entrySet()) {
			f.escribirFichero(lista.getValue().toString());
		}
		
	}
	
	/*public Alumno buscaDNI (String pDNI) {
		
		contenido = f.leerFicheroColeccion();
	
		for (int i = 0; i < contenido.size(); i++) {
			if (contenido.get(i).getId().equals(pDNI)) {
				return contenido.get(i);
			}
		}
		
		return null;
	}*/
	
	
	 /*public String buscaDNIv2 (String dni) {
		
		contenido = f.leerFichero();
		
		for (int i = 0; i < contenido.size(); i++) {
			if (contenido.get(i).contains(dni)) {
				return contenido.get(i);
			}
		}
		
		return null;
	}*/
	
	 public Alumno buscaDNImap (String pDNI) {
		 Alumno a = null;
		 
		 if(listaAlumnos.containsKey(pDNI)) {
			 a = listaAlumnos.get(pDNI);
		 }
		 
		 return a;	 		 
	 }
	
	public void Actualizar (String key, Alumno a) {
		if(listaAlumnos.containsKey(key)) {
			listaAlumnos.replace(key, a);
		}
		else {
			System.out.println("No existe el registro");
		}
	}
	
	public boolean Borrar (String pDNI) {
		if(listaAlumnos.containsKey(pDNI)) {
			listaAlumnos.remove(listaAlumnos.get(pDNI));
			return true;
		}
		else {
			return false;
		}
		
	}
}
