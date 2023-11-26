package com.example.stickhero;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.input.*;
import javafx.scene.paint.*;
public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Rectangle rct;


//    public void switchToScene1(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

    private Rectangle rotatingRectangle;

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("play_menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        // Initialize the rotatingRectangle
        rotatingRectangle = new Rectangle(50, 50, Color.BLUE); // You can customize the size and color

        // Add the rotatingRectangle to the root
        ((Parent) scene.getRoot()).getChildrenUnmodifiable().add(rotatingRectangle);

        // Set up a listener for key events
        scene.setOnKeyPressed(this::handleKeyPress);

        stage.setScene(scene);
        stage.show();
    }

    // Method to handle key presses
    private void handleKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.SPACE) {
            // Increase the length of the rectangle
            rotatingRectangle.setWidth(rotatingRectangle.getWidth() + 10);

            // Rotate the rectangle clockwise from its base
            rotatingRectangle.setRotate(rotatingRectangle.getRotate() + 10); // You can adjust the rotation angle
        }
    }
}