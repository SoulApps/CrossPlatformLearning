public class PruebaValues {
	public static void main(String[] args) {
		for (Dia d : Dia.values()) {
		    System.out.printf("El día de la semana: %s%n", d);
		}
		for (Color c : Color.values()) {
		    System.out.printf("El color %s tiene como Rgb: %s%n", c, c.getRgb());
		}
	}
}
