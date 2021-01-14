
package Negocio.Planta.Imp;

import java.io.Serializable;
import javax.persistence.Embeddable;


@Embeddable
public class RPlantaDepartamentoId implements Serializable {

	private static final long serialVersionUID = 0;

	private Integer plantaid;
	private Integer departamentoid;

	
	public RPlantaDepartamentoId() {}

	public RPlantaDepartamentoId(Integer planta, Integer departamento) {
		this.plantaid = planta;
		this.departamentoid = departamento;
	}
	
	
	public Integer getPlanta() {
		return plantaid;
	}
	public Integer getDepartamento() {
		return departamentoid;
	}
	public void setPlanta(Integer planta) {
		this.plantaid = planta;
	}
	
	public void setDepartamento(Integer departamento) {
		this.departamentoid = departamento;
	}

	

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof RPlantaDepartamentoId))
			return false;
		RPlantaDepartamentoId pk = (RPlantaDepartamentoId) obj;
		if ((plantaid == null && pk.plantaid != null) || (plantaid != null && !plantaid.equals(pk.plantaid)))
			return false;
		if ((departamentoid == null && pk.departamentoid != null)
				|| (departamentoid != null && !departamentoid.equals(pk.departamentoid)))
			return false;
		return true;
	}


	public int hashCode() {
		int hash=0;
		hash+=plantaid;
		hash+=departamentoid;
		return hash;
	}
}