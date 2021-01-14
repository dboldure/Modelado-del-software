package Presentación.Comando.Departamento;

import Negocio.Departamento.TDepartamento;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoModificarDepartamento implements Command{

	@Override
	public Contexto execute(Object data) {
		int resultado = FactoriaSA.getInstancia().generaSADepartamento().modificar((TDepartamento)data);
		return new Contexto(Evento.MODIFICAR_DEPARTAMENTO,resultado);
	}

}
