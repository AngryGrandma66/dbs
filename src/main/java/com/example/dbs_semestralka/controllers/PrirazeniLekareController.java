package com.example.dbs_semestralka.controllers;

import com.example.dbs_semestralka.service.NemocniceService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrirazeniLekareController {
    @FXML private TextField navstevaIdField;
    @FXML private TextField lekarIdField;

    private final NemocniceService service = new NemocniceService();

    @FXML
    private void handlePrirazeniLekare() {
        int navstevaId = Integer.parseInt(navstevaIdField.getText());
        int lekarId   = Integer.parseInt(lekarIdField.getText());
        service.pridejLekareNaNavstevu(navstevaId, lekarId);
        navstevaIdField.clear(); lekarIdField.clear();
    }
}