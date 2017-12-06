package actions;

import personajes.Sanador;

public class SanadorAction implements Action{

	String nombre;
	int fuerzaAtaque;
	int fuerzaDefensa;
	
	public SanadorAction(String nombre, int fuerzaAtaque, int fuerzaDefensa){
		this.nombre=nombre;
		this.fuerzaAtaque=fuerzaAtaque;
		this.fuerzaDefensa=fuerzaDefensa;
		
	}
	
	public Object execute(){
		return new Sanador(nombre, fuerzaAtaque, fuerzaAtaque);
	}
	
	public String toString(){
		return "SanadorAction[Nombre: "+nombre+"FuerzaAtaque: "+fuerzaAtaque+"FuerzaDefensa: "+fuerzaDefensa+"]";
	}
}