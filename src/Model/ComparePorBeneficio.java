package Model;

import java.util.Comparator;

public class ComparePorBeneficio implements Comparator<Oferta> {
	
	public int compare(Oferta a, Oferta b) {
		return  b.getMonto() - a.getMonto(); // de forma descendente 
	}
	
}
