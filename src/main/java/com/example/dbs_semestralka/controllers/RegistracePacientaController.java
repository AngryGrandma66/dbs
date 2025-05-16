package com.example.dbs_semestralka.controllers;
import com.example.dbs_semestralka.model.Pacient;
import com.example.dbs_semestralka.service.NemocniceService;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegistracePacientaController {
    @FXML private TextField jmenoField;
    @FXML private TextField prijmeniField;
    @FXML private DatePicker datumNarozeniPicker;
    @FXML private TextField adresaField;
    @FXML private TextField telefonField;
    @FXML private TextField cisloPojistenceField;
    @FXML private TextField rodneCisloField;

    private final NemocniceService service = new NemocniceService();

    @FXML
    private void handleRegistracePacienta() {
        Pacient p = new Pacient();
        p.setJmeno(jmenoField.getText());
        p.setPrijmeni(prijmeniField.getText());
        p.setDatumNarozeni(datumNarozeniPicker.getValue());
        p.setAdresa(adresaField.getText());
        p.setTelefon(telefonField.getText());
        p.setCisloPojistence(cisloPojistenceField.getText());
        p.setRodneCislo(rodneCisloField.getText());
        service.registrujPacienta(p);
        clearFields();
    }

    private void clearFields() {
        jmenoField.clear(); prijmeniField.clear(); adresaField.clear(); telefonField.clear();
        cisloPojistenceField.clear(); rodneCisloField.clear(); datumNarozeniPicker.setValue(null);
    }
}