
package Negocio.Empleado.Imp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Version;
import javax.persistence.NamedQueries;
import Negocio.Departamento.Imp.Departamento;
import Negocio.Empleado.TEmpleado;

import javax.persistence.ManyToOne;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;


@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@NamedQueries({
		@NamedQuery(name = "Negocio.Empleado.Imp.Empleado.findByid", query = "select obj from Empleado obj where :id = obj.id "),
		@NamedQuery(name = "Negocio.Empleado.Imp.Empleado.findBydni", query = "select obj from Empleado obj where :dni = obj.dni "),
		@NamedQuery(name = "Negocio.Empleado.Imp.Empleado.findBynombre", query = "select obj from Empleado obj where :nombre = obj.nombre "),
		@NamedQuery(name = "Negocio.Empleado.Imp.Empleado.readALL", query = "select obj from Empleado obj"),
		@NamedQuery(name = "Negocio.Empleado.Imp.Empleado.findBytelefono", query = "select obj from Empleado obj where :telefono = obj.telefono "),
		@NamedQuery(name = "Negocio.Empleado.Imp.Empleado.findBysueldo", query = "select obj from Empleado obj where :sueldo = obj.sueldo "),
		@NamedQuery(name = "Negocio.Empleado.Imp.Empleado.findByactivo", query = "select obj from Empleado obj where :activo = obj.activo "),
		@NamedQuery(name = "Negocio.Empleado.Imp.Empleado.findByversion", query = "select obj from Empleado obj where :version = obj.version "),
		@NamedQuery(name = "Negocio.Empleado.Imp.Empleado.findBydepartamento", query = "select obj from Empleado obj where :departamento = obj.departamento ") })
public abstract class Empleado implements Serializable {

	private static final long serialVersionUID = 0;

	
	public Empleado() {}
	
	public Empleado(int id, String nombre, String dni, String telefono, Departamento departamento,Float sueldo, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.dni=dni;
		this.telefono = telefono;
		this.departamento = departamento;
		this.activo = activo;
		this.sueldo=sueldo;
	}
	
	public Empleado(int id, String nombre, String dni, String telefono,Float sueldo, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.dni=dni;
		this.telefono = telefono;
		this.activo = activo;
		this.sueldo=sueldo;
	}
	
	public Empleado(String nombre,String dni, String telefono, Departamento departamento,Float sueldo, boolean activo) {
		this.nombre = nombre;
		this.dni=dni;
		this.telefono = telefono;
		this.departamento = departamento;
		this.activo = activo;
		this.sueldo=sueldo;
	}

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Version
	private int version;
	
	private String dni;
	
	private String nombre;
	
	private String telefono;
	
	private Float sueldo;
	
	private Boolean activo;
	
	
	@ManyToOne
	private Departamento departamento;

	
	
	public abstract Float calcularNominaMes();

	protected abstract TEmpleado toTransferConcrete(Integer iD, String nombre, boolean activo, String dni, String telefono, Float sueldo, Integer idDepartamento);
	
	public TEmpleado toTransfer(){
		return this.toTransferConcrete(this.id, this.nombre, this.activo,  this.dni, this.telefono, this.sueldo,  this.departamento.getId());
		
	}
	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
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


	public Float getSueldo() {
		return sueldo;
	}


	public void setSueldo(Float sueldo) {
		this.sueldo = sueldo;
	}


	public Boolean getActivo() {
		return activo;
	}


	public void setActivo(Boolean activo) {
		this.activo = activo;
	}


	public Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
}