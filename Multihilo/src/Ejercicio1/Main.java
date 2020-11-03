package Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{


	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		ArrayList<Profesores> Profesores = new ArrayList<Profesores>();
		Profesores = crearProfesores();
		
		System.out.println("Introduce el dia que quieras buscar");
		String diaB = sc.next();
		sc.close();
		
	}
	
	public static ArrayList<Profesores> crearProfesores () {
		ArrayList<Profesores> Profesores = new ArrayList<Profesores>();
		String nombres[] = {"Alejandro","Pedro","Rosa","Antonio","Juan","Maria","Belen","Jesus","Raul","Pepe"};	
		String dias[] = {"Lunes","Martes","Miercoles","Jueves","Viernes"};
		int aleatorio = (int) (Math.random()*25+1);		
		for (int i = 0 ;i<aleatorio;i++) {
			int nb = (int) (Math.random()*10);	
			int dia = (int) (Math.random()*5);	
			int hora = (int)(Math.random()*(8-7+1)+7);
			int minutos;
			if (hora == 8) {
				minutos = (int)(Math.random()*30);
			}else {
				minutos = (int)(Math.random()*(60-30+1)+30);
			}
			String horas= hora +":"+minutos;
			Profesores c = new Profesores (nombres[nb],dias[dia],horas);
			Profesores.add(c);
			
		}
		return Profesores;
	}


}
