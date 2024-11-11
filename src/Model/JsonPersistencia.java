package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonPersistencia {

    private static final String ruta = "Ofertas.json";

    public void guardarOfertasEnJson(List<Oferta> ofertas) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonArray jsonOfertas = new JsonArray();
        
        try (FileReader reader = new FileReader(ruta)) {
            JsonReader jsonReader = new JsonReader(reader);
            JsonElement elemento = gson.fromJson(jsonReader, JsonElement.class);
            if (elemento != null && elemento.isJsonArray()) {
                jsonOfertas = elemento.getAsJsonArray();
            }
        } catch (IOException e) {
            System.out.println("Archivo nuevo creado: Ofertas.json");
        }

        for (Oferta oferta : ofertas) {
            JsonObject jsonOferta = new JsonObject();
            jsonOferta.addProperty("Nombre y Apellido", oferta.getUsuario());;
            jsonOferta.addProperty("inicio", oferta.getInicio());
            jsonOferta.addProperty("fin", oferta.getFin());
            jsonOferta.addProperty("monto", oferta.getMonto());
            jsonOferta.addProperty("fecha", oferta.getFecha()); 

            jsonOfertas.add(jsonOferta);
        }
        try (FileWriter archivo = new FileWriter(ruta)) {
            gson.toJson(jsonOfertas, archivo);
            System.out.println("Ofertas guardadas en " + ruta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static List<Oferta> listaDeOfertasEnJson(String archivo) {
        List<Oferta> ofertas = null;
        try (FileReader reader = new FileReader(archivo)) {
            Gson gson = new Gson();
            ofertas = gson.fromJson(reader, new TypeToken<List<Oferta>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ofertas;
    }
}
