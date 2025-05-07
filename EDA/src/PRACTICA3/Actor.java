package PRACTICA3;

public class Actor {

	private String nombre;
	private ListaPeliculas Pelis;
	
	public Actor(String pNombre)
	{
		this.nombre=pNombre;
		this.Pelis= new ListaPeliculas();
	}

	public String getNombre() {
		return nombre;
	}

	public ListaPeliculas getPelis() {
		return Pelis;
	}
	
	public void annadirPeli(Pelicula pPeli)
	{
		this.Pelis.insertarPelicula(pPeli);
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
