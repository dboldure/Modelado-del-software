package Presentaci�n.Comando.Planta;

import java.util.ArrayList;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Planta.TPlanta;
import Presentaci�n.Contexto;
import Presentaci�n.Evento;
import Presentaci�n.Comando.Command;

public class ComandoListarPlanta implements Command {

	@Override
	public Contexto execute(Object data) {
		ArrayList<TPlanta> lista= FactoriaSA.getInstancia().generaSAPlanta().listar();
		return new Contexto(Evento.LISTAR_PLANTA,lista);
	}

}
