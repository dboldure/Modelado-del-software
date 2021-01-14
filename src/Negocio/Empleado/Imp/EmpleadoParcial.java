/**
 * 
 */
package Negocio.Empleado.Imp;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.NamedQuery;

import Negocio.Departamento.Imp.Departamento;
import Negocio.Empleado.TEmpleadoParcial;


@Entity
@NamedQuery(name = "Negocio.Empleado.Imp.EmpleadoParcial.findByhorasDia", query = "select obj from EmpleadoParcial obj where :horasDia = obj.horasDia ")
public class EmpleadoParcial extends Empleado implements Serializable {
	
	private static final long serialVersionUID = 0;

	public EmpleadoParcial(){
		
	}
	public EmpleadoParcial(int id, String nombre, String dni, String telefono, Departamento departamento,Float sueldo, boolean activo,int horasDia) {
		super(id,nombre,dni,telefono,departamento,sueldo,activo);
		setSueldo(sueldo);
	this.horasDia = horasDia;
	}
	public EmpleadoParcial(String nombre, String dni, String telefono, Departamento departamento,Float sueldo, boolean activo,int horasDia) {
		super(nombre,dni,telefono,departamento,sueldo,activo);
		setSueldo(sueldo);
	this.horasDia = horasDia;
	}

	
	public EmpleadoParcial(int id, String nombre, String dni, String telefono,Float sueldo, boolean activo,int horasDia) {
		super(id,nombre,dni,telefono,sueldo,activo);
		setSueldo(sueldo);
	this.horasDia = horasDia;
	}

	private Integer horasDia;
	
	protected TEmpleadoParcial toTransferConcrete(Integer iD, String nombre, boolean activo, String dni, String telefono, Float sueldo, Integer idDepartamento) {
		return new TEmpleadoParcial(iD, nombre, activo,  dni, telefono, sueldo,  idDepartamento, horasDia);
	}

	public Float calcularNominaMes() {
		Float sueldoDiario;
		sueldoDiario=this.getSueldo()*this.horasDia;
		return sueldoDiario*30;
	}


	public Integer getHorasDia() {
		return horasDia;
	}


	public void setHorasDia(Integer horasDia) {
		this.horasDia = horasDia;
	}
}