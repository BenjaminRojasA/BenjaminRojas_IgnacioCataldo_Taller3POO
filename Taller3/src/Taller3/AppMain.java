package Taller3;

import java.util.ArrayList;
import java.util.Scanner;

import Visitador.Visitor;
import Visitador.visitorImprimirTarea;

import java.io.File;
import java.io.FileNotFoundException;
public class AppMain {
	private static Sistema system = SistemaImp.getInstance();
	private static ArrayList<Proyecto> proyectos = system.verProyectos();
	private static ArrayList<Usuario> usuarios = system.verUsuarios();
	private static Scanner Escaner;
	private static Usuario usuarioLogueado = null;
	public static void main(String[] args) throws FileNotFoundException {
		cargarUsuarios();
		cargarProyectos();
		cargarTareas();
		Escaner = new Scanner(System.in);
		
		while (true) {
			System.out.println("------------------------");
			System.out.print("Usuario: ");
			String usuario = Escaner.nextLine();
			System.out.print("Contraseña: ");
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
				System.out.println("------------------------");
				break;
			} else {
				System.out.println("Usuario no encontrado.");
				System.out.println("------------------------");
			}
			
			
		}
		if (usuarioLogueado.getRol().equals("Administrador")) {
			menuAdministrador();
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
			System.out.println(">> ");
			
			int  opcion = Integer.parseInt(Escaner.nextLine());
			
			// Despliegue de opciones de Menu de Usuario
			try {
				
				if (opcion == 1) {
					desplegarProyectosUsuario();
					
				} else if( opcion == 2) {
					desplegarTareas();
				
				} else if( opcion == 3) {
					actualizarEstadoTarea();
				
				} else if( opcion == 4) {
					visitarCadaTarea();
					
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


	private static void visitarCadaTarea() {
		Visitor visitador = new visitorImprimirTarea();
		System.out.println("Desplegando acciones segun las tareas de " + usuarioLogueado.getUsuario() + ".");
		for (Tarea tareaUsuario : usuarioLogueado.getTareas()) {
			tareaUsuario.accept(visitador);
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


	private static void desplegarProyectosUsuario() {
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
		
		while(true) {
			
			System.out.println("--------Menú Administrador------");
			System.out.println("1) Ver lista completa de proyectos y tareas.");
			System.out.println("2) Agregar o eliminar un proyecto.");
			System.out.println("3) Agregar o eliminar una tarea en un proyecto.");
			System.out.println("4) Asignar prioridades con Strategy.");
			System.out.println("5) Generar reporte de proyectos.");
			System.out.println("6) Salir.");
			System.out.println(">> ");
			
			int  opcion = Integer.parseInt(Escaner.nextLine());
			
			// Despliegue de opciones de Menu de Administrador
			try {
				
				if (opcion == 1) {
					 desplegarProyectos();
				} else if( opcion == 2) {
					agregarOeliminarProyecto();
		
				} else if( opcion == 3) {
					agregarOeleminarTarea();
					 
				} else if( opcion == 4) {
					aplicarEstrategia();
				
				} else if( opcion == 5) {
					
				} else if (opcion == 6) {
					System.out.println("Saliendo...");
					break;
				} else {
					System.out.println("Error: debes ingresar una opcion valida ( 1, 2, 3, 4, 5 o 6)!.");
				}
				
			} catch (NumberFormatException e) {
		        System.out.println("Error: Debes ingresar un número válido (1, 2 o 3).");
		    }

		    System.out.println();
			
		}
		
	}		
		private static void aplicarEstrategia() {
		// TODO Auto-generated method stub
		
	}


		private static void agregarOeleminarTarea() {
		Escaner = new Scanner(System.in);
		
		
		System.out.print("Que desea hacer 'Agregar' o 'Eliminar': ");
		String operacion = Escaner.nextLine();
		switch (operacion) {
		
		case "Agregar":
			agregarTarea();
			
			
		case "Eliminar":
			eliminarTarea();
			
		}
		
		
		
		
	}


	private static void eliminarTarea() {
		Escaner = new Scanner(System.in);
		System.out.print("Id deproyecto al cual elimin ar la tarea: ");
		String idProyecto = Escaner.nextLine();
		System.out.print("Id de tarea de la tarea: ");
		String idTarea = Escaner.nextLine();
		System.out.print("Tipo de tarea de la tarea: ");
		String tipoTarea = Escaner.nextLine();
		System.out.print("Descripcion de la tarea: ");
		String descripcionTarea = Escaner.nextLine();
		System.out.print("Estado inicial de la tarea: ");
		String estadoInicialTarea = Escaner.nextLine();
		System.out.print("Responsable de la tarea: ");
		String responsableTarea = Escaner.nextLine();
		System.out.print("Complejidad de la tarea: ");
		String complejidadTarea = Escaner.nextLine();
		System.out.print("Fecha de creacion de la tarea (xx-mm-yy): ");
		String fechaTarea = Escaner.nextLine();
		
		system.eliminarTarea(idProyecto, idTarea, tipoTarea, descripcionTarea, estadoInicialTarea, responsableTarea ,complejidadTarea,fechaTarea);
		System.out.println("Tarea eliminado con exito!.");			
		}


	private static void agregarTarea() {
		Escaner = new Scanner(System.in);
		System.out.print("Id deproyecto al cual agregar la tarea: ");
		String idProyecto = Escaner.nextLine();
		System.out.print("Id de tarea de la tarea: ");
		String idTarea = Escaner.nextLine();
		System.out.print("Tipo de tarea de la tarea: ");
		String tipoTarea = Escaner.nextLine();
		System.out.print("Descripcion de la tarea: ");
		String descripcionTarea = Escaner.nextLine();
		System.out.print("Estado inicial de la tarea: ");
		String estadoInicialTarea = Escaner.nextLine();
		System.out.print("Responsable de la tarea: ");
		String responsableTarea = Escaner.nextLine();
		System.out.print("Complejidad de la tarea: ");
		String complejidadTarea = Escaner.nextLine();
		System.out.print("Fecha de creacion de la tarea (xx-mm-yy): ");
		String fechaTarea = Escaner.nextLine();
		
		system.agregarTarea(idProyecto, idTarea, tipoTarea, descripcionTarea, estadoInicialTarea, responsableTarea ,complejidadTarea,fechaTarea);
		System.out.println("Tarea agregado con exito!.");
			
		}


	// Metodo agregar o eliminar un Proyecto
	private static void agregarOeliminarProyecto() {
		Escaner = new Scanner(System.in);
		System.out.print("ID del proyecto: ");
		String idProyecto = Escaner.nextLine();
		System.out.println("Nombre del proyecto: ");
		String nombreProyecto = Escaner.nextLine();
		System.out.println("Responsable del proyecto: ");
		String responsableProyecto = Escaner.nextLine();
		System.out.print("Que desea hacer 'Agregar' o 'Eliminar': ");
		String operacion = Escaner.nextLine();
		switch (operacion) {
		
		case "Agregar":
			system.agregarProyecto(idProyecto, nombreProyecto, responsableProyecto);
			System.out.println("Proyecto agregado con exito!.");
			
		case "Eliminar":
			system.eliminarProyecto(idProyecto);
			System.out.println("Proyecto eliminado con exito!.");
		}
		
	}


	private static void desplegarProyectos() {
		System.out.println("Proyectos:");
		int numeroDeProyecto = 1;
		for (Proyecto proyecto : proyectos) {
			System.out.println(numeroDeProyecto + ") " + proyecto);
			numeroDeProyecto += 1;
		}
		
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
