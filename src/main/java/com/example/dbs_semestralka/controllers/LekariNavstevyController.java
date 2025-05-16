package com.example.dbs_semestralka.controllers;

import com.example.dbs_semestralka.dto.LekarNavstevyRow;
import com.example.dbs_semestralka.service.NemocniceService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class LekariNavstevyController {
    @FXML private TableView<LekarNavstevyRow> table;
    @FXML private TableColumn<LekarNavstevyRow, String> colJmeno;
    @FXML private TableColumn<LekarNavstevyRow, String> colPrijmeni;
    @FXML private TableColumn<LekarNavstevyRow, Long>   colPocet;

    private final NemocniceService service = new NemocniceService();

    @FXML
    public void initialize() {
        colJmeno   .setCellValueFactory(new PropertyValueFactory<>("jmeno"));
        colPrijmeni.setCellValueFactory(new PropertyValueFactory<>("prijmeni"));
        colPocet   .setCellValueFactory(new PropertyValueFactory<>("pocetNavstev"));

        List<LekarNavstevyRow> data = service.getLekariNavstevyNadPrumerem();
        table.setItems(FXCollections.observableArrayList(data));
    }
}
