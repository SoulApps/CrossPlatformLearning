package colores;


public class Colores {

	public static void main(String[] args) {
		final String RESET = "\u001B[0m";
		final String NEGRO = "\u001B[30m";
		final String ROJO = "\u001B[31m";
		final String VERDE = "\u001B[32m";
		final String AMARILLO = "\u001B[33m";
		final String AZUL = "\u001B[34m";
		final String MORADO = "\u001B[35m";
		final String CELESTE = "\u001B[36m";
		final String BLANCO = "\u001B[37m";
		
		final String FONDO_NEGRO = "\u001B[40m";
		final String FONDO_ROJO = "\u001B[41m";
		final String FONDO_VERDE = "\u001B[42m";
		final String FONDO_AMARILLO = "\u001B[43m";
		final String FONDO_AZUL = "\u001B[44m";
		final String FONDO_MORADO = "\u001B[45m";
		final String FONDO_CELESTE = "\u001B[46m";
		final String FONDO_BLANCO = "\u001B[47m";
		
		final String CELESTE_BLANCO = "\u001B[36;47m"; //Detrás del código del CELESTE(36) se pone ; y el código del fondo blanco(47)
		final String CELESTE_BLANCO_NEGRITA = "\u001B[1;36;47m"; //1 es el código del negrita
		final String CELESTE_BLANCO_SUBRAYADO = "\u001B[4;36;47m"; //4 es el código del subrayado
		final String ROJO_AMARILLO = "\u001B[33;41m";
		
		System.out.println(ROJO + "Este texto es de color rojo" + RESET);
		System.out.println(VERDE + "...y ahora es verde" + RESET);
		System.out.println(FONDO_MORADO + "Fondo morado" + RESET);
		System.out.println(CELESTE_BLANCO + "Fondo blanco con texto celeste" + RESET);
		System.out.println(CELESTE_BLANCO_NEGRITA + "Fondo blanco con texto celeste en negrita" + RESET);
		System.out.println(CELESTE_BLANCO_SUBRAYADO + "Fondo blanco con texto celeste subrayado" + RESET);
		System.out.printf("%s",ROJO_AMARILLO +(char)9733 + RESET);//Estrella
		
	}
}
