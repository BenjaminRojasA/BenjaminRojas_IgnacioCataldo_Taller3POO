package Taller3;

import java.util.ArrayList;

import Factory.FactoryProyecto;
import Factory.FactoryTarea;
import Factory.FactoryUsuario;

public class SistemaImp implements Sistema {
	
	//-----------------------listas de objetos--------------------
	private static ArrayList<Usuario> usuarios = new ArrayList<>();
	private static ArrayList<Proyecto> proyectos = new ArrayList<>();
	private static ArrayList<Tarea> tareas = new ArrayList<>();
	//---------------Patron Singleton--------------------
	private static SistemaImp instance;
	private SistemaImp(){
		
	}
	public static Sistema getInstance() {
		if (instance == null) {
			return new SistemaImp();
		}
		return instance;
	}
	//----------------------------------------------------
	
	//Metodo de creacion de objeto Usuario.
	@Override
	public void crearUsuario(String[] partesUsuario) {
		String username = partesUsuario[0];
		String contraseña = partesUsuario[1];
		String rol = partesUsuario[2];
		usuarios.add(FactoryUsuario.crearUsuario(username, contraseña, rol));
	
	}
	//Metodo de creacion de objeto Proyecto.
	@Override
	public void crearProyecto(String[] partesProyecto) {
		String idProyecto = partesProyecto[0];
		String nombreProyecto = partesProyecto[1];
		String responsableProyecto = partesProyecto[2];
		Proyecto proyecto = FactoryProyecto.crearProyecto(idProyecto, nombreProyecto, responsableProyecto);
				
		for (Usuario usuario : usuarios) {
			if(usuario.getUsuario().equals(responsableProyecto)) {
				usuario.agregarProyecto(proyecto);
			}
		}
		proyectos.add(proyecto);
		
	}
	//Metodo de creacion de objeto Tarea.
	@Override
	public void crearTarea(String[] partesTarea) {
		String idProyecto = partesTarea[0];
		String idTarea = partesTarea[1];
		String tipoTarea = partesTarea[2];
		String descripcionTarea = partesTarea[3];
		String estadoTarea = partesTarea[4];
		String responsableTarea = partesTarea[5];
		String complejidadTarea = partesTarea[6];
		String fechaTarea = partesTarea[7];
		Tarea tarea = FactoryTarea.crearTarea(idProyecto, idTarea, tipoTarea, descripcionTarea, estadoTarea, responsableTarea, complejidadTarea, fechaTarea);
		
		for (Usuario usuario : usuarios) {
			if (usuario.getUsuario().equals(responsableTarea)) {
				usuario.agregarTarea(tarea);
			}
		}
		
		for (Proyecto proyecto : proyectos) {
			if (proyecto.getId().equals(idProyecto)) {
				proyecto.agregarTarea(tarea);
			}
		}
		
		tareas.add(tarea);
			
	}
	
	@Override
	public ArrayList<Usuario> verUsuarios() {
		return usuarios;
	}
	@Override
	public ArrayList<Proyecto> verProyectos() {		
		return proyectos;
	}
	@Override
	public void agregarProyecto(String idProyecto, String nombreProyecto, String responsableProyecto) {
		Proyecto proyecto = FactoryProyecto.crearProyecto(idProyecto, nombreProyecto, responsableProyecto);
		proyectos.add(proyecto);
		
	}
	@Override
	public void eliminarProyecto(String idProyecto) {
		for (Proyecto proyecto : proyectos) {
			if (proyecto.getId().equals(idProyecto)) {
				ArrayList<Tarea> tareasProyecto = proyecto.getTareas();
				tareasProyecto = null;
				for (Tarea tareaBuscada : tareas) {
					if (tareaBuscada.getIdproyecto().equals(idProyecto)) {
						tareaBuscada.setIdproyecto("Sin proyecto asignado.");
					}
				}
				proyectos.remove(proyecto);
				break;
			}
		}
			
		
	}
	 
	
	@Override
	public void agregarTarea(String idProyecto, String idTarea, String tipoTarea, String descripcionTarea,
			String estadoInicialTarea, String responsableTarea, String complejidadTarea, String fechaTarea) {
		
		Tarea tareaCreada = FactoryTarea.crearTarea(idProyecto, idTarea, tipoTarea, descripcionTarea, estadoInicialTarea, responsableTarea, complejidadTarea, fechaTarea);
		tareas.add(tareaCreada);
		
		for (Proyecto proyectoBuscado : proyectos ) {
			if (proyectoBuscado.getId().equals(idProyecto)) {
				proyectoBuscado.getTareas().add(tareaCreada);
			}
		}
		
		for (Usuario usuarioBuscado : usuarios) {
			if (usuarioBuscado.getUsuario().equals(responsableTarea)) {
				int contadorTareaMismaFecha = 0;
				for (Tarea tarea : usuarioBuscado.getTareas()) {
					if (tarea.getFecha().equals(fechaTarea)) {
						contadorTareaMismaFecha +=1;
					}
				if (contadorTareaMismaFecha == 0) {
					usuarioBuscado.getTareas().add(tareaCreada);
				} 
				
				}
			}
		}
	}
	@Override
	public void eliminarTarea(String idProyecto, String idTarea, String tipoTarea, String descripcionTarea,
			String estadoInicialTarea, String responsableTarea, String complejidadTarea, String fechaTarea) {
		for (Tarea tareaBuscada : tareas) {
			if (tareaBuscada.getIdTarea().equals(idTarea)) {
				for (Proyecto proyectoBuscado : proyectos) {
					if (proyectoBuscado.getId().equals(idProyecto)) {
						proyectoBuscado.getTareas().remove(tareaBuscada);
					}
				}
				for (Usuario usuarioBuscado : usuarios) {
					if (usuarioBuscado.getUsuario().equals(responsableTarea)) {
						usuarioBuscado.getTareas().remove(tareaBuscada);
					}
				}
			}
		}
		
	}
	
}
