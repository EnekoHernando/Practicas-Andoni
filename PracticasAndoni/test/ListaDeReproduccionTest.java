import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ud.prog3.pr01.ListaDeReproduccion;

public class ListaDeReproduccionTest {
	private ListaDeReproduccion lr1;
	private ListaDeReproduccion lr2;
	private final File FIC_TEST1 = new File( "test/res/No del grupo.mp4" );
	private final File FIC_TEST2 = new File("test/res/Fichero Pentatonix no video.txt");
	@Before
	public void setUp() throws Exception {
		lr1 = new ListaDeReproduccion();
		lr2 = new ListaDeReproduccion();
		lr2.add( FIC_TEST1 );
		lr2.add( FIC_TEST2 );
	}
	@After
	public void tearDown() {
		lr2.clear();
	}
	// Chequeo de error por getFic(índice) por encima de final
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGet_Exc1() {
	lr1.getFic(0); // Debe dar error porque aún no existe la posición 0
	}
	// Chequeo de error por get(índice) por debajo de 0
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGet_Exc2() {
	lr2.getFic(-1); // Debe dar error porque aún no existe la posición -1
	}
	// Chequeo de funcionamiento correcto de get(índice)
	@Test public void testGet() {
	assertEquals( FIC_TEST1, lr2.getFic(0) ); // El único dato es el fic-test1
	}
	@Test (expected = IndexOutOfBoundsException.class)
	public void addTest() {
		lr1.add(FIC_TEST1);
		assertEquals(FIC_TEST1, lr1.getFic(0));
		lr1.removeFic(0);
		lr1.getFic(0);
	}
	@Test public void intercambioTest() {
		lr2.intercambia(0, 1);
		assertEquals(FIC_TEST2, lr2.getFic(0));
		assertEquals(FIC_TEST1, lr2.getFic(1));
	}
	@Test 
	public void addCarpeta() {
		String carpetaTest = "test/res/";
		String filtroTest = "*Pentatonix*.mp4";
		ListaDeReproduccion lr = new ListaDeReproduccion();
		lr.add( carpetaTest, filtroTest );
		assertEquals(3, lr.size());
		}
}
