module com.example.nlrs_main {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.nlrs_main to javafx.fxml;
    exports com.example.nlrs_main;
}