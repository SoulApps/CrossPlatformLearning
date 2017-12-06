package ClasePack;

import ArmasPack.Martillo;
import ArmasPack.Arma;

public class Paladin extends Clase {

	public Paladin() {
		super("Paladin", false, true);
		bonus = 10;
	}
	
	@Override
	public boolean comprobar(Arma arma) {
		boolean comp;
		
		if(arma instanceof Martillo) comp = true;
		else comp = false;
			
			
		return comp;
	}

}
