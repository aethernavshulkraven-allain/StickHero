package com.example.stickhero;

import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ResourceBundle;
import java.net.URL;
public class StickController  {
    @FXML
    private Rectangle myRectangle;
//    public void initialize(URL arg, ResourceBundle arg1){
//        Scale scale = new Scale();
//        scale.setPivotY(100);
//
//        myRectangle.getTransforms().add(scale);
//
////        TranslateTransition translate = new TranslateTransition();
////        translate.setNode(myRectangle);
////
////        translate.setDuration(Duration.millis(10000));
////        translate.setCycleCount(TranslateTransition.INDEFINITE);
////        translate.setByY(1000);
////        translate.play();
//    }

    public void initialize(){
        Scale scale = new Scale();
        scale.setPivotY(100);

        myRectangle.getTransforms().add(scale);
    }


}
