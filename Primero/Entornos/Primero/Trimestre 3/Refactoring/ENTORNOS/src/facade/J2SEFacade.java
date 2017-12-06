package facade;

import facade.delegate.J2SEFacadeDelegate;
import interfaz.Accion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import actions.*;
import banco.Cuenta;

public class J2SEFacade implements J2SEFacadeDelegate {

	private static final String FACHADA_MODELO = "fachadaModelo";
	private static final String FICHERO_CONFIGURACION = "configuracion/configuracion.properties";

	@Override
	public Cuenta CerrarCuenta(Cuenta cuenta) {
		Accion accion=new CerrarCuentaAccion(cuenta);
		return (Cuenta) accion.ejecutar();
	}

	public Cuenta CrearCuenta(double saldoInicial) {
		Accion accion= new CrearCuentaAccion(saldoInicial);
		return (Cuenta) accion.ejecutar();
	}

	@Override
	public Cuenta IngresarDinero(Cuenta cuenta, double ingreso) {
		Accion accion=new IngresarDineroAccion(cuenta, ingreso);
		return (Cuenta) accion.ejecutar();
	}

	@Override
	public Cuenta TransferirDinero(Cuenta deaqui, Cuenta aaqui,
			double transferencia) {
		Accion accion=new TransferirDineroAccion(deaqui,aaqui,transferencia);
		return (Cuenta) accion.ejecutar();
	}

	public static void main(String[] args) {
		Cuenta cuenta1;
		Cuenta cuenta2;
		
		Properties prop = new Properties();
		InputStream is = null;

		/*
		 * Cargamos un fichero de configuración con el nombre de la clase de la
		 * fachada para cargarla dinámicamente
		 */
		try {
			is = new FileInputStream(FICHERO_CONFIGURACION);
			prop.load(is);
		} catch (IOException e) {
			System.out.println(e);
		}
		J2SEFacadeDelegate fachada = null;

		/*
		 * Obtenemmos el cargador de clases del sistema.
		 */
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		try {

			/*
			 * Cargamos la fachada en tiempo de ejecución y creamos una
			 * instancia.
			 */
			@SuppressWarnings("rawtypes")
			Class loadedClass = classLoader.loadClass(prop
					.getProperty(FACHADA_MODELO));
			fachada = (J2SEFacadeDelegate) loadedClass.newInstance();
		} catch (Exception e) {

			System.out.println(e);
		}
		cuenta1=fachada.CrearCuenta(0);
		cuenta2=fachada.CrearCuenta(100);
		fachada.TransferirDinero (cuenta2,cuenta1,20.0);
		fachada.IngresarDinero(cuenta1, 30.0);
		String variableLocal = "cuenta1: "+cuenta1.getSaldo()+"\nCuenta2: "+cuenta2.getSaldo();
		System.out.println(variableLocal);
		
	}
}