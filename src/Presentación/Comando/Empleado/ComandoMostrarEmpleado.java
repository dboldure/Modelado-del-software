package Presentación.Comando.Empleado;

import Negocio.Empleado.TEmpleado;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoMostrarEmpleado implements Command{

	@Override
	public Contexto execute(Object data) {
		TEmpleado empleado = FactoriaSA.getInstancia().generaSAEmpleado().mostrar((Integer)(data));
		if(empleado!=null)
			return new Contexto(Evento.MOSTRAR_EMPLEADO,empleado);
		else return new Contexto(Evento.MOSTRAR_EMPLEADO_KO,empleado);
	}

}
