
/**
 * 
 */
package Presentación;

import javax.swing.JFrame;

import Presentación.ApplicationController.ApplicationController;

public class VistaPrincipal extends JFrame implements GUI{
	
	private static VistaPrincipal vista;
	
	
	private static final long serialVersionUID = 1L;
	
	private javax.swing.JButton clientes;
    private javax.swing.JButton departamento;
    private javax.swing.JButton discos;
    private javax.swing.JButton empleado;
    private javax.swing.JButton factura;
    private javax.swing.JButton fondo;
    private javax.swing.JButton planta;
    private javax.swing.JButton vinilofondo;
    private javax.swing.JLabel texcliente;
    private javax.swing.JLabel texdiscos;
    private javax.swing.JLabel texempleado;
    private javax.swing.JLabel texplanta;
    private javax.swing.JLabel textdepartamento;
    private javax.swing.JLabel textfactura;
   

    public VistaPrincipal()
    {
    	super();
    	initGUI();
    }
    
    public static VistaPrincipal getInstance()
    {
    	if(vista == null)vista = new VistaPrincipal();
    	vista.setVisible(true);
    	return vista;
    }
    
	private void initGUI() {
		
		 	textfactura = new javax.swing.JLabel();
	        texcliente = new javax.swing.JLabel();
	        texdiscos = new javax.swing.JLabel();
	        texempleado = new javax.swing.JLabel();
	        texplanta = new javax.swing.JLabel();
	        textdepartamento = new javax.swing.JLabel();
	        vinilofondo = new javax.swing.JButton();
	        factura = new javax.swing.JButton();
	        clientes = new javax.swing.JButton();
	        discos = new javax.swing.JButton();
	        empleado = new javax.swing.JButton();
	        planta = new javax.swing.JButton();
	        departamento = new javax.swing.JButton();
	        fondo = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        setTitle("Pantalla Principal");
	        setMinimumSize(new java.awt.Dimension(1187, 792));
	        setResizable(false);
	        getContentPane().setLayout(null);

	        textfactura.setFont(new java.awt.Font("Tahoma", 1, 36)); 
	        textfactura.setForeground(new java.awt.Color(255, 255, 255));
	        textfactura.setText("FACTURAS");
	        getContentPane().add(textfactura);
	        textfactura.setBounds(550, 260, 200, 40);

	        texcliente.setFont(new java.awt.Font("Tahoma", 1, 36)); 
	        texcliente.setForeground(new java.awt.Color(255, 255, 255));
	        texcliente.setText("CLIENTES");
	        getContentPane().add(texcliente);
	        texcliente.setBounds(550, 20, 190, 30);

	        texdiscos.setFont(new java.awt.Font("Tahoma", 1, 36)); 
	        texdiscos.setForeground(new java.awt.Color(255, 255, 255));
	        texdiscos.setText("DISCOS");
	        getContentPane().add(texdiscos);
	        texdiscos.setBounds(570, 510, 142, 44);

	        texempleado.setFont(new java.awt.Font("Tahoma", 1, 36)); 
	        texempleado.setForeground(new java.awt.Color(255, 255, 255));
	        texempleado.setText("EMPLEADO");
	        getContentPane().add(texempleado);
	        texempleado.setBounds(880, 14, 210, 40);

	        texplanta.setFont(new java.awt.Font("Tahoma", 1, 36)); 
	        texplanta.setForeground(new java.awt.Color(255, 255, 255));
	        texplanta.setText("PLANTA");
	        getContentPane().add(texplanta);
	        texplanta.setBounds(900, 260, 145, 44);

	        textdepartamento.setFont(new java.awt.Font("Tahoma", 1, 36)); 
	        textdepartamento.setForeground(new java.awt.Color(255, 255, 255));
	        textdepartamento.setText("DEPARTAMENTO");
	        getContentPane().add(textdepartamento);
	        textdepartamento.setBounds(832, 510, 320, 44);
	        
	        vinilofondo.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.VINILO_DIR))); 
	        vinilofondo.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.VINILO_DIR)));
	        vinilofondo.setEnabled(false);
	        vinilofondo.setBorderPainted(false);
	        vinilofondo.setContentAreaFilled(false);
	        getContentPane().add(vinilofondo);
	        vinilofondo.setBounds(0, 150, 490, 470);

	        factura.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.AMARILLO_DIR)));
	        factura.setBorderPainted(false);
	        factura.setContentAreaFilled(false);
	        factura.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	dispose();
					ApplicationController.getInstance().action(new Contexto(Evento.CREAR_VISTA_FACTURA, null));
	            }
	        });
	        getContentPane().add(factura);
	        factura.setBounds(540, 310, 210, 190);
 
	        clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.AZUL_DIR))); 
	        clientes.setBorderPainted(false);
	        clientes.setContentAreaFilled(false);
	        clientes.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	dispose();
					ApplicationController.getInstance().action(new Contexto(Evento.CREAR_VISTA_CLIENTE, null));
	            }
	        });
	        getContentPane().add(clientes);
	        clientes.setBounds(530, 60, 220, 190);
 
	        discos.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.VERDE_DIR))); 
	        discos.setBorderPainted(false);
	        discos.setContentAreaFilled(false);
	        discos.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	dispose();
					ApplicationController.getInstance().action(new Contexto(Evento.CREAR_VISTA_DISCO, null));
	            }
	        });
	        getContentPane().add(discos);
	        discos.setBounds(540, 560, 210, 190);

	        empleado.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.BLANCO_DIR))); 
	        empleado.setBorderPainted(false);
	        empleado.setContentAreaFilled(false);
	        empleado.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	dispose();
					ApplicationController.getInstance().action(new Contexto(Evento.CREAR_VISTA_EMPLEADO, null));
	            }
	        });
	        getContentPane().add(empleado);
	        empleado.setBounds(870, 60, 210, 190);
 
	        planta.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.ROJO_DIR))); 
	        planta.setBorderPainted(false);
	        planta.setContentAreaFilled(false);
	        planta.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	dispose();
					ApplicationController.getInstance().action(new Contexto(Evento.CREAR_VISTA_PLANTA, null));
	            }
	        });
	        getContentPane().add(planta);
	        planta.setBounds(870, 310, 210, 190);

	        departamento.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.MORADO_DIR))); 
	        departamento.setBorderPainted(false);
	        departamento.setContentAreaFilled(false);
	        departamento.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	dispose();
					ApplicationController.getInstance().action(new Contexto(Evento.CREAR_VISTA_DEPARTAMENTO, null));
	            }
	        });
	        getContentPane().add(departamento);
	        departamento.setBounds(880, 560, 210, 190);
	        
	        fondo.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.FONDO_MADERA_DIR))); 
	        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.FONDO_MADERA_DIR))); 
	        fondo.setEnabled(false);
	        fondo.setMaximumSize(new java.awt.Dimension(1187, 792));
	        fondo.setMinimumSize(new java.awt.Dimension(1187, 792));
	        getContentPane().add(fondo);
	        fondo.setBounds(0, 0, 1190, 760);

	        pack();
	        setLocationRelativeTo(null);
	        setVisible(true);
	}
	
	
	public void update(Contexto contexto){
		initGUI();
	}
	
}