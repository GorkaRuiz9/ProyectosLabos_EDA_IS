package segundaFase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DoubleLinkedListTest {

	UnorderedDoubleLinkedList<String> lista= new UnorderedDoubleLinkedList();
	
	@Before
	public void setUp() throws Exception 
	{
		
		
		lista.addToRear("Andrea");
		lista.addToRear("Lara");
		lista.addToRear("Marta");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRemoveFirst() 
	{
		lista.removeFirst();
		lista.visualizarNodos();
		
		lista.removeFirst();
		lista.visualizarNodos();
		
		lista.removeFirst();
		lista.visualizarNodos();
	}

	@Test
	public void testRemoveLast() 
	{
		lista.removeLast();
		lista.visualizarNodos();
		
		lista.removeLast();
		lista.visualizarNodos();
		
		lista.removeLast();
		lista.visualizarNodos();
	}

	@Test
	public void testRemove() 
	{
		//Borrar en medio
		lista.remove("Lara");
		lista.visualizarNodos();
		
		//Borrar al final
		lista.addToRear("Celia");
		lista.remove("Celia");
		lista.visualizarNodos();
		
		//Borrar al principio
		lista.addToFront("Julia");
		lista.remove("Julia");
		lista.visualizarNodos();
	}


	@Test
	public void testContains() 
	{
		assertTrue(lista.contains("Andrea"));
		assertFalse(lista.contains("Davo"));
	}

	@Test
	public void testFind() 
	{
		String elem;
		elem=lista.find("Andrea");
		assertEquals("Andrea",elem);
		
		elem=lista.find("Manolo");
		assertNull(elem);
	}



}
