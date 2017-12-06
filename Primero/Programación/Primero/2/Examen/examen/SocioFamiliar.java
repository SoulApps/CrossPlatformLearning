package examen;

import java.text.SimpleDateFormat;
import java.util.Arrays;

public class SocioFamiliar extends Socio{
	
	protected Familiares familiar[]=new Familiares[5];
	
	public SocioFamiliar() throws SocioIncorrectoException{
		super();
		
	}
	
	public SocioFamiliar(String nombre, String nif) throws SocioIncorrectoException{
		this.nombre=nombre;
		setNif(nif);
	}
	
	
	public double calcularCuotaBasica(){
		return base;
	}

	public double calcularCuotaActividades(){
		act=familiar.length*Constantes.ACTIVIDAD/Constantes.DESCUENTOFAM;
		return act;
	}
	
	public void registrarActividades(int numAct){
		this.numAct+=numAct;
	}
	
	//Clase interna familiar
		
		public class Familiares implements Cloneable{

			private String nombre;
			private int numAct;
			
			public Familiares(String nombre){
				this.nombre=nombre;
			}
			
			public String getNombre(){
				return nombre;
			}
			
			public void setNombre(String nombre){
				this.nombre=nombre;
			}
			
			public void registrarActividades(int numAct){
				this.numAct=numAct;
			}
			
			
			public boolean equals(Object o){
				boolean igual=false;
				
				if(o instanceof Familiares){
					if(nombre.equals(((Familiares)o).nombre) && (numAct==(((Familiares)o).numAct))){
						igual=true;
					}
				}
				return igual;
			}
			
			public Object clone() {
				Familiares f;
				
				try{
					
					f= (Familiares) super.clone();
					
				}catch(CloneNotSupportedException e){
					
					f = null;
				}
				
				return f;
			}

			public String toString(){
				return "[Nombre: "+nombre+" Número de actividades: "+numAct+"]";
			}
		}
		//Fin de la clase interna
		
		public boolean equals(Object o){
			boolean igual=false;
			
			if(o instanceof SocioFamiliar){
				if(nombre.equals(((SocioFamiliar)o).nombre) && (nif.equals(((SocioFamiliar)o).nif))
						&& (fecha.equals(((SocioFamiliar)o).fecha))
						&& Arrays.equals(familiar, ((SocioFamiliar)o).familiar)){
					igual=true;
				}
			}
			return igual;
		}
		
		public Object clone() {

			SocioFamiliar s;
			byte i;
			
			s=(SocioFamiliar) super.clone();
			s.familiar=familiar.clone();
				
			for(i=0;i<familiar.length;i++){
				if(familiar[i]!=null){
					s.familiar[i]=(Familiares) familiar[i].clone();
				}
			}
			return s;
		}

		public String toString(){
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			String socFam="";
			int numFam=0;
			int i;
			
			for(i=0; i<familiar.length; i++){
				if(familiar[i]!=null){
					socFam+=familiar[i].toString();
					numFam++;
				}
			}
			return "[Nombre: "+nombre+" Nif: "+nif+" Fecha de alta: "+formato.format(fecha)+" Número de familiares: "+familiar.length+"]";
		}
}
