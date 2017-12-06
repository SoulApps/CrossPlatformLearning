package codigo;


public class IesSaladillo {
	public static void main(String[] args){
		final int NUM_PERSONAS=6;
		Alumno a1=null,a2=null,a3=null;
		Profesor p1=null,p2=null,p3=null;
		Persona datosPersona[],datosClones[]=new Persona[NUM_PERSONAS];
		int i;
		
		///////////////////////////////// APARTADO 1
		System.out.printf("%n Primer apartado del nombre erróneo:  ");
		try{
			a1 = new Alumno("Jose Manuel Contreras De los Rios");
		}catch(NombreIncorrectoException e){
			System.out.println(e.getMessage());
		}
		
		///////////////////////////////// APARTADO 2
		
		try{
			a1 = new Alumno("Maria Peña Espinosa");
			a2  = new Alumno("Jose Valverde Higuera");
			a3 = new Alumno("Juan antonio Ruiz Perez");
			p1= new Profesor("Eva Rojas Del monte", 1500);
			p2 = new Profesor("Ana maria Mijas Olmedo", 1500);
			p3 = new Profesor("Javier Montoya Cuevas", 1200);
		}catch(NombreIncorrectoException e){
			System.out.println(e.getMessage());
		}
		
		System.out.printf("%n Segundo apartado: se han cargado los 3 alumnos y los 3 profesores en el array ");
		datosPersona= new Persona []{a1,a2,a3,p1,p2,p3};
		
		///////////////////////////////// APARTADO 3
		
		System.out.printf("%n%n Tercer apartado: %n");
		
		for(i = 0; i<datosPersona.length; i++){
			System.out.printf("%n %s",datosPersona[i].tipoNumero());
			System.out.printf("%n %s",datosPersona[i]);
			System.out.println();
		}
		
		///////////////////////////////// APARTADO 4
		System.out.printf("%n%n Cuarto apartado: creación de otro array para introducir los clones");
		
		for(i=0;i<datosPersona.length;i++)
			datosClones[i]=(Persona)datosPersona[i].clone();
		
		///////////////////////////////// APARTADO 5
		System.out.printf("%n%n Quinto apartado: las comparaciones entre los originales y sus clones%n");
		
		for(i=0;i<datosPersona.length;i++)
			System.out.printf("%n %s %n%s %s%n %s%n",datosPersona[i].toString(),
					datosPersona[i].equals(datosClones[i])?"":"no","es igual a",
							datosClones[i].toString());
		
		///////////////////////////////// APARTADO 6
		System.out.printf("%n%n Sexto apartado: método con el array de variables de interfaz%n");
		
		metodoInterfaz(datosClones);
	
		for(i=0;i<datosPersona.length;i++)
			System.out.printf("%n %s %n%s %s%n %s%n",datosPersona[i].toString(),
					datosPersona[i].equals(datosClones[i])?"":"no","es igual a",
							datosClones[i].toString());
	}
	public static void metodoInterfaz (Validable valor[]){
		int i;		
		for (i=0; i<valor.length;i++){
			if(i%2==0)
				valor[i].validar();			
			if (valor[i] instanceof Evaluable)
				((Evaluable) valor[i]).ponerNota(7.5f);			
			if (valor[i] instanceof Asalariado)
				((Asalariado) valor[i]).aumentarSueldo(10);			
		}		
	}
}
