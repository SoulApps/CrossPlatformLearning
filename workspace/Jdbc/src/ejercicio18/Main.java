package ejercicio18;

import util.Funciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Alejandro on 05/12/2016.
 */
public class Main {
    public static void main(String[] args) {
        Connection conexion;
        Statement sentencia;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //Carga el driver
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?allowMultiQueries=true", "root", "root"); //Conexión a la base de datos
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(Funciones.getScriptCreacion());

            sentencia.close();
            conexion.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("bam");
        }
    }
}
