package segundaFase;

	public class Node<T> {
		public T data; 			// dato del nodo
		public Node<T> prev; 	// puntero al anterior nodo de la lista
		public Node<T> next; 	// puntero al siguiente nodo de la lista
		// -------------------------------------------------------------

		public Node(T dd) 		// constructor
		{
			data = dd;
			next = null;
			prev = null;
		}



	public int compareTo (T elem)
	{
		return this.data.toString().compareToIgnoreCase(elem.toString());
	}
	
	
	}