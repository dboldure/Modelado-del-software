


package Integración.Transaction.Imp;

import Integración.Transaction.Transaction;
import Integración.Transaction.TransactionFactory;
import Integración.Transaction.TransactionMySQL;

public class TransactionFactoryImp extends TransactionFactory {

	@Override
	public Transaction crearTransaccion() {
		return new TransactionMySQL();

	}
}