

package Negocio.Disco;


public class TDiscoCD extends TDisco {

	private Boolean dvd;

	public TDiscoCD(Integer id, String nombre, Integer a�o, Float precio, Integer stock, String genero, Boolean activo, Boolean dvd) {
		super(id, nombre, a�o, precio, stock, genero, activo);
		this.dvd = dvd;
	}
	
	public Boolean getDvd() {
		return dvd;
	}

	public void setDvd(Boolean dvd) {
		this.dvd = dvd;
	}

	
}