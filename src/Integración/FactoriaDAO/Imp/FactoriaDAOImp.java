


package Integraci�n.FactoriaDAO.Imp;

import Integraci�n.FactoriaDAO.FactoriaDAO;
import Integraci�n.Factura.DAOFactura;
import Integraci�n.Factura.Imp.DAOFacturaImp;
import Integraci�n.Disco.DAODisco;
import Integraci�n.Disco.Imp.DAODiscoImp;
import Integraci�n.LineaFactura.DAOLineaFactura;
import Integraci�n.LineaFactura.Imp.DAOLineaFacturaImp;
import Integraci�n.Cliente.DAOCliente;
import Integraci�n.Cliente.Imp.DAOClienteImp;


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