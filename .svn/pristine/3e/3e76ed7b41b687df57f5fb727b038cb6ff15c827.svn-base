
package Presentación.Cliente;

import javax.swing.JFrame;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.GUI;
import Presentación.ResourcesAccess;
import Presentación.ApplicationController.ApplicationController;


public class VistaCliente extends JFrame implements GUI{
	
	private static VistaCliente vista;

    private static final long serialVersionUID = 1L;
   
    private javax.swing.JButton alta;
    private javax.swing.JButton baja;
    private javax.swing.JButton fondo;
    private javax.swing.JButton historial;
    private javax.swing.JButton listar;
    private javax.swing.JButton modificar;
    private javax.swing.JButton mostrar;
    private javax.swing.JButton pantallaPrincipal;
    private javax.swing.JLabel texalta;
    private javax.swing.JLabel texbaja;
    private javax.swing.JLabel texhistorial;
    private javax.swing.JLabel texhistorial1;
    private javax.swing.JLabel texlistar;
    private javax.swing.JLabel texmodificar;
    private javax.swing.JLabel texmostrar;
   
    public VistaCliente(){
		super();
		initGUI();
	}
   
   public static VistaCliente getInstance()
   {
	   if(vista == null)	vista =new VistaCliente();
	   vista.setVisible(true);
	   return vista;
   }
   
   public void initGUI(){
	   texalta = new javax.swing.JLabel();
       texbaja = new javax.swing.JLabel();
       texmodificar = new javax.swing.JLabel();
       texmostrar = new javax.swing.JLabel();
       texhistorial = new javax.swing.JLabel();
       texhistorial1 = new javax.swing.JLabel();
       texlistar = new javax.swing.JLabel();
       pantallaPrincipal = new javax.swing.JButton();
       baja = new javax.swing.JButton();
       modificar = new javax.swing.JButton();
       alta = new javax.swing.JButton();
       mostrar = new javax.swing.JButton();
       listar = new javax.swing.JButton();
       historial = new javax.swing.JButton();
       fondo = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
       setTitle("Cliente");
       setMinimumSize(new java.awt.Dimension(1187, 792));
       setResizable(false);
       getContentPane().setLayout(null);

       texalta.setFont(new java.awt.Font("Tahoma", 1, 36)); 
       texalta.setForeground(new java.awt.Color(255, 255, 255));
       texalta.setText("ALTA");
       getContentPane().add(texalta);
       texalta.setBounds(180, 80, 100, 40);

       texbaja.setFont(new java.awt.Font("Tahoma", 1, 36)); 
       texbaja.setForeground(new java.awt.Color(255, 255, 255));
       texbaja.setText("BAJA");
       getContentPane().add(texbaja);
       texbaja.setBounds(510, 80, 100, 40);

       texmodificar.setFont(new java.awt.Font("Tahoma", 1, 36)); 
       texmodificar.setForeground(new java.awt.Color(255, 255, 255));
       texmodificar.setText("MODIFICAR");
       getContentPane().add(texmodificar);
       texmodificar.setBounds(800, 80, 220, 40);

       texmostrar.setFont(new java.awt.Font("Tahoma", 1, 36)); 
       texmostrar.setForeground(new java.awt.Color(255, 255, 255));
       texmostrar.setText("MOSTRAR");
       getContentPane().add(texmostrar);
       texmostrar.setBounds(140, 380, 190, 40);

       texhistorial.setFont(new java.awt.Font("Tahoma", 1, 36)); 
       texhistorial.setForeground(new java.awt.Color(255, 255, 255));
       texhistorial.setText("HISTORIAL");
       getContentPane().add(texhistorial);
       texhistorial.setBounds(800, 350, 220, 40);

       texhistorial1.setFont(new java.awt.Font("Tahoma", 1, 36)); 
       texhistorial1.setForeground(new java.awt.Color(255, 255, 255));
       texhistorial1.setText("DE COMPRAS");
       getContentPane().add(texhistorial1);
       texhistorial1.setBounds(780, 390, 250, 40);

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

       baja.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.AZUL_DIR))); 
       baja.setBorderPainted(false);
       baja.setContentAreaFilled(false);
       baja.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
        	   ApplicationController.getInstance().action(new Contexto(Evento.BAJA_CLIENTE, null));
           }
       });
       getContentPane().add(baja);
       baja.setBounds(460, 130, 200, 200);

       modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.BLANCO_DIR))); 
       modificar.setBorderPainted(false);
       modificar.setContentAreaFilled(false);
       modificar.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
        	   ApplicationController.getInstance().action(new Contexto(Evento.MODIFICAR_CLIENTE, null));
           }
       });
       getContentPane().add(modificar);
       modificar.setBounds(800, 130, 200, 200);

       alta.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.AMARILLO_DIR))); 
       alta.setBorderPainted(false);
       alta.setContentAreaFilled(false);
       alta.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
        	   ApplicationController.getInstance().action(new Contexto(Evento.ALTA_CLIENTE, null));
           }
       });
       getContentPane().add(alta);
       alta.setBounds(130, 130, 200, 200);

       mostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.MORADO_DIR))); 
       mostrar.setBorderPainted(false);
       mostrar.setContentAreaFilled(false);
       mostrar.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
        	   ApplicationController.getInstance().action(new Contexto(Evento.MOSTRAR_CLIENTE, null));
           }
       });
       getContentPane().add(mostrar);
       mostrar.setBounds(130, 430, 200, 200);

       listar.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.VERDE_DIR))); 
       listar.setBorderPainted(false);
       listar.setContentAreaFilled(false);
       listar.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
        	   ApplicationController.getInstance().action(new Contexto(Evento.LISTAR_CLIENTE_OK, null));
           }
       });
       getContentPane().add(listar);
       listar.setBounds(470, 430, 200, 200);

       historial.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.ROJO_DIR))); 
       historial.setBorderPainted(false);
       historial.setContentAreaFilled(false);
       historial.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
        	   ApplicationController.getInstance().action(new Contexto(Evento.MOSTRAR_HISTORIAL_COMPRA, null));
           }
       });
       getContentPane().add(historial);
       historial.setBounds(800, 430, 200, 200);

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