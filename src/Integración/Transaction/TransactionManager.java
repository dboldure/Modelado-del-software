// HECHO


package Integración.Transaction;

import Integración.Transaction.Imp.TransactionManagerImp;

public abstract class TransactionManager {
	
	private static TransactionManager instancia;

	


	public static TransactionManager getInstance() {
		if(instancia == null){
			instancia = new TransactionManagerImp();
		}
		return instancia;

	}


	public abstract void eliminaTransaccion();

	public abstract Transaction nuevaTransaccion();

	public abstract Transaction getTransaccion();

}