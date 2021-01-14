package Presentación.Planta;

import javax.swing.JFrame;

import Presentación.Contexto;
import Presentación.Evento;
import Presentación.GUI;
import Presentación.ResourcesAccess;
import Presentación.ApplicationController.ApplicationController;

public class VistaPlanta extends JFrame implements GUI {


	private static final long serialVersionUID = 1L;
	
	private javax.swing.JButton alta;
    private javax.swing.JButton baja;
    private javax.swing.JButton desvincular;
    private javax.swing.JButton fondo;
    private javax.swing.JButton listar;
    private javax.swing.JButton modificar;
    private javax.swing.JButton mostrar;
    private javax.swing.JButton pantallaPrincipal;
    private javax.swing.JLabel texalta;
    private javax.swing.JLabel texbaja;
    private javax.swing.JLabel texdepartamento;
    private javax.swing.JLabel texdespart;
    private javax.swing.JLabel texdesvincular;
    private javax.swing.JLabel texlistar;
    private javax.swing.JLabel texmodificar;
    private javax.swing.JLabel texmostrar;
    private javax.swing.JLabel texvincular;
    private javax.swing.JButton vincular;
    
    public VistaPlanta(){
    	super();
    	initGUI();
    }

	private void initGUI() {
        texalta = new javax.swing.JLabel();
        texbaja = new javax.swing.JLabel();
        texmodificar = new javax.swing.JLabel();
        texmostrar = new javax.swing.JLabel();
        texlistar = new javax.swing.JLabel();
        texvincular = new javax.swing.JLabel();
        texdesvincular = new javax.swing.JLabel();
        texdespart = new javax.swing.JLabel();
        texdepartamento = new javax.swing.JLabel();
        pantallaPrincipal = new javax.swing.JButton();
        baja = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        alta = new javax.swing.JButton();
        mostrar = new javax.swing.JButton();
        listar = new javax.swing.JButton();
        desvincular = new javax.swing.JButton();
        vincular = new javax.swing.JButton();
        fondo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Planta");
        setMinimumSize(new java.awt.Dimension(1187, 792));
        setResizable(false);
        getContentPane().setLayout(null);

        texalta.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        texalta.setForeground(new java.awt.Color(255, 255, 255));
        texalta.setText("ALTA");
        getContentPane().add(texalta);
        texalta.setBounds(180, 80, 100, 40);

        texbaja.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        texbaja.setForeground(new java.awt.Color(255, 255, 255));
        texbaja.setText("BAJA");
        getContentPane().add(texbaja);
        texbaja.setBounds(510, 80, 100, 40);

        texmodificar.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        texmodificar.setForeground(new java.awt.Color(255, 255, 255));
        texmodificar.setText("MODIFICAR");
        getContentPane().add(texmodificar);
        texmodificar.setBounds(800, 80, 220, 40);

        texmostrar.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        texmostrar.setForeground(new java.awt.Color(255, 255, 255));
        texmostrar.setText("MOSTRAR");
        getContentPane().add(texmostrar);
        texmostrar.setBounds(50, 380, 190, 40);

        texlistar.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        texlistar.setForeground(new java.awt.Color(255, 255, 255));
        texlistar.setText("LISTAR");
        getContentPane().add(texlistar);
        texlistar.setBounds(330, 380, 140, 40);

        texvincular.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        texvincular.setForeground(new java.awt.Color(255, 255, 255));
        texvincular.setText("VINCULAR");
        getContentPane().add(texvincular);
        texvincular.setBounds(590, 350, 200, 40);

        texdesvincular.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        texdesvincular.setForeground(new java.awt.Color(255, 255, 255));
        texdesvincular.setText("DESVINCULAR");
        getContentPane().add(texdesvincular);
        texdesvincular.setBounds(880, 350, 270, 40);

        texdespart.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        texdespart.setForeground(new java.awt.Color(255, 255, 255));
        texdespart.setText("DEPARTAMENTO");
        getContentPane().add(texdespart);
        texdespart.setBounds(860, 390, 310, 40);

        texdepartamento.setFont(new java.awt.Font("Tahoma", 1, 36));
        texdepartamento.setForeground(new java.awt.Color(255, 255, 255));
        texdepartamento.setText("DEPARTAMENTO");
        getContentPane().add(texdepartamento);
        texdepartamento.setBounds(530, 390, 310, 40);

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
            	ApplicationController.getInstance().action(new Contexto(Evento.BAJA_PLANTA, null));
            }
        });
        getContentPane().add(baja);
        baja.setBounds(460, 130, 200, 200);

        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.BLANCO_DIR))); 
        modificar.setBorderPainted(false);
        modificar.setContentAreaFilled(false);
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	ApplicationController.getInstance().action(new Contexto(Evento.MODIFICAR_PLANTA, null));
            }
        });
        getContentPane().add(modificar);
        modificar.setBounds(800, 130, 200, 200);

        alta.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.AMARILLO_DIR))); 
        alta.setBorderPainted(false);
        alta.setContentAreaFilled(false);
        alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	ApplicationController.getInstance().action(new Contexto(Evento.ALTA_PLANTA, null));
            }
        });
        getContentPane().add(alta);
        alta.setBounds(130, 130, 200, 200);

        mostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.MORADO_DIR))); 
        mostrar.setBorderPainted(false);
        mostrar.setContentAreaFilled(false);
        mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	ApplicationController.getInstance().action(new Contexto(Evento.MOSTRAR_PLANTA, null));
            }
        });
        getContentPane().add(mostrar);
        mostrar.setBounds(40, 430, 200, 200);

        listar.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.MARRON_DIR))); 
        listar.setBorderPainted(false);
        listar.setContentAreaFilled(false);
        listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	ApplicationController.getInstance().action(new Contexto(Evento.LISTAR_PLANTA, null));
            }
        });
        getContentPane().add(listar);
        listar.setBounds(300, 430, 200, 200);

        desvincular.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.NARANJA_DIR))); 
        desvincular.setBorderPainted(false);
        desvincular.setContentAreaFilled(false);
        desvincular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	ApplicationController.getInstance().action(new Contexto(Evento.DESVINCULAR_DEPARTAMENTO, null));
            }
        });
        getContentPane().add(desvincular);
        desvincular.setBounds(910, 430, 200, 200);

        vincular.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.VERDE_DIR))); 
        vincular.setBorderPainted(false);
        vincular.setContentAreaFilled(false);
        vincular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	ApplicationController.getInstance().action(new Contexto(Evento.VINCULAR_DEPARTAMENTO, null));
            }
        });
        getContentPane().add(vincular);
        vincular.setBounds(580, 430, 200, 200);

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
		
		
	}

}
