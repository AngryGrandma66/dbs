package com.example.dbs_semestralka.controllers;

import com.example.dbs_semestralka.dto.NavstevyPacientLekarRow;
import com.example.dbs_semestralka.service.NemocniceService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class KontrolaNavstevController {
    @FXML private TableView<NavstevyPacientLekarRow> table;
    @FXML private TableColumn<NavstevyPacientLekarRow, Integer>       colNavId;
    @FXML private TableColumn<NavstevyPacientLekarRow, java.time.OffsetDateTime> colNavDatum;
    @FXML private TableColumn<NavstevyPacientLekarRow, String>        colPacJmeno;
    @FXML private TableColumn<NavstevyPacientLekarRow, String>        colPacPrijmeni;
    @FXML private TableColumn<NavstevyPacientLekarRow, String>        colLekJmeno;
    @FXML private TableColumn<NavstevyPacientLekarRow, String>        colLekPrijmeni;

    private final NemocniceService service = new NemocniceService();

    @FXML
    public void initialize() {
        colNavId       .setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getNavstevaId()));
        colNavDatum    .setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getDatumNavstevy()));
        colPacJmeno    .setCellValueFactory(c -> new SimpleStringProperty(     c.getValue().getPacientJmeno()));
        colPacPrijmeni .setCellValueFactory(c -> new SimpleStringProperty(     c.getValue().getPacientPrijmeni()));
        colLekJmeno    .setCellValueFactory(c -> new SimpleStringProperty(     c.getValue().getLekarJmeno()));
        colLekPrijmeni .setCellValueFactory(c -> new SimpleStringProperty(     c.getValue().getLekarPrijmeni()));

        List<NavstevyPacientLekarRow> rows = service.getKontrolniNavstevy();
        table.setItems(FXCollections.observableArrayList(rows));
    }
}
