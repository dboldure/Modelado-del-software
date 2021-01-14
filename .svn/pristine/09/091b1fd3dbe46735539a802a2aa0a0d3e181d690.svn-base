
package Presentación.Comando.Factoriacomando.Imp;


import Presentación.Comando.Planta.ComandoAltaPlanta;
import Presentación.Comando.Planta.ComandoBajaPlanta;
import Presentación.Comando.Planta.ComandoDesvincularDepartamento;
import Presentación.Comando.Planta.ComandoListarPlanta;
import Presentación.Comando.Planta.ComandoModificarPlanta;
import Presentación.Comando.Planta.ComandoMostrarPlanta;
import Presentación.Comando.Planta.ComandoVincularDepartamento;
import Presentación.Evento;
import Presentación.Comando.Command;
import Presentación.Comando.Cliente.ComandoAltaCliente;
import Presentación.Comando.Cliente.ComandoBajaCliente;
import Presentación.Comando.Cliente.ComandoListarCliente;
import Presentación.Comando.Cliente.ComandoModificarCliente;
import Presentación.Comando.Cliente.ComandoMostrarCliente;
import Presentación.Comando.Cliente.CommandMostrarHistorialDeCompra;
import Presentación.Comando.Departamento.ComandoAltaDepartamento;
import Presentación.Comando.Departamento.ComandoBajaDepartamento;
import Presentación.Comando.Departamento.ComandoListarDepartamento;
import Presentación.Comando.Departamento.ComandoModificarDepartamento;
import Presentación.Comando.Departamento.ComandoMostrarDepartamento;
import Presentación.Comando.Departamento.ComandoNominaDepartamento;
import Presentación.Comando.Disco.ComandoAltaDisco;
import Presentación.Comando.Disco.ComandoBajaDisco;
import Presentación.Comando.Disco.ComandoListarDiscos;
import Presentación.Comando.Disco.ComandoListarDiscosVendidos;
import Presentación.Comando.Disco.ComandoModificarDisco;
import Presentación.Comando.Disco.ComandoMostrarDisco;
import Presentación.Comando.Empleado.ComandoAltaEmpleado;
import Presentación.Comando.Empleado.ComandoBajaEmpleado;
import Presentación.Comando.Empleado.ComandoListarEmpleado;
import Presentación.Comando.Empleado.ComandoModificarEmpleado;
import Presentación.Comando.Empleado.ComandoMostrarEmpleado;
import Presentación.Comando.Empleado.ComandoNominaEmpleado;
import Presentación.Comando.Factoriacomando.CommandFactory;
import Presentación.Comando.Factura.ComandoAbrirFactura;
import Presentación.Comando.Factura.ComandoAñadirProducto;
import Presentación.Comando.Factura.ComandoCerrarFactura;
import Presentación.Comando.Factura.ComandoDevolucion;
import Presentación.Comando.Factura.ComandoEliminarProducto;
import Presentación.Comando.Factura.ComandoListarFacturas;
import Presentación.Comando.Factura.ComandoMostrarFactura;


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
			case AÑADIR_PRODUCTO_OK :  command = new ComandoAñadirProducto();
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