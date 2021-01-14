package Presentación.Comando.Empleado;

import Negocio.Empleado.TEmpleado;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoModificarEmpleado implements Command{

	@Override
	public Contexto execute(Object data) {

		int resultado = FactoriaSA.getInstancia().generaSAEmpleado().modificar((TEmpleado)(data));
		
		return new Contexto(Evento.MODIFICAR_EMPLEADO,resultado);
		
	}

}
