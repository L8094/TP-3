package Model;

import java.util.ArrayList;
import java.util.List;

import Presenter.Presentador;

public class MainPrueba {
	
    private static final String ruta = "Ofertas.json";

	public static void imprimir(List<Oferta>of) {
		if(of.isEmpty()) {
			System.out.println("VACIO");
		}
		for(Oferta ofer : of) {
			System.out.println(ofer.toString());
		}
	}
	
//	public static void main(String[] args) {
//		SalaEnsayo sala = new SalaEnsayo();
//		ComparePorBeneficio compare = new ComparePorBeneficio();
//		//Oferta oferta0 = new Oferta(8,19,16000.09);
//		Oferta oferta1 = new Oferta(8,12,16000.02);
//		Oferta oferta2 = new Oferta(12,15,14000.0);
//		Oferta oferta3 = new Oferta(11,16,10000.01);
//		Oferta oferta4 = new Oferta(17,21, 14000.09);
//		Oferta oferta5 = new Oferta(7, 11, 14000.04);
//		
//		//sala.agregarOferta(oferta0);
//		sala.agregarOferta(oferta1);
//		sala.agregarOferta(oferta2);
//		sala.agregarOferta(oferta3);
//		sala.agregarOferta(oferta4);
//		sala.agregarOferta(oferta5);
//		
//		Solver solver = new Solver(sala, compare);
//		
//		ArrayList<Oferta> ret = solver.resolver();
//		
//		imprimir(ret);
//	}
	
	
	public static void main(String[] args) {
		
		OfertaManager ofer = new OfertaManager();
//		SalaEnsayo sala = new SalaEnsayo();
//		ComparePorBeneficio compareBen = new ComparePorBeneficio();
//		ComparePorCociente compareCoc = new ComparePorCociente();
		//Oferta oferta0 = new Oferta(8,19,16000.09);
		Oferta oferta1 = new Oferta(00,23,50000.02,"A");
		Oferta oferta2 = new Oferta(12,15,25000.0,"E");
		Oferta oferta3 = new Oferta(11,16,25000.01,"I");
		Oferta oferta4 = new Oferta(17,21, 45000.09,"O");
		Oferta oferta5 = new Oferta(7, 11, 45000.04,"U");
		
		
		OfertaManager.agregarOfertaEnMemoria(oferta1);
		OfertaManager.agregarOfertaEnMemoria(oferta2);
		OfertaManager.agregarOfertaEnMemoria(oferta3);
		OfertaManager.agregarOfertaEnMemoria(oferta4);
		OfertaManager.agregarOfertaEnMemoria(oferta5);
		
		OfertaManager.guardarOfertasEnJson();

		List<Oferta> ret = JsonPersistencia.listaDeOfertasEnJson(ruta); //lista de ofertas guardadas
		List<Oferta> ret1 = Presentador.adjudicarOfertas(ret); //Esta lista se cambio a static - volverla
//		imprimir(ret);
		
		imprimir(ret1);
		
		//sala.agregarOferta(oferta0);
//		sala.agregarOferta(oferta1);
//		sala.agregarOferta(oferta2);
//		sala.agregarOferta(oferta3);
//		sala.agregarOferta(oferta4);
//		sala.agregarOferta(oferta5);
		
//		Solver solver = new Solver(sala, compareBen);
//		Solver solver = new Solver(compareCoc);
		
//		ArrayList<Oferta> ret = solver.resolver();
		
//		imprimir(ret);
	}
}
