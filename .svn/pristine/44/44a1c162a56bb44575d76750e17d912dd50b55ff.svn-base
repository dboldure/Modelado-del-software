package Negocio.Disco.Imp;

import Negocio.Disco.SADisco;
import Negocio.Disco.TDisco;
import Negocio.Disco.TDiscoCD;
import Negocio.Disco.TDiscoVinilo;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;

import Integración.Disco.DAODisco;
import Integración.FactoriaDAO.FactoriaDAO;
import Integración.FactoriaDAO.Imp.FactoriaDAOImp;
import Integración.Query.*;
import Integración.Transaction.Transaction;
import Integración.Transaction.TransactionManager;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SADiscoImp implements SADisco {
	
	
	/*
	 * TABLA DE ERRORES
	 * 
	 * -1 - tDisco == null (nos pasan un valor vacío)
	 * -2 - transaction == null (transaccion inválida)
	 * -100 - Error de Base de Datos 
	 * 
	 */
	public Integer alta(TDisco disco) {
		int id = -1;
		if (disco != null) {
			
			disco.setActivo(true);
			TransactionManager transactionManager = TransactionManager.getInstance();
			Transaction transaction = transactionManager.nuevaTransaccion();
			if (transaction != null) {
				transaction.start();
				FactoriaDAO factoria = FactoriaDAO.getInstance();
				DAODisco daoDisco = factoria.generaDAODisco();
				id = daoDisco.alta(disco);
				if(id == -1){
					id = -100; 
					transaction.rollback();
				}
				else{
					transaction.commit();
				}	
			}
			else{
				id = -2; 
			}
			transactionManager.eliminaTransaccion();
		}
		return id;
	}
	


	/*
	 * TABLA DE ERRORES
	 * 
	 * -1 - Transacción no creada (transaction == null)
	 * -2 - El disco que se quiere borrar no existe (no hay id coincidente)
	 * -3 - El disco que se quiere borrar ya está borrado (desactivado, vamos)
	 * -100 - Error de Base de Datos
	 * 
	 *
	 * 
	 */
	public Integer baja(Integer id) {
		int cod=-1;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaccion = transactionManager.nuevaTransaccion();
			if (transaccion != null) {
				transaccion.start();
				DAODisco daoDisco=FactoriaDAOImp.getInstance().generaDAODisco();
				TDisco disco=daoDisco.mostrar(id);
				if(disco!=null){
				if(disco.getActivo()){
					cod=daoDisco.baja(id);
					if(id==-1){
						id=-100;
						transaccion.rollback();
					}
					else transaccion.commit();
				
				}
				else{
					cod=-3; 
					transaccion.rollback();
					}
				}
				else{
					cod=-2; 
					transaccion.rollback();
				}
			}
			
			transactionManager.eliminaTransaccion();

		return cod;
	}
	

	
	
	/*
	 * TABLA DE ERRORES
	 * 
	 * -1 - tProducto == null
	 * -2 - Fallo en la transacción (no creada con éxito)
	 * -100 - Error de Base de Datos
	 * 
	 */
	public Integer modificar(TDisco tDisco) {
		int id = -1;
		if (tDisco != null) {
			TransactionManager transactionManager = TransactionManager.getInstance();
			Transaction transaction = transactionManager.nuevaTransaccion();
			if (transaction != null) {
				transaction.start();
				
				
				
				
				
				
				FactoriaDAO factoria = FactoriaDAO.getInstance();
				DAODisco daoDisco = factoria.generaDAODisco();
				
				TDisco disco = daoDisco.mostrar(tDisco.getId());
				
				if (disco != null){
					if (disco.getActivo()){
				
				
						
						if (!tDisco.getNombre().isEmpty())disco.setNombre(tDisco.getNombre());
						if (tDisco.getAño() != null)disco.setAño(tDisco.getAño());
						if (tDisco.getPrecio() != null)disco.setPrecio(tDisco.getPrecio());
						if (tDisco.getStock() != null)disco.setStock(tDisco.getStock());
						if (!tDisco.getGenero().isEmpty())disco.setGenero(tDisco.getGenero());
						
						if (disco instanceof TDiscoCD){
							if (((TDiscoCD) tDisco).getDvd() != null)((TDiscoCD) disco).setDvd(((TDiscoCD) tDisco).getDvd());
						}
						else{
							if (((TDiscoVinilo) tDisco).getGramaje() != null)((TDiscoVinilo) disco).setGramaje(((TDiscoVinilo) tDisco).getGramaje());
							if (!((TDiscoVinilo) tDisco).getPrensado().isEmpty())((TDiscoVinilo) disco).setPrensado(((TDiscoVinilo) tDisco).getPrensado());
							if (((TDiscoVinilo) tDisco).getRevoluciones() != null)((TDiscoVinilo) disco).setRevoluciones(((TDiscoVinilo) tDisco).getRevoluciones());
						}
						
						id = daoDisco.modificar(disco);
						if(id == -1) {	
							id=-100;
							transaction.rollback();		
						}else{
							transaction.commit();	
						}	
					
					}
					else {
						id = -4; // no esta activo
					}
				}
				else{
					id=-3;// no existe el disco
				}
			}
			transactionManager.eliminaTransaccion();
		}
		return id;
	}	
	
		
	


	
	public ArrayList<TDisco> listar() {
		
		ArrayList<TDisco> listaDiscos=null;
		FactoriaDAO factoria=FactoriaDAO.getInstance();
		DAODisco daoDisco=factoria.generaDAODisco();
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaccion = transactionManager.nuevaTransaccion();
		if(transaccion!=null){
			transaccion.start();
			listaDiscos =daoDisco.listar();
			transaccion.commit();
		}	
		transactionManager.eliminaTransaccion();
		
		
		return listaDiscos;
	}
	


	public TDisco mostrar(Integer id) {
		TDisco tDisco = null;
		
		FactoriaDAO factoria=FactoriaDAO.getInstance();
		DAODisco daoDisco = factoria.generaDAODisco();
		
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaccion = transactionManager.nuevaTransaccion();
			if(transaccion!=null){
				transaccion.start();
				tDisco = daoDisco.mostrar(id);
				transaccion.commit();
		}	
		transactionManager.eliminaTransaccion();
		
			
		return tDisco;
	}
	
	
	
	

	@SuppressWarnings("unchecked")
	public ArrayList<TDisco> listarDiscosVendidos(String fecha1, String fecha2) {
		
		ArrayList<TDisco> discos = null;
				
		
		ArrayList<java.sql.Date> fechas = new ArrayList<java.sql.Date>();
		
		
		java.sql.Date f1 = null, f2 = null;
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
	    
	    
	    try {
	    	f1 = new java.sql.Date(sdf.parse(fecha1).getTime());
		    f2 = new java.sql.Date(sdf.parse(fecha2).getTime());
		} catch (Exception ex) {
		        System.out.println("Error al obtener el formato de la fecha/hora");
		}
		
	    fechas.add(f1);
	    fechas.add(f2);
	    
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaccion = transactionManager.nuevaTransaccion();
		if(transaccion!=null){
			transaccion.start();
			
			
				FactoriaQuery factoria = FactoriaQuery.getInstance();
				discos = (ArrayList<TDisco>)factoria.getQuery(0).execute(fechas);
					
			
			
			transaccion.commit();
		}	
		transactionManager.eliminaTransaccion();
		
		
		
			
		return discos;
	}
	
	
}