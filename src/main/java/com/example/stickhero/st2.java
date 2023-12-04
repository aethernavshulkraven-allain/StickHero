//package com.example.stickhero;
//
//import javafx.animation.TranslateTransition;
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//
//import java.util.Random;
//
//public class st2 extends Application {
//    public Rectangle p1, p2, sp1, sp2, pnew;
//
//    public TranslateTransition pillar1Transition = new TranslateTransition(Duration.seconds(2), sp1);
//    public TranslateTransition pillar2Transition = new TranslateTransition(Duration.seconds(2), sp2);
//    public TranslateTransition pillar3Transition = new TranslateTransition(Duration.seconds(2), pnew);
//
//    public static Pane scenePane;
//
//
//    @Override
//    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("play_menu3.fxml"));
//        scenePane = new Pane(root);
//
//        p1 = new Rectangle(generateRandomNumber(70, 100), 200, Color.RED);
//        p1.setLayoutX(0);
//        p1.setLayoutY(500);
//
//        p2 = new Rectangle(generateRandomNumber(70, 100), 200, Color.RED);
//        p2.setLayoutX(250);
//        p2.setLayoutY(500);
//
//        sp1 = p1;
//        sp2 = p2;
//
//        scenePane.getChildren().addAll(sp1, sp2);
//
//
//
//    }
//
//    public void action(){
//        for (int i = 0; i < 5; i++) {
//            pnew = generateNewPillar3();
//            pillar1Transition.setByX(-200);
//            double pnl = sp2.getLayoutX();
//            pillar2Transition.setByX(0);
//            pillar3Transition.setByX(pnl);
//
//
//        }
//    }
//
//    private Rectangle generateNewPillar3() {
//
//    Rectangle pp = new Rectangle(generateRandomNumber(70, 100), 200, Color.BLACK);
//    pp.setLayoutX(440+pp.getWidth());
//    pp.setLayoutY(500);
//    scenePane.getChildren().add(pp);//
//
//
//    return pp;
//
//    // Add the new pillar2 to the scene
//    }
//
//    private static double generateRandomNumber(double a, double b) {
//        Random random = new Random();
//
//        return random.nextDouble(b - a + 1) + a;
//    }
//}
