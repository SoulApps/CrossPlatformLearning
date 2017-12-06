package sounds;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class OniiChanDaisuki {

	public static void main(String[] args) throws IOException { //Throws obligatorio o usar otro try catch.
		
		int i;
		String suki = "C:/Users/Alejandro/workspace/Pruebas/src/sounds/Onii-chan-_Daisuki.wav"; //Dirección cambiando las barras  \ por barras /.
		
		for (i = 0; i < 100; i--) {	//Cada vez que se quiera usar hay que ponerlo todo.
			InputStream insuki = new FileInputStream(suki);
			AudioStream daisuki = new AudioStream(insuki);
			AudioPlayer.player.start(daisuki);
			System.out.println("Onii-chan daisuki♥!!");
			
			//Try catch obligatorio.
			try {
				Thread.sleep(2700); //Delay en milisegundos.
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
