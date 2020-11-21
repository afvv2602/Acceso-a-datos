import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Fichero {

	private String ruta;
	private ArrayList <Alumno> coleccion = new ArrayList <Alumno> ();
	private ArrayList <String> listaFichero = new ArrayList <String> ();
	
	public Fichero (String ruta) {
		this.ruta = ruta;
		
	}

	public ArrayList <Alumno> leerFicheroColeccion () 
	{
		BufferedReader buffReader = null;
		
		try 
		{
			buffReader = new BufferedReader(new FileReader(this.ruta));
			String linea;
			
			while ((linea = buffReader.readLine())!= null) 
			{
				
				Alumno a = new Alumno(linea.split("#")[0],linea.split("#")[1],Integer.parseInt(linea.split("#")[2]));
				
				coleccion.add(a);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		finally {
			try {
				if (buffReader != null)
					buffReader.close();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return coleccion;
	}
		
	public void escribirFichero (String contenido) 
	{
		BufferedWriter buffWriter = null;
		
		try 
		{
			buffWriter = new BufferedWriter(new FileWriter(this.ruta, true));
			
			buffWriter.write(contenido);
			buffWriter.newLine();
			buffWriter.close();		
			
		}catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (buffWriter != null)
					buffWriter.close();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	
	}
	
	public ArrayList <String> leerFichero () {
	BufferedReader buffReader = null;
	
	try {
		buffReader = new BufferedReader(new FileReader(this.ruta));
		String linea;
		
		while ((linea = buffReader.readLine())!= null) {

			listaFichero.add(linea);
		}
		System.out.println(listaFichero);
	}catch (Exception e) {
		System.out.println(e.getMessage());
		
	}
	finally {
		try {
			if (buffReader != null)
				buffReader.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	return listaFichero;
	}
	
	public void borrarFichero ()  {
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(this.ruta));
			bw.write("");
			bw.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}



