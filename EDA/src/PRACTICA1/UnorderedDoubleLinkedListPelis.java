package PRACTICA1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

public class UnorderedDoubleLinkedListPelis{

	// Atributos
	protected Node<Pelicula> first;  // apuntador al �ltimo
	protected String descr;  // descripci�n
	protected int count;

	// Constructor
	public UnorderedDoubleLinkedListPelis() 
	{
		first = null;
		descr = "";
		count = 0;
	}
			

	public void removeFirst() 
	{
				
		if (isEmpty())
			{}
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
			{}
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


	public void remove(Pelicula elem) 
	{
		Node<Pelicula> actual=first;
			
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

			public boolean isEmpty() 
			//Determina si la lista est� vac�a
			{ return first == null;};


			
	public void addToRear(Pelicula elem) 
	{
	// a�ade un elemento al final 
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<Pelicula> nuevo=new Node<Pelicula>(elem);
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
	
	public void borrarActor (Actor pActor)
	{
		Node<Pelicula> actual=first;
		boolean primeraVez=true;
		
		while((actual!=first || primeraVez)&& actual!=null)
		{
			primeraVez=false;
			actual.data.borrarActor(pActor);;
		}
	}
	
	public boolean estaYannadir (Actor pActor, Pelicula pPelicula)
	{
		Node<Pelicula> actual=first;
		boolean primeraVez=true;
		boolean esta=false;
		

		while((actual!=first || primeraVez)&&!esta && actual!=null)
		{
			primeraVez=false;
			if (actual.data.comparaNombre(pPelicula))
			{
				esta=true;
				pPelicula.annadirActor(pActor);
			}
			else
			{
				actual=actual.next;
			}
		}
		return esta;
	}
	
	
	
	
	
	public Iterator<Pelicula> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<Pelicula> { 

		   private Node<Pelicula> actual=first;
		   boolean primeraVez=true;
		   
		   public boolean hasNext()
		   {
			   
			   boolean devolver=(actual!=first || primeraVez)&&actual!=null;
			   primeraVez=false;
			   return devolver;
		   }
		   
		   public Pelicula next()
		   {
			   Node<Pelicula> next=actual;
			   actual=actual.next;
			   return next.data;
		   }
		   
		   
		   public void remove() {}



	   } 
		
		

	
	
		public void escribirArchivo(String pNombreArchivo)
		{
			File archivo= new File (pNombreArchivo);
			Iterator<Pelicula> itr=this.iterator();
			Pelicula unaPeli;
			
			try {
				PrintWriter salida= new PrintWriter (new FileWriter (archivo));
				
				while (itr.hasNext())
				{
					unaPeli=itr.next();
					salida.print("\n"+unaPeli.getNombre());
					

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
