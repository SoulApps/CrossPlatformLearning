package ejercicio07;

import util.Funciones;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alejandro on 23/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        final String NO_TUTOR = "[Este profesor no es tutor]";
        ResultSet result;
        Funciones.abrirConexion();
        try {
            result = Funciones.select("SELECT * FROM profesor LEFT JOIN curso ON CodProf = Tutor;");

            while (result.next()) {
                System.out.printf("[CodProf: %s] [Nombre: %s] [Apellidos: %s] [FechaAlta: %s] ", result.getString(1), result.getString(2), result.getString(3), result.getTimestamp(4));
                if (result.getString(5) == null)
                    System.out.println(NO_TUTOR);
                else
                    System.out.printf("[CodOe: %s] [CodCurso: %s] [Tutor: %s]%n", result.getString(5), result.getString(6), result.getString(7));
            }

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Funciones.cerrarConexion();
    }
}
