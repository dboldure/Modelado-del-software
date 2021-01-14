package Presentación.Empleado;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Negocio.Empleado.TEmpleado;
import Negocio.Empleado.TEmpleadoCompleto;
import Negocio.Empleado.TEmpleadoParcial;
import Presentación.Contexto;
import Presentación.GUI;

public class VistaListarEmpleado extends JFrame implements GUI {
	
	private static final long serialVersionUID = 1L;
	
private ArrayList<TEmpleado> empleados;
	
	JFrame datos;
	
	public VistaListarEmpleado(){
		super();
		initGUI();
	}
	
	
	private void initGUI(){
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void update(Contexto cont) {
		
		empleados = (ArrayList<TEmpleado>)cont.getDato();
		
		String stringEmpleados = "";
		if (empleados != null){
			
			for (TEmpleado empleado : empleados) {
				stringEmpleados += "ID: " + empleado.getId() + "\n" +
						"DNI: " + empleado.getDni() + "\n" +
						"Nombre: " + empleado.getNombre() + "\n" +
						"Teléfono: " + empleado.getTelefono() + "\n" +
						"Sueldo: " + empleado.getSueldo() + "\n" +
						"Activo: " + empleado.getActivo() + "\n" +
						"Departamento: " + empleado.getId() + "\n";
				if(empleado instanceof TEmpleadoParcial)
					stringEmpleados += "Horas/dia empleado parcial: " + ((TEmpleadoParcial)empleado).getHorasDia() + "\n\n";
				else
					stringEmpleados += "Horas/Semana empleado completo: " + ((TEmpleadoCompleto) empleado).getHorasSemana() + "\n\n";
			}
		}
		JFrame ventana = new JFrame("Datos");
		ventana.setLayout(new GridLayout());
		JPanel panel = new JPanel(new GridLayout());
		ventana.setLocationRelativeTo(null);
		ventana.setBounds(700, 480, 400, 310);
		JTextArea texto = new JTextArea(150, 150);
		texto.setText(stringEmpleados);
		texto.setEditable(false);
		panel.add(texto);
		ventana.add(panel);
		JScrollPane scroll = new JScrollPane(texto);
		panel.add(scroll);
		ventana.setVisible(true);
		
	}
}
