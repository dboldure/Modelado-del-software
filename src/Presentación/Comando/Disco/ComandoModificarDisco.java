package Presentaci�n.Comando.Disco;

import Negocio.Disco.SADisco;
import Negocio.Disco.TDisco;
import Negocio.FactoriaSA.FactoriaSA;
import Presentaci�n.Contexto;
import Presentaci�n.Evento;
import Presentaci�n.Comando.Command;

public class ComandoModificarDisco implements Command{

	@Override
	public Contexto execute(Object data) {
		int resultado = FactoriaSA.getInstancia().generaSADisco().modificar((TDisco)(data));
		
		return new Contexto(Evento.MODIFICAR_DISCO,resultado);
	}

}
