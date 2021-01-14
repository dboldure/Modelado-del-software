


package Integración.FactoriaDAO;

import Integración.Factura.DAOFactura;
import Integración.Disco.DAODisco;
import Integración.FactoriaDAO.Imp.FactoriaDAOImp;
import Integración.LineaFactura.DAOLineaFactura;
import Integración.Cliente.DAOCliente;


public abstract class FactoriaDAO{

	private static FactoriaDAO instancia;
	
	public  static FactoriaDAO getInstance() {
		if(instancia==null) {
			instancia = new FactoriaDAOImp();
		}
		
		return instancia;

	}

	
	public abstract DAOFactura generaDAOFactura();

	
	public abstract DAODisco generaDAODisco();

	
	public abstract DAOLineaFactura generaDAOLineaPedido();

	
	public abstract DAOCliente generaDAOCliente();
}