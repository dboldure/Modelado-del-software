package Presentación.Comando.Empleado;

import Negocio.Empleado.SAEmpleado;
import Negocio.Empleado.TEmpleado;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoAltaEmpleado implements Command{

	@Override
	public Contexto execute(Object data) {
		 FactoriaSA factoria= FactoriaSA.getInstancia();
		 SAEmpleado saempleado= factoria.generaSAEmpleado();
         int resultado = saempleado.alta((TEmpleado)(data));
		
		return new Contexto(Evento.ALTA_EMPLEADO, resultado);
		
	}

}
