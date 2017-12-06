package ejercicio9;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Munieca extends Juguete{

	Bebe bebe;
	private static final byte PRECIO = 10;
	private Date fechaCompra;
	
	public enum Fecha{
		FEBRERO ("28-04-2015"), MARZO ("01-03-2014");
		
		private final String MES;
		
		Fecha (String mes){
			this.MES = mes;
		}
		
		public String getMES(){
			return MES;
		}
	}
	
	public Munieca() throws NombreIncorrectoException{
		this("SinDef", "SinDef", false, 0, Fecha.FEBRERO);
	}

	public Munieca(String nombre, String color, boolean despierto, float peso, Fecha fechaCom) throws NombreIncorrectoException{
		super(nombre, color);
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		
		bebe = new Bebe(despierto, peso);
		valorEc = valorEconomico();
		
		try {
			fechaCompra = formato.parse(fechaCom.getMES());
			
		} catch (ParseException e){}
	}
	
	public Munieca(String nombre, String color, boolean despierto, float peso, Date fecha) throws NombreIncorrectoException{
		super(nombre, color);
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		
		bebe=new Bebe(despierto, peso);
		valorEc=valorEconomico();
		fechaCompra=fecha;
	}
	
	public int valorEconomico(){
		return PRECIO;
	}
	
	public boolean equals(Object o){
		boolean r = false;
		
		if (o instanceof Munieca && super.equals(o) && fechaCompra.equals(((Munieca) o).fechaCompra) && bebe.equals(((Munieca) o).bebe))
			r = true;
		
		return r;
	}
	
	public Object clone(){
		Munieca m;
		
		m = (Munieca)super.clone();
		m.bebe = (Bebe) bebe.clone();
		m.fechaCompra = (Date) fechaCompra.clone();
		
		return m;
	}

	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		return super.toString() + "Munieca [bebe=" + bebe + " fecha de compra: " + formato.format(fechaCompra) + "]";
	}
	
	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}


				class Bebe implements Cloneable, Acciones{
					
					private boolean despierto;
					private float peso;
					
					public Bebe(boolean despierto, float peso){
						this.despierto = despierto;
						this.peso = peso;
					}
					
					public void dormir(){
						if (despierto)
							despierto = false;
					}
					
					public void despertar(){
						if (!despierto)
							despierto = true;
					}
					
					public void comer(float litros){
						if (despierto)
							peso += litros/4; 
					}
					
					public boolean equals(Object o){
						boolean r = false;
						
						if (o instanceof Bebe && despierto == ((Bebe) o).despierto && peso == ((Bebe) o).peso)
							r = true;
						
						return r;
					}
					
					public Object clone(){
						Bebe b;
						
						try{
							b = (Bebe) super.clone();
						} catch (CloneNotSupportedException e){
							b = null;
						}
						
						return b;
					}
		
					public String toString() {
						return "Bebe [despierto=" + despierto + ", peso=" + peso + "]";
					}
				}
}
