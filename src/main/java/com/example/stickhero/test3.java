package com.example.stickhero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class test3 {
    public static void main(String[] args) {
        Image retryIm = new Image("https://github.com/aethernavshulkraven-allain/StickHero/blob/81c2dc813fa352dbfc88abcf35723efcabbbf71f/src/main/resources/com/example/stickhero/retry.512x512.png");
        ImageView tst = new ImageView(retryIm);
        Pane scenePane = new Pane();
        scenePane.getChildren().add(tst);
    }
}
