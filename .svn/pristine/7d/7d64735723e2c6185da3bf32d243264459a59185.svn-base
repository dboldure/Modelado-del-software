


package Integración.Cliente.Imp;

import Integración.Cliente.DAOCliente;
import Integración.Transaction.Transaction;
import Integración.Transaction.TransactionManager;
import Negocio.Cliente.TCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOClienteImp implements DAOCliente {
	
	public Integer alta(TCliente cliente) {
		Integer id=-1;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				
				try {
					
					PreparedStatement ps = connection.prepareStatement("INSERT INTO cliente(dni,nombre,activo) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
				
					ps.setString(1, cliente.getDni());
					ps.setString(2, cliente.getNombre());
					ps.setBoolean(3, cliente.getActivo());
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


	public Integer baja(Integer id) {
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement state = connection.createStatement();
					state.executeUpdate("UPDATE cliente SET activo = 0 WHERE id = '" + id + "'");
				} catch (Exception e) {
					
				}
			}
			
		}
		return id;
	}



	public Integer modificar(TCliente cliente) {
		Integer id = -1;
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement state = connection.createStatement();
					state.executeUpdate("UPDATE cliente SET DNI = '" + cliente.getDni() + "', nombre = '" + cliente.getNombre()  +  "', activo = 1 WHERE id = '" + cliente.getId() + "'");
					id = cliente.getId();
				} catch (Exception e) {
				}
			}
		}
		return id;

	}

	
	public TCliente mostrar(Integer id) {
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement state = connection.createStatement();
					ResultSet set = state.executeQuery( "SELECT * FROM cliente WHERE id = '" + id + "' FOR UPDATE ");

					if (set.next()) {
						String DNI = set.getString("DNI");
						String nombre = set.getString("nombre");
						boolean activo = set.getBoolean("activo");
						return new TCliente(id, nombre, activo, DNI);
					}
				
				} catch (Exception e) {

				}
			}
		}
		return null;
	}


	public ArrayList<TCliente> listar() {
		
		ArrayList<TCliente>  listaClientes = new ArrayList<>();
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement state = connection.createStatement();
					ResultSet set = state.executeQuery("SELECT * FROM cliente");
					while (set.next()) {
						Integer ID = set.getInt("id");
						String DNI = set.getString("DNI");
						String nombre = set.getString("nombre");
						boolean activo = set.getBoolean("activo");
						
						listaClientes.add(new TCliente(ID, nombre, activo, DNI));
                    }
				} catch (Exception e) {
					listaClientes = null;
				}
				
			
		}
		}
		return listaClientes;
	}


	public TCliente mostrarPorDni(String dni) {
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try{
					Statement state = connection.createStatement();
					ResultSet set = state.executeQuery( "SELECT * FROM cliente WHERE DNI = '" + dni + "' FOR UPDATE");

					if (set.next()) {
						Integer ID = set.getInt("id");
						String nombre = set.getString("nombre");
						boolean activo = set.getBoolean("activo");
						return new TCliente(ID, nombre, activo, dni);
					}

				} catch (Exception e) {
					
				}
			}

		}
		return null;
	
	}
}