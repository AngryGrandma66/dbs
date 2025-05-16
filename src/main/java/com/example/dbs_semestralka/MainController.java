package com.example.dbs_semestralka;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Objects;

public class MainController {
    @FXML
    private BorderPane root;

    private void loadCenter(String fxmlPath) {
        try {
            Node content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlPath)));
            root.setCenter(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showRegistracePacienta() {
        loadCenter("/com/example/dbs_semestralka/registracePacienta.fxml");
    }

    @FXML
    private void showNovaNavsteva() {
        loadCenter("/com/example/dbs_semestralka/novaNavsteva.fxml");
    }

    @FXML
    private void showPrirazeniLekare() {
        loadCenter("/com/example/dbs_semestralka/prirazeniLekare.fxml");
    }

    @FXML
    private void showAktualizace() {
        loadCenter("/com/example/dbs_semestralka/aktualizace.fxml");
    }

    @FXML
    private void showRecept() {
        loadCenter("/com/example/dbs_semestralka/recept.fxml");
    }
    @FXML
    public void showPacientiNavstevy() {
        loadCenter("/com/example/dbs_semestralka/pacientiNavstevy.fxml");
    }
}
