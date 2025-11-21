package Visitador;

import Factory.TareaBug;
import Factory.TareaDocumentacion;
import Factory.TareaFeature;
import Taller3.Tarea;
import Taller3.Usuario;

public class visitorImprimirTarea implements Visitor {

	@Override
	public void visitar(Tarea tarea) {
		
		if (tarea instanceof TareaBug) {
			System.out.println(tarea.getIdTarea() + " tipo: Bug -> Afecta criticidad del proyecto.");
		} else if (tarea instanceof TareaFeature) {
			System.out.println(tarea.getIdTarea() + " tipo: Feature -> Impacta en la estimación de tiempo.");
		} else if (tarea instanceof TareaDocumentacion) {
			System.out.println(tarea.getIdTarea() + " tipo: Documentacion -> Mejora la calidad del proyecto.");
		}
		
		
	}

}
