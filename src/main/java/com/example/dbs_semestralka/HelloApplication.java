package com.example.dbs_semestralka;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // 1) Use an absolute path from the root of the classpath:
        URL fxmlUrl = getClass().getResource("/com/example/dbs_semestralka/mainView.fxml");
        if (fxmlUrl == null) {
            throw new RuntimeException("Cannot load FXML: /com/example/dbs_semestralka/mainView.fxml not found on classpath");
        }

        Parent root = FXMLLoader.load(fxmlUrl);
        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("DBS Semestrálka");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}