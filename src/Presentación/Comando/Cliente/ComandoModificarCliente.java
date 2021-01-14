/**
 * 
 */
package Presentaci�n.Comando.Cliente;

import Negocio.Cliente.TCliente;
import Negocio.FactoriaSA.FactoriaSA;
import Presentaci�n.Contexto;
import Presentaci�n.Evento;
import Presentaci�n.Comando.Command;

public class ComandoModificarCliente implements Command {

	@Override
	public Contexto execute(Object data) {

		int resultado = FactoriaSA.getInstancia().generaSACliente().modificar((TCliente)(data));
		
		return new Contexto(Evento.MODIFICAR_CLIENTE,resultado);
		
	}

	

}