package segundaFase;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem)
	{
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> actual=first;
		Node<T> aInsertar=new Node(elem);
		boolean annadido=false;
		
		while (!annadido)
		{
		
			if(first==null)
			{
				first=aInsertar;
				annadido=true;
			}

			else if(first.next==null && actual.compareTo(elem)>0)
			{
				aInsertar.next=first;
				first.prev=aInsertar;
				aInsertar.prev=first;
				first.next=aInsertar;
			
				first=aInsertar;
				annadido=true;
			}
			else if(first.next==null && actual.compareTo(elem)<0)
			{
				first.next=aInsertar;
				first.prev=aInsertar;
				aInsertar.prev=first;
				aInsertar.next=first;
				annadido=true;
			}
			else if(first.compareTo(elem)>0)
			{
				aInsertar.next=first;
				aInsertar.prev=first.prev;
				first.prev.next=aInsertar;
				first.prev=aInsertar;
				first=aInsertar;
				annadido=true;
			}
			else if (actual.next==first && actual.compareTo(elem)<0)
			{
				actual.next=aInsertar;
				aInsertar.prev=actual;
				aInsertar.next=first;
				first.prev=aInsertar;
				annadido=true;
			}
			else if (actual.compareTo(elem)<0 && actual.next.compareTo(elem)>0)
			{
				actual.next.prev=aInsertar;
				aInsertar.next=actual.next;
				aInsertar.prev=actual;
				actual.next=aInsertar;
				annadido=true;
			}
			else
			{
				actual=actual.next;
			}
		}
	}
		
	public void merge(DoubleLinkedList<T> lista) {
	    Node<T> guia=first;
	    Node<T> act2 = lista.first;
	    
	  

	    boolean primeraVez2 = true;

	    while (act2 != lista.first || primeraVez2) 
	    {
	        primeraVez2 = false;
	        guia=addMerge(act2.data,guia);
	        act2 = act2.next;
	    }

	}

	public Node<T> addMerge(T elem, Node<T> guia) {
	    Node<T> actual = guia;
	    
	    Node<T> aInsertar = new Node(elem);
	    boolean annadido = false;

	    while (!annadido)
		{
		
			if(first==null)
			{
				first=aInsertar;
				annadido=true;
			}

			else if(first.next==null && actual.compareTo(elem)>0)
			{
				aInsertar.next=first;
				first.prev=aInsertar;
				aInsertar.prev=first;
				first.next=aInsertar;
			
				first=aInsertar;
				annadido=true;
			}
			else if(first.next==null && actual.compareTo(elem)<0)
			{
				first.next=aInsertar;
				first.prev=aInsertar;
				aInsertar.prev=first;
				aInsertar.next=first;
				annadido=true;
			}
			else if(first.compareTo(elem)>0)
			{
				aInsertar.next=first;
				aInsertar.prev=first.prev;
				first.prev.next=aInsertar;
				first.prev=aInsertar;
				first=aInsertar;
				annadido=true;
			}
			else if (actual.next==first && actual.compareTo(elem)<0)
			{
				actual.next=aInsertar;
				aInsertar.prev=actual;
				aInsertar.next=first;
				first.prev=aInsertar;
				annadido=true;
			}
			else if (actual.compareTo(elem)<0 && actual.next.compareTo(elem)>0)
			{
				actual.next.prev=aInsertar;
				aInsertar.next=actual.next;
				aInsertar.prev=actual;
				actual.next=aInsertar;
				annadido=true;
			}
			else
			{
				actual=actual.next;
			}
		}
	    
	    Node<T>	ahora=aInsertar;
	    return ahora;
	    
	}
	




}
