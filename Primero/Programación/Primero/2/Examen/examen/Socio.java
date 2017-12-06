package examen;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Socio implements Pagos, Cloneable, Actividades{
	
	protected String nombre;
	protected String nif;
	protected Date fecha;
	protected double cuota;
	protected int numAct;
	protected double base=Constantes.MES;
	protected double act=Constantes.ACTIVIDAD;
	
	
	public Socio() throws SocioIncorrectoException{
		
		nombre="Nombre";
		//nif="12345678A";
		fecha=new Date();
		
	}
	
	public Socio(String nombre,String nif) throws SocioIncorrectoException{
		this.nombre=nombre;
		setNif(nif);
	}

	public void setNif(String nif) throws SocioIncorrectoException{
		if (nif.matches("[0-9]{8}[A-Z]{1}"))
			this.nif=nif;
		else 
			throw new SocioIncorrectoException("El nif del socio no es correcto");
	}
	
	
	public final double calcularCuotaMensual(){
		return calcularCuotaBasica()+calcularCuotaActividades();
	}
	public abstract double calcularCuotaBasica();
	
	public abstract double calcularCuotaActividades();
	
	public abstract void registrarActividades(int numAct);
	
	
	public Object clone(){
		
		Socio s;
		
		try{
			
			s= (Socio) super.clone();
			s.fecha= (Date) fecha.clone();
			
		}catch(CloneNotSupportedException e){
			
			s = null;
		}
		
		return s;
	}
	
	public String toString(){
		SimpleDateFormat formato = new SimpleDateFormat("dd/MMMM/yyyy");
		return "[Nombre: "+nombre+" Nif: "+nif+" Fecha de alta: "+formato.format(fecha)+"]";
	}
	
	public boolean equals (Object o){
		boolean igual=false;
		
		if(o instanceof Socio){
			if(nombre.equals(((Socio)o).nombre) && (nif.equals(((Socio)o).nif)) && (fecha.equals(((Socio)o).fecha))){
				igual=true;
			}
		}
		return igual;
		
	}
}
