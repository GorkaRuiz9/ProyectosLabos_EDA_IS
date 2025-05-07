package segundaFase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderedDoubleLinkedListTest {

	OrderedDoubleLinkedList<String> lista= new OrderedDoubleLinkedList<String>();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() 
	{
		lista.add("Celia");
		lista.add("Andrea");
		lista.add("Julia");
		lista.add("Berni");
		lista.add("Abecia");
		lista.add("Zuazo");
		lista.add("Ruiz");
		
		lista.visualizarNodos();
	}

	@Test
	public void testMerge() 
	{
		OrderedDoubleLinkedList<String> lista2= new OrderedDoubleLinkedList<String>();
		
		lista.add("Celia");
		lista.add("Andrea");
		lista.add("Julia");
		
		lista2.add("Berni");
		lista2.add("Abecia");
		lista2.add("Zuazo");
		lista2.add("Ruiz");
		
		lista.merge(lista2);
		lista.visualizarNodos();
	}



}
