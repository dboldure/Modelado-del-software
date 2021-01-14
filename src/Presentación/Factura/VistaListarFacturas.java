package Presentación.Factura;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Negocio.Factura.TFactura;
import Presentación.Contexto;
import Presentación.GUI;

public class VistaListarFacturas extends JFrame implements GUI{

	private static final long serialVersionUID = 1L;
	
		private ArrayList<TFactura> facturas;
		JFrame datos;

		public VistaListarFacturas() {
	        super();
	        initGUI();
	    }
                          
	    private void initGUI() {
	    	
	    	
	    	
	       
	    }                       

                    
	   
	    
		@SuppressWarnings("unchecked")
		@Override
		public void update(Contexto cont) {
			facturas = (ArrayList<TFactura>)cont.getDato();
			
			String stringFactura = "";
			if (facturas != null){
				for(TFactura factura : facturas){
					stringFactura += "ID: " + factura.getId() + "\n" +
							"ID Cliente: " + factura.getIdCliente() + "\n" +
							"Precio: " + factura.getPrecioTotal() + "\n" + 
							"Fecha: " + factura.getFecha() + "\n\n";
							//"Activo: " + factura.getActivo() + "\n\n";
				}
			}
			
			JFrame ventana = new JFrame("Datos");
			ventana.setLayout(new GridLayout());
			JPanel panel = new JPanel(new GridLayout());
			ventana.setLocationRelativeTo(null);
			ventana.setBounds(700, 480, 400, 310);
			JTextArea texto = new JTextArea(150,150);
			texto.setText(stringFactura);
			texto.setEditable(false);
			panel.add(texto);
			ventana.add(panel);
			JScrollPane scroll = new JScrollPane(texto);
			panel.add(scroll);
			ventana.setVisible(true);
		}

}
