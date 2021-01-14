
package Negocio.Cliente.Imp;

import java.util.ArrayList;
import Integración.Cliente.DAOCliente;
import Integración.FactoriaDAO.FactoriaDAO;
import Integración.FactoriaDAO.Imp.FactoriaDAOImp;
import Integración.Query.FactoriaQuery;
import Integración.Transaction.Transaction;
import Integración.Transaction.TransactionManager;
import Negocio.Cliente.SACliente;
import Negocio.Cliente.TCliente;
import Negocio.Disco.TDisco;

public class SAClienteImp implements SACliente {

	/*
	 * TABLA DE ERRORES
	 * 
	 * -1 - El parámetro cliente es null.
	 * -2 - Fallo al crear la transacción.
	 * -3 - El DNI del cliente coincide con el de un cliente en la base de datos.
	 * -100 - Fallo en la base de datos
	 */
	public Integer alta(TCliente cliente) {
		int id=-1;
		if(cliente!=null){ 
			TransactionManager transactionManager=TransactionManager.getInstance();
			Transaction transaccion=transactionManager.nuevaTransaccion();
			if(transaccion!=null) {
				transaccion.start();
				FactoriaDAO factoria=FactoriaDAO.getInstance();
				DAOCliente daoCliente=factoria.generaDAOCliente();
				
				TCliente c = daoCliente.mostrarPorDni(cliente.getDni());
				
				if(c==null || (c!=null && !c.getActivo())){
					if(c == null){
						id = daoCliente.alta(cliente);
						if(id < 0){
							id = -100;
							transaccion.rollback();
						}
					}
					else{
						cliente.setId(c.getId());
						id = daoCliente.modificar(cliente);
					}
				}
				else{
					id = -3;
				}
			}
		else{
			id = -2;
		}
		transaccion.commit();
		transactionManager.eliminaTransaccion();
				
					
		}
		return id;
	}


	
	
	/*
	 * TABLA DE ERRORES
	 * 
	 * -1 - Fallo al crear la transacción.
	 * -2 - El cliente no existe
	 * -3 - El cliente no figura como activo.
	 * -100 - Fallo en la base de datos.
	 */
	public Integer baja(Integer idCliente) {
		int id=-1;
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaccion = transactionManager.nuevaTransaccion();
			if (transaccion != null) {
				transaccion.start();
				DAOCliente daoCliente=FactoriaDAOImp.getInstance().generaDAOCliente();
				TCliente cliente=daoCliente.mostrar(idCliente);
				if(cliente!=null){
					if(cliente.getActivo()){
					
						id=daoCliente.baja(idCliente);
						if(id<0) {
							id = -100;
							transaccion.rollback();
						}	
						else {
							transaccion.commit();
						}
				
					}
					else{
						id=-3;
						transaccion.rollback();
					}
				}
				else{
					id=-2;
					transaccion.rollback();
				}
			}
			transactionManager.eliminaTransaccion();

	

		

		return id;
	}

	
	
	
	/*
	 * TABLA DE ERRORES
	 * -1 - El parámetro cliente es null.
	 * -2 - El cliente no existe.
	 * -3 - El cliente no está activo.
	 * -4 - Fallo al crear la transacción.
	 * -100 - Fallo en la base de datos.
	 * 
	 */
	public int modificar(TCliente cliente) {
		int id = -1;
		TCliente tC = null;
		if(cliente!=null){
		
			DAOCliente daoCliente=FactoriaDAOImp.getInstance().generaDAOCliente();
			
			TransactionManager transactionManager = TransactionManager.getInstance();
			Transaction transaccion = transactionManager.nuevaTransaccion();
			if(transaccion!=null){
				transaccion.start();
				tC=daoCliente.mostrar(cliente.getId());
			
			
				if(tC!=null){
					
					TCliente clienteRepe = daoCliente.mostrarPorDni(cliente.getDni());
					if (clienteRepe == null){
						if (cliente.getDni().equals("")) cliente.setDni(tC.getDni());
						if (cliente.getNombre().equals("")) cliente.setNombre(tC.getNombre());
						
						if(tC.getActivo()){
							
						
								
								id = daoCliente.modificar(cliente);
								if(id>=0){
									transaccion.commit();
								}else{
									id= -100;
									transaccion.rollback();
								}
								
							
							
							transactionManager.eliminaTransaccion();
							
							
						}else{
							id = -3;
						}
					}
					else{
						id = -5;
					}
				}
				else{
					id=-2;
				}
			}
			else{
				id=-4;
			}
		}
		return id;
	}
	

	public TCliente mostrar(Integer id) {
		TCliente tCliente=null;
	
		FactoriaDAO factoria=FactoriaDAO.getInstance();
		DAOCliente daoCliente=factoria.generaDAOCliente();
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaccion = transactionManager.nuevaTransaccion();
			if(transaccion!=null){
				transaccion.start();
				tCliente=daoCliente.mostrar(id);
				transaccion.commit();
		}	
		transactionManager.eliminaTransaccion();
		return tCliente;
	}

	public ArrayList<TCliente> listar() {
		ArrayList<TCliente> listaClientes=null;
		
		FactoriaDAO factoria=FactoriaDAO.getInstance();
		DAOCliente daoCliente=factoria.generaDAOCliente();
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaccion = transactionManager.nuevaTransaccion();
		if(transaccion!=null){
			transaccion.start();
			listaClientes =daoCliente.listar();
			transaccion.commit();
		}	
		transactionManager.eliminaTransaccion();
		
		return listaClientes;
	}

	

	@SuppressWarnings("unchecked")
	public ArrayList<TDisco> mostrarHistorialDeCompra(Integer idCliente) {
		ArrayList<TDisco> discos = null;
		
		FactoriaDAO factoria=FactoriaDAO.getInstance();
		DAOCliente daoCliente=factoria.generaDAOCliente();
		
		
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaccion = transactionManager.nuevaTransaccion();
		if(transaccion!=null){
			transaccion.start();
			
			TCliente cliente = daoCliente.mostrar(idCliente);
			if(cliente!=null){
				FactoriaQuery fQ = FactoriaQuery.getInstance();
				discos = (ArrayList<TDisco>)fQ.getQuery(1).execute(idCliente);
					
			}
			
			
			transaccion.commit();
		}	
		transactionManager.eliminaTransaccion();
		
		
	
		return discos;
	}

}