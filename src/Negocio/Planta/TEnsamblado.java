
package Negocio.Planta;

import java.util.List;

import Negocio.Departamento.TDepartamento;

public class TEnsamblado {
	
	

	private TPlanta planta;
	
	private List<TPlantaDepartamento> plantaDepartamento;
	
	private List<TDepartamento> departamentos;

	
	public TEnsamblado(TPlanta planta, List<TPlantaDepartamento> plantaDepartamento, List<TDepartamento> departamentos) {
		this.planta = planta;
		this.plantaDepartamento = plantaDepartamento;
		this.departamentos = departamentos;
	}
	
	
	public TPlanta getPlanta() {
		return planta;
	}

	public List<TPlantaDepartamento> getPlantaDepartamento() {
		return plantaDepartamento;
	}

	public List<TDepartamento> getDepartamentos() {
		return departamentos;
	}

	public void setPlanta(TPlanta planta) {
		this.planta = planta;
	}

	public void setPlantaDepartamento(List<TPlantaDepartamento> plantaDepartamento) {
		this.plantaDepartamento = plantaDepartamento;
	}

	public void setDepartamentos(List<TDepartamento> departamentos) {
		this.departamentos = departamentos;
	}
	
	
}