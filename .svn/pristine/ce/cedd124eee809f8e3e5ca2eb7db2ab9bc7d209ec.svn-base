


package Presentación.ApplicationController;

import Presentación.Contexto;
import Presentación.ApplicationController.Imp.ApplicationControllerImp;

public abstract class ApplicationController {


	private static ApplicationController instance;

	public static ApplicationController getInstance() {
		if(instance == null)
			instance = new ApplicationControllerImp();
		return instance;
	}

	public abstract void action(Contexto contexto);
}