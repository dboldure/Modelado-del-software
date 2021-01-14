package Presentaci�n.Comando.Empleado;

import java.util.ArrayList;

import Negocio.Empleado.TEmpleado;
import Negocio.FactoriaSA.FactoriaSA;
import Presentaci�n.Contexto;
import Presentaci�n.Evento;
import Presentaci�n.Comando.Command;

public class ComandoListarEmpleado implements Command{

	@Override
	public Contexto execute(Object data) {
		ArrayList<TEmpleado> lista= FactoriaSA.getInstancia().generaSAEmpleado().listar();
			return new Contexto(Evento.LISTAR_EMPLEADO,lista);
	}

}
