package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Oferta {
    private int inicio;
    private int fin;
    private double monto;
    private String fecha;  

    public Oferta(int inicio, int fin, double monto) {
        this.inicio = inicio;
        this.fin = fin;
        this.monto = monto;
        
        LocalDateTime fechaActualMasUno = LocalDateTime.now().plusDays(1);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.fecha = fechaActualMasUno.format(formato);
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

    @Override
    public String toString() {
        return "Oferta [inicio=" + inicio + ", fin=" + fin + ", monto=" + monto + ", fecha=" + fecha + "]";
    }
}
