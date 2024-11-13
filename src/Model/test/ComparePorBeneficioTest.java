package Model.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.ComparePorBeneficio;
import Model.Oferta;


class ComparePorBeneficioTest {
	    private ComparePorBeneficio comparator;
	    private Oferta ofertaA;
	    private Oferta ofertaB;

	    @BeforeEach
	    void setUp() {
	        comparator = new ComparePorBeneficio();
	        ofertaA = new Oferta(1, 10, 100.0, "usuarioA");
	        ofertaB = new Oferta(2, 20, 200.0, "usuarioB");
	    }
	    @Test
	    void TestCompareMayorMontoPrimer() {
	    	assertEquals(1, comparator.compare(ofertaA, ofertaB));
	    }
	  
	    @Test
	    void TestCompareMenorMontoPrimer() {
	    	ofertaA = new Oferta(1, 10, 100.0, "usuarioA");
	        ofertaB = new Oferta(2, 20, 200.0, "usuarioB");
	    	assertEquals(-1, comparator.compare(ofertaA, ofertaB));
	    }
	    
	    
	    @Test
	    void testCompare_IgualMonto() {
	        // Si ambos montos son iguales, esperamos 0
	        ofertaA = new Oferta(2, 20, 150.0, "usuarioA");
	        ofertaB = new Oferta(1, 10, 150.0, "usuarioB");
	        assertEquals(0, comparator.compare(ofertaA, ofertaB));
	    }
	   
	    @Test
	    void TestCompareMayorMontoPrimero() {
	    	assertFalse(ofertaA.getMonto() > ofertaB.getMonto());
	    }
	    
	   
	    @Test
	    void TestCompareMenorMontoPrimero() {
	    	assertTrue(ofertaA.getMonto() < ofertaB.getMonto());
	    }
	    
	}



