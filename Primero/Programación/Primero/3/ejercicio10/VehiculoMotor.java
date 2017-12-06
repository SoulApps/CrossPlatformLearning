package ejercicio10;

public abstract class VehiculoMotor extends Vehiculo implements Arrancable{
	
	protected boolean arrancado = false;
	protected final byte MARCHA_MAX = 6, MARCHA_MIN = 0;
	protected byte marcha = 0;
	protected Motor motor;
	
	public VehiculoMotor(String matricula, Marca marca, int cilindrada, int caballos){
		super(matricula, marca);
		motor = new Motor(caballos, cilindrada);
	}
	
	public void arrancar(){
		if (!arrancado)
			arrancado = true;
	}
	
	public void parar(){
		if (arrancado)
			arrancado = false;
	}
	
	public void subirMarcha(){
		if (marcha < MARCHA_MAX)
			marcha++;
	}
	
	public void bajarMarcha(){
		if (marcha > MARCHA_MIN)
			marcha--;
	}
	
	public Object clone(){
		VehiculoMotor v;
		
		v = (VehiculoMotor)super.clone();
		v.motor = (Motor)motor.clone();
		
		return v;
	}
	
	public int hashCode(){
		int r = super.hashCode();
		
		if (arrancado)
			r+=100;
		else 
			r+=200;
		
		r+=marcha*1000+motor.hashCode();
		return r;
	}
	
	public boolean equals(Object o){
		boolean r = false;
		
		if (o instanceof VehiculoMotor && super.equals(o) && arrancado == ((VehiculoMotor) o).arrancado 
			&& marcha == ((VehiculoMotor) o).marcha && motor.equals(((VehiculoMotor) o).motor))
			r = true;
		
		return r;
	}
	
	public String toString() {
		return String.format("%s, número de ruedas = %d, estado: %s, marcha = %d [Motor: caballos = %d, cilindrada = %d]", 
				super.toString(), calcularNumRuedas(), arrancado?"arrancado":"apagado", marcha, motor.caballos, motor.cilindrada);
	}

	public abstract int calcularNumRuedas();
	
		public class Motor implements Cloneable{
			private int caballos, cilindrada;
			
			public Motor(int caballos, int cilindrada){
				this.cilindrada = cilindrada;
				this.caballos = caballos;
			}
			
			public Object clone(){
				Motor m;
				
				try{
					m = (Motor)super.clone();
				} catch (CloneNotSupportedException e){
					m = null;
				}
				
				return m;
			}
			
			public int hashCode(){
				return caballos*1000+cilindrada*1000;
			}
			public boolean equals(Object o){
				boolean r = false;
				
				if (o instanceof Motor && caballos == ((Motor) o).caballos && cilindrada == ((Motor) o).cilindrada)
					r = true;
				
				return r;
			}
			
			public String toString() {
				return "Motor [caballos=" + caballos + ", cilindrada="
						+ cilindrada + "]";
			}

			public int getCaballos() {
				return caballos;
			}

			public void setCaballos(int caballos) {
				this.caballos = caballos;
			}

			public int getCilindrada() {
				return cilindrada;
			}

			public void setCilindrada(int cilindrada) {
				this.cilindrada = cilindrada;
			}
		}
}
