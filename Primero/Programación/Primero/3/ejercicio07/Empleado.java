package ejercicio07;

import java.util.ArrayList;
import java.util.Date;

public class Empleado implements Cloneable, Trabajar{
	
	protected String nombre;
	protected float sueldo;
	protected Date fechaAlta;
	protected ArrayList<Venta> venta = new ArrayList<Venta>(); // Preguntar por el clone y el equals. 
	protected int numHoras, numVentas;
	
	public Empleado(){
		this("SinNombre", 0);
	}
	
	public Empleado(String nombre, float sueldo){
		this.nombre = nombre;
		this.sueldo = sueldo;
		numHoras = 0;
		numVentas = 0;
		fechaAlta = new Date();
	}
	
	public boolean equals(Object o){
		boolean r = false;
		
		if (o instanceof Empleado && ((Empleado) o).nombre == nombre && ((Empleado) o).sueldo == sueldo 
			&& numHoras == ((Empleado) o).numHoras && numVentas == ((Empleado) o).numVentas 
			&& venta.equals(((Empleado) o).venta))
					r = true;
					
		return r;
	}
	
	public Object clone(){
		Empleado em;
		try{
			em = (Empleado)super.clone();
			em.venta = new ArrayList<Venta>(venta);
			em.fechaAlta = (Date)fechaAlta.clone();
			
		} catch (CloneNotSupportedException e) {
			em = null;
		}
		return em;
	}
	
	public String toString() {
		String cadVenta = "";
		for (Venta v:venta)
			cadVenta += v.toString()+"\n";
		return "Empleado [nombre=" + nombre + ", sueldo=" + sueldo
				+ ", fechaAlta=" + fechaAlta + ", numHoras=" + numHoras + "] " + "Ventas: \n"+ cadVenta;
	}

	public void incrementarHorasTrabajadas(){
		numHoras+=1;
	}
	
	public void incrementarHorasTrabajadas(int incremento){
		numHoras+=incremento;
		
	}
	
	public void ventaRealizada(int numVenta, float importe){
		venta.add(new Venta(numVenta,importe));
		numVentas++;
	}
	
	public void aumentoProductividad(int porcentaje){
		sueldo+=sueldo*porcentaje/100;
	}
	
		private class Venta implements Cloneable{
			
			private int numVenta;
			private float importe;
				
			public Venta(int numVenta, float importe){
				this.numVenta = numVenta;
				this.importe = importe;
			}
			
			public boolean equals(Object o){
				boolean r = false;
				
				if (o instanceof Venta && ((Venta) o).getNumVenta() == numVenta && ((Venta) o).getImporte() == importe)
					r = true;
				
				return r;
			}
			
			public Object clone(){
				Venta v;
				
				try{
					v = (Venta)super.clone();
				
				} catch(CloneNotSupportedException e){
					v = null;
				}
				return v;
			}

			public String toString() {
				return "- Venta [numVenta=" + numVenta + ", importe=" + importe
						+ "]";
			}

			public int getNumVenta() {
				return numVenta;
			}

			public float getImporte() {
				return importe;
			}
		}
}
