
package Negocio.Empleado.Imp;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;

import java.io.Serializable;
import javax.persistence.NamedQuery;

import Negocio.Departamento.Imp.Departamento;
import Negocio.Empleado.TEmpleadoCompleto;


@Entity
@NamedQueries({
@NamedQuery(name = "Negocio.Empleado.Imp.EmpleadoCompleto.findByhorasSemana", query = "select obj from EmpleadoCompleto obj where :horasSemana = obj.horasSemana "),
@NamedQuery(name = "Negocio.Empleado.Imp.EmpleadoCompleto.findBynombre", query = "select obj from EmpleadoCompleto obj where :nombre = obj.nombre ")})
public class EmpleadoCompleto extends Empleado implements Serializable {

	private static final long serialVersionUID = 0;

	
	public EmpleadoCompleto() {
	}
	
	public EmpleadoCompleto(int id, String nombre, String dni, String telefono, Departamento departamento,Float sueldo, boolean activo,int horasSemana) {
		super(id,nombre,dni,telefono,departamento,sueldo,activo);
		this.horasSemana = horasSemana;
	}
	public EmpleadoCompleto(int id, String nombre, String dni, String telefono,Float sueldo, boolean activo,int horasSemana) {
		super(id,nombre,dni,telefono,sueldo,activo);
		this.horasSemana = horasSemana;
	}
	public EmpleadoCompleto (String nombre, String dni, String telefono, Departamento departamento,Float sueldo, boolean activo,int horasSemana) {
		super(nombre,dni,telefono,departamento,sueldo,activo);
		this.horasSemana = horasSemana;
	}

	private Integer horasSemana;

	

	public Float calcularNominaMes() {
		Float sueldoSemanal;
		sueldoSemanal=this.getSueldo()*horasSemana;
		return sueldoSemanal*4;
		
	}


	public Integer getHorasSemana() {
		return horasSemana;
	}


	public void setHorasSemana(Integer horasSemana) {
		this.horasSemana = horasSemana;
	}

	@Override
	protected TEmpleadoCompleto toTransferConcrete(Integer iD, String nombre, boolean activo, String dni, String telefono,
			Float sueldo, Integer idDepartamento) {
			return new TEmpleadoCompleto(iD, nombre, activo,  dni, telefono, sueldo,  idDepartamento, horasSemana);
	}
}