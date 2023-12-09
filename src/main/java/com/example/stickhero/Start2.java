package com.example.stickhero;
import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.*;


public class Start2 extends Application {

    private Set<KeyCode> pressedKeys = new HashSet<>();
    private ScaleTransition scale;

    private boolean cherrylock = true;

    private boolean isFlipped = true;

    private storage gameData;

    private PauseTransition pause3 ;
    public double d;

    private RotateTransition rotate;
    private TranslateTransition stickmanTransition;

    private Rectangle pillar3;
    private TranslateTransition pillar3Transition;

    private Rectangle getPillar3() {
        return pillar3;
    }

    private TranslateTransition t;

    private static boolean flag;

    private TranslateTransition stickmanTransitionQuick;

    private TranslateTransition stickTransition;
    private TranslateTransition pillar1Transition;
    private TranslateTransition pillar2Transition;

    private boolean flag1 = false;
    private boolean flag2 = false;
    private boolean flag3 = false;
    private boolean flag4 = false;

    private int reloadFlag = 0;

    public int getReloadFlag() {
        return reloadFlag;
    }

    public void setReloadFlag(int reloadFlag) {
        this.reloadFlag = reloadFlag;
    }

    private saveDetails progress;


    public static saveDetails getSaveCurrState() {
        return saveCurrState;
    }

    public static void setSaveCurrState(saveDetails saveCurrState) {
        Start2.saveCurrState = saveCurrState;
    }

    private static saveDetails saveCurrState;

    private Rectangle stickRct;
    private Rectangle tempRct;

    private boolean flip_allow = false;


    private Rectangle pillar1;

    private pillar pillar1obj;
    private Rectangle pillar2;
    private pillar pillar2obj;

    private ArrayList<pillar> pillarArrayList;

    private static double minPillarWidth = 50;

    private Timeline collisionCheckTimeline;

    private static double maxPillarWidth = 100;

    private static boolean validStick;
    private static boolean stickFell;

    private static boolean stickmanIsFlipped;

    public static boolean isStickmanIsFlipped() {
        return stickmanIsFlipped;
    }

    public static void setStickmanIsFlipped(boolean stickmanIsFlipped) {
        Start2.stickmanIsFlipped = stickmanIsFlipped;
    }

    public static boolean isValidStick() {
        return validStick;
    }

    public static void setValidStick(boolean validStick) {
        Start2.validStick = validStick;
    }

    public static boolean isStickFell() {
        return stickFell;
    }

    public static void setStickFell(boolean stickFell) {
        Start2.stickFell = stickFell;
    }

    public static boolean isCherryIncremented() {
        return cherryIncremented;
    }

    public static void setCherryIncremented(boolean cherryIncremented) {
        Start2.cherryIncremented = cherryIncremented;
    }

    public static boolean isStickmanIntersects() {
        return stickmanIntersects;
    }

    public static void setStickmanIntersects(boolean stickmanIntersects) {
        Start2.stickmanIntersects = stickmanIntersects;
    }

    private static boolean cherryIncremented;

    private static boolean stickmanIntersects;

    private static Pane scenePane;
    private int start_x = 75;

    //stickman
    private Image stickmanImage = new Image(getClass().getResourceAsStream("0x0ss-85BackgroundRemoved.png"));
    public ImageView stickmanImageView = new ImageView(stickmanImage);


//    public ImageView stxi =

    private Timeline timeline1;
    private Text counter;

    private static int score = 0;


    private Timeline timeline2;
    private Timeline timeline3;

    private Timeline timeline4;

    private Image cherryImage = new Image(getClass().getResourceAsStream("590774.png"));
    private ImageView cherryImageView = new ImageView(cherryImage);

    private cherry cherryObj = new cherry(cherryImageView);

    private ImageView tempCherry = new ImageView(cherryImage);


    private static ArrayList<Double> cherryLocations = new ArrayList<Double>();

    private int pillar2HasCherry = 0;

    private int collectedCherryCount = 0;

    private Stage myStage;
    private double rotationPivotY = 0;

    private boolean canRotate = true;

    private boolean increaseFlag = true;

    private boolean game_lock = true;


    private ImageView cherryView = new ImageView(cherryImage);


    public Set<KeyCode> getPressedKeys() {
        return pressedKeys;
    }

    public void setPressedKeys(Set<KeyCode> pressedKeys) {
        this.pressedKeys = pressedKeys;
    }

    public ScaleTransition getScale() {
        return scale;
    }

    public void setScale(ScaleTransition scale) {
        this.scale = scale;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public void setFlipped(boolean flipped) {
        isFlipped = flipped;
    }

    public storage getGameData() {
        return gameData;
    }

    public void setGameData(storage gameData) {
        this.gameData = gameData;
    }

    public PauseTransition getPause3() {
        return pause3;
    }

    public void setPause3(PauseTransition pause3) {
        this.pause3 = pause3;
    }

    public double getD() {
        return d;
    }
    public ImageView stickmanImageview;


    public void setD(double d) {
        this.d = d;
    }

    public RotateTransition getRotate() {
        return rotate;
    }

    public void setRotate(RotateTransition rotate) {
        this.rotate = rotate;
    }

    public TranslateTransition getStickmanTransition() {
        return stickmanTransition;
    }

    public void setStickmanTransition(TranslateTransition stickmanTransition) {
        this.stickmanTransition = stickmanTransition;
    }

    public void setPillar3(Rectangle pillar3) {
        this.pillar3 = pillar3;
    }

    public TranslateTransition getPillar3Transition() {
        return pillar3Transition;
    }

    public void setPillar3Transition(TranslateTransition pillar3Transition) {
        this.pillar3Transition = pillar3Transition;
    }

    public TranslateTransition getT() {
        return t;
    }

    public void setT(TranslateTransition t) {
        this.t = t;
    }

    public static boolean isFlag() {
        return flag;
    }

    public static void setFlag(boolean flag) {
        Start2.flag = flag;
    }

    public TranslateTransition getStickmanTransitionQuick() {
        return stickmanTransitionQuick;
    }

    public void setStickmanTransitionQuick(TranslateTransition stickmanTransitionQuick) {
        this.stickmanTransitionQuick = stickmanTransitionQuick;
    }

    public TranslateTransition getStickTransition() {
        return stickTransition;
    }

    public void setStickTransition(TranslateTransition stickTransition) {
        this.stickTransition = stickTransition;
    }

    public TranslateTransition getPillar1Transition() {
        return pillar1Transition;
    }

    public void setPillar1Transition(TranslateTransition pillar1Transition) {
        this.pillar1Transition = pillar1Transition;
    }

    public TranslateTransition getPillar2Transition() {
        return pillar2Transition;
    }

    public void setPillar2Transition(TranslateTransition pillar2Transition) {
        this.pillar2Transition = pillar2Transition;
    }

    public boolean isFlag1() {
        return flag1;
    }

    public void setFlag1(boolean flag1) {
        this.flag1 = flag1;
    }

    public boolean isFlag2() {
        return flag2;
    }

    public void setFlag2(boolean flag2) {
        this.flag2 = flag2;
    }

    public boolean isFlag3() {
        return flag3;
    }

    public void setFlag3(boolean flag3) {
        this.flag3 = flag3;
    }

    public boolean isFlag4() {
        return flag4;
    }

    public void setFlag4(boolean flag4) {
        this.flag4 = flag4;
    }

    public saveDetails getProgress() {
        return progress;
    }

    public void setProgress(saveDetails progress) {
        this.progress = progress;
    }

    public Rectangle getStickRct() {
        return stickRct;
    }

    public void setStickRct(Rectangle stickRct) {
        this.stickRct = stickRct;
    }

    public Rectangle getTempRct() {
        return tempRct;
    }

    public void setTempRct(Rectangle tempRct) {
        this.tempRct = tempRct;
    }

    public boolean isFlip_allow() {
        return flip_allow;
    }

    public void setFlip_allow(boolean flip_allow) {
        this.flip_allow = flip_allow;
    }

    public Rectangle getPillar1() {
        return pillar1;
    }

    public void setPillar1(Rectangle pillar1) {
        this.pillar1 = pillar1;
    }

    public pillar getPillar1obj() {
        return pillar1obj;
    }

    public void setPillar1obj(pillar pillar1obj) {
        this.pillar1obj = pillar1obj;
    }

    public Rectangle getPillar2() {
        return pillar2;
    }

    public void setPillar2(Rectangle pillar2) {
        this.pillar2 = pillar2;
    }

    public pillar getPillar2obj() {
        return pillar2obj;
    }

    public void setPillar2obj(pillar pillar2obj) {
        this.pillar2obj = pillar2obj;
    }

    public ArrayList<pillar> getPillarArrayList() {
        return pillarArrayList;
    }

    public void setPillarArrayList(ArrayList<pillar> pillarArrayList) {
        this.pillarArrayList = pillarArrayList;
    }

    public static Pane getScenePane() {
        return scenePane;
    }

    public static void setScenePane(Pane scenePane) {
        Start2.scenePane = scenePane;
    }

    public int getStart_x() {
        return start_x;
    }

    public void setStart_x(int start_x) {
        this.start_x = start_x;
    }

    public Image getStickmanImage() {
        return stickmanImage;
    }

    public void setStickmanImage(Image stickmanImage) {
        this.stickmanImage = stickmanImage;
    }


    public void setStickmanImageView(ImageView stickmanImageView) {
        this.stickmanImageView = stickmanImageView;
    }

    public Timeline getTimeline1() {
        return timeline1;
    }

    public void setTimeline1(Timeline timeline1) {
        this.timeline1 = timeline1;
    }

    public Text getCounter() {
        return counter;
    }

    public void setCounter(Text counter) {
        this.counter = counter;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Start2.score = score;
    }

    public Timeline getTimeline2() {
        return timeline2;
    }

    public void setTimeline2(Timeline timeline2) {
        this.timeline2 = timeline2;
    }

    public Timeline getTimeline3() {
        return timeline3;
    }

    public void setTimeline3(Timeline timeline3) {
        this.timeline3 = timeline3;
    }

    public Timeline getTimeline4() {
        return timeline4;
    }

    public void setTimeline4(Timeline timeline4) {
        this.timeline4 = timeline4;
    }

    public Image getCherryImage() {
        return cherryImage;
    }

    public void setCherryImage(Image cherryImage) {
        this.cherryImage = cherryImage;
    }

    public ImageView getCherryImageView() {
        return cherryImageView;
    }

    public void setCherryImageView(ImageView cherryImageView) {
        this.cherryImageView = cherryImageView;
    }

    public cherry getCherryObj() {
        return cherryObj;
    }

    public void setCherryObj(cherry cherryObj) {
        this.cherryObj = cherryObj;
    }

    public ImageView getTempCherry() {
        return tempCherry;
    }

    public void setTempCherry(ImageView tempCherry) {
        this.tempCherry = tempCherry;
    }

    public static ArrayList<Double> getCherryLocations() {
        return cherryLocations;
    }

    public static void setCherryLocations(ArrayList<Double> cherryLocations) {
        Start2.cherryLocations = cherryLocations;
    }

    public int getPillar2HasCherry() {
        return pillar2HasCherry;
    }

    public void setPillar2HasCherry(int pillar2HasCherry) {
        this.pillar2HasCherry = pillar2HasCherry;
    }

    public int getCollectedCherryCount() {
        return collectedCherryCount;
    }

    public void setCollectedCherryCount(int collectedCherryCount) {
        this.collectedCherryCount = collectedCherryCount;
    }

    public Stage getMyStage() {
        return myStage;
    }

    public void setMyStage(Stage myStage) {
        this.myStage = myStage;
    }

    public double getRotationPivotY() {
        return rotationPivotY;
    }

    public void setRotationPivotY(double rotationPivotY) {
        this.rotationPivotY = rotationPivotY;
    }

    public boolean isCanRotate() {
        return canRotate;
    }

    public void setCanRotate(boolean canRotate) {
        this.canRotate = canRotate;
    }

    public boolean isIncreaseFlag() {
        return increaseFlag;
    }

    public void setIncreaseFlag(boolean increaseFlag) {
        this.increaseFlag = increaseFlag;
    }

    public boolean isGame_lock() {
        return game_lock;
    }

    public void setGame_lock(boolean game_lock) {
        this.game_lock = game_lock;
    }

    public ImageView getCherryView() {
        return cherryView;
    }

    public void setCherryView(ImageView cherryView) {
        this.cherryView = cherryView;
    }

    public Text getCherryText() {
        return cherryText;
    }

    public void setCherryText(Text cherryText) {
        this.cherryText = cherryText;
    }

    public boolean isFlip_flag() {
        return flip_flag;
    }

    public void setFlip_flag(boolean flip_flag) {
        this.flip_flag = flip_flag;
    }

    public boolean isaKeyPressed() {
        return aKeyPressed;
    }

    public void setaKeyPressed(boolean aKeyPressed) {
        this.aKeyPressed = aKeyPressed;
    }

    public boolean isCollided() {
        return collided;
    }

    public void setCollided(boolean collided) {
        this.collided = collided;
    }

    private Text cherryText;


    public void setCherryOpacity(){
        double x = generateRandomNumber(0,2);
        if(x>1){
            cherryImageView.setOpacity(0);
        }else{
            cherryImageView.setOpacity(1);
        }
    }


    public void try_rotate(){
        if(canRotate){
            canRotate = false;
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

        }else {

        }

    }


    public void tryFlip(){
        System.out.println("here");
        if(stickmanImageView.getBoundsInParent().intersects(pillar2.getBoundsInParent())){
            System.out.println("over");
        }
        if(!(stickmanImageView.getBoundsInParent().getMinX()<pillar1.getBoundsInParent().getMaxX() || stickmanImageView.getBoundsInParent().getMaxX()>pillar2.getBoundsInParent().getMinX())){
            isFlipped = !isFlipped;
            if (isFlipped) {
                stickmanImageView.setY(stickmanImageView.getBoundsInParent().getHeight()+stickRct.getWidth());
                stickmanImageView.setRotate(180);
                stickmanImageView.setScaleX(-1);
                flip_flag = false;
            } else {
                stickmanImageView.setY(0);
                stickmanImageView.setRotate(0);
                stickmanImageView.setScaleX(1);
                flip_flag = true;
            }
        }else{
            System.out.println("CANT FLIP");
        }

    }


    public void initializer(Pane scenePane, saveDetails s1){
        if(reloadFlag == 1){
            double p1_width = s1.standingPillarWidth;
            double p2_width = s1.nextPillarWidth;
            double x1 = s1.standingPillarX;
            double x2 = s1.nextPillarX;
            score = s1.score;
            int cherries = s1.cherryCount;
            collectedCherryCount = cherries;
            pillar1 = new Rectangle(p1_width, 200, Color.BLACK);
            pillar1.setX(0);
            pillar1.setLayoutY(500);
            pillar1obj = new pillar(pillar1);

            //Pair<Double, Double> pillar2Properties = generateRandomPillarProperties(scenePane.getWidth(), minPillarWidth, maxPillarWidth, 50);
            pillar2 = new Rectangle(p2_width, 200, Color.BLACK);
            pillar2.setLayoutX(x2);
            pillar2.setLayoutY(500);
            pillar2obj = new pillar(pillar2);

            SaveCurrState.f = false;
            reloadFlag = 0;
        }

        else {
            pillar1 = new Rectangle(generateRandomNumber(70, 100), 200, Color.BLACK);
            pillar1.setX(0);
            pillar1.setLayoutY(500);
            score = 0;
            pillar2 = new Rectangle(generateRandomNumber(70, 100), 200, Color.BLACK);
            pillar2.setLayoutX(generateRandomNumber(270, 320));
            pillar2.setLayoutY(500);
        }
        cherryText = new Text();
        cherryText.setText(String.valueOf(collectedCherryCount));
        cherryText.setLayoutX(360);
        cherryText.setLayoutY(50);
        cherryText.setStyle("-fx-font: 26 arial;");


        counter = new Text();
        counter.setText(String.valueOf(score));
        counter.setLayoutY(100);
        counter.setLayoutX(200);

        scenePane.getChildren().add(cherryText);

        counter.setStyle("-fx-font: 48 arial;");

        scenePane.getChildren().add(counter);

        scale = new ScaleTransition(Duration.millis(4000), stickRct);
        scale.setFromY(1.0);
        scale.setToY(2.0);

        stickmanImageView.setFitHeight(30.0);
        stickmanImageView.setFitWidth(40);
        stickmanImageView.setLayoutX(pillar1.getBoundsInParent().getMaxX()-stickmanImageView.getFitWidth());
        start_x = 75;
        stickmanImageView.setLayoutY(500-stickmanImageView.getFitHeight());

        stickRct = new Rectangle(5, 1, Color.BLACK);
        stickRct.setLayoutX(stickmanImageView.getLayoutX()+stickmanImageView.getFitWidth()-5);

        stickRct.setLayoutY(stickmanImageView.getLayoutY()+stickmanImageView.getFitHeight());

        scenePane.getChildren().add(stickRct);
        scenePane.getChildren().add(pillar1);
        scenePane.getChildren().add(pillar2);
        scenePane.getChildren().add(stickmanImageView);


        pillarArrayList = new ArrayList<>();
        pillarArrayList.add(pillar1obj);
        pillarArrayList.add(pillar2obj);
        gameData = new storage(pillarArrayList);
    }

    @Override
    public void start(Stage stage) {
        try {
            stickHero sh = stickHero.getInstance();
            stickmanImageview = sh.getImv();
            //used the singleton stickman instance "sh"
            cherrylock = true;
            isFlipped = false;
            increaseFlag = true;
            game_lock = true;
            canRotate = true;

            Parent root = FXMLLoader.load(getClass().getResource("play_menu3.fxml"));
            scenePane = new Pane(root);
            cherryView.setLayoutX(370);
            cherryView.setLayoutY(10);
            cherryView.setFitHeight(35);
            cherryView.setFitWidth(35);
            scenePane.getChildren().add(cherryView);

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


    public void tryIncrease(){
        if(increaseFlag){
            double newHeight = stickRct.getHeight() + 10;
            double newY = stickRct.getY() - 10;
            stickRct.setHeight(newHeight);
            stickRct.setY(newY);
        }
    }

    public boolean flip_flag = true;

    public void collision(){

    }

    private boolean aKeyPressed = false;

    private void handleKeyPressed(KeyEvent keyEvent) {
        KeyCode code = keyEvent.getCode();
        pressedKeys.add(keyEvent.getCode());

        if (code.equals(KeyCode.A)) {
            tryIncrease();
        }
        else if (code.equals(KeyCode.SPACE)) {
            tryFlip();
        }

        if(code.equals(KeyCode.S)){
            saveDetails progress = new saveDetails(collectedCherryCount, score, pillar1.getWidth(), pillar1.getLayoutX(), pillar2.getWidth(), pillar2.getLayoutX());
            try {
                serialize(progress);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Text save_t = new Text("Saved !");
            save_t.setLayoutX(170);
            save_t.setLayoutY(180);
            Font customFont2 = Font.loadFont(getClass().getResourceAsStream("/com/example/stickhero/kamikaze.3d-gradient-italic.ttf"), 24);
            save_t.setFont(customFont2);
            save_t.setFill(Color.BLACK);
            scenePane.getChildren().add(save_t);

            HelloController hc = new HelloController();


        }
    }

    public boolean collided = false;










    private void handleKeyReleased(KeyEvent keyEvent) {
        cherrylock = true;
        KeyCode code = keyEvent.getCode();
        pressedKeys.remove(code);
        if (code == KeyCode.A && game_lock) {
            scale.stop();
            flag = false;
            increaseFlag = false;
            game_lock = false;

            try_rotate();
            System.out.println("oye");
            PauseTransition pause = new PauseTransition(Duration.seconds(1.4));
            pause.setOnFinished(event -> {

                if (stickRct.getHeight() + stickRct.getLayoutX() >= pillar2.getLayoutX()-5 && stickRct.getHeight() + stickRct.getLayoutX() <= pillar2.getLayoutX() + pillar2.getWidth()) {
                    score++;
                    stickFell = true;
                    validStick = stickRct.getHeight() + stickRct.getLayoutX() >= pillar2.getLayoutX() && stickRct.getHeight() + stickRct.getLayoutX() <= pillar2.getLayoutX() + pillar2.getWidth();

                    counter.setText(String.valueOf(score));


                    timeline2 = new Timeline();
                    pillar3 = generateNewPillar3();
                    tempCherry  = generateCherry();
                    System.out.println("Cherry opacity - "+cherryImageView.getOpacity());
//
//                    System.out.println("before1 - "+stickmanImageView.getLayoutX());
//                    System.out.println("before2 - "+pillar1.getLayoutX());
//                    System.out.println("before3 - "+pillar2.getLayoutX());
//                    System.out.println("before4 - "+pillar3.getLayoutX());

//                    KeyFrame k1  = new KeyFrame(Duration.ZERO, new KeyValue(stickmanImageView.layoutXProperty(), stickmanImageView.getX()));
                    double p1 = pillar1.getLayoutX();
                    double p2 = pillar2.getBoundsInParent().getMinX();
                    double p3 = pillar3.getLayoutX();
                    double stm = stickmanImageView.getLayoutX();
                    double shm = stickmanImageview.getLayoutX();

                    double inc = cherryImageView.getLayoutX();


//                    KeyFrame k61  = new KeyFrame(Duration.seconds(1.2), new KeyValue(tempCherry.layoutXProperty(), tempCherry.getLayoutX()));
                    KeyFrame k62  = new KeyFrame(Duration.seconds(2), new KeyValue(tempCherry.layoutXProperty(), generateRandomNumber(pillar1.getBoundsInParent().getMaxX()+cherryImageView.getFitWidth(),pillar2.getBoundsInParent().getMinX()-cherryImageView.getFitWidth())));
//                    KeyFrame k63  = new KeyFrame(Duration.seconds(1.2), new KeyValue(cherryImageView.layoutXProperty(), cherryImageView.getLayoutX()));
                    KeyFrame k64  = new KeyFrame(Duration.seconds(2), new KeyValue(cherryImageView.layoutXProperty(),-200));



                    KeyFrame k6 =  new KeyFrame(Duration.seconds(1.2), new KeyValue(stickmanImageView.layoutXProperty(), pillar2.getBoundsInParent().getMaxX() - stickmanImageView.getFitWidth()));
                    KeyFrame k10  = new KeyFrame(Duration.seconds(2), new KeyValue(stickmanImageView.layoutXProperty(), pillar2.getWidth()-stickmanImageView.getFitWidth()-5));

                    KeyFrame k06 =  new KeyFrame(Duration.seconds(1.2), new KeyValue(stickmanImageview.layoutXProperty(), pillar2.getBoundsInParent().getMaxX() - stickmanImageview.getFitWidth()));
                    KeyFrame k100  = new KeyFrame(Duration.seconds(2), new KeyValue(stickmanImageview.layoutXProperty(), pillar2.getWidth()-stickmanImageview.getFitWidth()-5));

                    Timeline tt = new Timeline();
                    tt.getKeyFrames().addAll(k06,k100);
                    KeyFrame k11  = new KeyFrame(Duration.seconds(2), new KeyValue(stickRct.layoutXProperty(), p1-stickRct.getHeight()));

                    KeyFrame k7  = new KeyFrame(Duration.seconds(2), new KeyValue(pillar1.layoutXProperty(),-200));
                    KeyFrame k8  = new KeyFrame(Duration.seconds(2), new KeyValue(pillar2.layoutXProperty(), 0));
                    KeyFrame k9  = new KeyFrame(Duration.seconds(2), new KeyValue(pillar3.layoutXProperty(), p2 ));
                    if (pillar2HasCherry == 1) {
                        KeyFrame kCherry = new KeyFrame(Duration.seconds(1.2), new KeyValue(cherryImageView.layoutXProperty(), cherryImageView.getLayoutX()));
                        KeyFrame kCherry2 = new KeyFrame(Duration.seconds(2), new KeyValue(cherryImageView.layoutXProperty(),generateRandomNumber(pillar1.getBoundsInParent().getMaxX(),pillar2.getBoundsInParent().getMinX())));
                        timeline2.getKeyFrames().add(kCherry);
                        timeline2.getKeyFrames().add(kCherry2);


//                        timeline2.getKeyFrames().add(chkCollision);
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
                        pillar1 = pillar2;
                        pillar2 = pillar3;
                        canRotate = true;
                        stickRct = generate_stick();
                        increaseFlag = true;
                        game_lock = true;


                    });




                    collisionCheckTimeline = new Timeline(
                            new KeyFrame(Duration.millis(8), wi -> {
//                                System.out.println("Checking for collision");
//                                System.out.println("is flipped -  "+ isFlipped);
                                Bounds cherryBounds = cherryImageView.getBoundsInParent();
                                Bounds p2b= pillar2.getBoundsInParent();

                                if (stickmanImageView.getBoundsInParent().getMaxX()>= p2b.getMinX() && !flip_flag){

                                    timeline3.stop();
                                    timeline2.stop();
//                                    stickmanImageView.setLayoutX(pillar2.getBoundsInParent().getMinX()-stickmanImageView.getFitWidth());

                                    double xx = stickmanImageView.getLayoutX();
                                    System.out.println("x2 layout - "+pillar2.getLayoutX());
                                    Timeline endl = new Timeline();
                                    KeyFrame kk2 = new KeyFrame(Duration.ZERO,new KeyValue(stickmanImageView.xProperty(),stickmanImageView.getLayoutX()));
                                    KeyFrame kk3 = new KeyFrame(Duration.seconds(2),new KeyValue(stickmanImageView.yProperty(),800));
                                    endl.getKeyFrames().addAll(kk2,kk3);


                                    TranslateTransition fall = new TranslateTransition(Duration.seconds(1),stickmanImageView);
                                    stickmanImageView.setLayoutX(xx);
                                    stickmanImageView.setX(pillar2.getBoundsInParent().getMinX()-pillar2.getWidth());
                                    fall.setToY(800);

                                    fall.play();
                                    fall.setOnFinished(oi->{
                                        try {
                                            end();
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                    });


//                                    ended.play();
                                    collisionCheckTimeline.stop();


                                }
                                if (stickmanImageView.getLayoutX() <= cherryBounds.getMaxX() && stickmanImageView.getLayoutX() >= cherryBounds.getMinX()&& isFlipped) {
                                    System.out.println("Collision out");
                                    if(cherrylock){
                                        System.out.println("Collision in");

                                        collectedCherryCount++;
                                        cherrylock = false;
                                        cherryIncremented = true;
                                        stickmanIsFlipped = isFlipped;
                                        stickmanIntersects = stickmanImageView.getLayoutX() <= cherryBounds.getMaxX() && stickmanImageView.getLayoutX() >= cherryBounds.getMinX()&& isFlipped;
                                        boolean stickfigintersects = stickmanImageview.getLayoutX() <= cherryBounds.getMaxX() && stickmanImageview.getLayoutX() >= cherryBounds.getMinX()&& isFlipped;

                                        cherryText.setText(String.valueOf(collectedCherryCount));
                                        scenePane.getChildren().remove(cherryImageView);
                                    }
                                    System.out.println("after - "+collectedCherryCount);

                                }
                            })
                    );





                    collisionCheckTimeline.setCycleCount(Timeline.INDEFINITE);
                    collisionCheckTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(8)));
                    collisionCheckTimeline.play();
                    timeline3 = new Timeline();


                    timeline3.getKeyFrames().add(k6);
                    flip_allow = true;
                    timeline3.play();

                    timeline3.setOnFinished(opi->{
                        collisionCheckTimeline.stop();
                        flip_allow = false;
                        timeline2.play();
                    });
                }

                else
                {
                    try {
                        end();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            });
            pause.play();

        }

    }


    private static void serialize(saveDetails info) throws IOException{
        ObjectOutputStream out = null;
        try{
            System.out.println(info);
            out = new ObjectOutputStream(new FileOutputStream("saveProgressNew.txt"));
            out.writeObject(info);
        }finally {
            out.close();
        }
    }

    public static void deserialize(String progressFile) throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
//        ObjectOutputStream out  = null;

        try {
            in = new ObjectInputStream (
                    new FileInputStream(progressFile));
            saveDetails s1 = (saveDetails) in.readObject();
            System.out.println(s1);
        } finally {
            in.close();
        }
    }


    private static int cherryOccurs() {
        Random random = new Random();
        return random.nextInt(2);
    }

    public static void writeScore(int x) throws IOException {

        PrintWriter fww = new PrintWriter((new FileWriter("/Users/arnavshukla/Desktop/newProj/src/main/java/com/example/stickhero/highscore.txt")));
        String s = String.valueOf(x);
        fww.write(s +" ");
        fww.close();



    }

    private static Map<Double,Rectangle> pillarr_arrlist = new HashMap<>();

    private Rectangle generateNewPillar3() {
        double width = generateRandomNumber(70, 100);
        if(!pillarr_arrlist.containsKey(width)){
            Rectangle pp = new Rectangle(generateRandomNumber(70, 100), 200, Color.BLACK);
            pp.setLayoutX(440 + pp.getWidth());
            pp.setLayoutY(500);
            pillarr_arrlist.put(width,pp);

        }
        Rectangle rectangle = pillarr_arrlist.get(width);
        rectangle.setLayoutX(440 + rectangle.getWidth());
        rectangle.setLayoutY(500);

        scenePane.getChildren().add(rectangle);

        return rectangle;

    }


    ImageView generateCherry(){
        Image ci = new Image(getClass().getResourceAsStream("590774.png"));
        ImageView temp = new ImageView(ci);
        double x = generateRandomNumber(0,2);
        if(x>1){
            temp.setOpacity(1);
        }else{
            temp.setOpacity(1);
        }

        temp.setFitHeight(30);
        temp.setFitWidth(30);
        temp.setLayoutX(500);
        temp.setLayoutY(pillar2.getLayoutY()+10);
        scenePane.getChildren().add(temp);

        cherryLocations.add(temp.getLayoutX());
        return temp;

    }

    ImageView generateCherry2(){
        Image ci = new Image(getClass().getResourceAsStream("590774.png"));
        ImageView temp = new ImageView(ci);


        temp.setFitHeight(30);
        temp.setFitWidth(30);
        temp.setLayoutX(generateRandomNumber(pillar1.getBoundsInParent().getMaxX()+10, pillar2.getBoundsInParent().getMinX()-20));
        temp.setLayoutY(pillar2.getLayoutY()- cherryImageView.getFitHeight()+10);
        scenePane.getChildren().add(temp);

        cherryLocations.add(temp.getLayoutX());
        return temp;

    }

    private Rectangle generate_stick(){
        stickRct = new Rectangle(5, 1, Color.BLACK);
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
    public static int readHighScore(int score) throws FileNotFoundException {
        Scanner in2 = new Scanner(new BufferedInputStream(new FileInputStream("/Users/arnavshukla/Desktop/newProj/src/main/java/com/example/stickhero/highscore.txt")));
        ArrayList<Integer> int_arr2 = new ArrayList<>();
        while(in2.hasNext()){
            int y = Integer.parseInt(in2.next());
            int_arr2.add(y);
        }
        System.out.println(int_arr2);

        return int_arr2.get(0);
    }

    public static void main(String[] args) throws IOException {
        readHighScore(5);
        readHighScore(7);
        MusicPlayer player = new MusicPlayer();

//        Song1Player song1Player = new Song1Player(player);

        Thread music_t = new Thread(player);
        music_t.start();
        launch(args);
    }

    public void end() throws IOException {
        int x = readHighScore(5);
        {



            if(score>readHighScore(1)){
                writeScore(score);
            }

            SaveCurrState.r1 = pillar1;
            SaveCurrState.r2 = pillar2;
            SaveCurrState.score = score;

            timeline4 = new Timeline();
            KeyFrame k2  = new KeyFrame(Duration.seconds(2), new KeyValue(stickmanImageView.layoutXProperty(), stickmanImageView.getX()+stickRct.getBoundsInParent().getMaxX()-10));
            KeyFrame k3  = new KeyFrame(Duration.seconds(2), new KeyValue(stickmanImageView.layoutYProperty(), stickmanImageView.getLayoutY()));
            KeyFrame k4  = new KeyFrame(Duration.seconds(4), new KeyValue(stickmanImageView.layoutYProperty(), stickmanImageView.getLayoutY()+500));
            KeyFrame k222  = new KeyFrame(Duration.seconds(2), new KeyValue(stickmanImageview.layoutXProperty(), stickmanImageview.getX()+stickRct.getBoundsInParent().getMaxX()-10));
            KeyFrame k333  = new KeyFrame(Duration.seconds(2), new KeyValue(stickmanImageview.layoutYProperty(), stickmanImageview.getLayoutY()));
            KeyFrame k444  = new KeyFrame(Duration.seconds(4), new KeyValue(stickmanImageview.layoutYProperty(), stickmanImageview.getLayoutY()+500));
//                    timeline4.getKeyFrames().add(k1);
            timeline4.getKeyFrames().add(k2);
            timeline4.getKeyFrames().add(k3);
            timeline4.getKeyFrames().add(k4);
            timeline4.play();
            timeline4.setOnFinished(oo->{

                //game over text
                Text goText = new Text("Game Over!");
                goText.setLayoutX(75);
                goText.setLayoutY(150);

                // Load the font
                Font customFont = Font.loadFont(getClass().getResourceAsStream("/com/example/stickhero/kamikaze.3d-gradient-italic.ttf"), 48);
                goText.setFont(customFont);
                goText.toFront();
                goText.setFill(Color.BLACK);

                scenePane.getChildren().add(goText);

                Text hs = new Text("Highest Score: "+x);
                hs.setLayoutX(100);
                hs.setLayoutY(480);
                Font customFont5 = Font.loadFont(getClass().getResourceAsStream("/com/example/stickhero/kamikaze.3d-gradient-italic.ttf"), 24);
                hs.setFont(customFont5);
                hs.setFill(Color.BLACK);
                scenePane.getChildren().add(hs);

                Button button1 = new Button();
                Image retryIm = null;


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
                Image irev = new Image(getClass().getResourceAsStream("moye.png"));
                ImageView iv5 = new ImageView(irev);
                iv5.setLayoutY(200);
                iv5.setLayoutX(200);
                iv5.setFitHeight(47.0);
                iv5.setFitWidth(47.0);
                scenePane.getChildren().add(iv5);

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

                    saveDetails progress = new saveDetails(collectedCherryCount, score, pillar1.getWidth(), pillar1.getLayoutX(), pillar2.getWidth(), pillar2.getLayoutX());
                    try {
                        serialize(progress);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    Text save_t = new Text("Saved !");
                    save_t.setLayoutX(170);
                    save_t.setLayoutY(180);
                    Font customFont2 = Font.loadFont(getClass().getResourceAsStream("/com/example/stickhero/kamikaze.3d-gradient-italic.ttf"), 24);
                    save_t.setFont(customFont2);
                    save_t.setFill(Color.BLACK);
                    scenePane.getChildren().add(save_t);
                });


                iv4.setOnMouseClicked(goHomeEvent ->{
                    HelloController hc = new HelloController();
                    try {
                        hc.toHomeScreen(goHomeEvent);
                    } catch (IOException | gameNotFoundError e) {
                        throw new RuntimeException(e);
                    }
                });

                iv5.setOnMouseClicked(revival -> {
                    if(collectedCherryCount >= 3){
                        collectedCherryCount = collectedCherryCount -3;
                        progress = new saveDetails(collectedCherryCount, score, pillar1.getWidth(), pillar1.getLayoutX(), pillar2.getWidth(), pillar2.getLayoutX());
                        try {
                            serialize(progress);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        ObjectInputStream in = null;

                        try {
                            in = new ObjectInputStream (
                                    new FileInputStream("saveProgressNew.txt"));
                            saveDetails s1 = (saveDetails) in.readObject();

                            reloadFlag = 1;
                            saveCurrState = s1;
                            start(myStage);

                            //if stickman is flipped flip again
                            if(isFlipped == true){
                                isFlipped = false;
                            }

                            System.out.println(s1);
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        } finally {
                            try {
                                assert in != null;
                                in.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }else {
                        Text revf = new Text("Insufficient cherries !");
                        revf.setLayoutX(80);
                        revf.setLayoutY(180);
                        Font customFont2 = Font.loadFont(getClass().getResourceAsStream("/com/example/stickhero/kamikaze.3d-gradient-italic.ttf"), 20);
                        revf.setFont(customFont2);
                        revf.setFill(Color.BLACK);
                        scenePane.getChildren().add(revf);
                    }
                });
                scenePane.getChildren().addAll(rimv, rimv2, rimv3);
            });
        }
    }
}




class saveDetails implements Serializable {
    public int cherryCount;
    public int score;
    public double standingPillarWidth;
    public double standingPillarX;
    public double nextPillarWidth;
    public double nextPillarX;

    @Override
    public String toString() {
        return "\nsaveDetails{" +
                "cherryCount=" + cherryCount +
                ", score=" + score +
                ", standingPillarWidth=" + standingPillarWidth +
                ", standingPillarX=" + standingPillarX +
                ", nextPillarWidth=" + nextPillarWidth +
                ", nextPillarX=" + nextPillarX +
                "\n}";
    }

    public saveDetails(int cherryCount, int score, double standingPillarWidth, double standingPillarX, double nextPillarWidth, double nextPillarX) {
        this.cherryCount = cherryCount;
        this.score = score;
        this.standingPillarWidth = standingPillarWidth;
        this.standingPillarX = standingPillarX;
        this.nextPillarWidth = nextPillarWidth;
        this.nextPillarX = nextPillarX;
    }
}


class SaveCurrState {

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