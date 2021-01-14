
package Negocio.Factura;

import Negocio.LineaFactura.TLineaFactura;

import java.util.ArrayList;

public interface SAFactura {

	public Integer abrir(TFactura factura);

	public ArrayList<TLineaFactura> añadirProducto(ArrayList<TLineaFactura> lineasFactura, TLineaFactura lineaFactura);

	public ArrayList<TLineaFactura> quitarProducto(ArrayList<TLineaFactura> lineaFacturas, TLineaFactura lineaFactura);

	public Integer cerrar(ArrayList<TLineaFactura> lineasFactura, TFactura factura);

	public Integer devolucion(TLineaFactura lineaFactura);

	public TEnsamblado mostrar(Integer idFactura);

	public ArrayList<TFactura> listar();
	
}