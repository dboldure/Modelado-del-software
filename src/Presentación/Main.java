package Presentación;
//HECHO
import java.awt.Dimension;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Presentación.ApplicationController.ApplicationController;

public class Main {

		public static Dimension WINDOW_DIM = new Dimension(1000, 70);
		
		public static void main(String[] args) {

			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					
					try {
						
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					
					} catch (ClassNotFoundException e) {
						
						e.printStackTrace();
					
					} catch (InstantiationException e) {
						
						e.printStackTrace();
					
					} catch (IllegalAccessException e) {
						
						e.printStackTrace();
					
					} catch (UnsupportedLookAndFeelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					
					ApplicationController.getInstance().action(new Contexto(Evento.GUI_MOSTRAR,null));
					
				}
				
			});
			
		}


	}

