package Bol7;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


public abstract class Eje27Mascota implements Eje27Comunicarse, Cloneable, Comparable<Eje27Mascota>{
	public String nombre;
	public double cuota;
	public String raza;
	public String cod;
	public boolean enfadado = false;
	public Cria crias[];
	public Date fechaN = new Date();
	
	public Eje27Mascota(String nombre, double cuota, String raza, Cria crias[]){
		this.nombre = nombre;
		this.cuota = cuota;
		this.raza = raza;
		this.crias = crias;
	}

	
	public int compareTo(Eje27Mascota o){
		return fechaN.compareTo(o.fechaN);
	}
	
	public Eje27Mascota(){}
	public abstract String genCod();
	
	public String toString(){
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = format.format(fechaN);
		return String.format("-Codigo: %s\n-Nombre: %s\n-Cuota: %.2f\n-Raza: %s\n-Fecha Nacimiento: %s\n", cod, nombre, cuota, raza, fecha);
	}
	
	public boolean enfadarse() {
		enfadado = true;
		return enfadado;
	}
	
	public boolean equals(Object o){
		boolean r = false;
		
		if(o instanceof Eje27Mascota && ((Eje27Mascota) o).nombre.equals(nombre) && ((Eje27Mascota) o).cuota == cuota && ((Eje27Mascota) o).raza.equals(raza) && ((Eje27Mascota) o).cod == cod && ((Eje27Mascota) o).enfadado == enfadado && Arrays.equals(crias, ((Eje27Mascota) o).crias)){
			r=true;
		}
		
		return r;
	}
	
	public Object clone(){
		Eje27Mascota m;
		try{
			m = (Eje27Mascota) super.clone();
			m.crias = crias.clone(); //le asigno este array a la mascota clonada
			for(int i =0 ; i<crias.length ; i++){
				m.crias[i] = (Cria) crias[i].clone();
			}
		}catch(CloneNotSupportedException e){
			m=null;
			System.out.println("Clone no soportado");
		}
		
		return m;
	}
	
	//Cria
	public class Cria implements Cloneable{
		public String nombrec;
		public Date fechan;

				
		public Cria(String nombrec, Date fechan){
			this.nombrec = nombrec;
			this.fechan = fechan;
		}
		
		public String toString(){
			SimpleDateFormat format = new SimpleDateFormat("dd-MMMM-yyyy");
			String fechanac = format.format(fechan);
			return String.format("\n--Nombre Cria: %s\n--Fecha Nacimiento: %s\n\n", nombrec, fechanac);
		}
		
		public Object clone(){
			Cria c;
			
			try{
				c = (Cria) super.clone();
				c.fechan = (Date) fechan.clone();
			}catch(CloneNotSupportedException e){
				c=null;
				System.out.println("Clone no soportado");
			}
			
			return c;
		}
	}
	//
}
