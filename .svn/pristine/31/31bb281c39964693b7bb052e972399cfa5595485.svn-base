package Presentación.Comando.Factura;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Factura.SAFactura;
import Negocio.Factura.TEnsamblado;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoMostrarFactura implements Command{

	@Override
	public Contexto execute(Object data) {
		FactoriaSA factoria = FactoriaSA.getInstancia();
		SAFactura saFactura = factoria.generaSAFactura();
		TEnsamblado factura = saFactura.mostrar((Integer)data);
		if(factura != null)
			return new Contexto(Evento.MOSTRAR_FACTURA, factura);
		else return new Contexto(Evento.MOSTRAR_FACTURA_KO, factura);
	}

}
