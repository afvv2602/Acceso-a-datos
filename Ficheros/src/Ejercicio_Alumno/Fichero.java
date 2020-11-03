package Ejercicio_Alumno;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;

class Fichero {

	private String ruta;
	HashMap<String, Alumno> HMAlumnos = new HashMap<String, Alumno>();
	ArrayList<String> Alumnos = new ArrayList<String>();
	
	public Fichero(String ruta) {
		this.ruta = ruta;
	}

	public void insertaLinea(Alumno alumno) {
		File fichero = new File(this.ruta);
		String linea = alumno.toString();
		BufferedWriter buffWriter = null;
		try {
			buffWriter = new BufferedWriter(new FileWriter(fichero, true)); // true para que no machaque el fichero
			buffWriter.write(linea); // insertamos la linea
			buffWriter.newLine(); // creamos una linea debajo para que haga el salto de linea
			buffWriter.close(); // cerramos el fichero
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (buffWriter != null)
					buffWriter.close(); // cerramos el fichero
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	public Alumno actualizarRegistro(String separador, int posicion, String cambio,String pDNI) {
		String Nombre,Apellidos,edad,Modulo;
		Alumno Alumno = null;
		int Edad;
		Alumnos = dameContenido();
		for (String cadenaAlumnos : Alumnos) {
			String[] datosAlumnos = cadenaAlumnos.split(separador);
			String DNI = datosAlumnos[0];
			if (pDNI.equals(DNI)) {
				switch(posicion) {
				case 1: 
					//Actualiza Nombre
					Apellidos = datosAlumnos[2]; edad = datosAlumnos[3]; Modulo = datosAlumnos[4]; Edad = Integer.parseInt(edad);
					Alumno = new Alumno(cambio, Edad, DNI, Apellidos, Modulo);
					break;
				case 2:
					//Actualiza Apellidos
					 Nombre= datosAlumnos[1]; edad = datosAlumnos[3]; Modulo = datosAlumnos[4]; Edad = Integer.parseInt(edad);
					 Alumno = new Alumno(Nombre, Edad, DNI, cambio, Modulo);
					break;
				case 3:
					//Actualiza Edad
					Nombre= datosAlumnos[1]; Apellidos = datosAlumnos[2]; edad = datosAlumnos[3]; Modulo = datosAlumnos[4]; Edad = Integer.parseInt(cambio);
					Alumno = new Alumno(Nombre, Edad, DNI, Apellidos , Modulo);
					break;
				case 4: 
					//Actualiza Modulo
					Nombre= datosAlumnos[1]; Apellidos = datosAlumnos[2]; edad = datosAlumnos[3]; Edad = Integer.parseInt(edad);
					Alumno = new Alumno(Nombre, Edad, DNI, Apellidos , cambio);
					break;
				default : break;				
				}
			}
		}
		return Alumno;
		
	}

	public void BorrarLinea(String busqueda, int posicion, String separador) {
		File outputFile = null;
		File inputFile = null;
		try {
			inputFile = new File(this.ruta);
			outputFile = new File("./BDAlumnos_Temporal");
			outputFile.createNewFile();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(inputFile)); 
			writer = new BufferedWriter(new FileWriter(outputFile));
			String linea = null;
			while ((linea = reader.readLine()) != null) {
				String[] datosAlumnos = linea.split(separador);
				String DNIactual = datosAlumnos[posicion];
				if (DNIactual.trim().equals(busqueda)) {
					continue;
				}
				writer.write(linea + System.getProperty("line.separator"));
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (reader != null && writer != null) {
					reader.close();
					writer.close();
					moveFile(outputFile.getAbsolutePath(), inputFile.getAbsolutePath());
				}

			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}

		}

	}

	public void moveFile(String fromFile, String toFile) {

		File origin = new File(fromFile);
		File destination = new File(toFile);
		if (origin.exists()) {
			BufferedReader reader = null;
			BufferedWriter writer = null;
			try {
				reader = new BufferedReader(new FileReader(origin));// Lee BDAlumnos_Temporal
				writer = new BufferedWriter(new FileWriter(destination)); //Escribe en BDAlumnos
				String linea = null;
				while ((linea = reader.readLine()) != null) {
					writer.write(linea); // insertamos la linea
					writer.newLine(); // creamos una linea debajo para que haga el salto de linea
				}
				reader.close();
				writer.close();
				origin.delete(); // Borramos el fichero temporal 
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	}

	public ArrayList<String> dameContenido() {
		File fichero = new File(this.ruta);
		BufferedReader buffReader = null;
		try {
			buffReader = new BufferedReader(new FileReader(fichero)); // creamos fichero de lectura
			String linea;
			while ((linea = buffReader.readLine()) != null) {
				Alumnos.add(linea); // A�adimos el alumno al fichero
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (buffReader != null)
					buffReader.close();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}

		}
		return Alumnos; // devolvemos el arraylist
	}

	public HashMap<String, Alumno> crearHM() {

		ArrayList<String> alumnos = dameContenido();
		for (String cadenaAlumnos : alumnos) {
			String[] datosAlumnos = cadenaAlumnos.split("#");
			String DNI = datosAlumnos[0];
			String Nombre = datosAlumnos[1];
			String Apellidos = datosAlumnos[2];
			String edad = datosAlumnos[3];
			String Modulo = datosAlumnos[4];
			int Edad = Integer.parseInt(edad);
			Alumno Alumno = new Alumno(Nombre, Edad, DNI, Apellidos, Modulo);
			HMAlumnos.put(DNI, Alumno);

		}

		return HMAlumnos;
	}

	public void volcarMap(HashMap<String, Alumno> alumnos) {
		
		File origin = new File(this.ruta);
		if (origin.exists()) {
			BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter(origin));
				for(HashMap.Entry<String, Alumno> lista: alumnos.entrySet()) {
					writer.write(lista.getValue().toString()); // insertamos la linea
					writer.newLine(); // creamos una linea debajo para que haga el salto de linea
				}
				writer.close();
			}catch (IOException ioe) {
				ioe.printStackTrace();
				
			} 
		}
		
	}


}