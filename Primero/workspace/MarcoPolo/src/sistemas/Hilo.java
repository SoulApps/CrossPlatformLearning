package sistemas;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Alejandro on 10/02/2016.
 */
public class Hilo extends Thread {

    private String sonido;

    public Hilo(String str, String sonido) {
        super(str);
        this.sonido = sonido;
    }
    public void run(){
        int i;
        for (i = 0; i < 10; i++) {
            System.out.printf("%d %s%n", i, getName());

            try {
                sonar(sonido);
            } catch (IOException e){}


            try {
                sleep((int)(Math.random() * 1500));
            } catch (InterruptedException e) {}
        }
        System.out.printf("Final: %s%n",getName());
    }

    //Método que reproduce el archivo .wav
    public void sonar(String sonido) throws IOException {
        InputStream in = new FileInputStream(sonido);
        AudioStream audio = new AudioStream(in);
        AudioPlayer.player.start(audio);
    }

    public static void main(String[] args) {
        final String MARCO = "MarcoHomer.wav";
        final String POLO = "PoloBart.wav";

        new Hilo("Marco", MARCO).start();
        new Hilo("Polo", POLO).start();
    }
}
