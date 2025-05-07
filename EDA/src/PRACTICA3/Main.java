package PRACTICA3;

public class Main {

	
	
	public static void main(String[] args)
	{
		Escaner ec= new Escaner();
		ListaPeliculas listaPe=ec.getListaPe("C:\\Users\\Gorka\\Desktop\\ws\\EDA\\src\\PRACTICA3\\movies-dir\\actors_and_films_2017.txt");
		
		Graph grafo=new Graph();
		grafo.crearGrafo(listaPe);
		
		System.out.print(grafo.estanConectadosYDevuelveCamino("Aake Kalliala", "Aaron Douglas")); //Debe responder false
		System.out.print(grafo.estanConectadosYDevuelveCamino("Q69635632", "Q79814150")); //Debe responder true
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
