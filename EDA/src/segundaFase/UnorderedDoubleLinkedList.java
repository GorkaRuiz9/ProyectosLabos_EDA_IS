package segundaFase;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) 
	{
	// a�ade un elemento al comienzo
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> nuevo=new Node(elem);
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
			first=nuevo;
		}
		else
		{
			nuevo.next=first;
			nuevo.prev=first.prev;
			first.prev.next=nuevo;
			first.prev=nuevo;
			first=nuevo;
		}
		
		
	}

	public void addToRear(T elem) 
	{
	// a�ade un elemento al final 
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> nuevo=new Node(elem);
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
	
	public void addAfter(T elem, T target) 
	{
	// A�ade elem detr�s de otro elemento concreto, target,  que ya se encuentra en la lista
		// �COMPLETAR OPCIONAL!
		Node<T> actual=first;
		Node<T> aInsertar=new Node(elem);
		boolean primeraVez=true;
		boolean annadido=false;
		
		while((actual!=first || primeraVez)&& !annadido)
		{
			primeraVez=false;
			if (actual.data.equals(target)&& actual.next==null)
			{
				this.addToRear(elem);
				annadido=true;
			}
			else if (actual.data.equals(target)&& actual.next==first)
			{
				this.addToRear(elem);
				annadido=true;
			}
			else if (actual.data.equals(target))
			{
				actual.next.prev=aInsertar;
				aInsertar.next=actual.next;
				actual.next=aInsertar;
				aInsertar.prev=actual;
				annadido=true;
			}
			else
			{
				actual=actual.next;
			}
		}
	}

}
