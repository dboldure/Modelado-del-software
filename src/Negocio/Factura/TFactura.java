
package Negocio.Factura;

import java.sql.Date;


public class TFactura {
	
	private Integer id;
	private Integer idCliente;
	private float precioTotal;
	private Date fecha;
	private Boolean activo;

	
	public TFactura(Integer idFactura, Integer idCliente, Float precioTotal, Date fecha, Boolean activo){
		id = idFactura;
		this.idCliente = idCliente;
		this.precioTotal = precioTotal;
		this.fecha = fecha;
		this.activo = activo;
	}
		
	
	public TFactura(int idCliente) {
		this.idCliente = idCliente;
		this.activo = true;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public float getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	
}