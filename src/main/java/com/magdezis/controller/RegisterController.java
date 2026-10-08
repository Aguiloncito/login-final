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
import main.java.com.magdezis.dto.request.RegisterRequest;
import main.java.com.magdezis.service.AuthService;
import main.java.com.magdezis.util.SceneManager;

/**
 * FXML Controller class
 *
 * @author AGUILON
 */
public class RegisterController implements Initializable {
    //atributos
    private final AuthService authService;
    private final SceneManager sceneManager;

    @FXML
    private TextField txtFieldNombres;
    @FXML
    private TextField txtFieldApellidos;
    @FXML
    private PasswordField txtFieldContraseña;
    @FXML
    private TextField txtFieldEmail;

    //constructor
    public RegisterController(AuthService authService, SceneManager sceneManager){
        this.authService = authService;
        this.sceneManager = sceneManager;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // no se necesita nada aca por ahora
    }

    //metodo
    public void handleRegister() throws Exception{
        if(txtFieldNombres.getText().isEmpty() || txtFieldApellidos.getText().isEmpty()
                || txtFieldContraseña.getText().isEmpty() || txtFieldEmail.getText().isEmpty()){
            sceneManager.showInfoAlert("Campos faltantes", "Revisar información", "Uno o mas campos están vacios", Alert.AlertType.CONFIRMATION);
            return;
        }
        try{
            authService.register(new RegisterRequest(
                    txtFieldNombres.getText(),
                    txtFieldApellidos.getText(),
                    txtFieldEmail.getText(),
                    txtFieldContraseña.getText()
            ));
            sceneManager.showInfoAlert("Registro exitoso", "Éxito", "Registrado con éxito", Alert.AlertType.INFORMATION);
            sceneManager.showLoginView();
        }catch(RuntimeException e){
            sceneManager.showInfoAlert("Error al registrar", "Revisa tu información", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    //redirige de vuelta al login sin registrar
    public void handleBackToLogin() throws Exception{
        sceneManager.showLoginView();
    }
}
