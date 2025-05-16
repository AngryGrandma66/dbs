package com.example.dbs_semestralka.controllers;

import com.example.dbs_semestralka.dto.DiagnostikaPacientKardiologieRow;
import com.example.dbs_semestralka.service.NemocniceService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class PacientiKardiologieController {
    @FXML private TableView<DiagnostikaPacientKardiologieRow> table;
    @FXML private TableColumn<DiagnostikaPacientKardiologieRow, String> colPacJmeno;
    @FXML private TableColumn<DiagnostikaPacientKardiologieRow, String> colPacPrijmeni;
    @FXML private TableColumn<DiagnostikaPacientKardiologieRow, String> colKod;
    @FXML private TableColumn<DiagnostikaPacientKardiologieRow, String> colPopis;
    @FXML private TableColumn<DiagnostikaPacientKardiologieRow, String> colLekJmeno;
    @FXML private TableColumn<DiagnostikaPacientKardiologieRow, String> colLekPrijmeni;

    private final NemocniceService service = new NemocniceService();

    @FXML
    public void initialize() {
        colPacJmeno   .setCellValueFactory(new PropertyValueFactory<>("pacientJmeno"));
        colPacPrijmeni.setCellValueFactory(new PropertyValueFactory<>("pacientPrijmeni"));
        colKod        .setCellValueFactory(new PropertyValueFactory<>("kod"));
        colPopis      .setCellValueFactory(new PropertyValueFactory<>("popis"));
        colLekJmeno   .setCellValueFactory(new PropertyValueFactory<>("lekarJmeno"));
        colLekPrijmeni.setCellValueFactory(new PropertyValueFactory<>("lekarPrijmeni"));

        List<DiagnostikaPacientKardiologieRow> data =
                service.getPacientiDiagnozyKardiologie();
        table.setItems(FXCollections.observableArrayList(data));
    }
}
