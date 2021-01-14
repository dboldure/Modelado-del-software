
package Presentación.FactoriaVista.Imp;

import Presentación.Contexto;
import Presentación.GUI;
import Presentación.VistaPrincipal;
import Presentación.Cliente.VistaAltaCliente;
import Presentación.Cliente.VistaBajaCliente;
import Presentación.Cliente.VistaCliente;
import Presentación.Cliente.VistaHistorialCliente;
import Presentación.Cliente.VistaListarCliente;
import Presentación.Cliente.VistaModificarCliente;
import Presentación.Cliente.VistaMostrarCliente;
import Presentación.Departamento.VistaAltaDepartamento;
import Presentación.Departamento.VistaBajaDepartamento;
import Presentación.Departamento.VistaDepartamento;
import Presentación.Departamento.VistaListarDepartamento;
import Presentación.Departamento.VistaModificarDepartamento;
import Presentación.Departamento.VistaMostrarDepartamento;
import Presentación.Departamento.VistaNominaDepartamento;
import Presentación.Disco.VistaAltaDisco;
import Presentación.Disco.VistaBajaDisco;
import Presentación.Disco.VistaDisco;
import Presentación.Disco.VistaHistorialDiscos;
import Presentación.Disco.VistaListarDiscos;
import Presentación.Disco.VistaModificarDisco;
import Presentación.Disco.VistaMostrarDisco;
import Presentación.Empleado.VistaAltaEmpleado;
import Presentación.Empleado.VistaBajaEmpleado;
import Presentación.Empleado.VistaEmpleado;
import Presentación.Empleado.VistaListarEmpleado;
import Presentación.Empleado.VistaModificarEmpleado;
import Presentación.Empleado.VistaMostrarEmpleado;
import Presentación.Empleado.VistaNominaEmpleado;
import Presentación.FactoriaVista.FactoriaVista;
import Presentación.Factura.VistaAbrirFactura;
import Presentación.Factura.VistaBuscarFactura;
import Presentación.Factura.VistaDevolucion;
import Presentación.Factura.VistaFactura;
import Presentación.Factura.VistaListarFacturas;
import Presentación.Planta.VistaAltaPlanta;
import Presentación.Planta.VistaBajaPlanta;
import Presentación.Planta.VistaDesvincularDepartamento;
import Presentación.Planta.VistaListarPlanta;
import Presentación.Planta.VistaModificarPlanta;
import Presentación.Planta.VistaMostrarPlanta;
import Presentación.Planta.VistaPlanta;
import Presentación.Planta.VistaVincularDepartamento;


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
			
			
		
		case AÑADIR_PRODUCTO_OK :
		case ELIMINAR_PRODUCTO_OK :
		case AÑADIR_PRODUCTO_KO :
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