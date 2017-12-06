package herenciaEjercicio27;

import java.util.Date;


public class Clinica {

	public static void main(String[] args) {
		
		//Las variables de las mascotas.
		
		Loro pirata,l,v;
		Perro a,b;
		Periquito c,d,e;
		Gato g,f;

		//------------------- PRESENTACION ---------------------------
		
		System.out.printf("--------------------------------------\n");
		System.out.println("--RESULTADOS DE LA CLINICA CRUZ ROJA--");
		System.out.printf("--------------------------------------\n");
		
		//##############################################################
		
		System.out.printf("\n-- SECCIÓN DE LOROS --\n");
		System.out.printf("\n--------------------------------------\n");
		
		//------------------------- DATOS DE LOS LOROS ---------------------------------
		
		pirata = new Loro("Piraton",50,true,"Guacamayo",Alimentacion.OMNIVORA,true);		
		l=new Loro("Maruja",50,true,"Cotorra De Kramer",Alimentacion.INSECTIVORA,false);
		l.cria[0]=l.new Cria("Luna",new Date());
		
		//------------------- CONTENIDO DE LOS LOROS DEL MAIN ----------------------------------------------
		
		System.out.printf("\n-- DATOS -- \n%s\n \n-- El loro pirata dice: %s --\n",pirata.toString(),pirata.hablar());
		System.out.printf("\n-- El loro pirata esta enfermo por que esta enfadado, lo cual, se le hace una analitica "
				+ "para curarlo. --\n");
		pirata.analitica();
		System.out.printf("\n-- DATOS --  \n%s --\n",pirata.toString());
		v=(Loro) pirata.clone();
		v.setHablaH(false);
		System.out.printf("\n-- Loro hizo un curso de modales (se clona) --\n");
		System.out.printf("\n-- ¿Son iguales los loros? (comparado el loro clon con el original): "
				+ "%s ya que dice %s --\n",v.equals(pirata)?"Son iguales":"No son iguales",v.hablar());
		System.out.printf("\n##################################################################\n");// OTRO LORO
		System.out.printf("\n-- DATOS -- \n%s \nDice: %s\n",l.toString(),l.hablar());
		System.out.printf("\n-- ¿Son iguales los loros? (comparado con el primero 'LORO PIRATA'):"
				+ " %s \n",l.equals(pirata)?"Son iguales":"No son iguales");
		System.out.printf("\n--------------------------------------\n");
		
		//##############################################################
		
		System.out.printf("\n-- SECCIÓN DE PERROS --\n");
		System.out.printf("\n--------------------------------------\n");
		
		//------------------------- DATOS DE LOS PERROS ------------------------------
		
		a=new Perro("Maya",100,false,"Labrador","HS Perruno",GradoAgresividad.MEDIA);
		a.cria[0]=a.new Cria("Duna",new Date());
		a.cria[1]=a.new Cria("Lino",new Date());
		b=(Perro) a.clone();
		
		//------------------- CONTENIDO DE LOS PERROS DEL MAIN ----------------------------------------------
		
		System.out.printf("\n-- DATOS -- \n%s\n"
				+ "\n##################################################################\n "//OTRO PERRO
				+ "\n-- DATOS DEL CLONADO -- \n%s\n",a.toString(),b.toString());
		System.out.printf("\n-- Comparamos los perros si son identicos: %s  "
				+ "--\n",a.equals(b)?"Son iguales":"No son iguales");
		b.gradoAgresividad=GradoAgresividad.BAJA;
		System.out.printf("\n-- Se le hace una reduccion del nivel de agresividad al 'perro clonado'. --\n");
		System.out.printf("\n-- Comparamos el perro Original con el perro clonado: "
				+ "%s\n",a.equals(b)?"Son iguales":"No son iguales");
		System.out.printf("\n-- Lo que habla el Perro Clonado: %s --\n",b.hablar());
		System.out.printf("\n--------------------------------------\n");
		
		//##############################################################
		
		System.out.printf("\n-- SECCIÓN DE PERIQUITOS --\n");
		System.out.printf("\n--------------------------------------\n");
		
		//-------------------------- DATOS DE LOS PERIQUITOS ------------------------------
		
		c=new Periquito("Impacto",25,false,"Inseparable",Alimentacion.HERBIVORA);
		c.cria[0]=c.new Cria("Picaro",new Date());
		c.cria[1]=c.new Cria("Crak",new Date());
		c.cria[2]=c.new Cria("Pollo",new Date());
		d= new Periquito();
		e= new Periquito();
		
		//------------------- CONTENIDO DE LOS PERIQUITOS DEL MAIN ----------------------
				
		System.out.printf("\n-- DATOS -- \n%s \n-- Dice: %s --\n",c.toString(), c.hablar());
		System.out.printf("\n##################################################################\n");//OTROS PERIQUITOS
		System.out.printf("\n-- Nueva incorporación de periquitos aunque sin registrar. --\n");
		System.out.printf("\n-- DATOS -- \n%s\n "//Periquito d
				+ "\n##################################################################\n"
				+ "\n-- DATOS -- \n%s\n",d.toString(),e.toString());//Periquito e
		System.out.printf("\n-- ¿Son identicos los dos periquitos con datos por defecto?:"
				+ " %s aunque digan lo mismo %s --\n",d.equals(e)?"Son iguales":"No son iguales",d.hablar());
		System.out.printf("\n--------------------------------------\n");
		
		//##############################################################
		
		
		System.out.printf("\n-- SECCIÓN DE GATOS --\n");
		System.out.printf("\n--------------------------------------\n");
		
		//------------- DATOS DE LOS GATOS --------------
		
		 g=new Gato("Bigotes",30,false,"Pesa","GATSONIA");
		 f=new Gato();
		
		//------------------- CONTENIDO DE LOS GAtos DEL MAIN ------------------------
		
		System.out.printf("\n-- DATOS -- \n%s \n-- Dice: %s --\n",g.toString(),g.hablar());
		System.out.printf("\n##################################################################\n");//OTRO GATO
		System.out.printf("\n-- Nuevo gato aunque sin registrar --\n");
		System.out.printf("\n-- DATOS -- \n%s \n-- Dice: %s --\n",f.toString(),f.hablar());
		System.out.printf("\n-- ¿Son identicos los gatos?:"
				+ " %s aunque digan lo mismo %s --\n",g.equals(f)?"Son iguales":"No son iguales",f.hablar());
		
		//----------------- FIN.
		

		
		
		
		
	}

}
