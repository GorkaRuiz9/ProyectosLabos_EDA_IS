package PRACTICA3;

import java.util.HashMap;

public class Prueba {
    public static void main(String[] args) {
        final int TOPE = 10000;

        for (int numPruebas = 0; numPruebas < TOPE; numPruebas++) {
            
        	Escaner ec= new Escaner();
    		ListaPeliculas listaPe=ec.getListaPe("C:\\Users\\Gorka\\Desktop\\ws\\EDA\\src\\PRACTICA3\\movies-dir\\actors_and_films_2017.txt");
        	
            Graph grafo = new Graph();
            grafo.crearGrafo(listaPe); // Reemplaza listaPeliculas con tus datos

            // Inicializar y comenzar el temporizador
            Stopwatch timer = new Stopwatch();

            // Llamar al subprograma que quieres medir (en este caso, el cálculo de PageRank)
            HashMap<String, Double> pageRanks = grafo.pageRank();

            // Detener el temporizador y mostrar el tiempo transcurrido
            System.out.println("Prueba " + numPruebas + ". Tiempo(segundos): " + timer.elapsedTime());
        }
    }
}

