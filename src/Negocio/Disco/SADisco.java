package Negocio.Disco;

import java.util.ArrayList;
import java.sql.Date;

public interface SADisco {

	public Integer alta(TDisco disco);

	public Integer baja(Integer id);

	public Integer modificar(TDisco disco);

	public ArrayList<TDisco> listar();
	
	public TDisco mostrar(Integer id);

	public ArrayList<TDisco> listarDiscosVendidos(String fecha1, String fecha2);
}