/*
 * To change scene license header, choose License Headers in Project Properties.
 * To change scene template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botonescurridizo;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Alejandro
 */
public class BotonEscurridizo extends Application {
    
    private static Timer timer; //Timer estático para que se pare en el main.

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Ayy lmao");

        //Empieza en el 50, 50
        btn.setLayoutX(50);
        btn.setLayoutY(50);

        Pane root = new Pane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        //OnClick del botón que mueve el botón a una nueva ubicación.
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Random rnd = new Random();
                //Nueva posición.
                btn.setLayoutX(rnd.nextInt((int) (scene.getWidth() - btn.getWidth())));
                btn.setLayoutY(rnd.nextInt((int) (scene.getHeight() - btn.getHeight())));
            }
        });

        
        //OnMouseMove de la escena que detecta el movimiento del ratón en el scene(form)              
        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
            
                /*Detecta cual es la posición del ratón en la escena con respecto al botón y según la distancia y el lado,
                se moverá hacia el lado contrario*/
                
                if (event.getX() <= (btn.getLayoutX() + btn.getWidth() / 2 + 20) && btn.getLayoutX() + 1 < (scene.getWidth() - btn.getWidth())) {
                    btn.setLayoutX(btn.getLayoutX() + 3);
                }

                if (event.getY() <= (btn.getLayoutY() - btn.getHeight() / 2 + 20) && btn.getLayoutY() + 1 < (scene.getHeight() - btn.getHeight())) {
                    btn.setLayoutY(btn.getLayoutY() + 3);
                }

                if (event.getX() >= (btn.getLayoutX() / 2 - 20) && btn.getLayoutX() - 1 > 0) {
                    btn.setLayoutX(btn.getLayoutX() - 3);
                }

                if (event.getY() >= (btn.getLayoutY() / 2 - 20) && btn.getLayoutY() - 1 > 0) {
                    btn.setLayoutY(btn.getLayoutY() - 3);
                }

                //System.out.println(event.getX() + "|" + event.getY());
            }
        });

        //Timer que cada segundo aumenta el tamaño del botón.
        timer = new Timer();
        timer.schedule(
                new TimerTask() {

            @Override
            public void run() {
                //Aumento de tamaño.
                btn.setMinWidth(btn.getWidth() + 5);      
                btn.setMinHeight(btn.getHeight() + 5);
            }
        }, 0, 1000);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        timer.cancel(); //Parada del timer.
    }

}
