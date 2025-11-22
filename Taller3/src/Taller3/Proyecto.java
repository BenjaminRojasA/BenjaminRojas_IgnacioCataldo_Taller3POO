package Taller3;

import java.util.ArrayList;

public class Proyecto {
	private String id; 
	private String nombre;
	private String responsable;
	private ArrayList<Tarea> tareas = new ArrayList<>();
	
	public Proyecto(String id, String nombre, String responsable) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.responsable = responsable;
	}

	public String getId() {
		return id;
	}
	
	public String getResponsable() {
		return responsable;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Tarea> getTareas() {
		return tareas;
	}

	public void agregarTarea(Tarea tarea) {
		tareas.add(tarea);
		
	}
	
	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", responsable=" + responsable + ", tareas=" + tareas
				+ "]";
	}

	
	
	
	
}
