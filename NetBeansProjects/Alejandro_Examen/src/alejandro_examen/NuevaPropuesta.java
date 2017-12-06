/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alejandro_examen;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.stage.Stage;
import util.Funciones;

/**
 * FXML Controller class
 *
 * @author Alejandro
 */
public class NuevaPropuesta {

    private String nif;
    private int votosDisponibles, idPropuesta;

    @FXML
    private Label lblError;
    @FXML
    private TextField txtTitulo;
    @FXML
    private TextArea areaDescripcion;

    public void setParams(String nif, int votosDisponibles) {
        this.nif = nif;
        this.votosDisponibles = votosDisponibles;

    }

    @FXML
    public void proponer(ActionEvent event) {

        if (!txtTitulo.getText().equals("") && !areaDescripcion.getText().equals("")) {
            Funciones.abrirConexion();
            Funciones.insert(String.format("INSERT INTO propuesta VALUES(NULL, '%s', '%s', '%s');", txtTitulo.getText(), areaDescripcion.getText(), nif));
            Funciones.cerrarConexion();

            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                Parent root = loader.load(getClass().getResource("ListaDePropuestas.fxml").openStream());

                ListaDePropuestas controlador = (ListaDePropuestas) loader.getController();
                controlador.setParams(nif, votosDisponibles, true); //Para que muestre el mensaje al volver

                Scene scene = new Scene(root);
                scene.getStylesheets().add("alejandro_examen/Estilos.css");
                stage.setTitle("Lista de propuestas");
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            lblError.setVisible(true);
        }
    }

    @FXML
    public void cancelar(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("ListaDePropuestas.fxml").openStream());

            ListaDePropuestas controlador = (ListaDePropuestas) loader.getController();
            controlador.setParams(nif, votosDisponibles, false);

            Scene scene = new Scene(root);
            scene.getStylesheets().add("alejandro_examen/Estilos.css");
            stage.setTitle("Lista de propuestas");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void textoCambiado(InputEvent event) {
        lblError.setVisible(false);
    }
}
