module com.example.dbs_semestralka {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;


    opens com.example.dbs_semestralka to javafx.fxml;
    exports com.example.dbs_semestralka;
}