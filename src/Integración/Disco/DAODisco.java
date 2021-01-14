



package Integración.Disco;

import Negocio.Disco.TDisco;

import java.util.ArrayList;


public interface DAODisco {

	public Integer alta(TDisco disco);
	public Integer baja(Integer id);
	public Integer modificar(TDisco disco);
	public TDisco mostrar(Integer id);
	public ArrayList<TDisco> listar();
	
}