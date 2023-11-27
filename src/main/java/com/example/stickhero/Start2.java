package com.example.stickhero;
import javafx.animation.*;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javafx.util.Duration;

public class Start2 extends Application {

    private Set<KeyCode> pressedKeys = new HashSet<>();
    private ScaleTransition scale;

    private RotateTransition rotate;
    private TranslateTransition stickmanTransition;
    private TranslateTransition stickmanTransitionQuick;
    private TranslateTransition pillar1Transition;
    private TranslateTransition pillar2Transition;

    public Rectangle stickRct;

    public Rectangle pillar1;
    public Rectangle pillar2;
    private static double minPillarWidth = 50;

    private static double maxPillarWidth = 100;

    public static double getMinPillarWidth() {
        return minPillarWidth;
    }

    public static void setMinPillarWidth(double minPillarWidth) {
        Start2.minPillarWidth = minPillarWidth;
    }

    public static double getMaxPillarWidth() {
        return maxPillarWidth;
    }

    public static void setMaxPillarWidth(double maxPillarWidth) {
        Start2.maxPillarWidth = maxPillarWidth;
    }

    public static Pane scenePane;


    //stickman
    public Image stickmanImage = new Image(getClass().getResourceAsStream("0x0ss-85BackgroundRemoved.png"));
    public ImageView stickmanImageView = new ImageView(stickmanImage);

    public Timeline timeline1;
    private double rotationPivotY = 0;

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("play_menu2.fxml"));
            scenePane = new Pane(root);

            //generate random pillars
            //Pair<Double, Double> pillar1Properties = generateRandomPillarProperties(scenePane.getWidth(), minPillarWidth, maxPillarWidth, 50);
            pillar1 = new Rectangle(generateRandomNumber(30, 100), 100, Color.BLACK);
            pillar1.setLayoutX(75);
            pillar1.setLayoutY(300);

            //Pair<Double, Double> pillar2Properties = generateRandomPillarProperties(scenePane.getWidth(), minPillarWidth, maxPillarWidth, 50);
            pillar2 = new Rectangle(generateRandomNumber(30, 100), 100, Color.BLACK);
            pillar2.setLayoutX(generateRandomNumber(200, 400));
            pillar2.setLayoutY(300);

            stickRct = new Rectangle(7.5, 110, Color.WHITE);
            stickRct.setLayoutX(pillar1.getLayoutX() + pillar1.getWidth());
            stickRct.setLayoutY(190);

            scale = new ScaleTransition(Duration.millis(4000), stickRct);
            scale.setFromY(1.0);
            scale.setToY(2.0);

            // Set the pivot point to the bottom of the rectangle using a Rotate transform


            //fitHeight="47.0" fitWidth="57.0"
            stickmanImageView.setFitHeight(47.0);
            stickmanImageView.setFitWidth(57.0);
            stickmanImageView.setLayoutX(pillar1.getLayoutX());
            stickmanImageView.setLayoutY(250);

            scenePane.getChildren().add(stickRct);
            scenePane.getChildren().add(pillar1);
            scenePane.getChildren().add(pillar2);
            scenePane.getChildren().add(stickmanImageView);

            stickmanTransition = new TranslateTransition(Duration.seconds(2), stickmanImageView);
            stickmanTransitionQuick = new TranslateTransition(Duration.seconds(0), stickmanImageView);
            pillar1Transition = new TranslateTransition(Duration.seconds(2), pillar1);
            pillar2Transition = new TranslateTransition(Duration.seconds(2), pillar2);

            Scene scene = new Scene(scenePane);
            scene.setOnKeyPressed(this::handleKeyPressed);
            scene.setOnKeyReleased(this::handleKeyReleased);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static double generateRandomNumber(double a, double b) {
        // Create an instance of Random class
        Random random = new Random();

        // Generate a random number within the specified range [a, b]
        return random.nextDouble(b - a + 1) + a;
    }



    private void handleKeyPressed(KeyEvent keyEvent) {
        pressedKeys.add(keyEvent.getCode());

        if (pressedKeys.contains(KeyCode.A)) {
            // Increase the height and adjust the Y position
            double newHeight = stickRct.getHeight() + 1;
            double newY = stickRct.getY() - 1;
            stickRct.setHeight(newHeight);
            stickRct.setY(newY);
        }
        // Add other key handling as needed
    }

//    private void handleKeyReleased(KeyEvent keyEvent) {
//        scale.stop();
//        timeline1.play();
//
//        PauseTransition pause = new PauseTransition(Duration.seconds(2));
//
//        // Set the action to be performed after the pause
//        pause.setOnFinished(event -> {
//            // This code will be executed after the pause
//            //double stickEndX = stickRct.getX() + stickRct.getWidth();
//            if (stickRct.getHeight() + stickRct.getLayoutX() >= pillar2.getLayoutX() && stickRct.getHeight() + stickRct.getLayoutX() <= pillar2.getLayoutX() + pillar2.getWidth()/2) {
//                // Move stickman to pillar2 through animation
//                double targetX = pillar2.getLayoutX();
//                stickmanTransition.setToX(targetX);
//                stickmanTransition.play();
//            } else {
//                // Bring stickman to y = 0 through animation
//                stickmanTransition.setToX(stickmanImageView.getX()+stickRct.getHeight());
//                stickmanTransition.setToY(350);
//                stickmanTransition.play();
//            }
//        });
//
//        // Start the pause
//        pause.play();
//    }

    private void handleKeyReleased(KeyEvent keyEvent) {
        scale.stop();
        Rotate rotateTransform = new Rotate();

//            rotateTransform.pivotYProperty().bind(rct.layoutYProperty().add(rct.heightProperty()));
//            rotateTransform.pivotXProperty().bind(rct.layoutXProperty().add(rct.widthProperty()));
        rotateTransform.setPivotX(stickRct.getX());
        rotateTransform.setPivotY(stickRct.getY()+stickRct.getHeight()+stickRct.getWidth()/2);
        stickRct.getTransforms().add(rotateTransform);
        timeline1 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rotateTransform.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(2), new KeyValue(rotateTransform.angleProperty(), 90)));

        timeline1.play();

        PauseTransition pause = new PauseTransition(Duration.seconds(2));

        // Set the action to be performed after the pause
        pause.setOnFinished(event -> {
            // Check if stickRct falls on pillar2 from pillar1
            if (stickRct.getHeight() + stickRct.getLayoutX() >= pillar2.getLayoutX() && stickRct.getHeight() + stickRct.getLayoutX() <= pillar2.getLayoutX() + pillar2.getWidth()) {
                // Move stick man to pillar2 through animation
                double targetX = pillar2.getLayoutX() - pillar2.getWidth();
                stickmanTransition.setToX(targetX);
                stickmanTransition.play();

                PauseTransition pause2 = new PauseTransition(Duration.seconds(2));
                pause2.setOnFinished(event2 -> {
                    scenePane.getChildren().remove(pillar1);
                    scenePane.getChildren().remove(stickRct);
                });

                pause2.play();

                PauseTransition pause3 = new PauseTransition(Duration.seconds(2));
                pause3.setOnFinished(event3 -> {
                    pillar2.setLayoutX(pillar1.getLayoutX());
                    pillar1 = pillar2;
                    scenePane.getChildren().remove(pillar2);
                    scenePane.getChildren().add(pillar1);
                    stickmanTransition.setToX(pillar2.getLayoutX() - pillar2.getWidth()/2);
                    stickmanTransition.play();
                    stickRct = generate_stick();
                    stickRct.setLayoutX(pillar1.getLayoutX() + pillar1.getWidth());
                    stickRct.setLayoutY(190);
                    scenePane.getChildren().add(stickRct);

                    generateNewPillar2();


                });

                pause3.play();
            }

            else {
                // Bring stick man to y = 0 through animation
                stickmanTransition.setToX(stickmanImageView.getX() + stickRct.getHeight());
                stickmanTransition.setToY(350);
                stickmanTransition.play();
            }
        });

        // Start the pause
        pause.play();
    }

    private void generateNewPillar2() {
        // Generate a new pillar2 in the same way as in the start method
        pillar2 = new Rectangle(generateRandomNumber(30, 100), 100, Color.BLACK);
        pillar2.setLayoutX(generateRandomNumber(200, 400));
        pillar2.setLayoutY(300);

        // Add the new pillar2 to the scene
        scenePane.getChildren().add(pillar2);
    }


    private Rectangle generate_stick(){
        Rectangle stickRct = new Rectangle(7.5, 100, Color.WHITE);
        stickRct.setLayoutX(pillar1.getLayoutX() + pillar1.getWidth());
        stickRct.setLayoutY(190);

        scale = new ScaleTransition(Duration.millis(4000), stickRct);
        scale.setFromY(1.0);
        scale.setToY(2.0);

        // Set the pivot point to the bottom of the rectangle using a Rotate transform
        Rotate rotateTransform = new Rotate();

//            rotateTransform.pivotYProperty().bind(rct.layoutYProperty().add(rct.heightProperty()));
//            rotateTransform.pivotXProperty().bind(rct.layoutXProperty().add(rct.widthProperty()));
        rotateTransform.setPivotX(stickRct.getX());
        rotateTransform.setPivotY(stickRct.getY()+stickRct.getHeight()+stickRct.getWidth()/2);
        stickRct.getTransforms().add(rotateTransform);
        return stickRct;
    }





    public static void main(String[] args) {
        launch(args);
    }
}
