
package Negocio.Empleado;

public class TEmpleadoParcial extends TEmpleado{
	
	public TEmpleadoParcial(Integer iD, String nombre, boolean activo, String dni, String telefono, Float sueldo,Integer idDepartamento,Integer horasDia) {
		super(iD, nombre, activo, dni, telefono, sueldo, idDepartamento);
		this.horasDia=horasDia;
	}

	private Integer horasDia;

	public Integer getHorasDia() {
		return horasDia;
	}

	public void setHorasDia(Integer horasDia) {
		this.horasDia = horasDia;
	}

}