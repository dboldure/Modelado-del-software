
package Presentación.Comando;

import Presentación.Contexto;

public interface Command {
	
	public Contexto execute(Object data);
}