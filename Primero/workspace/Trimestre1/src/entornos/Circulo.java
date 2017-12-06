package entornos;

public class Circulo {
	


	private float x=0;
	private float y=0;
	private float radio=0;
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getRadio() {
		return radio;
	}
	public void setRadio(float radio) {
		if (radio>0){
			this.radio = radio;
		} else {
			System.out.println("No se permite radio negativo");
		}
		
	
	
	}
	
	public float area(){
		return (float) (Math.PI*radio*radio);	
		
	}
	
	public float perimetro(){
		return (float) (Math.PI*radio*2);	
		
	}
	

	@Override
	public String toString() {
		return "Circulo [x=" + x + ", y=" + y + ", radio=" + radio + "]";
	}
	
	
	static public void main(String args[]){
		
		Circulo miCirculo = new Circulo();
		Circulo miOtroCirculo = new Circulo();
		System.out.println("Círculo recién nacido:"+miCirculo);
		miCirculo.setX(1);
		miCirculo.setY(2);
		miCirculo.setRadio(5);
		
		miOtroCirculo.setX(miCirculo.getX());
		miOtroCirculo.setY(miCirculo.getY());
		miOtroCirculo.setRadio(miCirculo.getRadio()*2);
		
		System.out.println("Círculo con sus atributos:"+miCirculo);
		System.out.println("Círculo grande con sus atributos:"+miOtroCirculo);
		
		System.out.println("El area del circulo pequeño es "+miCirculo.area());
		System.out.println("El area del circulo grande es "+miOtroCirculo.area());
		System.out.println("El perímetro del circulo pequeño es "+miCirculo.perimetro());
		System.out.println("El perímetro del circulo grande es "+miOtroCirculo.perimetro());
		
		miOtroCirculo.setRadio(miOtroCirculo.getRadio()*2);
		
		System.out.println("El perímetro del círculo grande agrandado es "+miOtroCirculo.perimetro());
	}
	
	
}
