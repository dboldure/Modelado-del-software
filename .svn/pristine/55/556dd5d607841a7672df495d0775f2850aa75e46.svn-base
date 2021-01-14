package Presentación.Comando.Empleado;

import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoNominaEmpleado implements Command{

	@Override
	public Contexto execute(Object data) {

		Float d = (Float)FactoriaSA.getInstancia().generaSAEmpleado().mostrarNomina((Integer)data);
		if(d != null)
			return new Contexto(Evento.NOMINA_EMPLEADO_OK, d);
		else
			return new Contexto(Evento.NOMINA_EMPLEADO_KO, d);
		
	
	}

}
