/**
 * 
 */
package Presentación.Comando.Cliente;

import Negocio.Cliente.SACliente;
import Negocio.Cliente.TCliente;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoAltaCliente implements Command {


	@Override
	public Contexto execute(Object data) {
		 FactoriaSA factoria= FactoriaSA.getInstancia();
		 SACliente sacliente= factoria.generaSACliente();
         int resultado = sacliente.alta((TCliente)(data));
		return new Contexto(Evento.ALTA_CLIENTE,resultado);
	}
}