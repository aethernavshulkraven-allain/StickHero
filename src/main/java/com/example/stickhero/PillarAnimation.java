package com.example.stickhero;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PillarAnimation extends Application {

    private static final double PILLAR_WIDTH = 50;
    private static final double PILLAR_HEIGHT = 200;
    private static final double ANIMATION_DURATION = 1.0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        Rectangle pillar1 = createPillar(50, 50);
        Rectangle pillar2 = createPillar(200, 50);

        Button animateButton = new Button("Animate");
        animateButton.setOnAction(event -> animatePillars(pillar1, pillar2, root));

        root.getChildren().addAll(pillar1, pillar2, animateButton);

        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.setTitle("Pillar Animation");
        primaryStage.show();
    }

    private Rectangle createPillar(double x, double y) {
        Rectangle pillar = new Rectangle(x, y, PILLAR_WIDTH, PILLAR_HEIGHT);
        pillar.setFill(Color.BLUE);
        return pillar;
    }

    private void animatePillars(Rectangle pillar1, Rectangle pillar2, Pane root) {
        TranslateTransition transitionPillar1 = createTranslateTransition(pillar1, -PILLAR_WIDTH);
        TranslateTransition transitionPillar2 = createTranslateTransition(pillar2, -PILLAR_WIDTH);

        transitionPillar1.play();
        transitionPillar2.play();

        transitionPillar2.setOnFinished(e -> {
            // Remove pillar2 from the root
            root.getChildren().remove(pillar2);

            // Create and add a new pillar (pillar3) at the original position of pillar2
            Rectangle pillar3 = createPillar(200, 50);
            root.getChildren().add(pillar3);

            // Start the animation for pillar3 to move it to the position of pillar1
            TranslateTransition transitionPillar3 = createTranslateTransition(pillar3, 50);
            transitionPillar3.play();
        });
    }

    private TranslateTransition createTranslateTransition(Rectangle pillar, double targetX) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(ANIMATION_DURATION), pillar);
        transition.setToX(targetX);
        return transition;
    }

}
