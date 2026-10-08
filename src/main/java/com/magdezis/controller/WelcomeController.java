/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main.java.com.magdezis.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import main.java.com.magdezis.util.SceneManager;

/**
 * FXML Controller class
 *
 * @author AGUILON
 */
public class WelcomeController implements Initializable {
    //atributos
    private final String nombreUsuario;
    private final SceneManager sceneManager;

    @FXML
    private Label lblBienvenida;

    //constructor
    public WelcomeController(String nombreUsuario, SceneManager sceneManager){
        this.nombreUsuario = nombreUsuario;
        this.sceneManager = sceneManager;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblBienvenida.setText("Bienvenido, " + nombreUsuario);
    }

    //metodo, cierra sesion y regresa al login
    public void handleLogout() throws Exception{
        sceneManager.showLoginView();
    }
}
