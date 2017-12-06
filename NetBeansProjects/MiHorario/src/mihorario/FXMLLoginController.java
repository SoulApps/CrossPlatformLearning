/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mihorario;

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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import util.Funciones;

/**
 *
 * @author Alejandro
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private ComboBox cbProfesor;

    @FXML
    Button btnEntrar;

    @FXML
    private void handleSubmitButtonAction(ActionEvent event) {
        login(event);
    }

    @FXML
    private void handleComboBoxAction(ActionEvent event) {
        btnEntrar.setDisable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buscarProfesores();
    }

    private void buscarProfesores() {
        final String SELECT_PROFESORES = "SELECT CodProf FROM Profesor;";

        Funciones.abrirConexion();
        try (ResultSet result = Funciones.select(SELECT_PROFESORES)) {
            while (result.next()) {
                cbProfesor.getItems().add(result.getString(1));
            }
            result.close();
        } catch (SQLException e) {
        } finally {
            Funciones.cerrarConexion();
        }
    }

    public void login(Event event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("FXMLHorario.fxml").openStream());
            FXMLHorarioController controlador = (FXMLHorarioController) loader.getController();
            controlador.setProfesor(cbProfesor.getValue().toString());
            
            Scene scene = new Scene(root);
            stage.setTitle("Horario");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
