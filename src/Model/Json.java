package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import Presenter.ObservadoresOferta;
import Presenter.SalaControlador;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Json implements ObservadoresOferta {
	private SalaControlador salaControlador;

    public Json(SalaControlador salaController) {
        this.salaControlador = salaController;
        salaControlador.getSala().agregarObservador(this);
    }
			
    public void guardarOfertasEnJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonArray jsonOfertas = new JsonArray();

        // Leer ofertas existentes si el archivo ya existe
        try (FileReader reader = new FileReader("Ofertas.json")) {
            JsonReader jsonReader = new JsonReader(reader);
            JsonElement elemento = gson.fromJson(jsonReader, JsonElement.class);
            if (elemento != null && elemento.isJsonArray()) {
                jsonOfertas = elemento.getAsJsonArray();
            }
        } catch (IOException e) {
            // Si el archivo no existe, simplemente creamos un nuevo array
            System.out.println("Archivo nuevo creado: Ofertas.json");
        }

        // Agregar cada oferta con la fecha y hora actual al array JSON
        for (Oferta oferta : salaControlador.getSala().getOfertas()) {
            JsonObject jsonOferta = new JsonObject();
            jsonOferta.addProperty("inicio", oferta.getInicio());
            jsonOferta.addProperty("fin", oferta.getFin());
            jsonOferta.addProperty("monto", oferta.getMonto());

            // Agregar la fecha y hora de agregación
            LocalDateTime fechaHoraActual = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaHoraFormateada = fechaHoraActual.format(formato);
            jsonOferta.addProperty("fecha_hora_agregado", fechaHoraFormateada);

            jsonOfertas.add(jsonOferta);
        }

        // Guardar todas las ofertas en el archivo JSON
        try (FileWriter archivo = new FileWriter("Ofertas.json")) {
            gson.toJson(jsonOfertas, archivo);
            System.out.println("Ofertas guardadas en Ofertas.json con fecha y hora de agregación.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
			
//    public void guardarOfertasEnJson() {
//        JsonArray jsonOfertas = new JsonArray();
//        for (Oferta oferta : salaControlador.getSala().getOfertas()) {
//            JsonObject jsonOferta = new JsonObject();
//            jsonOferta.addProperty("inicio", oferta.getInicio());
//            jsonOferta.addProperty("fin", oferta.getFin());
//            jsonOferta.addProperty("monto", oferta.getMonto());
//            jsonOfertas.add(jsonOferta);
//        }
//
//        // Crear la instancia de Gson sin pretty printing
//        Gson gson = new Gson();
//        String jsonString = gson.toJson(jsonOfertas);
//
//        // Modificar el JSON para agregar un salto de línea entre objetos
//        jsonString = jsonString.replace("},{", "},\n{");
//
//        // Escribir el JSON modificado en el archivo
//        try (FileWriter archivo = new FileWriter("Ofertas.json")) {
//            archivo.write(jsonString);
//            System.out.println("Ofertas guardadas con saltos de línea en Ofertas.json");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

	@Override
	public void notificar(Oferta ofer) {
		guardarOfertasEnJson();
		
	}
}

