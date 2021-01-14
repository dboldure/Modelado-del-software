package Presentación.Comando.Disco;

import Negocio.Disco.SADisco;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoBajaDisco implements Command{

	@Override
	public Contexto execute(Object data) {
		FactoriaSA factoria = FactoriaSA.getInstancia();
		SADisco saDisco = factoria.generaSADisco();
		int resultado = saDisco.baja((Integer)data);
		
		return new Contexto(Evento.BAJA_DISCO,resultado);
		
		
	}

}
