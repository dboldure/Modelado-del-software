package Presentación.Comando.Empleado;

import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoBajaEmpleado implements Command{

	@Override
	public Contexto execute(Object data) {
		int resultado = FactoriaSA.getInstancia().generaSAEmpleado().baja((Integer)data);
	
		return new Contexto(Evento.BAJA_EMPLEADO,resultado);
	}

}
