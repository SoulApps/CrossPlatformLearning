package ejercicio09;

import util.Funciones;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Alejandro on 24/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        ResultSet result;
        Funciones.abrirConexion();
        try {
            result = Funciones.select("SELECT o.Nombre, CodCurso, p.Nombre FROM ofertaeducativa o, curso c, profesor p WHERE CodProf = Tutor AND o.CodOe = c.CodOe;");
            while (result.next())
                System.out.printf("[CodOe: %s] [CodCurso: %s] [Tutor: %s]%n", result.getString(1), result.getString(2), result.getString(3));
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Funciones.cerrarConexion();
    }
}
