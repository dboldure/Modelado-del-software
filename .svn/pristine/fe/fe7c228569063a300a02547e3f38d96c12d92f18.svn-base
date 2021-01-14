package Presentación.Comando.Departamento;

import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoNominaDepartamento implements Command{

	@Override
	public Contexto execute(Object data) {
		float resultado = FactoriaSA.getInstancia().generaSADepartamento().calcularNominaPorDepartamento((Integer)data);
		return new Contexto(Evento.NOMINA_DEPARTAMENTO_OK,resultado);
	}

}
