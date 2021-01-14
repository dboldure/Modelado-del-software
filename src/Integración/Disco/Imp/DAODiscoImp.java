



package Integración.Disco.Imp;

import Integración.Disco.DAODisco;
import Integración.Transaction.Transaction;
import Integración.Transaction.TransactionManager;
import Negocio.Disco.TDisco;
import Negocio.Disco.TDiscoCD;
import Negocio.Disco.TDiscoVinilo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DAODiscoImp implements DAODisco {

	public Integer alta(TDisco disco) {
		Integer id=-1;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				
				try {
					
					PreparedStatement ps = connection.prepareStatement("INSERT INTO disco(nombre,año,precio,stock,genero,activo) values (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, disco.getNombre());
					ps.setInt(2, disco.getAño());
					ps.setFloat(3, disco.getPrecio());
					ps.setInt(4, disco.getStock());
					ps.setString(5, disco.getGenero());
					ps.setBoolean(6, disco.getActivo());
					ps.executeUpdate();
					
					ResultSet rs = ps.getGeneratedKeys();
					if(rs.next()){
						id = rs.getInt(1);
					}
					
					if (disco instanceof TDiscoCD){
						PreparedStatement ps2 = connection.prepareStatement("INSERT INTO discocd(id,dvd) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
						
						ps2.setInt(1, id);
						ps2.setBoolean(2, ((TDiscoCD) disco).getDvd());
						ps2.executeUpdate();
					}
					else{
						PreparedStatement ps2 = connection.prepareStatement("INSERT INTO discovinilo(id,revoluciones,gramaje,prensado) values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
						
						ps2.setInt(1, id);
						ps2.setInt(2, ((TDiscoVinilo) disco).getRevoluciones());
						ps2.setInt(3, ((TDiscoVinilo) disco).getGramaje());
						ps2.setString(4, ((TDiscoVinilo) disco).getPrensado());
						ps2.executeUpdate();
					}
					
					
				} catch (Exception e) {
					
				}
			}
		}
	
		return id;
	}
	
	public Integer baja(Integer id) {
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement state = connection.createStatement();
					state.executeUpdate("UPDATE disco SET activo = 0 WHERE id = '" + id + "'");
				} catch (Exception e) {
					
				}
			}
			
		}
		return id;
	}

	public Integer modificar(TDisco disco) {
		Integer id = -1;
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement state = connection.createStatement();
					state.executeUpdate("UPDATE disco SET nombre = '" + disco.getNombre() + "', año = '" + disco.getAño() + "', precio = '" + disco.getPrecio() + "', stock = '" + disco.getStock() + "', genero = '" + disco.getGenero()  +   "', activo = 1 WHERE id = '" + disco.getId() + "'");
					id = disco.getId();
					
					if (disco instanceof TDiscoCD){
						Statement state2 = connection.createStatement();
						state2.executeUpdate("UPDATE discocd SET dvd = " + ((TDiscoCD) disco).getDvd() + " WHERE id = '" + disco.getId() + "'");
					}
					else{
						Statement state3 = connection.createStatement();
						state3.executeUpdate("UPDATE discovinilo SET revoluciones = '" + ((TDiscoVinilo) disco).getRevoluciones() + "', gramaje = '" + ((TDiscoVinilo) disco).getGramaje() + "', prensado = '" + ((TDiscoVinilo) disco).getPrensado() + "' WHERE id = '" + disco.getId() + "'");
					}
	
				} catch (Exception e) {
				}
			}
		}
		return id;
	}

	public ArrayList<TDisco> listar() {
		ArrayList<TDisco>  listaDiscos = new ArrayList<>();
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement state = connection.createStatement();
					ResultSet set = state.executeQuery("SELECT * FROM disco");
					while (set.next()) {
						Integer id = set.getInt("id");
						String nombre = set.getString("nombre");
						Integer año = set.getInt("año");
						Float precio = set.getFloat("precio");
						Integer stock = set.getInt("stock");
						String genero = set.getString("genero");
						boolean activo = set.getBoolean("activo");
						
						Statement state2 = connection.createStatement();
						ResultSet set2 = state2.executeQuery( "SELECT * FROM discocd WHERE id = '" + id + "' FOR UPDATE ");
						if (set2.next()) {
							Boolean dvd = set2.getBoolean("dvd");
							listaDiscos.add(new TDiscoCD(id, nombre, año, precio, stock, genero, activo, dvd));
						}
						else {
							Statement state3 = connection.createStatement();
							ResultSet set3 = state3.executeQuery( "SELECT * FROM discovinilo WHERE id = '" + id + "' FOR UPDATE ");
							if (set3.next()) {
								Integer revoluciones = set3.getInt("revoluciones");
								Integer gramaje = set3.getInt("gramaje");
								String prensado = set3.getString("prensado");
								listaDiscos.add(new TDiscoVinilo(id, nombre, año, precio, stock, genero, activo, revoluciones, gramaje, prensado));
							}
						}
                    }
				} catch (Exception e) {
					listaDiscos = null;
				}
			}
		}
		return listaDiscos;
	}

	public TDisco mostrar(Integer id) {
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement state = connection.createStatement();
					ResultSet set = state.executeQuery( "SELECT * FROM disco WHERE id = '" + id + "' FOR UPDATE ");

					if (set.next()) {
						String nombre = set.getString("nombre");
						Integer año = set.getInt("año");
						Float precio = set.getFloat("precio");
						Integer stock = set.getInt("stock");
						String genero = set.getString("genero");
						boolean activo = set.getBoolean("activo");						

						Statement state2 = connection.createStatement();
						ResultSet set2 = state2.executeQuery( "SELECT * FROM discocd WHERE id = '" + id + "' FOR UPDATE ");
						if (set2.next()) {
							Boolean dvd = set2.getBoolean("dvd");
							return new TDiscoCD(id, nombre, año, precio, stock, genero, activo, dvd);
						}
						
						else {

							Statement state3 = connection.createStatement();
							ResultSet set3 = state3.executeQuery( "SELECT * FROM discovinilo WHERE id = '" + id + "' FOR UPDATE ");
							if (set3.next()) {
								Integer revoluciones = set3.getInt("revoluciones");
								Integer gramaje = set3.getInt("gramaje");
								String prensado = set3.getString("prensado");
								return new TDiscoVinilo(id, nombre, año, precio, stock, genero, activo, revoluciones, gramaje, prensado);
							}
						
						}
					}
				
				} catch (Exception e) {

				}
			}
		}
		return null;
	}
}