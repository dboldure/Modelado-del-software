


package Integración.Transaction;

import Integración.Transaction.Imp.TransactionFactoryImp;

public abstract class TransactionFactory {

	private static TransactionFactory instancia;

	public static TransactionFactory getInstance() {
		if(instancia == null){
			instancia = new TransactionFactoryImp();
		}
		return instancia;

	}


	public abstract Transaction crearTransaccion();
	
}