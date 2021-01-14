package Presentación.Departamento;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Negocio.Departamento.TDepartamento;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.GUI;
import Presentación.ResourcesAccess;
import Presentación.ApplicationController.ApplicationController;

public class VistaAltaDepartamento extends JFrame implements GUI{

	private static final long serialVersionUID = 1L;
	
	private javax.swing.JButton cancelar;
    private javax.swing.JTextField telefono;
    private javax.swing.JButton confirmar;
    private javax.swing.JButton fondo;
    private javax.swing.JTextField nombre;
    private javax.swing.JLabel texttelefono;
    private javax.swing.JLabel textnombre;
    private javax.swing.JLabel textoinfo;
	
	public VistaAltaDepartamento(){
		super();
		initGUI();
	}

	private void initGUI() {
		cancelar = new javax.swing.JButton();
        confirmar = new javax.swing.JButton();
        nombre = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        textnombre = new javax.swing.JLabel();
        texttelefono = new javax.swing.JLabel();
        textoinfo = new javax.swing.JLabel();
        fondo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta Departamento");
        setMinimumSize(new java.awt.Dimension(1187, 792));
        setResizable(false);
        getContentPane().setLayout(null);

        cancelar.setBackground(new java.awt.Color(255, 51, 51));
        cancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });
        getContentPane().add(cancelar);
        cancelar.setBounds(690, 660, 210, 60);

        confirmar.setBackground(new java.awt.Color(0, 204, 51));
        confirmar.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        confirmar.setText("Confirmar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try{
            		if(nombre.getText().equals("") || telefono.getText().equals("")) throw new NumberFormatException();
					TDepartamento departamento = new TDepartamento(nombre.getText(),telefono.getText(),true);
					ApplicationController.getInstance().action(new Contexto(Evento.ALTA_DEPARTAMENTO_OK,departamento));
					dispose();
				}catch(NumberFormatException n){
					JOptionPane.showMessageDialog(new JFrame(), "Error en los datos", "Error", JOptionPane.ERROR_MESSAGE);
				}
				dispose();
            }
        });
        getContentPane().add(confirmar);
        confirmar.setBounds(930, 660, 210, 60);

        nombre.setFont(new java.awt.Font("Tahoma", 2, 24)); 
        nombre.setForeground(new java.awt.Color(153, 153, 153));
       
        getContentPane().add(nombre);
        nombre.setBounds(570, 220, 250, 100);

        telefono.setFont(new java.awt.Font("Tahoma", 2, 24));
        telefono.setForeground(new java.awt.Color(153, 153, 153));
        
        getContentPane().add(telefono);
        telefono.setBounds(570, 360, 250, 100);

        textnombre.setFont(new java.awt.Font("Tahoma", 1, 48)); 
        textnombre.setForeground(new java.awt.Color(255, 255, 255));
        textnombre.setText("Nombre:");
        getContentPane().add(textnombre);
        textnombre.setBounds(260, 240, 260, 70);

        texttelefono.setFont(new java.awt.Font("Tahoma", 1, 48)); 
        texttelefono.setForeground(new java.awt.Color(255, 255, 255));
        texttelefono.setText("Teléfono:");
        getContentPane().add(texttelefono);
        texttelefono.setBounds(260, 370, 280, 70);

        textoinfo.setFont(new java.awt.Font("Tahoma", 1, 48)); 
        textoinfo.setForeground(new java.awt.Color(255, 255, 255));
        textoinfo.setText("Dar de alta un nuevo departamento:");
        textoinfo.setToolTipText("");
        getContentPane().add(textoinfo);
        textoinfo.setBounds(140, 90, 920, 70);
        
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
	public void update(Contexto cont) {
		if (cont.getDato() != null){
			Integer id = (Integer)cont.getDato();
		
			switch((int)cont.getDato()){
				case -1: JOptionPane.showMessageDialog(new JFrame(),"El departamento es nulo", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -2: JOptionPane.showMessageDialog(new JFrame(),"Error sintactico", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -3: JOptionPane.showMessageDialog(new JFrame(),"El departamento ya esta dado de alta", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -100: JOptionPane.showMessageDialog(new JFrame(),"Error en la gestion de la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				default:
					JOptionPane.showMessageDialog(new JFrame(),"Departamento creado con ID : " + id.intValue());
					break;
			}
		}
		
	}
}
