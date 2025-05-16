module com.example.dbs_semestralka {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;    // <— make sure Hibernate’s core jar is on your module path
    requires java.sql;

    exports com.example.dbs_semestralka;

    opens com.example.dbs_semestralka to javafx.fxml;

    opens com.example.dbs_semestralka.controllers to javafx.fxml;
}