package com.example.stickhero;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.HashSet;
import java.util.Set;

public class Start2 extends Application {

    private Set<KeyCode> pressedKeys = new HashSet<>();
    private ScaleTransition scale;

    private RotateTransition rotate;
    public Rectangle rct;

    public Timeline timeline1;
    private double rotationPivotY = 0;

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("play_menu2.fxml"));

            rct = new Rectangle(10, 100, Color.WHITE);
            rct.setLayoutX(75);
            rct.setLayoutY(143);

            scale = new ScaleTransition(Duration.millis(4000), rct);
            scale.setFromY(1.0);
            scale.setToY(2.0);


            // Set the pivot point to the bottom of the rectangle using a Rotate transform
            Rotate rotateTransform = new Rotate();

//            rotateTransform.pivotYProperty().bind(rct.layoutYProperty().add(rct.heightProperty()));
//            rotateTransform.pivotXProperty().bind(rct.layoutXProperty().add(rct.widthProperty()));
            rotateTransform.setPivotX(rct.getX());
            rotateTransform.setPivotY(rct.getY()+rct.getHeight()+rct.getWidth()/2);
            rct.getTransforms().add(rotateTransform);
            timeline1 = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(rotateTransform.angleProperty(), 0)),
                    new KeyFrame(Duration.seconds(4), new KeyValue(rotateTransform.angleProperty(), 90)));




            Pane pane = new Pane(root, rct);

            // Set up key event handlers
            Scene scene = new Scene(pane);
            scene.setOnKeyPressed(this::handleKeyPressed);
            scene.setOnKeyReleased(this::handleKeyReleased);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleKeyPressed(KeyEvent keyEvent) {
        pressedKeys.add(keyEvent.getCode());

        if (pressedKeys.contains(KeyCode.A)) {
            // Increase the height and adjust the Y position
            double newHeight = rct.getHeight() + 1;
            double newY = rct.getY() - 1;
                rct.setHeight(newHeight);
                rct.setY(newY);
        }
        // Add other key handling as needed
    }

    private void handleKeyReleased(KeyEvent keyEvent) {
        scale.stop();
//        pressedKeys.remove(keyEvent.getCode());
//        double originalLayoutY = rct.getLayoutY();
//        rct.setLayoutY(originalLayoutY + rct.getHeight() / 2);
//
//        rotate.setOnFinished(event -> {
//            // Revert the layout to its original state after rotation
//            rct.setLayoutY(originalLayoutY);
//        });
//            rotate.play();
        timeline1.play();

        // Add other key release handling as needed
    }
    private void rotateRectangle() {
        // Set the pivot point to the bottom of the rectangle
        rct.getTransforms().add(new Rotate(90, rct.getLayoutX() + rct.getWidth() / 2, rct.getLayoutY() + rct.getHeight()));

        // Update the pivot point for future rotations
        rotationPivotY = rct.getLayoutY() + rct.getHeight();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
