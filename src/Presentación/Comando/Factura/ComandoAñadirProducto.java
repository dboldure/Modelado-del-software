package Presentaci�n.Comando.Factura;

import java.util.ArrayList;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Factura.SAFactura;
import Negocio.LineaFactura.TLineaFactura;
import Presentaci�n.Contexto;
import Presentaci�n.Evento;
import Presentaci�n.Comando.Command;

public class ComandoA�adirProducto implements Command{

	@Override
	public Contexto execute(Object data) {
		FactoriaSA factoria = FactoriaSA.getInstancia();
		SAFactura saFactura = factoria.generaSAFactura();
		
		
		ArrayList<TLineaFactura> array = (ArrayList<TLineaFactura>) data;
		TLineaFactura lineaFactura = array.get(array.size()-1);
		array.remove(array.size()-1);
		
		ArrayList<TLineaFactura> resultado = saFactura.a�adirProducto(array, lineaFactura);
		if(resultado!=null)
			return new Contexto(Evento.A�ADIR_PRODUCTO_OK,resultado);
		else return new Contexto(Evento.A�ADIR_PRODUCTO_KO,resultado);
	}

}
