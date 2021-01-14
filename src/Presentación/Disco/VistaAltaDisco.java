package Presentación.Disco;
//HECHO
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Negocio.Disco.TDisco;
import Negocio.Disco.TDiscoCD;
import Negocio.Disco.TDiscoVinilo;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.GUI;
import Presentación.ResourcesAccess;

public class VistaAltaDisco extends JFrame implements GUI{

	private static final long serialVersionUID = 1L;
	
		public VistaAltaDisco() {
	        super();
	        initGUI();
	    }
          
		protected void setCommonGUI()
		{
			cancelar = new javax.swing.JButton();
	        confirmar = new javax.swing.JButton();
	        nombre = new javax.swing.JTextField();
	        año = new javax.swing.JTextField();
	        revoluciones = new javax.swing.JTextField();
	        prensado = new javax.swing.JTextField();
	        dvd = new javax.swing.JTextField();
	        genero = new javax.swing.JTextField();
	        precio = new javax.swing.JTextField();
	        gramaje = new javax.swing.JTextField();
	        stock = new javax.swing.JTextField();
	        textnombre = new javax.swing.JLabel();
	        textaño = new javax.swing.JLabel();
	        txtgenero = new javax.swing.JLabel();
	        textoinfo = new javax.swing.JLabel();
	        textgramaje = new javax.swing.JLabel();
	        textrevoluciones = new javax.swing.JLabel();
	        textdvd = new javax.swing.JLabel();
	        textstock = new javax.swing.JLabel();
	        textprecio = new javax.swing.JLabel();
	        textprensado = new javax.swing.JLabel();
	        
	        cancelar.setBackground(new java.awt.Color(255, 51, 51));
	        cancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); 
	        cancelar.setText("Cancelar");
	        cancelar.addActionListener(new java.awt.event.ActionListener() {
	        	public void actionPerformed(ActionEvent evt) {
	                Presentación.ApplicationController.ApplicationController.getInstance().action(new Contexto(Evento.CREAR_VISTA_DISCO, null));
	                dispose();
	            }
	        });
	        getContentPane().add(cancelar);
	        cancelar.setBounds(690, 660, 210, 60);
	        cancelar.getAccessibleContext().setAccessibleName("Discos");

	        confirmar.setBackground(new java.awt.Color(0, 204, 51));
	        confirmar.setFont(new java.awt.Font("Tahoma", 1, 18)); 
	        confirmar.setText("Confirmar");
	        confirmar.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	boolean correcto = true;
	            	String datos = "";
	            	if(nombre.getText().equalsIgnoreCase("") || año.getText().equalsIgnoreCase("") || genero.getText().equalsIgnoreCase("") || precio.getText().equalsIgnoreCase("") || stock.getText().equalsIgnoreCase("")) correcto = false;
	            	datos += nombre.getText() + "\n";
	            	datos += año.getText() + "\n";
	            	datos += genero.getText() + "\n";
	            	datos += precio.getText() + "\n";
	            	datos += stock.getText() + "\n";
	            	datos += dvd.getText() + "\n";
	            	datos += gramaje.getText() + "\n";
	            	datos += revoluciones.getText() + "\n";
	            	datos += prensado.getText() + "\n";
	            	if(correcto){
	            		String[] salida = datos.split("\\n");
	            		try{
	            			if(eleccion == 0){
	            				boolean dvdentrada;
	            				if(dvd.getText() == "0"){
	            					dvdentrada = false;
	            				}
	            				else
	            					dvdentrada = true;
	            				Presentación.ApplicationController.ApplicationController.getInstance().action(new Contexto(Evento.ALTA_DISCO_OK, new TDiscoCD(0, salida[0], Integer.parseInt(salida[1]), Float.parseFloat(salida[3]), Integer.parseInt(salida[4]), salida[2], true, dvdentrada)));
	            				}
	            			else
	            				Presentación.ApplicationController.ApplicationController.getInstance().action(new Contexto(Evento.ALTA_DISCO_OK, new TDiscoVinilo(0, salida[0], Integer.parseInt(salida[1]), Float.parseFloat(salida[3]), Integer.parseInt(salida[4]), salida[2], true, Integer.parseInt(salida[7]), Integer.parseInt(salida[6]), salida[8])));
	            			} catch(Exception ex){
	            			JOptionPane.showMessageDialog(new JFrame(), "Informacion Erronea", "Error", JOptionPane.ERROR_MESSAGE);
	            		}
	            	}
	            	dispose();
	            }
	        });
	        getContentPane().add(confirmar);
	        confirmar.setBounds(930, 660, 210, 60);

	        nombre.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        nombre.setForeground(new java.awt.Color(153, 153, 153));
	        
	        getContentPane().add(nombre);
	        nombre.setBounds(300, 140, 250, 100);

	        año.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        año.setForeground(new java.awt.Color(153, 153, 153));
	        
	        getContentPane().add(año);
	        año.setBounds(300, 250, 250, 100);

	        

	        genero.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        genero.setForeground(new java.awt.Color(153, 153, 153));
	        
	        getContentPane().add(genero);
	        genero.setBounds(300, 580, 250, 100);

	        precio.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        precio.setForeground(new java.awt.Color(153, 153, 153));
	        
	        getContentPane().add(precio);
	        precio.setBounds(300, 360, 250, 100);

	        

	        stock.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        stock.setForeground(new java.awt.Color(153, 153, 153));
	        
	        getContentPane().add(stock);
	        stock.setBounds(300, 470, 250, 100);

	        textnombre.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textnombre.setForeground(new java.awt.Color(255, 255, 255));
	        textnombre.setText("Nombre:");
	        getContentPane().add(textnombre);
	        textnombre.setBounds(60, 150, 210, 70);

	        textaño.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textaño.setForeground(new java.awt.Color(255, 255, 255));
	        textaño.setText("Año:");
	        getContentPane().add(textaño);
	        textaño.setBounds(60, 270, 210, 70);

	        txtgenero.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        txtgenero.setForeground(new java.awt.Color(255, 255, 255));
	        txtgenero.setText("Género:");
	        getContentPane().add(txtgenero);
	        txtgenero.setBounds(60, 600, 210, 70);

	        textoinfo.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textoinfo.setForeground(new java.awt.Color(255, 255, 255));
	        textoinfo.setText("Dar de alta un nuevo disco:");
	        getContentPane().add(textoinfo);
	        textoinfo.setBounds(280, 30, 680, 70);

	        

	        

	        textstock.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textstock.setForeground(new java.awt.Color(255, 255, 255));
	        textstock.setText("Stock:");
	        getContentPane().add(textstock);
	        textstock.setBounds(60, 490, 210, 70);

	        textprecio.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textprecio.setForeground(new java.awt.Color(255, 255, 255));
	        textprecio.setText("Precio:");
	        getContentPane().add(textprecio);
	        textprecio.setBounds(60, 380, 210, 70);  

	        
	        
	      
		}
		
	    private void initGUI() {

	    	
	    	setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        setTitle("Alta Disco");
	        setMinimumSize(new java.awt.Dimension(1187, 792));
	        setResizable(false);
	        getContentPane().setLayout(null);
	        
	        //----------- 2 options button ------------------------
	        
	       
	    	
	    	JButton cd_select = new JButton("CD");
	    	JButton vinil_select= new JButton("Vinilo");
	    	
	    	//-------------------- CD ----------------------------
	    	
	    	cd_select.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					vinil_select.setVisible(false);
			        cd_select.setVisible(false);
			        setCommonGUI();
			        
			        textdvd.setFont(new java.awt.Font("Tahoma", 1, 48)); 
			        textdvd.setForeground(new java.awt.Color(255, 255, 255));
			        textdvd.setText("DVD:");
			        getContentPane().add(textdvd);
			        textdvd.setBounds(610, 150, 210, 70);
					dvd.setFont(new java.awt.Font("Tahoma", 2, 24)); 
			        dvd.setForeground(new java.awt.Color(153, 153, 153));
			        getContentPane().add(dvd);
			        dvd.setBounds(870, 140, 250, 100);
			        getContentPane().add(fondo);
				    eleccion = 0;   
				        
					
				}
	    		
	    	});
	    	
	    	//---------------------- Vinilo -------------------------
	    	
	    	vinil_select.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					vinil_select.setVisible(false);
			        cd_select.setVisible(false);
			        setCommonGUI();
			        
			        textgramaje.setFont(new java.awt.Font("Tahoma", 1, 48)); 
			        textgramaje.setForeground(new java.awt.Color(255, 255, 255));
			        textgramaje.setText("Gramaje:");
			        getContentPane().add(textgramaje);
			        textgramaje.setBounds(610, 400, 270, 70);

			        textrevoluciones.setFont(new java.awt.Font("Tahoma", 1, 36)); 
			        textrevoluciones.setForeground(new java.awt.Color(255, 255, 255));
			        textrevoluciones.setText("Revoluciones:");
			        getContentPane().add(textrevoluciones);
			        textrevoluciones.setBounds(610, 280, 270, 70);
			        
			        textprensado.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
			        textprensado.setForeground(new java.awt.Color(255, 255, 255));
			        textprensado.setText("Prensado:");
			        getContentPane().add(textprensado);
			        textprensado.setBounds(605, 150, 250, 70);
					
					gramaje.setFont(new java.awt.Font("Tahoma", 2, 24)); 
			        gramaje.setForeground(new java.awt.Color(153, 153, 153));
			        
			        getContentPane().add(gramaje);
			        gramaje.setBounds(880, 380, 250, 100);
			        
			        revoluciones.setFont(new java.awt.Font("Tahoma", 2, 24)); 
			        revoluciones.setForeground(new java.awt.Color(153, 153, 153));
			        
			        getContentPane().add(revoluciones);
			        revoluciones.setBounds(880, 260, 250, 100);

			        prensado.setFont(new java.awt.Font("Tahoma", 2, 24)); 
			        prensado.setForeground(new java.awt.Color(153, 153, 153));
			        
			        getContentPane().add(prensado);
			        prensado.setBounds(880, 140, 250, 100);
			        
			        getContentPane().add(fondo);
			        eleccion = 1;
				}
	    		
	    	}
	    	
	  
	    	);
	    	this.getContentPane().add(cd_select);
	    	cd_select.setBounds(360, 330, 210, 100);
	    	cd_select.setFont(new Font("Tempus Sans ITC", 0, 20));
	    	cd_select.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.RADIO_BUTTON_1)));
	    	cd_select.setBorderPainted(false);
	    	cd_select.setContentAreaFilled(false);
	    	
	    	
	    	this.getContentPane().add(vinil_select);
	    	vinil_select.setBounds(570, 330, 210, 100);
	    	vinil_select.setFont(new Font("Tempus Sans ITC", 0, 20));
	    	vinil_select.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.RADIO_BUTTON_1)));
	    	vinil_select.setBorderPainted(false);
	    	vinil_select.setContentAreaFilled(false);
	    	
	    	

	        
	        fondo = new javax.swing.JButton();
	        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.FONDO_MADERA_DIR))); // NOI18N
	        fondo.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.FONDO_MADERA_DIR))); // NOI18N
	        fondo.setEnabled(false);
	        fondo.setMaximumSize(new java.awt.Dimension(1187, 792));
	        fondo.setMinimumSize(new java.awt.Dimension(1187, 792));
	        getContentPane().add(fondo);
	    
	        fondo.setBounds(0, 0, 1190, 760);
	        
	        

	        pack();
	        setLocationRelativeTo(null);
	        setVisible(true);
	    }                       
                    
	    private int eleccion;
	    private javax.swing.JTextField año;
	    private javax.swing.JButton cancelar;
	    private javax.swing.JButton confirmar;
	    private javax.swing.JTextField dvd;
	    private javax.swing.JButton fondo;
	    private javax.swing.JTextField genero;
	    private javax.swing.JTextField gramaje;
	    private javax.swing.JTextField nombre;
	    private javax.swing.JTextField precio;
	    private javax.swing.JTextField prensado;
	    private javax.swing.JTextField revoluciones;
	    private javax.swing.JTextField stock;
	    private javax.swing.JLabel textaño;
	    private javax.swing.JLabel txtgenero;
	    private javax.swing.JLabel textgramaje;
	    private javax.swing.JLabel textrevoluciones;
	    private javax.swing.JLabel textdvd;
	    private javax.swing.JLabel textstock;
	    private javax.swing.JLabel textprecio;
	    private javax.swing.JLabel textprensado;
	    private javax.swing.JLabel textnombre;
	    private javax.swing.JLabel textoinfo;
		@Override
		
		public void update(Contexto contexto) {
			if (contexto.getDato() != null){
				Integer id = (Integer)contexto.getDato();
			
				switch((int)contexto.getDato()){
					case -1: JOptionPane.showMessageDialog(new JFrame(),"El cliente es nulo", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					case -2: JOptionPane.showMessageDialog(new JFrame(),"Error sintactico", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					case -100: JOptionPane.showMessageDialog(new JFrame(),"Error en la gestion de la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					default:
						JOptionPane.showMessageDialog(new JFrame(),"Disco creado con ID : " + id.intValue());
						break;
				}
			}
		}

}
