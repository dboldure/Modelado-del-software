
package Negocio.FactoriaSA;

import Negocio.Cliente.SACliente;
import Negocio.Departamento.SADepartamento;
import Negocio.Disco.SADisco;
import Negocio.Empleado.SAEmpleado;
import Negocio.FactoriaSA.Imp.FactoriaSAImp;
import Negocio.Factura.SAFactura;
import Negocio.Planta.SAPlanta;

public abstract class FactoriaSA {
	
	private static FactoriaSA instancia;

	
	public synchronized static FactoriaSA getInstancia() {
		if(instancia == null) instancia = new FactoriaSAImp();
		return instancia;
	}

	public abstract SACliente generaSACliente();
	public abstract SAFactura generaSAFactura();
	public abstract SADisco generaSADisco();
	public abstract SAEmpleado generaSAEmpleado();
	public abstract SADepartamento generaSADepartamento();
	public abstract SAPlanta generaSAPlanta();
}