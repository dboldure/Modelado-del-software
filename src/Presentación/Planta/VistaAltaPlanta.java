package Presentación.Planta;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Negocio.Planta.TPlanta;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.GUI;
import Presentación.ResourcesAccess;
import Presentación.ApplicationController.ApplicationController;


public class VistaAltaPlanta extends JFrame implements GUI {

	private static final long serialVersionUID = 1L;
	
	private javax.swing.JButton cancelar;
    private javax.swing.JButton confirmar;
    private javax.swing.JButton fondo;
    private javax.swing.JTextField numero;
    private javax.swing.JLabel textnumero;
    private javax.swing.JLabel textoinfo;
	
	public VistaAltaPlanta(){
		super();
		initGUI();
	}

	private void initGUI() {
		cancelar = new javax.swing.JButton();
        confirmar = new javax.swing.JButton();
        numero = new javax.swing.JTextField();
        textnumero = new javax.swing.JLabel();
        textoinfo = new javax.swing.JLabel();
        fondo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta Planta");
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
					TPlanta planta = new TPlanta(null,Integer.parseInt(numero.getText()),true);
					ApplicationController.getInstance().action(new Contexto(Evento.ALTA_PLANTA_OK, planta));
					dispose();
				}catch(NumberFormatException n){
					JOptionPane.showMessageDialog(new JFrame(), "Error en los datos", "Error", JOptionPane.ERROR_MESSAGE);
				}
				dispose();
            }
        });
        getContentPane().add(confirmar);
        confirmar.setBounds(930, 660, 210, 60);

        numero.setFont(new java.awt.Font("Tahoma", 2, 24)); 
        numero.setForeground(new java.awt.Color(153, 153, 153));
        
        getContentPane().add(numero);
        numero.setBounds(580, 310, 250, 100);

        textnumero.setFont(new java.awt.Font("Tahoma", 1, 48));
        textnumero.setForeground(new java.awt.Color(255, 255, 255));
        textnumero.setText("Número:");
        getContentPane().add(textnumero);
        textnumero.setBounds(340, 320, 240, 70);

        textoinfo.setFont(new java.awt.Font("Tahoma", 1, 48)); 
        textoinfo.setForeground(new java.awt.Color(255, 255, 255));
        textoinfo.setText("Dar de alta una planta:");
        getContentPane().add(textoinfo);
        textoinfo.setBounds(310, 110, 570, 70);

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
		
			switch((int)cont.getDato()){
				case -1: JOptionPane.showMessageDialog(new JFrame(),"La planta es nula", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -2: JOptionPane.showMessageDialog(new JFrame(),"La planta ya esta dada de alta", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -100: JOptionPane.showMessageDialog(new JFrame(),"Error en la gestion de la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				default:
					JOptionPane.showMessageDialog(new JFrame(),"Planta creada con ID : " + id.intValue());
					break;
			}
		}
		
	}


}
