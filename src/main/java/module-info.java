module de.neuefische.studentdbfrontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires java.net.http;
            
                            
    opens de.neuefische.studentdbfrontend to javafx.fxml;
    opens de.neuefische.studentdbfrontend.model to com.fasterxml.jackson.databind;
    opens de.neuefische.studentdbfrontend.service to com.fasterxml.jackson.databind;

    exports de.neuefische.studentdbfrontend;
    exports de.neuefische.studentdbfrontend.model;
    exports de.neuefische.studentdbfrontend.service;
}