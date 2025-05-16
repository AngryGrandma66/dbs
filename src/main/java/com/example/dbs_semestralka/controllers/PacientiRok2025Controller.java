package com.example.dbs_semestralka.controllers;

import com.example.dbs_semestralka.dto.PacientRokRow;
import com.example.dbs_semestralka.service.NemocniceService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PacientiRok2025Controller {
    @FXML private TableView<PacientRokRow> table;
    @FXML private TableColumn<PacientRokRow, String> colJmeno;
    @FXML private TableColumn<PacientRokRow, String> colPrijmeni;
    @FXML private TableColumn<PacientRokRow, String> colPojistka;

    private final NemocniceService service = new NemocniceService();

    @FXML
    public void initialize() {
        colJmeno   .setCellValueFactory(new PropertyValueFactory<>("jmeno"));
        colPrijmeni.setCellValueFactory(new PropertyValueFactory<>("prijmeni"));
        colPojistka.setCellValueFactory(new PropertyValueFactory<>("cisloPojistence"));

        // rok 2025
        var data = service.getPacientiByYear(2025);
        table.setItems(FXCollections.observableArrayList(data));
    }
}
