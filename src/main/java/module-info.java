module com.example.nlrs_main {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    exports com.example.nlrs_main;
    opens com.example.nlrs_main to javafx.fxml;
}