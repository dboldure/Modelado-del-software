package Presentación.Disco;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import Negocio.Cliente.TCliente;
import Negocio.Disco.TDisco;
import Negocio.Disco.TDiscoCD;
import Negocio.Disco.TDiscoVinilo;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.GUI;
import Presentación.ResourcesAccess;
import Presentación.ApplicationController.ApplicationController;

public class VistaListarDiscos extends JFrame implements GUI{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<TDisco> discos;
	
	JFrame datos;
	
	public VistaListarDiscos() {
        super();
        initGUI();
    }
	                     
	   private void initGUI() {

	      
	    }                      
               
	    
		@SuppressWarnings("unchecked")
		@Override
		public void update(Contexto cont) {
			
			ArrayList<TDisco> discos = (ArrayList<TDisco>)cont.getDato();
			
			String stringDiscos = "";
			if (discos != null){
				
				
				
				
				
				
				for (TDisco disco : discos) {
					stringDiscos += "ID: " + disco.getId() + "\n" +
							"Nombre: " + disco.getNombre() + "\n" +
							"Género: " + disco.getGenero() + "\n" +
							"Precio: " + disco.getPrecio() + "\n" +
							"Año: " + disco.getAño() + "\n" +
							"Stock: " + disco.getStock() + "\n";
					
							if (disco instanceof TDiscoCD){
								stringDiscos += "DVD: " + ((TDiscoCD) disco).getDvd() + "\n";
							}
							else {
								stringDiscos += "Prensado: " + ((TDiscoVinilo) disco).getPrensado() + "\n" +
								"Gramaje: " + ((TDiscoVinilo) disco).getGramaje() + "\n" +
								"Revoluciones: " + ((TDiscoVinilo) disco).getRevoluciones() + "\n";
							}
							stringDiscos += "Activo: " + disco.getActivo() + "\n\n";
				}
			}
			JFrame ventana = new JFrame("Datos");
			ventana.setLayout(new GridLayout());
			JPanel panel = new JPanel(new GridLayout());
			ventana.setLocationRelativeTo(null);
			ventana.setBounds(700, 480, 400, 310);
			JTextArea texto = new JTextArea(150, 150);
			texto.setText(stringDiscos);
			texto.setEditable(false);
			panel.add(texto);
			ventana.add(panel);
			JScrollPane scroll = new JScrollPane(texto);
			panel.add(scroll);
			ventana.setVisible(true);
			
			
		}
                 

}
