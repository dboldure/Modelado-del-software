
package Presentaci�n.FactoriaVista.Imp;

import Presentaci�n.Contexto;
import Presentaci�n.GUI;
import Presentaci�n.VistaPrincipal;
import Presentaci�n.Cliente.VistaAltaCliente;
import Presentaci�n.Cliente.VistaBajaCliente;
import Presentaci�n.Cliente.VistaCliente;
import Presentaci�n.Cliente.VistaHistorialCliente;
import Presentaci�n.Cliente.VistaListarCliente;
import Presentaci�n.Cliente.VistaModificarCliente;
import Presentaci�n.Cliente.VistaMostrarCliente;
import Presentaci�n.Departamento.VistaAltaDepartamento;
import Presentaci�n.Departamento.VistaBajaDepartamento;
import Presentaci�n.Departamento.VistaDepartamento;
import Presentaci�n.Departamento.VistaListarDepartamento;
import Presentaci�n.Departamento.VistaModificarDepartamento;
import Presentaci�n.Departamento.VistaMostrarDepartamento;
import Presentaci�n.Departamento.VistaNominaDepartamento;
import Presentaci�n.Disco.VistaAltaDisco;
import Presentaci�n.Disco.VistaBajaDisco;
import Presentaci�n.Disco.VistaDisco;
import Presentaci�n.Disco.VistaHistorialDiscos;
import Presentaci�n.Disco.VistaListarDiscos;
import Presentaci�n.Disco.VistaModificarDisco;
import Presentaci�n.Disco.VistaMostrarDisco;
import Presentaci�n.Empleado.VistaAltaEmpleado;
import Presentaci�n.Empleado.VistaBajaEmpleado;
import Presentaci�n.Empleado.VistaEmpleado;
import Presentaci�n.Empleado.VistaListarEmpleado;
import Presentaci�n.Empleado.VistaModificarEmpleado;
import Presentaci�n.Empleado.VistaMostrarEmpleado;
import Presentaci�n.Empleado.VistaNominaEmpleado;
import Presentaci�n.FactoriaVista.FactoriaVista;
import Presentaci�n.Factura.VistaAbrirFactura;
import Presentaci�n.Factura.VistaBuscarFactura;
import Presentaci�n.Factura.VistaDevolucion;
import Presentaci�n.Factura.VistaFactura;
import Presentaci�n.Factura.VistaListarFacturas;
import Presentaci�n.Planta.VistaAltaPlanta;
import Presentaci�n.Planta.VistaBajaPlanta;
import Presentaci�n.Planta.VistaDesvincularDepartamento;
import Presentaci�n.Planta.VistaListarPlanta;
import Presentaci�n.Planta.VistaModificarPlanta;
import Presentaci�n.Planta.VistaMostrarPlanta;
import Presentaci�n.Planta.VistaPlanta;
import Presentaci�n.Planta.VistaVincularDepartamento;


public class FactoriaVistaImp extends FactoriaVista {
	
	@Override
	public GUI generaVista(Contexto contexto) {
		GUI vista=null;
	
		switch(contexto.getEvento()){
		
		case ALTA_CLIENTE : vista = new VistaAltaCliente();
			break;
		case BAJA_CLIENTE : vista = new VistaBajaCliente();
			break;
		case MODIFICAR_CLIENTE : vista = new VistaModificarCliente();
			break;
		case LISTAR_CLIENTE : vista = new VistaListarCliente();
			break;
		case MOSTRAR_CLIENTE_OK :
		case MOSTRAR_CLIENTE_KO :
		case MOSTRAR_CLIENTE : vista = new VistaMostrarCliente();
			break;
		case MOSTRAR_HISTORIAL_COMPRA_OK :
		case MOSTRAR_HISTORIAL_COMPRA_KO :
		case MOSTRAR_HISTORIAL_COMPRA : vista =new VistaHistorialCliente();
			break;
			
			
		
		case A�ADIR_PRODUCTO_OK :
		case ELIMINAR_PRODUCTO_OK :
		case A�ADIR_PRODUCTO_KO :
		case ELIMINAR_PRODUCTO_KO :
		case ABRIR_FACTURA : vista = new VistaAbrirFactura();
			break;
		case CERRAR_FACTURA_OK :
		case CERRAR_FACTURA_KO :
		case CERRAR_FACTURA : vista = new VistaAbrirFactura();
			break;
		case DEVOLUCION : vista = new VistaDevolucion();
			break;
		case LISTAR_FACTURA_OK :
		case LISTAR_FACTURA_KO :
		case LISTAR_FACTURA : vista = new VistaListarFacturas();
			break;
		case MOSTRAR_FACTURA_OK :
		case MOSTRAR_FACTURA_KO :
		case MOSTRAR_FACTURA : vista = new VistaBuscarFactura();
			break;
			
			
			
		case ALTA_DISCO : vista = new VistaAltaDisco();
			break;
		case BAJA_DISCO : vista = new VistaBajaDisco();
			break;
		case MODIFICAR_DISCO : vista = new VistaModificarDisco();
			break;
		case LISTAR_DISCOS_OK :
		case LISTAR_DISCOS_KO :
		case LISTAR_DISCOS : vista = new VistaListarDiscos();
			break;
		case MOSTRAR_DISCO_OK :
		case MOSTRAR_DISCO_KO :
		case MOSTRAR_DISCO : vista = new VistaMostrarDisco();
			break;
		case LISTAR_DISCOS_VENDIDOS_OK :
		case LISTAR_DISCOS_VENDIDOS_KO :
		case LISTAR_DISCOS_VENDIDOS : vista =new VistaHistorialDiscos();
			break;	
			
		case ALTA_PLANTA : vista = new VistaAltaPlanta();
			break;
		case BAJA_PLANTA : vista = new VistaBajaPlanta();
			break;
		case MODIFICAR_PLANTA : vista = new VistaModificarPlanta();
			break;
		case MOSTRAR_PLANTA_OK:
		case MOSTRAR_PLANTA_KO:
		case MOSTRAR_PLANTA : vista = new VistaMostrarPlanta();
			break;
		case LISTAR_PLANTA : vista = new VistaListarPlanta();
			break;
		case VINCULAR_DEPARTAMENTO : vista = new VistaVincularDepartamento();
			break;
		case DESVINCULAR_DEPARTAMENTO : vista = new VistaDesvincularDepartamento();
			break;
			
		case ALTA_EMPLEADO : vista = new VistaAltaEmpleado();
			break;
		case BAJA_EMPLEADO : vista = new VistaBajaEmpleado();
			break;
		case MODIFICAR_EMPLEADO : vista = new VistaModificarEmpleado();
			break;
		case MOSTRAR_EMPLEADO_OK:
		case MOSTRAR_EMPLEADO_KO:
		case MOSTRAR_EMPLEADO : vista = new VistaMostrarEmpleado();
			break;
		case LISTAR_EMPLEADO : vista = new VistaListarEmpleado();
			break;
		case NOMINA_EMPLEADO:
		case NOMINA_EMPLEADO_KO:
		case NOMINA_EMPLEADO_OK : vista = new VistaNominaEmpleado();
			break;
			
		case ALTA_DEPARTAMENTO : vista = new VistaAltaDepartamento();
			break;
		case BAJA_DEPARTAMENTO : vista = new VistaBajaDepartamento();
			break;
		case MOSTRAR_DEPARTAMENTO_OK:
		case MOSTRAR_DEPARTAMENTO_KO:
		case MOSTRAR_DEPARTAMENTO : vista = new VistaMostrarDepartamento();
			break;
		case MODIFICAR_DEPARTAMENTO : vista = new VistaModificarDepartamento();
			break;
		case LISTAR_DEPARTAMENTO : vista = new VistaListarDepartamento();
			break;
		case NOMINA_DEPARTAMENTO_OK:
		case NOMINA_DEPARTAMENTO : vista = new VistaNominaDepartamento();
			break;
		
		case CREAR_VISTA_CLIENTE : vista = new VistaCliente();
			break;
		case CREAR_VISTA_FACTURA : vista =new VistaFactura();
			break;
		case CREAR_VISTA_DISCO : vista = new VistaDisco();
			break;
		case CREAR_VISTA_PLANTA : vista = new VistaPlanta();
			break;
		case CREAR_VISTA_EMPLEADO : vista = new VistaEmpleado();
			break;
		case CREAR_VISTA_DEPARTAMENTO : vista = new VistaDepartamento();
			break;
		case GUI_MOSTRAR : vista = new VistaPrincipal();
			break;
		default:
			break;
		}
		return vista;
		
	}

}