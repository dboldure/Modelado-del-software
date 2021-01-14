

package Integración.Query;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import Integración.Transaction.Transaction;
import Integración.Transaction.TransactionManager;
import Negocio.Disco.TDisco;
import Negocio.Disco.TDiscoCD;
import Negocio.Disco.TDiscoVinilo;


public class ListarDiscosVendidos implements Query {
	
	public Object execute(Object param) {
		@SuppressWarnings("unchecked")
		ArrayList<Date> fechas = (ArrayList<Date>) param;
		Date fecha1 = fechas.get(0);
		Date fecha2 = fechas.get(1);
		ArrayList<TDisco>  listaDiscos = new ArrayList<>();
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaccion();
		
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement state = connection.createStatement();
					ResultSet set = state.executeQuery("SELECT DISTINCT disco.id, disco.nombre, disco.año, disco.precio, disco.stock, disco.genero, disco.activo "
							+ "FROM (disco JOIN lineaFactura ON disco.id = lineaFactura.idDisco) "
							+ "JOIN factura ON lineaFactura.idFactura = factura.id "
							+ "WHERE factura.fecha BETWEEN '"+ fecha1 +"' AND '"+ fecha2 +"';");
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
							Boolean dvd = set2.getBoolean("DVD");
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