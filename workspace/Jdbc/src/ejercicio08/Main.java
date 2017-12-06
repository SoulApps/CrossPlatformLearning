package ejercicio08;

import util.Funciones;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by Alejandro on 05/12/2016.
 */
public class Main {
    public static void main(String[] args) {
        final String SELECT = "SELECT * FROM profesor LEFT JOIN curso ON CodProf = Tutor;";
        ResultSet result;
        ResultSetMetaData meta;
        Funciones.abrirConexion();

        try {
            result = Funciones.select(SELECT);
            meta = result.getMetaData();

            for (int i = 1; i < meta.getColumnCount(); i++)
                System.out.printf("[Nombre: %s] [Tipo de dato: %s] [¿Admite nulos?: %s] [Máximo ancho de caracteres: %s]%n", meta.getColumnName(i), meta.getColumnTypeName(i), meta.isNullable(i) == 1 ? "Sí" : "No", meta.getColumnDisplaySize(i));

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Funciones.cerrarConexion();
    }
}
