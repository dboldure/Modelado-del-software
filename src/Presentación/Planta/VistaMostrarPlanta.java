package Presentaci�n.Planta;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Negocio.Planta.TEnsamblado;
import Presentaci�n.Contexto;
import Presentaci�n.Evento;
import Presentaci�n.GUI;
import Presentaci�n.ResourcesAccess;
import Presentaci�n.ApplicationController.ApplicationController;

public class VistaMostrarPlanta extends JFrame implements GUI{
	
	private JButton cancelar;
    private JButton confirmar;
    private JButton fondo;
    private JTextField id;
	private JLabel textid;
	private static final long serialVersionUID = 1L;

	JFrame datos;
	
	public VistaMostrarPlanta(){
		super();
		initGUI();
	}
	
	
	private void initGUI(){		
		cancelar = new JButton();
        confirmar = new JButton();
        id = new JTextField();
        textid = new JLabel();
        fondo = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mostrar Planta");
        setMinimumSize(new Dimension(1187, 792));
        setResizable(false);
        getContentPane().setLayout(null);

        cancelar.setBackground(new Color(255, 51, 51));
        cancelar.setFont(new Font("Tahoma", 1, 18)); 
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });
        getContentPane().add(cancelar);
        cancelar.setBounds(690, 660, 210, 60);

        confirmar.setBackground(new Color(0, 204, 51));
        confirmar.setFont(new Font("Tahoma", 1, 18));
        confirmar.setText("Confirmar");
        confirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if (id.getText()!= null){
            		try{
            			System.out.println(id.getText());
            			ApplicationController.getInstance().action(new Contexto(Evento.MOSTRAR_PLANTA_OK, Integer.parseInt(id.getText())));
            		}catch(NumberFormatException n){
            			JOptionPane.showMessageDialog(new JFrame(), "Error en los datos", "Error", JOptionPane.ERROR_MESSAGE);
            			}
            		}
            	dispose();
            }
        });
        getContentPane().add(confirmar);
        confirmar.setBounds(930, 660, 210, 60);

        id.setFont(new Font("Tahoma", 2, 24)); 
        id.setForeground(new Color(153, 153, 153));
        
        getContentPane().add(id);
        id.setBounds(470, 310, 250, 100);

        textid.setFont(new Font("Tahoma", 1, 48)); 
        textid.setForeground(new Color(255, 255, 255));
        textid.setText("Mostrar la planta con id:");
        getContentPane().add(textid);
        textid.setBounds(260, 210, 710, 70);

        fondo.setIcon(new ImageIcon(getClass().getResource(ResourcesAccess.FONDO_MADERA_DIR)));
        fondo.setDisabledIcon(new ImageIcon(getClass().getResource(ResourcesAccess.FONDO_MADERA_DIR)));
        fondo.setEnabled(false);
        fondo.setMaximumSize(new Dimension(1187, 792));
        fondo.setMinimumSize(new Dimension(1187, 792));
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 1190, 760);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
	}



	@Override
	public void update(Contexto cont) {
		if(cont.getDato() != null){
			TEnsamblado ensamblado = (TEnsamblado)cont.getDato();
			String stringPlanta= "";
			if (ensamblado != null){
				stringPlanta += "ID: " + ensamblado.getPlanta().getId() + "\n" + "N�mero: " + ensamblado.getPlanta().getNumero() + "\n" +
						"Activo: " + ensamblado.getPlanta().getActivo() + "\n\n";
				int i = 0;
			
				while (i < ensamblado.getDepartamentos().size()){
					
					stringPlanta += "Tiene el departamento:\n" +
					
							"ID: " + ensamblado.getDepartamentos().get(i).getId() + "\n" +
							"Nombre: " + ensamblado.getDepartamentos().get(i).getNombre() + "\n" + 
							"Activo: " + ensamblado.getDepartamentos().get(i).getActivo() + "\n" +
							"Tel�fono: " + ensamblado.getDepartamentos().get(i).getTelefono() + "\n"+
					
					"Con superficie de " + ensamblado.getPlantaDepartamento().get(i).getMetros() + "m\n\n";
					
					i++;
				}
			}
			JFrame ventana = new JFrame("Mostrar");
			ventana.setLayout(new GridLayout());
			JPanel panel = new JPanel(new GridLayout());
			ventana.setLocationRelativeTo(null);
			ventana.setBounds(700, 480, 400, 310);
			JTextArea texto = new JTextArea(150, 150);
			texto.setText(stringPlanta);
			texto.setEditable(false);
			panel.add(texto);
			ventana.add(panel);
			JScrollPane scroll = new JScrollPane(texto);
			panel.add(scroll);
			ventana.setVisible(true);
			
		}
		else if(cont.getEvento() == Evento.MOSTRAR_PLANTA_KO){
			dispose();
			JOptionPane.showMessageDialog(new JFrame(),"La planta no existe", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
	}	
}
