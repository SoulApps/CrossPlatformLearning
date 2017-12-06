package ejercicio03;

import util.Funciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Alejandro on 29/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        PreparedStatement sentencia;
        Connection conexion = Funciones.abrirConexion();

        try {
            //Creo el curso.
            sentencia = conexion.prepareStatement("INSERT INTO curso VALUES(?, ?, ?)");
            sentencia.setString(1, "FPB");
            sentencia.setString(2, "1A");
            sentencia.setString(3, "PBG");
            sentencia.executeUpdate();

            //Creo las asignaturas.
            sentencia = conexion.prepareStatement("INSERT INTO asignatura VALUES(?, ?, ?, ?)");

            sentencia.setString(1, "@AAA");
            sentencia.setString(2, "Operaciones auxiliares para la configuración y la explotación");
            sentencia.setByte(3, (byte) 7);
            sentencia.setShort(4, (short) 245);
            sentencia.executeUpdate();

            sentencia.setString(1, "@AAB");
            sentencia.setString(2, "Montaje y mantenimiento de sistemas y componentes informáticos");
            sentencia.setByte(3, (byte) 9);
            sentencia.setShort(4, (short) 315);
            sentencia.executeUpdate();

            //Asigno las asignaturas.
            sentencia = conexion.prepareStatement("INSERT INTO reparto VALUES(?, ?, ?, ?)");

            sentencia.setString(1, "FPB");
            sentencia.setString(2, "1A");

            //1
            sentencia.setString(3, "@AAA");
            sentencia.setString(4, "JMG");
            sentencia.executeUpdate();

            //2
            sentencia.setString(3, "@AAB");
            sentencia.setString(4, "MPG");
            sentencia.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Funciones.cerrarConexion();
    }
}
