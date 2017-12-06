public enum Vaso {
	
	JARRA(500,20.7f), TUBO(250,16.8f), TERCIO(333,12.3f), CAÑA(200,8.5f);
	
	private int cc; 
	private float altura;
	
	Vaso(int cc,float altura) {
		this.cc=cc;
		this.altura=altura;
	}
	public int getCc() {
		return cc;
	}
	public float getAltura() {
		return altura; 
	}
}
