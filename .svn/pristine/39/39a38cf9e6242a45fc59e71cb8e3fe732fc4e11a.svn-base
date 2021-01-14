
package Presentación.Factura;

import javax.swing.JFrame;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.GUI;
import Presentación.ResourcesAccess;
import Presentación.ApplicationController.ApplicationController;

public class VistaFactura extends JFrame implements GUI{

	private static final long serialVersionUID = 1L;

	private static VistaFactura vista;
	
	private javax.swing.JButton abrir;
    private javax.swing.JButton buscar;
    private javax.swing.JButton devolucion;
    private javax.swing.JButton fondo;
    private javax.swing.JButton listar;
    private javax.swing.JButton pantallaPrincipal;
    private javax.swing.JLabel texabrir;
    private javax.swing.JLabel texbuscar;
    private javax.swing.JLabel texdevolucion;
    private javax.swing.JLabel texlistar;
	

	    public VistaFactura() {
	        super();
	        initGUI();
	    }
	    
	    public static VistaFactura getInstance()
	    {
	 	   if(vista == null)	vista =new VistaFactura();
	 	   vista.setVisible(true);
	 	   return vista;
	    }

                       
	    private void initGUI() {
	    	
	        texabrir = new javax.swing.JLabel();
	        texdevolucion = new javax.swing.JLabel();
	        texbuscar = new javax.swing.JLabel();
	        texlistar = new javax.swing.JLabel();
	        pantallaPrincipal = new javax.swing.JButton();
	        devolucion = new javax.swing.JButton();
	        buscar = new javax.swing.JButton();
	        abrir = new javax.swing.JButton();
	        listar = new javax.swing.JButton();
	        fondo = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        setTitle("Facturas");
	        setMinimumSize(new java.awt.Dimension(1187, 792));
	        setResizable(false);
	        getContentPane().setLayout(null);

	        texabrir.setFont(new java.awt.Font("Tahoma", 1, 36)); 
	        texabrir.setForeground(new java.awt.Color(255, 255, 255));
	        texabrir.setText("ABRIR");
	        getContentPane().add(texabrir);
	        texabrir.setBounds(170, 80, 120, 40);

	        texdevolucion.setFont(new java.awt.Font("Tahoma", 1, 36)); 
	        texdevolucion.setForeground(new java.awt.Color(255, 255, 255));
	        texdevolucion.setText("DEVOLUCIÓN");
	        getContentPane().add(texdevolucion);
	        texdevolucion.setBounds(440, 80, 260, 40);

	        texbuscar.setFont(new java.awt.Font("Tahoma", 1, 36)); 
	        texbuscar.setForeground(new java.awt.Color(255, 255, 255));
	        texbuscar.setText("BUSCAR");
	        getContentPane().add(texbuscar);
	        texbuscar.setBounds(830, 80, 170, 40);

	        texlistar.setFont(new java.awt.Font("Tahoma", 1, 36)); 
	        texlistar.setForeground(new java.awt.Color(255, 255, 255));
	        texlistar.setText("LISTAR");
	        getContentPane().add(texlistar);
	        texlistar.setBounds(500, 380, 140, 40);

	        pantallaPrincipal.setBackground(new java.awt.Color(255, 51, 51));
	        pantallaPrincipal.setFont(new java.awt.Font("Tahoma", 1, 18)); 
	        pantallaPrincipal.setText("Pantalla Principal");
	        pantallaPrincipal.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	dispose();
	         	   ApplicationController.getInstance().action(new Contexto(Evento.GUI_MOSTRAR, null));
	            }
	        });
	        getContentPane().add(pantallaPrincipal);
	        pantallaPrincipal.setBounds(930, 660, 210, 60);
	        

	        devolucion.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.AZUL_DIR))); 
	        devolucion.setBorderPainted(false);
	        devolucion.setContentAreaFilled(false);
	        devolucion.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	ApplicationController.getInstance().action(new Contexto(Evento.DEVOLUCION, null));
	            }
	        });
	        getContentPane().add(devolucion);
	        devolucion.setBounds(460, 130, 200, 200);

	        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.BLANCO_DIR))); // NOI18N
	        buscar.setBorderPainted(false);
	        buscar.setContentAreaFilled(false);
	        buscar.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	ApplicationController.getInstance().action(new Contexto(Evento.MOSTRAR_FACTURA, null));
	            }
	        });
	        getContentPane().add(buscar);
	        buscar.setBounds(800, 130, 200, 200);

	        abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.AMARILLO_DIR))); // NOI18N
	        abrir.setBorderPainted(false);
	        abrir.setContentAreaFilled(false);
	        abrir.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	ApplicationController.getInstance().action(new Contexto(Evento.ABRIR_FACTURA, null));
	            }
	        });
	        getContentPane().add(abrir);
	        abrir.setBounds(130, 130, 200, 200);

	        listar.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.VERDE_DIR))); // NOI18N
	        listar.setBorderPainted(false);
	        listar.setContentAreaFilled(false);
	        listar.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	ApplicationController.getInstance().action(new Contexto(Evento.LISTAR_FACTURA, null));
	            }
	        });
	        getContentPane().add(listar);
	        listar.setBounds(470, 430, 200, 200);

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
		public void update(Contexto contexto) {
			
		}

}