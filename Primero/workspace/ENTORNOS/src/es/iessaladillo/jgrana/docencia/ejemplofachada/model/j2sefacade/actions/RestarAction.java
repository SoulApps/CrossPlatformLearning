package es.iessaladillo.jgrana.docencia.ejemplofachada.model.j2sefacade.actions;

public class RestarAction implements Action{
	
	Integer x;
	Integer y;
	
	public RestarAction(Integer x, Integer y){
		this.x=x;
		this.y=y;
	}

	@Override
	public Object execute() {
		return new Integer(x.intValue()-y.intValue());
	}

	@Override
	public String toString() {
		return "SumarAction [x=" + x + ", y=" + y + "]";
	}
	
	
}
