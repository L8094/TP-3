package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Oferta {
	private String usuario;
    private int inicio;
    private int fin;
    private double monto;
    private String fecha;  

    public Oferta(int inicio, int fin, double monto,String user) {
        this.inicio = inicio;
        this.fin = fin;
        this.monto = monto;
        this.usuario = user;
        
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
    
    public String getUsuario() {
    	return this.usuario;
    }

    @Override
    public String toString() {
        return "Oferta [Usuario= "+ usuario + ",inicio=" + inicio + ", fin=" + fin + ", monto=" + monto + ", fecha=" + fecha + "]";
    }
}
