package Taller3;

import java.util.ArrayList;

public class Usuario {
	private String usuario;
	private String contraseña;
	private String rol;
	private ArrayList<Proyecto> proyectos = new ArrayList<>();
	private ArrayList<Tarea> tareas = new ArrayList<>();

	public Usuario(String usuario, String contraseña, String rol) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.rol = rol;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	
	public void agregarProyecto(Proyecto proyecto) {
		proyectos.add(proyecto);
		
	}

	public String getRol() {
		return rol;
	}

	public ArrayList<Proyecto> getProyectos() {
		return proyectos;
	}

	public void agregarTarea(Tarea tarea) {
		tareas.add(tarea);
		
	}

	public ArrayList<Tarea> getTareas() {
		return tareas;
	}
	
	

	

	
	
	
	
	
}
