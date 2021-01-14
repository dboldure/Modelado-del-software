package Presentación.Comando.Disco;

import Negocio.Disco.SADisco;
import Negocio.Disco.TDisco;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoMostrarDisco implements Command {

	@Override
	public Contexto execute(Object data) {
		FactoriaSA factoria= FactoriaSA.getInstancia();
		SADisco saDisco= factoria.generaSADisco();
		TDisco disco = saDisco.mostrar((Integer)data);
		if(disco.getId()!= null) 
			return new Contexto(Evento.MOSTRAR_DISCO,disco);
		else return new Contexto(Evento.MOSTRAR_DISCO_KO,disco);
	}

}
