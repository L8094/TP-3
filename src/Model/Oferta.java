package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Oferta {
	private String nombre;
    private int inicio;
    private int fin;
    private double monto;
    private String fecha;  
    private Boolean adjudicado;

    public Oferta(int inicio, int fin, double monto, String nombre) {
        this.inicio = inicio;
        this.fin = fin;
        this.monto = monto;
        this.nombre = nombre;
        this.adjudicado = false;
        this.fecha = crearFecha();
    }
    
    private String crearFecha() {
        LocalDateTime fechaActualMasUno = LocalDateTime.now().plusDays(1);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return fechaActualMasUno.format(formato);
    }

    public int getInicio() {
        return inicio;
    }

    public int getFin() {
        return fin;
    }

    public double getMonto() {
        return monto;
    }

    public String getFecha() {
        return fecha;
    }
    
    public String getUsuario() {
    	return this.nombre;
    }
    
    public Boolean getAdjudicada() {
    	return this.adjudicado;
    }
    
    public void adjudicar() {
    	this.adjudicado = true;
    }

    @Override
    public String toString() {
        return "|Nombre: "+ nombre + " | De: " + inicio + " a " + fin + " hs | Oferta: $" + monto + ", Fecha: " + fecha + "|";
    }
}
