package colecciones;

public class Clave {
	
	private int num;
	private Categoria categoria;
	private static char c;
	
	
		
	public Clave(Categoria categoria, int num){
		this.c=Categoria.getCodigo( categoria);
		this.num=num;
	}
	
	public String toString(){
		return Categoria.getCodigo(categoria)+""+num;
	}
	
}
