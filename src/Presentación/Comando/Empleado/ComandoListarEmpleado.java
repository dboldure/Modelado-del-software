package Presentación.Comando.Empleado;

import java.util.ArrayList;

import Negocio.Empleado.TEmpleado;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoListarEmpleado implements Command{

	@Override
	public Contexto execute(Object data) {
		ArrayList<TEmpleado> lista= FactoriaSA.getInstancia().generaSAEmpleado().listar();
			return new Contexto(Evento.LISTAR_EMPLEADO,lista);
	}

}
