package Presentaci�n.Comando.Departamento;

import Negocio.Departamento.TDepartamento;
import Negocio.FactoriaSA.FactoriaSA;
import Presentaci�n.Contexto;
import Presentaci�n.Evento;
import Presentaci�n.Comando.Command;

public class ComandoMostrarDepartamento implements Command{

	@Override
	public Contexto execute(Object data) {
		TDepartamento departamento = FactoriaSA.getInstancia().generaSADepartamento().mostrar((Integer)data);
		if(departamento!=null)
			return new Contexto(Evento.MOSTRAR_DEPARTAMENTO,departamento);
		else return new Contexto(Evento.MOSTRAR_DEPARTAMENTO_KO,departamento);
	}

}
