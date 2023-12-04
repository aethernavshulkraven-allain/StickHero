package com.example.stickhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Stage stage_primary;
    public static Parent root;

    static {
        try {
            root = FXMLLoader.load(HelloApplication.class.getResource("homeScreen.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static FXMLLoader Over_menu;


    static {
        Start2 st2 = new Start2();
        Over_menu = new FXMLLoader(HelloApplication.class.getResource("over_menu.fxml"));
    }
    public static Scene OverMenu;

    static {
        try {
            OverMenu = new Scene(Over_menu.load(),420,700);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void start(Stage stage) {
        try {
            stage_primary=stage;
//            ViewManager manager = new ViewManager();
//            stage = manager.getMainStage();
//            stage.show();
            Scene scene = new Scene(root);
            stage_primary.setScene(scene);
            stage_primary.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}