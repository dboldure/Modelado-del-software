
package Negocio.Planta.Imp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

import java.util.ArrayList;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import Negocio.Planta.TPlanta;


@Entity
@NamedQueries({
	@NamedQuery(name = "Negocio.Planta.Imp.Planta.readAll", query = "select obj from Planta obj"),
		@NamedQuery(name = "Negocio.Planta.Imp.Planta.findByid", query = "select obj from Planta obj where :id = obj.id "),
		@NamedQuery(name = "Negocio.Planta.Imp.Planta.findBynumero", query = "select obj from Planta obj where :numero = obj.numero "),
		@NamedQuery(name = "Negocio.Planta.Imp.Planta.findByversion", query = "select obj from Planta obj where :version = obj.version "),
		@NamedQuery(name = "Negocio.Planta.Imp.Planta.findByactivo", query = "select obj from Planta obj where :activo = obj.activo "),
		@NamedQuery(name = "Negocio.Planta.Imp.Planta.findBycontiene", query = "select obj from Planta obj where :contiene MEMBER OF obj.contiene ") })
public class Planta implements Serializable {

	private static final long serialVersionUID = 0;

	
	
	public Planta(Integer id, Integer numero, Boolean activo) {
		this.id = id;
		this.numero = numero;
		this.activo = activo;
	}
	
	public Planta(TPlanta planta) {
		this.id = planta.getId();
		this.numero = planta.getNumero();
		this.activo = planta.getActivo();
	}


	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Integer numero;
	
	@Version
	private Integer version;
	
	private Boolean activo;
	
	@OneToMany(mappedBy = "planta")
	private ArrayList<RPlantaDepartamento> contiene;

	public Planta() {
	}
	
	public TPlanta toTransfer() {
		return new TPlanta(id, numero, activo);
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public Boolean getActivo() {
		return activo;
	}


	public void setActivo(Boolean activo) {
		this.activo = activo;
	}


	public void setContiene(ArrayList<RPlantaDepartamento> contiene) {
		this.contiene = contiene;
	}
	
	public ArrayList<RPlantaDepartamento> getContiene() {
		return contiene;
	}
}