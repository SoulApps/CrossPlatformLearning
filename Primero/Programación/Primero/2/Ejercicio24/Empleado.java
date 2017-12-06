package Ejercicio24;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Empleado implements Trabajar,Cloneable{
	protected String nombre;
	protected float sueldo;
	protected final float SUELDOBASE=600;
	protected Date fechaAlta;
	protected SimpleDateFormat patronFecha= new SimpleDateFormat("d MMM YYYY HH:mm");
	protected int horasTrabajadas;
	protected Ventas ventas[] = new Ventas[5];
	protected long totalImporte=0;
	protected int numVentas=0;	
	
	
	public Empleado(String nombre,int horasTrabajadas){
		fechaAlta=new Date();
		this.nombre=nombre;
		this.horasTrabajadas=horasTrabajadas;
		sueldo=SUELDOBASE;
		
		
	}
	public void incrementar_horas_trabajadas(int num){
		horasTrabajadas+=num;
	}
	public void venta_realizada(int numVenta,long importe){
		if(numVentas<=4){
			ventas[numVentas]= new Ventas(numVenta,importe);
			totalImporte+=importe;
			numVentas++;
		}
	}
	public void aumento_productividad(int porcentaje){
		sueldo+=totalImporte*porcentaje/100;
		
	}
	public String toString(){
		int i;
		String cadena="";
		for(i=0;i<numVentas;i++)
			cadena+="\n\t"+ventas[i].toString();
			
		
		return String.format("Nombre: %s%nCargo: %s%nSueldo: %.2f€%nHoras Trabajadas: %d%nFecha de alta: %s%n%s%s", nombre,getClass().getSimpleName(),sueldo,horasTrabajadas,patronFecha.format(fechaAlta),(numVentas>0)?"\tVENTAS:":"",cadena);
	}
	public Object clone(){
		Empleado v;
		int i;
		try {
			v=(Empleado) super.clone();
			v.fechaAlta= (Date) fechaAlta.clone();
			v.ventas=ventas.clone(); //Hay que hacer este clone() siempre independentemente de que el array contenga primitivos u objetos
									 
			
			for(i=0;i<numVentas;i++) //Si el array es de objetos es necesario crear este for clonando cada posición del array.
				v.ventas[i]=(Ventas) ventas[i].clone();
			
		} catch (CloneNotSupportedException e) {
			v=null;
		}
		return v;
	}
	public boolean equals(Object o){
		boolean igual=false;
		if(o instanceof Empleado)
			if(((Empleado) o).horasTrabajadas==horasTrabajadas && ((Empleado)o).nombre.equals(nombre) && 
			((Empleado)o).numVentas==numVentas && ((Empleado)o).sueldo==sueldo && ((Empleado)o).totalImporte==totalImporte && Arrays.equals(ventas, ((Empleado)o).ventas) && 
			((Empleado)o).fechaAlta.equals(fechaAlta))
				igual=true;
		return igual;
	}
	
	 private class Ventas implements Cloneable{
		    
			private int numVenta;
			private long importe; 
			
			
			public Ventas(int numVenta,long importe){
				this.numVenta=numVenta;
				this.importe=importe;
			}
			

			public String toString(){
				return String.format("Número de venta : %d%n\tImporte: %d€%n", numVenta,importe);
			}
			
			public Object clone(){
				Ventas v;
				try {
					v=(Ventas) super.clone();
				} catch (CloneNotSupportedException e) {
					v=null;
					e.printStackTrace();
				}
				return v;
			}
			public boolean equals(Object o){
				boolean igual=false;
				if(o instanceof Ventas)
					if(((Ventas) o).importe==importe && ((Ventas)o).numVenta==numVenta)
						igual=true;
				return igual;
			}
			

		}
}
