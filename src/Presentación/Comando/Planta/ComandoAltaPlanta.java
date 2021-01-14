package Presentación.Comando.Planta;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Planta.SAPlanta;
import Negocio.Planta.TPlanta;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoAltaPlanta implements Command {

	@Override
	public Contexto execute(Object data) {
		FactoriaSA factoria = FactoriaSA.getInstancia();
		SAPlanta saplanta = factoria.generaSAPlanta();
		int resultado = saplanta.alta((TPlanta)(data));
		return new Contexto(Evento.ALTA_PLANTA, resultado);
	}

}
