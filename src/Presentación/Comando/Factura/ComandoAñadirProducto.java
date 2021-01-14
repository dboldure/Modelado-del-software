package Presentación.Comando.Factura;

import java.util.ArrayList;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Factura.SAFactura;
import Negocio.LineaFactura.TLineaFactura;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoAñadirProducto implements Command{

	@Override
	public Contexto execute(Object data) {
		FactoriaSA factoria = FactoriaSA.getInstancia();
		SAFactura saFactura = factoria.generaSAFactura();
		
		
		ArrayList<TLineaFactura> array = (ArrayList<TLineaFactura>) data;
		TLineaFactura lineaFactura = array.get(array.size()-1);
		array.remove(array.size()-1);
		
		ArrayList<TLineaFactura> resultado = saFactura.añadirProducto(array, lineaFactura);
		if(resultado!=null)
			return new Contexto(Evento.AÑADIR_PRODUCTO_OK,resultado);
		else return new Contexto(Evento.AÑADIR_PRODUCTO_KO,resultado);
	}

}
