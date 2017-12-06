package herenciaEjercicio27;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public abstract class Mascota implements Cloneable, Comunicarse {

	//Las variables del abuelo que son heredados a sus hijos y nietos.
	
	protected String nombre;
	protected float cuotaMensual;
	protected Cria cria[]=new Cria[5];
	protected boolean enfadado;
	protected String raza;
	protected String codigo;
	
	
	//Los contructores de Mascota.
	
	Mascota(){
		
		nombre="Sin nombre";
		cuotaMensual=0.00f;
		enfadado=false;
		raza="Desconocido";
		
	}
	
	Mascota(String nombre,float cuotaMensual, boolean enfadado, String raza){
		
		this.nombre=nombre;
		this.cuotaMensual=cuotaMensual;
		this.enfadado=enfadado;
		this.raza=raza;
	
	}
	
	//INICIO DE CLASE INTERNA -------------------------------------------------------------------------
	
	//La clase interna llamada Cria.
	
	public class Cria implements Cloneable{
		
		private String nombre;
		private Date fechaNac;
		
		public Cria(){
		
		nombre="Sin nombre";
		fechaNac= new Date();

		}
		
		public Cria(String nombre, Date fechaNac){
			
			this.nombre=nombre;
			this.fechaNac=fechaNac;
			
		}
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Date getFechaNac() {
			return fechaNac;
		}

		public void setFechaNac(Date fechaNac) {
			this.fechaNac = fechaNac;
		}
				
		// EL equal de la clase interna que comprueba cada una de las variables si es el adecuado. (Cria)

		public boolean equals(Object o){
			
			boolean igual=false;
			
			if(o instanceof Cria){
				
				if(nombre.equals(((Cria) o).nombre)&&fechaNac.equals(((Cria) o).fechaNac)){
				
					igual=true;
					
				}
				
			}
			
			return igual;
			
		}
	
		//El clone de la clase interna. (Cria)
		
		public Object clone(){
			
			Cria c;
			
			try{
				
				c= (Cria) super.clone();
				c.fechaNac= (Date) fechaNac.clone();
				
			}catch(CloneNotSupportedException e){
				
				c = null;
			}
			
			return c;
		
		}
		
		public String toString(){
			
			SimpleDateFormat formato = new SimpleDateFormat("dd-MMMM-yyyy");
			
			return "[Nombre: "+ nombre+"\nFecha nacimiento: "+formato.format(fechaNac)+"]\n\n";
			
		}
				
	}
	
	//FIN CLASE INTERNA ------------------------------------------------------------------------------
	
	/* El metodo de la clase Mascota. (Que cambia el valor a la inversa de la variable enfadado de 
	 * la mascota para curarla como su nombre indica "Analitica")*/
	
	public void analitica (){
		
		if(enfadado)
			enfadado=false;
		
	}
	
	// EL equal de la clase Mascota (Comprueba cada una de las variables si es el adecuado).
	
	public boolean equals(Object o){
		
		boolean igual=false;
		
		if(o instanceof Mascota){
			
			if(codigo.equals(((Mascota)o).codigo)&&nombre.equals(((Mascota) o).nombre)&&cuotaMensual==(((Mascota) o).cuotaMensual)
					&&Arrays.equals(cria,((Mascota) o).cria)&&enfadado==(((Mascota) o).enfadado)
						&&raza.equals(((Mascota) o).raza)){
			
				igual=true;
				
			}
			
		}
		
		return igual;
		
	}
	
	// EL clone de la clase Mascota.
	
	public Object clone(){
		
		Mascota m;
		
		try{
			
			m = (Mascota) super.clone();
			m.cria= cria.clone();
			
			for(byte i=0; i<cria.length; i++){
				
				if(cria[i]!=null){
					
					m.cria[i]=(Cria) cria[i].clone();
					
				}
				
			}
			
		}catch(CloneNotSupportedException e){
			
			m = null;
		}
		
		return m;
		
	}
	
//Getters y setters
	
public String getNombre() {
	return nombre;
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public String getRaza() {
	return raza;
}

public void setRaza(String raza) {
	this.raza = raza;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public float getCuotaMensual() {
	return cuotaMensual;
}

public void setCuotaMensual(float cuotaMensual) {
	this.cuotaMensual = cuotaMensual;
}

public Cria[] getCria() {
	return cria;
}

public void setCria(Cria[] cria) {
	this.cria = cria;
}

public boolean isEnfadado() {
	return enfadado;
}

public void setEnfadado(boolean enfadado) {
	this.enfadado = enfadado;
}



// El toString de la clase Mascota.

public String toString(){
	
	String criamost="";
	int numcria = 0;
	
	for(int i=0;i<cria.length;i++){
		
		if(cria[i]!=null){
		
			criamost+=cria[i].toString();
			numcria++;
		
		}
	}

	return "Mascota \n[Codigo de la mascota: "+codigo+"\nNombre: "+nombre+"\nCuota Mensual: "+cuotaMensual+
			"\nRaza: "+raza+((enfadado)? "\nEsta enfermo \n":"\nNo esta enfermo \n"+"]")
			+ ((numcria>0)? ("\nCrias: \n"+criamost):"");

}

// los metodos implandado de la clase comunicarse.


public abstract String hablar();

@Override
public void enfadarse() {
	
	enfadado=true;
	
}

}
