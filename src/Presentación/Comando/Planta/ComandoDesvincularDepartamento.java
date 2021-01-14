package Presentaci�n.Comando.Planta;

import java.util.ArrayList;

import Negocio.FactoriaSA.FactoriaSA;
import Presentaci�n.Contexto;
import Presentaci�n.Evento;
import Presentaci�n.Comando.Command;

public class ComandoDesvincularDepartamento implements Command {

	@Override
	public Contexto execute(Object data) {
		int resultado = FactoriaSA.getInstancia().generaSAPlanta().desvincularDepartamentoaLaPlanta(((ArrayList<Integer>) data).get(0),((ArrayList<Integer>) data).get(1));
		return new Contexto(Evento.DESVINCULAR_DEPARTAMENTO, resultado);
	}

}
