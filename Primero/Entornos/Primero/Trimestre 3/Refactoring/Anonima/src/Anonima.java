
public class Anonima {

	
	static public void main(String args[]){
	Runnable thread = new Runnable () {public void run(){System.out.println("Ejecutando thread");}};
	thread.run();
	}
	
	
}
