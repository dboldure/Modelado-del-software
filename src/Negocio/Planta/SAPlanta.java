
package Negocio.Planta;

import java.util.ArrayList;


public interface SAPlanta {

	public Integer alta(TPlanta planta);

	public Integer baja(Integer id);

	public Integer modificar(TPlanta planta);

	public TEnsamblado mostrar(Integer id);

	public ArrayList<TPlanta> listar();
	
	public Integer vincularDepartamentoaLaPlanta(Integer idPlanta, Integer idDepar, Float metros);

	public Integer desvincularDepartamentoaLaPlanta(Integer idPlanta, Integer idDepar);


}