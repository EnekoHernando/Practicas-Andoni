import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import practica1.ListaDeReproduccion;

class ListaReproduccionTest {
	private ListaDeReproduccion lr1;
	private ListaDeReproduccion lr2;
	private final File FIC_TEST1 = new File("src/test/res/No del grupo.mp4");
	@Before
	public void setUp() throws Exception{
		lr1 = new ListaDeReproduccion();
		lr2 = new ListaDeReproduccion();
		lr2.add(FIC_TEST1);
	}
	@After
	public void tearDown() {
		lr2.clear();
	}
		 // Chequeo de error por getFic(índice) por encima de final
		 @Test//(expected = IndexOutOfBoundsException.class)
		 public void testGet_Exc1() {
			 Assertions.assertThrows(IndexOutOfBoundsException.class, new Executable() {
				
				@Override
				public void execute() throws Throwable {
					 lr1.getFic(0); // Debe dar error porque aún no existe la posición 0	
				}
			});
		 }

		 // Chequeo de error por get(índice) por debajo de 0
		 @Test//(expected = IndexOutOfBoundsException.class)
		 public void testGet_Exc2() {
			 Assertions.assertThrows(IndexOutOfBoundsException.class, new Executable() {
					
					@Override
					public void execute() throws Throwable {
						 lr1.getFic(0); // Debe dar error porque aún no existe la posición -1	
					}
				});
		 }

		 // Chequeo de funcionamiento correcto de get(índice)
		 @Test public void testGet() {
		 assertEquals( FIC_TEST1, lr2.getFic(0) ); // El único dato es el fic-test1
		 } 

}
