/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alejandro_examen;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import util.Funciones;

/**
 * FXML Controller class
 *
 * @author Alejandro
 */
public class Estadisticas implements Initializable {

    @FXML
    private TableView<EstadisticaPropuesta> tableEstadisticas;
    @FXML
    private TableColumn<EstadisticaPropuesta, String> colTitulo;
    @FXML
    private TableColumn<EstadisticaPropuesta, Integer> colNumVotos;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colNumVotos.setCellValueFactory(new PropertyValueFactory<>("numVotos"));
        
        Funciones.abrirConexion();
        try (ResultSet result = Funciones.select("SELECT Titulo, COUNT(v.propuesta) FROM vota v RIGHT JOIN propuesta p ON v.propuesta = p.id GROUP BY p.id ORDER BY 2 DESC;")) {
            while (result.next()) {
                tableEstadisticas.getItems().add(new EstadisticaPropuesta(result.getString(1), result.getInt(2)));
            }
        } catch (SQLException ex) {    
            Logger.getLogger(Estadisticas.class.getName()).log(Level.SEVERE, null, ex);
        }    
        Funciones.cerrarConexion();
    }
}
