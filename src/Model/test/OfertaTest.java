package Model.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Model.Oferta;
import org.junit.jupiter.api.BeforeEach;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

	class OfertaTest {
	    private Oferta oferta;

	    @BeforeEach
	    void setUp() {
	        oferta = new Oferta(1, 10, 100.0, "usuarioTest");
	    }

	    @Test
	    void testGetInicio() {
	        assertEquals(1, oferta.getInicio());
	    }

	    @Test
	    void testGetFin() {
	        assertEquals(10, oferta.getFin());
	    }

	    @Test
	    void testGetMonto() {
	        assertEquals(100.0, oferta.getMonto(), 0.01);
	    }

	    @Test
	    void testGetUsuario() {
	        assertEquals("usuarioTest", oferta.getUsuario());
	    }

	    @Test
	    void testGetFecha() {
	        String fechaEsperada = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	        assertEquals(fechaEsperada, oferta.getFecha());
	    }

	    @Test
	    void testToString() {
	        String expectedString = "Oferta [Usuario= usuarioTest,inicio=1, fin=10, monto=100.0, fecha=" + oferta.getFecha() + "]";
	        assertEquals(expectedString, oferta.toString());
	    }
	}


