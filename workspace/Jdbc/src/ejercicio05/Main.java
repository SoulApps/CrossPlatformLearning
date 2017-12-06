package ejercicio05;

import util.Funciones;

/**
 * Created by Alejandro on 29/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        Funciones.abrirConexion();
        System.out.printf("%d filas afectadas", Funciones.insert("DELETE FROM ofertaeducativa WHERE CodOe = 'FPB'"));
        Funciones.cerrarConexion();
    }
}
