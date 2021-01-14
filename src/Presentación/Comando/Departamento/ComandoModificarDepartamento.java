package Presentaci�n.Comando.Departamento;

import Negocio.Departamento.TDepartamento;
import Negocio.FactoriaSA.FactoriaSA;
import Presentaci�n.Contexto;
import Presentaci�n.Evento;
import Presentaci�n.Comando.Command;

public class ComandoModificarDepartamento implements Command{

	@Override
	public Contexto execute(Object data) {
		int resultado = FactoriaSA.getInstancia().generaSADepartamento().modificar((TDepartamento)data);
		return new Contexto(Evento.MODIFICAR_DEPARTAMENTO,resultado);
	}

}
