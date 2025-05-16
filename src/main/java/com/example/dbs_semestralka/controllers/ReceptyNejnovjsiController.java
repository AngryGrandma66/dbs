package com.example.dbs_semestralka.controllers;

import com.example.dbs_semestralka.dto.ReceptLatestRow;
import com.example.dbs_semestralka.service.NemocniceService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class ReceptyNejnovjsiController {
    @FXML private TableView<ReceptLatestRow> table;
    @FXML private TableColumn<ReceptLatestRow, Number>        colReceptId;
    @FXML private TableColumn<ReceptLatestRow, String>        colNazevLeku;
    @FXML private TableColumn<ReceptLatestRow, String>        colDavkovani;
    @FXML private TableColumn<ReceptLatestRow, OffsetDateTime> colDatumNavstevy;

    private final NemocniceService service = new NemocniceService();

    @FXML
    public void initialize() {
        colReceptId      .setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getReceptId()));
        colNazevLeku     .setCellValueFactory(c -> new SimpleStringProperty( c.getValue().getNazevLeku()));
        colDavkovani     .setCellValueFactory(c -> new SimpleStringProperty( c.getValue().getDavkovani()));
        colDatumNavstevy .setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getDatumNavstevy()));

        // od 1.1.2024
        OffsetDateTime since = OffsetDateTime.of(2024,1,1,0,0,0,0, ZoneOffset.UTC);
        List<ReceptLatestRow> rows = service.getLatestRecepty(since);
        table.setItems(FXCollections.observableArrayList(rows));
    }
}
