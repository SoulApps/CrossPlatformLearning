package ejercicio14;

import teclado.Teclado;
import util.Funciones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Alejandro on 29/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        SimpleDateFormat formato = new SimpleDateFormat("EEEE");
        Date ahora = new Date();
        ResultSet result;
        String codProf = Teclado.next("¿Qué profesor quieres buscar?"), dia;
        Funciones.abrirConexion();

        dia = formato.format(ahora); //Saco el día
        dia = dia.replace('é', 'e'); //Quito la tilde si es miércoles porque en la base de datos no existe. El sábado no porque no hace falta.

        try {
            result = Funciones.select(String.format("SELECT r.CodOe, r.CodCurso FROM tramohorario t, horario h, reparto r WHERE t.CodTramo = h.CodTramo AND h.CodAsignatura = r.CodAsignatura AND CodProf = '%s' AND HoraInicio <= NOW() AND HoraFin >= NOW() AND Dia = '%s';", codProf, dia));
            if (result.next()) {
                System.out.println(result.getString(1));
                System.out.println(result.getString(2));
            }
            else
                System.out.printf("%s está en su casa", codProf);

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Funciones.cerrarConexion();
    }
}
