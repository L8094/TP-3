package Model.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.google.gson.Gson;
import Model.Oferta;
import Model.OfertaManager;
import org.junit.jupiter.api.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class OfertaManagerTest {
    private static final String TEST_JSON_PATH = "OfertasTest.json";
    private Oferta oferta;
    private OfertaManager ofertaManager;

    @BeforeEach
    void setUp() {
        ofertaManager = new OfertaManager(TEST_JSON_PATH); 
        oferta = new Oferta(1, 10, 100.0, "usuarioTest");
    }

    @AfterEach
    void tearDown() {
        
        File file = new File(TEST_JSON_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testAgregarOfertaEnMemoria() {
        ofertaManager.agregarOfertaEnMemoria(oferta);
        assertTrue(ofertaManager.hayOfertasEnMemoria());
    }

    @Test
    void testBorrarOfertasDeMemoria() {
        ofertaManager.agregarOfertaEnMemoria(oferta);
        ofertaManager.borrarOfertasDeMemoria();
        assertFalse(ofertaManager.hayOfertasEnMemoria());
    }

    //------------------------------------------------

    @Test
    void testGuardarOfertasEnJson() {
        ofertaManager.agregarOfertaEnMemoria(oferta);
        ofertaManager.guardarOfertasEnJson(); 
        assertFalse(ofertaManager.hayOfertasEnMemoria());
    }

    @Test
    void testCargarOfertasDesdeJSON() throws IOException {
        crearArchivoDePrueba();
        List<Oferta> ofertas = ofertaManager.cargarOfertasDesdeJSON(oferta.getFecha());
        assertEquals(1, ofertas.size(), "Debería haber una oferta en la fecha seleccionada");
        assertEquals("usuarioTest", ofertas.get(0).getUsuario(), "El usuario debería coincidir");
    }

    @Test
    void testCargarOfertasDesdeJSONArchivoNoExistente() {
        Exception exception = assertThrows(RuntimeException.class, () -> ofertaManager.cargarOfertasDesdeJSON("2023-11-30"));
        assertTrue(exception.getMessage().contains("El archivo JSON no existe"));
    }

    private void crearArchivoDePrueba() throws IOException {
        ofertaManager.agregarOfertaEnMemoria(oferta);
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(TEST_JSON_PATH)) {
            gson.toJson(List.of(oferta), writer);
        }
    }
    
    @Test
    void testGuardarOfertasEnJson2() {
        ofertaManager.agregarOfertaEnMemoria(oferta);
        ofertaManager.guardarOfertasEnJson(); 
        File file = new File(TEST_JSON_PATH);
        assertTrue(file.exists(), "El archivo JSON de prueba debería existir.");
    }
}
