package Estrategia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import Taller3.Tarea;

public class StrategyPorImpacto implements Strategy {
    
    // Mapeo para asignar un valor numérico al Tipo/Impacto
    private static final Map<String, Integer> MAPA_IMPACTO = new HashMap<>();
    static {
        // Bug tiene la máxima prioridad
        MAPA_IMPACTO.put("Bug", 3);
        MAPA_IMPACTO.put("Feature", 2);
        MAPA_IMPACTO.put("Documentacion", 1);
    }

    @Override
    public ArrayList<Tarea> ordenarTareas(ArrayList<Tarea> tareas) {
        ArrayList<Tarea> tareasPriorizadas = new ArrayList<>(tareas); 
        
        Collections.sort(tareasPriorizadas, new Comparator<Tarea>() {
            @Override
            public int compare(Tarea t1, Tarea t2) {
                Integer prioridad1 = MAPA_IMPACTO.getOrDefault(t1.getTipo(), 0);
                Integer prioridad2 = MAPA_IMPACTO.getOrDefault(t2.getTipo(), 0);
                
                // Orden descendente por valor (3, 2, 1) -> (Bug, Feature, Documentacion)
                return prioridad2.compareTo(prioridad1);
            }
        });
        
        return tareasPriorizadas;
    }
}
