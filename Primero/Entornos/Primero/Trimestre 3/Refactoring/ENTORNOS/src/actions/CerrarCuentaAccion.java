package actions;
import interfaz.Accion;
import banco.Cuenta;

public class CerrarCuentaAccion implements Accion{
	
	Cuenta cuenta;
	
	public CerrarCuentaAccion (Cuenta cuenta){
		cuenta=null;
	}
	
	public Object ejecutar() {
		
		return true;
	}
}
