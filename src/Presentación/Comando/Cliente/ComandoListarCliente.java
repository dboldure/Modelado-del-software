/**
 * 
 */
package Presentación.Comando.Cliente;

import java.util.ArrayList;

import Negocio.Cliente.TCliente;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoListarCliente implements Command {

	@Override
	public Contexto execute(Object data) {
		ArrayList<TCliente> lista= FactoriaSA.getInstancia().generaSACliente().listar();
			return new Contexto(Evento.LISTAR_CLIENTE,lista);
	}




}