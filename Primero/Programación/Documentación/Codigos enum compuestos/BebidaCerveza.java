public class BebidaCerveza {
	enum MarcaCerveza { AMBAR, GUINNESS, HEINEKEN }
	private Vaso vaso;
	private MarcaCerveza marca;
	BebidaCerveza(MarcaCerveza marca, Vaso vaso) {
		this.marca=marca;
		this.vaso=vaso;
	}
	public void servir() {
		System.out.printf("Sirviendo %d cc. de cerveza %s en un/a %s de %.2f cm de altura",vaso.getCc(),marca.toString().toLowerCase(),vaso.toString().toLowerCase(),vaso.getAltura());
	}
}
