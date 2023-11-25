package com.example.stickhero;

import com.almasb.fxgl.core.View;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class ViewManager {
    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    public ViewManager(){
        mainPane = new AnchorPane();
        mainStage = new Stage();
        mainScene = new Scene(mainPane,WIDTH,HEIGHT);
        mainStage.setScene(mainScene);
    }
    public Stage getMainStage(){
        return mainStage;
    }
}
