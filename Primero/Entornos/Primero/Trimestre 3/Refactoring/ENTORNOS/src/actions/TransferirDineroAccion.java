package actions;

import interfaz.Accion;
import banco.Cuenta;

public class TransferirDineroAccion implements Accion {
	
	Cuenta deaqui;
	Cuenta aaqui;
	double transferencia;
	
	public TransferirDineroAccion(Cuenta deaqui, Cuenta aaqui,double transferencia){
		this.deaqui=deaqui;
		this.aaqui=aaqui;
		this.transferencia=transferencia;
	}
	public Object ejecutar() {
		deaqui.setSaldo(deaqui.getSaldo()-transferencia);
		aaqui.setSaldo(aaqui.getSaldo()+transferencia);
		return deaqui;
	}

}
