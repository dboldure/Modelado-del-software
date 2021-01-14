


package Integración.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;



public class TransactionMySQL implements Transaction {

	private final String ENLACE = "jdbc:mysql://localhost:3306/iesoft1";
	private final String USUARIO = "root";
	private final String PASS = "";
	
	private Connection con;


		
		public TransactionMySQL(){
			
			try {
				
				con = DriverManager.getConnection(ENLACE, USUARIO, PASS);
			} catch (Exception e) {
				con = null;
			}
		}

		public void start() {
			try {
				con.setAutoCommit(false);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}

		public void commit() {
			try {
				con.commit();
				con.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}

		public void rollback() {
			try {
				con.rollback();
				con.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}

		public Object getResource() {
			return con;
		}
	}
