import java.util.ArrayList;

public class Alumno implements Cloneable{
	
	private String nombre;
	private ArrayList<Integer> notas;
	private ArrayList<Asignatura> asignaturas;
	
	Alumno(String nombre,ArrayList<Integer> notas,ArrayList<Asignatura> asignaturas){
		this.nombre=nombre;
		this.notas=notas;
		this.asignaturas=asignaturas;
	}
	@SuppressWarnings("unchecked")
	public Object clone(){
		Alumno alumno;
		int i;
		try {
			alumno=(Alumno) super.clone();
			alumno.notas= (ArrayList<Integer>) notas.clone();
			alumno.asignaturas=(ArrayList<Asignatura>) asignaturas.clone();
			for(i=0;i<asignaturas.size();i++)
				alumno.asignaturas.set(i, (Asignatura)asignaturas.get(i).clone());
			
		} catch (CloneNotSupportedException e) {
			alumno=null;
		}
		return alumno;
	}
	public boolean equals(Object o){
		boolean resultado=false;
		if(o instanceof Alumno && notas.equals(((Alumno)o).notas) && asignaturas.equals(((Alumno)o).asignaturas))
				resultado=true;
		return resultado;
	}
	public String toString() {
		return "Alumno [nombre=" + nombre + ", notas=" + notas
				+ ", asignaturas=" + asignaturas + "]";
	}
	public static void main(String[] args) {
		ArrayList<Asignatura> asignaturas=new ArrayList<Asignatura>();
		ArrayList<Integer> notas=new ArrayList<Integer>();
		notas.add(8);
		notas.add(9);
		notas.add(10);
		asignaturas.add(new Asignatura("BD",6));
		asignaturas.add(new Asignatura("Programacion",8));
		asignaturas.add(new Asignatura("Sistemas",6));
		Alumno a2,a1=new Alumno("Cristina",notas,asignaturas);
		a2=(Alumno)a1.clone();
		System.out.printf("Alumno a1: %s \nClonado: %s",a1,a2);
		System.out.printf("\nEl alumno a1 %s al alumno a2",a1.equals(a2)?"es igual":"no es igual");
		a2.notas.set(0, 10);
		a2.asignaturas.get(0).nombre = "FOL";
		a2.asignaturas.get(0).numHoras = 3;
		System.out.printf("\nAlumno a1: %s \nClonado: %s",a1,a2);
		System.out.printf("\nEl alumno a1 %s al alumno a2",a1.equals(a2)?"es igual":"no es igual");
	}
}
