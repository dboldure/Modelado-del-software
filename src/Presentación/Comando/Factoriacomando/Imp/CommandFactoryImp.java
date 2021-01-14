
package Presentaci�n.Comando.Factoriacomando.Imp;


import Presentaci�n.Comando.Planta.ComandoAltaPlanta;
import Presentaci�n.Comando.Planta.ComandoBajaPlanta;
import Presentaci�n.Comando.Planta.ComandoDesvincularDepartamento;
import Presentaci�n.Comando.Planta.ComandoListarPlanta;
import Presentaci�n.Comando.Planta.ComandoModificarPlanta;
import Presentaci�n.Comando.Planta.ComandoMostrarPlanta;
import Presentaci�n.Comando.Planta.ComandoVincularDepartamento;
import Presentaci�n.Evento;
import Presentaci�n.Comando.Command;
import Presentaci�n.Comando.Cliente.ComandoAltaCliente;
import Presentaci�n.Comando.Cliente.ComandoBajaCliente;
import Presentaci�n.Comando.Cliente.ComandoListarCliente;
import Presentaci�n.Comando.Cliente.ComandoModificarCliente;
import Presentaci�n.Comando.Cliente.ComandoMostrarCliente;
import Presentaci�n.Comando.Cliente.CommandMostrarHistorialDeCompra;
import Presentaci�n.Comando.Departamento.ComandoAltaDepartamento;
import Presentaci�n.Comando.Departamento.ComandoBajaDepartamento;
import Presentaci�n.Comando.Departamento.ComandoListarDepartamento;
import Presentaci�n.Comando.Departamento.ComandoModificarDepartamento;
import Presentaci�n.Comando.Departamento.ComandoMostrarDepartamento;
import Presentaci�n.Comando.Departamento.ComandoNominaDepartamento;
import Presentaci�n.Comando.Disco.ComandoAltaDisco;
import Presentaci�n.Comando.Disco.ComandoBajaDisco;
import Presentaci�n.Comando.Disco.ComandoListarDiscos;
import Presentaci�n.Comando.Disco.ComandoListarDiscosVendidos;
import Presentaci�n.Comando.Disco.ComandoModificarDisco;
import Presentaci�n.Comando.Disco.ComandoMostrarDisco;
import Presentaci�n.Comando.Empleado.ComandoAltaEmpleado;
import Presentaci�n.Comando.Empleado.ComandoBajaEmpleado;
import Presentaci�n.Comando.Empleado.ComandoListarEmpleado;
import Presentaci�n.Comando.Empleado.ComandoModificarEmpleado;
import Presentaci�n.Comando.Empleado.ComandoMostrarEmpleado;
import Presentaci�n.Comando.Empleado.ComandoNominaEmpleado;
import Presentaci�n.Comando.Factoriacomando.CommandFactory;
import Presentaci�n.Comando.Factura.ComandoAbrirFactura;
import Presentaci�n.Comando.Factura.ComandoA�adirProducto;
import Presentaci�n.Comando.Factura.ComandoCerrarFactura;
import Presentaci�n.Comando.Factura.ComandoDevolucion;
import Presentaci�n.Comando.Factura.ComandoEliminarProducto;
import Presentaci�n.Comando.Factura.ComandoListarFacturas;
import Presentaci�n.Comando.Factura.ComandoMostrarFactura;


public class CommandFactoryImp extends CommandFactory {

	@Override
	public Command CommandParser(Evento evento) {
			
			Command command = null;
			
			switch(evento){
			case ALTA_CLIENTE_OK: command =new ComandoAltaCliente();
			     break;
			case BAJA_CLIENTE_OK : command= new ComandoBajaCliente();
			     break;
			case MOSTRAR_CLIENTE_KO:
			case MOSTRAR_CLIENTE_OK : command = new ComandoMostrarCliente();
			     break;
			case LISTAR_CLIENTE_OK : command = new ComandoListarCliente();  
			     break;
			case MODIFICAR_CLIENTE_OK : command= new ComandoModificarCliente();  
			     break;
			case MOSTRAR_HISTORIAL_COMPRA_KO :
			case MOSTRAR_HISTORIAL_COMPRA_OK : command= new CommandMostrarHistorialDeCompra();
			     break;
			case ABRIR_FACTURA_OK :  command = new ComandoAbrirFactura();
				break;
			case CERRAR_FACTURA_OK : command = new ComandoCerrarFactura();
				break;
			case A�ADIR_PRODUCTO_OK :  command = new ComandoA�adirProducto();
				break;
			case ELIMINAR_PRODUCTO_OK : command = new ComandoEliminarProducto();
				break;
		
				
				
			case DEVOLUCION_OK : command = new ComandoDevolucion();
				break;
			case LISTAR_FACTURA :
			case LISTAR_FACTURA_OK : command = new ComandoListarFacturas();
				break;
			case MOSTRAR_FACTURA_OK : command = new ComandoMostrarFactura();
				break;
			case ALTA_DISCO_OK : command = new ComandoAltaDisco();
				break;
			case BAJA_DISCO_OK : command = new ComandoBajaDisco();
				break;
			case LISTAR_DISCOS : command = new ComandoListarDiscos();
				break;
			case LISTAR_DISCOS_OK : command = new ComandoListarDiscos();
				break;
			case HISTORIAL_DISCO_OK :
			case HISTORIAL_DISCO_KO :  command = new ComandoListarDiscosVendidos();
				break;
			case MODIFICAR_DISCO_OK : 	command = new ComandoModificarDisco();
				break;
			case MOSTRAR_DISCO_OK : command = new ComandoMostrarDisco();
				break;
			case ALTA_PLANTA_OK : command = new ComandoAltaPlanta();
				break;
			case BAJA_PLANTA_OK : command = new ComandoBajaPlanta();
				break;
			case MOSTRAR_PLANTA_KO:
			case MOSTRAR_PLANTA_OK: command = new ComandoMostrarPlanta();
				break;
			case LISTAR_PLANTA : command = new ComandoListarPlanta();
				break;
			case MODIFICAR_PLANTA_OK : command = new ComandoModificarPlanta();
				break;
			case VINCULAR_DEPARTAMENTO_OK : command = new ComandoVincularDepartamento();
				break;
			case DESVINCULAR_DEPARTAMENTO_OK : command = new ComandoDesvincularDepartamento();
				break;
			case ALTA_DEPARTAMENTO_OK : command = new ComandoAltaDepartamento();
				break;
			case BAJA_DEPARTAMENTO_OK : command = new ComandoBajaDepartamento();
				break;
			case MOSTRAR_DEPARTAMENTO_KO : 
			case MOSTRAR_DEPARTAMENTO_OK : command = new ComandoMostrarDepartamento();
				break;
			case MODIFICAR_DEPARTAMENTO_OK : command = new ComandoModificarDepartamento();
				break;
			case LISTAR_DEPARTAMENTO: command = new ComandoListarDepartamento();
				break;
			case NOMINA_DEPARTAMENTO_OK : command = new ComandoNominaDepartamento();
				break;
			case ALTA_EMPLEADO_OK : command = new ComandoAltaEmpleado();
				break;
			case BAJA_EMPLEADO_OK : command = new ComandoBajaEmpleado();
				break;
			case MOSTRAR_EMPLEADO_KO : 
			case MOSTRAR_EMPLEADO_OK : command = new ComandoMostrarEmpleado();
				break;
			case MODIFICAR_EMPLEADO_OK : command = new ComandoModificarEmpleado();
				break;
			case LISTAR_EMPLEADO : command = new ComandoListarEmpleado();
				break;
			case NOMINA_EMPLEADO_OK : command = new ComandoNominaEmpleado();
				break;
			default:
				break;
			}
			
			return command;
		
		
	}
}