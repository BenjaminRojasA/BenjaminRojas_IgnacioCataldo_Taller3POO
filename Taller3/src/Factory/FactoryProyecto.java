package Factory;
import Taller3.Proyecto;
public class FactoryProyecto {

	public static Proyecto crearProyecto(String id, String nombre, String responsable) {
		return new Proyecto(id,nombre,responsable);
	}
}
