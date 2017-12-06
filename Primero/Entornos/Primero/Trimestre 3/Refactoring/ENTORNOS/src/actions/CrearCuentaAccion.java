package actions;

import interfaz.Accion;
import banco.Cuenta;

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
