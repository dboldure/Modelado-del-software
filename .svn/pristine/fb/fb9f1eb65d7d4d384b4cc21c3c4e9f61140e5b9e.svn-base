/**
 * 
 */
package Presentación.Comando.Cliente;

import Negocio.Cliente.TCliente;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoModificarCliente implements Command {

	@Override
	public Contexto execute(Object data) {

		int resultado = FactoriaSA.getInstancia().generaSACliente().modificar((TCliente)(data));
		
		return new Contexto(Evento.MODIFICAR_CLIENTE,resultado);
		
	}

	

}