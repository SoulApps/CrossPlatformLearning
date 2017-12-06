package HistoriaPack;
import java.text.DecimalFormat;
import java.util.Random;

import ArmasPack.Arma;
import ClasePack.Clase;

public class Personaje {
	
	private String nombre;
	private Clase clase;
	private Arma arma;
	private boolean muerto = false;
	private boolean armado = false;
	private double vida = 100;
	private int danho = 10;
	private double defensa = 10;
	private int probEsquivar = 0;
	
	public Personaje (String nombre, Clase clase){
		this.nombre = nombre;
		this.clase = clase;
		calcularBonus();
	}
	
	public void calcularBonus(){
		if (clase.isRanged()){
			if(clase.isMagico()) {		//Mago
				vida = vida - calculoBonus((int)vida);
				danho = danho + (calculoBonus(danho))*2;
				defensa = defensa - calculoBonus((int)defensa);
				

			}
			else {						//Arquero
				vida = vida - calculoBonus((int)vida);
				danho = danho + calculoBonus(danho);
				defensa = defensa - calculoBonus((int)defensa);
				probEsquivar = probEsquivar + clase.getBonus();
			}
		}
		else{
			if(clase.isMagico()){  	//Paladin
				vida = vida + calculoBonus((int)vida);
				danho = danho + calculoBonus(danho);
				defensa = defensa + calculoBonus((int)defensa);

			}
			else{				//Caballero
				vida = vida + calculoBonus((int)vida);
				danho = danho - calculoBonus(danho)/2;
				defensa = defensa + calculoBonus((int)defensa);

			}
		}
	}
	
	public int calculoBonus(int estadistica){
		
		return (estadistica*clase.getBonus())/100;
		
	}
	
	public void estadisticas(){
		DecimalFormat df = new DecimalFormat("#.##");
		
		System.out.println("Estadisticas");
		System.out.println("------------");
		System.out.println("Nombre: "+getNombre());
		System.out.println("Clase: "+getClase().getNombre());
		System.out.println("Vida: "+df.format(getVida()));
		System.out.print("Arma: ");
		if(armado) System.out.println(arma.getNombre());
		else System.out.println("Desarmado");
		System.out.println("Daño: "+getDanho());
		System.out.println("Defensa: "+getDefensa());
		System.out.println("Probabilidad de Esquivar: "+getProbEsquivar()+"%");
		
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public Arma getArma() {
		return arma;
	}

	public double getVida() {
		return vida;
	}

	public void setVida(double vidaRest) {
		
		if(vidaRest < 0){
			this.vida = 0;
		}
		else this.vida = vidaRest;
	}

	public double getDefensa() {
		return defensa;
	}


	public int getProbEsquivar() {
		return probEsquivar;
	}

	public void setProbEsquivar(int probEsquivar) {
		this.probEsquivar = probEsquivar;
	}

	public int getDanho() {
		return danho;
	}

	public void setDanho(int danhoFis) {
		this.danho = danhoFis;
	}

	
	public void armar (Arma arma) throws ClaseException{
		if(clase.comprobar(arma)){
			this.arma = arma;	
			danho = danho + arma.getDanho();
			armado = true;
		}
		else throw new ClaseException("No puede llevar esa arma");

	}
	
	public void desarmar () throws DesarmadoException{
		if(arma!=null){
			danho = danho - arma.getDanho();
			armado = false;
			this.arma = null;
		}
		else{
			throw new DesarmadoException("Ya esta desarmado.");
		}
	}
	
	public double redDanho(){
		
		double total;
		DecimalFormat df = new DecimalFormat("#.##");
		String f;
		
		f= df.format((defensa/(100+defensa))*100);
		f = f.replace(",", ".");
		
		total = Double.parseDouble(f);
		
		return total;
	}
	
	public void atacar (Personaje pj){
		double vidaRest, danho;
		DecimalFormat df = new DecimalFormat("#.##");
		String f;
		Random  rnd = new Random();
		int prob;
			
			if(getVida() > 0&&pj.getVida() > 0){
				if(pj.getProbEsquivar()==0){
						danho = pj.getDanho() * (100-pj.redDanho())/100;
						
						f= df.format(danho);
						f = f.replace(",", ".");
						
						danho = Double.parseDouble(f);
						
						vidaRest = pj.getVida() - danho;
						
						pj.setVida(vidaRest);
						
						System.out.println(nombre+" asestó un golpe a "+pj.getNombre());
						
						if(pj.getVida()==0)System.out.println("Y "+pj.getNombre()+" murió.");
						
				}
				else{
					
					prob = rnd.nextInt(100)+1;
					if(prob>=1&&prob<=pj.getProbEsquivar()){
					
						System.out.println(nombre+" asestó un golpe a "+pj.getNombre()+". Y "+pj.getNombre()+" lo esquivó.");
						
					}
					else {
						
						danho = pj.getDanho() * (100-pj.redDanho())/100;
						
						f= df.format(danho);
						f = f.replace(",", ".");
						
						danho = Double.parseDouble(f);
						
						vidaRest = pj.getVida() - danho;
												
						System.out.println(nombre+" asestó un golpe a "+pj.getNombre());
						
						pj.setVida(vidaRest);
						
						if(pj.getVida()==0)System.out.println("Y "+pj.getNombre()+" murió.");
					}
				}
			}
			
	}
	

	public void setDefensa(double defensa) {
		this.defensa = defensa;
	}

	public boolean isMuerto() {
		return muerto;
	}

	public void setMuerto(boolean muerto) {
		this.muerto = muerto;
	}
	
}
