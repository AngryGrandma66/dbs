package com.example.dbs_semestralka.controllers;

import com.example.dbs_semestralka.service.NemocniceService;
import com.example.dbs_semestralka.dto.PacientiNavstevyRow;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.time.LocalDate;
import java.time.OffsetDateTime;

public class PacientiNavstevyController {
    @FXML private TableView<PacientiNavstevyRow> table;
    @FXML private TableColumn<PacientiNavstevyRow,String> colJmeno;
    @FXML private TableColumn<PacientiNavstevyRow,String> colPrijmeni;
    @FXML private TableColumn<PacientiNavstevyRow,LocalDate> colDatum;
    @FXML private TableColumn<PacientiNavstevyRow,Integer> colNavId;
    @FXML private TableColumn<PacientiNavstevyRow, OffsetDateTime> colNavDatum;

    private final NemocniceService service = new NemocniceService();

    @FXML
    private void initialize() {
        colJmeno.   setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getJmeno()));
        colPrijmeni.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPrijmeni()));
        colDatum.   setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getDatumNarozeni()));
        colNavId.   setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getNavstevaId()));
        colNavDatum.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getDatumNavstevy()));

        table.getItems().setAll(
                service.getPacientiNavstevy(LocalDate.of(1970,1,1))
        );
    }
}