package examen;

import java.text.SimpleDateFormat;

public class SocioIndividual extends Socio{
	
	public SocioIndividual() throws SocioIncorrectoException{
		super();
	}
	
	public SocioIndividual(String nombre, String nif) throws SocioIncorrectoException{
		this.nombre=nombre;
		setNif(nif);
	}
	
	
	public double calcularCuotaBasica(){
		if(numAct>Constantes.LIMACTIND)
			base=Constantes.MES/Constantes.DESCUENTOIND;
		else
			base=Constantes.MES;
		return base;	
	}
	
	public double calcularCuotaActividades(){
		act=numAct*act;
		return act;
	}

	
	public void registrarActividades(int numAct){
		this.numAct=numAct;
	}

	public boolean equals(Object o){
		boolean igual=false;
		
		if(o instanceof SocioIndividual){
			if(nombre.equals(((SocioIndividual)o).nombre) && (nif.equals(((SocioIndividual)o).nif)) && (fecha.equals(((SocioIndividual)o).fecha))){
				igual=true;
			}
		}
		return igual;
	}
	
	public Object clone() {

		return super.clone();
	}

	public String toString(){
		SimpleDateFormat formato = new SimpleDateFormat("dd/MMMM/yyyy");
		return "[Nombre: "+nombre+" Nif: "+nif+" Fecha de alta: "+formato.format(fecha)+"]";
	}
}
