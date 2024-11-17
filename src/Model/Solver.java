package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solver {
	
    private List<Oferta> ofertas;
	private Comparator<Oferta> compare;
	private List<Oferta> solucion;
	
    public Solver(List<Oferta> ofertasFiltradas, Comparator<Oferta> compare) {
        this.ofertas = ofertasFiltradas;
        this.compare = compare;
    }
    
    public List<Oferta> resolver() {
        this.solucion = new ArrayList<>();
        for (Oferta oferta : objetosOrdenados()) {
            boolean seSuperpone = false;
            for (Oferta ofertaAdjudicada : solucion) {
                if (seSuperponen(oferta, ofertaAdjudicada)) {
                    seSuperpone = true;
                }
            }
            if (!seSuperpone) {
                solucion.add(oferta);
                oferta.adjudicar();
            }
        }
        return solucion;
    }

    private List<Oferta> objetosOrdenados() {
        Collections.sort(ofertas, compare);
        return ofertas;
    }


	private boolean seSuperponen(Oferta a, Oferta b) {
        return !(a.getFin() <= b.getInicio() || b.getFin() <= a.getInicio());
    }
}
