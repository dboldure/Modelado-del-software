/**
 * 
 */
package Presentación.Comando.Cliente;

import java.util.ArrayList;

import Negocio.Disco.TDisco;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class CommandMostrarHistorialDeCompra implements Command {

	@Override
	public Contexto execute(Object data) {
		ArrayList<TDisco> lista= FactoriaSA.getInstancia().generaSACliente().mostrarHistorialDeCompra((Integer)(data));
		if (lista != null){
			return new Contexto(Evento.MOSTRAR_HISTORIAL_COMPRA,lista);
		}
		else return new Contexto(Evento.MOSTRAR_HISTORIAL_COMPRA_KO,lista);
		
	
	}

	
	
}