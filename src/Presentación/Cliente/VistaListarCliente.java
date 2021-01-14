package Presentación.Cliente;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import Negocio.Cliente.TCliente;
import Presentación.Contexto;
import Presentación.GUI;

public class VistaListarCliente extends JFrame implements GUI {
	

	private static final long serialVersionUID = 1L;
	
	private ArrayList<TCliente> clientes;
	
	JFrame datos;
	
	public VistaListarCliente(){
		super();
		initGUI();
	}
	
	
	private void initGUI(){
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void update(Contexto cont) {
		
		clientes = (ArrayList<TCliente>)cont.getDato();
		
		String stringClientes = "";
		if (clientes != null){
			
			for (TCliente cliente : clientes) {
				stringClientes += "ID: " + cliente.getId() + "\n" +
						"DNI: " + cliente.getDni() + "\n" +
						"Nombre: " + cliente.getNombre() + "\n" +
						"Activo: " + cliente.getActivo() + "\n\n";
			}
		}
		JFrame ventana = new JFrame("Datos");
		ventana.setLayout(new GridLayout());
		JPanel panel = new JPanel(new GridLayout());
		ventana.setLocationRelativeTo(null);
		ventana.setBounds(700, 480, 400, 310);
		JTextArea texto = new JTextArea(150, 150);
		texto.setText(stringClientes);
		texto.setEditable(false);
		panel.add(texto);
		ventana.add(panel);
		JScrollPane scroll = new JScrollPane(texto);
		panel.add(scroll);
		ventana.setVisible(true);
		
	}
	

}
