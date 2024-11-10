package Presenter;

import java.util.List;
import Model.ComparePorCociente;
import Model.Oferta;
import Model.OfertaManager;
import Model.Solver;
import View.MenuPrincipal;
import View.MenuCrearOferta;


public class Presentador{
    private MenuCrearOferta vistaOfertas;
    private MenuPrincipal vistaMenuPpal; 
    private OfertaManager ofertaManager;
    
    public Presentador(MenuCrearOferta vistaOfertas, MenuPrincipal vistaMenuPpal) {
        this.ofertaManager = new OfertaManager();
        this.vistaOfertas = vistaOfertas;
        this.vistaMenuPpal = vistaMenuPpal; 
    }
    
    public Presentador(MenuCrearOferta vistaOfertas) {
        this.ofertaManager = new OfertaManager();
        this.vistaOfertas = vistaOfertas;
    }
    
    public void agregarOferta(Integer inicio, Integer fin, String dinero) {
        double din = Double.parseDouble(dinero);
        Oferta nuevaOferta = new Oferta(inicio, fin, din);
        OfertaManager.agregarOfertaEnMemoria(nuevaOferta);
        vistaOfertas.actualizarOferta(nuevaOferta);
    }


    public void agregarOfertas() {
        OfertaManager.guardarOfertasEnJson();    
    }

    public void obtenerOfertasPorFecha(String fechaSeleccionada) {
    	try {
        List<Oferta> ofertasFiltradasPorFecha = OfertaManager.cargarOfertasDesdeJSON(fechaSeleccionada);
        if (!ofertasFiltradasPorFecha.isEmpty()) {
            List<Oferta> ofertasAdjudicadas = adjudicarOfertas(ofertasFiltradasPorFecha);
                vistaMenuPpal.mostrarOfertasEnVentana(ofertasFiltradasPorFecha, ofertasAdjudicadas, fechaSeleccionada);
    	}  else {
        	vistaMenuPpal.noHayOfertasEnFecha();
    	}
    	}
    	catch (RuntimeException a){
    		vistaMenuPpal.noHayOfertasEnFecha();
    	}
       
    }

    public static List<Oferta> adjudicarOfertas(List<Oferta> ofertasFiltradasPorFecha) {
        ComparePorCociente comparador = new ComparePorCociente();
        Solver solver = new Solver(ofertasFiltradasPorFecha, comparador);
        return solver.resolver();
    }
}




