/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicafinal;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import util.Funciones;

/**
 *
 * @author Alejandro
 */
public class Inspeccion implements Initializable {

    private final SimpleDateFormat FORMATO_VISITA = new SimpleDateFormat("dd/MM/yyyy");
    private final SimpleDateFormat FORMATO_SELECT = new SimpleDateFormat("yyyy-MM-dd");
    private final SimpleDateFormat FORMATO_SEMANAS = new SimpleDateFormat("dd/MM");
    private final Calendar C = Calendar.getInstance();
    private final String[] SEMANAS = new String[4];
    private String SEMANA_ACTUAL;

    @FXML
    private ComboBox cbInspector;
    @FXML
    private Label lblInfo;
    @FXML
    private TabPane tabsSemanas;
    @FXML
    private Tab tab1, tab2, tab3, tab4;
    @FXML
    private TableView table1, table2, table3, table4;
    @FXML
    private TableColumn<ElementoLista, String> colFecha1, colFecha2, colFecha3, colFecha4, colInstituto1, colInstituto2, colInstituto3, colInstituto4;
    @FXML
    private WebView webMotivo, webResolucion;
    
    private int id;
    private char tipo;

    //Recoge el id y el tipo de usuario que se logea.
    public void setParams(int id, char tipo) {
        this.id = id;
        this.tipo = tipo;
        cargarInspectores();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int esteLunes;
        
        //Oculta los header de las columnas del TableView.
        ocultarHeadersColumnas(table1);
        ocultarHeadersColumnas(table2);
        ocultarHeadersColumnas(table3);
        ocultarHeadersColumnas(table4);

        //Enlaza las columnas del tableview.
        colFecha1.setCellValueFactory(new PropertyValueFactory<>("param1"));
        colInstituto1.setCellValueFactory(new PropertyValueFactory<>("param2"));
        colFecha2.setCellValueFactory(new PropertyValueFactory<>("param1"));
        colInstituto2.setCellValueFactory(new PropertyValueFactory<>("param2"));
        colFecha3.setCellValueFactory(new PropertyValueFactory<>("param1"));
        colInstituto3.setCellValueFactory(new PropertyValueFactory<>("param2"));
        colFecha4.setCellValueFactory(new PropertyValueFactory<>("param1"));
        colInstituto4.setCellValueFactory(new PropertyValueFactory<>("param2"));

        //Prepara los nombres de las tabs.        
        Date date = new Date();
        C.setTime(date);
        esteLunes = C.get(Calendar.DAY_OF_WEEK) - C.getFirstDayOfWeek(); //Me pongo en último lunes.
        C.add(Calendar.DATE, -esteLunes + 7); //Siguiente lunes.
        
        //Guardo la semana siguiente para usarla en las selects.
        SEMANA_ACTUAL = (FORMATO_SELECT.format(C.getTime()));

        cargarTabs(esteLunes, C.getTime(), 0); //Calculo las fechas para las tabs.

        //Asigno los nombre de las tabs.
        tab1.setText(SEMANAS[0]);
        tab2.setText(SEMANAS[1]);
        tab3.setText(SEMANAS[2]);
        tab4.setText(SEMANAS[3]);
    }

    //Se cambia a la pantalla de centros.
    @FXML
    private void gotoCentros(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("Centros.fxml").openStream());
            Centros controlador = (Centros) loader.getController();
            controlador.setParams(id, tipo);

            Scene scene = new Scene(root);
            scene.getStylesheets().add("practicafinal/Estilos.css");
            stage.setTitle("Centros");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Carga los tableviews del tabview cuando se selecciona un inspector en el combobox.
    @FXML
    private void handleCbInspectorOnAction(ActionEvent event) {
        final String SELECT = "SELECT v.fecha, c.nombre FROM \"VISITA\" v INNER JOIN \"CENTRO\" c ON v.id_centro = c.id WHERE id_inspector = (SELECT id FROM \"USUARIO\" WHERE nombre = '%s') AND fecha BETWEEN DATE '%s' - INTEGER '%d' - INTERVAL '1 WEEK' AND DATE '%s' - INTEGER '%d';";
        
        ElementoLista e;
        //Limpio los tableview.
        table1.getItems().clear();
        table2.getItems().clear();
        table3.getItems().clear();
        table4.getItems().clear();
        
        if (cbInspector.getValue() != null) {
            Funciones.abrirConexion();
            //Según el número buscará en diferentes semanas. También se decidirá en que tableview de qué tab escribir.
            for (int i = 0; i < 4; i++) {
                try (ResultSet result = Funciones.select(String.format(SELECT, cbInspector.getValue(), SEMANA_ACTUAL, i * 7, SEMANA_ACTUAL, i * 7 + 1))) {
                    while (result.next()) {
                        e = new ElementoLista(FORMATO_VISITA.format(FORMATO_SELECT.parse(result.getString(1))), result.getString(2).trim());
                        switch (i) {
                            case 0:
                                table1.getItems().add(e);
                                break;
                            case 1:
                                table2.getItems().add(e);
                                break;
                            case 2:
                                table3.getItems().add(e);
                                break;
                            case 3:
                                table4.getItems().add(e);
                                break;
                        }
                    }
                } catch (SQLException | ParseException ex) {
                    Logger.getLogger(Inspeccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            Funciones.cerrarConexion();
        }
    }
    
    //Cambia los datos del panel de la derecha(info) cuando se selecciona un elemento de un tableview.
    @FXML
    private void handleElementClicked(MouseEvent event) {        
        TableView tableView = (TableView) event.getSource(); //Detecto el tableview que se ha seleccionado
        ElementoLista e = (ElementoLista) tableView.getSelectionModel().getSelectedItem(); //Detecto el elemento que se ha seleccionado.
        if (e != null) {
            tableView.getSelectionModel().clearSelection(); //Deselecciono el elemento seleccionado.
            lblInfo.setText(String.format("%s %s", e.getParam1(), e.getParam2()));
            //Busco los datos de la visita correspondiente.
            Funciones.abrirConexion();
            try(ResultSet result = Funciones.select(String.format("SELECT motivo, resolucion FROM \"VISITA\" WHERE fecha = '%s' AND id_centro = (SELECT id FROM \"CENTRO\" WHERE nombre = '%s') AND id_inspector = (SELECT id FROM \"USUARIO\" WHERE nombre = '%s');", e.getParam1(), e.getParam2(), cbInspector.getValue()))) {
                if (result.next()) {
                    //Cargo los WebView.
                    webMotivo.getEngine().loadContent(result.getString(1));
                    webResolucion.getEngine().loadContent(result.getString(2));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Inspeccion.class.getName()).log(Level.SEVERE, null, ex);
            }
            Funciones.cerrarConexion();
        }
    }

    //Oculta los headers del tableview que se pasa por parámetros.
    private void ocultarHeadersColumnas(TableView table) {
        table.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> source, Number oldWidth, Number newWidth) {
                Pane header = (Pane) table.lookup("TableHeaderRow");
                if (header.isVisible()) {
                    header.setMaxHeight(0);
                    header.setMinHeight(0);
                    header.setPrefHeight(0);
                    header.setVisible(false);
                }
            }
        });
    }

    //Carga los inspectores en el combobox.
    private void cargarInspectores() {
        final String SELECT = "SELECT nombre FROM \"USUARIO\" WHERE tipo = 'I'";
        Funciones.abrirConexion();
        try (ResultSet result = Funciones.select(SELECT)) {
            while (result.next()) {
                cbInspector.getItems().add(result.getString(1).trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inspeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        Funciones.cerrarConexion();
    }

    //Método recursivo que se ejecutará 4 veces y añadirá a un array las últimas 4 semanas.
    private void cargarTabs(int i, Date fecha, int turno) {
        if (turno < 4) { //Últimas 4 semanas.
            C.setTime(fecha); //Cojo la última fecha.
            C.add(Calendar.DATE, -7); //Resto una semana.
            Date resultado = C.getTime(); //Obtengo el objeto Date.
            SEMANAS[turno] = FORMATO_SEMANAS.format(C.getTime()); //Guardo en el array.
            cargarTabs(i, resultado, turno + 1); //Vuelvo a llamar al método con la última fecha calculada.
        }
    }
        
}
