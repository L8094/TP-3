package Model.test;

import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.Test;
	import Model.ComparePorCociente;
	import Model.Oferta;
	import org.junit.jupiter.api.BeforeEach;
	

	class ComparePorCocienteTest {
	    private ComparePorCociente comparator;
	    private Oferta ofertaA;
	    private Oferta ofertaB;

	    @BeforeEach
	    void setUp() {
	        comparator = new ComparePorCociente();
	    }

	    @Test
	    void testCompareMayorCocientePrimero() {
	        ofertaA = new Oferta(1, 5, 100.0, "usuarioA");  // Cociente: 100.0 / 4 = 25.0
	        ofertaB = new Oferta(2, 10, 150.0, "usuarioB"); // Cociente: 150.0 / 8 = 18.75
	        assertTrue(comparator.compare(ofertaA, ofertaB) < 0);
	    }

	    @Test
	    void testCompareMenorCocientePrimero() {
	        ofertaA = new Oferta(1, 5, 50.0, "usuarioA");   // Cociente: 50.0 / 4 = 12.5
	        ofertaB = new Oferta(2, 10, 160.0, "usuarioB"); // Cociente: 160.0 / 8 = 20.0
	        assertTrue(comparator.compare(ofertaA, ofertaB) > 0);
	    }

	    @Test
	    void testCompareCocientesIguales() {
	        ofertaA = new Oferta(1, 5, 100.0, "usuarioA");   // Cociente: 100.0 / 4 = 25.0
	        ofertaB = new Oferta(2, 10, 200.0, "usuarioB"); // Cociente: 200.0 / 8 = 25.0
	        assertEquals(0, comparator.compare(ofertaA, ofertaB)); 
	    }
	}


