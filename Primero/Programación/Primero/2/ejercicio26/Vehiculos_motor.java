package ejercicio26;

public abstract class Vehiculos_motor extends Vehiculo implements Arrancable, Cloneable{
	
	protected Motor motor;
	protected boolean encendido = false;
	protected int marcha = 0;
	
	public Vehiculos_motor(String modelo, Marca marca, int cilindrada, int caballos){
		super (modelo, marca);
		motor = new Motor (cilindrada, caballos);		
	}
	
	public Vehiculos_motor (){
		this ("000F", Marca.GLOBE, 0,0);
	}
	
	public Object clone(){
		
		Vehiculos_motor vm;
		
		vm = (Vehiculos_motor) super.clone();
		vm.motor = (Motor) motor.clone();
		
		return vm;		
		
	}
	
	public boolean equals (Object obj){
		boolean r = false;
		
		if (obj instanceof Vehiculos_motor && super.equals(obj) 
				&& motor.equals(((Vehiculos_motor) obj).motor))
			r = true;
		
		return r;
	}
	
	
	class Motor implements Cloneable{
		
		protected int cilindrada;
		protected int caballos;

		
		
		public Motor (int cilindrada, int caballos){
			this.cilindrada = cilindrada;
			this.caballos = caballos;
		}
		
		public Motor (){
			this(0, 0);
		}
		
		public Object clone(){
			
			Motor m;
			
			try {
				m=(Motor)super.clone();
			} catch (CloneNotSupportedException e) {
				m=null;
			}
			return m;		
			
		}
		
		public boolean equals(Object obj) {

			boolean bool = false;

			if (obj instanceof Motor){
				if (((Motor) obj).cilindrada == cilindrada
					&& ((Motor) obj).caballos == caballos)
					bool = true;}
				
			return bool;
		}

		public String toString(){
				return String.format("Tiene %d cc y %d caballos", cilindrada, caballos);
		}
	}

	
	public void arrancar() {
		encendido = true;

	}

	public void parar() {
		encendido = false;
		
	}

	
	public void subir_marcha() {
		if(marcha<6) marcha++;
		
	}

	public void bajar_marcha() {
		if(marcha>0) marcha--;
		
	}
	
	public void puntoMuerto (){
		marcha = 0;
	}
	
	public void marchaAtras (){
		if (marcha == 0) marcha = -1;
	}
	
	public abstract byte calcularNumRuedas();
	
	public String toString(){
		String marchaMetida;
		
		switch (marcha){
			case -1:
				marchaMetida = "tiene metida la marcha atras";
				break;
			case 0:
				marchaMetida = "esta en punto muerto";
				break;
			default:
				marchaMetida = "tiene metida la "+marcha+"º marcha";
				break;
		}
		
		return String.format("Esta %s, %s, %s, %d ruedas. Su motor: %s", encendido?"encendido":"apagado", marchaMetida, super.toString(), calcularNumRuedas(), motor.toString());
		
	}
}
