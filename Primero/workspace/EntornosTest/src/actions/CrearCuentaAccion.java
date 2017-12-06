package actions;

import banco.Cuenta;
import interfaz.Accion;

public class CrearCuentaAccion implements Accion{

	double saldoInicial;
	private Cuenta micuenta;
	
	public CrearCuentaAccion(double saldoInicial){
		this.saldoInicial=saldoInicial;
	}
	
	public Object ejecutar() {
		micuenta = new Cuenta ();
		micuenta.setSaldo(saldoInicial);
		return micuenta;
	}
}
