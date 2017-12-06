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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import util.Funciones;

/**
 *
 * @author Alejandro
 */
public class Login {

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtContrasenha;
    @FXML
    private Button btnEntrar, btnCrearUsuario;

    @FXML
    private void handleEntrarAction(ActionEvent event) {
        login(event);
    }

    @FXML
    private void handleKeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            login(event);
        }
    }

    @FXML
    private void handleCrearUsuarioAction(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("Registro.fxml").openStream());

            Registro controlador = (Registro) loader.getController();

            Scene scene = new Scene(root);
            scene.getStylesheets().add("alejandro_examen/Estilos.css");
            stage.setTitle("Registro");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void login(Event event) {
        boolean existe = false;
        int votosDisponibles = 0;
        String nif = null;

        if (!txtUsuario.getText().equals("") || !txtContrasenha.getText().equals("")) {
            Funciones.abrirConexion();

            try (ResultSet result = Funciones.select(String.format("SELECT NIF, VotosDisponibles FROM usuario WHERE NIF = '%s' AND Contrasenha = '%s';", txtUsuario.getText(), txtContrasenha.getText()))) {
                if (result.next()) {
                    nif = result.getString(1);
                    votosDisponibles = result.getInt(2);
                    existe = true;
                }

            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            Funciones.cerrarConexion();

            if (existe) {
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
            } else {
                //Muestra el diálogo cuando no los datos no son correctos.
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No se ha podido iniciar sesión.");
                alert.setContentText("Usuario o contraseña incorrectos.");
                alert.showAndWait();
            }
        } else {
            //Muestra el diálogo cuando no los datos no son correctos.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se ha podido iniciar sesión.");
            alert.setContentText("Debes introducir usuario y contraseña.");
            alert.showAndWait();
        }
    }
}
