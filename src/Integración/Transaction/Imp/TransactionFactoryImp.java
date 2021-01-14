


package Integraci�n.Transaction.Imp;

import Integraci�n.Transaction.Transaction;
import Integraci�n.Transaction.TransactionFactory;
import Integraci�n.Transaction.TransactionMySQL;

public class TransactionFactoryImp extends TransactionFactory {

	@Override
	public Transaction crearTransaccion() {
		return new TransactionMySQL();

	}
}