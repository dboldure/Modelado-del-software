


package Integración.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Integración.Transaction.Transaction;
import Integración.Transaction.TransactionManager;
import Negocio.Disco.TDisco;
import Negocio.Disco.TDiscoCD;
import Negocio.Disco.TDiscoVinilo;


public class MostrarHistorialDeCompras implements Query {

	public Object execute(Object param) {
		Integer idCliente = (Integer) param;
		ArrayList<TDisco>  listaDiscos = new ArrayList<>();
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement state = connection.createStatement();
					
					ResultSet set = state.executeQuery("SELECT DISTINCT disco.id, disco.nombre, disco.año, disco.precio, disco.stock, disco.genero, disco.activo "
							+ "FROM ((disco INNER JOIN lineaFactura ON disco.id = lineaFactura.idDisco) "
							+ "INNER JOIN factura ON lineaFactura.idFactura = factura.id) "
							+ "INNER JOIN cliente ON factura.idCliente = cliente.id "
							+ "WHERE cliente.id = '" + idCliente + "'");
					
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
}