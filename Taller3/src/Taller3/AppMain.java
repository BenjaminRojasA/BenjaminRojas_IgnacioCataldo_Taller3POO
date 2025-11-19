package Taller3;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class AppMain {
	private static Sistema system = SistemaImp.getInstance();
	private static Scanner Escaner;
	
	public static void main(String[] args) throws FileNotFoundException {
		cargarUsuarios();
		cargarProyectos();
		cargarTareas();
			
	}	
	
	
	private static void cargarTareas() throws FileNotFoundException {
		Escaner = new Scanner(new File("tareas.txt"));
		
		while (Escaner.hasNextLine()) {
			String linea = Escaner.nextLine();
			String[] partesUsuario = linea.split("|");
			system.crearTarea(partesUsuario);
			
			}
		
	}


	private static void cargarProyectos() throws FileNotFoundException {
		Escaner = new Scanner(new File("proyectos.txt"));
		
		while (Escaner.hasNextLine()) {
			String linea = Escaner.nextLine();
			String[] partesProyecto = linea.split("|");
			system.crearProyecto(partesProyecto);
			
			}
		
	}


	private static void cargarUsuarios() throws FileNotFoundException {
		Escaner = new Scanner(new File("usuarios.txt"));
		
		while (Escaner.hasNextLine()) {
			String linea = Escaner.nextLine();
			String[] partesTarea = linea.split("|");
			system.crearUsuario(partesTarea);
			
			}
	}	

	

}
