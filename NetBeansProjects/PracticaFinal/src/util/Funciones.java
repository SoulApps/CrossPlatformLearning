package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

/**
 * Created by Alejandro on 23/11/2016.
 */
public class Funciones {

    public static boolean CONEXION_LOCAL = false;
    private static final String URL_LOCAL = "jdbc:postgresql://localhost:5432/Inspeccion", USUARIO_LOCAL = "root", PASS_LOCAL = "root";
    private static final String URL_INTERNET = "jdbc:postgresql://horton.elephantsql.com:5432/trojejgc", USUARIO_INTERNET = "trojejgc", PASS_INTERNET = "jLPcSW9-xRYYU29jAOqp62QUhafZWteD";
    
    
    private static Connection conexion;
    private static Statement sentencia;
    
    public static Connection abrirConexion() {
        String url = CONEXION_LOCAL?URL_LOCAL:URL_INTERNET;
        String usuario = CONEXION_LOCAL?USUARIO_LOCAL:USUARIO_INTERNET;
        String pass = CONEXION_LOCAL?PASS_LOCAL:PASS_INTERNET;
        try {
            Class.forName("org.postgresql.Driver"); //Carga el driver
            conexion = DriverManager.getConnection(url, usuario, pass); //Conexión a la base de datos
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("bam");
        }

        return conexion;
    }

    public static boolean comprobarTabla(String tabla) {
        boolean existe = false;
        String[] tipos = {"TABLE"};
        DatabaseMetaData dbmd;
        ResultSet result;

        try {
            dbmd = conexion.getMetaData();
            result = dbmd.getTables(null, "horario", null, tipos);
            while (result.next()) {
                if (result.getString("TABLE_NAME").equals(tabla)) {
                    existe = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return existe;
    }

    public static void mostrarInformacionTabla(String tabla) {
        DatabaseMetaData dbmd;
        ResultSet result;
        try {
            dbmd = conexion.getMetaData();
            if (comprobarTabla(tabla)) {
                //Información de la tabla
                System.out.println("DATOS DE LA TABLA");
                result = dbmd.getColumns(null, "horario", tabla, null);
                while (result.next()) {
                    System.out.printf("[Columna: %s] [Tipo: %s] [Tamaño: %s] [Null: %s]%n", result.getString("COLUMN_NAME"), result.getString("TYPE_NAME"), result.getString("COLUMN_SIZE"), result.getString("IS_NULLABLE"));
                }

                System.out.println();

                //Claves primarias
                System.out.println("CLAVES PRIMARIAS");
                result = dbmd.getPrimaryKeys(null, "horario", tabla);
                while (result.next()) {
                    System.out.printf("Clave primaria: %s%n", result.getString("COLUMN_NAME"));
                }

                //Claves ajenas exportadas
                System.out.println("\n CLAVES EXPORTADAS");
                result = dbmd.getExportedKeys(null, "horario", tabla);
                while (result.next()) {
                    System.out.printf("[Clave exportada: %s] [Clave primaria: %s] [Tabla origen:%s] [Tabla destino: %s]%n", result.getString("FKCOLUMN_NAME"), result.getString("PKCOLUMN_NAME"), result.getString("PKTABLE_NAME"), result.getString("FKTABLE_NAME"));
                }

                //Claves ajenas importadas
                System.out.println("\n CLAVES IMPORTADAS");
                result = dbmd.getImportedKeys(null, "horario", tabla);
                while (result.next()) {
                    System.out.printf("[Clave exportada: %s] [Clave primaria: %s] [Tabla origen:%s] [Tabla destino: %s]%n", result.getString("FKCOLUMN_NAME"), result.getString("PKCOLUMN_NAME"), result.getString("PKTABLE_NAME"), result.getString("FKTABLE_NAME"));
                }
            } else {
                System.out.println("No existe esa tabla");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int insert(String insert) {
        int filasAfectadas = 0;

        try {
            sentencia = conexion.createStatement();
            filasAfectadas = sentencia.executeUpdate(insert);
        } catch (SQLException e) {
            System.out.println("ERROR. PUEDE QUE LA CLAVE PRIMARIA ESTÉ REPETIDA");
        }

        return filasAfectadas;
    }

    public static ResultSet select(String select) throws SQLException {
        sentencia = conexion.createStatement();
        return sentencia.executeQuery(select);
    }

    public static String getScriptCreacion() {
        String linea, salto = System.getProperty("line.separator");
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("2016-2017 script_horario.sql"));

            while ((linea = reader.readLine()) != null) {
                stringBuilder.append(linea);
                stringBuilder.append(salto);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    public static void cerrarConexion() {
        try {
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
