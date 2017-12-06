package es.iessaladillo.jgrana.docencia.ejemplofachada.model.j2sefacade.actions;

public class FactorialAction implements Action{
	
	Integer x;
	
	public FactorialAction(Integer x){
		this.x=x;

	}

	@Override
	public Object execute() {
		int xTipoBasico = x.intValue();
		int factorial=1;
		for (int i=xTipoBasico;i>1;i--){
			factorial=factorial*i;
		}	
		return new Integer(factorial);
	}

	@Override
	public String toString() {
		return "FactorialAction [x=" + x + "]";
	}


	
	
}
