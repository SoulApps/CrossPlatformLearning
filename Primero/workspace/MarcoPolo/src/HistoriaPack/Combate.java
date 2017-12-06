package HistoriaPack;

import java.util.Random;

 class Combate extends Thread{

	
	private Personaje pj;
	private Personaje pj2;
	private Personaje pj3;
	private Personaje pj4;
	
	public Combate (Personaje pj, Personaje pj2, Personaje pj3, Personaje pj4){
		
		this.pj = pj;
		this.pj2 = pj2;
		this.pj3 = pj3;
		this.pj4 = pj4;
		
	}
	
	public void run(){
		int pjAsig;
		Random rnd = new Random ();
		

		do{
			do{
				pjAsig = rnd.nextInt(3);
			} while (estaMuerto(pjAsig));	

			switch (pjAsig){
			
			case 0:
				pj.atacar(pj2);
				break;
				
			case 1:
				pj.atacar(pj3);
				break;
				
			case 2:
				pj.atacar(pj4);
				break;
				
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} while (pj.getVida() > 0&&!todosMuertos());
	}
	
	public boolean estaMuerto(int n){
		boolean muerto = false;
		
		switch (n){
		case 0:
			if(pj2.getVida()==0)muerto = true;
			break;
			
		case 1:
			if(pj3.getVida()==0)muerto = true;
			break;
			
		case 2:
			if(pj4.getVida()==0)muerto = true;
			break;
			
		}
		
		
		return muerto;
	}
	
	public boolean todosMuertos (){
		boolean muerte;
		
		if(pj2.getVida() == 0&&pj3.getVida()==0&&pj4.getVida()==0) muerte = true;
		else muerte = false;
		
		return muerte;
		
		
	}

	
	
}
