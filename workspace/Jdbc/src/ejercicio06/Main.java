package ejercicio06;

import util.Funciones;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alejandro on 23/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        ResultSet result;
        Funciones.abrirConexion();
        try {
            //a
            result = Funciones.select("SELECT * FROM profesor ORDER BY Apellidos");
            while (result.next())
                System.out.printf("[CodProf: %s] [Nombre: %s] [Apellidos: %s] [FechaAlta: %s]%n", result.getString(1), result.getString(2), result.getString(3), result.getTimestamp(4));

            System.out.println();
            //b
            result = Funciones.select("SELECT * FROM profesor ORDER BY FechaAlta DESC");
            while (result.next())
                System.out.printf("[CodProf: %s] [Nombre: %s] [Apellidos: %s] [FechaAlta: %s]%n", result.getString(1), result.getString(2), result.getString(3), result.getTimestamp(4));

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Funciones.cerrarConexion();
    }
}
