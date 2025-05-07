package PRACTICA3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

public class ListaActores {

	private ArrayList<Actor> lista;
	
	public ListaActores()
	{
		this.lista= new ArrayList<Actor>();
	}
	
	
	
	public ArrayList<Actor> getLista() {
		return lista;
	}



	private Iterator<Actor> getIterador()
	{
		return this.lista.iterator();
	}
	
	public int buscarActor(Actor pActor) 
	{
		Iterator<Actor> itr=this.getIterador();
		int contador=-1;
		
		while (itr.hasNext())
		{
		Actor unActor=itr.next();
		contador++;
			if (unActor==pActor)
			{
				return contador;
			}
		}
		contador=-1;
		return contador;
	}
	
	public void insertarActor (Actor pActor)
	{
		this.lista.add(pActor);
	}
	
	public void borrarActor (Actor pActor)
	{
		this.borrarActorListaActores(pActor);
		pActor.getPelis().borrarActor(pActor);
	}
	
	public void borrarActorListaActores(Actor pActor)
	{
		int puesto=this.buscarActor(pActor);
		if (puesto!=-1)
		{
		this.lista.remove(puesto);
		}
	}
	
	public boolean estaYannadir(Actor pActor, Pelicula pPelicula)
	{
		Iterator<Actor> itr=this.getIterador();
		Actor unActor;
		boolean esta=false;
		
		while (itr.hasNext()&&!esta)
		{
			unActor=itr.next();
			
			if (unActor.comparaNombre(pActor))
			{
				esta=true;
				unActor.annadirPeli(pPelicula);
			}
		}
		return esta;
	}
	
	public void escribirArchivo(String pNombreArchivo)
	{
		File archivo= new File (pNombreArchivo);
		Iterator<Actor> itr=this.getIterador();
		Actor unActor;
		
		try {
			PrintWriter salida= new PrintWriter (new FileWriter (archivo));
			
			while (itr.hasNext())
			{
				unActor=itr.next();
				salida.print("\n"+unActor.getNombre());
				

			}
			salida.close();
			System.out.print("Se ha creado el archivo");
		}
		catch (IOException ex)
		{
			ex.printStackTrace(System.out);
		}
	}

	
	public ListaActores listaOrdenada()
	{
		ListaActores listaOrdenada=new ListaActores();
		ArrayList<Actor> lista=new ArrayList<Actor>(this.lista); //Hay que indicarle el contenido, ya que si lo hacemos por aignacion va referirse a la referencia
		//cambiando la original tambien
		
		 Collections.sort(lista, new Comparator<Actor>() {
	            
	            public int compare(Actor actor1, Actor actor2) {
	                return actor1.getNombre().compareTo(actor2.getNombre()); //Este metodo devuelve un numero >0 si el segundo string 
	                //viene antes que el primero y <0 si el primero va antes que el segundo. Es un metodo que utiliza el sort
	                //haciendo la ordenacion burbuja
	            }
	        });
        listaOrdenada.setLista(lista);
		 return listaOrdenada;
	}



	public void setLista(ArrayList<Actor> lista) {
		this.lista = lista;
	}
	
	
	
	//Metodo solo utilizado para pruebas
	public Actor obtenerUnActor()
	{
		Iterator<Actor> itr=this.getIterador();
		Actor unActor=null;
		int contador=2;
		boolean para=false;
		
		while(itr.hasNext()&&!para)
		{
			unActor=itr.next();
			if (contador==206)
			{
				para=true;
			}
			else
			{
				contador++;
			}
		}
		System.out.print(unActor.getNombre());
		return unActor;
	}
	
	
	
	
	
	
	
	
	
}
