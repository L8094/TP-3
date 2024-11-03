package Presenter;

import Model.Oferta;
import Model.SalaEnsayo;

public class Observador {
	private SalaEnsayo sala;

	public Observador (SalaEnsayo sala) {
		this.sala = sala;
	}
	
	public void enviarOferta(String inicio , String fin, String dinero) {
		int ini = Integer.parseInt(inicio);
		int fi = Integer.parseInt(fin);
		int din = Integer.parseInt(dinero);
		
        Oferta nuevaOferta = new Oferta(ini, fi, din);
        
        sala.agregarOferta(nuevaOferta);
    }
}
