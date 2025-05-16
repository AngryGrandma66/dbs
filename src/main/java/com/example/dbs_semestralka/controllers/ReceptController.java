package com.example.dbs_semestralka.controllers;

import com.example.dbs_semestralka.model.Recept;
import com.example.dbs_semestralka.service.NemocniceService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ReceptController {
    @FXML private TextField navstevaIdField;
    @FXML private TextField nazevLekuField;
    @FXML private TextField davkovaniField;

    private final NemocniceService service = new NemocniceService();

    @FXML
    private void handleVytvorRecept() {
        Recept r = new Recept();
        r.setIdNavsteva(service.najdiNavstevu(Integer.parseInt(navstevaIdField.getText())));
        r.setNazevLeku(nazevLekuField.getText());
        r.setDavkovani(davkovaniField.getText());
        service.vytvorRecept(r);
        navstevaIdField.clear(); nazevLekuField.clear(); davkovaniField.clear();
    }
}