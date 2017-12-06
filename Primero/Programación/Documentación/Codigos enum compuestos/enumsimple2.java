import java.util.Scanner;


public class EnumSimple {
	public enum Dia {
		 LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
	}
	public static void main(String[] args) {
		
		Dia d;
		d=Dia.SABADO;
		if(d==Dia.LUNES)
			System.out.println("Empieza la semana");
		else if(d==Dia.SABADO)
			System.out.println("Empieza el fin de semana");		
	}

}
