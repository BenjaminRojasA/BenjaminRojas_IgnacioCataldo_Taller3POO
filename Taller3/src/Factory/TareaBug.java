package Factory;

import Taller3.Tarea;
import Visitador.Visitor;

public class TareaBug extends Tarea {

	public TareaBug(String idproyecto, String idTarea, String tipo, String descripcion, String estado,
			String responsableTarea, String complejidad, String fecha) {
		super(idproyecto, idTarea, tipo, descripcion, estado, responsableTarea, complejidad, fecha);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor visitorImprimirTarea) {
		visitorImprimirTarea.visitar(this);		
	}

}
