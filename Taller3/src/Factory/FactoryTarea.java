package Factory;
import Taller3.Tarea;
public class FactoryTarea {
	public static Tarea crearTarea(String idProyecto, String id, String tipo,String descripcion, String estado, String responsable, String complejidad, String fecha) {
		
		return new Tarea(idProyecto,id,tipo,descripcion,estado,responsable,complejidad,fecha);
		
	}

}
