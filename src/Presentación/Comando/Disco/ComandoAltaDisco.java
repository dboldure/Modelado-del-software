package Presentación.Comando.Disco;


import Negocio.Disco.SADisco;
import Negocio.Disco.TDisco;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoAltaDisco  implements Command {

	@Override
	public Contexto execute(Object data) {
		 FactoriaSA factoria= FactoriaSA.getInstancia();
		 SADisco saDisco= factoria.generaSADisco();
         int resultado = saDisco.alta((TDisco)data);
	
		return new Contexto(Evento.ALTA_DISCO,resultado);
	}

}
