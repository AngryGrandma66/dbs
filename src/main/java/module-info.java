module com.example.dbs_semestralka {
    opens com.example.dbs_semestralka to javafx.fxml;
    opens com.example.dbs_semestralka.controllers to javafx.fxml;
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
}