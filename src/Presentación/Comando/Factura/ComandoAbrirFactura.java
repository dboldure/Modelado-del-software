package Presentaci�n.Comando.Factura;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Factura.SAFactura;
import Negocio.Factura.TFactura;
import Presentaci�n.Contexto;
import Presentaci�n.Evento;
import Presentaci�n.Comando.Command;

public class ComandoAbrirFactura implements Command {

	@Override
	public Contexto execute(Object data) {
		FactoriaSA factoria = FactoriaSA.getInstancia();
		SAFactura saFactura = factoria.generaSAFactura();
		int resultado = saFactura.abrir((TFactura)data);
		if(resultado!= -1)
			return new Contexto(Evento.ABRIR_FACTURA_OK,resultado);
		
		else return new Contexto(Evento.ABRIR_FACTURA_KO,resultado);
	}

}
