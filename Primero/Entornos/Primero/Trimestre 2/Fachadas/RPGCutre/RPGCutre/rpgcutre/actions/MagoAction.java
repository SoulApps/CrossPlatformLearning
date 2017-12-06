package actions;

import personajes.Mago;

public class MagoAction implements Action{

	String nombre;
	int fuerzaAtaque;
	int fuerzaDefensa;
	
	public MagoAction(String nombre, int fuerzaAtaque, int fuerzaDefensa){
		this.nombre=nombre;
		this.fuerzaAtaque=fuerzaAtaque;
		this.fuerzaDefensa=fuerzaDefensa;
		
	}
	
	public Object execute(){
		return new Mago(nombre, fuerzaAtaque, fuerzaAtaque);
	}
	
	public String toString(){
		return "MagoAction[Nombre: "+nombre+"FuerzaAtaque: "+fuerzaAtaque+"FuerzaDefensa: "+fuerzaDefensa+"]";
	}
}