package Presentación.Cliente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Presentación.Contexto;
import Presentación.Evento;
import Presentación.GUI;
import Presentación.ResourcesAccess;
import Presentación.ApplicationController.ApplicationController;

public class VistaBajaCliente extends JFrame implements GUI{

	private static final long serialVersionUID = 1L;
	
	 private JButton cancelar;
	 private JButton confirmar;
	 private JButton fondo;
	 private JTextField id;
	 private JLabel textid;
	 
	public VistaBajaCliente(){
		super();
		initGUI();
	}
	
	private void initGUI(){
		
		cancelar = new JButton();
        confirmar = new JButton();
        id = new JTextField();
        textid = new JLabel();
        fondo = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Baja Cliente");
        setMinimumSize(new Dimension(1187, 792));
        setResizable(false);
        getContentPane().setLayout(null);

        cancelar.setBackground(new Color(255, 51, 51));
        cancelar.setFont(new Font("Tahoma", 1, 18)); 
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });
        getContentPane().add(cancelar);
        cancelar.setBounds(690, 660, 210, 60);

        confirmar.setBackground(new Color(0, 204, 51));
        confirmar.setFont(new Font("Tahoma", 1, 18));
        confirmar.setText("Confirmar");
        confirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if (id.getText() != null){
            		try{
            			ApplicationController.getInstance().action(new Contexto(Evento.BAJA_CLIENTE_OK, Integer.parseInt(id.getText())));
            		}catch(NumberFormatException n){
            			JOptionPane.showMessageDialog(new JFrame(), "Error en los datos", "Error", JOptionPane.ERROR_MESSAGE);
            			}
            		}
            	dispose();
            }
        });
        getContentPane().add(confirmar);
        confirmar.setBounds(930, 660, 210, 60);

        id.setFont(new Font("Tahoma", 2, 24)); 
        id.setForeground(new Color(153, 153, 153));
        
        getContentPane().add(id);
        id.setBounds(470, 310, 250, 100);

        textid.setFont(new Font("Tahoma", 1, 48)); 
        textid.setForeground(new Color(255, 255, 255));
        textid.setText("Dar de baja al cliente con id:");
        getContentPane().add(textid);
        textid.setBounds(260, 210, 710, 70);

        fondo.setIcon(new ImageIcon(getClass().getResource(ResourcesAccess.FONDO_MADERA_DIR)));
        fondo.setDisabledIcon(new ImageIcon(getClass().getResource(ResourcesAccess.FONDO_MADERA_DIR)));
        fondo.setEnabled(false);
        fondo.setMaximumSize(new Dimension(1187, 792));
        fondo.setMinimumSize(new Dimension(1187, 792));
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 1190, 760);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
	@Override
	public void update(Contexto contexto) {
		
		if (contexto.getDato() != null){
			Integer id = (Integer)contexto.getDato();
		
			switch((int)contexto.getDato()){
				case -1: JOptionPane.showMessageDialog(new JFrame(),"Error sintactico", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -2: JOptionPane.showMessageDialog(new JFrame(),"El cliente a dar de baja no existe", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -3: JOptionPane.showMessageDialog(new JFrame(),"El cliente a dar de baja ya ha sido eliminado", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -100: JOptionPane.showMessageDialog(new JFrame(),"Error en la gestion de la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				default:
					JOptionPane.showMessageDialog(new JFrame(), "Se dio de baja correctamente el cliente con id: " + id);
					break;
			}
		}
		
	}
	
}
