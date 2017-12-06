package codigo;


import java.util.Arrays;

public class Alumno extends Persona implements Evaluable{
	private final float NOTA_INICIAL= -1;
	private final int MAXNOTA=5;
	private float nota[]=new float[MAXNOTA];
	private static int numero=0;
	
	Alumno(String nombre) throws NombreIncorrectoException {
		super(nombre);
		numOrden=++numero;
		Arrays.fill(nota,NOTA_INICIAL);
	}
	public boolean equals(Object o){
		boolean result=false;
		
		if(o instanceof Alumno && super.equals(o) && Arrays.equals(nota, ((Alumno) o).nota))
			result=true;
		
		return result;
	}	
	public Object clone(){
		Alumno clonado;
		
		clonado=(Alumno)super.clone();
		clonado.nota=nota.clone();
		
		return clonado;
	}	
	public String toString() {
		return "Alumno [" +super.toString()+ " nota=" + Arrays.toString(nota) + "]";
	}
	public void ponerNota(float numNota) {
		int i;
		boolean exit=false;
		
		for (i=0;i<nota.length&&!exit;i++)
				if(nota[i]==NOTA_INICIAL){
					nota[i]=numNota;
					exit=true;
				}
	}	
}
