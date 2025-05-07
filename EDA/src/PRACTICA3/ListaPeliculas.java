package PRACTICA3;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaPeliculas {

	private ArrayList<Pelicula> lista;
	
	public ListaPeliculas()
	{
		this.lista= new ArrayList<Pelicula>();
	}
	
	public ArrayList<Pelicula> getLista()
	{
		return this.lista;
	}
		
	public void insertarPelicula(Pelicula pPeli)
	{
		this.lista.add(pPeli);
	}
	
	public Iterator<Pelicula> getIterador()
	{
		return this.lista.iterator();
	}
	
	public boolean estaYannadir(Actor pActor, Pelicula pPelicula)
	{
		Iterator<Pelicula> itr=this.getIterador();
		Pelicula unaPelicula;
		boolean esta=false;
		
		while (itr.hasNext()&&!esta)
		{
			unaPelicula=itr.next();
			
			if (unaPelicula.comparaNombre(pPelicula))
			{
				esta=true;
				unaPelicula.annadirActor(pActor);;
			}
		}
		return esta;
	}

	
	public void borrarActor(Actor pActor)
	{
			Iterator<Pelicula> itr=this.getIterador();
			Pelicula unaPelicula;
		
			while (itr.hasNext())
			{
				unaPelicula=itr.next();
				if (unaPelicula!=null)
				{
					unaPelicula.borrarActor(pActor);
				}
			
			}
		}

	
	public void escribirArchivo(String pNombreArchivo)
	{
		File archivo= new File (pNombreArchivo);
		Iterator<Pelicula> itr=this.getIterador();
		Pelicula unaPelicula;
		
		try {
			PrintWriter salida= new PrintWriter (new FileWriter (archivo));
			
			while (itr.hasNext())
			{
				unaPelicula=itr.next();
				salida.print("\n"+unaPelicula.getNombre());
				

			}
			salida.close();
			System.out.print("Se ha creado el archivo");
		}
		catch (IOException ex)
		{
			ex.printStackTrace(System.out);
		}
	}
	
	
	//Metodo solo utilizado para pruebas
	public Pelicula obtenerUnaPeli()
	{
		Iterator<Pelicula> itr=this.getIterador();
		Pelicula unaPeli=null;
		int contador=2;
		boolean para=false;
		
		while(itr.hasNext()&&!para)
		{
			unaPeli=itr.next();
			if (contador==206)
			{
				para=true;
			}
			else
			{
				contador++;
			}
		}
		System.out.print(unaPeli.getNombre());
		return unaPeli;
	}
	
	
	
	
	
}
