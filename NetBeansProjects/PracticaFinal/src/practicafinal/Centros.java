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
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
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
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import util.Funciones;

/**
 *
 * @author Alejandro
 */
public class Centros implements Initializable {

    final DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @FXML
    private RadioButton rbMisCentros, rbTodosLosCentros, rbCentrosPendientes;
    @FXML
    private ComboBox cbLocalidad, cbCentro;
    @FXML
    private Button btnVisita, btnGuardar, btnCambiarVista;
    @FXML
    private Label lblInstituto, lblCiudad, lblOk;
    @FXML
    private TextField txtMotivo, txtResultado;
    @FXML
    private DatePicker dateFecha;
    @FXML
    private Pane paneVisita, paneVer;
    @FXML
    private ToggleGroup grpCentros;
    @FXML
    private WebView webOfertas, webNotas;
    @FXML
    private TableView<ElementoLista> tableEquipo;
    @FXML
    private TableColumn<ElementoLista, String> colPuesto, colNombre;

    private WebEngine webEngine;
    private boolean hayPendiente;

    private int id;
    private char tipo;

    private String centro, localidad;

    //Recoge el id y el tipo de usuario que se logea.
    public void setParams(int id, char tipo) {
        this.id = id;
        this.tipo = tipo;
        prepararModo(); //Cambio la visibilidad según el usuario.
        cargarLocalidades(); //Cargo las localidades en el combobox.       
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Oculta los header de las columnas del TableView.
        tableEquipo.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> source, Number oldWidth, Number newWidth) {
                Pane header = (Pane) tableEquipo.lookup("TableHeaderRow");
                if (header.isVisible()) {
                    header.setMaxHeight(0);
                    header.setMinHeight(0);
                    header.setPrefHeight(0);
                    header.setVisible(false);
                }
            }
        });

        //Enlazo las columnas del tableview.
        colPuesto.setCellValueFactory(new PropertyValueFactory<>("param1"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("param2"));

        //Listener de los radiobuttons.
        grpCentros.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                reset();
                cargarLocalidades();
            }
        });
    }

    //Se cambia a la pantalla de inspección(si es de consejería).
    @FXML
    private void gotoInspeccion(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("Inspeccion.fxml").openStream());
            Inspeccion controlador = (Inspeccion) loader.getController();
            controlador.setParams(id, tipo);

            Scene scene = new Scene(root);
            scene.getStylesheets().add("practicafinal/Estilos.css");
            stage.setTitle("Inspección");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Habilita el panel para guardar visitas y deshabilita este botón.
    @FXML
    private void visitaOnClick(ActionEvent event) {
        paneVisita.setDisable(false);
        btnVisita.setDisable(true);
    }

    //Guarda o actualiza(solo para centros pendientes ya guardados) los datos introducidos en el panel de visita.
    @FXML
    private void guardarOnClick(ActionEvent event) {
        final String SELECT_INSPECTOR = "INSERT INTO \"VISITA\" VALUES(%d, (SELECT id FROM \"CENTRO\" WHERE nombre = '%s' AND localidad = '%s'), '%s', '%s', '%s');";
        final String SELECT_CONSEJERO = "INSERT INTO \"VISITA\" VALUES((SELECT id_inspector FROM \"ASOCIA\" WHERE anho = %1$d AND id_centro = (SELECT id FROM \"CENTRO\" WHERE nombre = '%2$s' AND localidad = '%3$s')), (SELECT id FROM \"CENTRO\" WHERE nombre = '%2$s' AND localidad = '%3$s'), '%4$s', '%5$s', NULL);";

        final String UPDATE_INSPECTOR = "UPDATE \"VISITA\" SET motivo = '%s', resolucion = '%s', fecha = '%s' WHERE id_centro = (SELECT id FROM \"CENTRO\" WHERE nombre = '%s' AND localidad = '%s') AND fecha = '1900-01-01';";
        final String UPDATE_CONSEJERO = "UPDATE \"VISITA\" SET motivo = '%s' WHERE id_centro = (SELECT id FROM \"CENTRO\" WHERE nombre = '%s' AND localidad = '%s');";

        boolean ok = true;
        String mensaje = "";
        Timer timer = new Timer();

        //Compruebo que todos los campos necesarios están introducidos según el usuario..
        if (tipo == 'I') {
            if (txtMotivo.getText().equals("") || txtResultado.getText().equals("") || dateFecha.getValue() == null) {
                ok = false;
                mensaje = "Debes introducir un motivo, una fecha y un resultado para poder guardar.";
            }
        } else if (tipo == 'C') {
            if (txtMotivo.getText().equals("")) {
                ok = false;
                mensaje = "Debes introducir un motivo para poder guardar.";
            }
        }
        if (ok) {
            //Actualizo o inserto.
            Funciones.abrirConexion();
            if (!hayPendiente) { //Si no es un centro pendiente.
                if (tipo == 'I') {
                    Funciones.insert(String.format(SELECT_INSPECTOR, id, centro, localidad, formato.format(dateFecha.getValue()), txtMotivo.getText(), txtResultado.getText()));
                } else {
                    Funciones.insert(String.format(SELECT_CONSEJERO, calcularAnhoAcademico(), centro, localidad, "1900-01-01", txtMotivo.getText()));
                    hayPendiente = true;
                }
            } else {
                if (tipo == 'I') {
                    Funciones.insert(String.format(UPDATE_INSPECTOR, txtMotivo.getText(), txtResultado.getText(), formato.format(dateFecha.getValue()), cbCentro.getValue(), cbLocalidad.getValue()));
                    hayPendiente = false;
                } else {
                    Funciones.insert(String.format(UPDATE_CONSEJERO, txtMotivo.getText(), centro, localidad));
                }
            }
            Funciones.cerrarConexion();
            
            //Muestro el mensaje de que todo ha ido bien que se oculta a los 3 segundos.
            lblOk.setVisible(true);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    lblOk.setVisible(false);
                    timer.cancel(); //Paro el timer.
                }
            }, 3000);

            //Si no es un centro pendiente, resteo y selecciono el radiobutton de mis centros.
            if (!hayPendiente) {
                rbCentrosPendientes.setSelected(false);
                rbMisCentros.setSelected(true);
                reset();
            }
        } else {
            //Muestra el diálogo cuando no se meten todos los datos necesarios.
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se ha podido guardar la visita.");
            alert.setContentText(mensaje);
            alert.showAndWait();
        }
    }

    //Carga los datos del centro seleccionado.
    @FXML
    private void handleOnCentroAction(ActionEvent event) {
        final String SELECT = "SELECT motivo FROM \"VISITA\" WHERE id_centro = (SELECT id FROM \"CENTRO\" WHERE nombre = '%s' AND localidad = '%s') AND fecha = '1900-01-01';";

        if (cbCentro.getValue() != null) {
            reset();
            centro = cbCentro.getValue().toString();
            lblInstituto.setText(centro);
            lblCiudad.setText(localidad);
            mostrarDatos();

            Funciones.abrirConexion();
            try (ResultSet result = Funciones.select(String.format(SELECT, centro, localidad))) { //La select busca los centros pendientes.
                rellenarEquipoDirectivo();

                //Compruebo si hay centros pendientes.
                if (result.next() && (rbCentrosPendientes.isSelected() || tipo == 'C')) {
                    //Si hay, entonces habilito el panel de visita y cargo el motivo.
                    txtMotivo.setText(result.getString(1));
                    paneVisita.setDisable(false);
                    btnVisita.setDisable(true);
                    hayPendiente = true;
                } else { //Si no, entonces habilito el botón de nueva visita.
                    btnVisita.setDisable(false);
                }

            } catch (SQLException ex) {
                Logger.getLogger(Centros.class.getName()).log(Level.SEVERE, null, ex);
            }
            Funciones.cerrarConexion();
        }
    }

    //Carga el combobox de centros según la localidad seleccionada.
    @FXML
    private void handleLocalidadAction(ActionEvent event) {
        final String SELECT_MIS_CENTROS = String.format("SELECT nombre FROM \"CENTRO\" c INNER JOIN \"ASOCIA\" a ON c.id = a.id_centro AND a.id_inspector = %d AND anho = %d;", id, calcularAnhoAcademico());
        final String SELECT_TODOS = "SELECT nombre FROM \"CENTRO\" WHERE localidad = '%s';";
        final String SELECT_PENDIENTES = "SELECT nombre FROM \"VISITA\" v INNER JOIN \"CENTRO\" c ON v.id_centro = c.id WHERE fecha = '1900-01-01' AND c.localidad = '%s';";
        String select;

        if (cbLocalidad.getValue() != null) {
            localidad = cbLocalidad.getValue().toString();

            reset();

            /*Compruebo el radiobutton que configura la búsqueda de centros
            y compruebo el tipo de búsqueda para hacer la búsqueda correspondiente.*/
            if (rbMisCentros.isSelected() && tipo != 'C') {
                select = SELECT_MIS_CENTROS;
            } else if (rbTodosLosCentros.isSelected() || tipo == 'C') {
                select = String.format(SELECT_TODOS, localidad);
            } else {
                select = String.format(SELECT_PENDIENTES, localidad);
            }

            //Busco el centro.
            Funciones.abrirConexion();
            cbCentro.setDisable(false);
            cbCentro.getItems().clear();
            try (ResultSet result = Funciones.select(select)) {
                while (result.next()) {
                    cbCentro.getItems().add(result.getString(1).trim());
                }
            } catch (SQLException ex) {
                Logger.getLogger(Centros.class.getName()).log(Level.SEVERE, null, ex);
            }
            Funciones.cerrarConexion();
        }
    }

    //Añade las localidades al combobox según el usuario y el radiobutton.
    private void cargarLocalidades() {
        final String SELECT_MIS_CENTROS = String.format("SELECT DISTINCT localidad FROM \"CENTRO\" c INNER JOIN \"ASOCIA\" a ON c.id = a.id_centro WHERE a.id_inspector = %d AND anho = %d;", id, calcularAnhoAcademico());
        final String SELECT_TODOS = "SELECT DISTINCT localidad FROM \"CENTRO\";";
        final String SELECT_PENDIENTES = String.format("SELECT localidad FROM \"VISITA\" v INNER JOIN \"CENTRO\" c ON v.id_centro = c.id INNER JOIN \"ASOCIA\" a on c.id = a.id_centro WHERE fecha = '1900-01-01' AND a.id_inspector = %d AND anho = %d;", id, calcularAnhoAcademico());
        String select;

        if (rbMisCentros.isSelected() && tipo != 'C') {
            select = SELECT_MIS_CENTROS;
        } else if (rbTodosLosCentros.isSelected() || tipo == 'C') {
            select = SELECT_TODOS;
        } else {
            select = SELECT_PENDIENTES;
        }

        if (cbLocalidad.getItems() != null) {
            cbLocalidad.getItems().removeAll(cbLocalidad.getItems());
        }
        cbCentro.setDisable(true);
        cbCentro.getItems().clear();

        Funciones.abrirConexion();
        try (ResultSet result = Funciones.select(select)) {
            while (result.next()) {
                cbLocalidad.getItems().add(result.getString(1).trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Centros.class.getName()).log(Level.SEVERE, null, ex);
        }

        Funciones.cerrarConexion();
    }

    //Calcula el año académico actual.
    private int calcularAnhoAcademico() {
        String fechaActual = new SimpleDateFormat("MM-yyyy").format(new Date());
        int mes = Integer.parseInt(fechaActual.split("-")[0]), anho = Integer.parseInt(fechaActual.split("-")[1]);
        if (mes < 9) {
            anho--;
        }
        return anho;
    }

    //Muestra las ofertas educativas y notas del centro seleccionado.
    private void mostrarDatos() {
        buildHtmls(false);
        rellenarEquipoDirectivo();
    }

    //Oculta o muestra componentes según el tipo de usuario.
    private void prepararModo() {
        if (tipo == 'I') {
            btnCambiarVista.setVisible(false);
        } else {
            paneVer.setVisible(false);
            dateFecha.setDisable(true);
            txtResultado.setDisable(true);
        }
    }

    //Busca los datos y carga en el tableview de equipo directivo del centro.
    private void rellenarEquipoDirectivo() {
        final String SELECT = String.format("SELECT m.cargo, m.nombre FROM \"MIEMBRO\" m INNER JOIN \"CENTRO\" c ON m.id_centro = c.id AND c.localidad = '%s' AND c.nombre = '%s';", localidad, centro);
        
        tableEquipo.getItems().clear(); //Limpia el tableview
        Funciones.abrirConexion();
        try (ResultSet result = Funciones.select(SELECT)) {
            while (result.next()) {
                tableEquipo.getItems().add(new ElementoLista(result.getString(1).trim(), result.getString(2).trim()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Centros.class.getName()).log(Level.SEVERE, null, ex);
        }

        Funciones.cerrarConexion();
    }

    //Busca y carga los webview si reset = false, si no, los pone en blanco.
    private void buildHtmls(boolean reset) {
        final String FILA = "%s<br>";
        String ofertas = "";
        String notas = "";

        if (!reset) {
            Funciones.abrirConexion();
            try (ResultSet result = Funciones.select(String.format("SELECT oferta, notas FROM \"CENTRO\" WHERE localidad = '%s' AND nombre = '%s'", localidad, centro))) {
                while (result.next()) {
                    ofertas = result.getString(1);
                    notas = result.getString(2) == null ? "" : result.getString(2); //Compruebo que las notas no sean nulas.
                }
                Funciones.cerrarConexion();

            } catch (SQLException ex) {
                Logger.getLogger(Centros.class.getName()).log(Level.SEVERE, null, ex);
            }
            Funciones.cerrarConexion();
        }

        //Escribirá cadena vacía si reset = true.
        webEngine = webOfertas.getEngine();
        webEngine.loadContent(ofertas);

        webEngine = webNotas.getEngine();
        webEngine.loadContent(notas);
    }

    //Resetea el formulario.
    private void reset() {
        lblCiudad.setText("");
        lblInstituto.setText("");
        txtMotivo.setText("");
        txtResultado.setText("");
        dateFecha.setValue(null);
        btnVisita.setDisable(true);
        paneVisita.setDisable(true);
        hayPendiente = false;
        tableEquipo.getItems().clear();
        txtMotivo.setText("");
        txtResultado.setText("");
        dateFecha.setValue(null);
        buildHtmls(true);
    }
}
