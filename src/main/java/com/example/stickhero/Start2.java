package com.example.stickhero;
import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
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

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.cert.PolicyNode;
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
    public boolean flag2 = false;
    public boolean flag3 = false;
    public boolean flag4 = false;


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
    public Text counter;

    public static int score = 0;


    public Timeline timeline2;
    public Timeline timeline3;

    public Timeline timeline4;

    public Image cherryImage = new Image(getClass().getResourceAsStream("590774.png"));
    public ImageView cherryImageView = new ImageView(cherryImage);

    public static ArrayList<Double> cherryLocations = new ArrayList<Double>();

    public int pillar2HasCherry = 0;

    public int collectedCherryCount = 0;

    public Stage myStage;
    private double rotationPivotY = 0;

    @Override
    public void start(Stage stage) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("play_menu3.fxml"));
            scenePane = new Pane(root);

            counter = new Text();
            counter.setText(String.valueOf(score));
            counter.setLayoutY(100);
            counter.setLayoutX(200);
//            Font font = (Font.loadFont("src/main/java/com/example/stickhero/kamikaze.3d-gradient-italic.ttf",24));
//            counter.setFont(font);
            counter.setStyle("-fx-font: 48 arial;");

            scenePane.getChildren().add(counter);


            //generate random pillars
            //Pair<Double, Double> pillar1Properties = generateRandomPillarProperties(scenePane.getWidth(), minPillarWidth, maxPillarWidth, 50);
            pillar1 = new Rectangle(generateRandomNumber(70, 100), 200, Color.BLACK);
            pillar1.setX(0);
            pillar1.setLayoutY(500);

            //Pair<Double, Double> pillar2Properties = generateRandomPillarProperties(scenePane.getWidth(), minPillarWidth, maxPillarWidth, 50);
            pillar2 = new Rectangle(generateRandomNumber(70, 100), 200, Color.BLACK);
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

            stickRct = new Rectangle(7.5, 1, Color.BLACK);
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
            myStage = stage;
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static double generateRandomNumber(double a, double b) {
        Random random = new Random();

        return random.nextDouble(b - a + 1) + a;
    }


    private boolean aKeyPressed = false;

    private void handleKeyPressed(KeyEvent keyEvent) {
        pressedKeys.add(keyEvent.getCode());

        if (pressedKeys.contains(KeyCode.A)) {
            // Increase the height and adjust the Y position
            double newHeight = stickRct.getHeight() + 10;
            double newY = stickRct.getY() - 10;
            stickRct.setHeight(newHeight);
            stickRct.setY(newY);
        }
        else if (pressedKeys.contains(KeyCode.SPACE)) {
            // add code to flip imageview object call stImg verically
            stickmanImageView.setScaleY(stickmanImageView.getScaleY()*-1);
        }
        // Add other key handling as needed
    }





    private void handleKeyReleased(KeyEvent keyEvent) {
        scale.stop();

//        KeyCode code = keyEvent.getCode();
//        pressedKeys.remove(code);
//
//        if (code == KeyCode.A) {
//            aKeyPressed = false;
//
        Rotate rotateTransform = new Rotate();

//            rotateTransform.pivotYProperty().bind(rct.layoutYProperty().add(rct.heightProperty()));
//            rotateTransform.pivotXProperty().bind(rct.layoutXProperty().add(rct.widthProperty()));
        rotateTransform.setPivotX(stickRct.getX());
        rotateTransform.setPivotY(stickRct.getY()+stickRct.getHeight()+stickRct.getWidth()/2);
        stickRct.getTransforms().add(rotateTransform);
        timeline1 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rotateTransform.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1.4), new KeyValue(rotateTransform.angleProperty(), 90)));

        timeline1.setOnFinished(event5 -> {
            timeline1.stop();
        });

        timeline1.play();


//
        PauseTransition pause = new PauseTransition(Duration.seconds(1.4));

        // Set the action to be performed after the pause
        pause.setOnFinished(event -> {

            // Check if stickRct falls on pillar2 from pillar1
            if (stickRct.getHeight() + stickRct.getLayoutX() >= pillar2.getLayoutX() && stickRct.getHeight() + stickRct.getLayoutX() <= pillar2.getLayoutX() + pillar2.getWidth()) {
                score++;
                counter.setText(String.valueOf(score));


                timeline2 = new Timeline();
                pillar3 = generateNewPillar3();
                System.out.println("before1 - "+stickmanImageView.getLayoutX());
                System.out.println("before2 - "+pillar1.getLayoutX());
                System.out.println("before3 - "+pillar2.getLayoutX());
                System.out.println("before4 - "+pillar3.getLayoutX());
                KeyFrame k1  = new KeyFrame(Duration.ZERO, new KeyValue(stickmanImageView.layoutXProperty(), stickmanImageView.getX()));
//                KeyFrame k2  = new KeyFrame(Duration.seconds(3), new KeyValue(pillar1.layoutXProperty(), pillar1.getX()));
//                KeyFrame k3  = new KeyFrame(Duration.seconds(3), new KeyValue(pillar2.layoutXProperty(), pillar2.getX()));
//                KeyFrame k4  = new KeyFrame(Duration.seconds(3), new KeyValue(pillar3.layoutXProperty(), pillar3.getX()));
//                KeyFrame k5  = new KeyFrame(Duration.seconds(3), new KeyValue(stickRct.layoutXProperty(), stickRct.getX()));

                double p1 = pillar1.getLayoutX();
                double p2 = pillar2.getBoundsInParent().getMinX();
                double p3 = pillar3.getLayoutX();
                double stm = stickmanImageView.getLayoutX();


                KeyFrame k6 = new KeyFrame(Duration.seconds(1.2), new KeyValue(stickmanImageView.layoutXProperty(), pillar2.getBoundsInParent().getMaxX() - stickmanImageView.getFitWidth()));


                KeyFrame k10  = new KeyFrame(Duration.seconds(2), new KeyValue(stickmanImageView.layoutXProperty(), pillar2.getWidth()-stickmanImageView.getFitWidth()-5));
                KeyFrame k11  = new KeyFrame(Duration.seconds(2), new KeyValue(stickRct.layoutXProperty(), p1-stickRct.getHeight()));

                KeyFrame k7  = new KeyFrame(Duration.seconds(2), new KeyValue(pillar1.layoutXProperty(),-200));
                KeyFrame k8  = new KeyFrame(Duration.seconds(2), new KeyValue(pillar2.layoutXProperty(), 0));
                KeyFrame k9  = new KeyFrame(Duration.seconds(2), new KeyValue(pillar3.layoutXProperty(), p2 ));
                if (pillar2HasCherry == 1) {
                    KeyFrame kCherry = new KeyFrame(Duration.seconds(2), new KeyValue(cherryImageView.layoutXProperty(), generateRandomNumber(100, 240)));
                    timeline2.getKeyFrames().add(kCherry);

//                    BooleanBinding intersecting = stickmanImageView.getLayoutX() >= cherryImageView.getBoundsInParent().getMinX() && stickmanImageView.getLayoutX() <= cherryImageView.getBoundsInParent().getMaxX();
//                    intersecting.addListener((obs, wasIntersecting, isNowIntersecting) -> {
//                        System.out.println("Collision!");
//                    });

                    KeyFrame chkCollision = new KeyFrame(Duration.millis(8), cherryCollision -> {
                        System.out.println("Checking for collision");
                        Bounds cherryBounds = cherryImageView.getBoundsInParent();
//                        Bounds stickmanBounds = stickmanImageView.getBoundsInParent();

                        if (stickmanImageView.getLayoutX() <= cherryBounds.getMaxX() && stickmanImageView.getLayoutX() >= cherryBounds.getMinX()) {
                            System.out.println("Detected cherry");
                            collectedCherryCount += 1;
                            scenePane.getChildren().remove(cherryImageView);
                            System.out.println();
                        }
                    });
                    timeline2.getKeyFrames().add(chkCollision);
                }

                timeline2.getKeyFrames().add(k7);
                timeline2.getKeyFrames().add(k8);
                timeline2.getKeyFrames().add(k9);
                timeline2.getKeyFrames().add(k10);
                timeline2.getKeyFrames().add(k11);
//                timeline2.getKeyFrames().add(l2);
//                timeline2.getKeyFrames().add(l3);
//                timeline2.getKeyFrames().add(l4);

//                timeline2.play();
                timeline2.setOnFinished(op->{

                    System.out.println("after1 - "+stickmanImageView.getLayoutX());
                    System.out.println("after2 - "+pillar1.getLayoutX());
                    System.out.println("after3 - "+pillar2.getLayoutX());
                    System.out.println("after4 - "+pillar3.getLayoutX());
                    System.out.println("after - "+stickmanImageView.getLayoutX());

                    System.out.println("pillar 2 -"+pillar3.layoutXProperty());
                    pillar1 = pillar2;
                    pillar2 = pillar3;
                    stickRct = generate_stick();
                });

//                Timeline collCheck = new Timeline(new KeyFrame(Duration.millis(600),eventcc -> {
//                    System.out.println("Checking for collision");
//                    Bounds cherryBounds = cherryImageView.getBoundsInParent();
////                        Bounds stickmanBounds = stickmanImageView.getBoundsInParent();
//
//                    if (stickmanImageView.getLayoutX() <= cherryBounds.getMaxX() && stickmanImageView.getLayoutX() >= cherryBounds.getMinX()) {
//                        System.out.println("Detected cherry");
//                        collectedCherryCount += 1;
//                        scenePane.getChildren().remove(cherryImageView);
//                        System.out.println();
//                    }
//                }));

//                if (pillar2HasCherry == 1) {
//                    KeyFrame kCherry = new KeyFrame(Duration.seconds(2), new KeyValue(cherryImageView.layoutXProperty(), generateRandomNumber(100, 240)));
//                    collCheck.getKeyFrames().add(kCherry);
//
//
////                    BooleanBinding intersecting = stickmanImageView.getLayoutX() >= cherryImageView.getBoundsInParent().getMinX() && stickmanImageView.getLayoutX() <= cherryImageView.getBoundsInParent().getMaxX();
////                    intersecting.addListener((obs, wasIntersecting, isNowIntersecting) -> {
////                        System.out.println("Collision!");
////                    });
//
////                    KeyFrame chkCollision = new KeyFrame(Duration.millis(8), cherryCollision -> {
//
//                    });
//                    collCheck.getKeyFrames().add(chkCollision);


                timeline3 = new Timeline();

                timeline3.getKeyFrames().add(k1);
                timeline3.getKeyFrames().add(k6);
                timeline3.play();
                timeline3.setOnFinished(opi->{
                    timeline2.play();
//                    collCheck.play();
                });

                System.out.println("p1 - "+pillar1.layoutXProperty());
                System.out.println("p2 - "+pillar2.layoutXProperty());


            }

            else {
                // Bring stick man to y = 0 through animation
                System.out.println("here");

                timeline4 = new Timeline();
                KeyFrame k1  = new KeyFrame(Duration.ZERO, new KeyValue(stickmanImageView.layoutXProperty(), stickmanImageView.getX()));

                KeyFrame k2  = new KeyFrame(Duration.seconds(2), new KeyValue(stickmanImageView.layoutXProperty(), stickmanImageView.getX()+stickRct.getBoundsInParent().getMaxX()-10));
                KeyFrame k3  = new KeyFrame(Duration.seconds(2), new KeyValue(stickmanImageView.layoutYProperty(), stickmanImageView.getLayoutY()));
                KeyFrame k4  = new KeyFrame(Duration.seconds(4), new KeyValue(stickmanImageView.layoutYProperty(), stickmanImageView.getLayoutY()+500));
                timeline4.getKeyFrames().add(k1);
                timeline4.getKeyFrames().add(k2);
                timeline4.getKeyFrames().add(k3);
                timeline4.getKeyFrames().add(k4);
                timeline4.play();
                timeline4.setOnFinished(oo->{
                    Rectangle over = new Rectangle(300,500, Color.WHITE);

                    Button button1 = new Button();
                    Image retryIm = null;
                    try {
                        retryIm = new Image(getClass().getResource("retry.512x512.png").toURI().toString());
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }

                    Image goHome = null;
                    try {
                        goHome = new Image(getClass().getResource("house-black-shape-for-home-interface-symbol.png").toURI().toString());
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }

                    Image save = null;
                    try {
                        save = new Image(getClass().getResource("2639912_save_icon.png").toURI().toString());
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                    ImageView rimv = new ImageView(retryIm);
                    rimv.setFitHeight(8);
                    rimv.setFitWidth(8);

                    ImageView rimv2 = new ImageView(goHome);
                    rimv2.setFitHeight(8);
                    rimv2.setFitWidth(8);

                    ImageView rimv3 = new ImageView(save);
                    rimv3.setFitHeight(8);
                    rimv3.setFitWidth(8);

                    button1.setGraphic(rimv);

                    button1.setOnMouseClicked(retry ->{
                        start(myStage);
                    });
                    Button button3 = new Button();
                    button3.setGraphic(rimv3);
                    Button button2 = new Button();
                    button2.setGraphic(rimv2);
                    button1.setPrefSize(10, 10);
                    button2.setPrefSize(10, 10);
                    button3.setPrefSize(10, 10);
                    StackPane stackPane = new StackPane();
                    StackPane.setAlignment(button1, Pos.CENTER_LEFT);
                    StackPane.setAlignment(button2, Pos.CENTER_RIGHT);
                    StackPane.setAlignment(button3, Pos.CENTER);

                    stackPane.getChildren().addAll(over, button1, button2, button3, rimv, rimv2, rimv3);

                    over.setOpacity(over.getOpacity()*0.5);
                    stackPane.setLayoutX(60);
                    stackPane.setLayoutY(125);
                    Text title = new Text("Game Over");
                    title.setLayoutX(50);
                    title.setLayoutX(50);
                    title.setFont(Font.font(16));
                    stackPane.getChildren().add(title);
                    scenePane.getChildren().add(stackPane);
                });
            }
        });
        pause.play();
    }

//    private static int cherryOccurs() {
//        Random random = new Random();
//        return random.nextInt(2);
//    }

    private Rectangle generateNewPillar3() {

        Rectangle pp = new Rectangle(generateRandomNumber(70, 100), 200, Color.BLACK);
        pp.setLayoutX(440 + pp.getWidth());
        pp.setLayoutY(500);

//        int cherryFlag = cherryOccurs();
//        if(cherryFlag == 1){
//            //fitHeight="47.0" fitWidth="57.0"
//            cherryImageView.setFitHeight(46.0);
//            cherryImageView.setFitWidth(39.0);
//            cherryImageView.setLayoutX(450 + generateRandomNumber(100, 240));
//            cherryImageView.setLayoutY(pillar2.getLayoutY()- cherryImageView.getFitHeight());
//            scenePane.getChildren().add(cherryImageView);
//
//            cherryLocations.add(cherryImageView.getLayoutX());
//            pillar2HasCherry = 1;
//        }else {
//            pillar2HasCherry = 0;
//        }
//
        scenePane.getChildren().add(pp);
        return pp;

        // Add the new pillar2 to the scene
//        scenePane.getChildren().add(pillar2);
    }

//    private boolean detectCherryCollision() {
//        if (pillar2HasCherry == 1) {
//            Bounds cherryBounds = cherryImageView.getBoundsInParent();
//            Bounds stickmanBounds = stickmanImageView.getBoundsInParent();
//
//            if (stickmanBounds.intersects(cherryBounds)) {
//                scenePane.getChildren().remove(cherryImageView);
//                pillar2HasCherry = 0;
//                return true;
//            }
//        }
//
//        return false;
//    }

//    private Rectangle generateNewPillar3() {
//
//        Rectangle pp = new Rectangle(generateRandomNumber(70, 100), 200, Color.BLACK);
//        pp.setLayoutX(440+pp.getWidth());
//        pp.setLayoutY(500);
//        scenePane.getChildren().add(pp);//
//
//
//        return pp;
//
//        // Add the new pillar2 to the scene
//    }


    private Rectangle generate_stick(){
        stickRct = new Rectangle(7.5, 1, Color.BLACK);
        stickRct.setLayoutX(stickmanImageView.getLayoutX()+stickmanImageView.getFitWidth());

        stickRct.setLayoutY(stickmanImageView.getLayoutY()+stickmanImageView.getFitHeight());

        scale = new ScaleTransition(Duration.millis(4000), stickRct);
        scale.setFromY(1.0);
        scale.setToY(2.0);
        Rotate rotateTransform = new Rotate();
        rotateTransform.setPivotX(stickRct.getX());
        rotateTransform.setPivotY(stickRct.getY()+stickRct.getHeight()+stickRct.getWidth()/2);
        stickRct.getTransforms().add(rotateTransform);
        scenePane.getChildren().add(stickRct);
        return stickRct;
    }



    public static void main(String[] args) {
        launch(args);
    }
}