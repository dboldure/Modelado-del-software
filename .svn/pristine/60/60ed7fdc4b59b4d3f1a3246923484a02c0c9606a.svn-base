/**
 * 
 */
package Presentación.Comando.Cliente;

import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoBajaCliente implements Command {

	@Override
	public Contexto execute(Object data) {
		
		int resultado = FactoriaSA.getInstancia().generaSACliente().baja((Integer)data);
		
		return new Contexto(Evento.BAJA_CLIENTE/*_OK*/,resultado);
		
	}

	
}