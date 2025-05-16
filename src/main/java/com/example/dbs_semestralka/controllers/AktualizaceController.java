package com.example.dbs_semestralka.controllers;

import com.example.dbs_semestralka.service.NemocniceService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AktualizaceController {
    @FXML private Button updateButton;
    private final NemocniceService service = new NemocniceService();

    @FXML
    private void handleAktualizace() {
        service.aktualizujLekareADiagnostiku();
    }
}