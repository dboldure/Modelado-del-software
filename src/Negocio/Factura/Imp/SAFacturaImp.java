
package Negocio.Factura.Imp;


import java.util.ArrayList;

import Integración.Cliente.DAOCliente;
import Integración.Disco.DAODisco;
import Integración.FactoriaDAO.FactoriaDAO;
import Integración.Factura.DAOFactura;
import Integración.LineaFactura.DAOLineaFactura;
import Integración.Query.FactoriaQuery;
import Integración.Transaction.Transaction;
import Integración.Transaction.TransactionManager;

import Negocio.Cliente.TCliente;
import Negocio.Disco.TDisco;
import Negocio.Factura.SAFactura;
import Negocio.Factura.TEnsamblado;
import Negocio.Factura.TFactura;
import Negocio.LineaFactura.TLineaFactura;


public class SAFacturaImp implements SAFactura {

	
	
	/*
	 * TABLA DE ERRORES
	 * 
	 * -0 - Sin errores.
	 * -1 - El parámetro TFactura es null.
	 * -2 - El idCliente almacenado dentro de TFactura no corresponde a ningún cliente.
	 * -3 - El idCliente almacenado dentro de TFactura corresponde a un cliente no activo.
	 * 
	 */
	public Integer abrir(TFactura factura) {
		int cod=0;
		if(factura!=null){
			
			
			TransactionManager transactionManager=TransactionManager.getInstance();
			Transaction transaccion=transactionManager.nuevaTransaccion();
			if(transaccion!=null) {
				transaccion.start();
			
				FactoriaDAO factoria = FactoriaDAO.getInstance();
				DAOCliente daoCliente = factoria.generaDAOCliente();
				int idC = factura.getIdCliente();
				TCliente tC = daoCliente.mostrar(idC);
				if(tC != null){
					if(tC.getActivo()){
						factura.setActivo(true);
						factura.setPrecioTotal(0);
					}else{
						cod=-3;
					}
				}else{
					cod=-2;
				}
				
				
			}	
				
			transactionManager.eliminaTransaccion();
			
			
		}else{
			cod = -1;
		}
		
		
		
		return cod;
	}

	
	

	
	public ArrayList<TLineaFactura> añadirProducto(ArrayList<TLineaFactura> lineasFactura, TLineaFactura lineaFactura) {
		FactoriaDAO factoria = FactoriaDAO.getInstance();
		DAODisco daoDisco = factoria.generaDAODisco();
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaccion = transactionManager.nuevaTransaccion();
		if(transaccion!=null){
			transaccion.start();
			
			TDisco disco = daoDisco.mostrar(lineaFactura.getIdDisco());
			if(disco!=null && disco.getActivo()){
				lineaFactura.setPrecio(disco.getPrecio());
				
				boolean encontrado = false;
				for(TLineaFactura lF : lineasFactura){
					if(lF.getIdDisco() == disco.getId()){
						encontrado=true;
						if(lF.getCantidad() + lineaFactura.getCantidad() <= disco.getStock()){
							lF.setCantidad(lF.getCantidad() + lineaFactura.getCantidad());
							//lF.setPrecio(disco.getPrecio() * lF.getCantidad());
							
						}
					}
					
				}
				
				if(!encontrado){
					if(lineaFactura.getCantidad() <= disco.getStock()){
						lineasFactura.add(lineaFactura);
					}
				}
				transaccion.commit();
			}
				
			
			else{
				transaccion.rollback();
			}
			
			
		}	
		transactionManager.eliminaTransaccion();
		return lineasFactura;
	}
	
	public ArrayList<TLineaFactura> quitarProducto(ArrayList<TLineaFactura> lineaFacturas, TLineaFactura lineaFactura) {
		
		
		int index = 0;
		for(TLineaFactura lF: lineaFacturas){
				if(lineaFactura.getIdDisco() == lF.getIdDisco()){
					
					if(lineaFactura.getCantidad() <= lF.getCantidad()){
						lF.setCantidad(lF.getCantidad() - lineaFactura.getCantidad());
					
					}else{
						lF.setCantidad(0);
					}
					if(lF.getCantidad()==0){
						lineaFacturas.remove(index);
					}
				
				}
				index++;
		}
		
		return lineaFacturas;
	}
	

		

	/*
	 * Errores:
	 * -1: algún parámetro de entrada es null.
	 * -2: fallo al crear la transacción.
	 * -3: el cliente no existe.
	 * -4: el cliente no está activo.
	 * -5: el stock de un disco es menor quela cantidad de una linea factura donde aparece.
	 * -100: Error en la gestion de la BDD.
	 * 
	 * PRECONDICIÓN: los valores de los atributos almacenados en los parámetros son validos.
	 * 
	 */
	public Integer cerrar(ArrayList<TLineaFactura> lineasFactura, TFactura factura){

		int id = 0;
		
		if(lineasFactura != null && factura != null && !lineasFactura.isEmpty()){
			
			TransactionManager transactionManager = TransactionManager.getInstance();
			Transaction transaction = transactionManager.nuevaTransaccion();
			if(transaction!=null){
				
				FactoriaDAO factoria = FactoriaDAO.getInstance();
				DAOCliente daoCliente = factoria.generaDAOCliente();
				TCliente cliente = daoCliente.mostrar(factura.getIdCliente());
				if(cliente!=null){
					if(cliente.getActivo()){
						
						DAOFactura daoFactura = factoria.generaDAOFactura();
						id = daoFactura.cerrar(factura);
						factura.setId(id);
						if(id!=-1){
							
							float total=0;
							int idDisco, idLineaFactura;
							
							DAODisco daoDisco = factoria.generaDAODisco();
							TDisco disco;
							DAOLineaFactura daoLineaFactura = factoria.generaDAOLineaPedido();
							TLineaFactura  lineaFactura;
							
							for(TLineaFactura lF: lineasFactura){
								lF.setIdFactura(id);
								disco = daoDisco.mostrar(lF.getIdDisco());
								if(lF.getCantidad() <= disco.getStock()){
									total += lF.getPrecio() * lF.getCantidad();
									disco.setStock(disco.getStock() - lF.getCantidad());
									idDisco = daoDisco.modificar(disco);
									lineaFactura = lF;
									idLineaFactura = daoLineaFactura.alta(lineaFactura);
									if(idDisco == -1 || idLineaFactura == -1){
										id = -100;
										transaction.rollback();
										break;
									}
								}else{
									id = -5;
									transaction.rollback();
									break;
								}	
							}
							
							id = daoFactura.modificarPrecioTotal(factura.getId(), total);
							
							if(id >= 0){
								transaction.commit();
							}else{
								id = -100;
								transaction.rollback();
							}
					}else{
						id = -4;
					}
				}else{
					id = -3;
				}
			}else{
				id = -2;
			}
		transactionManager.eliminaTransaccion();	
			}else{
				id=-1;
			}
		
		}
		return id;
	}
	


	
	/*
	 * Error:
	 * -1: El disco no existe.
	 * -2: la factura no existe.
	 * -3: no existen lineas factura de ese disco en esa factura.
	 * -4: fallo en la transaccion.
	 * -5: Las unidades a devolver superan las de la venta.
	 * -100: Error en la gestion de la BDD.
	 * 
	 *
	 */
	public Integer devolucion(TLineaFactura lineaFactura) {
		
		int idDisco = lineaFactura.getIdDisco();
		int idFactura = lineaFactura.getIdFactura();
		int cantidad = lineaFactura.getCantidad();
		
		int id=0;
		
		FactoriaDAO factoria = FactoriaDAO.getInstance();
		DAODisco daoDisco = factoria.generaDAODisco();
		
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.nuevaTransaccion();
		if(transaction!=null){
			transaction.start();
			TDisco disco = daoDisco.mostrar(idDisco);
			if(disco!=null){
				DAOFactura daoFactura = factoria.generaDAOFactura();
				TFactura factura = daoFactura.mostrar(idFactura);
				if(factura!=null){
					DAOLineaFactura daoLineaFactura = factoria.generaDAOLineaPedido();
					ArrayList<TLineaFactura> lineasFactura = (ArrayList<TLineaFactura>)daoLineaFactura.mostrarLineasFacturaPorIdFactura(idFactura);
					if(lineasFactura!=null && !lineasFactura.isEmpty()){
						
						for(TLineaFactura lF : lineasFactura){
							if(lF.getIdDisco() == idDisco){
								if(cantidad>0){
									if(cantidad <= lF.getCantidad()){
										lF.setCantidad(lF.getCantidad()-cantidad);
										if(lF.getCantidad()==0){
											id = daoLineaFactura.baja(idDisco, idFactura);
											if(id == -1){
												id = -100;
												transaction.rollback();
												break;
											}
										}else{
											id = daoLineaFactura.modificar(lF);
											if(id ==-1){
												id = -100;
												transaction.rollback();
												break;
											}
										}
										disco.setStock(disco.getStock()+cantidad);
										daoDisco.modificar(disco);
										id = daoFactura.modificarPrecioTotal(idFactura, factura.getPrecioTotal() - (	lF.getPrecio()* cantidad));
										if(id==-1){
											id=-100;
											transaction.rollback();
											break;
										}
									}else{
										id = -5;
										break;
									}
								}
							}
						}
						transaction.commit();
						
					}else{
						id = -3;
					}
				}else{
					id = -2;
				}
			}else{
				id = -1;
			}
		}else{
			id = -4;
		}
		transactionManager.eliminaTransaccion();
		return id;
	}
	
	
	
	
	@SuppressWarnings("null")
	public TEnsamblado mostrar(Integer idFactura) {
		
		TEnsamblado facturaCompleta = null;
		FactoriaDAO factoria = FactoriaDAO.getInstance();
		DAOFactura daoFactura = factoria.generaDAOFactura();
		
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaccion = transactionManager.nuevaTransaccion();
		if(transaccion!=null){
			transaccion.start();
			
			TFactura factura = daoFactura.mostrar(idFactura);
			if(factura!=null){
				
				DAOLineaFactura daoLineaFactura = factoria.generaDAOLineaPedido();
				ArrayList<TLineaFactura> lineasFactura = (ArrayList<TLineaFactura>)daoLineaFactura.mostrarLineasFacturaPorIdFactura(idFactura);
				if(lineasFactura!=null){
					DAODisco daoDisco = factoria.generaDAODisco();
					ArrayList<TDisco> discos = new ArrayList<TDisco>();
					TDisco disco;
					for(TLineaFactura lF : lineasFactura){
						disco = daoDisco.mostrar(lF.getIdDisco());
						if(disco!=null){
							discos.add(disco);
						}else break;
					}
					
					facturaCompleta = new TEnsamblado(factura, lineasFactura, discos);
					
				}	
			}
			
			transaccion.commit();
		}	
		transactionManager.eliminaTransaccion();
		
		
		return facturaCompleta;
		
	}
	
	
	
	public ArrayList<TFactura> listar() {
		ArrayList<TFactura> listaFacturas=null;
		
		FactoriaDAO factoria=FactoriaDAO.getInstance();
		DAOFactura daoFactura=factoria.generaDAOFactura();
		
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaccion = transactionManager.nuevaTransaccion();
		if(transaccion!=null){
			transaccion.start();
			listaFacturas =daoFactura.listar();
			transaccion.commit();
		}	
		transactionManager.eliminaTransaccion();
		
		
		
		
		
		return listaFacturas;
	}
	
	
	
	

}