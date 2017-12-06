package ejercicio17;

import teclado.Teclado;
import util.Funciones;

import java.sql.*;

/**
 * Created by Alejandro on 05/02/2017.
 */
public class Main {
    public static void main(String[] args) {
        String sql = "{CALL mostrarAsignatura(?, ?, ?)}";
        ResultSet result;
        CallableStatement llamada;
        Connection conexion = Funciones.abrirConexion();
        String oe = Teclado.next("¿En qué oferta educativa quieres buscar?"), curso = Teclado.next("¿De qué curso?"), asignatura = Teclado.next("¿Qué asignatura?");

        try {
            llamada = conexion.prepareCall(sql);
            llamada.setString(1, oe);
            llamada.setString(2, curso);
            llamada.setString(3, asignatura);

            result = llamada.executeQuery();

            if (result.next()) {
                System.out.println(result.getString(1));
                System.out.println(result.getString(2));
            }
            else
                System.out.println("No existe");

            llamada.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Teclado.close();
        Funciones.cerrarConexion();
    }
}
