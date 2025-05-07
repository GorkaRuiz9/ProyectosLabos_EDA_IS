package PRACTICA1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnorderedDoubleLinkedListActoresTest {

	
	UnorderedDoubleLinkedListActores lista;
	Actor a1;
	Actor a2;
	Actor a3;
	Actor a4;
	
	
	@Before
	public void setUp() throws Exception 
	{
		a1= new Actor("Manolo Lama");
		a2= new Actor("Paco Gonzalez");
		a3= new Actor("Luis Rubiales");
		a4=new Actor("Sergio Ramos");
		
		lista= new UnorderedDoubleLinkedListActores();
		
		lista.addToRear(a1);
		lista.addToRear(a2);
		lista.addToRear(a3);
	}

	@After
	public void tearDown() throws Exception 
	{
		lista= new UnorderedDoubleLinkedListActores();
	}

	@Test
	public void testBuscarActor() 
	{
		Actor unActor=lista.buscarActor(a2);
		assertEquals(unActor,a2);
		
		Actor dosActor=lista.buscarActor(a4);
		assertNull(dosActor);
	}

	@Test
	public void testAddToRear() 
	{
		assertNull(lista.buscarActor(a4));
		
		lista.addToRear(a4);
		assertNotNull(lista.buscarActor(a4));
	}

	@Test
	public void testEstaYannadir() 
	{
		boolean esta;
		Pelicula peli= new Pelicula("La vida es bella", 2000);
		
		//Como está, devuelve true y no añade nada a la lista, pero si la pelicula
		assertFalse(a1.getPelis().estaYannadir(a1, peli));
		esta=lista.estaYannadir(a1, peli);
		assertTrue(esta);
		assertTrue(a1.getPelis().estaYannadir(a1, peli));
		
	
		
		esta=lista.estaYannadir(a4, null);
		//No está, devuelve false y listo
		assertFalse(esta);
	}

	@Test
	public void testBorrarActor() 
	{
		Pelicula peli=new Pelicula("Dios", 2000);
		a2.annadirPeli(peli);
		peli.annadirActor(a2);
		
		
		Actor unActor= lista.buscarActor(a2);
		assertNotNull(unActor);
		assertTrue(peli.getActores().estaYannadir(a2, null));
		
		lista.borrarActor(a2);
		
		
		//Con esto comprobamos que el actor a sido eliminado de la lista de actores
		Actor dosActor= lista.buscarActor(a2);
		assertNull(dosActor);
		
		//Pero debemos comprobar que tambien ha sido borrado de las peliculas en las que estaba
		assertFalse(peli.getActores().estaYannadir(a2, null));
	}

	@Test
	public void testListaOrdenada() 
	{
		lista.addToRear(a4);
		
		lista.escribirArchivo("C:\\Users\\Gorka\\Desktop\\Escribir archivos\\sinOrdenar.txt");
		
		UnorderedDoubleLinkedListActores listaOrdenada=lista.listaOrdenada();
		
		listaOrdenada.escribirArchivo("C:\\Users\\Gorka\\Desktop\\Escribir archivos\\ordenada.txt");
	}

	@Test
	public void testEscribirArchivo() 
	{
		lista.escribirArchivo("C:\\Users\\Gorka\\Desktop\\Escribir archivos\\prueba.txt");
	}

}
