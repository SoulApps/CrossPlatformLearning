package ClasePack;

import ArmasPack.Arco;
import ArmasPack.Arma;

public class Arquero extends Clase{

	public Arquero() {
		super("Arquero", true, false);
		bonus = 20;
	}

	@Override
	public boolean comprobar(Arma arma) {
		boolean comp;
		
		if(arma instanceof Arco) comp = true;
		else comp = false;
			
			
		return comp;
	}

}
