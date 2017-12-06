package ejercicio04;

import util.Funciones;

/**
 * Created by Alejandro on 29/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        Funciones.abrirConexion();
        //Ambas funcionan.
        //System.out.printf("%d fila(s) afectada(s)", Funciones.insert("UPDATE asignatura SET HorasSemanales = HorasSemanales * 1.1, HorasTotales = HorasTotales * 1.1 WHERE Nombre LIKE 'M%' AND CodAsignatura IN(SELECT CodAsignatura FROM reparto WHERE CodOe = 'FPB')"));
        System.out.printf("%d fila(s) afectada(s)", Funciones.insert("UPDATE asignatura a INNER JOIN reparto r ON a.CodAsignatura = r.CodAsignatura SET HorasSemanales = HorasSemanales * 1.1, HorasTotales = HorasTotales * 1.1  WHERE Nombre LIKE 'M%' AND CodOe = 'FPB'"));
        Funciones.cerrarConexion();
    }
}
