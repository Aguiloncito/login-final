/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main.java.com.magdezis;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import main.java.com.magdezis.util.SceneManager;

/**
 *
 * @author AGUILON
 */
public class MainApp extends Application{
     
    private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        SceneManager sceneManager = new SceneManager(primaryStage);
        sceneManager.showLoginView();
        primaryStage.show();
    }
    
    public static void main(String[] args) throws Exception{
        launch();
    }
}
