import teclado.Teclado;
import util.Funciones;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Alejandro on 16/12/2016.
 */
public class HorarioProfesor {
    public static void main(String[] args) {
        final String SELECT = "SELECT r.CodAsignatura, r.CodCurso, r.CodOe, h.CodTramo FROM horario h, reparto r, tramohorario t\n" +
                "WHERE CodProf = '%s' AND h.CodCurso = r.CodCurso AND h.CodOe = r.CodOe AND h.CodAsignatura = r.CodAsignatura AND h.CodTramo = t.CodTramo\n" +
                "ORDER BY SUBSTRING(h.CodTramo, 2), Dia;";

        final String DIA = "SELECT DISTINCT dia FROM tramohorario ORDER BY dia;", HORA = "SELECT DISTINCT HoraInicio, HoraFin FROM tramohorario ORDER BY Dia, 1, 2;";

        int i, j, k = 0;
        char h, d;
        String profesor;
        String[] dias = new String[5], horas = new String[6];
        ArrayList<String> horario = new ArrayList<>();

        ResultSet result, dia, hora;

        profesor = Teclado.next("¿El horario de qué profesor quieres buscar?");
        Funciones.abrirConexion();
        try {
            dia = Funciones.select(DIA);
            hora = Funciones.select(HORA);
            result = Funciones.select(String.format(SELECT, profesor));

            while (result.next())
                horario.add(String.format("%s [%s %s]%s", result.getString(1), result.getString(2), result.getString(3), result.getString(4)));

            if (horario.size() != 0) {
                i = 0;
                while (dia.next())
                    dias[i++] = dia.getString(1);

                i = 0;
                while (hora.next()) {
                    horas[i++] = String.format("%s %s", hora.getString(1), hora.getString(2));
                }


                for (i = 0; i < dias.length; i++) {
                    if (i == 0) {
                        for (j = 0; j < horas[0].length(); j++)
                            System.out.print("  ");
                        System.out.printf("%-30s", dias[i]);
                    } else
                        System.out.printf("%-30s", dias[i]);
                }

                System.out.println();

                for (j = 0; j < 6; j++) {
                    System.out.printf("%-30s ", horas[j]);
                    for (i = 0; i < 5; i++) {
                        if (k < horario.size()) {
                            h = horario.get(k).split("]")[1].charAt(1);
                            if (Integer.parseInt(String.valueOf(h)) == j + 1) {
                                d = horario.get(k).split("]")[1].charAt(0);
                                if (d == 'L' && i == 0)
                                    System.out.printf("%-30s ", horario.get(k++));
                                else if (d == 'M' && i == 1)
                                    System.out.printf("%-30s ", horario.get(k++));
                                else if (d == 'X' && i == 2)
                                    System.out.printf("%-30s ", horario.get(k++));
                                else if (d == 'J' && i == 3)
                                    System.out.printf("%-30s ", horario.get(k++));
                                else if (d == 'V' && i == 4)
                                    System.out.printf("%-30s ", horario.get(k++));
                                else
                                    System.out.printf("%-30s", "");
                            }
                        }
                    }
                    System.out.println();
                }
            } else
                System.out.println("No existe ese profesor");

            //Cierro.
            dia.close();
            hora.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Funciones.cerrarConexion();
    }
}
