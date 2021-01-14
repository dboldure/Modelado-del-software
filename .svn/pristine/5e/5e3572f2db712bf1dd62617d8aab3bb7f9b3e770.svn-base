

package Integración.Factura.Imp;

import Integración.Factura.DAOFactura;
import Integración.Transaction.Transaction;
import Integración.Transaction.TransactionManager;
import Negocio.Factura.TFactura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.Date;


public class DAOFacturaImp implements DAOFactura {

	public Integer cerrar(TFactura factura) {
		Integer id=-1;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				
				try {
					
					PreparedStatement ps = connection.prepareStatement("INSERT INTO factura(precioTotal, fecha, idCliente, activo) values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
				
					Calendar fecha = new GregorianCalendar();
					int año = fecha.get(Calendar.YEAR);
			        int mes = fecha.get(Calendar.MONTH);
			        int dia = fecha.get(Calendar.DAY_OF_MONTH);
					
			        String f = "" + dia +"-"+ mes + "-"+ año;
			        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			        
			        java.util.Date date = format.parse(f);
			        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			        
			        
					ps.setInt(3, factura.getIdCliente());
					ps.setFloat(1, factura.getPrecioTotal());
					ps.setDate(2, sqlDate);
					ps.setBoolean(4, factura.getActivo());
					ps.executeUpdate();
					
					ResultSet rs = ps.getGeneratedKeys();
					if(rs.next()){
						id = rs.getInt(1);

					}
				} catch (Exception e) {
					
				}
			}
		}
	
		return id;

	}

	public Integer modificarPrecioTotal(Integer idFactura, Float precioTotal) {
		Integer id = -1;
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement state = connection.createStatement();
					state.executeUpdate("UPDATE factura SET precioTotal = '" + precioTotal + "' WHERE id = '" + idFactura + "'");
					id = idFactura;
				} catch (Exception e) {
				}
			}
		}
		return id;
	}

	public TFactura mostrar(Integer idFactura) {
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement state = connection.createStatement();
					ResultSet set = state.executeQuery( "SELECT * FROM factura WHERE id = '" + idFactura + "' FOR UPDATE ");

					if (set.next()) {
						Integer idCliente = set.getInt("idCliente");
						Float precioTotal = set.getFloat("precioTotal");
						Date fecha = set.getDate("fecha");
						boolean activo = set.getBoolean("activo");
						return new TFactura(idFactura, idCliente, precioTotal, fecha, activo);
					}
				
				} catch (Exception e) {

				}
			}
		}
		return null;
	}

	public ArrayList<TFactura> listar() {
		ArrayList<TFactura>  listaFacturas = new ArrayList<>();
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement state = connection.createStatement();
					ResultSet set = state.executeQuery("SELECT * FROM factura");
					while (set.next()) {
						Integer idFactura = set.getInt("id");
						Integer idCliente = set.getInt("idCliente");
						Float precioTotal = set.getFloat("precioTotal");
						Date fecha = set.getDate("fecha");
						boolean activo = set.getBoolean("activo");
						listaFacturas.add(new TFactura(idFactura, idCliente, precioTotal, fecha, activo));
                    }
				} catch (Exception e) {
					listaFacturas = null;
				}
				
			
			}
		}
		return listaFacturas;
	}

	public ArrayList<TFactura> mostrarFacturasPorCliente(Integer idCliente) {
		ArrayList<TFactura>  listaFacturas = new ArrayList<>();
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement state = connection.createStatement();
					ResultSet set = state.executeQuery("SELECT * FROM factura WHERE idCliente = '" + idCliente + "'");
					while (set.next()) {
						Integer idFactura = set.getInt("id");
						Float precioTotal = set.getFloat("precioTotal");
						Date fecha = set.getDate("fecha");
						boolean activo = set.getBoolean("activo");
						listaFacturas.add(new TFactura(idFactura, idCliente, precioTotal, fecha, activo));
                    }
				} catch (Exception e) {
					listaFacturas = null;
				}
				
			
			}
		}
		return listaFacturas;
	}
}