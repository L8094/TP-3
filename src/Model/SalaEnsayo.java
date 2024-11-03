package Model;

import java.util.ArrayList;

import Presenter.ObservadoresOferta;

public class SalaEnsayo {
	
	private ArrayList<ObservadoresOferta> observadores;
	private ArrayList<Oferta> ofertas;
	
	public SalaEnsayo() {
		this.ofertas = new ArrayList<>();
		this.observadores = new ArrayList<>();
	}
	
	
	public void agregarOferta(Oferta ofer) {
		ofertas.add(ofer);
		notificarObservadores(ofer);
	}
	
	public void agregarObservador(ObservadoresOferta observador) {
	        observadores.add(observador);
	 }

	   
	 public void removerObservador(ObservadoresOferta observador) {
	        observadores.remove(observador);
	 }


	private void notificarObservadores(Oferta ofer) {
	        for (ObservadoresOferta observador : observadores) {
	            observador.notificar(ofer);
	        }
	    }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<Oferta> getObjetos(){
		return new ArrayList(ofertas);
	}
}
