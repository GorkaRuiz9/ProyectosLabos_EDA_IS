package PRACTICA3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Graph {
	
    HashMap<String, Integer> th;
    String[] keys;
    ArrayList<Integer>[] adjList;
	
	public void crearGrafo(ListaPeliculas lista){
		// Post: crea el grafo desde la lista de peliculas
		//       Los nodos son nombres de actores/actrices		
		
          // Paso 1: llenar “th”

		 th = new HashMap<>();
	        int id = 0;

	        
	        for(Pelicula peli:lista.getLista())
	        {
	        	for(Actor unActor:peli.getActores().getLista())
	        	{
	        		if (!th.containsKey(unActor.getNombre())) 
	        		{
	                    th.put(unActor.getNombre(), id++);
	        		}
	        	}
	        }
	        
		
		
          // Paso 2: llenar “keys”
		keys = new String[th.size()];
		for (String k: th.keySet()) keys[th.get(k)] = k;

          // Paso 3: llenar “adjList”
        
		adjList = new ArrayList[keys.length];
        for (int i = 0; i < keys.length; i++) {
            adjList[i] = new ArrayList<Integer>();
        }


        for (Pelicula peli:lista.getLista()) {
            ArrayList<Actor> actores = peli.getActores().getLista();
            for (int i = 0; i < actores.size(); i++) {
                for (int j = i + 1; j < actores.size(); j++) {
                    int actor1 = th.get(actores.get(i).getNombre());
                    int actor2 = th.get(actores.get(j).getNombre());
                    adjList[actor1].add(actor2);
                    adjList[actor2].add(actor1); // Porque el grafo es no dirigido
                }
            }
        }
	}
	
	public void print(){
	   for (int i = 0; i < adjList.length; i++){
		System.out.print("Element: " + i + " " + keys[i] + " --> ");
		for (int k: adjList[i])  System.out.print(keys[k] + " ### ");
		
		System.out.println();
	   }
	}
	
	public boolean estanConectados(String a1, String a2){
		Queue<Integer> porExaminar = new LinkedList<Integer>();
		
		int pos1 = th.get(a1);
		int pos2 = th.get(a2);
		boolean enc = false;
		boolean[] examinados = new boolean[th.size()];

		porExaminar.add(pos1);
        examinados[pos1] = true;

        while (!porExaminar.isEmpty()) {
            int actual = porExaminar.poll();

            if (actual == pos2) {
                enc = true;
                break;
            }

            for (int elemento : adjList[actual]) {
                if (!examinados[elemento]) {
                    porExaminar.add(elemento);
                    examinados[elemento] = true;
                }
            }
        }

        return enc;


	}
	
	
	 public ArrayList<String> estanConectadosYDevuelveCamino(String a1, String a2) 
	 {
	        Queue<Integer> porExaminar = new LinkedList<>();
	        int pos1 = th.get(a1);
	        int pos2 = th.get(a2);
	        boolean encontrado = false;
	        boolean[] examinados = new boolean[th.size()];
	        int[] padre = new int[th.size()];

	        porExaminar.add(pos1);
	        examinados[pos1] = true;
	        padre[pos1] = -1; // Usamos -1 para indicar que el primer nodo no tiene un nodo padre

	        while (!porExaminar.isEmpty() && !encontrado) {
	            int actual = porExaminar.poll();

	            for (int elemento : adjList[actual]) {
	                if (!examinados[elemento]) {
	                    porExaminar.add(elemento);
	                    examinados[elemento] = true;
	                    padre[elemento] = actual;

	                    if (elemento == pos2) {
	                        encontrado = true;
	                        break;
	                    }
	                }
	            }
	        }

	        // Construir la lista de relaciones
	        ArrayList<String> relaciones = new ArrayList<>();
	        if (encontrado) {
	            int actual = pos2;
	            while (actual != -1) {
	                relaciones.add(keys[actual]);
	                actual = padre[actual];
	            }
	            Collections.reverse(relaciones); // Invertir la lista para que sea de a1 a a2
	        }

	        return relaciones;
	    }
	 
	 
	 
	 
	 public HashMap<String, Double> pageRank() {
		    double dampingFactor = 0.85; // Valor usual
		    double epsilon = 0.0001; // Uso de umbral para la convergencia

		    HashMap<String, Double> pageRanks = new HashMap<>();
		    HashMap<String, Double> newPageRanks = new HashMap<>();

		    // Inicializar PageRanks
		    for (String key : th.keySet()) {
		        pageRanks.put(key, 1.0 / th.size());
		    }

		    // Calcular PageRanks
		    boolean haConvergido = false;

		    while (!haConvergido) {
		        for (String key : th.keySet()) {
		            double newPageRank = (1 - dampingFactor) / th.size();

		            for (int vecino: adjList[th.get(key)]) {
		                newPageRank += dampingFactor * pageRanks.get(keys[vecino]) / adjList[vecino].size();
		            }

		            newPageRanks.put(key, newPageRank);
		        }

		        // Verificar convergencia
		        haConvergido = true;
		        for (String key : th.keySet()) {
		            if (Math.abs(newPageRanks.get(key) - pageRanks.get(key)) > epsilon) {
		                haConvergido = false;
		                break;
		            }
		        }

		        // Actualizar PageRanks para la próxima iteración
		        for (String key : th.keySet()) {
		            pageRanks.put(key, newPageRanks.get(key));
		        }


		    }

		    return pageRanks;
		}
	 
	 
	 public ArrayList<Dupla> buscarActores(ArrayList<String> actores) {
		    HashMap<String, Double> pageRanks = pageRank();

		    // Crear lista de Pares
		    ArrayList<Dupla> resultado = new ArrayList<>();
		    for (String actor : actores) {
		        Dupla unaDupla = new Dupla();
		        unaDupla.actor = actor;
		        unaDupla.pageRank = pageRanks.getOrDefault(actor, 0.0);
		        resultado.add(unaDupla);
		    }

		    // Ordenar la lista de Pares por PageRank de mayor a menor
		    resultado.sort((a, b) -> Double.compare(b.pageRank, a.pageRank));

		    return resultado;
		}

	}
