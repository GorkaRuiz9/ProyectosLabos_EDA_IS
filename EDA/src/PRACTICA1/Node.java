package PRACTICA1;

	public class Node<T> {
		public T data; 			// dato del nodo
		public Node<T> prev; 	// puntero al anterior nodo de la lista
		public Node<T> next; 	// puntero al siguiente nodo de la lista
		// -------------------------------------------------------------

		public Node(T elem) 		// constructor
		{
			data = elem;
			next = null;
			prev = null;
		}







	public T getData() {
			return data;
		}







		public void setData(T elem) {
			this.data = elem;
		}







	public int compareTo (Node<Actor> elem1,Node<Actor> elem)
	{
		return elem1.data.getNombre().compareToIgnoreCase(elem.data.getNombre());
	}
	
	
	}