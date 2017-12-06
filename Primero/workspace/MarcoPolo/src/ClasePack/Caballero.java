package ClasePack;

import ArmasPack.Arma;
import ArmasPack.Espada;

public class Caballero extends Clase{

	public Caballero() {
		super("Caballero", false, false);
	}

	@Override
	public boolean comprobar(Arma arma) {
		boolean comp;
		
		if(arma instanceof Espada) comp = true;
		else comp = false;
			
			
		return comp;
	}
}
