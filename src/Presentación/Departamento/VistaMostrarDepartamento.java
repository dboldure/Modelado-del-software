package Presentación.Departamento;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Negocio.Departamento.TDepartamento;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.GUI;
import Presentación.ResourcesAccess;
import Presentación.ApplicationController.ApplicationController;

public class VistaMostrarDepartamento extends JFrame implements GUI{
	
    private javax.swing.JButton cancelar;
    private javax.swing.JButton confirmar;
    private javax.swing.JButton fondo;
    private javax.swing.JTextField id;
    private javax.swing.JLabel textid;

	private static final long serialVersionUID = 1L;
	
	public VistaMostrarDepartamento(){
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
        setTitle("Mostrar Departamento");
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
            	if (id.getText()!= null){
            		try{
            			System.out.println(id.getText());
            			ApplicationController.getInstance().action(new Contexto(Evento.MOSTRAR_DEPARTAMENTO_OK, Integer.parseInt(id.getText())));
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
        textid.setText("Mostrar datos del departamento con id:");
        getContentPane().add(textid);
        textid.setBounds(110, 220, 970, 70);
        
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
			TDepartamento departamento = (TDepartamento) cont.getDato();
			String stringDepartamento = "";
			if(departamento != null){
				stringDepartamento += "ID: " + departamento.getId() + "\n" +
						"Nombre: " + departamento.getNombre() + "\n" + 
						"Activo: " + departamento.getActivo() + "\n" +
						"Teléfono: " + departamento.getTelefono() + "\n\n";
			}
			JFrame ventana = new JFrame("Mostrar");
			ventana.setLayout(new GridLayout());
			JPanel panel = new JPanel(new GridLayout());
			ventana.setLocationRelativeTo(null);
			ventana.setBounds(700, 480, 400, 310);
			JTextArea texto = new JTextArea(150, 150);
			texto.setText(stringDepartamento);
			texto.setEditable(false);
			panel.add(texto);
			ventana.add(panel);
			JScrollPane scroll = new JScrollPane(texto);
			panel.add(scroll);
			ventana.setVisible(true);
		}
		else if(cont.getEvento() == Evento.MOSTRAR_DEPARTAMENTO_KO){
			dispose();
			JOptionPane.showMessageDialog(new JFrame(),"El departamento no existe", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
