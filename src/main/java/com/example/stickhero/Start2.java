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

import static java.lang.System.exit;


public class Start2 extends Application {

    private Set<KeyCode> pressedKeys = new HashSet<>();
    private ScaleTransition scale;
    PauseTransition pause3 ;
    public double d;

    private RotateTransition rotate;
    private TranslateTransition stickmanTransition;

    private Rectangle pillar3;
    private TranslateTransition pillar3Transition;

    public Rectangle getPillar3() {
        return pillar3;
    }

    private TranslateTransition t;

    private TranslateTransition stickmanTransitionQuick;

    private TranslateTransition stickTransition;
    private TranslateTransition pillar1Transition;
    private TranslateTransition pillar2Transition;

    public boolean flag1 = false;


    public Rectangle stickRct;
    public Rectangle tempRct;

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
    private int start_x = 75;

    //stickman
    public Image stickmanImage = new Image(getClass().getResourceAsStream("0x0ss-85BackgroundRemoved.png"));
    public ImageView stickmanImageView = new ImageView(stickmanImage);

    public Timeline timeline1;
    private double rotationPivotY = 0;

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("play_menu3.fxml"));
            scenePane = new Pane(root);

            //generate random pillars
            //Pair<Double, Double> pillar1Properties = generateRandomPillarProperties(scenePane.getWidth(), minPillarWidth, maxPillarWidth, 50);
            pillar1 = new Rectangle(generateRandomNumber(50, 70), 200, Color.RED);
            pillar1.setLayoutX(20);
            pillar1.setLayoutY(500);

            //Pair<Double, Double> pillar2Properties = generateRandomPillarProperties(scenePane.getWidth(), minPillarWidth, maxPillarWidth, 50);
            pillar2 = new Rectangle(generateRandomNumber(50, 70), 200, Color.BLUE);
            pillar2.setLayoutX(generateRandomNumber(270, 320));
            pillar2.setLayoutY(500);

            scale = new ScaleTransition(Duration.millis(4000), stickRct);
            scale.setFromY(1.0);
            scale.setToY(2.0);

            // Set the pivot point to the bottom of the rectangle using a Rotate transform


            //fitHeight="47.0" fitWidth="57.0"
            stickmanImageView.setFitHeight(47.0);
            stickmanImageView.setFitWidth(57.0);
            stickmanImageView.setLayoutX(pillar1.getLayoutX());
            start_x = 75;
            stickmanImageView.setLayoutY(500-stickmanImageView.getFitHeight());

            stickRct = new Rectangle(7.5, 1, Color.WHITE);
            stickRct.setLayoutX(stickmanImageView.getLayoutX()+stickmanImageView.getFitWidth()-5);

            stickRct.setLayoutY(stickmanImageView.getLayoutY()+stickmanImageView.getFitHeight());

            scenePane.getChildren().add(stickRct);
            scenePane.getChildren().add(pillar1);
            scenePane.getChildren().add(pillar2);
            scenePane.getChildren().add(stickmanImageView);

            stickmanTransition = new TranslateTransition(Duration.seconds(2), stickmanImageView);
            stickTransition = new TranslateTransition(Duration.seconds(2), stickRct);
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
        Random random = new Random();

        return random.nextDouble(b - a + 1) + a;
    }



    private void handleKeyPressed(KeyEvent keyEvent) {
        pressedKeys.add(keyEvent.getCode());

        if (pressedKeys.contains(KeyCode.A)) {
            // Increase the height and adjust the Y position
            double newHeight = stickRct.getHeight() + 10;
            double newY = stickRct.getY() - 10;
            stickRct.setHeight(newHeight);
            stickRct.setY(newY);
        }
        // Add other key handling as needed
    }



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

        timeline1.setOnFinished(event5 -> {
            timeline1.stop();
        });

        timeline1.play();


//
        PauseTransition pause = new PauseTransition(Duration.seconds(2));

        // Set the action to be performed after the pause
        pause.setOnFinished(event -> {
            // Check if stickRct falls on pillar2 from pillar1
            if (stickRct.getHeight() + stickRct.getLayoutX() >= pillar2.getLayoutX() && stickRct.getHeight() + stickRct.getLayoutX() <= pillar2.getLayoutX() + pillar2.getWidth()) {
                // Move stick man to pillar2 through animation
                pillar3 = generateNewPillar3();
                scenePane.getChildren().add(pillar3);

                pillar3Transition = new TranslateTransition(Duration.seconds(2), pillar3);

                double targetX = stickmanImageView.getLayoutX()+stickRct.getHeight();
                stickmanTransition.setToX(targetX);
//                if (stickmanTransition.getStatus() == Animation.Status.RUNNING)  {
//                    stickmanTransition.stop();
//                }



                stickmanTransition.play();

                PauseTransition pause2 = new PauseTransition(Duration.seconds(2));
                pause2.play();
                pause2.setOnFinished(event2 -> {
                    System.out.println(pillar2.getLayoutX());
                    pillar3Transition.setByX(-200);
                    stickmanTransition.setToX(pillar1.getLayoutX());
                    d =-(pillar2.getLayoutX()-pillar1.getLayoutX());
                    pillar2Transition.setByX(-(pillar2.getLayoutX()-pillar1.getLayoutX()));
//                    pillar2Transition.setToX(-1000);

                    pillar1Transition.setToX(-(pillar2.getLayoutX()));
                    stickTransition.setToX(pillar1.getLayoutX()-(pillar2.getLayoutX()+pillar1.getLayoutX()));
                    pillar2Transition.play();
                    pillar2Transition.setOnFinished(event5 ->{
                        System.out.println(pillar2.getLayoutX());
                    });
                    pillar3Transition.play();
                    pillar1Transition.play();
                    stickmanTransition.play();
                    stickTransition.play();
                    System.out.println(pillar2.getLayoutX());
                    pillar3Transition.setOnFinished(event7->{
                        flag1 = true;
                    });

                });

                pause3 = new PauseTransition(Duration.seconds(2));


//

                pause3.setOnFinished(event6->{
//                    while (flag1 == false){
//
//                    }
                    System.out.println("HI");
                    tempRct = generate_stick();
                    scenePane.getChildren().add(tempRct);
                    Rectangle extra = tempRct;
                    tempRct = stickRct;
                    stickRct = extra;


//                    System.out.println(pillar1.getLayoutX());
////                    pillar2.setX(d);
//
//                    System.out.println(pillar2.getLayoutX());
////                    pillar2.setX(-(pillar2.getLayoutX()-pillar1.getLayoutX()));
//                    pillar1 = pillar2;
//                    System.out.println(pillar1.getLayoutX());
//
//                    scenePane.getChildren().remove(pillar2);
//                    pillar2 = generateNewPillar2();
//                    scenePane.getChildren().add(pillar2);
//                    tempRct = stickRct;
////                    scenePane.getChildren().remove(stickRct);
//                    stickRct = generate_stick();
//                    scenePane.getChildren().add(stickRct);
//
//
                });
                pause3.play();
//                pause3.setOnFinished(event3 -> {
//                    pillar2.setLayoutX(20); // TO BE SEEN WHY PILLAR2 NOT MOVING LEFTWARDS
//                    pillar2Transition.setToX(20);
//                    stickmanTransition.setToX(20);
//                    ParallelTransition moveLeftGroup = new ParallelTransition(pillar2Transition, stickmanTransition);
//
//                    moveLeftGroup.setOnFinished(event7 -> {
//                        moveLeftGroup.stop();
//                    });
//
//                    moveLeftGroup.play();
//                    pillar1 = pillar2;
//                    scenePane.getChildren().remove(pillar2);
//                    scenePane.getChildren().add(pillar1);
//                    stickRct = generate_stick();
//
//                    scenePane.getChildren().add(stickRct);
//
//                    generateNewPillar2();
//
//
//                });
//
//                pause3.play();
            }

            else {
                // Bring stick man to y = 0 through animation
                double targetX = stickRct.getHeight();
                stickmanTransition.setToX(targetX);
//                if (stickmanTransition.getStatus() == Animation.Status.RUNNING) {
//                    stickmanTransition.stop();
//                }

                stickmanTransition.setOnFinished(event8 -> {
                    stickmanTransition.stop();
                });

                stickmanTransition.play();
//                stickmanTransition.setToX(stickmanImageView.getX() + stickRct.getHeight());
                stickmanTransition.setToY(350);
                stickmanTransition.play();
                exit(1);
            }
        });

        // Start the pause
        pause.play();
    }

    private Rectangle generateNewPillar2() {

        Rectangle pp = new Rectangle(generateRandomNumber(30, 70), 200, Color.BLACK);
        pp.setLayoutX(generateRandomNumber(250, 320));
        pp.setLayoutY(500);
        return pp;

        // Add the new pillar2 to the scene
//        scenePane.getChildren().add(pillar2);
    }

    private Rectangle generateNewPillar3() {

        Rectangle pp = new Rectangle(generateRandomNumber(30, 70), 200, Color.BLACK);
        pp.setLayoutX(440+pp.getWidth());
        pp.setLayoutY(500);

        return pp;

        // Add the new pillar2 to the scene
//        scenePane.getChildren().add(pillar2);
    }


    private Rectangle generate_stick(){
        stickRct = new Rectangle(7.5, 1, Color.WHITE);
        stickRct.setLayoutX(stickmanImageView.getLayoutX()+stickmanImageView.getFitWidth()-5);

        stickRct.setLayoutY(stickmanImageView.getLayoutY()+stickmanImageView.getFitHeight());

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
    public static void main(String[] args) {
        launch(args);
    }
}
