/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alejandro_examen;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.Funciones;

/**
 * FXML Controller class
 *
 * @author Alejandro
 */
public class ListaDePropuestas {

    private String nif;
    private int votosDisponibles, idPropuesta;

    @FXML
    private Label lblMensaje;
    @FXML
    private Button btnVotarPropuesta;
    @FXML
    private ListView lstPropuestas;
    @FXML
    private TextArea areaDescripcion;

    public void setParams(String nif, int votosDisponibles, boolean mensaje) {
        this.nif = nif;
        this.votosDisponibles = votosDisponibles;

        //Cargo el ListView.
        Funciones.abrirConexion();
        try (ResultSet result = Funciones.select(String.format("SELECT Titulo FROM propuesta WHERE Usuario != '%s';", nif))) {
            while (result.next()) {
                lstPropuestas.getItems().add(result.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListaDePropuestas.class.getName()).log(Level.SEVERE, null, ex);
        }
        Funciones.cerrarConexion();

        if (mensaje) {
            lblMensaje.setVisible(true);
            //El mensaje se oculta a los 3 segundos.
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    lblMensaje.setVisible(false);
                    timer.cancel();
                }
            }, 3000);
        }
    }

    @FXML
    private void nuevaPropuesta(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("NuevaPropuesta.fxml").openStream());

            NuevaPropuesta controlador = (NuevaPropuesta) loader.getController();
            controlador.setParams(nif, votosDisponibles);

            Scene scene = new Scene(root);
            scene.getStylesheets().add("alejandro_examen/Estilos.css");
            stage.setTitle("Nueva Propuesta");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void votarPropuesta(ActionEvent event) {
        if (votosDisponibles > 0) {
            Funciones.abrirConexion();
            Funciones.insert(String.format("INSERT INTO vota VALUES('%s', %d);", nif, idPropuesta));
            Funciones.insert(String.format("UPDATE usuario SET VotosDisponibles = %d WHERE NIF = '%s'", --votosDisponibles, nif));
            Funciones.cerrarConexion();
            btnVotarPropuesta.setDisable(true);
        }
    }

    @FXML
    private void verEstadoVotacion(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage padre = (Stage) node.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("Estadisticas.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("alejandro_examen/Estilos.css");
        stage.setResizable(false);
        stage.initOwner(padre); 
        stage.setTitle("Estadísticas");
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    private void verPropuesta(MouseEvent event) {
        String resultado = "", e;        
        if (lstPropuestas.getSelectionModel().getSelectedItem() != null) {
            e = lstPropuestas.getSelectionModel().getSelectedItem().toString(); //Detecto el elemento que se ha seleccionado.
            if (e != null) {
                btnVotarPropuesta.setDisable(false);
                //Busco los datos de la propuesta correspondiente.
                Funciones.abrirConexion();
                try (ResultSet result = Funciones.select(String.format("SELECT p.Id, p.Descripcion, v.Usuario FROM propuesta p LEFT JOIN vota v ON p.id = v.propuesta WHERE p.Titulo = '%s';", e))) {
                    if (result.next()) {
                        idPropuesta = result.getInt(1); //Guardo el id de la propuesta.
                        resultado += result.getString(2); //Cargo el TextArea.
                        if (result.getString(3).equals(nif)) {
                            btnVotarPropuesta.setDisable(true);
                        }
                    }
                    areaDescripcion.setText(resultado);
                } catch (SQLException ex) {
                    Logger.getLogger(ListaDePropuestas.class.getName()).log(Level.SEVERE, null, ex);
                }
                Funciones.cerrarConexion();
            }
        }
    }
}
