package Presentación.Planta;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Negocio.Planta.TPlanta;
import Presentación.Contexto;
import Presentación.GUI;

public class VistaListarPlanta extends JFrame implements GUI{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<TPlanta> plantas;
	
	JFrame datos;
	
	public VistaListarPlanta(){
		super();
		initGUI();
	}

	private void initGUI() {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Contexto cont) {
		plantas = (ArrayList<TPlanta>)cont.getDato();
		
		String stringPlantas = "";
		if(plantas != null){
			for(TPlanta planta : plantas){
				stringPlantas += "ID: " + planta.getId() + "\n" + 
						"Número: " + planta.getNumero() + "\n" +
						"Activo: " + planta.getActivo() + "\n\n";
			}
		}
		JFrame ventana = new JFrame("Datos");
		ventana.setLayout(new GridLayout());
		JPanel panel = new JPanel(new GridLayout());
		ventana.setLocationRelativeTo(null);
		ventana.setBounds(700, 480, 400, 310);
		JTextArea texto = new JTextArea(150, 150);
		texto.setText(stringPlantas);
		texto.setEditable(false);
		panel.add(texto);
		ventana.add(panel);
		JScrollPane scroll = new JScrollPane(texto);
		panel.add(scroll);
		ventana.setVisible(true);
		
	}

}
