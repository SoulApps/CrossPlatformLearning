public class PruebaEnum {
	public static void main(String[] args) {
		BebidaCerveza birra = new BebidaCerveza(BebidaCerveza.MarcaCerveza.AMBAR, Vaso.JARRA);
		birra.servir();
	}
}
