package Presenter;

import Model.SalaEnsayo;

public class SalaControlador {
	
	SalaEnsayo sala;
	
	 public SalaControlador(SalaEnsayo sala) {
	        this.sala = sala;
	    }

	 public SalaEnsayo getSala() {
	        return sala;
	 }
}
