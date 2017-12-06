/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Alejandro
 */
public class Login extends Application {

    private final String NOMBRE = "usuario", CONTRASENHA = "pass";

    //Aquí arriba se encuentran los que son útiles.
    private Text actiontarget = new Text();
    private TextField userTextField = new TextField();
    private PasswordField pwBox = new PasswordField();

    private Rectangle cuadrado;

    @Override
    public void start(Stage primaryStage) {
        //final String NOMBRE = "usuario", CONTRASENHA = "pass";

        primaryStage.setTitle("Login");

        //Panel tabla
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);

        //Título
        Text scenetitle = new Text("Welcome");
        //scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scenetitle.setId("texto_bienvenida");
        grid.add(scenetitle, 0, 0, 2, 1);

        //Label
        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        //TextBox
        //TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        //Label
        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        //Pass
        //PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        //Botón
        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        //Mensaje de error
        //Text actiontarget = new Text();
        actiontarget.setId("mensaje");
        grid.add(actiontarget, 1, 6);

        //Botón de inicio se sesión
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                login();
            }
        });

        //Text focus
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

        //Enter en usuario.
        userTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    login();
                }
            }
        });

        //Enter en contraseña.
        pwBox.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    login();
                }
            }
        });

        //Cuadrado con gradiente
        cuadrado = new Rectangle(50, 50,
                new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new Stop[]{
            new Stop(0, Color.web("#f8bd55")),
            new Stop(0.14, Color.web("#c0fe56")),
            new Stop(0.28, Color.web("#5dfbc1")),
            new Stop(0.43, Color.web("#64c2f8")),
            new Stop(0.57, Color.web("#be4af7")),
            new Stop(0.71, Color.web("#ed5fc2")),
            new Stop(0.85, Color.web("#ef504c")),
            new Stop(1, Color.web("#f2660f")),}));

        grid.add(cuadrado, 0, 5);

        //Estilos
        scene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());

        //Impide que se pueda cambiar su tamaño o maximizar.
        primaryStage.setResizable(false);

        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

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
                    cuadrado.setRotate(cuadrado.getRotate() + 1);
                    for (int i = 0; i <= NUM_VUELTAS; i++) {
                        if (cuadrado.getRotate() == 360 * NUM_VUELTAS) {
                            cuadrado.setRotate(0); //Resetea el cuadrado
                            actiontarget.setVisible(false);
                            userTextField.setText(""); //Limpia el nombre.
                            pwBox.setText(""); //Limpia la contraseña.
                            timer.cancel(); //Cancela este timer.
                        }
                    }
                }
            }, 0, 1);

        } else {
            actiontarget.setVisible(true);
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText("Error");
        }
    }
}
