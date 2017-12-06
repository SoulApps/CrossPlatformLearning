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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import util.Funciones;

/**
 *
 * @author Alejandro
 */
public class LoginScreen implements Initializable {

    @FXML
    private CheckBox chkConexion;
    @FXML
    private ComboBox cbNombre;
    @FXML
    private TextField txtContrasenha;
    @FXML
    private Button btnAcceder;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbNombre.requestFocus();
        //Cargo el combobox con los usuarios.
        Funciones.abrirConexion();
        try (ResultSet result = Funciones.select("SELECT nombre FROM \"USUARIO\";")) {
            while (result.next()) {
                cbNombre.getItems().add(result.getString(1).trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        Funciones.cerrarConexion();
    }

    //Se logea con el botón.
    @FXML
    private void handleOnButtonPressed(ActionEvent event) {
        login(event);
    }

    //Se logea con enter.
    @FXML
    private void handleOnKeyPressed(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            login(event);
        }
    }

    //Verifica los datos introducidos, si son válidos, abrirá una ventana según el tipo de usuario. Si no, mostrará un error.
    private void login(Event event) {
        //Compruebo si las credenciales son válidas.
        boolean existe = false;
        int id = 0;
        char tipo = 0;
        String nombre, pass, titulo, ruta;

        //Decide qué cadena de conexión usar desde ahora según el checkbox.
        Funciones.CONEXION_LOCAL = chkConexion.isSelected();

        Funciones.abrirConexion();

        try (ResultSet result = Funciones.select(String.format("SELECT id, tipo FROM \"USUARIO\" WHERE nombre = '%s' AND password = '%s';", cbNombre.getValue(), txtContrasenha.getText()))) {
            if (result.next()) { //Si existe ese usuario guardo su id y su tipo.
                id = result.getInt(1);
                tipo = result.getString(2).charAt(0);
                existe = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);       
        }
        Funciones.cerrarConexion();

        if (existe) {
            //Si existe abre otro formulario dependiendo del tipo de usuario.
            if (tipo == 'I') { //Si es un inspector.
                titulo = "Centros";
            } else { //Si no
                titulo = "Inspeccion";
            }

            ruta = String.format("%s.fxml", titulo); //Monto la ruta del fxml de la nueva ventana.
            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                Parent root = loader.load(getClass().getResource(ruta).openStream());
                if (tipo == 'I') {
                    Centros controlador = (Centros) loader.getController();
                    controlador.setParams(id, tipo);
                } else {
                    Inspeccion controlador = (Inspeccion) loader.getController();
                    controlador.setParams(id, tipo);
                }

                Scene scene = new Scene(root);
                scene.getStylesheets().add("practicafinal/Estilos.css");
                stage.setTitle(titulo);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //Muestra el diálogo cuando no los datos no son correctos.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se ha podido iniciar sesión.");
            alert.setContentText("Usuario o contraseña incorrectos.");
            alert.showAndWait();
        }
    }
}
