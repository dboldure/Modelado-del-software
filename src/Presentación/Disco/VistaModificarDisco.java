package Presentaci�n.Disco;
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
import Presentaci�n.Contexto;
import Presentaci�n.Evento;
import Presentaci�n.GUI;
import Presentaci�n.ResourcesAccess;

public class VistaModificarDisco extends JFrame implements GUI{

	private static final long serialVersionUID = 1L;
	
		public VistaModificarDisco() {
	        super();
	        initGUI();
	    }
          
		protected void setCommonGUI()
		{
			cancelar = new javax.swing.JButton();
	        confirmar = new javax.swing.JButton();
	        id = new javax.swing.JTextField();
	        nombre = new javax.swing.JTextField();
	        a�o = new javax.swing.JTextField();
	        revoluciones = new javax.swing.JTextField();
	        prensado = new javax.swing.JTextField();
	        dvd = new javax.swing.JTextField();
	        genero = new javax.swing.JTextField();
	        precio = new javax.swing.JTextField();
	        gramaje = new javax.swing.JTextField();
	        stock = new javax.swing.JTextField();
	        textid = new javax.swing.JLabel();
	        textnombre = new javax.swing.JLabel();
	        texta�o = new javax.swing.JLabel();
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
	                Presentaci�n.ApplicationController.ApplicationController.getInstance().action(new Contexto(Evento.CREAR_VISTA_DISCO, null));
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
	            
	            	
	            	if (id.getText()!=null){
	            		try{
	            			
	            			Integer a�oaux=null,stockaux=null,gramajeaux=null,revolucionesaux=null;
	    	            	Float precioaux= null;
	    	            	Boolean dvdaux=null;
	    	            	if(!a�o.getText().isEmpty())a�oaux=Integer.parseInt(a�o.getText());
	    	            	if(!precio.getText().isEmpty())precioaux=Float.parseFloat(precio.getText());
	    	            	if(!stock.getText().isEmpty())stockaux=Integer.parseInt(stock.getText());
	    	            	
	            			
	            			if(eleccion == 0){
	            				if(!dvd.getText().isEmpty())dvdaux=Boolean.parseBoolean(dvd.getText());
	            				Presentaci�n.ApplicationController.ApplicationController.getInstance().action(new Contexto(Evento.MODIFICAR_DISCO_OK, new TDiscoCD(Integer.parseInt(id.getText()), nombre.getText(), a�oaux, precioaux, stockaux, genero.getText(), true, dvdaux)));
	            				}
	            			else{
		    	            	if(!gramaje.getText().isEmpty())gramajeaux=Integer.parseInt(gramaje.getText());
		    	            	if(!revoluciones.getText().isEmpty())revolucionesaux=Integer.parseInt(revoluciones.getText());
	            				Presentaci�n.ApplicationController.ApplicationController.getInstance().action(new Contexto(Evento.MODIFICAR_DISCO_OK, new TDiscoVinilo(Integer.parseInt(id.getText()), nombre.getText(), a�oaux, precioaux, stockaux, genero.getText(), true, revolucionesaux, gramajeaux, prensado.getText())));
	            			}
            			} catch(Exception ex){
	            			JOptionPane.showMessageDialog(new JFrame(), "Informacion Erronea", "Error", JOptionPane.ERROR_MESSAGE);
	            		}
	            	}
	            	else{
	            		JOptionPane.showMessageDialog(new JFrame(), "Introduce el id", "Error", JOptionPane.ERROR_MESSAGE);
	            	}
	            	dispose();
	            }
	        });
	        getContentPane().add(confirmar);
	        confirmar.setBounds(930, 660, 210, 60);
	        
	        
	        id.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        id.setForeground(new java.awt.Color(153, 153, 153));
	        
	        getContentPane().add(id);
	        id.setBounds(300, 140, 250, 100);

	        nombre.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        nombre.setForeground(new java.awt.Color(153, 153, 153));
	        
	        getContentPane().add(nombre);
	        nombre.setBounds(300, 250, 250, 100);

	        a�o.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        a�o.setForeground(new java.awt.Color(153, 153, 153));
	        
	        getContentPane().add(a�o);
	        a�o.setBounds(300, 360, 250, 100);

	        

	        

	        precio.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        precio.setForeground(new java.awt.Color(153, 153, 153));
	        
	        getContentPane().add(precio);
	        precio.setBounds(300, 470, 250, 100);
	        
	        
	        
	        stock.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        stock.setForeground(new java.awt.Color(153, 153, 153));
	        
	        getContentPane().add(stock);
	        stock.setBounds(300, 580, 250, 100);
	        
	        genero.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        genero.setForeground(new java.awt.Color(153, 153, 153));
	        
	        getContentPane().add(genero);
	        genero.setBounds(880, 140, 250, 100);

	        


	        textid.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textid.setForeground(new java.awt.Color(255, 255, 255));
	        textid.setText("Id:");
	        getContentPane().add(textid);
	        textid.setBounds(60, 150, 210, 70);
	        
	        textnombre.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textnombre.setForeground(new java.awt.Color(255, 255, 255));
	        textnombre.setText("Nombre:");
	        getContentPane().add(textnombre);
	        textnombre.setBounds(60, 270, 210, 70);

	        texta�o.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        texta�o.setForeground(new java.awt.Color(255, 255, 255));
	        texta�o.setText("A�o:");
	        getContentPane().add(texta�o);
	        texta�o.setBounds(60, 380, 210, 70);

	        
	        textprecio.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textprecio.setForeground(new java.awt.Color(255, 255, 255));
	        textprecio.setText("Precio:");
	        getContentPane().add(textprecio);
	        textprecio.setBounds(60, 490, 210, 70);  
	        
	        
	        textstock.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textstock.setForeground(new java.awt.Color(255, 255, 255));
	        textstock.setText("Stock:");
	        getContentPane().add(textstock);
	        textstock.setBounds(60, 600, 210, 70);

	        
	        
	        txtgenero.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        txtgenero.setForeground(new java.awt.Color(255, 255, 255));
	        txtgenero.setText("G�nero:");
	        getContentPane().add(txtgenero);
	        txtgenero.setBounds(610, 150, 210, 70);

	        textoinfo.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textoinfo.setForeground(new java.awt.Color(255, 255, 255));
	        textoinfo.setText("Modificar un disco:");
	        getContentPane().add(textoinfo);
	        textoinfo.setBounds(280, 30, 680, 70);

	        

	        

	        
	       

	        
	        
	      
		}
		
	    private void initGUI() {

	    	
	    	setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        setTitle("Modificar Disco");
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
			        textdvd.setBounds(610, 280, 270, 70);
					dvd.setFont(new java.awt.Font("Tahoma", 2, 24)); 
			        dvd.setForeground(new java.awt.Color(153, 153, 153));
			        getContentPane().add(dvd);
			        dvd.setBounds(880, 260, 250, 100);
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
			        
			        textprensado.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
			        textprensado.setForeground(new java.awt.Color(255, 255, 255));
			        textprensado.setText("Prensado:");
			        getContentPane().add(textprensado);
			        textprensado.setBounds(610, 280, 270, 70);
			        
			        
			        textrevoluciones.setFont(new java.awt.Font("Tahoma", 1, 36)); 
			        textrevoluciones.setForeground(new java.awt.Color(255, 255, 255));
			        textrevoluciones.setText("Revoluciones:");
			        getContentPane().add(textrevoluciones);
			        textrevoluciones.setBounds(610, 400, 270, 70);
			        
			        textgramaje.setFont(new java.awt.Font("Tahoma", 1, 48)); 
			        textgramaje.setForeground(new java.awt.Color(255, 255, 255));
			        textgramaje.setText("Gramaje:");
			        getContentPane().add(textgramaje);
			        textgramaje.setBounds(610, 520, 270, 70);

			       
			        
			        prensado.setFont(new java.awt.Font("Tahoma", 2, 24)); 
			        prensado.setForeground(new java.awt.Color(153, 153, 153));
			        
			        getContentPane().add(prensado);
			        prensado.setBounds(880, 260, 250, 100);
					
			        
			        revoluciones.setFont(new java.awt.Font("Tahoma", 2, 24)); 
			        revoluciones.setForeground(new java.awt.Color(153, 153, 153));
			        
			        getContentPane().add(revoluciones);
			        revoluciones.setBounds(880, 380, 250, 100);
			        
					gramaje.setFont(new java.awt.Font("Tahoma", 2, 24)); 
			        gramaje.setForeground(new java.awt.Color(153, 153, 153));
			        
			        getContentPane().add(gramaje);
			        gramaje.setBounds(880, 500, 250, 100);
			        
			       

			        
			        
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
	    private javax.swing.JTextField a�o;
	    private javax.swing.JButton cancelar;
	    private javax.swing.JButton confirmar;
	    private javax.swing.JTextField dvd;
	    private javax.swing.JButton fondo;
	    private javax.swing.JTextField id;
	    private javax.swing.JTextField genero;
	    private javax.swing.JTextField gramaje;
	    private javax.swing.JTextField nombre;
	    private javax.swing.JTextField precio;
	    private javax.swing.JTextField prensado;
	    private javax.swing.JTextField revoluciones;
	    private javax.swing.JTextField stock;
	    private javax.swing.JLabel textid;
	    private javax.swing.JLabel texta�o;
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
					case -1: JOptionPane.showMessageDialog(new JFrame(),"El disco es nulo", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					case -2: JOptionPane.showMessageDialog(new JFrame(),"Error sintactico", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					case -3: JOptionPane.showMessageDialog(new JFrame(),"El disco no existe", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					case -4: JOptionPane.showMessageDialog(new JFrame(),"El disco no esta activo", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					case -100: JOptionPane.showMessageDialog(new JFrame(),"Error en la gestion de la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					default:
						JOptionPane.showMessageDialog(new JFrame(),"Disco modificado con ID : " + id.intValue());
						break;
				}
			}
		}

}