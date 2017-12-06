/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mispruebas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author Alejandro
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private WebView web;
    private WebEngine eng;
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        eng = web.getEngine();
        URL urlHello = getClass().getResource("html.html");
        eng.load(urlHello.toExternalForm());
        
        
        String s = "\"Secundaria publico diurno. Bachillerato publico diurno. FPBasica publico diurno. FPMedio publico diurno. FPSuperior publico diurno.\"";
        String ss[] = s.split("\\.");
        System.out.println(s.split("\\.").length);
        for (String a:ss)
            System.out.println(a.trim());
    }    
    
}
