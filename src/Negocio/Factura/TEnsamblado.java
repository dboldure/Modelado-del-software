
package Negocio.Factura;


import Negocio.LineaFactura.TLineaFactura;
import java.util.ArrayList;
import Negocio.Disco.TDisco;


public class TEnsamblado {
	
	
	private TFactura factura;
	private ArrayList<TLineaFactura> lineasFactura;
	private ArrayList<TDisco> discos;
	
	
	public TEnsamblado() {
	}
	
	public TEnsamblado(TFactura factura, ArrayList<TLineaFactura> lineasFactura, ArrayList<TDisco> discos) {
		this.factura = factura;
		this.lineasFactura = lineasFactura;
		this.discos = discos;
	}
	
	public TFactura getFactura() {
		return factura;
	}
	public void setFactura(TFactura factura) {
		this.factura = factura;
	}
	public ArrayList<TLineaFactura> getLineasFactura() {
		return lineasFactura;
	}
	public void setLineasFactura(ArrayList<TLineaFactura> lineasFactura) {
		this.lineasFactura = lineasFactura;
	}
	public ArrayList<TDisco> getDiscos() {
		return discos;
	}
	public void setDiscos(ArrayList<TDisco> discos) {
		this.discos = discos;
	}

	
	
}