
public class Potencia extends PotenciaSimple implements Multiplicable {

	public Potencia(int base, int exponente){
		this.base = base;
		this.exponente = exponente;
		
	}

	/* (non-Javadoc)
	 * @see Multiplicable#multiplicar(Potencia)
	 */
	@Override
	public Multiplicable multiplicar(Object potencia)throws NiIdeaDeMatesException{
		Multiplicable resultado= null;
		if (esBaseIgual((Potencia) potencia)){
			resultado = new Potencia(this.getBase(), sumaExponente((Potencia) potencia));
		} else throw new NiIdeaDeMatesException("La base debe de ser igual");	
		return resultado;
			
	}

	private int sumaExponente(Potencia potencia) {
		return this.getExponente()+potencia.getExponente();
	}

	private boolean esBaseIgual(Potencia potencia) {
		return this.getBase()==potencia.getBase();
	}
	
	/** Calcula la potencia de una potencia
	 * 
	 * @param exponente
	 * @return
	 */
	
	public Multiplicable potenciaDePotencia(int exponente){
		return new Potencia(this.getBase(), this.getExponente()*exponente);
	}
	
	@Override
	public String toString() {
		return "Potencia [base=" + base + ", exponente=" + exponente + "]";
	}
	}
