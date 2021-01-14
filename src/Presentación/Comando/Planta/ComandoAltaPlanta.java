package Presentaci�n.Comando.Planta;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Planta.SAPlanta;
import Negocio.Planta.TPlanta;
import Presentaci�n.Contexto;
import Presentaci�n.Evento;
import Presentaci�n.Comando.Command;

public class ComandoAltaPlanta implements Command {

	@Override
	public Contexto execute(Object data) {
		FactoriaSA factoria = FactoriaSA.getInstancia();
		SAPlanta saplanta = factoria.generaSAPlanta();
		int resultado = saplanta.alta((TPlanta)(data));
		return new Contexto(Evento.ALTA_PLANTA, resultado);
	}

}
