package Presentación.Comando.Departamento;

import Negocio.Departamento.TDepartamento;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoMostrarDepartamento implements Command{

	@Override
	public Contexto execute(Object data) {
		TDepartamento departamento = FactoriaSA.getInstancia().generaSADepartamento().mostrar((Integer)data);
		if(departamento!=null)
			return new Contexto(Evento.MOSTRAR_DEPARTAMENTO,departamento);
		else return new Contexto(Evento.MOSTRAR_DEPARTAMENTO_KO,departamento);
	}

}
