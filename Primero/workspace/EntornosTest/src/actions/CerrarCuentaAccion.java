package actions;
import banco.Cuenta;
import interfaz.Accion;

public class CerrarCuentaAccion implements Accion{
	
	Cuenta cuenta;
	
	public CerrarCuentaAccion (Cuenta cuenta){
		cuenta=null;
	}
	
	public Object ejecutar() {
		
		return true;
	}
}
