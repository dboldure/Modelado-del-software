package Presentación.Comando.Planta;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Planta.TEnsamblado;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoMostrarPlanta implements Command {

	@Override
	public Contexto execute(Object data) {
		TEnsamblado planta = FactoriaSA.getInstancia().generaSAPlanta().mostrar((Integer)(data));
		if(planta != null)
			return new Contexto(Evento.MOSTRAR_PLANTA, planta);
		else return new Contexto(Evento.MOSTRAR_PLANTA_KO, planta);

	}

}
