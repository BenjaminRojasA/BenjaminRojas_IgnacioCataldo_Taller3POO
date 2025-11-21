package Taller3;

import java.util.ArrayList;

public interface Sistema {

	void crearUsuario(String[] partes);
	void crearProyecto(String[] partes);
	void crearTarea(String[] partes);
	ArrayList<Usuario> verUsuarios();
	ArrayList<Proyecto> verProyectos();
	void agregarProyecto(String idProyecto, String nombreProyecto, String usuario);
	void eliminarProyecto(String idProyecto);

	
	void agregarTarea(String idProyecto, String idTarea, String tipoTarea, String descripcionTarea,
			String estadoInicialTarea, String responsableTarea, String complejidadTarea, String fechaTarea);
	void eliminarTarea(String idProyecto, String idTarea, String tipoTarea, String descripcionTarea,
			String estadoInicialTarea, String responsableTarea, String complejidadTarea, String fechaTarea);
	

}
