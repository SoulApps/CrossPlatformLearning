import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Socio implements Cloneable,Pagos,Actividades{
	protected String nombre;
	protected String nif;
	protected Date fechaAlta=new Date();
	protected int numActividades = 0;
	
	Socio(String nombre, String nif)throws SocioIncorrectoException {
		setNif(nif);
		this.nombre = nombre;
	}
	public void setNif(String nif) throws SocioIncorrectoException {
		if (nif.matches("\\d{8}[A-ZÑ]"))
			this.nif=nif;
		else
			throw new SocioIncorrectoException(Constantes.NIF_INCORRECTO);
	}
	public Object clone(){
		Socio socio;
		try {
			socio=(Socio) super.clone();
			socio.fechaAlta=(Date) fechaAlta.clone();
		} catch (CloneNotSupportedException e) {
			socio=null;
		}
		return socio;
	}
	public boolean equals(Object o){
		boolean resultado=false;
		if(o instanceof Socio && nombre.equals(((Socio)o).nombre) && nif.equals(((Socio)o).nif)
			&& fechaAlta.equals(((Socio)o).fechaAlta) && numActividades==((Socio)o).numActividades)
			resultado=true;
		return resultado;
	}
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy");
		return String.format("%s: %s %s %s NumActividades:%d", getClass().getSimpleName(),nombre,nif,sdf.format(fechaAlta),numActividades);
	}
	public abstract float calcularCuotaBasica();

	public abstract float calcularCuotaActividades();

	public final float calcularCuotaMensual() {
		return calcularCuotaBasica() + calcularCuotaActividades();
	}
	public void registrarActividades(int numActividades){
		if(numActividades>0)
			this.numActividades+=numActividades;
	}
	public void setNumActividades(int numActividades){
		this.numActividades=numActividades;
	}
}
