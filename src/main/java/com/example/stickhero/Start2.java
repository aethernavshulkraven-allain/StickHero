package com.example.stickhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class Start2 extends Application{
    @Override
    public void start(Stage stage) {
        try {
//            ViewManager manager = new ViewManager();
//            stage = manager.getMainStage();
//            stage.show();
            Parent root = FXMLLoader.load(getClass().getResource("play_menu2.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}