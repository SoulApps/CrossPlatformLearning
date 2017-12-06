package prueba;

import java.io.File;

/**
 * Created by Alejandro on 24/11/2015.
 */
public class Terror {
    public static void main(String[] args) {
        int i;
        File f = new File("C:/Users/Alejandro/workspace/Trimestre1/src/prueba/Texto.txt");
        System.out.println("Este programa se auto destruirá en 10 segundos.");
        for (i = 10; i > 0; i--) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        System.out.println("Boooom!!!!!!");
        f.delete();
    }
}
