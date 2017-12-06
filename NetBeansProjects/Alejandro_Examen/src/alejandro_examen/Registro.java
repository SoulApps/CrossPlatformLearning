/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alejandro_examen;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import util.Funciones;

/**
 * FXML Controller class
 *
 * @author Alejandro
 */
public class Registro {

    @FXML
    private TextField txtNIF;
    @FXML
    private PasswordField txtContrasenha, txtRepetirContrasenha;

    @FXML
    private void handleRegistrarAction(ActionEvent event) {
        registrar(event);
    }

    @FXML
    private void handleKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            registrar(event);
        }
    }

    private void registrar(Event event) {
        boolean disponible = false;
        int votosDisponibles = 10;
        String nif = txtNIF.getText();

        if (!txtNIF.getText().equals("") && !txtContrasenha.getText().equals("") && !txtRepetirContrasenha.getText().equals("")) {
            if (txtContrasenha.getText().equals(txtRepetirContrasenha.getText())) {
                Funciones.abrirConexion();

                try (ResultSet result = Funciones.select(String.format("SELECT COUNT(*) FROM usuario WHERE NIF = '%s';", nif))) {
                    if (result.next()) { //Si existe ese usuario guardo su id y su tipo.
                        if (result.getInt(1) == 0) {
                            disponible = true;
                        }
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (disponible) {
                    Funciones.insert(String.format("INSERT INTO usuario VALUES('%s', '%s', 10);", nif, txtContrasenha.getText()));
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
                        Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    mostrarAlerta("Ese usuario ya está registrado.");
                }
                
                Funciones.cerrarConexion();
            } else {
                //Muestra el diálogo cuando no las contraseñas no son iguales.
                mostrarAlerta("Las contraseñas deben ser iguales.");
            }
        } else {
            //Muestra el diálogo el formulario no está relleno.           
            mostrarAlerta("Debes rellenar todos los campos.");
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("No se ha podido registrar.");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
