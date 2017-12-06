package actions;

import banco.Cuenta;
import interfaz.Accion;

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
