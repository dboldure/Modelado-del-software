


package Integración.Query.Imp;

import Integración.Query.FactoriaQuery;
import Integración.Query.ListarDiscosVendidos;
import Integración.Query.MostrarHistorialDeCompras;
import Integración.Query.Query;


public class FactoriaQueryImp extends FactoriaQuery {
	
	public Query getQuery(Integer tipo) {
		if(tipo == 0) return new ListarDiscosVendidos();
		if(tipo == 1) return new MostrarHistorialDeCompras();
		return null;
	}
}