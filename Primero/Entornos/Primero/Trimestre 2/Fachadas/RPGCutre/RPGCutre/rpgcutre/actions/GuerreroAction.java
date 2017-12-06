package actions;

import personajes.Guerrero;

public class GuerreroAction implements Action{

	String nombre;
	int fuerzaAtaque;
	int fuerzaDefensa;
	
	public GuerreroAction(String nombre, int fuerzaAtaque, int fuerzaDefensa){
		this.nombre=nombre;
		this.fuerzaAtaque=fuerzaAtaque;
		this.fuerzaDefensa=fuerzaDefensa;
		
	}
	
	public Object execute(){
		return new Guerrero(nombre, fuerzaAtaque, fuerzaAtaque);
	}
	
	public String toString(){
		return "GuerreroAction[Nombre: "+nombre+"FuerzaAtaque: "+fuerzaAtaque+"FuerzaDefensa: "+fuerzaDefensa+"]";
	}
}
