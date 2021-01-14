
package Negocio.Departamento;

import Negocio.Departamento.Imp.Departamento;

public class TDepartamento {
	
	private Integer id;
	
	private String nombre;
	
	private String telefono;

	private Boolean activo;

	public TDepartamento(Departamento departamento) {
		this.id=departamento.getId();
		this.telefono=departamento.getTelefono();
		this.nombre=departamento.getNombre();
		this.activo=departamento.getActivo();
		
	}
	
	public TDepartamento(Integer id,String nombre,String telefono,Boolean activo) {
		this.id=id;
		this.telefono=telefono;
		this.nombre=nombre;
		this.activo=activo;
		
	}
    
	public TDepartamento(String nombre,String telefono,Boolean activo) {
		this.telefono=telefono;
		this.nombre=nombre;
		this.activo=activo;
		
	}
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


}