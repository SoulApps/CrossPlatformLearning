package ClasePack;

import ArmasPack.Varita;
import ArmasPack.Arma;

public class Mago extends Clase {

	public Mago() {
		super("Mago", true, true);
	}
	
	@Override
	public boolean comprobar(Arma arma) {
		boolean comp;
		
		if(arma instanceof Varita) comp = true;
		else comp = false;
			
			
		return comp;
	}

}
