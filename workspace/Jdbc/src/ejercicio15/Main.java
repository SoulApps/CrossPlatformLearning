package ejercicio15;

import util.Funciones;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alejandro on 30/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        ResultSet result;
        Funciones.abrirConexion();

        try {
            result = Funciones.select("SELECT Nombre, HorasSemanales, COUNT(*), COUNT(DISTINCT CodOe) FROM asignatura a, reparto r WHERE HorasSemanales >= 3 AND a.CodAsignatura = r.CodAsignatura GROUP BY a.CodAsignatura;");
            while (result.next())
                System.out.printf("[Nombre: %s] [Horas semanales: %d] [Número de cursos donde se imparte: %d] [Número de ofertas educativas donde se imparte: %d]%n", result.getString(1), result.getInt(2), result.getInt(3), result.getInt(4));
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Funciones.cerrarConexion();
    }
}
