package Taller3;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class AppMain {
	private static Sistema system = SistemaImp.getInstance();
	private static Scanner s;
	
	public static void main(String[] args) throws FileNotFoundException {
		cargarUsuarios();
		cargarProyectos();
		cargarTareas();
			
	}	
	
	
	private static void cargarTareas() throws FileNotFoundException {
		s = new Scanner(new File("tareas.txt"));
		
		while (s.hasNextLine()) {
			String linea = s.nextLine();
			String[] partes = linea.split("|");
			system.crearTarea(partes);
			
			}
		
	}


	private static void cargarProyectos() throws FileNotFoundException {
		s = new Scanner(new File("proyectos.txt"));
		
		while (s.hasNextLine()) {
			String linea = s.nextLine();
			String[] partes = linea.split("|");
			system.crearProyecto(partes);
			
			}
		
	}


	private static void cargarUsuarios() throws FileNotFoundException {
		s = new Scanner(new File("usuarios.txt"));
		
		while (s.hasNextLine()) {
			String linea = s.nextLine();
			String[] partes = linea.split("|");
			system.crearUsuario(partes);
			
			}
	}	

	

}
