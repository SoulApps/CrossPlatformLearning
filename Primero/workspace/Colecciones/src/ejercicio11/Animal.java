package ejercicio11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public abstract class Animal implements Comunicarse, Cloneable{

	String nombre;
	double cuotaMensual;
	String raza;
	Crias crias[]=new Crias[5];
	String codigo;

	
	Animal(String nombre, double cuotaMensual, String raza){
		this.nombre=nombre;
		this.cuotaMensual=cuotaMensual;
		this.raza=raza;
	}
	
	 @Override
	public String toString() {
		 
		 int i;
		 
		 String cadena=String.format("%nNombre: %s%nCuotaMensual: %.2f Euros%nRaza: %s%nCrias: ", nombre, cuotaMensual, raza);
		 for(i=0; i<crias.length; i++)
			 if(crias[i]!=null)
				 cadena+="\n\t" + crias[i].toString();
		return cadena + String.format("%nCodigo: %s%nHablar: %s%nEnfadarse: %s", codigo, hablar(), enfadarse());
	}

	//Clase interna
	public class Crias implements Cloneable{

		String nombre;
		Date fnac;

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Date getFnac() {
			return fnac;
		}

        public void setFnac(String fecha) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            try {
                fnac = formato.parse(fecha);
            } catch (ParseException e) {

            }
        }

		Crias(String nombre, String fnac){
			this.nombre=nombre;
            setFnac(fnac);
        }

		@Override
		public String toString() {
            String fecha = new SimpleDateFormat("dd/MM/yyyy").format(fnac);
			return String.format("Nombre: %s%n\tFNac: %s", nombre, fecha);
		}

		public boolean equals(Object obj) {
			boolean resultado=false;
			if(obj instanceof Crias && nombre.equals(((Crias)obj).nombre) && fnac.equals(((Crias)obj).fnac))
				resultado=true;
			return resultado;
		}

		public Object clone(){
			Crias clonado;
			try {
				clonado=(Crias) super.clone();//El clone al que se llama es el de Object
                clonado.fnac = (Date) fnac.clone();
			} catch (CloneNotSupportedException e) {
				clonado=null;
			}
			return clonado;
		}
	}
	//Fin clase interna

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCuotaMensual() {
		return cuotaMensual;
	}

	public void setCuotaMensual(double cuotaMensual) {
		this.cuotaMensual = cuotaMensual;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Crias[] getCrias() {
		return crias;
	}

	public void setCrias(Crias[] crias) {
		this.crias = crias;
	}

	@Override
	public abstract String hablar();

	@Override
	public abstract boolean enfadarse();
	
	public void criar(String nombre, String fnac){
		int i;
		boolean criado=false;
		
		for(i=0; i<crias.length && !criado; i++)
			if(crias[i]==null){
				criado=true;
				crias[i]=new Crias(nombre, fnac);
			}
		
		
	}
	
	public boolean equals(Object obj) {
		boolean resultado=false;
		if(obj instanceof Animal && nombre.equals(((Animal)obj).nombre) 
				&& cuotaMensual==((Animal)obj).cuotaMensual && raza.equals(((Animal)obj).raza) && Arrays.equals(((Animal)obj).crias,crias) && codigo.equals(((Animal)obj).codigo))
				resultado=true;
		return resultado;		
	}	
	
	public Object clone(){
		Animal clonado;
		int i;
		try {
			clonado=(Animal) super.clone();//El clone al que se llama es el de Object
			clonado.crias= crias.clone();
			for (i = 0; i < crias.length; i++) {
				if(crias[i]!=null)
					clonado.crias[i]=(Crias) crias[i].clone();
			}
		} catch (CloneNotSupportedException e) {
			clonado=null;
		}
		return clonado;		
	}
}
