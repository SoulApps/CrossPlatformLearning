
public class Club {
	public static void main(String[] args) {
		final byte NUMSOCIOS=6;
		SocioIndividual si = null,si1 = null,si2=null;
		SocioFamiliar sf=null,sf1=null,sf2=null,sf3=null,sf4=null;
		Actividades socios[]=new Actividades[NUMSOCIOS];
		
		System.out.printf("Apartado1: \n");
		try {
			si=new SocioIndividual("Juan","123456789A");//9 dígitos
		} catch (SocioIncorrectoException e) {
			System.out.println(e.getMessage());
		}
		try {
			si=new SocioIndividual("Juan","1234567A");//7 dígitos
		} catch (SocioIncorrectoException e) {
			System.out.println(e.getMessage());
		}
		try {
			si=new SocioIndividual("Juan","12345678a");//Letra minúscula
		} catch (SocioIncorrectoException e) {
			System.out.println(e.getMessage());
		}
		try {
			si=new SocioIndividual("Juan","12345678");//Sin letra
		} catch (SocioIncorrectoException e) {
			System.out.println(e.getMessage());
		}
		System.out.printf("\nApartado2: \n");
		try {
			si=new SocioIndividual("Juan","12345678A");
			si.registrarActividades(23);
			si1=new SocioIndividual("Pepe","87654321B");
			si1.registrarActividades(15);
			System.out.printf("%s Cuota mensual:%.2f",si.toString(),si.calcularCuotaMensual());
			System.out.printf("\n%s Cuota mensual:%.2f",si1.toString(),si1.calcularCuotaMensual());
			System.out.printf("\n%s\n",si.equals(si1)?"Son iguales":"No son iguales");
			si2=(SocioIndividual) si.clone();
			System.out.printf("\n%s \nY su clon: %s",si,si2);
			System.out.printf("\n%s",si.equals(si2)?"Son iguales":"No son iguales");
		} catch (SocioIncorrectoException e) {
			System.out.println(e.getMessage());
		}
		System.out.printf("\n\nApartado3: \n");
		try {
			sf=new SocioFamiliar("Jesus","15896547L",0);
		} catch (SocioIncorrectoException e) {
			System.out.println(e.getMessage());
		}
		try {
			sf1=new SocioFamiliar("Maria","58736027T",1);
			sf1.anadirFamiliar("Pepa", Vinculo.MADRE);
			sf1.registrarActividades(3);
			sf1.registrarActividadesSocio("Pepa", 4);
			sf2=new SocioFamiliar("Ana","85694712P",3);
			sf2.anadirFamiliar("Jose", Vinculo.HERMANO);
			sf2.anadirFamiliar("Esteban", Vinculo.OTRO);
			sf2.anadirFamiliar("Antonio", Vinculo.PADRE);
			sf2.registrarActividades(5);			
			sf2.registrarActividadesSocio("Jose", 1);//Otra forma si no estuviera implementado registrarActividadesSocio: sf2.getFamiliares()[0].registrarActividades(1);
			sf2.registrarActividadesSocio("Esteban", 3);
			sf2.registrarActividadesSocio("Antonio", 9);
			System.out.printf("%s \nCuota mensual:%.2f",sf1.toString(),sf1.calcularCuotaMensual());
			System.out.printf("\n%s \nCuota mensual:%.2f",sf2.toString(),sf2.calcularCuotaMensual());
			System.out.printf("\n%s\n",sf1.equals(sf2)?"Son iguales":"No son iguales");
			sf3=(SocioFamiliar) sf2.clone();
			System.out.printf("\n%s \nY su clon: %s",sf2,sf3);
			System.out.printf("\n%s",sf2.equals(sf3)?"Son iguales":"No son iguales");
		} catch (SocioIncorrectoException e) {
			System.out.println(e.getMessage());
		}
		System.out.printf("\n\nApartado4: ");
		try {
			sf4=new SocioFamiliar("Pilar","75249856U",5);
		} catch (SocioIncorrectoException e) {
			System.out.println(e.getMessage());
		}
		sf4.anadirFamiliar("Raul", Vinculo.HERMANO);
		sf4.anadirFamiliar("Carmen", Vinculo.OTRO);
		sf4.anadirFamiliar("Luis", Vinculo.PADRE);
		sf4.anadirFamiliar("Cristina", Vinculo.MADRE);
		sf4.anadirFamiliar("Roberto", Vinculo.HERMANO);
		si.setNumActividades(0);
		si1.setNumActividades(0);
		si2.setNumActividades(0);
		sf1.setNumActividades(0);
		sf2.setNumActividades(0);
		sf3.setNumActividades(0);
		socios[0]=si;
		socios[2]=si1;
		socios[4]=si2;
		socios[1]=sf1;
		socios[3]=sf2;
		socios[5]=sf4;
		calcularCuotaMensual(registrarActividades(socios));
	}
	public static Actividades[] registrarActividades(Actividades[] socios){
		int i,j;
		for(i=0;i<socios.length;i++){
			socios[i].registrarActividades(i);
			if(socios[i] instanceof SocioFamiliar){
				for(j=0;j<((SocioFamiliar)socios[i]).getFamiliares().length;j++)
					(((SocioFamiliar)socios[i]).getFamiliares())[j].registrarActividades(j);
			}
		}
		return socios;
	}
	public static void calcularCuotaMensual(Actividades[] socios){
		int i;
		for(i=0;i<socios.length;i++)
			System.out.printf("\n\n%s \nCuota mensual: %.2f",((Socio)socios[i]).toString(),((Socio)socios[i]).calcularCuotaMensual());
	}
}
