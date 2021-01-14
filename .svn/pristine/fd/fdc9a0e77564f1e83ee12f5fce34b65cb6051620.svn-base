



package Integración.LineaFactura.Imp;

import Integración.LineaFactura.DAOLineaFactura;
import Integración.Transaction.Transaction;
import Integración.Transaction.TransactionManager;
import Negocio.LineaFactura.TLineaFactura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class DAOLineaFacturaImp implements DAOLineaFactura {
	
	public Integer alta(TLineaFactura lineaFactura) {
		Integer id=-1;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				
				try {
					
					PreparedStatement ps = connection.prepareStatement("INSERT INTO lineaFactura (idDIsco, idFactura, cantidad, precio) values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
				
					ps.setInt(1, lineaFactura.getIdDisco());
					ps.setInt(2, lineaFactura.getIdFactura());
					ps.setInt(3, lineaFactura.getCantidad());
					ps.setFloat(4, lineaFactura.getPrecio());
					ps.executeUpdate();
					
					id = 1;
				} catch (Exception e) {
					id = -100;
				}
			}
		}
	
		return id;
	}

	public Integer baja(Integer idDisco, Integer idFactura) {
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement state = connection.createStatement();
					state.executeUpdate("DELETE FROM lineaFactura WHERE idDisco = '" + idDisco + "' AND idFactura = '" + idFactura + "'");
					return 1;
				} catch (Exception e) {
					
				}
			}
			
		}
		return -1;
	}
	
	public TLineaFactura mostrar(Integer idDisco, Integer idFactura) {
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement state = connection.createStatement();
					ResultSet set = state.executeQuery( "SELECT * FROM lineaFactura WHERE idDisco = '" + idDisco + "' AND idFactura = '" + idFactura + "' FOR UPDATE ");

					if (set.next()) {
						Integer cantidad = set.getInt("cantidad");
						Float precio = set.getFloat("precio");
						return new TLineaFactura(idDisco, idFactura, cantidad, precio);
					}
				
				} catch (Exception e) {

				}
			}
		}
		return null;
	}

	public Integer modificar(TLineaFactura lineaFactura) {
		Integer id = -1;
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement state = connection.createStatement();
					state.executeUpdate("UPDATE lineaFactura SET cantidad = '" + lineaFactura.getCantidad() + 
							"', precio = '" + lineaFactura.getPrecio()  + 
							"' WHERE idDisco = '" + lineaFactura.getIdDisco() + "' AND idFactura = '" + lineaFactura.getIdFactura() + "'");
					id = 1;
				} catch (Exception e) {
			}
		}
		}
		return id;
	}

	public Collection<TLineaFactura> listar() {
		ArrayList<TLineaFactura>  listaLineasFactura = new ArrayList<>();
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement state = connection.createStatement();
					ResultSet set = state.executeQuery("SELECT * FROM lineaFactura");
					while (set.next()) {
						Integer idDisco = set.getInt("idDisco");
						Integer idFactura = set.getInt("idFactura");
						Integer cantidad = set.getInt("cantidad");
						Float precio = set.getFloat("precio");
						
						listaLineasFactura.add(new TLineaFactura(idDisco, idFactura, cantidad, precio));
                    }
				} catch (Exception e) {
					listaLineasFactura = null;
				}
			}
		}
		return listaLineasFactura;
	}

	public Collection<TLineaFactura> mostrarLineasFacturaPorIdDisco(Integer idDisco) {
		ArrayList<TLineaFactura>  listaLineasFactura = new ArrayList<>();
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement state = connection.createStatement();
					ResultSet set = state.executeQuery("SELECT * FROM lineaFactura WHERE idDisco = '" + idDisco + "'");
					while (set.next()) {
						Integer idFactura = set.getInt("idFactura");
						Integer cantidad = set.getInt("cantidad");
						Float precio = set.getFloat("precio");
						
						listaLineasFactura.add(new TLineaFactura(idDisco, idFactura, cantidad, precio));
                    }
				} catch (Exception e) {
					listaLineasFactura = null;
				}
			}
		}
		return listaLineasFactura;
	}

	public Collection<TLineaFactura> mostrarLineasFacturaPorIdFactura(Integer idFactura) {
		ArrayList<TLineaFactura>  listaLineasFactura = new ArrayList<>();
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement state = connection.createStatement();
					ResultSet set = state.executeQuery("SELECT * FROM lineaFactura WHERE idFactura = '" + idFactura + "'");
					while (set.next()) {
						Integer idDisco = set.getInt("idDisco");
						Integer cantidad = set.getInt("cantidad");
						Float precio = set.getFloat("precio");
						
						listaLineasFactura.add(new TLineaFactura(idDisco, idFactura, cantidad, precio));
                    }
				} catch (Exception e) {
					listaLineasFactura = null;
				}
			}
		}
		return listaLineasFactura;
	}
}