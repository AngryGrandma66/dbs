package com.example.dbs_semestralka.controllers;


import com.example.dbs_semestralka.model.Navsteva;
import com.example.dbs_semestralka.service.NemocniceService;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class NovaNavstevaController {
    @FXML private TextField pacientIdField;
    @FXML private DatePicker datumNavstevyPicker;
    @FXML private TextField typNavstevyField;
    @FXML private TextArea zpravaArea;

    private final NemocniceService service = new NemocniceService();

    @FXML
    private void handleNovaNavsteva() {
        Navsteva n = new Navsteva();
        n.setIdPacient(service.najdiPacienta(Integer.parseInt(pacientIdField.getText())));
        n.setDatum(datumNavstevyPicker.getValue().atStartOfDay().atOffset(java.time.ZoneOffset.UTC));
        n.setTyp(typNavstevyField.getText());
        n.setLekarskaZprava(zpravaArea.getText());
        service.vytvorNavstevu(n);
        clearFields();
    }

    private void clearFields() {
        pacientIdField.clear(); datumNavstevyPicker.setValue(null); typNavstevyField.clear(); zpravaArea.clear();
    }
}
