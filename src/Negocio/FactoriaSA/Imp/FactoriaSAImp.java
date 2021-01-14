
package Negocio.FactoriaSA.Imp;

import Negocio.Cliente.SACliente;
import Negocio.Cliente.Imp.SAClienteImp;
import Negocio.Departamento.SADepartamento;
import Negocio.Departamento.Imp.SADepartamentoImp;
import Negocio.Disco.SADisco;
import Negocio.Disco.Imp.SADiscoImp;
import Negocio.Empleado.SAEmpleado;
import Negocio.Empleado.Imp.SAEmpleadoImp;
import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Factura.SAFactura;
import Negocio.Factura.Imp.SAFacturaImp;
import Negocio.Planta.SAPlanta;
import Negocio.Planta.Imp.SAPlantaImp;


public class FactoriaSAImp extends FactoriaSA {

	  public SACliente generaSACliente(){
		return new SAClienteImp();
	 }

	@Override
	public SAFactura generaSAFactura() {
		return new SAFacturaImp();
	}

	@Override
	public SADisco generaSADisco() {
		return new SADiscoImp();
	}

	@Override
	public SAEmpleado generaSAEmpleado() {
		return new SAEmpleadoImp();
	}

	@Override
	public SADepartamento generaSADepartamento() {
		return new SADepartamentoImp();
	}

	@Override
	public SAPlanta generaSAPlanta() {
		return new SAPlantaImp();
	}
}