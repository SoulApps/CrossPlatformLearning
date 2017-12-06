import java.util.InputMismatchException;
import java.util.Scanner;


public class LectorGenerico {
	static Scanner scanner = new Scanner(System.in);
	
	@SuppressWarnings("unchecked") //necesario, ya que al nivel en que trabaja eclipse, le es imposible comprobar que lo que recibe sea el tipo correcto
	public static <T> T scanNumberG(char tipo, String mens){
		/*
		-tipo: es un caracter que dependiendo de cual ponga el programador leera un int, float, double, etc. Ej: Si el programador pone el caracter "i" se leera un integer
		-mens: es un mensaje que el usuario pasa por parametro. Ej: "Introduce numero:"
		 */
		 //Ejemplo de lectura de un float en el Main:   float numero = LectorGenerico.scanNumberG('f', "Introduce float gen:");
		boolean salir=false;
		T parm=null;
		
		System.out.println(mens); 
		
		do{
			try{
				salir=false;
				switch(tipo){
				case 'i'://Entero
					parm = (T) new Integer(scanner.nextInt());
					break;
				case 'd'://Double
					parm = (T) new Double(scanner.nextDouble());
					break;
				case 'f'://Float
					parm = (T) new Float(scanner.nextFloat());
					break;
				case 'l'://Long
					parm = (T) new Long(scanner.nextLong());
					break;
				case 's'://Short
					parm = (T) new Short(scanner.nextShort());
					break;
				case 'b'://Byte
					parm = (T) new Byte(scanner.nextByte());
					break;
				case 'c'://Char
					parm = (T) new Character(scanner.nextLine().charAt(0));
					break;
				case 't'://String. Se hace con nextline. Cuidado porque segun que situacion hay que limpiar el scanner antes
					parm = (T) new String(scanner.nextLine());
					break;
				default:
					System.out.println("Error: No se ha especificado el caracter correcto.\n i = Integer\n d = Double\n f = Float\n l = Long\n s = Short\n b = Byte");
				}
			}catch(InputMismatchException e){
				System.out.println("Error: Tipo Incorrecto. ReIntroducir un numero:");
				scanner.nextLine();
				salir=true;
			}
		}while(salir);
		
		return parm;
	}
}
