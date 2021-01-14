package Presentación.Comando.Factura;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Factura.SAFactura;
import Negocio.LineaFactura.TLineaFactura;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoDevolucion implements Command{

	@Override
	public Contexto execute(Object data) {
		FactoriaSA factoria = FactoriaSA.getInstancia();
		SAFactura saFactura = factoria.generaSAFactura();
		int resultado = saFactura.devolucion((TLineaFactura)(data));
		
		return new Contexto(Evento.DEVOLUCION,resultado);
	}

}
