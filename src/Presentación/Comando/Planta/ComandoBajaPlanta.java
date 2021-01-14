package Presentación.Comando.Planta;

import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoBajaPlanta implements Command {

	@Override
	public Contexto execute(Object data) {
		int resultado = FactoriaSA.getInstancia().generaSAPlanta().baja((Integer)data);
		return new Contexto(Evento.BAJA_PLANTA,resultado);
	}

}
