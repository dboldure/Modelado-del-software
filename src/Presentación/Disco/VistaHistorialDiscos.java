package Presentación.Disco;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Negocio.Disco.TDisco;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.GUI;
import Presentación.ResourcesAccess;

public class VistaHistorialDiscos extends JFrame implements GUI{

	private static final long serialVersionUID = 1L;
		public VistaHistorialDiscos() {
	    	super();
	        initGUI();
	    }
                      
	    private void initGUI() {

	        cancelar = new javax.swing.JButton();
	        confirmar = new javax.swing.JButton();
	        fechainicio = new javax.swing.JTextField();
	        fechafinal = new javax.swing.JTextField();
	        textfechainicio = new javax.swing.JLabel();
	        textfechafinal = new javax.swing.JLabel();
	        textoinfo = new javax.swing.JLabel();
	        fondo = new javax.swing.JButton();

	        setVisible(true);
	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	        setTitle("Listar Discos Vendidos");
	        setMinimumSize(new java.awt.Dimension(1187, 792));
	        setResizable(false);
	        getContentPane().setLayout(null);

	        cancelar.setBackground(new java.awt.Color(255, 51, 51));
	        cancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
	        cancelar.setText("Cancelar");
	        cancelar.addActionListener(new java.awt.event.ActionListener() {
	        	public void actionPerformed(java.awt.event.ActionEvent evt) {
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
	            	
	            	if(!fechainicio.getText().equalsIgnoreCase("") && !fechafinal.getText().equalsIgnoreCase("")){
	            
	            		ArrayList<String> fechas = new ArrayList<String>();
	            		fechas.add(fechainicio.getText());
	            		fechas.add(fechafinal.getText());
	            		try{
	            			Presentación.ApplicationController.ApplicationController.getInstance().action(new Contexto(Evento.HISTORIAL_DISCO_OK, fechas));
	            		} catch(Exception ex){
	            			JOptionPane.showMessageDialog(new JFrame(), "Informacion Erronea", "Error", JOptionPane.ERROR_MESSAGE);
	            		}
	            	}
	            	dispose();
	            }
	        });
	        getContentPane().add(confirmar);
	        confirmar.setBounds(930, 660, 210, 60);

	        fechainicio.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        fechainicio.setForeground(new java.awt.Color(153, 153, 153));
	        
	        getContentPane().add(fechainicio);
	        fechainicio.setBounds(560, 260, 250, 100);

	        fechafinal.setFont(new java.awt.Font("Tahoma", 2, 24)); 
	        fechafinal.setForeground(new java.awt.Color(153, 153, 153));
	       
	        getContentPane().add(fechafinal);
	        fechafinal.setBounds(560, 380, 250, 100);

	        textfechainicio.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textfechainicio.setForeground(new java.awt.Color(255, 255, 255));
	        textfechainicio.setText("Fecha inicio:");
	        getContentPane().add(textfechainicio);
	        textfechainicio.setBounds(220, 270, 320, 70);

	        textfechafinal.setFont(new java.awt.Font("Tahoma", 1, 48));
	        textfechafinal.setForeground(new java.awt.Color(255, 255, 255));
	        textfechafinal.setText("Fecha final:");
	        getContentPane().add(textfechafinal);
	        textfechafinal.setBounds(220, 390, 320, 70);

	        textoinfo.setFont(new java.awt.Font("Tahoma", 1, 48)); 
	        textoinfo.setForeground(new java.awt.Color(255, 255, 255));
	        textoinfo.setText("Listar discos vendidos entre las fechas:");
	        getContentPane().add(textoinfo);
	        textoinfo.setBounds(140, 140, 960, 70);

	        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.FONDO_MADERA_DIR))); 
	        fondo.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource(ResourcesAccess.FONDO_MADERA_DIR)));
	        fondo.setEnabled(false);
	        fondo.setMaximumSize(new java.awt.Dimension(1187, 792));
	        fondo.setMinimumSize(new java.awt.Dimension(1187, 792));
	        getContentPane().add(fondo);
	        fondo.setBounds(0, 0, 1190, 760);

	        pack();
	        setLocationRelativeTo(null);
	    }                       

	                     
	    private javax.swing.JButton cancelar;
	    private javax.swing.JButton confirmar;
	    private javax.swing.JTextField fechafinal;
	    private javax.swing.JTextField fechainicio;
	    private javax.swing.JButton fondo;
	    private javax.swing.JLabel textfechafinal;
	    private javax.swing.JLabel textfechainicio;
	    private javax.swing.JLabel textoinfo;
		@Override
		
		public void update(Contexto contexto) {
			if(contexto.getDato() != null)
			{
			
				ArrayList<TDisco> discos = (ArrayList<TDisco>)contexto.getDato();
				String stringDiscos = "";
	    		if (discos != null){
	    			
	    			for (TDisco disco : discos) {
	    				stringDiscos += "ID: " + disco.getId() + "\n" +
	    						"Nombre: " + disco.getNombre() + "\n" +
	    						"Género: " + disco.getGenero() + "\n" +
	    						"Precio: " + disco.getPrecio() + "\n\n";
	    			}
	    	
	    		}
	    		
	    		if (discos.isEmpty()) stringDiscos += "Ninguno";
	    		
	    		JFrame ventana = new JFrame("Datos");
	    		ventana.setLayout(new GridLayout());
	    		JPanel panel = new JPanel(new GridLayout());
	    		ventana.setLocationRelativeTo(null);
	    		ventana.setBounds(700, 480, 400, 310);
	    		JTextArea texto = new JTextArea(150, 150);
	    		texto.setText(stringDiscos);
	    		texto.setEditable(false);
	    		panel.add(texto);
	    		ventana.add(panel);
	    		JScrollPane scroll = new JScrollPane(texto);
	    		panel.add(scroll);
	    		ventana.setVisible(true);
			}
			else if(contexto.getEvento() == Evento.HISTORIAL_DISCO_KO){
				dispose();
				JOptionPane.showMessageDialog(new JFrame(),"Error en las fechas", "Error", JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
	                  

}

