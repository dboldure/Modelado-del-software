package Presentación.Comando.Departamento;

import java.util.ArrayList;

import Negocio.Departamento.TDepartamento;
import Negocio.FactoriaSA.FactoriaSA;
import Presentación.Contexto;
import Presentación.Evento;
import Presentación.Comando.Command;

public class ComandoListarDepartamento implements Command{

	@Override
	public Contexto execute(Object data) {
		ArrayList<TDepartamento> lista = FactoriaSA.getInstancia().generaSADepartamento().listar();
		return new Contexto(Evento.LISTAR_DEPARTAMENTO,lista);
	}

}
