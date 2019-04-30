import static org.junit.jupiter.api.Assertions.*;
import Modelo.*;
import Controlador.*;

import org.junit.jupiter.api.Test;

class PruebasUnitarias {

	@Test
	void test1() {
		Crud crud = new Crud();
		Carrera carrera = new Carrera();
		carrera.nombre = "pruebaunitaria";
		crud.crear(carrera);
		crud.buscar(carrera);
		assertEquals(crud.crear(carrera),crud.buscar(carrera));
	}
	@Test
	void test2() {
		Crud crud = new Crud();
		assertEquals("string","string");
	}
	@Test
	void test3() {
		Crud crud = new Crud();
		assertEquals("string","string");
	}
	@Test
	void test4() {
		Crud crud = new Crud();
		assertEquals("string","string");
	}
	@Test
	void test5() {
		Crud crud = new Crud();
		assertEquals("string","string");
	}
	@Test
	void test6() {
		Crud crud = new Crud();
		assertEquals("string","string");
	}

}
