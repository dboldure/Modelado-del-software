package Presentación.Comando.Disco;

import java.util.ArrayList;

import Negocio.Disco.TDisco;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoListarDiscosVendidos implements Command {

	@Override
	public Contexto execute(Object data) {
		
		if(data != null){
			ArrayList<String> fechas = (ArrayList<String>) data;
			ArrayList<TDisco> lista= FactoriaSA.getInstancia().generaSADisco().listarDiscosVendidos(fechas.get(0), fechas.get(1));
			return new Contexto(Evento.LISTAR_DISCOS_VENDIDOS, lista);
		}
		else return new Contexto(Evento.LISTAR_DISCOS_VENDIDOS_KO, null);
		
	}

}