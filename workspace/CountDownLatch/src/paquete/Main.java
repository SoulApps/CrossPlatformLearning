package paquete;


/**
 * Created by Alejandro on 09/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        final int ASISTENTES = 10, DELEGACIONES = 3;
        Videoconferencia videoconferencia = new Videoconferencia(ASISTENTES);
        Delegacion[] delegacion = new Delegacion[DELEGACIONES];

        videoconferencia.start();
        for (int i = 0; i < DELEGACIONES; i++) {
            delegacion[i] = new Delegacion(videoconferencia, i * 4);
            delegacion[i].start();
        }


    }
}
