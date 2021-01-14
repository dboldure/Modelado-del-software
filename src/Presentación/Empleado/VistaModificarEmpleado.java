package Presentación.Empleado;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Negocio.Empleado.TEmpleado;
import Negocio.Empleado.TEmpleadoCompleto;
import Negocio.Empleado.TEmpleadoParcial;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.GUI;
import Presentación.ResourcesAccess;
import Presentación.ApplicationController.ApplicationController;

public class VistaModificarEmpleado extends JFrame implements GUI{

	private static final long serialVersionUID = 1L;
	
Font commonFont = new Font("Tahoma", 1, 20);
	
	private JButton cancelar;
    private JButton confirmar;
    
    private JButton fondo;
    private JLabel textoinfo;
    
    private JTextField id;
    private JTextField dni;
    private JTextField nombre;
    private JTextField telefono;
    private JTextField sueldo;
    private JTextField departamento;
    private JTextField horas;
    
    private JLabel textId;
    private JLabel textdni;
    private JLabel textnombre;
    private JLabel textTelefono;
    private JLabel textSueldo;
    private JLabel textDepartamento;
    private JLabel textHoras;
	public VistaModificarEmpleado(){
		super();
		initGUI();
	}
	
	private void initGUI(){
		cancelar = new JButton();
        confirmar = new JButton();
        id = new JTextField();
        nombre = new JTextField();
        dni = new JTextField();
        telefono = new JTextField();
        sueldo = new JTextField();
        departamento = new JTextField();
        horas = new JTextField();
        
        textId = new JLabel();
        textnombre = new JLabel();
        textdni = new JLabel();
        textoinfo = new JLabel();
        fondo = new JButton();
        textTelefono = new JLabel();
        textSueldo = new JLabel();
        textDepartamento = new JLabel();
        textHoras = new JLabel();
        //new JLabel();
        
        JCheckBox employeeType = new JCheckBox();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar Empleado");
        setMinimumSize(new Dimension(1187, 792));
        setResizable(false);
        getContentPane().setLayout(null);

        cancelar.setBackground(new Color(255, 51, 51));
        cancelar.setFont(commonFont);
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });
        getContentPane().add(cancelar);
        cancelar.setBounds(690, 660, 210, 60);

        confirmar.setBackground(new Color(0, 204, 51));
        confirmar.setFont(commonFont); 
        confirmar.setText("Confirmar");
        confirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	TEmpleado empleado;
            	try{
            		
            		Integer Dep = null, Horas = null;
            		Float Sueldo = null;
            		
            		if (!departamento.getText().equals("")) Dep = Integer.parseInt(departamento.getText());
            		if (!horas.getText().equals("")) Horas = Integer.parseInt(horas.getText());
            		if (!sueldo.getText().equals("")) Sueldo = Float.parseFloat(sueldo.getText());
            		
            		if(employeeType.isSelected())
            			empleado = new TEmpleadoParcial(Integer.parseInt(id.getText()), nombre.getText(), true, dni.getText(), telefono.getText(), Sueldo, Dep, Horas);
            		else
            			empleado = new TEmpleadoCompleto(Integer.parseInt(id.getText()), nombre.getText(), true, dni.getText(), telefono.getText(), Sueldo, Dep, Horas);
					
					ApplicationController.getInstance().action(new Contexto(Evento.MODIFICAR_EMPLEADO_OK, empleado));
					dispose();
				}catch(NumberFormatException n){
					JOptionPane.showMessageDialog(new JFrame(), "Hay que introducir el Id", "Error", JOptionPane.ERROR_MESSAGE);
				}
				dispose();
            }
		});
        getContentPane().add(confirmar);
        confirmar.setBounds(930, 660, 210, 60);
        
        //id---------------------------------------
        
        id.setFont(new Font("Tahoma", 2, 20)); 
        id.setForeground(new Color(153, 153, 153));

        getContentPane().add(id);
        id.setBounds(550, 70, 200, 50);
        
	        textId.setFont(commonFont); 
	        textId.setForeground(new Color(255, 255, 255));
	        textId.setText("Id:");
	        getContentPane().add(textId);
	        textId.setBounds(200, 70, 200, 50);

        //nombre---------------------------------------
        
        nombre.setFont(new Font("Tahoma", 2, 20)); 
        nombre.setForeground(new Color(153, 153, 153));

        getContentPane().add(nombre);
        nombre.setBounds(550, 150, 200, 50);
        
	        textnombre.setFont(commonFont); 
	        textnombre.setForeground(new Color(255, 255, 255));
	        textnombre.setText("Nombre:");
	        getContentPane().add(textnombre);
	        textnombre.setBounds(200, 150, 200, 50);
        
        //dni-----------------------------------------

        dni.setFont(new Font("Tahoma", 2, 24)); 
        dni.setForeground(new Color(153, 153, 153));

        getContentPane().add(dni);
        dni.setBounds(550, 230, 200, 50);
        
	        textdni.setFont(commonFont); 
	        textdni.setForeground(new Color(255, 255, 255));
	        textdni.setText("DNI:");
	        getContentPane().add(textdni);
	        textdni.setBounds(200, 230, 200, 50);
        
        //telefono-------------------------------------
        
        telefono.setFont(commonFont); 
        telefono.setForeground(new Color(153, 153, 153));

        getContentPane().add(telefono);
        telefono.setBounds(550, 310, 200, 50);
        
	        textTelefono.setFont(commonFont); 
	        textTelefono.setForeground(new Color(255, 255, 255));
	        textTelefono.setText("Teléfono:");
	        getContentPane().add(textTelefono);
	        textTelefono.setBounds(200, 310, 200, 50);
        
        //departamento---------------------------------
        
        departamento.setFont(commonFont); 
        departamento.setForeground(new Color(153, 153, 153));

        getContentPane().add(departamento);
        departamento.setBounds(550, 390, 200, 50);
        
	        textDepartamento.setFont(commonFont); 
	        textDepartamento.setForeground(new Color(255, 255, 255));
	        textDepartamento.setText("Departamento:");
	        getContentPane().add(textDepartamento);
	        textDepartamento.setBounds(200, 390, 200, 50);
        
        //sueldo---------------------------------------
        
        sueldo.setFont(new Font("Tahoma", 2, 24)); 
        sueldo.setForeground(new Color(153, 153, 153));

        getContentPane().add(sueldo);
        sueldo.setBounds(550, 480, 200, 50);
        
	        textSueldo.setFont(commonFont); 
	        textSueldo.setForeground(new Color(255, 255, 255));
	        textSueldo.setText("Sueldo Base:");
	        getContentPane().add(textSueldo);
	        textSueldo.setBounds(200, 480, 200, 50);
	        

	  //specialiced
	        
	        employeeType.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					if(employeeType.isSelected())
						textHoras.setText("Horas dia (parcial): ");
					else
						textHoras.setText("Horas semana (completo): ");
					
				}
	        	
	        });
	        getContentPane().add(employeeType);
	        employeeType.setBounds(550, 555, 20, 20);
	        JLabel eType = new JLabel("Parcial: ");
	        eType.setFont(commonFont); 
	        eType.setForeground(new Color(255, 255, 255));
	        getContentPane().add(eType);
	        eType.setBounds(200, 550, 200, 20);
	        
      //horas semana------------------------------------
        
        horas.setFont(new Font("Tahoma", 2, 24)); 
        horas.setForeground(new Color(153, 153, 153));

        getContentPane().add(horas);
        horas.setBounds(550, 600, 200, 50);
        
	        textHoras.setFont(commonFont); 
	        textHoras.setForeground(new Color(255, 255, 255));
	        textHoras.setText("Horas semana (completo): ");
	        getContentPane().add(textHoras);
	        textHoras.setBounds(200, 600, 500, 50);  
        
        

        

        

        textoinfo.setFont(commonFont); 
        textoinfo.setForeground(new Color(255, 255, 255));
        textoinfo.setText("Modificar al empleado:");
        getContentPane().add(textoinfo);
        textoinfo.setBounds(350, 0, 530, 70);

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
	public void update(Contexto contexto) {
		if (contexto.getDato() != null){
			Integer id = (Integer)contexto.getDato();
			
			switch((int)contexto.getDato()){
				case -1: JOptionPane.showMessageDialog(new JFrame(),"El empleado es null", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -2: JOptionPane.showMessageDialog(new JFrame(),"El empleado no existe", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -3: JOptionPane.showMessageDialog(new JFrame(),"El empleado no está activo", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -4: JOptionPane.showMessageDialog(new JFrame(),"El departamento no existe", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -5: JOptionPane.showMessageDialog(new JFrame(),"El departamento no está activo", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -6: JOptionPane.showMessageDialog(new JFrame(),"El empleado no es del mismo tipo que el ya existente", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -7: JOptionPane.showMessageDialog(new JFrame(),"El Dni ya está en uso", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				case -100: JOptionPane.showMessageDialog(new JFrame(),"Error en la gestion de la Base de Datos", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				default:
					JOptionPane.showMessageDialog(new JFrame(),"Empleado con ID:  " + id.intValue() + " ha sido modificado" );
					break;
			}
		}
	}
	
}

