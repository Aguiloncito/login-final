/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main.java.com.magdezis.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.java.com.magdezis.dto.request.LoginRequest;
import main.java.com.magdezis.dto.response.LoginResponse;
import main.java.com.magdezis.service.AuthService;
import main.java.com.magdezis.util.SceneManager;

/**
 * FXML Controller class
 *
 * @author AGUILON
 */
public class LoginController implements Initializable {
    //atributos
     private final AuthService authService;
     private final SceneManager sceneManager;
     @FXML
     private TextField txtFieldEmail;
     @FXML
     private PasswordField txtFieldContraseña;
    //Constructor
     public LoginController(AuthService authService, SceneManager sceneManager){
         this.authService = authService;
         this.sceneManager = sceneManager;
     }
             
             
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("TODO LO QUE ESTE ACA, SE EJECUTA CUANDO SE MUESTRA LA VISTA");
    } 
    
    //metodo
    public void handleLogin() throws Exception{
        if(txtFieldEmail.getText().isEmpty()||txtFieldContraseña.getText().isEmpty()){
            sceneManager.showInfoAlert("Campos faltantes", "Revisar información", "Uno o mas campos están vacios", Alert.AlertType.CONFIRMATION);
        }else{
            try{
            LoginResponse userLogged = authService.login(new LoginRequest(txtFieldEmail.getText(), txtFieldContraseña.getText()));
            sceneManager.showWelcomeView(userLogged.getNombreCompleto());
            }catch(RuntimeException e){
                sceneManager.showInfoAlert("Datos incorrectos", "Revisa tu información", "Intenta de nuevo", Alert.AlertType.INFORMATION);
            }
        }
    }

    //redirige a la vista de registro
    public void handleGoToRegister() throws Exception{
        sceneManager.showRegisterView();
    }
}
