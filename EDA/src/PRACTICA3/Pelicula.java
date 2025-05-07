package PRACTICA3;


public class Pelicula {

	private String nombre;
	private int annoEstreno;
	private ListaActores Actores;
	
	public Pelicula(String pNombre, int pAnno)
	{
		this.nombre=pNombre;
		this.annoEstreno=pAnno;
		this.Actores= new ListaActores();
	}

	public ListaActores getActores() {
		return Actores;
	}
	
	public void modificarAnno(int pAnno)
	{
		this.annoEstreno=pAnno;
	}
	
	public void annadirActor(Actor pActor)
	{
		this.Actores.insertarActor(pActor);
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
