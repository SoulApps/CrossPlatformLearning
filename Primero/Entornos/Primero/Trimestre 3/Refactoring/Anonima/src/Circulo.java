
public class Circulo {
	
	private Punto punto;
	private double radio;
	

	Circulo(double x, double y, double radio){
		this.radio = radio;
		punto = new Punto(x,y);

		
	}
	
	public double area(){
		return Math.PI*radio*radio;
	}
	
	class Punto{
		private double x;
		private double y;
	
		Punto(double x, double y){
			this.x = x;
			this.y = y;
		}
		public double getX() {
			return x;
		}
		public void setX(double x) {
			this.x = x;
		}
		public double getY() {
			return y;
		}
		public void setY(double y) {
			this.y = y;
		}

	}

}
