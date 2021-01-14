
package Presentación.Comando.Factoriacomando;

import Presentación.Evento;
import Presentación.Comando.Command;
import Presentación.Comando.Factoriacomando.Imp.CommandFactoryImp;


public abstract class CommandFactory {
	
	private static CommandFactory instance;

	public static CommandFactory getInstance() {
		if(instance == null)
			instance = new CommandFactoryImp();
		return instance;
	}

	public abstract Command CommandParser(Evento evento);

	
}