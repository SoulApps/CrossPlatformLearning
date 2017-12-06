package examen;

public class Main {

	public static void main(String[] args) {
		
		//Parte 1
		
		System.out.printf("------PARTE 1------\n");
		
		//Nif con un dni mayor de 8 dígitos
		try{
			SocioIndividual s=new SocioIndividual("Pepe", "123456789A");
		}catch (SocioIncorrectoException e){
			System.out.println("El nif del socio no es correcto para un nif mayor de 8 dígitos");
		}
		
		//Nif con un dni menor de 8 dígitos
		try{
			SocioIndividual s=new SocioIndividual("Pepe", "1234567A");
		}catch (SocioIncorrectoException e){
			System.out.println("El nif del socio no es correcto para un nif menor de 8 dígitos");
		}
		
		//Nif con un dni con letra minúscula
		try{
			SocioIndividual s=new SocioIndividual("Pepe", "12345678a");
		}catch (SocioIncorrectoException e){
			System.out.println("El nif del socio no es correcto para un nif con una letra minúscula");
		}
		
		//Nif sin letra
		try{
			SocioIndividual s=new SocioIndividual("Pepe", "12345678");
		}catch (SocioIncorrectoException e){
			System.out.println("El nif del socio no es correcto para un nif sin letra");
		}
		
		//Fin de la parte 1

		
		
		//Parte 2
		
		System.out.printf("\n\n\n------PARTE 2------\n");
		
		try{
			SocioIndividual s1=new SocioIndividual("Pepe", "12345678A");
			SocioIndividual s2=new SocioIndividual("Juan", "12345678B");
			SocioIndividual s3=new SocioIndividual("Pepe", "12345678W");
			
			s1.registrarActividades(23);
			s2.registrarActividades(15);
			
			System.out.println(s1.toString());
			System.out.println(s1.calcularCuotaMensual());
			
			
			System.out.println(s2.toString());
			System.out.println(s2.calcularCuotaMensual());
			
			System.out.println(s1.equals(s3));
			
			s3=(SocioIndividual)s1.clone();
			System.out.println(s1.equals(s3));
		}catch (SocioIncorrectoException e){
			System.out.println("El nif del socio no es correcto");
		}
		
		//Parte 3

		System.out.printf("\n\n\n------PARTE 3------\n");

		SocioFamiliar a, b, c;
		try {
			a=new SocioFamiliar("Pepe", "12345678A");
			System.out.println(a.toString());
			a.registrarActividades(1);
			System.out.println(a.calcularCuotaMensual());
		
			b=new SocioFamiliar("Segundo", "12345678A");
			b.registrarActividades(2);
			System.out.println(b.toString());
			b.familiar[0]=b.new Familiares("Joe");
			b.familiar[0].registrarActividades(1);
			System.out.println(a.calcularCuotaMensual());
			
			c=new SocioFamiliar("Ternera", "12345678A");
			System.out.println(c.toString());
			c.registrarActividades(3);
			c.familiar[0]=c.new Familiares("Wesley");
			c.familiar[0].registrarActividades(1);
			c.familiar[1]=c.new Familiares("Mengano");
			c.familiar[1].registrarActividades(2);
			c.familiar[2]=c.new Familiares("Fulano de Tal");
			c.familiar[2].registrarActividades(3);
			System.out.println(a.calcularCuotaMensual());
			
			System.out.println(a.equals(b));
			
			c=(SocioFamiliar)a.clone();
			System.out.println(a.equals(c));
			
			
		}catch (SocioIncorrectoException e){
			System.out.println("El nif del socio no es correcto para un nif mayor de 8 dígitos");
		}
		
		//Fin de la parte 3
		
	}

	
	
}
