
package Presentación.FactoriaVista;

import Presentación.Contexto;
import Presentación.GUI;

import Presentación.FactoriaVista.Imp.FactoriaVistaImp;


public abstract class FactoriaVista {
	
private static FactoriaVista instancia;

	
	public static FactoriaVista getInstance() {
		if(instancia==null) {
			instancia = new FactoriaVistaImp();
		}
		
		return instancia;

	}
	
	public abstract GUI generaVista(Contexto contexto);
	
	
}