package Presentación.Planta;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Presentación.Contexto;
import Presentación.Evento;
import Presentación.GUI;
import Presentación.ResourcesAccess;
import Presentación.ApplicationController.ApplicationController;

public class VistaVincularDepartamento extends JFrame implements GUI{
		
	private static final long serialVersionUID = 1L;
	
	private javax.swing.JButton cancelar;
	private javax.swing.JButton confirmar;
	private javax.swing.JTextField metros;
	private javax.swing.JTextField depart;
	private javax.swing.JButton fondo;
	private javax.swing.JTextField planta;
	private javax.swing.JLabel textmetros;
	private javax.swing.JLabel textdepart;
	private javax.swing.JLabel textoinfo;
	private javax.swing.JLabel textplanta;
	
	public VistaVincularDepartamento(){
		super();
		initGUI();
	}

	private void initGUI() {
		    cancelar = new javax.swing.JButton();
	        confirmar = new javax.swing.JButton();
	        metros = new javax.swing.JTextField();
	        depart = new javax.swing.JTextField();
	        planta = new javax.swing.JTextField();
	        textmetros = new javax.swing.JLabel();
	        textdepart = new javax.swing.JLabel();
	        textplanta = new javax.swing.JLabel();
	        textoinfo = new javax.swing.JLabel();
	        fondo = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        setTitle("Vincular Departamento");
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
	            	if (planta.getText() != null && depart.getText()!= null){
	            		try{
	            			Vector<Object> ids = new Vector<Object>();
	            		
	            			ids.add(0, Integer.parseInt(planta.getText()));
	            			ids.add(1, Integer.parseInt(depart.getText()));
	            			ids.add(2, Float.parseFloat(metros.getText()));
	            			ApplicationController.getInstance().action(new Contexto(Evento.VINCULAR_DEPARTAMENTO_OK, ids));
	            		}catch(NumberFormatException n){
	            			JOptionPane.showMessageDialog(new JFrame(), "Error en los datos", "Error", JOptionPane.ERROR_MESSAGE);
	            			}
	            		}
	            	dispose();
	            }
	        });
	        getContentPane().add(confirmar);
	        confirmar.setBounds(930, 660, 210, 60);

	        depart.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        depart.setForeground(new java.awt.Color(153, 153, 153));
	        
	        getContentPane().add(depart);
	        depart.setBounds(650, 230, 250, 100);

	        planta.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        planta.setForeground(new java.awt.Color(153, 153, 153));
	        
	        getContentPane().add(planta);
	        planta.setBounds(650, 360, 250, 100);
	        
	        metros.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        metros.setForeground(new java.awt.Color(153, 153, 153));
	        
	        getContentPane().add(metros);
	        metros.setBounds(650, 490, 250, 100);

	        textdepart.setFont(new java.awt.Font("Tahoma", 1, 48));
	        textdepart.setForeground(new java.awt.Color(255, 255, 255));
	        textdepart.setText("Id departamento:");
	        getContentPane().add(textdepart);
	        textdepart.setBounds(190, 240, 440, 70);

	        textplanta.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textplanta.setForeground(new java.awt.Color(255, 255, 255));
	        textplanta.setText("Id planta:");
	        getContentPane().add(textplanta);
	        textplanta.setBounds(190, 370, 250, 70);
	        
	        textmetros.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textmetros.setForeground(new java.awt.Color(255, 255, 255));
	        textmetros.setText("Metros:");
	        getContentPane().add(textmetros);
	        textmetros.setBounds(190, 500, 250, 70);

	        textoinfo.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textoinfo.setForeground(new java.awt.Color(255, 255, 255));
	        textoinfo.setText("Vincular el departamento a la planta:");
	        getContentPane().add(textoinfo);
	        textoinfo.setBounds(100, 120, 1040, 70);
        
	        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.FONDO_MADERA_DIR))); 
	        fondo.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.FONDO_MADERA_DIR))); 
	        fondo.setEnabled(false);
	        fondo.setMaximumSize(new java.awt.Dimension(1187, 792));
	        fondo.setMinimumSize(new java.awt.Dimension(1187, 792));
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
		
			switch(id){
				case -1: JOptionPane.showMessageDialog(new JFrame(),"Valores null", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -2: JOptionPane.showMessageDialog(new JFrame(),"Metros no válidos", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -3: JOptionPane.showMessageDialog(new JFrame(),"La planta no existe", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -4: JOptionPane.showMessageDialog(new JFrame(),"La planta no esta activa", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -5: JOptionPane.showMessageDialog(new JFrame(),"El departamento no existe", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -6: JOptionPane.showMessageDialog(new JFrame(),"El departamento no esta activo", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -7: JOptionPane.showMessageDialog(new JFrame(),"Ya estaban vinculados", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -100: JOptionPane.showMessageDialog(new JFrame(),"Error en la gestion de la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				default:
					JOptionPane.showMessageDialog(new JFrame(),"Vinculados con éxito");
					break;
			}
		}
		
	}
}
