package PRACTICA1;


public class Pelicula {

	private String nombre;
	private int annoEstreno;
	private UnorderedDoubleLinkedListActores Actores;
	
	public Pelicula(String pNombre, int pAnno)
	{
		this.nombre=pNombre;
		this.annoEstreno=pAnno;
		this.Actores= new UnorderedDoubleLinkedListActores();
	}

	public UnorderedDoubleLinkedListActores getActores() {
		return Actores;
	}
	
	public void modificarAnno(int pAnno)
	{
		this.annoEstreno=pAnno;
	}
	
	public void annadirActor(Actor pActor)
	{
		this.Actores.addToRear(pActor);;
	}
	
	public boolean comparaNombre(Pelicula pPelicula)
	{
		if (this.getNombre().equals(pPelicula.getNombre()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public String getNombre() {
		return nombre;
	}

	
	public void borrarActor(Actor pActor)
	{
		this.Actores.borrarActorListaActores(pActor);;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
