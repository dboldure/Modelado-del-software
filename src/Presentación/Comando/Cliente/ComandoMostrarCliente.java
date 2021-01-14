/**
 * 
 */
package Presentaci�n.Comando.Cliente;

import Negocio.Cliente.TCliente;
import Negocio.FactoriaSA.FactoriaSA;
import Presentaci�n.Contexto;
import Presentaci�n.Evento;
import Presentaci�n.Comando.Command;

public class ComandoMostrarCliente implements Command {

	@Override
	public Contexto execute(Object data) {
		TCliente cliente = FactoriaSA.getInstancia().generaSACliente().mostrar((Integer)(data));
		if(cliente!=null)
			return new Contexto(Evento.MOSTRAR_CLIENTE,cliente);
		else return new Contexto(Evento.MOSTRAR_CLIENTE_KO,cliente);
	}

	

}