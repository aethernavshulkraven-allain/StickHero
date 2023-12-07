package com.example.stickhero;
import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Start2 extends Application {

    private Set<KeyCode> pressedKeys = new HashSet<>();
    private ScaleTransition scale;

    private boolean isFlipped = true;


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

    public static boolean flag;

    private TranslateTransition stickmanTransitionQuick;

    private TranslateTransition stickTransition;
    private TranslateTransition pillar1Transition;
    private TranslateTransition pillar2Transition;

    public boolean flag1 = false;
    public boolean flag2 = false;
    public boolean flag3 = false;
    public boolean flag4 = false;


    public static SaveCurrState saveCurrState;

    public Rectangle stickRct;
    public Rectangle tempRct;

    public boolean flip_allow = false;


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

    public ImageView tempCherry = new ImageView(cherryImage);


    public static ArrayList<Double> cherryLocations = new ArrayList<Double>();

    public int pillar2HasCherry = 0;

    public int collectedCherryCount = 0;

    public Stage myStage;
    private double rotationPivotY = 0;


    public void try_rotate(){
        Rotate rotateTransform = new Rotate();
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
    }


    public void tryFlip(){
        if(!(stickmanImageView.getBoundsInParent().getMinX()<pillar1.getBoundsInParent().getMaxX() || stickmanImageView.getBoundsInParent().getMaxX()>pillar2.getBoundsInParent().getMinX())){
            isFlipped = !isFlipped;
            if (isFlipped) {
                stickmanImageView.setY(stickmanImageView.getBoundsInParent().getHeight()+stickRct.getWidth());
                stickmanImageView.setRotate(180);
                stickmanImageView.setScaleX(-1);
            } else {
                stickmanImageView.setY(0);  // Set the Y position to the top
                stickmanImageView.setRotate(0);  // Reset rotation
                stickmanImageView.setScaleX(1);
                // Reset scale
            }
        }else{
            System.out.println("CANT FLIP");
        }

    }


    public void initializer(Pane scenePane,SaveCurrState s1){
        if(SaveCurrState.isF()){
            double p1_width = SaveCurrState.r1.getWidth();
            double p2_width = SaveCurrState.r2.getWidth();
            double x1 = SaveCurrState.r1.getLayoutX();
            double x2 = SaveCurrState.r2.getLayoutX();
            score = SaveCurrState.score;
            int cherries = SaveCurrState.cherries;
            pillar1 = new Rectangle(p1_width, 200, Color.BLACK);
            pillar1.setX(0);
            pillar1.setLayoutY(500);

            //Pair<Double, Double> pillar2Properties = generateRandomPillarProperties(scenePane.getWidth(), minPillarWidth, maxPillarWidth, 50);
            pillar2 = new Rectangle(p2_width, 200, Color.BLACK);
            pillar2.setLayoutX(x2);
            pillar2.setLayoutY(500);
            SaveCurrState.f = false;

        }
        else {
            pillar1 = new Rectangle(generateRandomNumber(70, 100), 200, Color.BLACK);
            pillar1.setX(0);
            pillar1.setLayoutY(500);
            score = 0;

            //Pair<Double, Double> pillar2Properties = generateRandomPillarProperties(scenePane.getWidth(), minPillarWidth, maxPillarWidth, 50);
            pillar2 = new Rectangle(generateRandomNumber(70, 100), 200, Color.BLACK);
            pillar2.setLayoutX(generateRandomNumber(270, 320));
            pillar2.setLayoutY(500);
        }
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
//        pillar1 = new Rectangle(generateRandomNumber(70, 100), 200, Color.BLACK);
//        pillar1.setX(0);
//        pillar1.setLayoutY(500);
//
//        //Pair<Double, Double> pillar2Properties = generateRandomPillarProperties(scenePane.getWidth(), minPillarWidth, maxPillarWidth, 50);
//        pillar2 = new Rectangle(generateRandomNumber(70, 100), 200, Color.BLACK);
//        pillar2.setLayoutX(generateRandomNumber(270, 320));
//        pillar2.setLayoutY(500);

        scale = new ScaleTransition(Duration.millis(4000), stickRct);
        scale.setFromY(1.0);
        scale.setToY(2.0);

        // Set the pivot point to the bottom of the rectangle using a Rotate transform


        //fitHeight="47.0" fitWidth="57.0"
        stickmanImageView.setFitHeight(30.0);
        stickmanImageView.setFitWidth(40);
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

    }

    @Override
    public void start(Stage stage) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("play_menu3.fxml"));
            scenePane = new Pane(root);
            initializer(scenePane,saveCurrState);



            stickmanTransition = new TranslateTransition(Duration.seconds(2), stickmanImageView);
            stickTransition = new TranslateTransition(Duration.seconds(2), stickRct);
            stickmanTransitionQuick = new TranslateTransition(Duration.seconds(0), stickmanImageView);
            pillar1Transition = new TranslateTransition(Duration.seconds(2), pillar1);
            pillar2Transition = new TranslateTransition(Duration.seconds(2), pillar2);
            cherryImageView = generateCherry2();

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
            double newHeight = stickRct.getHeight() + 10;
            double newY = stickRct.getY() - 10;
            stickRct.setHeight(newHeight);
            stickRct.setY(newY);
        }
        else if (pressedKeys.contains(KeyCode.SPACE)) {
            tryFlip();
        }
        // Add other key handling as needed
    }





    private void handleKeyReleased(KeyEvent keyEvent) {



        KeyCode code = keyEvent.getCode();
        pressedKeys.remove(code);
//
        if (code == KeyCode.A) {
            scale.stop();
            flag = false;


//            rotateTransform.pivotYProperty().bind(rct.layoutYProperty().add(rct.heightProperty()));
//            rotateTransform.pivotXProperty().bind(rct.layoutXProperty().add(rct.widthProperty()));
            Rotate rotateTransform = new Rotate();
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
            System.out.println("oye");


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
                    tempCherry  = generateCherry();

                    System.out.println("before1 - "+stickmanImageView.getLayoutX());
                    System.out.println("before2 - "+pillar1.getLayoutX());
                    System.out.println("before3 - "+pillar2.getLayoutX());
                    System.out.println("before4 - "+pillar3.getLayoutX());

//                    KeyFrame k1  = new KeyFrame(Duration.ZERO, new KeyValue(stickmanImageView.layoutXProperty(), stickmanImageView.getX()));
                    double p1 = pillar1.getLayoutX();
                    double p2 = pillar2.getBoundsInParent().getMinX();
                    double p3 = pillar3.getLayoutX();
                    double stm = stickmanImageView.getLayoutX();
                    double inc = cherryImageView.getLayoutX();


//                    KeyFrame k61  = new KeyFrame(Duration.seconds(1.2), new KeyValue(tempCherry.layoutXProperty(), tempCherry.getLayoutX()));
                    KeyFrame k62  = new KeyFrame(Duration.seconds(2), new KeyValue(tempCherry.layoutXProperty(), generateRandomNumber(pillar1.getBoundsInParent().getMaxX(),pillar2.getBoundsInParent().getMinX())));
//                    KeyFrame k63  = new KeyFrame(Duration.seconds(1.2), new KeyValue(cherryImageView.layoutXProperty(), cherryImageView.getLayoutX()));
                    KeyFrame k64  = new KeyFrame(Duration.seconds(2), new KeyValue(cherryImageView.layoutXProperty(),-200));



                    KeyFrame k6 =  new KeyFrame(Duration.seconds(1.2), new KeyValue(stickmanImageView.layoutXProperty(), pillar2.getBoundsInParent().getMaxX() - stickmanImageView.getFitWidth()));
                    KeyFrame k10  = new KeyFrame(Duration.seconds(2), new KeyValue(stickmanImageView.layoutXProperty(), pillar2.getWidth()-stickmanImageView.getFitWidth()-5));
                    KeyFrame k11  = new KeyFrame(Duration.seconds(2), new KeyValue(stickRct.layoutXProperty(), p1-stickRct.getHeight()));

                    KeyFrame k7  = new KeyFrame(Duration.seconds(2), new KeyValue(pillar1.layoutXProperty(),-200));
                    KeyFrame k8  = new KeyFrame(Duration.seconds(2), new KeyValue(pillar2.layoutXProperty(), 0));
                    KeyFrame k9  = new KeyFrame(Duration.seconds(2), new KeyValue(pillar3.layoutXProperty(), p2 ));
                    if (pillar2HasCherry == 1) {
                        KeyFrame kCherry = new KeyFrame(Duration.seconds(1.2), new KeyValue(cherryImageView.layoutXProperty(), cherryImageView.getLayoutX()));
                        KeyFrame kCherry2 = new KeyFrame(Duration.seconds(2), new KeyValue(cherryImageView.layoutXProperty(),generateRandomNumber(100,200)));
                        timeline2.getKeyFrames().add(kCherry);
                        timeline2.getKeyFrames().add(kCherry2);
                        KeyFrame chkCollision = new KeyFrame(Duration.millis(8), cherryCollision -> {
                            System.out.println("Checking for collision");
                            Bounds cherryBounds = cherryImageView.getBoundsInParent();
                            if (stickmanImageView.getLayoutX() <= cherryBounds.getMaxX() && stickmanImageView.getLayoutX() >= cherryBounds.getMinX()) {
                                System.out.println("Detected cherry");
                                collectedCherryCount += 1;
                                scenePane.getChildren().remove(cherryImageView);
                                System.out.println();
                            }
                        });
                        timeline2.getKeyFrames().add(chkCollision);
                    }
//                    timeline2.getKeyFrames().add(k61);
//                    timeline2.getKeyFrames().add(k63);
                    timeline2.getKeyFrames().add(k64);
                    timeline2.getKeyFrames().add(k62);

                    timeline2.getKeyFrames().add(k7);
                    timeline2.getKeyFrames().add(k8);
                    timeline2.getKeyFrames().add(k9);
                    timeline2.getKeyFrames().add(k10);
                    timeline2.getKeyFrames().add(k11);
                    timeline2.setOnFinished(op->{
                        flip_allow = false;
                        cherryImageView = tempCherry;

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

                    timeline3 = new Timeline();

//                    timeline3.getKeyFrames().add(k1);
                    timeline3.getKeyFrames().add(k6);
                    flip_allow = true;
                    timeline3.play();

                    timeline3.setOnFinished(opi->{
                        flip_allow = false;
                        timeline2.play();
                    });

                    System.out.println("p1 - "+pillar1.layoutXProperty());
                    System.out.println("p2 - "+pillar2.layoutXProperty());


                }

                else {

                    SaveCurrState.r1 = pillar1;
                    SaveCurrState.r2 = pillar2;
                    SaveCurrState.score = score;
//                    SaveCurrState.cherries;


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
//                        Rectangle over = new Rectangle(300,500, Color.WHITE);

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


//abstract-surface-textures-white-concrete-stone-wall_74190-8189.jpg-2.avif
                        Image i2 = new Image(getClass().getResourceAsStream("background.jpg"));
                        ImageView im2 = new ImageView(i2);
                        im2.setLayoutY(100);
                        im2.setLayoutX(50);
                        im2.setFitHeight(500);
                        im2.setFitWidth(350);
                        im2.setOpacity(im2.getOpacity()*0.5);
                        scenePane.getChildren().add(im2);
                        button1.setLayoutX(200);
                        button1.setLayoutY(400);
                        button1.setLayoutX(200);
                        button1.setLayoutY(300);


                        button1.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
                        button1.setStyle("-fx-background-color: #00ff00");
                        button1.setGraphic(rimv);
                        Image i1 = new Image(getClass().getResourceAsStream("retry.512x512.png"));
                        ImageView iv1 = new ImageView(i1);
                        iv1.setLayoutY(500);
                        iv1.setLayoutX(200);
                        iv1.setFitHeight(47.0);
                        iv1.setFitWidth(47.0);
                        scenePane.getChildren().add(iv1);
                        boolean isMouseTransparent = iv1.isMouseTransparent();
                        System.out.println("Is mouse transparent: " + isMouseTransparent);
                        Image i3 = new Image(getClass().getResourceAsStream("2639912_save_icon.png"));
                        ImageView iv2 = new ImageView(i3);
                        iv2.setLayoutY(400);
                        iv2.setLayoutX(200);
                        iv2.setFitHeight(47.0);
                        iv2.setFitWidth(47.0);
                        scenePane.getChildren().add(iv2);
                        Image i4 = new Image(getClass().getResourceAsStream("house-black-shape-for-home-interface-symbol.png"));
                        ImageView iv4 = new ImageView(i4);
                        iv4.setLayoutY(300);
                        iv4.setLayoutX(200);
                        iv4.setFitHeight(47.0);
                        iv4.setFitWidth(47.0);
                        scenePane.getChildren().add(iv4);

                        iv1.setOnMousePressed(retry ->{
                            System.out.println("Mouse clicked!"); // Add this line for debugging

                            score = 0;
                            start(myStage);
                        });



                        Button button3 = new Button();
                        button3.setGraphic(rimv3);
                        Button button2 = new Button();
                        button2.setGraphic(rimv2);

                        button1.setPrefSize(20, 20);
                        button2.setPrefSize(10, 10);
                        button3.setPrefSize(10, 10);

                        button2.getStyleClass().add(".css");


                        button2.setOnMouseClicked(revive->{
                            SaveCurrState.f = true;
                            start(myStage);

                        });

                        iv2.setOnMouseClicked(savegame ->{
                            Text save_t = new Text("Game Saved Successsfully");
                            save_t.setLayoutX(100);
                            save_t.setLayoutY(200);
                            save_t.setStyle("-fx-font: 48 arial;");
                            scenePane.getChildren().add(save_t);
                            System.out.println("HI");

                        });

//                        StackPane stackPane = new StackPane();
//                        StackPane.setAlignment(button1, Pos.CENTER_LEFT);
//                        StackPane.setAlignment(button2, Pos.CENTER_RIGHT);
//                        StackPane.setAlignment(button3, Pos.CENTER);
//
                        scenePane.getChildren().addAll(button1, button2, button3, rimv, rimv2, rimv3);

//                        over.setOpacity(over.getOpacity()*0.5);
//                        stackPane.setLayoutX(60);
//                        stackPane.setLayoutY(125);
                        Text title = new Text("Game Over");
                        title.setStyle("-fx-font: 48 arial");

                        title.setLayoutX(100);
                        title.setLayoutX(200);
//                        title.setFont(Font.font(16));
//
//                        stackPane.getChildren().add(title);
//                        scenePane.getChildren().add(stackPane);
                    });
                }
            });
            pause.play();

        }

//            aKeyPressed = false;
//

    }

    private static int cherryOccurs() {
        Random random = new Random();
        return random.nextInt(2);
    }

    private Rectangle generateNewPillar3() {

        Rectangle pp = new Rectangle(generateRandomNumber(70, 100), 200, Color.BLACK);
        pp.setLayoutX(440 + pp.getWidth());
        pp.setLayoutY(500);

//
        scenePane.getChildren().add(pp);
        return pp;

        // Add the new pillar2 to the scene
//        scenePane.getChildren().add(pillar2);
    }


    ImageView generateCherry(){
        Image ci = new Image(getClass().getResourceAsStream("590774.png"));
        ImageView temp = new ImageView(ci);

        temp.setFitHeight(36);
        temp.setFitWidth(28);
        temp.setLayoutX(500 );
        temp.setLayoutY(pillar2.getLayoutY()- cherryImageView.getFitHeight());
        scenePane.getChildren().add(temp);

        cherryLocations.add(temp.getLayoutX());
        return temp;

    }

    ImageView generateCherry2(){
        Image ci = new Image(getClass().getResourceAsStream("590774.png"));
        ImageView temp = new ImageView(ci);

        temp.setFitHeight(36);
        temp.setFitWidth(28.0);
        temp.setLayoutX(generateRandomNumber(pillar1.getBoundsInParent().getMaxX(), pillar2.getBoundsInParent().getMinX()));
        temp.setLayoutY(pillar2.getLayoutY()- cherryImageView.getFitHeight());
        scenePane.getChildren().add(temp);

        cherryLocations.add(temp.getLayoutX());
        return temp;

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
        MusicPlayer player = new MusicPlayer();
        Thread music_t = new Thread(player);
//        music_t.start();
        launch(args);
    }
}


class MusicPlayer implements Runnable{
    MediaPlayer mediaPlayer;
    @Override
    public void run() {
        System.out.println("hihi");
        String ms = "mujic.mp3";
        Media h = new Media(Paths.get(ms).toUri().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.play();

    }
}

class SaveCurrState{

    public static boolean isF() {
        return f;
    }

    public static boolean f;

    static Rectangle r1;
    static Rectangle r2;
    static int score;

    public static void setF(boolean f) {
        SaveCurrState.f = f;
    }

    static int cherries;




}


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
