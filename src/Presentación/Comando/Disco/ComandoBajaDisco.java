package Presentaci�n.Comando.Disco;

import Negocio.Disco.SADisco;
import Negocio.FactoriaSA.FactoriaSA;
import Presentaci�n.Contexto;
import Presentaci�n.Evento;
import Presentaci�n.Comando.Command;

public class ComandoBajaDisco implements Command{

	@Override
	public Contexto execute(Object data) {
		FactoriaSA factoria = FactoriaSA.getInstancia();
		SADisco saDisco = factoria.generaSADisco();
		int resultado = saDisco.baja((Integer)data);
		
		return new Contexto(Evento.BAJA_DISCO,resultado);
		
		
	}

}
