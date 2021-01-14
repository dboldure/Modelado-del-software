


package Integración.Cliente;

import Negocio.Cliente.TCliente;

import java.util.ArrayList;



public interface DAOCliente {
	
	public Integer alta(TCliente cliente);
	public Integer baja(Integer id);
	public Integer modificar(TCliente cliente);
	public TCliente mostrar(Integer id);
	public ArrayList<TCliente> listar();
	public TCliente mostrarPorDni(String dni);
	
}
