package Model;

import java.util.ArrayList;

public class MainPrueba {
	public static void imprimir(ArrayList<Oferta>of) {
		if(of.isEmpty()) {
			System.out.println("VACIO");
		}
		for(Oferta ofer : of) {
			System.out.println(ofer.toString());
		}
	}
	
	public static void main(String[] args) {
		SalaEnsayo sala = new SalaEnsayo();
		ComparePorBeneficio compare = new ComparePorBeneficio();
		//Oferta oferta0 = new Oferta(8,19,16000.09);
		Oferta oferta1 = new Oferta(8,12,16000.02);
		Oferta oferta2 = new Oferta(12,15,14000.0);
		Oferta oferta3 = new Oferta(11,16,10000.01);
		Oferta oferta4 = new Oferta(17,21, 14000.09);
		Oferta oferta5 = new Oferta(7, 11, 14000.04);
		
		//sala.agregarOferta(oferta0);
		sala.agregarOferta(oferta1);
		sala.agregarOferta(oferta2);
		sala.agregarOferta(oferta3);
		sala.agregarOferta(oferta4);
		sala.agregarOferta(oferta5);
		
		Solver solver = new Solver(sala, compare);
		
		ArrayList<Oferta> ret = solver.resolver();
		
		imprimir(ret);
	}
}
