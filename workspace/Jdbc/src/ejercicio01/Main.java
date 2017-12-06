package ejercicio01;

import teclado.Teclado;
import util.Funciones;

/**
 * Created by Alejandro on 23/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        String tabla = Teclado.next("¿De qué tabla quieres ver información?");
        Funciones.abrirConexion();
        Funciones.mostrarInformacionTabla(tabla);
        Funciones.cerrarConexion();
    }
}
