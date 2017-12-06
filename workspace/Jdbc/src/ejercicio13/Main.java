package ejercicio13;

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
        String profesor = Teclado.next("¿Qué profesor quieres buscar?"), tramo = Teclado.next("¿En qué tramo quieres buscarlo?");
        Funciones.abrirConexion();
        try {
            result = Funciones.select(String.format("SELECT h.CodOe, h.CodCurso FROM horario h, reparto r WHERE h.CodAsignatura = r.CodAsignatura AND CodProf = '%s' AND CodTramo = '%s';", profesor, tramo));
            if (result.next())
                System.out.printf("[CodOe: %s] [CodCurso: %s]%n", result.getString(1), result.getString(2));
            else
                System.out.println("Estará en su casa o algo");

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Funciones.cerrarConexion();
    }
}
