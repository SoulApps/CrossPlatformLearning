
public class SocioIndividual extends Socio {

	SocioIndividual(String nombre, String nif) throws SocioIncorrectoException {
		super(nombre, nif);
	}
	public boolean equals(Object o){
		boolean resultado=false;
		if(o instanceof SocioIndividual && super.equals(o))
			resultado=true;
		return resultado;
	}
	public float calcularCuotaBasica() {
		float resultado; 
		if (numActividades > Constantes.ACTIVIDADES_INDIVIDUAL)
			resultado = Constantes.CUOTA_BASICA * (1-Constantes.DESCUENTO_INDIVIDUAL);
		else
			resultado = Constantes.CUOTA_BASICA;
		return resultado; 
	}

	public float calcularCuotaActividades() {
		return numActividades * Constantes.CUOTA_ACTIVIDAD;
	}
}
