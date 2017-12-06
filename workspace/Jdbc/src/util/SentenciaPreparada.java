package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Alejandro on 07/12/2016.
 */
public class SentenciaPreparada {

    private PreparedStatement sentencia;
    private Connection conexion;

    public SentenciaPreparada(String insert) {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //Carga el driver
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario", "root", "root"); //Conexión a la base de datos
            sentencia = conexion.prepareCall(insert);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setSentencia(String insert) {
        try {
            sentencia = conexion.prepareCall(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertPreparado(Object... args) {

        try {
            sentencia.getParameterMetaData();
            for (int i = 0; i < args.length; i++) {
                if (args[i] != null) {
                    if (args[i] instanceof String)
                        sentencia.setString(i + 1, (String) args[i]);
                    else if (args[i] instanceof Byte)
                        sentencia.setByte(i + 1, (Byte) args[i]);
                    else if (args[i] instanceof Short)
                        sentencia.setInt(i + 1, (Short) args[i]);
                    else if (args[i] instanceof Integer)
                        sentencia.setInt(i + 1, (Integer) args[i]);
                    else if (args[i] instanceof Long)
                        sentencia.setLong(i + 1, (Long) args[i]);
                    else if (args[i] instanceof Float)
                        sentencia.setFloat(i + 1, (Float) args[i]);
                    else if (args[i] instanceof Double)
                        sentencia.setDouble(i + 1, (Double) args[i]);
                }
            }

            sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void cerrarConexion() {
        try {
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
