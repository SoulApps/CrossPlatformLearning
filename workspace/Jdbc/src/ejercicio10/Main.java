package ejercicio10;

import teclado.Teclado;
import util.Funciones;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alejandro on 24/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        ResultSet result;
        String asignatura = Teclado.next("¿Qué asignatura quieres buscar?"), curso = Teclado.next("¿Qué curso quieres buscar?"), oe = Teclado.next("¿Qué oferta educativa quieres buscar?");
        Funciones.abrirConexion();
        try {
            result = Funciones.select(String.format("SELECT * FROM horario WHERE CodAsignatura = '%s' AND CodCurso = '%s' AND CodOe = '%s';", asignatura, curso, oe));
            while (result.next())
                System.out.printf("[CodTramo: %s] [CodOe: %s] [CodCurso: %s] [CodAsignatura: %s]%n", result.getString(1), result.getString(2), result.getString(3) ,result.getString(4));
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Funciones.cerrarConexion();
    }
}
