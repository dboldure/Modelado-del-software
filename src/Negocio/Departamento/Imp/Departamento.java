
package Negocio.Departamento.Imp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import Negocio.Departamento.TDepartamento;
import Negocio.Empleado.Imp.Empleado;
import Negocio.Planta.Imp.RPlantaDepartamento;

import java.util.ArrayList;


@Entity
@NamedQueries({
	    @NamedQuery(name = "Negocio.Departamento.Imp.Departamento.readAll", query = "select obj from Departamento obj"),
		@NamedQuery(name = "Negocio.Departamento.Imp.Departamento.findByid", query = "select obj from Departamento obj where :id = obj.id "),
		@NamedQuery(name = "Negocio.Departamento.Imp.Departamento.findBynombre", query = "select obj from Departamento obj where :nombre = obj.nombre "),
		@NamedQuery(name = "Negocio.Departamento.Imp.Departamento.findBynombreytelefono", query = "select obj from Departamento obj where :nombre = obj.nombre and :telefono = obj.telefono "),
		@NamedQuery(name = "Negocio.Departamento.Imp.Departamento.findBytelefono", query = "select obj from Departamento obj where :telefono = obj.telefono "),
		@NamedQuery(name = "Negocio.Departamento.Imp.Departamento.findByversion", query = "select obj from Departamento obj where :version = obj.version "),
		@NamedQuery(name = "Negocio.Departamento.Imp.Departamento.findByactivo", query = "select obj from Departamento obj where :activo = obj.activo "),
		@NamedQuery(name = "Negocio.Departamento.Imp.Departamento.findBycontiene", query = "select obj from Departamento obj where :contiene MEMBER OF obj.contiene "),
		@NamedQuery(name = "Negocio.Departamento.Imp.Departamento.findByempleado", query = "select obj from Departamento obj where :empleado MEMBER OF obj.empleado ") })
public class Departamento implements Serializable {

	private static final long serialVersionUID = 0;

	
	public Departamento() {}

	public Departamento(Integer id, String nombre, String telefono,  boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.activo = activo;
		this.contiene = new ArrayList<>();
	}
	
	public Departamento(String nombre, String telefono,  boolean activo) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.activo = activo;
		this.contiene = new ArrayList<>();
	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nombre;
	
	private String telefono;

	@Version
	private int version;
	
	private Boolean activo;
	
	@OneToMany(mappedBy = "departamento")
	private ArrayList<RPlantaDepartamento> contiene;

	@OneToMany(mappedBy = "departamento")
	private ArrayList<Empleado> empleado;

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public TDepartamento toTransfer() {
		return new TDepartamento(new Departamento(id,nombre,telefono,activo));
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleado;
	}

	public void setEmpleados(ArrayList<Empleado> empleado) {
		this.empleado = empleado;
	}
}