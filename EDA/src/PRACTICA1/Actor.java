package PRACTICA1;

public class Actor {

	private String nombre;
	private UnorderedDoubleLinkedListPelis Pelis;
	
	public Actor(String pNombre)
	{
		this.nombre=pNombre;
		this.Pelis= new UnorderedDoubleLinkedListPelis();
	}

	public String getNombre() {
		return nombre;
	}

	public UnorderedDoubleLinkedListPelis getPelis() {
		return Pelis;
	}
	
	public void annadirPeli(Pelicula pPeli)
	{
		this.Pelis.addToRear(pPeli);;
	}
	
	public boolean comparaNombre(Actor pActor)
	{
		if (this.getNombre().equals(pActor.getNombre()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
