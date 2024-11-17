	package Model;
	
	import com.google.gson.Gson;
	import com.google.gson.reflect.TypeToken;
	import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;
	
	public class OfertaManager {
	    private static JsonPersistencia jsonpersistencia;
	    private static ArrayList<Oferta> ofertasEnMemoria;
	    private static String ruta;
	
	    public OfertaManager(String ruta) {
	    	OfertaManager.ruta= ruta;
	        OfertaManager.jsonpersistencia = new JsonPersistencia(ruta);  
	        OfertaManager.ofertasEnMemoria = new ArrayList<>();
	    }
				
	    public static void guardarOfertasEnJson() {
	        jsonpersistencia.guardarOfertasEnJson(ofertasEnMemoria);
	        ofertasEnMemoria.clear();
	    }
	    
	    public static void agregarOfertaEnMemoria(Oferta oferta) {
	        ofertasEnMemoria.add(oferta);
//	        System.out.println(oferta.toString() + "OFERTA AGREGADA EN MEMORIA");
	    }
	    
	
		public static List<Oferta> cargarOfertasDesdeJSON(String fechaSeleccionada) {
			 List<Oferta> ofertasFiltradas = new ArrayList<>();
			 
			 File file = new File(ruta);
			    if (!file.exists()) {
			        throw new RuntimeException("El archivo JSON no existe en la ruta especificada: " + ruta);
			    }
		        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
		            Gson gson = new Gson();
		            List<Oferta> ofertas = gson.fromJson(reader, new TypeToken<List<Oferta>>() {}.getType());
		            for (Oferta oferta : ofertas) {
		                if (oferta.getFecha().equals(fechaSeleccionada)) {
		                    ofertasFiltradas.add(oferta);
		                }
		            }
		        } catch (IOException e) {
//		        	System.out.println("No hay ningun Json creado");
		            e.printStackTrace();
		        }
		        return ofertasFiltradas;
		    }
		
		public static void borrarOfertasDeMemoria() {
			ofertasEnMemoria.clear();
//            System.out.println("se borro todo");
        }
		
		public static boolean hayOfertasEnMemoria() {
			return !ofertasEnMemoria.isEmpty();
		}
	}
	
