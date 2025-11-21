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
}
