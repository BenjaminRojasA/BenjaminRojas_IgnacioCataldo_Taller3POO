package Estrategia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Taller3.Tarea;

public class SatrategyPorFecha implements Strategy {

    @Override
    public ArrayList<Tarea> ordenarTareas(ArrayList<Tarea> tareas) {
        // Hacemos una copia de la lista para ordenar.
        ArrayList<Tarea> tareasPriorizadas = new ArrayList<>(tareas); 
        
        // Ordena usando un comparador.
        Collections.sort(tareasPriorizadas, new Comparator<Tarea>() {
            @Override
            public int compare(Tarea t1, Tarea t2) {
                // Compara las fechas (String) directamente. 
                // "2025-08-01" es menor que "2025-08-02", por lo que t1 sale primero.
                return t1.getFecha().compareTo(t2.getFecha()); 
            }
        });
        
        return tareasPriorizadas;
    }
}
	
