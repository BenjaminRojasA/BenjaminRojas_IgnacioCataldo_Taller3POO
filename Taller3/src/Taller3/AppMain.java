package Taller3;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class AppMain {
	private static Sistema system = SistemaImp.getInstance();
	private static ArrayList<Usuario> usuarios = system.verUsuarios();
	private static Scanner Escaner;
	private static Usuario usuarioLogueado = null;
	public static void main(String[] args) throws FileNotFoundException {
		cargarUsuarios();
		cargarProyectos();
		cargarTareas();
		Escaner = new Scanner(System.in);
		
		while (true) {
			System.out.println("Usuario: ");
			String usuario = Escaner.nextLine();
			System.out.println("coontraseña: ");
			String contraseña = Escaner.nextLine();
			int condicional = 0;
			for (Usuario usuarioLista : usuarios) {
				if (usuarioLista.getUsuario().equals(usuario) && usuarioLista.getContraseña().equals(contraseña)) {
					System.out.println("Usuario Logueado.");
					condicional = 1;
					usuarioLogueado = usuarioLista;
					break;
				}	
			}
			if (condicional == 1) {
				break;
			} else {
				System.out.println("Usuario no enontrado.");
			}
			System.out.println("");
			
		}
		if (usuarioLogueado.getRol().equals("Administrador")) {
			
		} else if (usuarioLogueado.getRol().equals("Colaborador")) {
			menuUsuario();
		}
			
	}	
	
	
	private static void menuUsuario() {
		
		while(true) {
			
			System.out.println("--------Menú Usuario------");
			System.out.println("1) Ver proyectos disponibles.");
			System.out.println("2) Ver tareas asignadas.");
			System.out.println("3) Actualizar estado de una tarea.");
			System.out.println("4) Aplicar Visitor sobre tareas.");
			System.out.println("5) Salir.");
			
			int  opcion = Integer.parseInt(Escaner.nextLine());
			
			// Despliegue de opciones de Menu de Usuario
			try {
				
				if (opcion == 1) {
					desplegarProyectos();
					
				} else if( opcion == 2) {
					desplegarTareas();
				
				} else if( opcion == 3) {
					actualizarEstadoTarea();
				
				} else if( opcion == 4) {
					
				} else if (opcion == 5) {
					System.out.println("Saliendo...");
					break;
				} else {
					System.out.println("Error: debes ingresar una opcion valida ( 1, 2, 3, 4 o 5)!.");
				}
				
			} catch (NumberFormatException e) {
		        System.out.println("Error: Debes ingresar un número válido (1, 2 o 3).");
		    }

		    System.out.println();
			
		}
		
		
	}


	private static void actualizarEstadoTarea() {
		ArrayList<Tarea> tareasUsuario = usuarioLogueado.getTareas();
		Escaner = new Scanner(System.in);
		System.out.println("Tareas de " + usuarioLogueado.getUsuario() + ":");
		if ( tareasUsuario != null) {
			
			for (Tarea tareaUsuario: tareasUsuario) {
				if (!tareaUsuario.getEstado().equals("Completada")) {
					System.out.println(">> " + tareaUsuario);
					
				}
			}
			System.out.println("");
			System.out.println("Que tarea deseas actualizar el estado (indica el id)? : ");
			String idTareaActualizar = Escaner.nextLine();
			
			for (Tarea tareaUsuario: tareasUsuario) {
				if (tareaUsuario.getIdTarea().equals(idTareaActualizar)) {
					System.out.println("A la tarea " + tareaUsuario.getIdTarea() + " cambiar estado a en 'progreso' o a 'Completada'?: ");
					while (true) {
						String estadoTareaIngresado = Escaner.nextLine();
						tareaUsuario.setEstado(estadoTareaIngresado);
						break;
					}
				}

			}
			
			
		} else {
			System.out.println(usuarioLogueado.getUsuario() + " actualmente no tiene tareas asignadas.");
		}
	
	}


	private static void desplegarTareas() {
		ArrayList<Tarea> tareasUsuario = usuarioLogueado.getTareas();
		System.out.println("Tareas de " + usuarioLogueado.getUsuario() + ":");
		if ( tareasUsuario != null) {
			for (Tarea tareaUsuario: tareasUsuario) {
				System.out.println(">> " + tareaUsuario);
			}
			
		} else {
			System.out.println(usuarioLogueado.getUsuario() + " actualmente no tiene tareas asignadas.");
		}
		
	}


	private static void desplegarProyectos() {
		ArrayList<Proyecto> proyectosUsuario = usuarioLogueado.getProyectos();
		System.out.println("Proyectos de " + usuarioLogueado.getUsuario() + ":");
		
		if (proyectosUsuario != null) {
			for (Proyecto proyectoUsuario : proyectosUsuario) {
				System.out.println(proyectoUsuario);
			}
			
		} else {
			System.out.println(usuarioLogueado.getUsuario() + " actualmente no tiene proyectos asignados.");
			
		}
		
	}


	private static void menuAdministrador() {
		// TODO Auto-generated method stub
		
	}


	private static void cargarTareas() throws FileNotFoundException {
		Escaner = new Scanner(new File("tareas.txt"));
		
		while (Escaner.hasNextLine()) {
			String linea = Escaner.nextLine();
			String[] partesUsuario = linea.split("\\|");
			system.crearTarea(partesUsuario);
			
			}
		
	}


	private static void cargarProyectos() throws FileNotFoundException {
		Escaner = new Scanner(new File("proyectos.txt"));
		
		while (Escaner.hasNextLine()) {
			String linea = Escaner.nextLine();
			String[] partesProyecto = linea.split("\\|");
			system.crearProyecto(partesProyecto);
			
			}
		
	}


	private static void cargarUsuarios() throws FileNotFoundException {
		Escaner = new Scanner(new File("usuarios.txt"));
		
		while (Escaner.hasNextLine()) {
			String linea = Escaner.nextLine();
			String[] partesTarea = linea.split("\\|");
			system.crearUsuario(partesTarea);
			
			}
	}	

	

}
