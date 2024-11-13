package Model;

import java.util.Comparator;

public class ComparePorCociente implements Comparator<Oferta> {
	
	@Override
	public int compare(Oferta uno, Oferta dos)
	{
		
		double cocienteUno = uno.getMonto() / (uno.getFin() - uno.getInicio());
		double cocienteDos = dos.getMonto() / (dos.getFin() - dos.getInicio());
		
	
		if( cocienteUno < cocienteDos )
			return 1;
		else if( cocienteUno == cocienteDos )
			return 0;
		else
			return -1;
	}

	
}
