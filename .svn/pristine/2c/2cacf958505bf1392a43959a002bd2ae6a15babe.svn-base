package Presentación.Disco;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Negocio.Cliente.TCliente;
import Negocio.Disco.TDisco;
import Negocio.Disco.TDiscoCD;
import Negocio.Disco.TDiscoVinilo;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.GUI;
import Presentación.ResourcesAccess;
import Presentación.ApplicationController.ApplicationController;


public class VistaMostrarDisco extends JFrame implements GUI{
	
	private static final long serialVersionUID = 1L;
	
		public VistaMostrarDisco() {
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
	        setTitle("Mostrar Disco");
	        setMinimumSize(new java.awt.Dimension(1187, 792));
	        setResizable(false);
	        getContentPane().setLayout(null);

	        cancelar.setBackground(new java.awt.Color(255, 51, 51));
	        cancelar.setFont(new java.awt.Font("Tahoma", 1, 18));
	        cancelar.setText("Cancelar");
	        cancelar.addActionListener(new java.awt.event.ActionListener() {
	        	public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	Presentación.ApplicationController.ApplicationController.getInstance().action(new Contexto(Evento.CREAR_VISTA_DISCO, null));
	            	dispose();
	            }
	        });
	        getContentPane().add(cancelar);
	        cancelar.setBounds(690, 660, 210, 60);
	        cancelar.getAccessibleContext().setAccessibleName("Clientes");

	        confirmar.setBackground(new java.awt.Color(0, 204, 51));
	        confirmar.setFont(new java.awt.Font("Tahoma", 1, 18));
	        confirmar.setText("Confirmar");
	        confirmar.addActionListener(new java.awt.event.ActionListener() {
	        	public void actionPerformed(java.awt.event.ActionEvent evt) {
	        		if (id.getText()!= null){
	            		try{
	            			System.out.println(id.getText());
	            			ApplicationController.getInstance().action(new Contexto(Evento.MOSTRAR_DISCO_OK, Integer.parseInt(id.getText())));
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
	        textid.setText("Mostrar datos del disco con id:");
	        getContentPane().add(textid);
	        textid.setBounds(220, 220, 830, 70);

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
	    
	    public void initGUIMostrar(){
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
	        textgenero = new javax.swing.JLabel();
	        textoinfo = new javax.swing.JLabel();
	        textgramaje = new javax.swing.JLabel();
	        textrevoluciones = new javax.swing.JLabel();
	        textdvd = new javax.swing.JLabel();
	        textstock = new javax.swing.JLabel();
	        textprecio = new javax.swing.JLabel();
	        textprensado = new javax.swing.JLabel();
	        fondo = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        setTitle("Mostrar Disco");
	        setMinimumSize(new java.awt.Dimension(1187, 792));
	        setResizable(false);
	        getContentPane().setLayout(null);

	        cancelar.setBackground(new java.awt.Color(255, 51, 51));
	        cancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); 
	        cancelar.setText("Cancelar");
	        cancelar.addActionListener(new java.awt.event.ActionListener() {
	        	public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	Presentación.ApplicationController.ApplicationController.getInstance().action(new Contexto(Evento.CREAR_VISTA_DISCO, null));
	            	//new VistaCliente();
	            	dispose();
	            }
	        });
	        getContentPane().add(cancelar);
	        cancelar.setBounds(690, 660, 210, 60);
	        cancelar.getAccessibleContext().setAccessibleName("Clientes");

	        confirmar.setBackground(new java.awt.Color(0, 204, 51));
	        confirmar.setFont(new java.awt.Font("Tahoma", 1, 18)); 
	        confirmar.setText("Confirmar");
	        confirmar.addActionListener(new java.awt.event.ActionListener() {
	        	public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	Presentación.ApplicationController.ApplicationController.getInstance().action(new Contexto(Evento.GUI_MOSTRAR, null));
	               
	            }
	        });
	        getContentPane().add(confirmar);
	        confirmar.setBounds(930, 660, 210, 60);

	        nombre.setFont(new java.awt.Font("Tahoma", 2, 36)); 
	        nombre.setForeground(new java.awt.Color(153, 153, 153));

	        getContentPane().add(nombre);
	        nombre.setBounds(300, 140, 250, 100);

	        año.setFont(new java.awt.Font("Tahoma", 2, 36));
	        año.setForeground(new java.awt.Color(153, 153, 153));

	        getContentPane().add(año);
	        año.setBounds(300, 250, 250, 100);

	        revoluciones.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        revoluciones.setForeground(new java.awt.Color(153, 153, 153));

	        getContentPane().add(revoluciones);
	        revoluciones.setBounds(880, 260, 250, 100);

	        prensado.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        prensado.setForeground(new java.awt.Color(153, 153, 153));

	        getContentPane().add(prensado);
	        prensado.setBounds(880, 510, 250, 100);

	        dvd.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        dvd.setForeground(new java.awt.Color(153, 153, 153));

	        getContentPane().add(dvd);
	        dvd.setBounds(880, 140, 250, 100);

	        genero.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        genero.setForeground(new java.awt.Color(153, 153, 153));

	        getContentPane().add(genero);
	        genero.setBounds(300, 580, 250, 100);

	        precio.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        precio.setForeground(new java.awt.Color(153, 153, 153));

	        getContentPane().add(precio);
	        precio.setBounds(300, 360, 250, 100);

	        gramaje.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        gramaje.setForeground(new java.awt.Color(153, 153, 153));
	        
	        getContentPane().add(gramaje);
	        gramaje.setBounds(880, 380, 250, 100);

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

	        textgenero.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textgenero.setForeground(new java.awt.Color(255, 255, 255));
	        textgenero.setText("Género:");
	        getContentPane().add(textgenero);
	        textgenero.setBounds(60, 600, 210, 70);

	        textoinfo.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textoinfo.setForeground(new java.awt.Color(255, 255, 255));
	        textoinfo.setText("Mostrar datos del disco:");
	        getContentPane().add(textoinfo);
	        textoinfo.setBounds(300, 30, 650, 70);

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

	        textdvd.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textdvd.setForeground(new java.awt.Color(255, 255, 255));
	        textdvd.setText("DVD:");
	        getContentPane().add(textdvd);
	        textdvd.setBounds(610, 150, 210, 70);

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

	        textprensado.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textprensado.setForeground(new java.awt.Color(255, 255, 255));
	        textprensado.setText("Prensado:");
	        getContentPane().add(textprensado);
	        textprensado.setBounds(620, 520, 250, 70);

	        fondo.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.FONDO_MADERA_DIR))); 
	        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.FONDO_MADERA_DIR))); 
	        fondo.setEnabled(false);
	        fondo.setMinimumSize(new java.awt.Dimension(1187, 792));
	        getContentPane().add(fondo);
	        fondo.setBounds(0, 0, 1190, 760);

	        pack();
	        setLocationRelativeTo(null);
	        this.setVisible(true);
	    }
                    
	    private javax.swing.JButton cancelar;
	    private javax.swing.JButton confirmar;
	    private javax.swing.JButton fondo;
	    private javax.swing.JTextField id;
	    private javax.swing.JLabel textid;
	    private javax.swing.JTextField año;
	    private javax.swing.JTextField dvd;
	    private javax.swing.JTextField genero;
	    private javax.swing.JTextField gramaje;
	    private javax.swing.JTextField nombre;
	    private javax.swing.JTextField precio;
	    private javax.swing.JTextField prensado;
	    private javax.swing.JTextField revoluciones;
	    private javax.swing.JTextField stock;
	    private javax.swing.JLabel textaño;
	    private javax.swing.JLabel textdvd;
	    private javax.swing.JLabel textgenero;
	    private javax.swing.JLabel textgramaje;
	    private javax.swing.JLabel textnombre;
	    private javax.swing.JLabel textoinfo;
	    private javax.swing.JLabel textprecio;
	    private javax.swing.JLabel textprensado;
	    private javax.swing.JLabel textrevoluciones;
	    private javax.swing.JLabel textstock;
	    
		@Override
		public void update(Contexto cont) {
			//if(cont.getEvento() == Evento.MOSTRAR_DISCO_OK)
			if(cont.getDato() != null)
			{
				TDisco disco = (TDisco) cont.getDato();

				String stringDisco = "";
				if (disco != null){
					
					
					stringDisco += "ID: " + disco.getId() + "\n" +
							"Nombre: " + disco.getNombre() + "\n" +
							"Género: " + disco.getGenero() + "\n" +
							"Precio: " + disco.getPrecio() + "\n" +
							"Año: " + disco.getAño() + "\n" +
							"Stock: " + disco.getStock() + "\n" +
							"Activo: " + disco.getActivo() + "\n";
					
							if (disco instanceof TDiscoCD){
								stringDisco += "DVD: " + ((TDiscoCD) disco).getDvd();
							}
							else {
								stringDisco += "Prensado: " + ((TDiscoVinilo) disco).getPrensado() + "\n" +
								"Gramaje: " + ((TDiscoVinilo) disco).getGramaje() + "\n" +
								"Revoluciones: " + ((TDiscoVinilo) disco).getRevoluciones();
							}
					

				}
				JFrame ventana = new JFrame("Mostrar");
				ventana.setLayout(new GridLayout());
				JPanel panel = new JPanel(new GridLayout());
				ventana.setLocationRelativeTo(null);
				ventana.setBounds(700, 480, 400, 310);
				JTextArea texto = new JTextArea(150, 150);
				texto.setText(stringDisco);
				texto.setEditable(false);
				panel.add(texto);
				ventana.add(panel);
				JScrollPane scroll = new JScrollPane(texto);
				panel.add(scroll);
				ventana.setVisible(true);
				
				
			}
			else if(cont.getEvento() == Evento.MOSTRAR_DISCO_KO){
				dispose();
				JOptionPane.showMessageDialog(new JFrame(),"El disco no existe", "Error", JOptionPane.ERROR_MESSAGE);
				
			}
			/*if(cont.getEvento() == Evento.MOSTRAR_DISCO_OK)
			{
				TDisco disco = (TDisco) cont.getDato();
				TDiscoCD dvdT = (TDiscoCD) cont.getDato();
				TDiscoVinilo vinilo = (TDiscoVinilo) cont.getDato();
				
				nombre.setText(disco.getNombre());
				año.setText(""+disco.getAño());
				genero.setText(disco.getGenero());
				stock.setText(""+disco.getStock());
				dvd.setText(""+dvdT.getDvd());
				gramaje.setText(""+vinilo.getGramaje());
				revoluciones.setText(""+vinilo.getRevoluciones());
				prensado.setText(vinilo.getPrensado());
			}	*/
		}

}
