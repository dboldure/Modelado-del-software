
package Presentaci�n.Comando.Factoriacomando;

import Presentaci�n.Evento;
import Presentaci�n.Comando.Command;
import Presentaci�n.Comando.Factoriacomando.Imp.CommandFactoryImp;


public abstract class CommandFactory {
	
	private static CommandFactory instance;

	public static CommandFactory getInstance() {
		if(instance == null)
			instance = new CommandFactoryImp();
		return instance;
	}

	public abstract Command CommandParser(Evento evento);

	
}