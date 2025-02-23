module com.souza.charles.graphicalapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.souza.charles.graphicalapp.controller to javafx.fxml;
    opens com.souza.charles.graphicalapp.model.entities to javafx.fxml;
    opens com.souza.charles.graphicalapp.view to javafx.fxml;

    exports com.souza.charles.graphicalapp.controller;
    exports com.souza.charles.graphicalapp.model.dao;
    exports com.souza.charles.graphicalapp.model.db;
    exports com.souza.charles.graphicalapp.model.entities;
    exports com.souza.charles.graphicalapp.model.exceptions;
    exports com.souza.charles.graphicalapp.model.services;
    exports com.souza.charles.graphicalapp.view;
}
