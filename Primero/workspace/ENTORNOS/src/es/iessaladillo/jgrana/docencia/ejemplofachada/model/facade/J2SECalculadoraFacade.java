package es.iessaladillo.jgrana.docencia.ejemplofachada.model.facade;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import es.iessaladillo.jgrana.docencia.ejemplofachada.model.facade.delegate.CalculadoraFacadeDelegate;
import es.iessaladillo.jgrana.docencia.ejemplofachada.model.j2sefacade.actions.Action;
import es.iessaladillo.jgrana.docencia.ejemplofachada.model.j2sefacade.actions.FactorialAction;
import es.iessaladillo.jgrana.docencia.ejemplofachada.model.j2sefacade.actions.RestarAction;
import es.iessaladillo.jgrana.docencia.ejemplofachada.model.j2sefacade.actions.SumarAction;

public class J2SECalculadoraFacade implements CalculadoraFacadeDelegate{

	@Override
	public Integer sumar(Integer x, Integer y) {
		Action accion = new SumarAction(x,y);
		return (Integer)accion.execute();
	}

	@Override
	public Integer restar(Integer x, Integer y) {
		Action accion = new RestarAction(x,y);
		return (Integer)accion.execute();
	}

	@Override
	public Integer factorial(Integer x) {
		Action accion = new FactorialAction(x);
		return (Integer) accion.execute();
	}

	static public void main(String args[]){
		

		
		Properties prop = new Properties();
		InputStream is = null;

		/* Cargamos un fichero de configuración con el nombre
		 * de la clase de la fachada para cargarla dinámicamente
		 */
		try {
		  is=new FileInputStream("configuracion/configuracion.properties");
		  prop.load(is);
		} catch(IOException e) {
			System.out.println(e);
		}
		
		String nombreArchivoFachada = prop.getProperty("fachadaModelo");
		
		CalculadoraFacadeDelegate fachada = null;
		
		/* Obtenemmos el cargador de clases
		 * del sistema.
		 */
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		try{
			
		/* Cargamos la fachada en tiempo de ejecución y creamos una instancia.
		 * 
		 */
			Class loadedClass = classLoader.loadClass(nombreArchivoFachada);
			fachada = (CalculadoraFacadeDelegate)loadedClass.newInstance();
		} catch(Exception e){
			
			System.out.println(e);
		}
		
		
		Integer suma = fachada.sumar(5,3);
		Integer resta = fachada.restar(5,3);
		Integer factorial = fachada.factorial(5);
	
		System.out.println("Suma: "+suma);
		System.out.println("Resta:"+resta);
		System.out.println("Factorial:"+factorial);
			
		
		
	
	}
}
