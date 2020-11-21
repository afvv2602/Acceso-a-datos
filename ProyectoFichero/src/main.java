import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		BDAlumno bdalumno = new BDAlumno();
		BDAlumnoXML bdXML = new BDAlumnoXML();
		
		bdalumno.updateMap();
		
		Alumno a = new Alumno ("7007845H","VICTOR" , 23);
		Alumno a2 = new Alumno ("90082254V","JUAN" , 29);
		Alumno a3 = new Alumno ("67857463V","LUIS", 17);
		Alumno a4 = new Alumno ("67859421Y", "ANDREA", 20);
		Alumno a5 = new Alumno ("381736315H", "TOMAS", 19);
		
		
		bdalumno.Insertar(a);
		bdalumno.Insertar(a2);
		bdalumno.Insertar(a3);
		bdalumno.Insertar(a4);
		bdalumno.Insertar(a5);
		
		bdXML.Inserta(a);
		bdXML.Inserta(a2);
		bdXML.Inserta(a3);
		bdXML.Inserta(a4);
		bdXML.Inserta(a5);
		
		/*Alumno prueba = bdalumno.buscaDNImap("90082254V");
		
		System.out.println("Registro encontrado: " + prueba.toString());*/
		
		Alumno a6 = new Alumno("381736315H", "ADRIAN", 12);
		bdalumno.Actualizar(a6.getId(), a6);
		
		bdalumno.volcarMap();
		
		
	}

}
