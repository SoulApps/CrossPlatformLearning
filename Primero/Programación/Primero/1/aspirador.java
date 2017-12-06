
public class Aspirador {

	public Aspirador(){
		System.out.println("Ha nacido un aspirador!!!!");
		setPotencia(1);
		encendido = false;
	}
	
	private int potencia;
	private boolean encendido;
	
	public int getPotencia() {
		return potencia;
	}

	
	public boolean isEncendido() {
		return encendido;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public void arrancarParar(){
		if (encendido){
			System.out.println("Apagando...");
			encendido = false;
		} else{
			System.out.println("Encendiendo con potencia actual "+potencia);
			
			encendido = true;
		}
		
	}
	
	public void recogerCable(){
		System.out.println("Recogiendo cable...");
	}
	
	
	static public void main(String args[]){
		
		Aspirador miAspirador = new Aspirador();
		
		miAspirador.arrancarParar();
		miAspirador.setPotencia(4);
		System.out.println("Potencia actual: "+miAspirador.getPotencia());
		miAspirador.arrancarParar();
		
	}
	
}
