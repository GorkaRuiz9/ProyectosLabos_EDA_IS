package segundaFase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnorderedDoubleLinkedListTest {

	UnorderedDoubleLinkedList<String> lista=new UnorderedDoubleLinkedList<String>();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddToFront() 
	{
		lista.addToFront("Andrea");
		lista.addToFront("Marta");
		lista.addToFront("Lara");
		
		lista.visualizarNodos();
	}

	@Test
	public void testAddToRear() 
	{
		lista.addToRear("Andrea");
		lista.addToRear("Marta");
		lista.addToRear("Lara");
		
		lista.visualizarNodos();
	}

	@Test
	public void testAddAfter() 
	{
		lista.addToRear("Andrea");
		lista.addAfter("Lara", "Andrea");
		lista.addAfter("Celia", "Andrea");
		lista.addAfter("Julia", "Celia");
		
		lista.visualizarNodos();
		
	}

}
