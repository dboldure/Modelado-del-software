package Presentación.Comando.Planta;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Planta.TPlanta;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoModificarPlanta implements Command {

	@Override
	public Contexto execute(Object data) {
		int resultado = FactoriaSA.getInstancia().generaSAPlanta().modificar((TPlanta)(data));
		return new Contexto(Evento.MODIFICAR_PLANTA, resultado);

	}

}
