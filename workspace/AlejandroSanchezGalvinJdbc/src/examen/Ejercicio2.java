package examen;

import java.sql.*;

/**
 * Created by Alejandro on 15/12/2016.
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        final String SELECT = "SELECT a.CodAsignatura, Nombre, HorasSemanales, CodOe, CodCurso, h.CodTramo FROM asignatura a, horario h, tramohorario t WHERE a.CodAsignatura = h.CodAsignatura AND h.CodTramo = t.CodTramo ORDER BY 1, 4, 5, Dia, 6;";
        String asignaturaAnterior = "", asignaturaActual,  cursoAnterior = "", cursoActual;

        Connection conexion;
        Statement sentencia;
        ResultSet resultSet;

        //Cabecera
        System.out.println("***************************************************************************************************************************\n" +
                "\t\t\t\t\t\t\t\t\t\t\tASIGNATURAS DEL IES SALADILLO\n" +
                "***************************************************************************************************************************");


        try {
            Class.forName("com.mysql.jdbc.Driver"); //Carga el driver.
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario", "root", "root"); //Conexión a la base de datos.
            sentencia = conexion.createStatement();
            resultSet = sentencia.executeQuery(SELECT);

            while (resultSet.next()) {
                //Compruebo primero que estoy en la misma asignatura para mostrar o no los datos de la asignatura.
                asignaturaActual = resultSet.getString(1); //Guardo la asignatura que estoy leyendo para utilizarla más tarde.
                if (!asignaturaActual.equals(asignaturaAnterior))
                    System.out.printf("%nCódigo: %s Nombre: %s Horas semanales: %d", asignaturaActual, resultSet.getString(2), resultSet.getInt(3));

                cursoActual = String.format("%s %s", resultSet.getString(4), resultSet.getString(5)); //Código completo del curso.

                //Compruebo que no estoy en el mismo curso y tampoco en la misma asignatura para poner los datos del curso y no poner comas.
                if (!asignaturaActual.equals(asignaturaAnterior) || !cursoActual.equals(cursoAnterior))
                    System.out.printf("\n\tCódigo curso: %s Tramos horarios: ", cursoActual);
                else
                    System.out.print(",");

                System.out.print(resultSet.getString(6)); //Tramo horario.

                //Cambio el curso y la asignatura anterior por el actual.
                cursoAnterior = cursoActual;
                asignaturaAnterior = asignaturaActual;
            }

            //Cierro.
            resultSet.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
