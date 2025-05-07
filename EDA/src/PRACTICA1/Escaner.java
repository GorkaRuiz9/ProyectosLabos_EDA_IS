package PRACTICA1;

import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Escaner {

	private UnorderedDoubleLinkedListActores listaAc;
	private UnorderedDoubleLinkedListPelis listaPe;
	
	
	
	
	public Escaner() {
		// TODO Auto-generated constructor stub
	}

	private void cargarLista(String nomF)
	{
		
		UnorderedDoubleLinkedListActores listaAc= new UnorderedDoubleLinkedListActores();
		UnorderedDoubleLinkedListPelis listaPe= new UnorderedDoubleLinkedListPelis();
		
		try{
		 Scanner entrada = new Scanner(new FileReader(nomF));
		 String linea;
		 int anno=0;
		 int contador = 1;
		 int longitud = nomF.length();
	        
	        
	        for (int i = longitud - 1; i >= 0; i--) 
	        {
	            char caracter = nomF.charAt(i);
	            String character = String.valueOf(caracter);
	            int valorNumerico = (int) caracter;
	            if (valorNumerico >= 48 && valorNumerico <= 57 && contador<=1000) {
	            	anno=anno+Integer.parseInt(character)*contador;
	            	contador=contador*10;
	            	}
	            }
	            
	            
	            
		 
		 
		 while (entrada.hasNext()) 
		 {
			 linea = entrada.nextLine();
			
			 String[] partes=linea.split("###");
			 
			 Actor unActor= new Actor(partes[1]);
			 
			 Pelicula unaPelicula= new Pelicula(partes[3], anno);
			 
			 if (!listaAc.estaYannadir(unActor, unaPelicula))
			 {
			 unActor.annadirPeli(unaPelicula);
			 listaAc.addToRear(unActor);
			 }
			 
			 if(!listaPe.estaYannadir(unActor, unaPelicula))
			 {
			 unaPelicula.annadirActor(unActor);		 
			 listaPe.addToRear(unaPelicula);
			 }
		 
		 }
		 entrada.close();
		 this.listaAc=listaAc;
		 this.listaPe=listaPe;
		 }
		 catch(IOException e) {e.printStackTrace();}
		
		
	    }

	public UnorderedDoubleLinkedListActores getListaAc(String nomF) 
	{
		if (this.listaAc==null)
		{
			this.cargarLista(nomF);
		}
		return listaAc;
	}


	public UnorderedDoubleLinkedListPelis getListaPe(String nomF) 
	{	
		if (this.listaPe==null)
		{
			this.cargarLista(nomF);
		}
		return listaPe;
	}

	


	}
	

