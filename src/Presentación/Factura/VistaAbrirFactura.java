package Presentación.Factura;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Integración.Cliente.DAOCliente;
import Integración.FactoriaDAO.FactoriaDAO;
import Negocio.Factura.TEnsamblado;
import Negocio.Factura.TFactura;
import Negocio.LineaFactura.TLineaFactura;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.GUI;
import Presentación.ResourcesAccess;
import Presentación.ApplicationController.ApplicationController;
import Presentación.FactoriaVista.FactoriaVista;

public class VistaAbrirFactura extends JFrame implements GUI{

		private static final long serialVersionUID = 1L;
		
		private JFrame ventana;
		private TFactura factura;
		private javax.swing.JButton cancelar;
	    private javax.swing.JButton confirmar;
	    private javax.swing.JButton fondo;
	    private javax.swing.JTextField id;
	    private javax.swing.JLabel textid;
	    private javax.swing.JLabel textcantidad;
	    private javax.swing.JLabel textcantidad1;
	    private javax.swing.JTextField añadir;
	    private javax.swing.JTextField añadirCantidad;
	    private javax.swing.JTextField eliminarCantidad;
	    private javax.swing.JButton añadirboton;
	    private javax.swing.JButton cerrarFactura;
	    private javax.swing.JTextField eliminar;
	    private javax.swing.JButton eliminarboton;
	    private javax.swing.JLabel texañadir;
	    private javax.swing.JLabel texdevolucion;
	    private javax.swing.JLabel textid1;
	    private ArrayList<TLineaFactura> lineasFactura;
	
		public VistaAbrirFactura() {
	    	super();
	        initGUI();
	    }
		
		public VistaAbrirFactura(int n) {
	    	super();
	    }
                
	    private void initGUI() {

	        cancelar = new javax.swing.JButton();
	        confirmar = new javax.swing.JButton();
	        id = new javax.swing.JTextField();
	        textid = new javax.swing.JLabel();
	        fondo = new javax.swing.JButton();
	    	lineasFactura = new ArrayList<TLineaFactura>();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        setTitle("Abrir Factura");
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
	        confirmar.setText("Abrir");
	        confirmar.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	if (id.getText() != null){
	            		try{
	            			factura = new TFactura(Integer.parseInt(id.getText()));
	            			//ApplicationController.getInstance().action(new Contexto(Evento.ABRIR_FACTURA_OK, factura));
	            			opcionesFactura(Integer.parseInt(id.getText()));
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
	        id.setBounds(460, 310, 250, 100);
	        

	        textid.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textid.setForeground(new java.awt.Color(255, 255, 255));
	        textid.setText("Abrir nueva factura para el cliente con id:");
	        getContentPane().add(textid);
	        textid.setBounds(90, 210, 1050, 70);

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
	    
	    private void opcionesFactura(int idCliente){
	    	ventana = new JFrame("Editar factura");
			
	    	texañadir = new javax.swing.JLabel();
	        texdevolucion = new javax.swing.JLabel();
	        cerrarFactura = new javax.swing.JButton();
	        añadir = new javax.swing.JTextField();
	        textcantidad = new javax.swing.JLabel();
	        textcantidad1 = new javax.swing.JLabel();
	        textid = new javax.swing.JLabel();
	        textid1 = new javax.swing.JLabel();
	        eliminar = new javax.swing.JTextField();
	        añadirCantidad = new javax.swing.JTextField();
	        eliminarCantidad = new javax.swing.JTextField();
	        añadirboton = new javax.swing.JButton();
	        eliminarboton = new javax.swing.JButton();
	        fondo = new javax.swing.JButton();
	        ventana.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        ventana.setTitle("Abrir Factura");
	        ventana.setMinimumSize(new java.awt.Dimension(1187, 792));
	        ventana.setResizable(false);
	        ventana.getContentPane().setLayout(null);

	        texañadir.setFont(new java.awt.Font("Tahoma", 1, 36)); 
	        texañadir.setForeground(new java.awt.Color(255, 255, 255));
	        texañadir.setText("AÑADIR PRODUCTO");
	        ventana.getContentPane().add(texañadir);
	        texañadir.setBounds(150, 140, 370, 40);
	        
	        texdevolucion.setFont(new java.awt.Font("Tahoma", 1, 36)); 
	        texdevolucion.setForeground(new java.awt.Color(255, 255, 255));
	        texdevolucion.setText("ELIMINAR PRODUCTO");
	        ventana.getContentPane().add(texdevolucion);
	        texdevolucion.setBounds(650, 140, 420, 40);

	        cerrarFactura.setBackground(new java.awt.Color(255, 51, 51));
	        cerrarFactura.setFont(new java.awt.Font("Tahoma", 1, 18)); 
	        cerrarFactura.setText("Cerrar factura");
	        cerrarFactura.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                try{
	                	TEnsamblado lineaFacturas = new TEnsamblado();
	                	lineaFacturas.setLineasFactura(lineasFactura);
	                	lineaFacturas.setFactura(factura);
	                	ApplicationController.getInstance().action(new Contexto(Evento.CERRAR_FACTURA_OK, lineaFacturas));
						dispose();
	                }catch(NumberFormatException n){
					JOptionPane.showMessageDialog(new JFrame(), "Error en los datos", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	                ventana.dispose();
	            }
	        });
	        ventana.getContentPane().add(cerrarFactura);
	        cerrarFactura.setBounds(920, 660, 210, 60);
	        
	        añadirCantidad.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        ventana.getContentPane().add(añadirCantidad);
	        añadirCantidad.setForeground(new java.awt.Color(153, 153, 153));
	        añadirCantidad.setBounds(240, 330, 230, 80);
	        
	        eliminarCantidad.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        ventana.getContentPane().add(eliminarCantidad);
	        eliminarCantidad.setForeground(new java.awt.Color(153, 153, 153));
	        eliminarCantidad.setBounds(720, 330, 230, 80);
	        
	        añadir.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        ventana.getContentPane().add(añadir);
	        añadir.setBounds(240, 230, 230, 80);
	        
	        textid.setFont(new java.awt.Font("Tahoma", 1, 36)); 
	        textid.setForeground(new java.awt.Color(255, 255, 255));
	        textid.setText("Id:");
	        ventana.getContentPane().add(textid);
	        textid.setBounds(640, 250, 90, 40);
	        
	        textcantidad.setFont(new java.awt.Font("Tahoma", 1, 36)); 
	        textcantidad.setForeground(new java.awt.Color(255, 255, 255));
	        textcantidad.setText("Uds:");
	        ventana.getContentPane().add(textcantidad);
	        textcantidad.setBounds(610, 350, 90, 40);
	        
	        textcantidad1.setFont(new java.awt.Font("Tahoma", 1, 36)); 
	        textcantidad1.setForeground(new java.awt.Color(255, 255, 255));
	        textcantidad1.setText("Uds:");
	        ventana.getContentPane().add(textcantidad1);
	        textcantidad1.setBounds(120, 350, 90, 40);

	        textid1.setFont(new java.awt.Font("Tahoma", 1, 36)); 
	        textid1.setForeground(new java.awt.Color(255, 255, 255));
	        textid1.setText("Id:");
	        ventana.getContentPane().add(textid1);
	        textid1.setBounds(150, 250, 90, 40);

	        eliminar.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        ventana.getContentPane().add(eliminar);
	        eliminar.setBounds(720, 230, 230, 80);

	        añadirboton.setBackground(new java.awt.Color(0, 153, 0));
	        añadirboton.setFont(new java.awt.Font("Tahoma", 1, 18));
	        añadirboton.setText("Añadir");
	        añadirboton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	if(añadir.getText() != null && añadirCantidad.getText() != null){
						TLineaFactura lineaFactura = new TLineaFactura(Integer.parseInt(añadir.getText()), idCliente, Integer.parseInt(añadirCantidad.getText()), null);
						lineasFactura.add(lineaFactura);
						ApplicationController.getInstance().action(new Contexto(Evento.AÑADIR_PRODUCTO_OK, lineasFactura));
						
	                }
	            }
	        });
	        ventana.getContentPane().add(añadirboton);
	        añadirboton.setBounds(220, 450, 210, 60);

	        eliminarboton.setBackground(new java.awt.Color(0, 153, 0));
	        eliminarboton.setFont(new java.awt.Font("Tahoma", 1, 18));
	        eliminarboton.setText("Eliminar");
	        eliminarboton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
		             if(eliminar.getText() != null && eliminarCantidad.getText() != null){   
		            	 TLineaFactura lineaFactura = new TLineaFactura(Integer.parseInt(eliminar.getText()), idCliente, Integer.parseInt(eliminarCantidad.getText()), null);
		            	 lineasFactura.add(lineaFactura);
		            	 ApplicationController.getInstance().action(new Contexto(Evento.ELIMINAR_PRODUCTO_OK, lineasFactura));
		             }
	            }
	        });
	        ventana.getContentPane().add(eliminarboton);
	        eliminarboton.setBounds(740, 450, 210, 60);

	        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.FONDO_MADERA_DIR))); 
	        fondo.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.FONDO_MADERA_DIR)));
	        fondo.setEnabled(false);
	        fondo.setMaximumSize(new java.awt.Dimension(1187, 792));
	        fondo.setMinimumSize(new java.awt.Dimension(1187, 792));
	        ventana.getContentPane().add(fondo);
	        fondo.setBounds(0, 0, 1190, 760);

	        ventana.pack();
	        ventana.setLocationRelativeTo(null);
	        ventana.setVisible(true);                    
	    }

		@Override
		public void update(Contexto cont) {
			
			if (cont.getEvento() == Evento.AÑADIR_PRODUCTO_OK || cont.getEvento() == Evento.ELIMINAR_PRODUCTO_OK) return;
			if (cont.getDato() != null){
				Integer id = (Integer)cont.getDato();
			
				switch((int)cont.getDato()){
					case -1: JOptionPane.showMessageDialog(new JFrame(),"El parámetro TFactura es null", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					case -2: JOptionPane.showMessageDialog(new JFrame(),"No existe el cliente", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					case -3: JOptionPane.showMessageDialog(new JFrame(),"El cliente no esta activo", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					case -0: JOptionPane.showMessageDialog(new JFrame(),"No se ha creado la factura porque está vacia", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					default:
						JOptionPane.showMessageDialog(new JFrame(), "Se abrió una factura correctamente al cliente con id: " + id);
						break;
				}
				
			}
			
		}

}
