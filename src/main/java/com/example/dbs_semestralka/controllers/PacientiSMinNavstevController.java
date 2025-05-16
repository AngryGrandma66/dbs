package com.example.dbs_semestralka.controllers;

import com.example.dbs_semestralka.dto.PacientNavstevCountRow;
import com.example.dbs_semestralka.service.NemocniceService;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class PacientiSMinNavstevController {
    @FXML private TableView<PacientNavstevCountRow> table;
    @FXML private TableColumn<PacientNavstevCountRow, String> colJmeno;
    @FXML private TableColumn<PacientNavstevCountRow, String> colPrijmeni;
    @FXML private TableColumn<PacientNavstevCountRow, Number> colPocetNavstev;

    private final NemocniceService service = new NemocniceService();

    @FXML
    public void initialize() {
        colJmeno      .setCellValueFactory(c -> new SimpleStringProperty( c.getValue().getJmeno()));
        colPrijmeni   .setCellValueFactory(c -> new SimpleStringProperty( c.getValue().getPrijmeni()));
        colPocetNavstev.setCellValueFactory(c -> new SimpleLongProperty(  c.getValue().getPocetNavstev()));

        // zobrazíme jen ty s min. 2 návštěvami
        List<PacientNavstevCountRow> rows = service.getPacientiSMinNavstev(2);
        table.setItems(FXCollections.observableArrayList(rows));
    }
}
