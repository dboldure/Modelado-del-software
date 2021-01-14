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

import Negocio.Cliente.TCliente;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.GUI;
import Presentación.ResourcesAccess;
import Presentación.ApplicationController.ApplicationController;

public class VistaAltaCliente extends JFrame implements GUI{


	private static final long serialVersionUID = 1L;
	
	private JButton cancelar;
    private JButton confirmar;
    private JTextField dni;
    private JButton fondo;
    private JTextField nombre;
    private JLabel textdni;
    private JLabel textnombre;
    private JLabel textoinfo;
	
	public VistaAltaCliente(){
		super();
		initGUI();
	}

	
	
	private void initGUI(){
		
		cancelar = new JButton();
        confirmar = new JButton();
        nombre = new JTextField();
        dni = new JTextField();
        textnombre = new JLabel();
        textdni = new JLabel();
        textoinfo = new JLabel();
        fondo = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta Cliente");
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
            	try{
					TCliente cliente = new TCliente(null, nombre.getText(), true, dni.getText());
					ApplicationController.getInstance().action(new Contexto(Evento.ALTA_CLIENTE_OK, cliente));
					dispose();
				}catch(NumberFormatException n){
					JOptionPane.showMessageDialog(new JFrame(), "Error en los datos", "Error", JOptionPane.ERROR_MESSAGE);
				}
				dispose();
            }
		});
        getContentPane().add(confirmar);
        confirmar.setBounds(930, 660, 210, 60);

        nombre.setFont(new Font("Tahoma", 2, 24)); 
        nombre.setForeground(new Color(153, 153, 153));

        getContentPane().add(nombre);
        nombre.setBounds(560, 260, 250, 100);

        dni.setFont(new Font("Tahoma", 2, 24)); 
        dni.setForeground(new Color(153, 153, 153));

        getContentPane().add(dni);
        dni.setBounds(560, 380, 250, 100);

        textnombre.setFont(new Font("Tahoma", 1, 48)); 
        textnombre.setForeground(new Color(255, 255, 255));
        textnombre.setText("Nombre:");
        getContentPane().add(textnombre);
        textnombre.setBounds(330, 270, 210, 70);

        textdni.setFont(new java.awt.Font("Tahoma", 1, 48)); 
        textdni.setForeground(new Color(255, 255, 255));
        textdni.setText("DNI:");
        getContentPane().add(textdni);
        textdni.setBounds(330, 390, 210, 70);

        textoinfo.setFont(new java.awt.Font("Tahoma", 1, 48)); 
        textoinfo.setForeground(new Color(255, 255, 255));
        textoinfo.setText("Dar de alta al cliente:");
        getContentPane().add(textoinfo);
        textoinfo.setBounds(350, 120, 530, 70);

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
				case -1: JOptionPane.showMessageDialog(new JFrame(),"El cliente es nulo", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -2: JOptionPane.showMessageDialog(new JFrame(),"Error sintactico", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -3: JOptionPane.showMessageDialog(new JFrame(),"El cliente ya esta dado de alta", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -100: JOptionPane.showMessageDialog(new JFrame(),"Error en la gestion de la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				default:
					JOptionPane.showMessageDialog(new JFrame(),"Cliente creado con ID : " + id.intValue());
					break;
			}
		}
		
	}

}
