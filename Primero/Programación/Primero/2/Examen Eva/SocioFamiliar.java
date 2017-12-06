import java.util.Arrays;


public class SocioFamiliar extends Socio {
	private int numFamiliares;
	private Familiar familiares[];

	SocioFamiliar(String nombre, String nif,int numFamiliares) throws SocioIncorrectoException{
		super(nombre, nif);
		setnumFamiliares(numFamiliares);	
		familiares=new Familiar[numFamiliares];
	}
	public void setnumFamiliares(int numFamiliares) throws SocioIncorrectoException{
		if(numFamiliares<Constantes.MIN_FAMILIARES || numFamiliares>Constantes.MAX_FAMILIARES)
			throw new SocioIncorrectoException(Constantes.FAM_INCORRECTO);
		else
			this.numFamiliares = numFamiliares;
	}
	public Object clone(){
		int i;
		SocioFamiliar socioFamiliar;
		socioFamiliar=(SocioFamiliar) super.clone();
		socioFamiliar.familiares=familiares.clone();
		for(i=0;i<familiares.length;i++)
			if(familiares[i]!=null)
				socioFamiliar.familiares[i]=(Familiar)familiares[i].clone();
		return socioFamiliar;
	}
	public boolean equals(Object o){
		boolean resultado=false;

		if(o instanceof SocioFamiliar && super.equals(o) && numFamiliares==((SocioFamiliar)o).numFamiliares
			&& Arrays.equals(familiares, ((SocioFamiliar)o).getFamiliares() ))
				resultado=true;
		
		return resultado;
	}
	public String toString() {
		String resultado;
		int i;
		resultado=String.format("%s Número de familiares: %d ",super.toString(),numFamiliares);
		for(i=0;i<familiares.length;i++)
			if(familiares[i]!=null)//Para que no de un NullPointerException si todavía no se han añadido familiares
				resultado+=String.format("\nFamiliar %d: %s",i+1,familiares[i].toString());
		return resultado;
	}
	public float calcularCuotaBasica() {
		return Constantes.CUOTA_BASICA;
	}
	public float calcularCuotaActividades() {
		return (float) (numActividades * (Constantes.CUOTA_ACTIVIDAD * (1 - Constantes.DESCUENTO_FAMILIAR * numFamiliares)));
	}
	public void anadirFamiliar(String nombre,Vinculo vinculo){
		int i=0;
		while(i<numFamiliares && familiares[i]!=null )
			i++;
		if(i<numFamiliares)
			familiares[i]=new Familiar(nombre,vinculo);		
	}
	public void registrarActividadesSocio(String nombreSocio,int numActividades){
		int i;
		boolean enc=false;
		for(i=0;i<familiares.length && !enc;i++)
			if(familiares[i].nombre.equals(nombreSocio)){
				familiares[i].registrarActividades(numActividades);
				enc=true;
			}
	}
	public int getNumFamiliares(){
		return numFamiliares;
	}
	public Familiar[] getFamiliares(){
		return familiares;
	}
	public class Familiar implements Cloneable,Actividades{
		
		private String nombre;
		private Vinculo vinculo;
		
		Familiar(String nombre,Vinculo vinculo){
			this.nombre=nombre;
			this.vinculo=vinculo;
		}
		public Object clone(){
			Familiar familiar;
			try {
				familiar=(Familiar) super.clone();
			} catch (CloneNotSupportedException e) {
				familiar=null;
			}
			return familiar;
		}
		public boolean equals(Object o){
			boolean resultado=false;
			if(o instanceof Familiar && nombre.equals(((Familiar)o).nombre) && vinculo==((Familiar)o).vinculo)
				resultado=true;
			return resultado;
		}
		public String toString() {
			return String.format("%s %s",nombre,vinculo.toString().toLowerCase());
		}
		public void registrarActividades(int numActividades) {
			if(numActividades>0)
				SocioFamiliar.this.numActividades+=numActividades;			
		}
	}
}
