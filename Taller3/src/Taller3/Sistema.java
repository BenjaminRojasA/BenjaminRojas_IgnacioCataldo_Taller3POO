package Taller3;

import java.util.ArrayList;

public interface Sistema {

	void crearUsuario(String[] partes);
	void crearProyecto(String[] partes);
	void crearTarea(String[] partes);
	ArrayList<Usuario> verUsuarios();


}
