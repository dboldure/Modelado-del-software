
package Presentación.ApplicationController.Imp;

import Presentación.Contexto;
import Presentación.GUI;
import Presentación.ApplicationController.ApplicationController;
import Presentación.Comando.Command;
import Presentación.Comando.Factoriacomando.CommandFactory;
import Presentación.FactoriaVista.FactoriaVista;

public class ApplicationControllerImp extends ApplicationController {

	@Override
	public void action(Contexto contexto) {
	
		
        Command command = CommandFactory.getInstance().CommandParser(contexto.getEvento());

		
		if(command != null) {
			
			contexto = command.execute(contexto.getDato());
		}
		
			FactoriaVista factoriaVista =FactoriaVista.getInstance();
			GUI vista =factoriaVista.generaVista(contexto);
			vista.update(contexto);
			if (contexto.getDato() != null){
				vista.dispose();
			}
			
				
			
		}
			
	}
