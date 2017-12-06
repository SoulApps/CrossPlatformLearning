import java.util.Date;
import java.util.TimeZone;


public class ClaseTimeZone {

	public static void main(String[] args) {
		int i;
		String id_zonas[];
		TimeZone tz = TimeZone.getDefault();
		System.out.println(tz.getClass().getSimpleName());
		System.out.printf("ID de esta zona horaria: %s\n",tz.getID());
		System.out.printf("Nombre de la zona horaria: %s\n", tz.getDisplayName());		
		System.out.printf("Esta zona horaria %s utiliza horario de verano\n",tz.useDaylightTime()?"si":"no");
		System.out.printf("Esta zona horaria %s está en un cambio horario\n", tz.inDaylightTime(new Date())?"si":"no");
		//Se almacenan las ID de zona horaria disponibles en un array y se muestran
		id_zonas = TimeZone.getAvailableIDs();
		for(i=0;i<id_zonas.length;i++)
			System.out.printf("%d - %s\n",i, id_zonas[i]);
		//se cambia la zona horaria por una de las obtenidas en la lista anterior
		tz.setID("Antarctica/South_Pole");
		System.out.printf("\nZona horaria actualizada, ID: %s Nombre: %s",tz.getID(),tz.getDisplayName());
	}
}
