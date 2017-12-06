package actions;

import banco.Cuenta;
import interfaz.Accion;

public class IngresarDineroAccion implements Accion {

		Cuenta cuenta;
		double ingreso;
		
		public IngresarDineroAccion(Cuenta cuenta,double ingreso){
			this.cuenta=cuenta;
			this.ingreso=ingreso;
		}

		public Object ejecutar() {
			cuenta.setSaldo(cuenta.getSaldo()+ingreso);
			return cuenta;
		}
		
}
