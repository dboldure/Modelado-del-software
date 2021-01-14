
package Negocio.Cliente;

import java.util.ArrayList;

import Negocio.Disco.TDisco;



public interface SACliente {

	public Integer alta(TCliente cliente);

	public Integer baja(Integer id);
	
	public int modificar(TCliente cliente);
	
	public TCliente mostrar(Integer id);

	public ArrayList<TCliente> listar();
	
	public ArrayList<TDisco> mostrarHistorialDeCompra(Integer idCliente);
	
	
}