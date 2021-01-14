package Presentación.Comando.Factura;

import java.util.ArrayList;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Factura.SAFactura;
import Negocio.Factura.TFactura;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoListarFacturas implements Command{

	@Override
	public Contexto execute(Object data) {
		FactoriaSA factoria = FactoriaSA.getInstancia();
		SAFactura saFactura = factoria.generaSAFactura();
		ArrayList<TFactura> lista = saFactura.listar();
		return new Contexto(Evento.LISTAR_FACTURA, lista);
	}

}
