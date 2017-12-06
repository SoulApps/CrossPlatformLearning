/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jefaturadeestudios;

import clases.Horario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import util.Funciones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Alejandro
 */
public class FXMLDocumentController implements Initializable {

    private final ArrayList<String> horario = new ArrayList<>();
    private final String[] horas = new String[6];

    @FXML
    private ComboBox<String> cbProfesor;
    @FXML
    private ListView<String> hoy;
    @FXML
    private TableView<Horario> semana;
    @FXML
    private ToggleGroup tipo;
    @FXML
    private RadioButton rbDiario, rbSemanal;
    @FXML
    private TableColumn<Horario, String> colHoras, colLunes, colMartes, colMiercoles, colJueves, colViernes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Id de los radiobuttons
        rbDiario.setUserData("Diario");
        rbSemanal.setUserData("Semanal");

        colHoras.setCellValueFactory(new PropertyValueFactory<>("horaTramo"));
        colLunes.setCellValueFactory(new PropertyValueFactory<>("horaLunes"));
        colMartes.setCellValueFactory(new PropertyValueFactory<>("HoraMartes"));
        colMiercoles.setCellValueFactory(new PropertyValueFactory<>("horaMiercoles"));
        colJueves.setCellValueFactory(new PropertyValueFactory<>("horaJueves"));
        colViernes.setCellValueFactory(new PropertyValueFactory<>("horaViernes"));

        Funciones.abrirConexion();
        buscarProfesores();
        buscarHoras();
        Funciones.cerrarConexion();

        cbProfesor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                buscarHorario();
            }

        });

        tipo.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                buscarHorario();
            }

        });
    }

    private void buscarProfesores() {
        final String SELECT_PROFESORES = "SELECT CodProf FROM profesor;";
        ResultSet result;

        try {
            result = Funciones.select(SELECT_PROFESORES);
            while (result.next()) {
                cbProfesor.getItems().add(result.getString(1));
            }
            result.close();
        } catch (SQLException e) {
        }
    }

    private void buscarHoy() {
        final String SELECT_HOY = "SELECT t.HoraInicio, t.HoraFin, h.CodAsignatura, h.CodOe, h.CodCurso "
                + "FROM horario h INNER JOIN tramohorario t ON h.CodTramo = t.CodTramo INNER JOIN reparto r ON r.CodAsignatura = h.CodAsignatura "
                + "WHERE CodProf = '%s' AND Dia = '%s' "
                + "ORDER BY t.Dia, t.HoraInicio;";

        final SimpleDateFormat FORMATO = new SimpleDateFormat("EEEE");
        boolean seguir;
        ResultSet result;

        hoy.getItems().clear();
        hoy.setVisible(true);
        semana.setVisible(false);

        Funciones.abrirConexion();
        try {
            result = Funciones.select(String.format(SELECT_HOY, cbProfesor.getValue(), FORMATO.format(new Date())));
            seguir = result.next();
            for (String hora : horas) {
                if (seguir) {
                    if (String.format("%s-%s", result.getString(1), result.getString(2)).equals(hora)) {
                        hoy.getItems().add(String.format("%s-%s %s %s %s", result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)));
                        seguir = result.next();
                        System.out.println(seguir);
                    } else {
                        hoy.getItems().add(hora);
                    }
                } else {
                    hoy.getItems().add(hora);
                }
            }
            result.close();
        } catch (SQLException e) {
        } finally {
            Funciones.cerrarConexion();
        }
    }

    private void buscarSemana() {
        final String SELECT_SEMANA = "SELECT r.CodAsignatura, r.CodCurso, r.CodOe, h.CodTramo FROM horario h, reparto r, tramohorario t\n"
                + "WHERE CodProf = '%s' AND h.CodCurso = r.CodCurso AND h.CodOe = r.CodOe AND h.CodAsignatura = r.CodAsignatura AND h.CodTramo = t.CodTramo\n"
                + "ORDER BY SUBSTRING(h.CodTramo, 2), Dia;";
        ResultSet result;

        ObservableList<Horario> lista = FXCollections.observableArrayList();

        horario.clear();
        semana.setVisible(true);
        hoy.setVisible(false);

        Funciones.abrirConexion();
        try {
            result = Funciones.select(String.format(SELECT_SEMANA, cbProfesor.getValue()));
            while (result.next()) {
                horario.add(String.format("%s %s %s_%s", result.getString(1), result.getString(2), result.getString(3), result.getString(4)));
            }
            rellenarSemana(lista);
            semana.setItems(lista);
            result.close();
        } catch (SQLException e) {
        } finally {
            Funciones.cerrarConexion();
        }
    }

    private void rellenarSemana(ObservableList lista) {
        int i, j, k = 0;
        char h, d;
        String[] fila = new String[6];

        buscarHoras();

        //Coloca en fila[] las asignaturas de cada tramo horario, respetando las horas sin clase.
        for (j = 0; j < 6; j++) {
            fila[0] = horas[j]; //Aquí va la hora.
            for (i = 1; i < 6; i++) {
                if (k < horario.size()) {
                    h = horario.get(k).split("_")[1].charAt(1);
                    if (Integer.parseInt(String.valueOf(h)) == j + 1) {
                        d = horario.get(k).split("_")[1].charAt(0);
                        if (d == 'L' && i == 1) {
                            fila[i] = horario.get(k++).split("_")[0];
                        } else if (d == 'M' && i == 2) {
                            fila[i] = horario.get(k++).split("_")[0];
                        } else if (d == 'X' && i == 3) {
                            fila[i] = horario.get(k++).split("_")[0];
                        } else if (d == 'J' && i == 4) {
                            fila[i] = horario.get(k++).split("_")[0];
                        } else if (d == 'V' && i == 5) {
                            fila[i] = horario.get(k++).split("_")[0];
                        } else {
                            fila[i] = "";
                        }
                    }
                }
            }
            lista.add(new Horario(fila[0], fila[1], fila[2], fila[3], fila[4], fila[5])); //Añado la fila.
            Arrays.fill(fila, null); //Limpio el array.
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
        } catch (SQLException ex) {
        }
    }

    private void buscarHorario() {
        boolean diario;

        if (tipo.getSelectedToggle() != null) {
            diario = tipo.getSelectedToggle().getUserData().equals("Diario");
            if (diario) {
                buscarHoy();
            } else {
                buscarSemana();
            }
        }
    }
}
