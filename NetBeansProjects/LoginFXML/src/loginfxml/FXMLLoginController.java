/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginfxml;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author Alejandro
 */
public class FXMLLoginController implements Initializable {

    private final String NOMBRE = "usuario", CONTRASENHA = "pass";

    @FXML
    private Text actiontarget;
    @FXML
    private TextField userTextField;
    @FXML
    private PasswordField pwBox;
    @FXML
    private ImageView logo;

    @FXML
    private void handleSubmitButtonAction(ActionEvent event) {
        login();
    }

    @FXML
    private void handleSubmitOnKeyPressed(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            login();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (actiontarget.getText().equals("Error") && !oldValue.equals(newValue)) {
                    actiontarget.setVisible(false);
                }
            }
        }
        );

        pwBox.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (actiontarget.getText().equals("Error") && !oldValue.equals(newValue)) {
                    actiontarget.setVisible(false);
                }
            }
        }
        );

    }

    //Métodos propios.
    //Comprueba si el usuario y la contraseña son correctos.
    public void login() {
        if (userTextField.getText().equals(NOMBRE) && pwBox.getText().equals(CONTRASENHA)) { //Si el nombre y la contraseña son correctos.                   
            actiontarget.setVisible(true);
            actiontarget.setFill(Color.GREEN);
            actiontarget.setText("Bienvenido");

            Timer timer = new Timer();

            //Mover cuadrado y ocultar mensaje.           
            timer.scheduleAtFixedRate(new TimerTask() {

                @Override
                public void run() {
                    final int NUM_VUELTAS = 5;
                    logo.setRotate(logo.getRotate() + 1);
                    if (logo.getRotate() == 360 * NUM_VUELTAS) {
                        logo.setRotate(0); //Resetea el cuadrado
                        actiontarget.setVisible(false);
                        userTextField.setText(""); //Limpia el nombre.
                        pwBox.setText(""); //Limpia la contraseña.                          
                        timer.cancel(); //Cancela este timer.
                    }

                }
            }, 0, 1);
            userTextField.requestFocus();

        } else {
            actiontarget.setVisible(true);
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText("Error");
        }
    }
}
