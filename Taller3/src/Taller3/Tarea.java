package Taller3;

public class Tarea {
	private String idproyecto;
	private String idTarea;
	private String tipo;
	private String descripcion;
	private String estado;
	private String responsableTarea;
	private String complejidad;
	private String fecha;
	
	public Tarea(String idproyecto, String idTarea, String tipo, String descripcion, String estado,
			String responsableTarea, String complejidad, String fecha) {
		super();
		this.idproyecto = idproyecto;
		this.idTarea = idTarea;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.responsableTarea = responsableTarea;
		this.complejidad = complejidad;
		this.fecha = fecha;
	}
	
	public String getIdTarea() {
		return idTarea;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Tarea [id=" + idTarea + ", tipo =" + tipo + ", descripcion="
				+ descripcion + ", estado=" + estado + ", responsableTarea=" + responsableTarea + ", complejidad="
				+ complejidad + ", fecha=" + fecha + "]";
	}
	
	
	
	 
	
	
}
