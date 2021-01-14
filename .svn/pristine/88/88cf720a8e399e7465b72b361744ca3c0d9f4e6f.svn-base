package Presentación.Cliente;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Cliente.TCliente;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.GUI;
import Presentación.ApplicationController.ApplicationController;

public class VistaModificarCliente extends JFrame implements GUI {

	private static final long serialVersionUID = 1L;
	
	JFrame datos;
	
	public VistaModificarCliente(){
		super();
		initGUI();
	}
	
	public void dispose(){
		datos.dispose();
	}
	
	private void initGUI(){
		datos = new JFrame("Datos");
		JPanel ventana = new JPanel();
		
		datos.setLocationRelativeTo(null);
		ventana.setLayout(new GridLayout(4, 2));
		
		JLabel ID = new JLabel("ID:");
		JLabel DNI = new JLabel("DNI:");
		JLabel nombre = new JLabel("Nombre:");
		
		JTextField textoID = new JTextField();
		JTextField textoDNI = new JTextField();
		JTextField textoNombre = new JTextField();
		
		ventana.add(ID);
		ventana.add(textoID);
		ventana.add(DNI);
		ventana.add(textoDNI);
		ventana.add(nombre);
		ventana.add(textoNombre);
		
		
		JButton hecho = new JButton("Hecho");
		hecho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					TCliente cliente = new TCliente(Integer.parseInt(textoID.getText()), textoNombre.getText(), true, textoDNI.getText());
					ApplicationController.getInstance().action(new Contexto(Evento.MODIFICAR_CLIENTE_OK, cliente));
					datos.dispose();
				}catch(NumberFormatException n){
					JOptionPane.showMessageDialog(new JFrame(), "Error en los datos", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datos.dispose();
				//setVisible(true);
			}
		});
		
		ventana.add(hecho);
		ventana.add(cancelar);
		datos.add(ventana);
		datos.setSize(200, 200);
		datos.setVisible(true);
		
	}
	
	
	
	@Override
	public void update(Contexto contexto) {
		if (contexto.getDato() != null){
			Integer id = (Integer)contexto.getDato();
			
			switch((int)contexto.getDato()){
				case -1: JOptionPane.showMessageDialog(new JFrame(),"El cliente es null", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -2: JOptionPane.showMessageDialog(new JFrame(),"El cliente no existe", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -3: JOptionPane.showMessageDialog(new JFrame(),"El cliente no está activo", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -5: JOptionPane.showMessageDialog(new JFrame(),"Ya existe un cliente con ese DNI", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -4: JOptionPane.showMessageDialog(new JFrame(),"Fallo transaccion", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -100: JOptionPane.showMessageDialog(new JFrame(),"Error en la gestion de la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				default:
					JOptionPane.showMessageDialog(new JFrame(),"Cliente con ID:  " + id.intValue() + " ha sido modificado" );
					break;
			}
		}
	}
	
	TCliente cliente;
	Integer idS;
	String dniS;
	String nombreS;
}
