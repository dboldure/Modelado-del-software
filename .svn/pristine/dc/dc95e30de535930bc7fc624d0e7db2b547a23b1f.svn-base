package Presentación.Factura;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Negocio.Disco.TDiscoCD;
import Negocio.Disco.TDiscoVinilo;
import Negocio.Factura.TEnsamblado;
import Negocio.Factura.TFactura;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.GUI;
import Presentación.ResourcesAccess;
import Presentación.ApplicationController.ApplicationController;

public class VistaBuscarFactura extends JFrame implements GUI{

	private static final long serialVersionUID = 1L;
	
    
	private javax.swing.JButton cancelar;
	private javax.swing.JButton confirmar;
	private javax.swing.JButton fondo;
	private javax.swing.JTextField id;
	private javax.swing.JLabel textid;
	
	public VistaBuscarFactura() {
        super();
        initGUI();
    }
                    
    private void initGUI(){

        cancelar = new javax.swing.JButton();
        confirmar = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        textid = new javax.swing.JLabel();
        fondo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Factura");
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
                if(id.getText() != null){
                	try{
                		ApplicationController.getInstance().action(new Contexto(Evento.MOSTRAR_FACTURA_OK, Integer.parseInt(id.getText())));
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
        textid.setText("Buscar factura existente con id:");
        getContentPane().add(textid);
        textid.setBounds(220, 220, 830, 70);

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
		
		if(cont.getDato() != null)
		{
		
		
		TEnsamblado ensamblado = (TEnsamblado) cont.getDato();
		
		String stringFactura = "";
		if(ensamblado != null){
			stringFactura +=  "La factura: \n" + "ID " + ensamblado.getFactura().getId() + "\n" +
					"ID Cliente: " + ensamblado.getFactura().getIdCliente() + "\n" +
					"Precio: " + ensamblado.getFactura().getPrecioTotal() + "\n" + 
					"Fecha: " + ensamblado.getFactura().getFecha() + "\n\n\nTiene los siguientes discos: \n\n";
					//"Activo: " + ensamblado.getFactura().getActivo() + "\n\n\nTiene los siguientes discos: \n\n";
			
			for(int i = 0; i < ensamblado.getLineasFactura().size(); i++){
				stringFactura += "ID: " + ensamblado.getDiscos().get(i).getId() + "\n" +
						"Nombre: " + ensamblado.getDiscos().get(i).getNombre() + "\n" +
						"Género: " + ensamblado.getDiscos().get(i).getGenero() + "\n" +
						// Muestra precio cuando se compro:
						//"Precio: " + ensamblado.getLineasFactura().get(i).getPrecio()/ensamblado.getLineasFactura().get(i).getCantidad() + "\n" +
						// Muestra precio actual:
						"Precio: " + ensamblado.getDiscos().get(i).getPrecio() + "\n" +
						"Año: " + ensamblado.getDiscos().get(i).getAño() + "\n" +
						"Stock: " + ensamblado.getDiscos().get(i).getStock() + "\n";
						//"Activo: " + ensamblado.getDiscos().get(i).getActivo() + "\n";
				
						if (ensamblado.getDiscos().get(i) instanceof TDiscoCD){
							TDiscoCD disco = (TDiscoCD) ensamblado.getDiscos().get(i);
							stringFactura += "DVD: " + disco.getDvd() + "\n";
						}
						else {
							TDiscoVinilo disco = (TDiscoVinilo) ensamblado.getDiscos().get(i);
							stringFactura += "Prensado: " + disco.getPrensado() + "\n" +
							"Gramaje: " + disco.getGramaje() + "\n" +
							"Revoluciones: " + disco.getRevoluciones() + "\n";
						}
				
				
						stringFactura += "Cantidad comprada: " + ensamblado.getLineasFactura().get(i).getCantidad() + "\n" +
						"Precio total: " + ensamblado.getLineasFactura().get(i).getPrecio() + "\n\n";
			}
			
			
			
		}
		JFrame ventana = new JFrame("Datos");
		ventana.setLayout(new GridLayout());
		JPanel panel = new JPanel(new GridLayout());
		ventana.setLocationRelativeTo(null);
		ventana.setBounds(700, 480, 400, 310);
		JTextArea texto = new JTextArea(150,150);
		texto.setText(stringFactura);
		texto.setEditable(false);
		panel.add(texto);
		ventana.add(panel);
		JScrollPane scroll = new JScrollPane(texto);
		panel.add(scroll);
		ventana.setVisible(true);
	
		}
		else if(cont.getEvento() == Evento.MOSTRAR_FACTURA_KO){
			dispose();
			JOptionPane.showMessageDialog(new JFrame(),"La factura no existe", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
	}
}
