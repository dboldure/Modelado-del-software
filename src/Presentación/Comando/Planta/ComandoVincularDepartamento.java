package Presentación.Comando.Planta;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;

import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoVincularDepartamento implements Command {

	@Override
	public Contexto execute(Object data) {
		
		
		Integer planta = ((Vector<Integer>) data).get(0);
		Integer dep = ((Vector<Integer>) data).get(1);
		Float metros = ((Vector<Float>) data).get(2);
		
		
	
		
		
		int resultado = FactoriaSA.getInstancia().generaSAPlanta().vincularDepartamentoaLaPlanta(planta, dep, metros/*,((ArrayList<Integer>) data).get(1),((ArrayList<Float>) data).get(2)*/);
		return new Contexto(Evento.VINCULAR_DEPARTAMENTO, resultado);

	}

}
