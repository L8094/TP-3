package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solver {
	
	SalaEnsayo sala;
	Comparator<Oferta> compare;
	ArrayList<Oferta> solucion;
	
	public Solver(SalaEnsayo sala, Comparator<Oferta> compare) {
		this.sala= sala;
		this.compare = compare;
	}
	public ArrayList<Oferta> resolver(){
	    this.solucion = new ArrayList<>();

	    for(Oferta oferta : objetosOrdenados()) {
	        boolean seSuperpone = false;
	        // Verificar si la oferta se superpone con alguna de las ya seleccionadas
	        for(Oferta ofertaAdjudicada : solucion) {
	            if (seSuperponen(oferta, ofertaAdjudicada)) {
	                seSuperpone = true; // Si se superpone, no agregamos esta oferta   
	            }
	        }
	        // Si no se superpone con ninguna adjudicada, la agregamos
	        if (!seSuperpone) {
	            solucion.add(oferta);
	        }
	    }
	    return solucion;
	}

	
	public ArrayList<Oferta> objetosOrdenados(){
		ArrayList<Oferta> objetos = sala.getOfertas();
		Collections.sort(objetos,compare);
		
		return objetos;
		
	}
	
	
	// Método para verificar superposición de ofertas

	private boolean seSuperponen(Oferta a, Oferta b) {
        return !(a.getFin() <= b.getInicio() || b.getFin() <= a.getInicio());
    }
}
