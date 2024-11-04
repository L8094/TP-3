package Model;

public class Oferta {
	private int inicio;
    private int fin;
    private double monto;
    
    
    public Oferta(int inicio, int fin, double monto) {
    	this.inicio = inicio;
    	this.fin = fin;
    	this.monto = monto;
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

    @Override
    public String toString() {
        return "Oferta [inicio=" + inicio + ", fin=" + fin + ", monto=" + monto + "]";
    }
}
