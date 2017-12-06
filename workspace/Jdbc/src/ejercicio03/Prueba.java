package ejercicio03;

import util.SentenciaPreparada;

/**
 * Created by Alejandro on 07/12/2016.
 */
public class Prueba {
    public static void main(String[] args) {
        SentenciaPreparada sentenciaPreparada = new SentenciaPreparada("INSERT INTO curso VALUES(?, ?, ?)");
        sentenciaPreparada.insertPreparado("FPB", "1A", "PBG");

        sentenciaPreparada.setSentencia("INSERT INTO asignatura VALUES(?, ?, ?, ?)");
        sentenciaPreparada.insertPreparado("@AAA", "Operaciones auxiliares para la configuración y la explotación", new Byte((byte) 7), new Short((short) 245));
        sentenciaPreparada.insertPreparado("@AAB", "Montaje y mantenimiento de sistemas y componentes informáticos", new Byte((byte) 9), new Short((short) 315));

        sentenciaPreparada.setSentencia("INSERT INTO reparto VALUES(?, ?, ?, ?)");
        sentenciaPreparada.insertPreparado("FPB", "1A", "@AAA", "JMG");
        sentenciaPreparada.insertPreparado("FPB", "1A", "@AAB", "MPG");

       sentenciaPreparada.cerrarConexion();
    }
}
