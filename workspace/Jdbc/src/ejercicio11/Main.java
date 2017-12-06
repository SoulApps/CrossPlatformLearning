package ejercicio11;

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
        String profesor = Teclado.next("¿Qué profesor quieres buscar?");
        Funciones.abrirConexion();
        try {
            result = Funciones.select(String.format("SELECT CodAsignatura FROM reparto WHERE CodProf = '%s';", profesor));
            while (result.next())
                System.out.printf("[CodAsignatura: %s]%n", result.getString(1));
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Funciones.cerrarConexion();
    }
}
