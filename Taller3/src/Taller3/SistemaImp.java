package Taller3;

import java.util.ArrayList;

import Factory.FactoryProyecto;
import Factory.FactoryTarea;
import Factory.FactoryUsuario;

public class SistemaImp implements Sistema {
	private static ArrayList<Usuario> usuarios = new ArrayList<>();
	private static ArrayList<Proyecto> proyectos = new ArrayList<>();
	private static ArrayList<Tarea> tareas = new ArrayList<>();
	private static SistemaImp instance;
	
	private SistemaImp(){
		
	}
	public static Sistema getInstance() {
		if (instance == null) {
			return new SistemaImp();
		}
		return instance;
	}
	@Override
	public void crearUsuario(String[] p) {
		String username = p[0];
		String contraseña = p[1];
		String rol = p[2];
		usuarios.add(FactoryUsuario.crearUsuario(username, contraseña, rol));
	
	}
	@Override
	public void crearProyecto(String[] p) {
		String idProyecto = p[0];
		String nombreProyecto = p[1];
		String responsableProyecto = p[2];
		Proyecto proyecto = FactoryProyecto.crearProyecto(idProyecto, nombreProyecto, responsableProyecto);
				
		for (Usuario usuario : usuarios) {
			if(usuario.getUsuario().equals(responsableProyecto)) {
				usuario.agregarProyecto(proyecto);
			}
		}
		proyectos.add(proyecto);
		
	}
	@Override
	public void crearTarea(String[] p) {
		String idProyecto = p[0];
		String idTarea = p[1];
		String tipo = p[2];
		String descripcion = p[3];
		String estado = p[4];
		String responsableTarea = p[5];
		String complejidad = p[6];
		String fecha = p[7];
		Tarea tarea = FactoryTarea.crearTarea(idProyecto, idTarea, tipo, descripcion, estado, responsableTarea, complejidad, fecha);
		for (Proyecto proyecto : proyectos) {
			if (proyecto.getId().equals(idProyecto)) {
				proyecto.agregarTarea(tarea);
			}
		}
		tareas.add(tarea);
		
		
		
		
	}
}
