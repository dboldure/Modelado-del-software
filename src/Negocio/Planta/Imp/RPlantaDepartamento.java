
package Negocio.Planta.Imp;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.NamedQuery;
import Negocio.Departamento.Imp.Departamento;
import Negocio.Planta.TPlantaDepartamento;

import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;

@Entity
@NamedQueries({
		@NamedQuery(name = "Negocio.Planta.Imp.RPlantaDepartamento.findBydepartamento", query = "select obj from RPlantaDepartamento obj where :departamento = obj.departamento "),
		@NamedQuery(name = "Negocio.Planta.Imp.RPlantaDepartamento.findBymetros", query = "select obj from RPlantaDepartamento obj where :metros = obj.metros "),
		@NamedQuery(name = "Negocio.Planta.Imp.RPlantaDepartamento.findByplanta", query = "select obj from RPlantaDepartamento obj where :planta = obj.planta ") })
public class RPlantaDepartamento implements Serializable {


	private static final long serialVersionUID = 0;

	
	
	public RPlantaDepartamento() {}

	public RPlantaDepartamento(Departamento departamento, float metros, Planta planta) {
		this.departamento = departamento;
		this.metros = metros;
		this.planta = planta;
	}


	@EmbeddedId
	private RPlantaDepartamentoId id;
	
	@Id
	@ManyToOne
	@MapsId("departamentoid") private Departamento departamento;
	
	private float metros;
	@Id
	@ManyToOne
	@MapsId("plantaid") private Planta planta;

	public Departamento getDepartamento() {
		return departamento;
	}
	public float getMetros() {
		return metros;
	}
	public Planta getPlanta() {
		return planta;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public void setMetros(float metros) {
		this.metros = metros;
	}
	public void setPlanta(Planta planta) {
		this.planta = planta;
	}
	
	public TPlantaDepartamento toTransfer() {
		return new TPlantaDepartamento(metros, planta.getId(), departamento.getId());
	}
}