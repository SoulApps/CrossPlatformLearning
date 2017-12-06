package sounds;
import java.io.*;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Countdown {

	public static void main(String[] args) throws IOException {
		
		String suki = "C:/Users/Alejandro/workspace/Pruebas/src/sounds/Onii-chan-_Daisuki.wav";
		String sonido = "C:/Users/Alejandro/Music/osu!/Skins/LostCool-Mix/readys.wav";
		String one = "C:/Users/Alejandro/Music/osu!/Skins/LostCool-Mix/count1s.wav";
		String two = "C:/Users/Alejandro/Music/osu!/Skins/LostCool-Mix/count2s.wav";
		String three = "C:/Users/Alejandro/Music/osu!/Skins/LostCool-Mix/count3s.wav";
		String zero = "C:/Users/Alejandro/Music/osu!/Skins/LostCool-Mix/gos.wav";
		
		//Countdown
		InputStream in = new FileInputStream(sonido);
		AudioStream audio = new AudioStream(in);
		AudioPlayer.player.start(audio);
		System.out.println("Countdown!!");
		
		
		delayL();
		
		//3
		InputStream input3 = new FileInputStream(three);
		AudioStream tres = new AudioStream(input3);
		AudioPlayer.player.start(tres);
		System.out.println("THREE!!");
		
		delayC();
	
		//2
		InputStream input2 = new FileInputStream(two);
		AudioStream dos = new AudioStream(input2);
		AudioPlayer.player.start(dos);
		System.out.println("TWO!!");
		
		
		delayC();
	
		//1
		InputStream input1 = new FileInputStream(one);
		AudioStream uno = new AudioStream(input1);
		AudioPlayer.player.start(uno);
		System.out.println("ONE!!");
		
		delayC();
	
		//0
		InputStream input0 = new FileInputStream(zero);
		AudioStream cero = new AudioStream(input0);
		AudioPlayer.player.start(cero);
		System.out.println("ZERO!!");
		
		
		delay();
		
		//Onii-chan Daisuki!
		InputStream insuki = new FileInputStream(suki);
		AudioStream daisuki = new AudioStream(insuki);
		AudioPlayer.player.start(daisuki);
		System.out.println("Onii-chan daisuki♥!!");
		
	}

	private static void delay(){
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void delayC(){
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void delayL(){
		try {
			Thread.sleep(1300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
