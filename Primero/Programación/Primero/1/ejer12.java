package boletin2;

import java.util.Scanner;

public class Ejer12 {
	//enum para el ejercicio
	public enum Genero {
		HOMBRE, MUJER
	}
	
	public static void main(String[] args) {
		//declaracion de variables
		Scanner teclado = new Scanner(System.in);
		int edad, genero, hijos;
		Genero sexo;
		//comienzo del programa
			//pedir datos al usuario
		do {
			System.out.println("Introducir la edad del usuario (solo es valida si esta entre 18 y 40)");
			edad=teclado.nextInt();
		} while (edad<18||edad>40);
		do {
			System.out.println("Introducir el genero del usuario");
			System.out.println("1. Hombre");
			System.out.println("2. Mujer");
			genero=teclado.nextInt();
		} while (genero!=1&&genero!=2);
		//uso de un if para introducir en el enum
		sexo=(genero==1)?Genero.HOMBRE:Genero.MUJER;
		do {
			System.out.println("Introducir el numero de hijos");
			hijos=teclado.nextInt();
		} while (hijos<0);
		System.out.printf("La edad: %d, el sexo: %s y tiene %d hijos",edad,sexo,hijos);
		teclado.close();
	}

}
