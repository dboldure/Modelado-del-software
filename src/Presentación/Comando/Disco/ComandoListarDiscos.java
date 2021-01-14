package Presentaci�n.Comando.Disco;

import java.util.ArrayList;

import Negocio.Disco.SADisco;
import Negocio.Disco.TDisco;
import Negocio.FactoriaSA.FactoriaSA;
import Presentaci�n.Contexto;
import Presentaci�n.Evento;
import Presentaci�n.Comando.Command;

public class ComandoListarDiscos implements Command {

	@Override
	public Contexto execute(Object data) {
		FactoriaSA factoria= FactoriaSA.getInstancia();
		SADisco saDisco= factoria.generaSADisco();
		ArrayList<TDisco> lista = saDisco.listar();
		return new Contexto(Evento.LISTAR_DISCOS, lista);
	}

}
