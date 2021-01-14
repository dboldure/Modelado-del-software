package Presentación.Departamento;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Presentación.Contexto;
import Presentación.Evento;
import Presentación.GUI;
import Presentación.ResourcesAccess;
import Presentación.ApplicationController.ApplicationController;

public class VistaBajaDepartamento extends JFrame implements GUI{

	private static final long serialVersionUID = 1L;
	
	private javax.swing.JButton cancelar;
    private javax.swing.JButton confirmar;
    private javax.swing.JButton fondo;
    private javax.swing.JTextField id;
    private javax.swing.JLabel textid;
	
	public VistaBajaDepartamento(){
		super();
		initGUI();
	}

	private void initGUI() {
		cancelar = new javax.swing.JButton();
        confirmar = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        textid = new javax.swing.JLabel();
        fondo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Baja Departamento");
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
        confirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if (id.getText() != null){
            		try{
            			ApplicationController.getInstance().action(new Contexto(Evento.BAJA_DEPARTAMENTO_OK, Integer.parseInt(id.getText())));
            		}catch(NumberFormatException n){
            			JOptionPane.showMessageDialog(new JFrame(), "Error en los datos", "Error", JOptionPane.ERROR_MESSAGE);
            			}
            		}
            	dispose();
            }
        });
        getContentPane().add(confirmar);
        confirmar.setBounds(930, 660, 210, 60);

        id.setFont(new java.awt.Font("Tahoma", 2, 24)); 
        id.setForeground(new java.awt.Color(153, 153, 153));

        getContentPane().add(id);
        id.setBounds(470, 310, 250, 100);

        textid.setFont(new java.awt.Font("Tahoma", 1, 48)); 
        textid.setForeground(new java.awt.Color(255, 255, 255));
        textid.setText("Dar de baja el departamento con id:");
        getContentPane().add(textid);
        textid.setBounds(140, 210, 890, 70);
        
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
				case -1: JOptionPane.showMessageDialog(new JFrame(),"No existe el departamento", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -2: JOptionPane.showMessageDialog(new JFrame(),"El departamento a dar de baja ya ha sido eliminado", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -3: JOptionPane.showMessageDialog(new JFrame(),"El departamento esta vinculado a una planta", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -4: JOptionPane.showMessageDialog(new JFrame(),"El departamento tiene empleados asignados", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -100: JOptionPane.showMessageDialog(new JFrame(),"Error en la gestion de la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				default:
					JOptionPane.showMessageDialog(new JFrame(), "Se dio de baja correctamente el departamento con id: " + id);
					break;
			}
		}
	}
}
