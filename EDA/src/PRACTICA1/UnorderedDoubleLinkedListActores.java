package PRACTICA1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

public class UnorderedDoubleLinkedListActores{

	// Atributos
		protected Node<Actor> first;  // apuntador al �ltimo
		protected String descr;  // descripci�n
		protected int count;

		// Constructor
		public UnorderedDoubleLinkedListActores() {
	               first = null;
			descr = "";
			count = 0;
		}
		

		public void removeFirst() 
		{
			
			if (isEmpty())
			{
				
			}
			else if(first.next==null)
			{
				this.first=null;
			
			}
			else if (first.next.next==first)
			{
				this.first=first.next;
				first.next=null;
				first.prev=null;

			}
			else
			{
			first.next.prev=first.prev;
			first.prev.next=first.next;
			first=first.next;

			}
		}

		public void removeLast() 
		{
			if (isEmpty())
			{
				
			}
			else if(first.next==null)
			{
				
				this.first=null;
				
			}
			else if (first.next==first) //Esto esta hecho de manera que una lista de un elemento su next y prev no apunten a nada
			{
			
				first.next=null;
				first.prev=null;
				first=first.next;
				
			}
			else
			{
				
				first.prev=first.prev.prev;
				first.prev.next=first;
				
			}
		}


		public void remove(Actor elem) 
		{
			Node<Actor> actual=first;
		
			boolean primeraVez=true;
			
			boolean eliminado=false;
			
			while ((actual!=first || primeraVez) && !eliminado)
			{
				primeraVez=false;
				if (actual.data.equals(elem))
				{
					if (actual==first && first.next==null)
					{
		
						first=null;
						eliminado=true;
					}
					else if (actual==first)
					{
						this.removeFirst();
						eliminado=true;
		
					}
					else if (actual.next==first)
					{
						this.removeLast();
						eliminado=true;
		
					}
					else
					{
		
						actual.next.prev=actual.prev;
						actual.prev.next=actual.next;
						eliminado=true;
					}
				}
				else
				{
					actual=actual.next;
				}
			}
			

		}

		public Actor buscarActor(Actor pActor)
		{
			Node<Actor> actual=first;
			Node<Actor> aDevolver=null;
			boolean primeraVez=true;
			boolean encontrado=false;
			
			while((actual!=first|| primeraVez)&&!encontrado&&first!=null)
			{
				primeraVez=false;
				if (actual.data.getNombre().equals(pActor.getNombre()))
				{
					encontrado=true;
					aDevolver=actual;
					return aDevolver.data;
				}
				else
				{
					actual=actual.next;
				}
			}
			return null;
		}
		
		
		public boolean isEmpty() 
		//Determina si la lista est� vac�a
		{ return first == null;};


		
		
		public void addToRear(Actor elem) 
		{
		// a�ade un elemento al final 
			// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
			Node<Actor> nuevo=new Node(elem);
			if (first==null)
			{
				first=nuevo;
			}
			else if (first.next==null)
			{
				first.next=nuevo;
				first.prev=nuevo;
				nuevo.next=first;
				nuevo.prev=first;
			}
			else
			{
				first.prev.next=nuevo;
				nuevo.prev=first.prev;
				nuevo.next=first;
				first.prev=nuevo;
			}
		}
	
	
	public boolean estaYannadir (Actor pActor, Pelicula pPelicula)
	{
		Node<Actor> actual=first;
		boolean primeraVez=true;
		boolean esta=false;
		

		while((actual!=first || primeraVez)&&!esta && actual!=null)
		{
			primeraVez=false;
			if (actual.data.comparaNombre(pActor))
			{
				esta=true;
				pActor.annadirPeli(pPelicula);
			}
			else
			{
				actual=actual.next;
			}
		}
		return esta;
	}
	
	public void borrarActor(Actor pActor)
	{
		this.borrarActorListaActores(pActor);
		pActor.getPelis().borrarActor(pActor);
		
	}
	
	public void borrarActorListaActores(Actor pActor)
	{
		this.remove(pActor);
	}
	
	
	
	public UnorderedDoubleLinkedListActores listaOrdenada()
	{
		
		Node<Actor> actual=first;
		boolean primeraVez=true;
		boolean sinCambios=false;
		
		while(!sinCambios)
		{
			sinCambios=true;
			primeraVez=true;
			actual=first;
			while (actual.next!=first || primeraVez)
			{
				primeraVez=false;
				
				if (actual.compareTo(actual,actual.next)>0)
				{
					sinCambios=false;
					
					Actor data1=actual.getData();
					Actor data2=actual.next.getData();
					
					actual.setData(data2);
					actual.next.setData(data1);
				}
				actual=actual.next;
			}
		}
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	

	public Iterator<Actor> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<Actor> { 

		   private Node<Actor> actual=first;
		   boolean primeraVez=true;
		   
		   public boolean hasNext()
		   {
			   
			   boolean devolver=(actual!=first || primeraVez)&&actual!=null;
			   primeraVez=false;
			   return devolver;
		   }
		   
		   public Actor next()
		   {
			   Node<Actor> next=actual;
			   actual=actual.next;
			   return next.data;
		   }
		   
		   
		   public void remove() {}



	   } 
		

	
	
		public void escribirArchivo(String pNombreArchivo)
		{
			File archivo= new File (pNombreArchivo);
			Iterator<Actor> itr=this.iterator();
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
