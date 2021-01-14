package Presentación.Comando.Departamento;

import Negocio.Departamento.SADepartamento;
import Negocio.Departamento.TDepartamento;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoAltaDepartamento implements Command{

	@Override
	public Contexto execute(Object data) {
		FactoriaSA factoria = FactoriaSA.getInstancia();
		SADepartamento sadepartamento = factoria.generaSADepartamento();
		int resultado = sadepartamento.alta((TDepartamento)data);
		return new Contexto(Evento.ALTA_DEPARTAMENTO,resultado);
	}

}
