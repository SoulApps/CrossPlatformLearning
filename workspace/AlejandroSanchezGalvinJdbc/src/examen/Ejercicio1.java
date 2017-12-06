package examen;

import java.sql.*;

/**
 * Created by Alejandro on 15/12/2016.
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        final String SELECT  = "SELECT p.Nombre, Apellidos, o.Nombre, c.CodOe, c.CodCurso, (SELECT COUNT(CodProf) FROM reparto WHERE CodProf = p.CodProf GROUP BY CodProf) FROM profesor p LEFT JOIN Curso c ON CodProf = Tutor LEFT JOIN OfertaEducativa o ON c.CodOe = o.CodOe;";
        String aux;
        Connection conexion;
        Statement sentencia;
        ResultSet resultSet;

        try {
            Class.forName("com.mysql.jdbc.Driver"); //Carga el driver.
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario", "root", "root"); //Conexión a la base de datos.
            sentencia = conexion.createStatement();
            resultSet = sentencia.executeQuery(SELECT);

            //Muestro los datos.
            while (resultSet.next())
                System.out.printf("[Nombre: %s] [Apellidos: %s] [Oferta educativa: %s] [Curso: %s] [Asignaturas: %s]%n", resultSet.getString(1), resultSet.getString(2), (aux = resultSet.getString(3)) == null?"No es tutor":aux, (aux = resultSet.getString(4)) == null?"No es tutor":String.format("%s %s", aux, resultSet.getString(5)), resultSet.getInt(6));

            //Cierro.
            resultSet.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
