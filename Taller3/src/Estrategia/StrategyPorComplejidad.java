package Estrategia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import Taller3.Tarea;

public class StrategyPorComplejidad implements Strategy{
    
    // Mapeo para asignar un valor numérico a la complejidad
    private static final Map<String, Integer> MAPA_COMPLEJIDAD = new HashMap<>();
    static {
        // Asignamos mayor número a mayor prioridad
        MAPA_COMPLEJIDAD.put("Alta", 3);
        MAPA_COMPLEJIDAD.put("Media", 2);
        MAPA_COMPLEJIDAD.put("Baja", 1);
    }

    @Override
    public ArrayList<Tarea> ordenarTareas(ArrayList<Tarea> tareas) {
        ArrayList<Tarea> tareasPriorizadas = new ArrayList<>(tareas); 
        
        Collections.sort(tareasPriorizadas, new Comparator<Tarea>() {
            @Override
            public int compare(Tarea t1, Tarea t2) {
                Integer prioridad1 = MAPA_COMPLEJIDAD.getOrDefault(t1.getComplejidad(), 0);
                Integer prioridad2 = MAPA_COMPLEJIDAD.getOrDefault(t2.getComplejidad(), 0);
                
                // Comparamos los valores numéricos. 
                // Usamos (p2 - p1) para ordenar de forma descendente (3, 2, 1) -> (Alta, Media, Baja)
                return prioridad2.compareTo(prioridad1);
            }
        });
        
        return tareasPriorizadas;
    }
}
