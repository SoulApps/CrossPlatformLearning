package potencias;
public interface Multiplicable {

	/**
	 * Multiplica potencias de la misma base
	 * @param potencia TODO
	 */
	public abstract Multiplicable multiplicar(Object potencia)
			throws NiIdeaDeMatesException;

}