package Presentaci�n.Comando.Empleado;

import Negocio.Empleado.TEmpleado;
import Negocio.FactoriaSA.FactoriaSA;
import Presentaci�n.Contexto;
import Presentaci�n.Evento;
import Presentaci�n.Comando.Command;

public class ComandoModificarEmpleado implements Command{

	@Override
	public Contexto execute(Object data) {

		int resultado = FactoriaSA.getInstancia().generaSAEmpleado().modificar((TEmpleado)(data));
		
		return new Contexto(Evento.MODIFICAR_EMPLEADO,resultado);
		
	}

}
