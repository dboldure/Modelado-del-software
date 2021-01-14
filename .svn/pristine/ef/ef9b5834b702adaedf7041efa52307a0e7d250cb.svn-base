package Presentación.Factura;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Negocio.LineaFactura.TLineaFactura;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.GUI;
import Presentación.ResourcesAccess;
import Presentación.ApplicationController.ApplicationController;

public class VistaDevolucion extends JFrame implements GUI{

	private static final long serialVersionUID = 1L;
	
	private javax.swing.JButton cancelar;
    private javax.swing.JTextField cantidad;
    private javax.swing.JButton confirmar;
    private javax.swing.JButton fondo;
    private javax.swing.JTextField iddisco;
    private javax.swing.JTextField idfactura;
    private javax.swing.JLabel textdni;
    private javax.swing.JLabel textdni1;
    private javax.swing.JLabel textnombre;
    private javax.swing.JLabel textoinfo;
    
	public VistaDevolucion() {
	    	super();
	        initGUI();
	    }
                         
	    private void initGUI() {

	        cancelar = new javax.swing.JButton();
	        confirmar = new javax.swing.JButton();
	        idfactura = new javax.swing.JTextField();
	        cantidad = new javax.swing.JTextField();
	        iddisco = new javax.swing.JTextField();
	        textnombre = new javax.swing.JLabel();
	        textdni = new javax.swing.JLabel();
	        textoinfo = new javax.swing.JLabel();
	        textdni1 = new javax.swing.JLabel();
	        fondo = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        setTitle("Devolución");
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
						TLineaFactura lineaFactura = new TLineaFactura(Integer.parseInt(iddisco.getText()), Integer.parseInt(idfactura.getText()), Integer.parseInt(cantidad.getText()), null);
						ApplicationController.getInstance().action(new Contexto(Evento.DEVOLUCION_OK, lineaFactura));
						dispose();
					}catch(NumberFormatException n){
						JOptionPane.showMessageDialog(new JFrame(), "Error en los datos", "Error", JOptionPane.ERROR_MESSAGE);
					}
					dispose();
	            }
	        });
	        getContentPane().add(confirmar);
	        confirmar.setBounds(930, 660, 210, 60);

	        idfactura.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        idfactura.setForeground(new java.awt.Color(153, 153, 153));
	        
	        getContentPane().add(idfactura);
	        idfactura.setBounds(560, 180, 250, 100);

	        cantidad.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        cantidad.setForeground(new java.awt.Color(153, 153, 153));
	        
	        getContentPane().add(cantidad);
	        cantidad.setBounds(560, 430, 250, 100);

	        iddisco.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        iddisco.setForeground(new java.awt.Color(153, 153, 153));
	        
	        getContentPane().add(iddisco);
	        iddisco.setBounds(560, 310, 250, 100);

	        textnombre.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textnombre.setForeground(new java.awt.Color(255, 255, 255));
	        textnombre.setText("Id factura:");
	        getContentPane().add(textnombre);
	        textnombre.setBounds(250, 190, 270, 70);

	        textdni.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textdni.setForeground(new java.awt.Color(255, 255, 255));
	        textdni.setText("Cantidad:");
	        getContentPane().add(textdni);
	        textdni.setBounds(250, 440, 270, 70);

	        textoinfo.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textoinfo.setForeground(new java.awt.Color(255, 255, 255));
	        textoinfo.setText("Devolución:");
	        getContentPane().add(textoinfo);
	        textoinfo.setBounds(440, 60, 300, 70);

	        textdni1.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textdni1.setForeground(new java.awt.Color(255, 255, 255));
	        textdni1.setText("Id disco:");
	        getContentPane().add(textdni1);
	        textdni1.setBounds(250, 320, 210, 70);

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
							
				switch((int)cont.getDato()){
					case -1: JOptionPane.showMessageDialog(new JFrame(),"El disco no existe", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					case -2: JOptionPane.showMessageDialog(new JFrame(),"La factura no existe", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					case -3: JOptionPane.showMessageDialog(new JFrame(),"No existe ese disco en la factura", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					case -4: JOptionPane.showMessageDialog(new JFrame(),"Fallo en la transaccion", "Error", JOptionPane.ERROR_MESSAGE);
					break;
					case -5: JOptionPane.showMessageDialog(new JFrame(),"Las unidades a devolver superan las de la venta", "Error", JOptionPane.ERROR_MESSAGE);
					break;
					case -100: JOptionPane.showMessageDialog(new JFrame(),"Error en la gestion de la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					default:
						JOptionPane.showMessageDialog(new JFrame(), "Se realizó la devolución correctamente");
						break;
				}
			
		}
	}
}
