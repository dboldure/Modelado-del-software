/**
 * 
 */
package Presentaci�n.Comando.Cliente;

import java.util.ArrayList;

import Negocio.Cliente.TCliente;
import Negocio.FactoriaSA.FactoriaSA;
import Presentaci�n.Contexto;
import Presentaci�n.Evento;
import Presentaci�n.Comando.Command;

public class ComandoListarCliente implements Command {

	@Override
	public Contexto execute(Object data) {
		ArrayList<TCliente> lista= FactoriaSA.getInstancia().generaSACliente().listar();
			return new Contexto(Evento.LISTAR_CLIENTE,lista);
	}




}