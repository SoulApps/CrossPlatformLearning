package ejercicio16;

import teclado.Teclado;
import util.Funciones;

import java.sql.*;

/**
 * Created by Alejandro on 29/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        String sql = "{? = CALL mostrarTutor(?, ?)}";
        ResultSet result;
        CallableStatement llamada;
        Connection conexion = Funciones.abrirConexion();
        String oe = Teclado.next("¿En qué oferta educativa quieres buscar?"), curso = Teclado.next("¿De qué curso?");

        try {
            llamada = conexion.prepareCall(sql);
            llamada.registerOutParameter(1, Types.VARCHAR);
            llamada.setString(2, oe);
            llamada.setString(3, curso);

            result = llamada.executeQuery();

            if (result.next())
                System.out.println(result.getString(1));
            else
                System.out.println("No existe");

            llamada.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Funciones.cerrarConexion();
    }
}
