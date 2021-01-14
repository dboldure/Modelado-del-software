package Presentación.Comando.Planta;

import java.util.ArrayList;

import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoDesvincularDepartamento implements Command {

	@Override
	public Contexto execute(Object data) {
		int resultado = FactoriaSA.getInstancia().generaSAPlanta().desvincularDepartamentoaLaPlanta(((ArrayList<Integer>) data).get(0),((ArrayList<Integer>) data).get(1));
		return new Contexto(Evento.DESVINCULAR_DEPARTAMENTO, resultado);
	}

}
