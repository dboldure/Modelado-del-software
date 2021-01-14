package Presentaci�n.Comando.Departamento;

import Negocio.FactoriaSA.FactoriaSA;
import Presentaci�n.Contexto;
import Presentaci�n.Evento;
import Presentaci�n.Comando.Command;

public class ComandoBajaDepartamento implements Command{

	@Override
	public Contexto execute(Object data) {
		int resultado = FactoriaSA.getInstancia().generaSADepartamento().baja((Integer)data);
		return new Contexto(Evento.BAJA_DEPARTAMENTO,resultado);
	}

}
