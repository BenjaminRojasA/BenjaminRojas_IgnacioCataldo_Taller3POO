package Factory;
import Taller3.Tarea;
public class FactoryTarea {
	public static Tarea crearTarea(String idProyecto, String id, String tipo,String descripcion, String estado, String responsable, String complejidad, String fecha) {
		
		switch (tipo) {
		case "Bug":
			return new TareaBug(idProyecto,id,tipo,descripcion,estado,responsable,complejidad,fecha);
			
		case "Feature":
			return new TareaFeature(idProyecto,id,tipo,descripcion,estado,responsable,complejidad,fecha);
		
		case "Documentacion":
			return new TareaDocumentacion(idProyecto,id,tipo,descripcion,estado,responsable,complejidad,fecha);
			
		}
		return null;
		
	}

}
