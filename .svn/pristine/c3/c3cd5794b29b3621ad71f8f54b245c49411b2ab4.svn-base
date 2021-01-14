package Presentación.Comando.Departamento;

import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoBajaDepartamento implements Command{

	@Override
	public Contexto execute(Object data) {
		int resultado = FactoriaSA.getInstancia().generaSADepartamento().baja((Integer)data);
		return new Contexto(Evento.BAJA_DEPARTAMENTO,resultado);
	}

}
