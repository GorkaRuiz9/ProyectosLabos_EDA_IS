package segundaFase;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> first;  // apuntador al �ltimo
	protected String descr;  // descripci�n
	protected int count;

	// Constructor
	public DoubleLinkedList() {
               first = null;
		descr = "";
		count = 0;
	}
	
	public void setDescr(String nom) {
	  descr = nom;
	}

	public String getDescr() {
	  return descr;
	}

	public T removeFirst() 
	{
		
		if (isEmpty())
		{
			return null;
		}
		else if(first.next==null)
		{
			Node<T> actual=first;
			this.first=null;
			return actual.data;
		}
		else if (first.next.next==first)
		{
			Node<T> actual=first;
			this.first=first.next;
			first.next=null;
			first.prev=null;
			return actual.data;
		}
		else
		{
		Node<T> actual=first;
		first.next.prev=first.prev;
		first.prev.next=first.next;
		first=first.next;
		return actual.data;
		}
	}

	public T removeLast() 
	{
		if (isEmpty())
		{
			return null;
		}
		else if(first.next==null)
		{
			Node<T> ultimo=first.prev;
			this.first=null;
			return ultimo.data;
		}
		else if (first.next==first) //Esto esta hecho de manera que una lista de un elemento su next y prev no apunten a nada
		{
			Node<T> ultimo=first.prev;
			first.next=null;
			first.prev=null;
			first=first.next;
			return ultimo.data;
		}
		else
		{
			Node<T> ultimo=first.prev;
			first.prev=first.prev.prev;
			first.prev.next=first;
			return ultimo.data;
		}
	}


	public T remove(T elem) 
	{
		Node<T> actual=first;
		Node<T> borrado=null;
		boolean primeraVez=true;
		
		boolean eliminado=false;
		
		while ((actual!=first || primeraVez) && !eliminado)
		{
			primeraVez=false;
			if (actual.data.equals(elem))
			{
				if (actual==first && first.next==null)
				{
					borrado=actual;
					first=null;
					eliminado=true;
				}
				else if (actual==first)
				{
					this.removeFirst();
					eliminado=true;
					borrado=actual;
				}
				else if (actual.next==first)
				{
					this.removeLast();
					eliminado=true;
					borrado=actual;
				}
				else
				{
					borrado=actual;
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
		
		return borrado.data;
	}

	public T first() {
	//Da acceso al primer elemento de la lista
	      if (isEmpty())
	          return null;
	      else return first.data;
	}

	public T last() {
	//Da acceso al �ltimo elemento de la lista
	      if (isEmpty())
	          return null;
	      else return first.prev.data;
	}

	public boolean contains(T elem) 
	{
	//Determina si la lista contiene un elemento concreto
		boolean esta=false;

		Iterator<T> it = iterator();
		while (it.hasNext() && !esta) 
			{
					T elemento = it.next();
					if (elemento.equals(elem))
					{
						esta=true;
					}
					
			}
		
		return esta;
		      
	}   

	public T find(T elem) 
	{
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no est�
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> actual=first;
		boolean primeraVez=true;
		
		while(actual!=first || primeraVez)
		{
			primeraVez=false;
			if(actual.data.equals(elem))
			{
				return actual.data;
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
	
	public int size() 
	//Determina el n�mero de elementos de la lista
	{ return count;};
	
	/** Return an iterator to the stack that iterates through the items . */ 
	public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> { 

		   private Node<T> actual=first;
		   boolean primeraVez=true;
		   
		   public boolean hasNext()
		   {
			   
			   boolean devolver=(actual!=first || primeraVez)&&actual!=null;
			   primeraVez=false;
			   return devolver;
		   }
		   
		   public T next()
		   {
			   Node<T> next=actual;
			   actual=actual.next;
			   return next.data;
		   }
		   
		   
		   public void remove() {}



	   } // private class
		
		
         public void visualizarNodos() {
			System.out.println(this.toString());
		}

		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "DoubleLinkedList " + result ;
		}

}
