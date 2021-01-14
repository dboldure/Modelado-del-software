package Presentación.Departamento;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Negocio.Departamento.TDepartamento;
import Presentación.Contexto;
import Presentación.GUI;

public class VistaListarDepartamento extends JFrame implements GUI{

	private static final long serialVersionUID = 1L;
	
	private ArrayList<TDepartamento> departamentos;
	JFrame datos;
	
	public VistaListarDepartamento(){
		super();
		initGUI();
	}

	private void initGUI() {
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public void update(Contexto cont) {
		departamentos = (ArrayList<TDepartamento>)cont.getDato();
		String stringDepartamentos = "";
		if(departamentos != null){
			for(TDepartamento departamento : departamentos){
				stringDepartamentos += "ID: " + departamento.getId() + "\n" +
						"Nombre: " + departamento.getNombre() + "\n" + 
						"Activo: " + departamento.getActivo() + "\n" +
						"Teléfono: " + departamento.getTelefono() + "\n\n";
			}
		}
		JFrame ventana = new JFrame("Datos");
		ventana.setLayout(new GridLayout());
		JPanel panel = new JPanel(new GridLayout());
		ventana.setLocationRelativeTo(null);
		ventana.setBounds(700, 480, 400, 310);
		JTextArea texto = new JTextArea(150, 150);
		texto.setText(stringDepartamentos);
		texto.setEditable(false);
		panel.add(texto);
		ventana.add(panel);
		JScrollPane scroll = new JScrollPane(texto);
		panel.add(scroll);
		ventana.setVisible(true);
	}
}
