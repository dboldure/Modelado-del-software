package Presentación.Comando.Factura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Factura.SAFactura;
import Negocio.Factura.TEnsamblado;
import Negocio.Factura.TFactura;
import Negocio.LineaFactura.TLineaFactura;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoCerrarFactura implements Command {

	@Override
	public Contexto execute(Object data) {
		FactoriaSA factoria = FactoriaSA.getInstancia();
		SAFactura saFactura = factoria.generaSAFactura();
	
		
		
		TEnsamblado ensamblado = (TEnsamblado) data;
		
		
		int resultado = saFactura.cerrar(ensamblado.getLineasFactura(), ensamblado.getFactura());
		if(resultado!=-1)
			return new Contexto(Evento.CERRAR_FACTURA_OK,resultado);
		else return new Contexto(Evento.CERRAR_FACTURA_KO,resultado);
	}

}
