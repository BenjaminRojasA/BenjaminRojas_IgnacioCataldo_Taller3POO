package Estrategia;

import java.util.ArrayList;

import Taller3.Tarea;

public interface Strategy {
	ArrayList<Tarea> ordenarTareas(ArrayList<Tarea> tareas);
}
