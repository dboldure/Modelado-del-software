/**
 * 
 */
package Presentación.Comando.Cliente;

import Negocio.Cliente.TCliente;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoMostrarCliente implements Command {

	@Override
	public Contexto execute(Object data) {
		TCliente cliente = FactoriaSA.getInstancia().generaSACliente().mostrar((Integer)(data));
		if(cliente!=null)
			return new Contexto(Evento.MOSTRAR_CLIENTE,cliente);
		else return new Contexto(Evento.MOSTRAR_CLIENTE_KO,cliente);
	}

	

}