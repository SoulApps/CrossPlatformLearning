package colecciones;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Empleado implements Cloneable{
	
	private Clave clave;
	private String nombre;
	private Date fechaAlta=new Date();
	private Date fechaBaja=new Date();
	private static Categoria categoria;
	private static int diasTrabajados;
	
	
	
	
	public Empleado(String nombre, Categoria categoria, Date fechaAlta, Date fechaBaja){
		this.nombre=nombre;
		this.setCategoria(categoria);
		this.fechaAlta=fechaAlta;
		this.fechaBaja=fechaBaja;
	}
	
	public Empleado(){
		nombre="Nombre";
		categoria=null;
		fechaAlta=null;
		fechaBaja=null;
	}
	
	private void setCategoria(Categoria categoria){
		
	}
	
	private Categoria getCategoria(){
		return categoria;
	}
	

	public String asignarClave(Categoria categoria){
		
		return clave.toString();
		
	}
	
	//Clon de Empleado 
	public Object clone(){
		
		Empleado emp;
		
		try{
			emp= (Empleado) super.clone();
			
		}catch(CloneNotSupportedException e){
			emp=null;
		}
		
		return emp;
		
	}
	
	//toString de Empleado
	public String toString(){
		return getCategoria()+" Nombre: "+nombre+" Clave: "+clave+" Fecha alta: "+fechaAlta+" Fecha baja: "+fechaBaja+" Días trabajados: "+diasTrabajados;
	}
	
	//Método para calcular los días trabajados sin terminar
	public static int calcularDiasTrabajados(String fechaAlta){
		int diasTrabajados = 0;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String fechaBaja;

		return diasTrabajados;
	}


}
