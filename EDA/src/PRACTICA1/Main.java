package PRACTICA1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main 
{
	private static Main instancia= new Main();



	public static void main(String[] args)
		{
			Escaner unEscaner=new Escaner();
			
			UnorderedDoubleLinkedListActores listaAc=unEscaner.getListaAc("C:\\Users\\Gorka\\Desktop\\ws\\EDA\\src\\PRACTICA1\\movies-dir\\actors_and_films_1983.txt");
			listaAc.escribirArchivo("C:\\Users\\Gorka\\Desktop\\xd\\actores.txt");
			
			UnorderedDoubleLinkedListPelis listaPe=unEscaner.getListaPe("C:\\Users\\Gorka\\Desktop\\ws\\EDA\\src\\PRACTICA1\\movies-dir\\actors_and_films_1983.txt");
			listaPe.escribirArchivo("C:\\Users\\Gorka\\Desktop\\xd\\pelis.txt");
		}
}
