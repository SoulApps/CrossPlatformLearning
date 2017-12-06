/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mihorario;

import util.Funciones;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;


/**
 *
 * @author Alejandro
 */
public class FXMLHorarioController {

    @FXML
    private Label lblProfesor;  
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab tabLunes, tabMartes, tabMiercoles, tabJueves, tabViernes;
    @FXML
    private ListView<String> lstLunes, lstMartes, lstMiercoles, lstJueves, lstViernes;

    private String profesor;
    private final String[] horas = new String[6];

    public void setProfesor(String profesor) {
        this.profesor = profesor;
        cargarDatos();
    }

    private void cargarDatos() {
        final String SQL_DIA = "SELECT t.HoraInicio, t.HoraFin, h.CodAsignatura, h.CodOe, h.CodCurso "
                + "FROM horario h INNER JOIN tramohorario t ON h.CodTramo = t.CodTramo INNER JOIN reparto r ON r.CodAsignatura = h.CodAsignatura "
                + "WHERE CodProf = '%s' AND Dia = '%s' "
                + "ORDER BY t.Dia, t.HoraInicio;";
        ResultSet result;

        try {
            Funciones.abrirConexion();

            cargarProfesor();
            buscarHoras();

            //Lunes
            result = Funciones.select(String.format(SQL_DIA, profesor, "LUNES"));
            cargarDia(result, lstLunes);

            //Martes
            result = Funciones.select(String.format(SQL_DIA, profesor, "MARTES"));
            cargarDia(result, lstMartes);

            //Miércoles
            result = Funciones.select(String.format(SQL_DIA, profesor, "MIERCOLES"));
            cargarDia(result, lstMiercoles);

            //Jueves
            result = Funciones.select(String.format(SQL_DIA, profesor, "JUEVES"));
            cargarDia(result, lstJueves);

            //Viernes
            result = Funciones.select(String.format(SQL_DIA, profesor, "VIERNES"));
            cargarDia(result, lstViernes);

            result.close();

        } catch (SQLException ex) {
            Logger.getLogger(FXMLHorarioController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Funciones.cerrarConexion();
        }
    }

    private void cargarDia(ResultSet result, ListView<String> dia) throws SQLException {
        boolean seguir = result.next();
        for (String hora : horas) {
            if (seguir) {
                if (String.format("%s-%s", result.getString(1), result.getString(2)).equals(hora)) {
                    dia.getItems().add(String.format("%s-%s %s %s %s", result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)));
                    seguir = result.next();
                } else {
                    dia.getItems().add(hora);
                }
            } else {
                dia.getItems().add(hora);
            }
        }
    }

    private void buscarHoras() {
        final String SELECT_HORAS = "SELECT DISTINCT HoraInicio, HoraFin FROM tramohorario ORDER BY Dia, 1, 2;";
        int i = 0;
        ResultSet result;
        try {
            result = Funciones.select(SELECT_HORAS);
            while (result.next()) {
                horas[i++] = String.format("%s-%s", result.getString(1), result.getString(2));
            }
            result.close();
        } catch (SQLException ex) {
        }
    }

    private void cargarProfesor() {
        final String SQL_PROFESOR = String.format("SELECT Nombre, Apellidos FROM Profesor WHERE CodProf = '%s';", profesor);

        ResultSet result;
        try {
            result = Funciones.select(SQL_PROFESOR);
            while (result.next()) {
                lblProfesor.setText(String.format("%s %s", result.getString(1), result.getString(2)));
            }
            result.close();
        } catch (SQLException ex) {
        }
    }
}
