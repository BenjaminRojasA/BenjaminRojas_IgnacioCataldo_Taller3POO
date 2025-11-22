package Taller3;

import java.util.ArrayList;

import Estrategia.Strategy;

public class Proyecto {
	private String id; 
	private String nombre;
	private String responsable;
	private ArrayList<Tarea> tareas = new ArrayList<>();
	private Strategy estrategiaActual;
	
	public Proyecto(String id, String nombre, String responsable) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.responsable = responsable;
	}
	
	public void setEstrategia(Strategy nuevaEstrategia) {
        this.estrategiaActual = nuevaEstrategia;
    }
	// Método para ejecutar la priorización
    public ArrayList<Tarea> priorizarTareas() {
        if (estrategiaActual == null) {
            System.out.println("No hay estrategia de priorización asignada.");
            return this.tareas;
        }
        // Delega la responsabilidad de ordenar a la estrategia actual
        return estrategiaActual.ordenarTareas(this.tareas);
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
