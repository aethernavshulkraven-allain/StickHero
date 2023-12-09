package com.example.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void toHomeScreen(MouseEvent event) throws IOException, gameNotFoundError {
        Parent root = FXMLLoader.load(getClass().getResource("homeScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toLoadGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loadGame.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toGameplay(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Start2 gcontroller = new Start2();

        gcontroller.start(stage);

    }

    public void deserialize1(ActionEvent event) throws IOException, ClassNotFoundException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        String progressFile = "saveProgress.txt";
        ObjectInputStream in = null;
//        ObjectOutputStream out  = null;

        try {
            in = new ObjectInputStream (
                    new FileInputStream(progressFile));
            saveDetails s1 = (saveDetails) in.readObject();

            Start2 p1 = new Start2();
            p1.setReloadFlag(1);
            p1.setSaveCurrState(s1);
            p1.start(stage);

//            System.out.println(s1);
        } finally {
            in.close();
        }
    }
    public void deserialize2(ActionEvent event) throws IOException, ClassNotFoundException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        String progressFile = "saveProgress2.txt";
        ObjectInputStream in = null;
//        ObjectOutputStream out  = null;

        try {
            in = new ObjectInputStream (
                    new FileInputStream(progressFile));
            saveDetails s1 = (saveDetails) in.readObject();

            Start2 p1 = new Start2();
            p1.setReloadFlag(1);
            p1.setSaveCurrState(s1);
            p1.start(stage);

//            System.out.println(s1);
        } finally {
            in.close();
        }
    }
    public void deserialize3(ActionEvent event) throws IOException, ClassNotFoundException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        String progressFile = "saveProgress1.txt";
        ObjectInputStream in = null;
//        ObjectOutputStream out  = null;

        try {
            in = new ObjectInputStream (
                    new FileInputStream(progressFile));
            saveDetails s1 = (saveDetails) in.readObject();

            Start2 p1 = new Start2();
            p1.setReloadFlag(1);
            p1.setSaveCurrState(s1);
            p1.start(stage);

//            System.out.println(s1);
        } finally {
            in.close();
        }
    }

    public void deserializeLast(ActionEvent event) throws IOException, ClassNotFoundException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        String progressFile = "saveProgressNew.txt";
        ObjectInputStream in = null;
//        ObjectOutputStream out  = null;

        try {
            in = new ObjectInputStream (
                    new FileInputStream(progressFile));
            saveDetails s1 = (saveDetails) in.readObject();

            Start2 p1 = new Start2();
            p1.setReloadFlag(1);
            p1.setSaveCurrState(s1);
            p1.start(stage);

//            System.out.println(s1);
        } finally {
            in.close();
        }
    }
}
