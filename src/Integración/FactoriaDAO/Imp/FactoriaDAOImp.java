


package Integración.FactoriaDAO.Imp;

import Integración.FactoriaDAO.FactoriaDAO;
import Integración.Factura.DAOFactura;
import Integración.Factura.Imp.DAOFacturaImp;
import Integración.Disco.DAODisco;
import Integración.Disco.Imp.DAODiscoImp;
import Integración.LineaFactura.DAOLineaFactura;
import Integración.LineaFactura.Imp.DAOLineaFacturaImp;
import Integración.Cliente.DAOCliente;
import Integración.Cliente.Imp.DAOClienteImp;


public class FactoriaDAOImp extends FactoriaDAO {
	
	public DAOFactura generaDAOFactura() {
		return new DAOFacturaImp();
	}

	
	public DAODisco generaDAODisco() {
		return new DAODiscoImp();
	}

	
	public DAOLineaFactura generaDAOLineaPedido() {
		return new DAOLineaFacturaImp();
	}

	
	public DAOCliente generaDAOCliente() {
		return new DAOClienteImp();
	}
}