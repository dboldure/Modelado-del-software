


package Integración.Query;

import Integración.Query.Imp.FactoriaQueryImp;

public abstract class FactoriaQuery {

	private static FactoriaQuery instancia;

	
	public static FactoriaQuery getInstance() {
		if(instancia == null){
			instancia = new FactoriaQueryImp();
		}
		return instancia;
	}


	public abstract Query getQuery(Integer tipo);
}
