package Al;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Excepciones {
		Pruebas();
	}

	static void Pruebas() {
		BDAlumno bdalumno = new BDAlumno();
		Alumno alumnoUno = new Alumno("Pepe", 26, "A", "Fernandez", "Programacion");
		Alumno alumnoDos = new Alumno("Luis", 20, "B");
		Alumno alumnoTres = new Alumno("Juan", 32, "A");
		Alumno alumnoCuatro = new Alumno("Antonio", 25, "D");
		List<Alumno> listado;
		Map<String, Alumno> listadoSinCaps;

		// Save
		System.out.println("---------------");
		System.out.println("Metodo inserta");
		try {
			bdalumno.inserta(alumnoUno);
		} catch (Excepciones e) {
			System.out.println(e.getMensaje());
		}
		try {
			bdalumno.inserta(alumnoDos);
		} catch (Excepciones e) {
			System.out.println(e.getMensaje());
		}
		try {
			bdalumno.inserta(alumnoTres);
		} catch (Excepciones e) {
			System.out.println(e.getMensaje());
		}

		// Get all
		System.out.println("---------------");
		System.out.println("Metodo getAll \n");
		try {
			listado = bdalumno.getAll();
			for (int i = 0; i < listado.size(); i++) {
				Alumno z = listado.get(i);
				System.out.println(z.toString());
			}
		} catch (Excepciones e) {
			System.out.println(e.getMensaje());
		}

		// Count
		System.out.println("---------------");
		System.out.println("Metodo count \n");
		try {
			System.out.println(bdalumno.count());
		} catch (Excepciones e) {
			System.out.println(e.getMensaje());
		}

		// Delete
		try {
			bdalumno.borrar(alumnoDos.getDNI());
		} catch (Excepciones e) {
			System.out.println(e.getMensaje());
		}

		// Get all
		System.out.println("---------------");
		System.out.println("Metodo getAll \n");
		try {
			listado = bdalumno.getAll();
			for (int i = 0; i < listado.size(); i++) {
				Alumno z = listado.get(i);
				System.out.println(z.toString());
			}
		} catch (Excepciones e) {
			System.out.println(e.getMensaje());
		}

		// Count
		System.out.println("---------------");
		System.out.println("Metodo count \n");
		try {
			System.out.println(bdalumno.count());
		} catch (Excepciones e) {
			System.out.println(e.getMensaje());
		}

		// Save
		System.out.println("---------------");
		System.out.println("Metodo inserta \n");
		try {
			bdalumno.inserta(alumnoCuatro);
		} catch (Excepciones e) {
			System.out.println(e.getMensaje());
		}

		try {
			Alumno a = new Alumno("Pedro", 23, "C");
			bdalumno.inserta(a);

		} catch (Excepciones e) {
			System.out.println(e.getMensaje());
		}

		// Get all
		System.out.println("---------------");
		System.out.println("Metodo getAll \n");
		try {
			listado = bdalumno.getAll();
			for (int i = 0; i < listado.size(); i++) {
				Alumno z = listado.get(i);
				System.out.println(z.toString());
			}
		} catch (Excepciones e) {
			System.out.println(e.getMensaje());
		}

		// Count
		System.out.println("---------------");
		System.out.println("Metodo count \n");
		try {
			System.out.println(bdalumno.count());
		} catch (Excepciones e) {
			System.out.println(e.getMensaje());
		}

		// Borrar
		System.out.println("---------------");
		System.out.println("Metodo borrar \n");
		try {
			bdalumno.borrar(alumnoDos.getDNI());
		} catch (Excepciones e) {
			System.out.println(e.getMensaje());
		}

		// existByDNI
		System.out.println("---------------");
		System.out.println("Metodo existByDNI \n");
		try {
			System.out.println(bdalumno.buscaPorDNI("D"));
			System.out.println(bdalumno.buscaPorDNI("E"));
		} catch (Excepciones e) {
			System.out.println(e.getMensaje());
		}

		// findByDNI
		System.out.println("---------------");
		System.out.println("Metodo findByDNI \n");
		try {
			System.out.println(bdalumno.findByDNI("D"));
			System.out.println(bdalumno.findByDNI("E"));
		} catch (Excepciones e) {
			System.out.println(e.getMensaje());
		}
		
		// Get all
		System.out.println("---------------");
		System.out.println("Metodo getAll \n");
		try {
			listado = bdalumno.getAll();
			for (int i = 0; i < listado.size(); i++) {
				Alumno z = listado.get(i);
				System.out.println(z.toString());
			}
		} catch (Excepciones e) {
			System.out.println(e.getMensaje());
		}
		
		//getMapByIgnoreCase
		System.out.println("---------------");
		System.out.println("Metodo getMapByIgnoreCase \n");
		try {
			listadoSinCaps = bdalumno.getMapByIgnoreCase("An");
			for (HashMap.Entry<String, Alumno> lista : listadoSinCaps.entrySet()) {
				Alumno z = lista.getValue();
				System.out.println(z.toString());
			}
			listadoSinCaps = bdalumno.getMapByIgnoreCase("AnTo");
			for (HashMap.Entry<String, Alumno> lista : listadoSinCaps.entrySet()) {
				Alumno z = lista.getValue();
				System.out.println(z.toString());
			}
		} catch (Excepciones e) {
			System.out.println(e.getMensaje());
		}
		
	}
}
